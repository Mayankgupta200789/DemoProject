package companies.microsoft.onsite.oops.parkinglot;

import java.util.Map;

public class ParkingSpot {

    private String id;
    private Map<Entrance,Integer> distanceMap;
    private boolean isAvailable;

    public ParkingSpot(String id, Map<Entrance, Integer> distanceMap, boolean isAvailable) {
        this.id = id;
        this.distanceMap = distanceMap;
        this.isAvailable = isAvailable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<Entrance, Integer> getDistanceMap() {
        return distanceMap;
    }

    public void setDistanceMap(Map<Entrance, Integer> distanceMap) {
        this.distanceMap = distanceMap;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
