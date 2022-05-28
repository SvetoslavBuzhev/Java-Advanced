package MultidimensionalArraysEx.FillTheMatrix;

import java.util.Arrays;
import java.util.Scanner;


public class _03DiagonalDifferences {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int size=Integer.parseInt(scan.nextLine());
        int[][] matrix= readMatrix(size,scan);
        int firstDiagonal=getDiagonalOne(matrix);
        int secondDiagonal=getDiagonalTwo(matrix,size);

        System.out.println(DiagonalDifference(firstDiagonal,secondDiagonal));
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
    private static int DiagonalDifference(int firstDiagonal, int secondDiagonal) {
        return Math.abs(firstDiagonal-secondDiagonal);

    }

    private static int getDiagonalTwo(int[][] matrix, int size) {
        int sum=0;
        for (int i = matrix.length-1; i >=0; i--) {
            sum+=matrix[i][matrix.length-1-i];
        }
        return sum;
    }

    private static int getDiagonalOne(int[][] matrix) {
        int sum=0;
        for (int i = 0; i < matrix.length; i++) {
            sum+=matrix[i][i];
        }
        return sum;
    }
}
