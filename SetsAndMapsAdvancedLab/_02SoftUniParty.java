package SetsandMapsAdvancedLab;

import java.util.*;

public class _02SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> guests = new TreeSet<>();


        fillSets(guests, scan);
        checkForGuests(guests, scan);
    }

    private static void checkForGuests(Set<String> guests, Scanner scan) {
        String input = scan.nextLine();
        while (!input.equals("END")) {
            guests.remove(input);
            input = scan.nextLine();
        }
        System.out.println(guests.size());
        System.out.println(String.join(System.lineSeparator(),guests));
    }


    private static void fillSets(Set<String> vip, Scanner scan) {
        String input = scan.nextLine();
        while (!input.equals("PARTY")) {
            vip.add(input);
            input = scan.nextLine();
        }
    }
}
