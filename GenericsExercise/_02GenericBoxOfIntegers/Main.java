package GenericsExercise._02GenericBoxOfIntegers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int linesToRead = Integer.parseInt(scan.nextLine());
        BoxOfInts box = new BoxOfInts();
        for (int i = 0; i < linesToRead; i++) {
            Integer element = Integer.valueOf(scan.nextLine());
            box.addToBox(element);
        }
        System.out.println(box);
    }
}
