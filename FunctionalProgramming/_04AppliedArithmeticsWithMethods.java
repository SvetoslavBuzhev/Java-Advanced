package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _04AppliedArithmeticsWithMethods {
    public static void main(String[] args) {

        //Function <приема, връща> -> apply
        //Consumer <приема> -> void -> accept
        //Supplier <връща> -> get
        //Predicate <приема> -> връща true/false ->test
        //BiFunction <приема,приема,връща> ->apply
        Scanner scan = new Scanner(System.in);
        List<Integer> inputOfIntegers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scan.nextLine();
        Function<List<Integer>, List<Integer>> add = list -> list.stream()
                .map(number -> number + 1)
                .collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiply = list -> list.stream()
                .map(number -> number * 2)
                .collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtract = list -> list.stream()
                .map(number -> number - 1)
                .collect(Collectors.toList());
        Consumer<List<Integer>> print = list -> list.forEach(number -> System.out.printf(number + " "));
        while (!input.equals("end")) {

            switch (input) {
                case "add":
                    inputOfIntegers=add.apply(inputOfIntegers);
                    break;
                case "multiply":
                    inputOfIntegers=multiply.apply(inputOfIntegers);
                    break;
                case "subtract":
                    inputOfIntegers=subtract.apply(inputOfIntegers);
                    break;
                case "print":
                    print.accept(inputOfIntegers);
                    System.out.println();
                    break;
            }
            input = scan.nextLine();
        }
    }
}
