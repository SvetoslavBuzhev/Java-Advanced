package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int[][] firstMatrix=matrix(scan);
        int[][] secondMatrix=matrix(scan);

       boolean isEqual=areEqual(firstMatrix,secondMatrix);

       String output= isEqual ? "equal" : "not equal";
       System.out.println(output);
    }
    public static boolean areEqual(int[][] matrixOne,int[][] matrixTwo){
        if (matrixOne.length!=matrixTwo.length){
            return false;
        }
        for (int row = 0; row < matrixOne.length; row++) {
            int[] firstArray=matrixOne[row];
            int[] secondArray=matrixTwo[row];
            for (int col = 0; col <firstArray.length; col++) {
                if (matrixOne[row].length!=matrixTwo[row].length){
                    return false;
                }
                int firstNumber=firstArray[col];
                int secondNumber=secondArray[col];

                if (firstNumber!=secondNumber){
                    return false;
                }
            }
        }
        return true;
    }
    public static int[][] matrix(Scanner scan){
        String[] input= scan.nextLine().split("\\s+");

        int rows=Integer.parseInt(input[0]);
        int cols=Integer.parseInt(input[1]);

        int[][] matrix=new int[rows][cols];

        for (int row = 0;row<rows;row++){
            int[] intInput= Arrays.stream(scan.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col]=intInput[col];
            }
        }
        return matrix;
    }
}
