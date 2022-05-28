package SetsandMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class _03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<Integer> firstDeck = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> secondDeck = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        for (int i = 0; i < 50; i++) {
            Iterator<Integer> firstIterator = firstDeck.iterator();
            int firstNumber = firstIterator.next();
            firstIterator.remove();

            Iterator<Integer> secondIterator = secondDeck.iterator();
            int secondNumber = secondIterator.next();
            secondIterator.remove();

            if (firstNumber > secondNumber) {
                firstDeck.add(firstNumber);
                firstDeck.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                secondDeck.add(firstNumber);
                secondDeck.add(secondNumber);
            }
            if (firstDeck.isEmpty() || secondDeck.isEmpty()) {
                break;
            }
        }
        if (firstDeck.size()>secondDeck.size()){
            System.out.println("First player win!");
        } else if (firstDeck.size()<secondDeck.size()) {
            System.out.println("Second player win!");
        }else {
            System.out.println("Draw");
        }
    }
}
