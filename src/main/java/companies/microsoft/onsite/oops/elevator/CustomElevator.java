package companies.microsoft.onsite.oops.elevator;

import java.util.Queue;
import java.util.Scanner;

public class CustomElevator {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        int currentFloor = 1;
        do {
            System.out.println("Enter destination floor");
            System.out.println("Door is closing");

            int destinationFloor = scanner.nextInt();

            int i ;

            if(destinationFloor > currentFloor) {
                for(i  = currentFloor; i <= destinationFloor;i++ )
                {
                    System.out.println("Going up... " + i);
                    Thread.sleep(1000);
                }
                i--;
            } else {
                for(i = currentFloor;i >= destinationFloor;i--) {
                    System.out.println("Going down... " + i );
                    Thread.sleep(1000);
                }
                i++;
            }
            System.out.println("Hello, opening the door, we are on " + i);
            currentFloor = destinationFloor;
        }while(true);
    }
}
