package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        scan.nextLine();

        int[][] matrix = readMatrix(rows, scan);


        String[] input = scan.nextLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);

        int numberToSearch = wrongNumber(row, col, matrix);

        reformMatrix(matrix, numberToSearch);
    }

    private static void reformMatrix(int[][] matrix, int numberToSearch) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int sum = 0;
                if (matrix[row][col] == numberToSearch) {
                    if (row + 1 <= matrix.length-1) {
                        if (matrix[row + 1][col] != numberToSearch) {
                            sum += matrix[row + 1][col];
                        }
                    }
                    if (row - 1 >= 0) {
                        if (matrix[row - 1][col] != numberToSearch) {
                            sum += matrix[row - 1][col];
                        }
                    }
                    if (col + 1 <= matrix[row].length-1) {
                        if (matrix[row][col + 1] != numberToSearch) {
                            sum += matrix[row][col + 1];
                        }
                    }
                    if (col - 1 >=0) {
                        if (matrix[row][col - 1] != numberToSearch) {
                            sum += matrix[row][col - 1];
                        }
                    }
                    matrix[row][col]=sum;
                }
            }
        }
        print(matrix);
    }

    public static void print(int[][] matrix) {
        for (int[] line : matrix) {
            for (int element : line) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int wrongNumber(int row, int col, int[][] matrix) {
        return matrix[row][col];
    }

    public static int[][] readMatrix(int rows, Scanner scan) {
        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            int[] line = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = line;
        }
        return matrix;
    }
}
