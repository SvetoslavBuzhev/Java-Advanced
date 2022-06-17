package _07CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        CustomList list = new CustomList<>();
        while (!input.equals("END")) {
            String[] inputSplit = input.split("\\s+");
            String command = inputSplit[0];
            switch (command) {
                case "Add":
                    String element = inputSplit[1];
                    list.Add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(inputSplit[1]);
                    list.Remove(index);
                    break;
                case "Contains":
                    String el = inputSplit[1];
                    System.out.println(list.Contains(el));
                    break;
                case "Max":
                    list.Max();
                    break;
                case "Min":
                    list.Min();
                    break;
                case "Greater":
                    String elements = inputSplit[1];
                    System.out.println(list.Greater(elements));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(inputSplit[1]);
                    int secondIndex = Integer.parseInt(inputSplit[2]);
                    list.Swap(firstIndex,secondIndex);
                    break;
                case "Print":
                    list.print();
                    break;
            }
            input = scan.nextLine();
        }
    }
}
