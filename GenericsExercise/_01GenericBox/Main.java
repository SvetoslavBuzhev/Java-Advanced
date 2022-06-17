package GenericsExercise._01GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int linesToRead = Integer.parseInt(scan.nextLine());
        Box box = new Box();
        for (int i = 0; i < linesToRead; i++) {
            String element = scan.nextLine();
            box.addToBox(element);
        }
        System.out.println(box);
    }
}
