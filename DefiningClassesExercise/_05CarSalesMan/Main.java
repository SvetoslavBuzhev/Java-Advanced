package DefiningClassesExercise._05CarSalesMan;

import java.util.*;

public class Main {
    public static List<Engine> engines = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        LinkedList<Car> cars = new LinkedList<>();
        int readLinesForEngines = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < readLinesForEngines; i++) {
            String[] parts = scan.nextLine().split("\\s+");
            Engine engine = new Engine(parts);
            engines.add(engine);
        }

        int readLinesForCars = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < readLinesForCars; i++) {
            String[] carInfo = scan.nextLine().split("\\s+");
            Engine engine = null;
            for (int j = 0; j < engines.size(); j++) {
                if (engines.get(j).getModel().equals(carInfo[1])){
                    engine = engines.get(j);
                }
            }
            Car car = new Car (carInfo,engine);

            cars.add(car);
        }
        System.out.println();
        cars.forEach(System.out::println);
    }
}
