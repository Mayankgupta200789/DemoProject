package companies.microsoft.onsite.oops.elevator;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ElevatorFloorScannerImpl implements ElevatorFloorScanner {



    private Map<Integer,Boolean> floorRequest = new HashMap<>();

    private PriorityQueue<Integer> queue = new PriorityQueue<>();

    private ElevatorMover elevatorMover;

    public ElevatorFloorScannerImpl(ElevatorMover elevatorMover) {
        this.elevatorMover = elevatorMover;
    }

    // Lets say through scan, an elevator know which floor
    // the elevator is
    @Override
    public boolean scan(int floor) throws InterruptedException {
        if(floorRequest.get(floor)) {
            elevatorMover.stop();
            floorRequest.put(floor,false);
        }
        return false;
    }
}
