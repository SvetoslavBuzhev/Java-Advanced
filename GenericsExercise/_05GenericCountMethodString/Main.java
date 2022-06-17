package _05GenericCountMethodString;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Count elements = new Count<>();

        int readLines = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < readLines; i++) {
            String el = scan.nextLine();
            elements.addMethods(el);
        }

        System.out.println(elements.countGreaterItems(scan.nextLine()));
    }
}