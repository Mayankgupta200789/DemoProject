package companies.Convoy.logistics;

public class Truck extends Vehicle{

    private final static int capacityOfTruck = 100;

    public Truck(int id, String vehicleNo) {

        super(id,vehicleNo,capacityOfTruck);
    }
}
