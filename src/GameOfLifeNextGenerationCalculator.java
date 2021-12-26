import java.util.ArrayList;
import java.util.List;

public class GameOfLifeNextGenerationCalculator {
    public boolean[][] calculate(boolean[][] currentGeneration) {
        List<Integer> currentNeighborsList = calculateNeighborsForEachCell(currentGeneration);
        int rowsQuantity = currentGeneration.length;
        int columnsQuantity = currentGeneration[0].length;
        boolean[][] nextGen = new boolean[rowsQuantity][columnsQuantity];
        for (int row = 0; row < rowsQuantity; row++) {
            for (int cln = 0; cln < columnsQuantity; cln++) {
                if (mightBeAlive(currentGeneration[row][cln],currentNeighborsList.get(row * columnsQuantity + cln))) {
                    nextGen[row][cln] = true;
                }
            }
        }
        return nextGen;
    }

    List<Integer> calculateNeighborsForEachCell(boolean[][] currentGeneration) {
        int rowsQuantity = currentGeneration.length;
        int columnsQuantity = currentGeneration[0].length;
        List<Integer> neighborsList = new ArrayList<>(rowsQuantity * columnsQuantity);
        for (int row = 0; row < rowsQuantity; row++) {
            for (int column = 0; column < columnsQuantity; column++) {
                int counter = 0;
                if (row - 1 >= 0 && column - 1 >= 0 && currentGeneration[row - 1][column - 1]) {
                    counter++;
                }
                if (row - 1 >= 0 && currentGeneration[row - 1][column]) {
                    counter++;
                }
                if (row - 1 >= 0 && column + 1 < columnsQuantity && currentGeneration[row - 1][column + 1]) {
                    counter++;
                }
                if (column - 1 >= 0 && currentGeneration[row][column - 1]) {
                    counter++;
                }
                if (column + 1 < columnsQuantity && currentGeneration[row][column + 1]) {
                    counter++;
                }
                if (row + 1 < rowsQuantity && column - 1 >= 0 && currentGeneration[row + 1][column - 1]) {
                    counter++;
                }
                if (row + 1 < rowsQuantity && currentGeneration[row + 1][column]) {
                    counter++;
                }
                if (row + 1 < rowsQuantity && column + 1 < columnsQuantity && currentGeneration[row + 1][column + 1]) {
                    counter++;
                }
                neighborsList.add(counter);
            }
        }
        return neighborsList;
    }

    boolean mightBeAlive(boolean cell, int neighborsQuantity) {
        if (cell && neighborsQuantity >= 2 && neighborsQuantity <= 3) {
            return true;
        } else return !cell && neighborsQuantity == 3;
    }
}
