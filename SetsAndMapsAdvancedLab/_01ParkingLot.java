package SetsandMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01ParkingLot {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Set<String> carNumbers=new LinkedHashSet<>();

        parkingSystem(scan,carNumbers);
    }

    private static void parkingSystem(Scanner scan, Set<String> carNumbers) {
        String input=scan.nextLine();
        while (!input.equals("END")){

            String command=input.split(", ")[0];
            String carNumber=input.split(", ")[1];
            if (command.equals("IN")){
                carNumbers.add(carNumber);
            }else {
                carNumbers.remove(carNumber);
            }
            input=scan.nextLine();
        }
        if (carNumbers.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }
        printSet(carNumbers);
    }

    private static void printSet(Set<String> carNumbers) {
        for (String carNumber:carNumbers) {
            System.out.println(carNumber);
        }
    }
}
