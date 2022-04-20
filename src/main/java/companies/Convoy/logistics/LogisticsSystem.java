package companies.Convoy.logistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogisticsSystem {

    private List<Order> orders;
    private List<Vehicle> vehicles;
    private List<User> users;
    private Map<Integer,Location> orderLocations = new HashMap<>();

    public LogisticsSystem(List<Order> orders, List<Vehicle> vehicles, List<User> users) {
        this.orders = orders;
        this.vehicles = vehicles;
        this.users = users;
    }


    public void takeOrder(Order order) {
        System.out.println("Adding an order to the system");
        orders.add(order);
    }

    public void processOrder(Order order) {
        System.out.println("Processing an order of the system");
    }

    public Location trackOrder(int orderId) {
        System.out.println("Tracking an order of the system");
        return orderLocations.get(orderId);
    }

    public void cancelOrder(Order order) {
        System.out.println("Going to cancel an order of the system");
    }

    public void registerNewUser(User user)
    {
        System.out.println("Registering a new user to the system");
        users.add(user);
    }
}
