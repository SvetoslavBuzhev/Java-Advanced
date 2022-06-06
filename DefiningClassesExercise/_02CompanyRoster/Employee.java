package DefiningClassesExercise._02CompanyRoster;

import java.util.Scanner;

public class Employee {
    private
    String name;



    double salary;
    String position;
    String department;
    String email = "n/a";



    Integer age = -1;

    public Employee(Scanner scan) {
        String[] input = scan.nextLine().split(" ");
        this.name = input[0];
        this.salary = Double.parseDouble(input[1]);
        this.position = input[2];
        this.department = input[3];
        if (input.length == 5) {
            String in = input[4];
            try {
                this.age = Integer.parseInt(in);
            } catch (Exception e) {
                this.email = in;
            }
        } else if (input.length == 6) {
            this.email = input[4];
            this.age = Integer.parseInt(input[5]);
        }
    }
    public String getEmail(){
        return email;
    }
    public Integer getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public String print() {
        return String.format("%s %.2f %s %d",getName(),getSalary(),getEmail(),getAge() );
    }
}
