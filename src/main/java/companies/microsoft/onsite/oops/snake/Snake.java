package companies.microsoft.onsite.oops.snake;

import java.util.LinkedList;
import java.util.List;

public class Snake {

    private LinkedList<Cell> snakePartList = new LinkedList<>();
    private Cell head;



    public Snake(Cell initPos) {
       head = initPos;
       snakePartList.add(initPos);
       head.setCellType(CellType.SNAKE_NODE);
    }

    public void grow() {
        snakePartList.add(head);
    }

    public void move(Cell nextCell) {

        Cell tail = snakePartList.removeLast();
        tail.setCellType(CellType.EMPTY);

        head = nextCell;
        head.setCellType(CellType.SNAKE_NODE);
        snakePartList.addFirst(head);
    }

    public boolean checkCrash(Cell nextCell) {
        for(Cell cell : snakePartList) {
            if(cell == nextCell ){
                return true;
            }
        }
        return false;
    }

    public LinkedList<Cell> getSnakePartList() {
        return snakePartList;
    }

    public void setSnakePartList(LinkedList<Cell> snakePartList) {
        this.snakePartList = snakePartList;
    }

    public Cell getHead() {
        return head;
    }

    public void setHead(Cell head) {
        this.head = head;
    }
}
