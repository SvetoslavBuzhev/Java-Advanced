package SetsandMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _06ProductShop {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        String input=scan.nextLine();

        Map<String,Map<String,Double>> shopProducts=new TreeMap<>();

        while (!input.equals("Revision")){
            String[] inputSplit=input.split(", ");
            String shopName=inputSplit[0];
            String productToAdd=inputSplit[1];
            double priceOfProduct=Double.parseDouble(inputSplit[2]);

            shopProducts.putIfAbsent(shopName,new LinkedHashMap<>());
            shopProducts.get(shopName).put(productToAdd,priceOfProduct);
            input=scan.nextLine();
        }

        for (Map.Entry<String, Map<String, Double>> entry : shopProducts.entrySet()) {
            System.out.printf("%s->%n",entry.getKey());
            for (Map.Entry<String, Double> stringDoubleEntry : entry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n",stringDoubleEntry.getKey(),stringDoubleEntry.getValue());
            }
        }


    }
}
