package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsofSquareMatrix {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int size= scan.nextInt();

        scan.nextLine();

        int[][] matrix=readMatrix(size,size,scan);

        int[][] diagonals=diagonalsRead(matrix,size);

        print(diagonals);
    }
    public static void print(int[][] diagonals){
        for (int[] line:diagonals) {
            for (int element:line){
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }
    private static int[][] diagonalsRead(int[][] matrix,int size) {
        int[][] diagonals=new int[2][size];
        int counter=0;
        for (int i = 0; i < size; i++) {
            diagonals[0][i]=matrix[i][i];
        }
        for (int i = size; i > 0; i--) {
            diagonals[1][size-1-i+1]=matrix[i-1][counter++];
        }
        return diagonals;
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
