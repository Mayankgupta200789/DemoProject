package companies.Convoy.logistics;

public class Vehicle {


    private int id;
    private String vehicleNo;
    private int capacity;
    private Location currentPosition;
    private VehicleStatus vehicleStatus;

    public Vehicle(int id, String vehicleNo, int capacity) {
        this.id = id;
        this.vehicleNo = vehicleNo;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Location getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Location currentPosition) {
        this.currentPosition = currentPosition;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
}
