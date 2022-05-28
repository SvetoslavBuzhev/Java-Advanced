package SetsandMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class _03VoinaWithQueue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] firstRow = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] secondRow = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> firstDeck = new ArrayDeque<>();
        ArrayDeque<Integer> secondDeck = new ArrayDeque<>();

        fillQueue(firstRow, firstDeck);
        fillQueue(secondRow, secondDeck);

        int rounds = 0;
        while (!firstDeck.isEmpty() && !secondDeck.isEmpty()) {
            if (rounds == 50) {
                break;
            }

            int firstNumber = firstDeck.pop();
            int secondNumber = secondDeck.pop();

            if (firstNumber > secondNumber) {
                firstDeck.offer(firstNumber);
                firstDeck.offer(secondNumber);
            } else if (secondNumber > firstNumber) {
                secondDeck.offer(firstNumber);
                secondDeck.offer(secondNumber);
            }
            rounds++;
        }
        if (firstDeck.size() > secondDeck.size()) {
            System.out.println("First player win!");
        } else if (firstDeck.size() < secondDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw");
        }
    }


    private static void fillQueue(int[] firstRow, ArrayDeque<Integer> firstDeck) {
        for (int element : firstRow) {
            if (!firstDeck.contains(element)) {
                firstDeck.offer(element);
            }
        }
    }
}
