package MultidimensionalArraysEx.FillTheMatrix;

import java.util.Arrays;
import java.util.Scanner;

public class _02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        String[][] matrix = new String[input[0]][input[1]];
        matrix = putInPalindromes(input[0],input[1]);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] line:matrix) {
            for (String element:line ){
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }

    private static String[][] putInPalindromes(int rows, int column) {

        String[][] palindromeMatrix=new String[rows][column];
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < column; col++) {
                char currentCh=(char)(row+'a');
                char middle=(char)(currentCh+col);
                palindromeMatrix[row][col]=String.valueOf(currentCh)+middle+currentCh;

            }
        }
        return palindromeMatrix;
    }
}
