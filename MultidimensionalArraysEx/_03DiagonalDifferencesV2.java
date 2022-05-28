package MultidimensionalArraysEx.FillTheMatrix;


import java.util.Arrays;
import java.util.Scanner;

public class _03DiagonalDifferencesV2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[size][size];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        System.out.println(Math.abs(diagonal(matrix) - diagonal2(matrix)));
    }

    public static int diagonal(int[][] matrix) {
        int sum1 = 0;
        int row = 0;
        int col = 0;
        while (row < matrix.length && col < matrix[0].length) {
            sum1 += matrix[row][col];
            row++;
            col++;
        }
        return sum1;
    }

    public static int diagonal2(int[][] matrix) {
        int sum = 0;
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            sum += matrix[row][col];
            row--;
            col++;
        }
        return sum;
    }
}

