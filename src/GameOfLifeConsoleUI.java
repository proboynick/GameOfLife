import java.io.IOException;

public class GameOfLifeConsoleUI {
    public void show(boolean[][] field) throws IOException, InterruptedException {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j]) {
                    System.out.print("0");
                } else {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
    }
}
