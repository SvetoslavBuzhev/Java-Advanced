package MultidimensionalArraysEx.FillTheMatrix;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("[ ,]+");
        int matrixSize = Integer.parseInt(input[0]);

        int[][] matrix = new int[matrixSize][matrixSize];

        if (input[1].equals("A")) {
            matrix = firstPattern(matrixSize);
        } else if (input[1].equals("B")) {
            matrix = secondPattern(matrixSize);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] line:matrix) {
            for (int number:line) {
                System.out.print(number+ " ");
            }
            System.out.println();
        }
    }

    private static int[][] secondPattern(int matrixSize) {
        int counter = 1;
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int col = 0; col < matrixSize; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrixSize; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            } else {
                for (int row = matrixSize-1; row >= 0; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }

            }
        }

        return matrix;
    }

    private static int[][] firstPattern(int matrixSize) {
        int counter = 1;
        int[][] matrix = new int[matrixSize][matrixSize];
        for (int col = 0; col < matrixSize; col++) {
            for (int row = 0; row < matrixSize; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
        return matrix;
    }
}
