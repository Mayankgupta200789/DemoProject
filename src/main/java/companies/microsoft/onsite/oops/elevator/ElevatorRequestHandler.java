package companies.microsoft.onsite.oops.elevator;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class ElevatorRequestHandler {




    private static final Integer GROUND_FLOOR = 1;
    private static final Integer TOP_FLOOR = 200;



    private ElevatorMover elevatorMover;

    public ElevatorRequestHandler(ElevatorMover elevatorMover) {
        this.elevatorMover = elevatorMover;
    }

    public void handle() {

        Queue<Integer> upPriorityQueue = ElevatorCache.getUpPriorityQueue();
        Queue<Integer> downPriorityQueue = ElevatorCache.getDownPriorityQueue();
        List<Integer> availableLists = ElevatorCache.getAvailableLists();
        Integer upFloor = upPriorityQueue.peek();
        Integer downFloor = downPriorityQueue.peek();

//        if(upFloor > downFloor) {
//            while(!downPriorityQueue.isEmpty() || elevatorMover.getCurrentFloor() != GROUND_FLOOR) {
//                Integer floor = downPriorityQueue.poll();
//                elevatorMover.move(floor,Direction.DOWN);
//            }
//        }
        if (elevatorMover.getCurrentFloor() != GROUND_FLOOR) {
            if (upFloor > downFloor) {
                while (!downPriorityQueue.isEmpty() || elevatorMover.getCurrentFloor() != GROUND_FLOOR) {
                    Integer floor = downPriorityQueue.poll();
                    elevatorMover.move(floor, Direction.DOWN);
                    availableLists.add(floor);
                }
            }
        } else if (elevatorMover.getCurrentFloor() != TOP_FLOOR) {
            // Serve all up requests first before serving down
            if (downFloor > upFloor) {
                while (!upPriorityQueue.isEmpty() || elevatorMover.getCurrentFloor() != TOP_FLOOR) {
                    Integer floor = upPriorityQueue.poll();
                    elevatorMover.move(floor, Direction.UP);
                    availableLists.add(floor);
                }
            }
        }

        if(upPriorityQueue.isEmpty() && downPriorityQueue.isEmpty()){
            elevatorMover.stop();
        }

    }
}
