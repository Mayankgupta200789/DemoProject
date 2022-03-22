package companies.microsoft.onsite.oops.elevator;

public interface ElevatorFloorScanner {


    boolean scan(int floor) throws InterruptedException;
}
