package FuntionalProgrammingLAb;

import java.util.*;
import java.util.stream.Collectors;

public class _01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)//правим го текст в int
                .filter(n -> n % 2 == 0) //филтрираме,премахваме всички нечетни числа
                .collect(Collectors.toList()); //Judge не поддържа другите варианти за създаване на лист

        System.out.println(numbers
                .stream()
                .map(String::valueOf)//вземаме value на листа като String
                .collect(Collectors.joining(", ")));//добавяме стринговете като между тях слагаме ", "

        System.out.println(numbers
                .stream()
                .sorted() //сортираме
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}
