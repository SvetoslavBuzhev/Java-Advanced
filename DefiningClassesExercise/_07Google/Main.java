package DefiningClassesExercise._07Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Person> People = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!input.equals("End")) {
            String[] inputSplit = input.split("\\s+");
            String personName = inputSplit[0];

            if (!People.containsKey(personName)) {
                People.put(personName, new Person(personName));
            }

            readInfo(inputSplit, People, personName);

            input = scan.nextLine();
        }
        input = scan.nextLine();
        System.out.println(People.get(input));
    }

    public static void readInfo(String[] inputSplit, Map<String, Person> People, String personName) {
        String nameOrModel = inputSplit[2];
        switch (inputSplit[1]) {
            case "company":
                String department = inputSplit[3];
                double salary = Double.parseDouble(inputSplit[4]);
                People.get(personName).setCompany(new Company(nameOrModel, department, salary));
                break;
            case "car":
                int carSpeed = Integer.parseInt(inputSplit[3]);
                People.get(personName).setCar(new Car(nameOrModel, carSpeed));
                break;
            case "pokemon":
                String element = inputSplit[3];
                People.get(personName).addPokemon(new Pokemon(nameOrModel, element));
                break;
            case "children":
                String childBirth = inputSplit[3];
                People.get(personName).addChild(new Child(nameOrModel, childBirth));
                break;
            case "parents":
                String parentBirth = inputSplit[3];
                People.get(personName).addParent(new Parent(nameOrModel, parentBirth));
                break;
        }
    }
}
