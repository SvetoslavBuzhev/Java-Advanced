package SetAndMapsAdvancedExercise;

import java.util.*;
import java.util.stream.Collectors;

public class _02SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> inputInfo = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int sizeOfFirstSet = inputInfo.get(0);
        int sizeOfSecondSet = inputInfo.get(1);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < sizeOfFirstSet + sizeOfSecondSet; i++) {
            while (i < sizeOfSecondSet) {
                firstSet.add(Integer.parseInt(scan.nextLine()));
                i++;
            }
            secondSet.add(Integer.parseInt(scan.nextLine()));
        }
        firstSet.retainAll(secondSet);
        firstSet.forEach(e -> System.out.print(e + " "));
    }
}

