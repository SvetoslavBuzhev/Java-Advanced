package TestExerciseArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _06RotateMatrixx {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //четем вход и сплитваме по [()];
        String[] input = scan.nextLine().split("[()]+");
        int angle = Integer.parseInt(input[1])%360;

        //Понеже не знаем колко е броя на думите, и ни трябва динамично променяща се структура,ще използваме List
        //всеки път проверяваме колко е дълга думата, най-дългата я запазваме като maxLengthCol;
        //четем докато не получим команда "END";

        List<String> words = new ArrayList<>();
        //четем вход и го запазваме в words, за да го запаметим в двумерния масив;
        String currentWord = scan.nextLine();
        int maxLengthCol = Integer.MIN_VALUE;

        while (!currentWord.equals("END")) {
            if (currentWord.length() > maxLengthCol) {
                maxLengthCol = currentWord.length();
            }
            words.add(currentWord);
            currentWord = scan.nextLine();
        }
        int rows = words.size();
        int cols = maxLengthCol;
        char[][] matrixOfWords = new char[rows][cols];
        readMatrix(rows, cols, matrixOfWords, words);
        rotateMatrix(matrixOfWords, rows, cols, angle);
    }

    private static void rotateMatrix(char[][] matrixOfWords, int rows, int cols, int angle) {
       switch (angle){
           case 90:
            //rotate 90;
            rotate90(rows,cols,matrixOfWords);
        break;
           case 180:
            //rotate 180;
            rotate180(rows,cols,matrixOfWords);
        break;
           case 270:
            //rotate 270;
            rotate270(rows,cols,matrixOfWords);
       break;
           case 0:
           case 360:
            basicRotate(rows,cols,matrixOfWords);
            //rotate 0 or 360;
        }
    }

    private static void basicRotate(int rows, int cols, char[][] matrixOfWords) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrixOfWords[row][col]);
            }System.out.println();
        }
    }

    private static void rotate270(int rows, int cols, char[][] matrixOfWords) {
        for (int col = cols-1; col >=0 ; col--) {
            for (int row = 0; row < rows; row++) {
                System.out.print(matrixOfWords[row][col]);
            }
            System.out.println();
        }
    }

    private static void rotate180(int rows, int cols, char[][] matrixOfWords) {
        for (int row = rows-1; row >=0 ; row--) {
            for (int col = cols-1; col >=0 ; col--) {
                System.out.print(matrixOfWords[row][col]);
            }
            System.out.println();
        }
    }

    private static void rotate90(int rows, int cols, char[][] matrixOfWords) {
        for (int col = 0; col < cols; col++) {
            for (int row = rows-1; row >=0 ; row--) {
                System.out.print(matrixOfWords[row][col]);
            }
            System.out.println();
        }
    }

    private static void readMatrix(int rows, int cols, char[][] matrixOfWords, List<String> words) {
        for (int row = 0; row < rows; row++) {
            //вземаме думата за да я сплитним и добавим после в масива
            String currentWord = words.get(row);
            for (int col = 0; col < cols; col++) {
                //Проверката за да можем да напълним целия масив с символи, иначе ще стане jagged array и ще е трудна rotate операцията
                //не е col<=currentWord.Length , защото няма да можем да достъпим символ
                if (col < currentWord.length()) {
                    matrixOfWords[row][col] = currentWord.charAt(col);
                } else {
                    matrixOfWords[row][col] = ' ';
                }
            }
        }
    }


}


/*hello
softuni
exam

 i
 n
ou
ltm
lfa
eox
hse
 */