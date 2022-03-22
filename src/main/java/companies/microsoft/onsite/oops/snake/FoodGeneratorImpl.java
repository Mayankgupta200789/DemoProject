package companies.microsoft.onsite.oops.snake;

public class FoodGeneratorImpl implements FoodGenerator {


    @Override
    public void generate(Cell[][] cells) {

        int rowRandom = (int)Math.random() * 30;
        int colRandom = (int)Math.random() * 30;

        if(cells[rowRandom][colRandom].getCellType() != CellType.SNAKE_NODE) {
            cells[rowRandom][colRandom].setCellType(CellType.FOOD);
        }

    }
}
