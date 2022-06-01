package FuntionalProgrammingLAb;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _02SumNumbers {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Function<List<Integer>,String> countFormatter = list->"Count = "+list.size();
        Function<List<Integer>,Integer> sumAllElements = l->  l.stream().reduce(0,Integer::sum);
        Function<Integer,String> sumFormatter = s -> "Sum = " + s;
        System.out.println(countFormatter.apply(numbers));
        int sumAllElement=sumAllElements.apply(numbers);
        String printSum=sumFormatter.apply(sumAllElement);
        System.out.println(printSum);
    }
}
