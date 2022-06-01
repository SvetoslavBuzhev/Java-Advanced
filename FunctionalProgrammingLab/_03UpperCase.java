package FuntionalProgrammingLAb;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _03UpperCase {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);


        Predicate<String> isUpperCase=w->Character.isUpperCase(w.charAt(0)); //връща true или false;

        List<String> words = Arrays.stream(scan.nextLine().split(" ")).
        filter(isUpperCase)
        .collect(Collectors.toList());

        Function<List<String>,Integer> count= List::size;
        System.out.println(count.apply(words));
        System.out.println(String.join(System.lineSeparator(),words));

    }
}
