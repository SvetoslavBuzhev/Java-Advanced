package MultidimensionalArraysEx.FillTheMatrix;

import java.util.Arrays;
import java.util.Scanner;

public class _05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String[][] matrix = readMatrix(input[0], input[1], scan);

        String command = scan.nextLine();
        while (!command.equals("END")) {

            String[] commandSplit = command.split("\\s+");
            if (commandSplit[0].equals("swap")) {
                try {
                    if (commandSplit.length == 5) {
                        int n1 = Integer.parseInt(commandSplit[1]);
                        int n2 = Integer.parseInt(commandSplit[2]);
                        int n3 = Integer.parseInt(commandSplit[3]);
                        int n4 = Integer.parseInt(commandSplit[4]);
                        if (isValidd(n1, matrix.length) || isValidd(n2, matrix[0].length) ||
                                isValidd(n3, matrix.length) || isValidd(n4, matrix[0].length)) {
                            System.out.println("Invalid input!");
                            command=scan.nextLine();
                            continue;
                        }else {
                            printMatrix(matrixSwap(matrix, n1, n2, n3, n4));
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
            command = scan.nextLine();
        }
    }
    public static boolean isValidd(int n, int max){
        return n < 0 || n >= max;
    }
    public static void printMatrix(String[][] matrix) {
        for (String[] line : matrix) {
            for (String element : line) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static String[][] matrixSwap(String[][] matrix, int n1, int n2, int n3, int n4) {
        String temp = matrix[n1][n2];
        matrix[n1][n2] = matrix[n3][n4];
        matrix[n3][n4] = temp;
        return matrix;
    }

    private static String[][] readMatrix(int i, int i1, Scanner scan) {
        String[][] matrix = new String[i][i1];
        for (int row = 0; row < i; row++) {
            String[] input = scan.nextLine().split("\\s+");
            matrix[row] = input;
        }
        return matrix;
    }
}
