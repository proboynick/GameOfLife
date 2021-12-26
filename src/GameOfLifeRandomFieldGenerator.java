import java.util.Random;

public class GameOfLifeRandomFieldGenerator {
    Random random = new Random();

    boolean[][] generate(int rows, int columns) {
        boolean[][] randomField = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                randomField[i][j] = random.nextBoolean();
            }
        }
        return randomField;
    }
}
