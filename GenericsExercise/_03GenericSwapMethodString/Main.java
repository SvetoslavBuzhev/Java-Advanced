package _03GenericSwapMethodString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int readLines = Integer.parseInt(scan.nextLine());

        List<Swap> stringList = new ArrayList<>();

        for (int i = 0; i < readLines; i++) {
           Swap<String> el = new Swap<>(scan.nextLine());
           stringList.add(el);
        }
        int[] toSwap = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Swap.swap(toSwap[0],toSwap[1],stringList);
        stringList.forEach(System.out::println);
    }
}
