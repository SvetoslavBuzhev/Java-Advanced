package DefiningClassesLab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        for (int i = 0; i <count; i++) {
            String[] inputSplit = input.split("\\s+");
            Car car = new Car();
            car.setBrand(inputSplit[0]);
            car.setModel(inputSplit[1]);
            car.setHorsePower(Integer.parseInt(inputSplit[2]));

            System.out.println(car.carInfo());
            input=scan.nextLine();
        }
    }
}
