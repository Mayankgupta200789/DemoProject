package companies.microsoft.onsite.oops.elevator;

public class Elevator {

    private int id;
    private Direction currentDirection;
    private int moveToFloor;

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    private int currentFloor;

    public int getMoveToFloor() {
        return moveToFloor;
    }

    public void setMoveToFloor(int moveToFloor) {
        this.moveToFloor = moveToFloor;
    }

    private Button button;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
