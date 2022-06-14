package exam13Aprim;

import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        String[][] matrix = new String[size][size];
        fillTheMatrix(matrix, scan);
        int[] position = getRow(matrix);
        int ofRow = position[0];
        int ofCol = position[1];
        int[] positionOfSecondM = getPosition(matrix);
        int costOfSwords = 0;
        while (costOfSwords < 65 && ofRow >= 0 && ofRow < matrix.length && ofCol >= 0 && ofCol < matrix[0].length) {
            String command = scan.nextLine();
            int currentCost = 0;
            switch (command) {
                case "left":
                    ofCol -= 1;
                    if (!(ofCol >= 0)) {
                        matrix[ofRow][ofCol + 1] = "-";
                        break;
                    }
                    try {
                        currentCost += Integer.parseInt(matrix[ofRow][ofCol]);
                    } catch (Exception ignored) {
                    }
                    if (matrix[ofRow][ofCol].equals("M")) {
                        matrix[ofRow][ofCol + 1] = "-";
                        teleport(matrix, ofRow, ofCol, positionOfSecondM);
                        position = getRow(matrix);
                        ofCol = position[1];
                        ofRow = position[0];
                        break;
                    }
                    matrix[ofRow][ofCol + 1] = "-";
                    matrix[ofRow][ofCol] = "A";
                    break;
                case "right":

                    ofCol += 1;
                    if (!( ofCol < matrix[0].length)) {
                        matrix[ofRow][ofCol - 1] = "-";
                        break;
                    }
                    try {
                        currentCost += Integer.parseInt(matrix[ofRow][ofCol]);
                    } catch (Exception ignored) {
                    }
                    if (matrix[ofRow][ofCol].equals("M")) {
                        matrix[ofRow][ofCol - 1] = "-";
                        teleport(matrix, ofRow, ofCol, positionOfSecondM);
                        position = getRow(matrix);
                        ofCol = position[1];
                        ofRow = position[0];
                        break;
                    }
                    matrix[ofRow][ofCol - 1] = "-";
                    matrix[ofRow][ofCol] = "A";
                    break;
                case "up":
                    ofRow -= 1;
                    if (!(ofRow >= 0 )) {
                        matrix[ofRow + 1][ofCol] = "-";
                        break;
                    }
                    try {
                        currentCost += Integer.parseInt(matrix[ofRow][ofCol]);
                    } catch (Exception ignored) {
                    }
                    if (matrix[ofRow][ofCol].equals("M")) {
                        matrix[ofRow + 1][ofCol] = "-";
                        teleport(matrix, ofRow, ofCol, positionOfSecondM);
                        position = getRow(matrix);
                        ofCol = position[1];
                        ofRow = position[0];
                        break;
                    }
                    matrix[ofRow + 1][ofCol] = "-";
                    matrix[ofRow][ofCol] = "A";
                    break;
                case "down":
                    ofRow += 1;
                    if (!(ofRow < matrix.length )) {
                        matrix[ofRow - 1][ofCol] = "-";
                        break;
                    }
                    try {
                        currentCost += Integer.parseInt(matrix[ofRow][ofCol]);
                    } catch (Exception ignored) {
                    }
                    if (matrix[ofRow][ofCol].equals("M")) {
                        matrix[ofRow - 1][ofCol] = "-";
                        teleport(matrix, ofRow, ofCol, positionOfSecondM);
                        position = getRow(matrix);
                        ofCol = position[1];
                        ofRow = position[0];
                        break;
                    }
                    matrix[ofRow - 1][ofCol] = "-";
                    matrix[ofRow][ofCol] = "A";
            }
            costOfSwords += currentCost;
        }
        print(costOfSwords,matrix);
    }
    private static void print(int costOfSwords, String[][] matrix) {
        if (costOfSwords>65){
            System.out.println("Very nice swords, I will come back for more!");
            System.out.println("The king paid " +costOfSwords + " gold coins.");
        }else {
            System.out.println("I do not need more swords!");
            System.out.println("The king paid " + costOfSwords+ " gold coins.");
        }
        printMatrix(matrix);
    }
    private static void printMatrix(String[][] matrix){
        for (String[] row:matrix) {
            for (String symbol:row) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
    private static void teleport(String[][] matrix, int ofRow, int ofCol, int[] positionOfSecondM) {
        matrix[ofRow][ofCol] = "-";
        ofRow = positionOfSecondM[0];
        ofCol = positionOfSecondM[1];
        matrix[ofRow][ofCol] = "A";
    }
    private static int[] getPosition(String[][] matrix) {
        int countOfM = 0;
        int[] position = new int[2];
        if (anyM(matrix)) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j].equals("M")) {
                        countOfM++;
                    }
                    if (countOfM == 2) {
                        position[0] = i;
                        position[1] = j;
                        return position;
                    }
                }
            }

        }
        return null;
    }
    private static boolean anyM(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("M")) {
                    return true;
                }
            }
        }
        return false;
    }
    private static int[] getRow(String[][] matrix) {
        int[] position = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String currentPosition = matrix[row][col];
                if (currentPosition.equals("A")) {
                    position[0] = row;
                    position[1] = col;
                }
            }
        }
        return position;
    }
    private static void fillTheMatrix(String[][] matrix, Scanner scan) {
        for (int i = 0; i < matrix.length; i++) {
            String[] input = scan.nextLine().split("");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input[j];
            }
        }
    }
}
