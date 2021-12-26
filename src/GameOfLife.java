import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GameOfLife {
    private GameOfLifeConsoleUI consoleUI = new GameOfLifeConsoleUI();
    private GameOfLifeRandomFieldGenerator generator = new GameOfLifeRandomFieldGenerator();
    private GameOfLifeNextGenerationCalculator calculator = new GameOfLifeNextGenerationCalculator();

    public static void main(String[] args) throws IOException, InterruptedException {
        GameOfLife game = new GameOfLife();
        game.run();
    }

    public void run() throws IOException, InterruptedException {
        boolean[][] field = generator.generate(10, 10);
        while(true) {
            consoleUI.show(field);
            sleepForSeconds(1000);
            field = calculator.calculate(field);
        }
    }

    private void sleepForSeconds(int seconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            System.out.println("Exception occurred!");
            System.exit(1);
        }
    }
}
