package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix=new int[rows][cols];

        for (int row = 0; row <rows; row++) {
            int[] inputOfNumbers = Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col]=inputOfNumbers[col];
            }
        }
        int numberToCheck=Integer.parseInt(scan.nextLine());
        if (isFound(matrix,numberToCheck)){
            rowAndColumn(matrix,numberToCheck);
        }else {
            System.out.println("not found");
        }
    }

    private static void rowAndColumn(int[][] matrix, int numberToCheck) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (numberToCheck==matrix[i][j]){
                    System.out.println(i + " " + j);
                }
            }
        }
    }

    private static boolean isFound(int[][] matrix, int numberToCheck) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (numberToCheck==matrix[i][j]){
                    return true;
                }
            }
        }return false;
    }
}
