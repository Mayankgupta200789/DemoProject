package companies.microsoft.onsite.oops.parkinglot;

import java.util.Comparator;
import java.util.Map;

public class EntraceParkingSpotComparator implements Comparator<ParkingSpot> {


    private Entrance entranceType;

    public EntraceParkingSpotComparator(Entrance entranceType) {
        this.entranceType = entranceType;
    }

    @Override
    public int compare(ParkingSpot o1, ParkingSpot o2) {
        Map<Entrance, Integer> firstDistanceMap = o1.getDistanceMap();
        Map<Entrance, Integer> secondDistanecMap = o2.getDistanceMap();

        Integer distanceFromFirstEntrance = firstDistanceMap.get(entranceType);
        Integer distanceFromSecondEntrance = secondDistanecMap.get(entranceType);
        return distanceFromFirstEntrance - distanceFromSecondEntrance;
    }
}
