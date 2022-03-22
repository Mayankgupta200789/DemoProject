package companies.microsoft.onsite.oops.snake;

public class Board {

    private static final int MAX_SIZE = 30;
    private Cell[][] cells = new Cell[MAX_SIZE][MAX_SIZE];
    private FoodGenerator foodGenerator;

    public Board(int rowCount,int columnCount) {
        for(int i = 0 ; i < rowCount; i++ ) {
            for(int j = 0 ; j < columnCount;j++ ) {
                cells[i][j] = new Cell(i,j);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public void generate() {
        foodGenerator.generate(cells);
    }



}
