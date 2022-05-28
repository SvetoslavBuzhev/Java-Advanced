package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfMatrices {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String[] input=scan.nextLine().split("[ ,]+");

        int rows=Integer.parseInt(input[0]);
        int cols=Integer.parseInt(input[1]);

        int[][]matrix=readMatrix(rows,cols,scan);

        int sumOfMatrixNumbers=sumMatrix(matrix);

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sumOfMatrixNumbers);
    }

    private static int sumMatrix(int[][] matrix) {
        int sum = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }
        return sum;
    }

    private static int[][] readMatrix(int rows, int cols, Scanner scan) {
        int[][] matrix=new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] inputLine= Arrays.stream(scan.nextLine().split("[, ]+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row]=inputLine;
        }
        return matrix;
    }


}
