package SetAndMapsAdvancedExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04CountOfSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char[] ch = scan.nextLine().toCharArray();

        Map<Character, Integer> mapOfChars = new TreeMap<>();

        for (char symbol : ch) {
            mapOfChars.putIfAbsent(symbol, 0);
            mapOfChars.put(symbol, mapOfChars.get(symbol) + 1);
        }

        mapOfChars
                .entrySet()
                .stream()
                .forEach(symbol -> System.out.printf("%c: %d time/s%n", symbol.getKey(), symbol.getValue()));
    }

}

