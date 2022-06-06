package DefiningClassesExercise._03SpeedRacing;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        Map<String,List<Car>> cars = new LinkedHashMap<>();

        int count = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < count; i++) {
            String[] carInput = scan.nextLine().split("\\s+");

            String model = carInput[0];
            double fuelAm = Double.parseDouble(carInput[1]);
            double costPerKm = Double.parseDouble(carInput[2]);

            Car car = new Car(model,fuelAm,costPerKm);
            cars.putIfAbsent(car.getModel(),new ArrayList<>());
            cars.get(car.getModel()).add(car);
        }

        String input = scan.nextLine();

        while (!input.equals("End")){
            String[] inputSplit = input.split("\\s+");

            String car = inputSplit[1];
            double amountOfKm = Double.parseDouble(inputSplit[2]);

            cars.get(car).get(0).movingCar(amountOfKm);
            input=scan.nextLine();
        }
        System.out.println(
        cars.entrySet()
                .stream()
                .map(car -> String.format("%s %.2f %d",car.getKey(),car.getValue().get(0).getFuelAmount(),
                        car.getValue().get(0).getTravelDistance()))
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
