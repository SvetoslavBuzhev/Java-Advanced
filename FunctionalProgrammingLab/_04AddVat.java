package FuntionalProgrammingLAb;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class _04AddVat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Consumer<Double> price=p-> System.out.printf("%.2f%n",p);

        UnaryOperator<Double> priceVat = p -> p * 1.2;

        System.out.println("Prices with VAT: ");

        Arrays.stream(scan.nextLine().split(", "))
                .map(Double::parseDouble)
                .map(priceVat)
                .forEach(price);
    }
}
