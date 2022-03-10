package companies.microsoft.onsite.oops.elevator;

public class MoveDown implements Move {


    private Elevator elevator;

    public MoveDown(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void move(int floor) {
        this.elevator.setCurrentFloor(floor);
    }
}
