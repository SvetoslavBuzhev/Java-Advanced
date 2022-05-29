package SetsandMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int countOfStudents=Integer.parseInt(scan.nextLine());

        Map<String,double[]> graduationGrades=new LinkedHashMap<>();

        for (int i = 0; i < countOfStudents; i++) {
            String name=scan.nextLine();

            double[] grades=Arrays.stream(scan.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            graduationGrades.putIfAbsent(name,new double[grades.length]);
            graduationGrades.put(name,grades);
        }
graduationGrades
        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByKey())
        .forEach(student->{
            double sum=0;
            for (int i = 0; i < student.getValue().length; i++) {
                sum+=student.getValue()[i];
            }
            double average = sum/student.getValue().length;
            System.out.println(student.getKey() + " is graduated with " + average);
        });
    }
}
