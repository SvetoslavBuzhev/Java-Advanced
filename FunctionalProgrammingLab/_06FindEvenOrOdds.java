package FuntionalProgrammingLAb;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _06FindEvenOrOdds {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int[] Range= Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int lower=Range[0];
        int upper=Range[1];
        String command=scan.nextLine();

        System.out.println(IntStream.rangeClosed(lower,upper)
                .boxed()
                .filter(getPredicate(command))
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));

    }

    private static Predicate<Integer> getPredicate(String command) {
        switch (command){
            case "odd":
                return p->p%2!=0;
            case "even":
                return p->p%2==0;
            default:
                throw new IllegalArgumentException("Wrong command input");
        }
    }
}
