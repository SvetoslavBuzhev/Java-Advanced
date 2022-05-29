package SetsandMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class _06ProductShopWithStream {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        Map<String, Map<String, Double>> shopProducts = new TreeMap<>();

        while (!input.equals("Revision")) {
            String[] inputSplit = input.split(", ");
            String shopName = inputSplit[0];
            String productToAdd = inputSplit[1];
            double priceOfProduct = Double.parseDouble(inputSplit[2]);

            shopProducts.putIfAbsent(shopName, new LinkedHashMap<>());
            shopProducts.get(shopName).put(productToAdd, priceOfProduct);
            input = scan.nextLine();
        }
        System.out.println(shopProducts.entrySet()  //
                .stream()
                .map(shop -> String.format("%s->%n%s", shop.getKey(), shop.getValue()
                                        .entrySet()
                                        .stream()
                                        .map(product -> String.format("Product: %s, Price: %.1f", product.getKey(), product.getValue()))
                                        .collect(Collectors.joining(System.lineSeparator()))
                        )
                )
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
/*System.out.println(shopProducts.entrySet()
        .stream()
        .map(shop -> String.format("%s->%n%s", shop.getKey(), shop.getValue()
            .entrySet()
            .stream()
            .map(product -> String.format("Product: %s, Price: %.1f",product.getKey(),product.getValue()))
            .collect(COllectors.joining(System.lineSeparator()))
            )
          )
          .col
 */

