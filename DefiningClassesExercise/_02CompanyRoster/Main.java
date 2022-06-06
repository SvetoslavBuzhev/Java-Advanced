package DefiningClassesExercise._02CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int scanLines = Integer.parseInt(scan.nextLine());

        Map<String, List<Employee>> Department = new LinkedHashMap<>();

        for (int i = 0; i < scanLines; i++) {
            Employee employee = new Employee(scan);
            String depart = employee.getDepartment();
            Department.putIfAbsent(employee.getDepartment(), new ArrayList<>());
            Department.get(depart).add(employee);
        }


        String highestAverageSalary = Department
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> getAverageSalary(entry.getValue())))
                .get()
                .getKey();

        System.out.printf("Highest Average Salary: %s%n",highestAverageSalary);
        List<Employee> bestDepartment = Department.get(highestAverageSalary);

        System.out.println(
        bestDepartment.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .map(Employee::print)
                .collect(Collectors.joining(System.lineSeparator()))
        );
    }

    private static double getAverageSalary(List<Employee> employees) {
        double sum = 0;

        for (Employee employee: employees) {
            sum += employee.getSalary();
        }

        return sum/employees.size();
    }
}
