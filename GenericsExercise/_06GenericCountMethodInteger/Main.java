package _06GenericCountMethodInteger;





import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Count elements = new Count<>();

        int readLines = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < readLines; i++) {
            Double el = Double.parseDouble(scan.nextLine());
            elements.addMethods(el);
        }
        List<Double> els = elements.countGreaterItems(Double.parseDouble(scan.nextLine()));
        System.out.println(els.size());
    }
}