package SetsandMapsAdvancedLab;

import java.util.*;

public class _04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Double, Integer> numberCount = new LinkedHashMap<>();

        double[] splitArray = Arrays.stream(scan.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        for (int i = 0; i < splitArray.length; i++) {
            if (numberCount.containsKey(splitArray[i])) {
                numberCount.put(splitArray[i], numberCount.get(splitArray[i]) + 1);
            } else {
                numberCount.put(splitArray[i], 1);
            }
        }
        for (Map.Entry<Double, Integer> doubleIntegerEntry : numberCount.entrySet()) {
            System.out.printf("%.1f -> %d%n",doubleIntegerEntry.getKey(),doubleIntegerEntry.getValue());
        }
    }
}
