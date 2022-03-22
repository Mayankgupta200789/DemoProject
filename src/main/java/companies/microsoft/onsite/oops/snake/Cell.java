package companies.microsoft.onsite.oops.snake;

public class Cell {

    private int row;
    private int column;
    private CellType cellType;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.cellType = CellType.EMPTY;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }
}
