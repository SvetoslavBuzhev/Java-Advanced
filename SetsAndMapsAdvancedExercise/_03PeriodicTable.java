package SetAndMapsAdvancedExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _03PeriodicTable {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int rowToRead=Integer.parseInt(scan.nextLine());

        Set<String> elementSet=new TreeSet<>();

        for (int i = 0; i < rowToRead; i++) {
            String[] elements=scan.nextLine().split(" ");
            elementSet.addAll(Arrays.asList(elements));
        }
        for (String symbol:elementSet) {
            System.out.print(symbol+" ");
        }
    }
}
