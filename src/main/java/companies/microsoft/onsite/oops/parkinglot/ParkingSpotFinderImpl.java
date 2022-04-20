package companies.microsoft.onsite.oops.parkinglot;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class ParkingSpotFinderImpl implements ParkingSpotFinder {

    static {

        HashMap<Entrance, Integer> entranceIntegerHashMap = new HashMap<>();
        entranceIntegerHashMap.put(Entrance.FIRST,4);
        entranceIntegerHashMap.put(Entrance.SECOND,10);
        entranceIntegerHashMap.put(Entrance.THIRD,12);
        entranceIntegerHashMap.put(Entrance.FOURTH,13);
        HashMap<Entrance, Integer> entranceIntegerHashMap2 = new HashMap<>();
        entranceIntegerHashMap2.put(Entrance.FIRST,2);
        entranceIntegerHashMap2.put(Entrance.SECOND,11);
        entranceIntegerHashMap2.put(Entrance.THIRD,16);
        entranceIntegerHashMap2.put(Entrance.FOURTH,12);
        ParkingSpot parkingSpot = new ParkingSpot("123", entranceIntegerHashMap, false);
        ParkingSpot parkingSpot2 = new ParkingSpot("124", entranceIntegerHashMap, true);
        ParkingSpotAvailableCache.availableParkingSpotQueue1 = new PriorityQueue<>(new EntraceParkingSpotComparator(Entrance.FIRST));
        ParkingSpotAvailableCache.availableParkingSpotQueue1.add(parkingSpot);
        ParkingSpotAvailableCache.availableParkingSpotQueue1.add(parkingSpot2);
        ParkingSpotAvailableCache.availableParkingSpotQueue2 = new PriorityQueue<>(new EntraceParkingSpotComparator(Entrance.SECOND));
        ParkingSpotAvailableCache.availableParkingSpotQueue2.add(parkingSpot);
        ParkingSpotAvailableCache.availableParkingSpotQueue2.add(parkingSpot2);
        ParkingSpotAvailableCache.availableParkingSpotQueue3 = new PriorityQueue<>(new EntraceParkingSpotComparator(Entrance.THIRD));
        ParkingSpotAvailableCache.availableParkingSpotQueue3.add(parkingSpot);
        ParkingSpotAvailableCache.availableParkingSpotQueue3.add(parkingSpot2);
        ParkingSpotAvailableCache.availableParkingSpotQueue4 = new PriorityQueue<>(new EntraceParkingSpotComparator(Entrance.FOURTH));
        ParkingSpotAvailableCache.availableParkingSpotQueue4.add(parkingSpot);
        ParkingSpotAvailableCache.availableParkingSpotQueue4.add(parkingSpot2);
    }

    @Override
    public ParkingSpot find(Entrance entrance) {

        if(entrance.equals(Entrance.FIRST)) {
            return !ParkingSpotAvailableCache.availableParkingSpotQueue1.isEmpty()
                    ? ParkingSpotAvailableCache.availableParkingSpotQueue1.poll() : null;
        } else if(entrance.equals(Entrance.SECOND)) {
            return !ParkingSpotAvailableCache.availableParkingSpotQueue2.isEmpty()
                    ? ParkingSpotAvailableCache.availableParkingSpotQueue2.poll() : null;
        }else if(entrance.equals(Entrance.THIRD)) {
            return !ParkingSpotAvailableCache.availableParkingSpotQueue3.isEmpty()
                    ? ParkingSpotAvailableCache.availableParkingSpotQueue3.poll() : null;
        }else if(entrance.equals(Entrance.FOURTH)) {
            return !ParkingSpotAvailableCache.availableParkingSpotQueue4.isEmpty()
                    ? ParkingSpotAvailableCache.availableParkingSpotQueue4.poll() : null;
        }
        return null;
    }
}
