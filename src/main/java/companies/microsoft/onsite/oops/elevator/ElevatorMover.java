package companies.microsoft.onsite.oops.elevator;

public interface ElevatorMover {


    void move(int floor,Direction direction);
    void stop();
    int getCurrentFloor();
}
