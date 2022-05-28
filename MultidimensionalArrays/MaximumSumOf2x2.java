package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("[ ,]+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = readMatrix(rows, cols, scan);

        printMatrixAndSum(matrix);
    }

    private static void printMatrixAndSum(int[][] matrix) {
        int[][] MatrixWithBiggestSum = new int[2][2];
        int MatrixBiggestSum = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int[][] currentMatrix = new int[2][2];
                currentMatrix[0][0] = matrix[row][col];
                currentMatrix[0][1] = matrix[row][col + 1];
                currentMatrix[1][0] = matrix[row + 1][col];
                currentMatrix[1][1] = matrix[row + 1][col + 1];
                int sum=sumOfMatrix(currentMatrix);
                if (sum > MatrixBiggestSum) {
                    MatrixBiggestSum = sum;
                    MatrixWithBiggestSum = currentMatrix;
                }
            }
        }
        print(MatrixWithBiggestSum);
        System.out.println(MatrixBiggestSum);
    }
    public  static void print(int[][] MatrixWithBiggestSum){
        System.out.print(MatrixWithBiggestSum[0][0]+" ");
        System.out.print(MatrixWithBiggestSum[0][1]+" ");
        System.out.println();
        System.out.print(MatrixWithBiggestSum[1][0]+" ");
        System.out.print(MatrixWithBiggestSum[1][1]+" ");
        System.out.println();
    }
    private static int sumOfMatrix(int[][] currentMatrix) {
        return currentMatrix[0][0] + currentMatrix[0][1] + currentMatrix[1][0] + currentMatrix[1][1];
    }


    private static int[][] readMatrix(int rows, int cols, Scanner scan) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] inputLine = Arrays.stream(scan.nextLine().split("[, ]+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = inputLine;
        }
        return matrix;
    }
}
