package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Function <приема, връща> -> apply
        //Consumer <приема> -> void -> accept
        //Supplier <връща> -> get
        //Predicate <приема> -> връща true/false ->test
        //BiFunction <приема,приема,връща> ->apply
        List<Integer> inputOfIntegers = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Function<List<Integer>, Integer> getMinNum = Collections::min;
        System.out.println(getMinNum.apply(inputOfIntegers));
    }
}
