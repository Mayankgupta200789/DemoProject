package companies.microsoft.onsite.oops.elevator;

public class MoveUp implements Move {

    private Elevator elevator;

    public MoveUp(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void move(int floor) {
        this.elevator.setCurrentFloor(floor);

    }
}
