package FuntionalProgrammingLAb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _05FilterByAge {
    public static class Person {
        private
        String name;
        int age;
        public
        Person (String name,int age){
            this.age=age;
            this.name=name;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n= Integer.parseInt(scan.nextLine());

        List<Person> people=new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] p= scan.nextLine().split(", ");
            String name=p[0];
            int age= Integer.parseInt(p[1]);

            Person person=new Person(name,age);
            people.add(person);
        }
        String olderOrYounger=scan.nextLine();
        int age= Integer.parseInt(scan.nextLine());
        String format=scan.nextLine();

        people = filterByCondition(people,predicate(olderOrYounger,age));

        Consumer<Person> printer=getPrinter(format);

        people.forEach(printer);
    }

    private static Consumer<Person> getPrinter(String format) {
        switch (format){
            case "name":
                return p->System.out.println(p.name);
            case "age":
                return p->System.out.println(p.age);
            case "name age":
                return p->System.out.println(p.name+" - "+p.age);
            default:
                throw new IllegalArgumentException("Invalid format input");
        }
    }

    private static List<Person> filterByCondition(List<Person> people, Predicate<Person> predicate) {
            return people.stream()
                    .filter(predicate)
                    .collect(Collectors.toList());
    }

    private static Predicate<Person> predicate(String olderOrYounger, int age) {
        switch (olderOrYounger){
            case "younger":
                return p->p.age<=age;
            case "older":
                return p->p.age>=age;
            default:
                throw new IllegalArgumentException("Invalid parameters for age predicate."+olderOrYounger);
        }
    }
}
