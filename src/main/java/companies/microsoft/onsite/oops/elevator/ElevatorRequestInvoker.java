package companies.microsoft.onsite.oops.elevator;

import java.util.PriorityQueue;
import java.util.Queue;

public class ElevatorRequestInvoker {


    private Queue<OutsideElevatorRequest> elevatorRequestQueue = new PriorityQueue<>();

    public ElevatorRequestInvoker(Queue<OutsideElevatorRequest> elevatorRequestQueue) {
        this.elevatorRequestQueue = elevatorRequestQueue;
    }


}
