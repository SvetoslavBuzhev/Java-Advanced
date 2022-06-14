package exam13Aprim;

import java.util.*;
import java.util.stream.Collectors;

public class BlackSmith {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> crafterWeapons = new TreeMap<>();

        ArrayDeque<Integer> steel = new ArrayDeque<>();
        fillQueue(steel, scan);
        ArrayDeque<Integer> carbon = new ArrayDeque<>();
        fillStack(carbon, scan);

        while (!steel.isEmpty()) {
            int sum = steel.poll() + carbon.peek();
            creatingWeapon(sum, crafterWeapons, carbon);
        }


        print(crafterWeapons, steel, carbon);

    }

    private static void print(Map<String, Integer> crafterWeapons, ArrayDeque<Integer> steel, ArrayDeque<Integer> carbon) {
        printFirstLine(crafterWeapons);
        printSecondLine(steel, carbon);
        System.out.println();
        System.out.println(
                crafterWeapons.entrySet()
                        .stream()
                        .map(e -> String.format("%s: %d", e.getKey(), e.getValue()))
                        .collect(Collectors.joining(System.lineSeparator())));
    }


    private static void printSecondLine(ArrayDeque<Integer> steel, ArrayDeque<Integer> carbon) {
        if (steel.size() > 0) {
            System.out.print("Steel left: ");
            String output = steel.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.print(output);
        } else {
            System.out.println("Steel left: none");
        }
        if (carbon.size() > 0) {
            System.out.print("Carbon left: ");
            String output = carbon.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.print(output);
        } else {
            System.out.println("Carbon left: none");
        }
    }

    private static void printFirstLine(Map<String, Integer> crafterWeapons) {
        if (crafterWeapons.size() > 0) {
            int swords = crafterWeapons.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println("You have forged " + swords + " swords.");
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
    }


    private static void fillQueue(ArrayDeque<Integer> steel, Scanner scan) {
        List<Integer> steelValues = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        steel.addAll(steelValues);
    }

    private static void fillStack(ArrayDeque<Integer> carbon, Scanner scan) {
        int[] input = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int element : input) {
            carbon.push(element);
        }
    }

    private static void creatingWeapon(int sum, Map<String, Integer> crafterWeapons, ArrayDeque<Integer> carbon) {
        switch (sum) {
            case 70:
                crafterWeapons.putIfAbsent("Gladius", 0);
                crafterWeapons.put("Gladius", crafterWeapons.get("Gladius") + 1);
                carbon.pop();
                break;
            case 80:
                crafterWeapons.putIfAbsent("Shamshir", 0);
                crafterWeapons.put("Shamshir", crafterWeapons.get("Shamshir") + 1);
                carbon.pop();
                break;
            case 90:
                crafterWeapons.putIfAbsent("Katana", 0);
                crafterWeapons.put("Katana", crafterWeapons.get("Katana") + 1);
                carbon.pop();
                break;
            case 110:
                crafterWeapons.putIfAbsent("Sabre", 0);
                crafterWeapons.put("Sabre", crafterWeapons.get("Sabre") + 1);
                carbon.pop();
                break;
            default:
                int carbonValue = carbon.pop() + 5;
                carbon.push(carbonValue);
        }
    }
}

