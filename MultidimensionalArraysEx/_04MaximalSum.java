package MultidimensionalArraysEx.FillTheMatrix;

import java.util.Arrays;
import java.util.Scanner;

public class _04MaximalSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = input[0];
        int cols = input[1];

        int[][] matrix = readMatrix(scan, rows, cols);

      MatrixWithBiggestSum(matrix);
    }

    private static void MatrixWithBiggestSum(int[][] matrix) {
        int[][] matrix3x3 = new int[3][4];
        int biggestSum=Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length-2; row++) {
            for (int col = 0; col < matrix[row].length-2; col++) {
                int[][] currentMatrix=new int[3][3];
                currentMatrix[0][0]=matrix[row][col];
                currentMatrix[1][0]=matrix[row+1][col];
                currentMatrix[2][0]=matrix[row+2][col];
                currentMatrix[0][1]=matrix[row][col+1];
                currentMatrix[0][2]=matrix[row][col+2];
                currentMatrix[1][1]=matrix[row+1][col+1];
                currentMatrix[2][2]=matrix[row+2][col+2];
                currentMatrix[1][2]=matrix[row+1][col+2];
                currentMatrix[2][1]=matrix[row+2][col+1];
                if (getValue(currentMatrix)>biggestSum){
                    matrix3x3=currentMatrix;
                    biggestSum=getValue(currentMatrix);
                }
            }
        }
        System.out.println("Sum = "+biggestSum);
        printMatrix(matrix3x3);
    }

    public static void printMatrix (int[][] matrix3x3){
        for (int[] line:matrix3x3) {
            for (int element:line) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public static int getValue(int[][] matrix){
        int sum=0;
        for (int[] line:matrix) {
            for (int element:line) {
                sum+=element;
            }
        }
        return sum;
    }
    public static int[][] readMatrix(Scanner scan, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = input;
        }
        return matrix;
    }
}
