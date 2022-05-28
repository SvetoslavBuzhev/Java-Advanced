package TestExerciseArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _07CrossFire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] size = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = size[0];
        int cols = size[1];
        //понеже работата с List е по-лесна използваме лист като създаваме list от integers в друг лист;
        // Лист пълен с lists l1,l2,l3,l4,l5
        // l1   1  2  3  4  5
        // l2   6  7  8  9  10
        // l3   11 12 13 14 15
        // l4   16 17 18 19 20
        // l5   21 22 23 24 25
        List<List<Integer>> matrix = new ArrayList<>();


        System.out.println();
        bombMatrix(scan, matrix, rows, cols);
    }

    private static void bombMatrix(Scanner scan, List<List<Integer>> matrix, int rows, int cols) {
        fillMatrix(matrix, rows, cols);
        String input = scan.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            int[] bombCoordinates = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int bombRow = bombCoordinates[0];
            int bombCol = bombCoordinates[1];
            int bombRadius = bombCoordinates[2];
            bombRows(matrix, bombRow, bombRadius, bombCol);
            bombCols(matrix, bombRow, bombRadius, bombCol);
            matrix.removeIf(List::isEmpty);
            input = scan.nextLine();
        }
        printMatrix(matrix);
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> currentList : matrix) {
            for (int currentInt : currentList) {
                System.out.print(currentInt + " ");
            }
            System.out.println();
        }
    }


    private static void bombCols(List<List<Integer>> matrix, int bombRow, int bombRadius, int bombCol) {
        for (int col = bombCol + bombRadius; col >= bombCol - bombRadius; col--) {
            if (isValidCol(col, matrix, bombRow)) {
                matrix.get(bombRow).remove(col);
            }
        }
    }

    private static boolean isValidCol(int col, List<List<Integer>> matrix, int bombRow) {
        return bombRow >= 0 && bombRow < matrix.size() && col >= 0 && col < matrix.get(bombRow).size();
    }

    private static void bombRows(List<List<Integer>> matrix, int bombRow, int bombRadius, int bombCols) {
        for (int row = bombRow - bombRadius; row < bombRow + bombRadius; row++) {
            if (isValidRow(row, matrix, bombCols,bombRow)) {
                matrix.get(row).remove(bombCols);
            }
        }
    }

    private static boolean isValidRow(int row, List<List<Integer>> matrix, int bombCols,int bombRow) {
        return row >= 0 && row < matrix.size() && bombCols >= 0 && bombCols < matrix.get(row).size() && row != bombRow;
    }

    private static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int counter = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(counter);
                counter++;
            }
        }
    }
}
