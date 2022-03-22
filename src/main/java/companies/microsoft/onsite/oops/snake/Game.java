package companies.microsoft.onsite.oops.snake;

public class Game {

    public static final int DIRECTION_NONE = 0,DIRECTION_RIGHT = 1,
    DIRECTION_LEFT = -1, DIRECTION_UP = 2, DIRECTION_DOWN = -2;

    private Snake snake;
    private Board board;
    private int direction;
    private boolean gameOver;

    public Game(Snake snake, Board board) {
        this.snake = snake;
        this.board = board;
    }

    public void update() {
        if(!gameOver) {
            if(direction != DIRECTION_NONE ){
                Cell nextCell = getNextCell(snake.getHead());

                if(snake.checkCrash(nextCell)) {
                    setDirection(DIRECTION_NONE);
                    gameOver  = true;
                } else {
                    snake.move(nextCell);
                    if(nextCell.getCellType() == CellType.FOOD) {
                        snake.grow();
                        board.generate();
                    }
                }
            }
        }
    }

    public Cell getNextCell(Cell currentPosition) {

        int row = currentPosition.getRow();
        int column = currentPosition.getColumn();

        if(direction == DIRECTION_RIGHT){
            column++;
        } else if (direction == DIRECTION_LEFT ){
            column--;
        } else if( direction == DIRECTION_UP) {
            row++;
        } else if( direction == DIRECTION_DOWN ){
            row--;
        }
        return board.getCells()[row][column];
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
