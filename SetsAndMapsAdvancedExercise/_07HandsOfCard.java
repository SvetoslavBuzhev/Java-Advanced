package SetAndMapsAdvancedExercise;

import java.util.*;

public class _07HandsOfCard {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, Set<String>> deckPlayers = new LinkedHashMap<>();
        Map<String, Integer> cards = new HashMap<>();
        cards.put("2", 2);  cards.put("9", 9);      cards.put("5", 5);  cards.put("Q", 12); cards.put("A", 14);
        cards.put("8", 8);  cards.put("4", 4);      cards.put("J", 11); cards.put("7", 7);
        cards.put("3", 3);  cards.put("10", 10);    cards.put("6", 6);  cards.put("K", 13);

        Map<String,Integer> types = new LinkedHashMap<>();
        types.put("S",4);   types.put("D",2);
        types.put("H",3);   types.put("C",1);

        while (!input.equals("JOKER")) {
            String[] input1Split = input.split(": ");
            String[] input2Split = input1Split[1].split(", ");
            input = scan.nextLine();
            deckPlayers.putIfAbsent(input1Split[0], new LinkedHashSet<>());
            for (String card : input2Split) {
                deckPlayers.get(input1Split[0]).add(card);
            }
        }
        deckPlayers.
                entrySet()
                .stream()
                .forEach(Player -> {
                    int sum = 0;
                    for (String card : Player.getValue()) {
                        String number="";
                        String type="";
                        if (card.length() == 3) {
                            String[] inputSplit = card.split("");
                            number = inputSplit[0] + inputSplit[1];
                            type = card.split("")[2];
                        } else {
                            type = card.split("")[1];
                            number = card.split("")[0];
                        }
                        int num = cards.get(number);
                        int typ = types.get(type);

                        sum += typ * num;
                    }
                    System.out.printf("%s: %d%n", Player.getKey(), sum);
                });
    }


}
