package StackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countOfPlants = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> plantsPesticides = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(plantsPesticides::push);
        boolean lessPesticides = true;
        do {
            for (int i = 1; i < countOfPlants; i++) {
                if (!plantsPesticides.isEmpty()) {
                    int getLastPesticide = plantsPesticides.poll();
                    if (!plantsPesticides.isEmpty()&&plantsPesticides.peek() > getLastPesticide) {
                        plantsPesticides.poll();
                        plantsPesticides.offer(getLastPesticide);
                    } else {
                        plantsPesticides.offer(getLastPesticide);
                    }
                }
            }
        } while (lessPesticides);
    }
}
