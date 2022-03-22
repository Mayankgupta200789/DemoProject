package companies.microsoft.onsite.oops.elevator;

public class ElevatorMoverImpl implements ElevatorMover {


    private Elevator elevator;

    public ElevatorMoverImpl(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void move(int floor,Direction direction) {
        elevator.setCurrentDirection(direction);
        elevator.setCurrentFloor(floor);

    }

    @Override
    public void stop() {

    }

    @Override
    public int getCurrentFloor() {
        return elevator.getCurrentFloor();
    }
}
