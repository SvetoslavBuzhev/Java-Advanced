package MultidimensionalArrays;

import java.util.Scanner;

public class InterserctionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = Integer.parseInt(scan.nextLine());
        int cols = Integer.parseInt(scan.nextLine());

        char[][] firstMatrix = readMatrix(rows, cols, scan);
        char[][] secondMatrix = readMatrix(rows, cols, scan);

        char[][] intersectedMatrix = intersection(firstMatrix, secondMatrix);

        printElements(intersectedMatrix);
    }

    private static void printElements(char[][] intersectedMatrix) {
        for (int row = 0; row < intersectedMatrix.length; row++) {
            for (int col = 0; col < intersectedMatrix[row].length; col++) {
                System.out.print(intersectedMatrix[row][col]+" ");
            }
            System.out.println();
        }
    }

    private static char[][] intersection(char[][] firstMatrix, char[][] secondMatrix) {
        char[][] intersectedMatrix=new char[firstMatrix.length][firstMatrix[0].length];
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col]!=secondMatrix[row][col]){
                    intersectedMatrix[row][col]='*';
                }else {
                    intersectedMatrix[row][col]=firstMatrix[row][col];
                }
            }
        }return intersectedMatrix;
    }

    private static char[][] readMatrix(int rows, int cols, Scanner scan) {
        char[][] matrix=new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            char[] inputLine= (scan.nextLine().replaceAll(" ","")).toCharArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col]=inputLine[col];
            }
        }
        return matrix;
    }

}
