import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int linesForEmployees = Integer.parseInt(scan.nextLine());

        Map<String, List<Employ>> Departments = new HashMap<>();


        for (int i = 0; i < linesForEmployees; i++) {

            Employ employ = employs(scan);

            Departments.putIfAbsent(employ.getDepartment(), new ArrayList<>());
            Departments.get(employ.getDepartment()).add(employ);
        }

        String maxAvgSalary = Departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(employs -> getAvgSalary(employs.getValue())))
                .get()
                .getKey();
        System.out.println("Highest Average Salary: " + maxAvgSalary);

        List<Employ> employList = Departments.get(maxAvgSalary);

        employList
                .stream()
                .sorted(Comparator.comparingDouble(Employ::getSalary).reversed())
                .forEach(System.out::println);
    }


    private static double getAvgSalary(List<Employ> employs) {
        double sum = 0;

        for (Employ employ : employs) {
            sum += employ.getSalary();
        }

        return sum / employs.size();
    }

    private static Employ employs(Scanner scan) {
        String[] inputSplit = scan.nextLine().split(" ");

        String name = inputSplit[0];
        double salary = Double.parseDouble(inputSplit[1]);
        String position = inputSplit[2];
        String department = inputSplit[3];
        Employ employ = null;
        if (inputSplit.length == 4) {
            employ = new Employ(name, salary, position, department);
        } else if (inputSplit.length == 6) {
            String email = inputSplit[4];
            int age = Integer.parseInt(inputSplit[5]);
            employ = new Employ(name, salary, position, department, email, age);
        } else if (inputSplit.length == 5 && inputSplit[4].contains("@")) {
            String email = inputSplit[4];
            employ = new Employ(name, salary, position, department, email);
        } else if (inputSplit.length == 5) {
            int age = Integer.parseInt(inputSplit[4]);
            employ = new Employ(name, salary, position, department, age);
        }
        return employ;
    }
}
