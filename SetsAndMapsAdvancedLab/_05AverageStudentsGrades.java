package SetsandMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class _05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, ArrayList<Double>> students = new TreeMap<>();

        int countOfGrades = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < countOfGrades; i++) {
            String[] inputWithNameAndGrades = scan.nextLine().split(" ");
            String key = inputWithNameAndGrades[0];
            double grade = Double.parseDouble(inputWithNameAndGrades[1]);
            students.putIfAbsent(key, new ArrayList<>());   //ако не съществува такъв елемент създаваме нов лист
            students.get(key).add(grade);                   //след като съществува добавяме вече елемент;
        }

        for (Map.Entry<String, ArrayList<Double>> entry : students.entrySet()) {
            double averageGrade = avgGrades(students, entry.getKey());
            List<String> tmp = entry.getValue().stream()        //от лист с Double
                    .map(e -> String.format("%.2f", e))         //в лист от String
                    .toList();                                  //На втория ред казваме че "е" е елемент тип Double , който се превръща в String
                        //като казваме какъв е формата и кой елемент преобразяваме;

            String score = String.join(" ", tmp);          //Създаваме String който събира всички елементи от листа tmp в един String и ги разделя с място;
            System.out.printf("%s -> %s (avg: %.2f)%n", entry.getKey(), score, averageGrade);
        }


    }

    private static double avgGrades(Map<String, ArrayList<Double>> students, String key) {
        double averageGrade = 0;
        for (double element : students.get(key)) {
            averageGrade += element;
        }
        return averageGrade;
    }
}
