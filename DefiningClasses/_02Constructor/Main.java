package DefiningClassesLab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = Integer.parseInt(scan.nextLine());

        for (int i = 0; i <count; i++) {
            String[] inputSplit = scan.nextLine().split("\\s+");
            Car car;
            if (inputSplit.length!=1){
                car = new Car(inputSplit[0], inputSplit[1], Integer.parseInt(inputSplit[2]));
            }else {
                car = new Car(inputSplit[0]);
            }
            System.out.println(car.carInfo());
        }
    }
}
