package FunctionalProgrammingExercise;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        List<Integer> ints  = Arrays.stream(scan.nextLine().split(" ")).
                map(Integer::parseInt)
                .collect(Collectors.toList());
        int divisor = Integer.parseInt(scan.nextLine());
        Consumer<Integer> print = p -> System.out.print(p + " ");
        Collections.reverse(ints);
        ints.stream()
                .filter(isDiviseble(ints,divisor))
                .forEach(print);

    }

    private static Predicate<? super Integer> isDiviseble(List<Integer> ints, int divisor) {
        return p -> p % divisor!=0;
    }
}
