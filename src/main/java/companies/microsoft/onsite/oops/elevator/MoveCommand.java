package companies.microsoft.onsite.oops.elevator;

public class MoveCommand implements Command {

    private Move move;

    public MoveCommand(Move move) {
        this.move = move;
    }

    @Override
    public void execute(int option) {

        move.move(option);

    }
}
