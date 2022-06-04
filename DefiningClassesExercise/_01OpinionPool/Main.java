package DefiningClassesExercise._01OpinionPool;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = Integer.parseInt(scan.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] splitInput = scan.nextLine().split(" ");
            String name = splitInput[0];
            int age = Integer.parseInt(splitInput[1]);

            Person person = new Person(name, age);
            people.add(person);
        }
        people
                .stream()
                .sorted(Comparator.comparing(Person::getName))
                .filter(Main::isMoreThan30)

                .forEach(person -> {
                    System.out.println(person.print());
                });
    }

    private static boolean isMoreThan30(Person p) {
        return p.getAge() >= 30;
    }


}
