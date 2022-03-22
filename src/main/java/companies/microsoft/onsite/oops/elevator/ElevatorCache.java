package companies.microsoft.onsite.oops.elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class ElevatorCache {

    private static Queue<Integer> upPriorityQueue = new PriorityBlockingQueue<>();
    private static Queue<Integer> downPriorityQueue = new PriorityBlockingQueue<>();
    private static List<Integer> availableLists = new ArrayList<>();

    public static Queue<Integer> getUpPriorityQueue() {
        return upPriorityQueue;
    }

    public static void setUpPriorityQueue(Queue<Integer> upPriorityQueue) {
        ElevatorCache.upPriorityQueue = upPriorityQueue;
    }

    public static Queue<Integer> getDownPriorityQueue() {
        return downPriorityQueue;
    }

    public static void setDownPriorityQueue(Queue<Integer> downPriorityQueue) {
        ElevatorCache.downPriorityQueue = downPriorityQueue;
    }

    public static List<Integer> getAvailableLists() {
        return availableLists;
    }

    public static void setAvailableLists(List<Integer> availableLists) {
        ElevatorCache.availableLists = availableLists;
    }
}
