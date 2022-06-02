package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class _02KnightOfHonor {
    //Function <приема, връща> -> apply
    //Consumer <приема> -> void -> accept
    //Supplier <връща> -> get
    //Predicate <приема> -> връща true/false ->test
    //BiFunction <приема,приема,връща> ->apply
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        List<String> names= Arrays.stream(scan.nextLine().split(" "))
                .collect(Collectors.toList());
        Consumer<String> print=n -> System.out.println("Sir " + n);

        names.forEach(print);
    }
}
