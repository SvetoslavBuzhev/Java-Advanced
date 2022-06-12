package DefiningClassesExercise._04RawData;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = Integer.parseInt(scan.nextLine());

        Map<String, Car> Cars = new LinkedHashMap<>();

        for (int i = 0; i < count; i++) {
            String[] input = scan.nextLine().split("\\s+");
            Tire[] tires = new Tire[4];

            String model = input[0];
            int speed = Integer.parseInt(input[1]);
            int power = Integer.parseInt(input[2]);
            int weight = Integer.parseInt(input[3]);
            String type = input[4];
            int index = 4;
            for (int j = 0; j < 4; j++) {
                index++;
                double pressure = Double.parseDouble(input[index]);
                index++;
                int age = Integer.parseInt(input[index]);
                Tire currentTire = new Tire(pressure, age);
                tires[j] = currentTire;
            }
            Car car = new Car(model, speed, power, weight, type, tires);
            Cars.put(model, car);
        }
        String input = scan.nextLine();
        if (input.equals("fragile")) {
           Cars.entrySet()
                    .stream()
                    .filter(entry -> entry.getValue().getCarCargo().getCargoType().equals("fragile"))
                    .filter(entry -> entry.getValue().isMorePressure())
                    .forEach(car->{
                        System.out.println(car.getKey());
                    });

        } else if (input.equals("flamable")) {
            Cars.entrySet()
                    .stream()
                    .filter(entry -> entry.getValue().getCarCargo().getCargoType().equals("flamable"))
                    .filter(entry -> entry.getValue().hasEnoughPower())
                    .forEach(car->{
                        System.out.println(car.getKey());
                    });
        }
    }
}
