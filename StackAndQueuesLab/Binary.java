package StackAndQueuesLab;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Binary {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int decimalNumber = scan.nextInt();
        ArrayDeque<Integer> stackOfNumbers = new ArrayDeque<>();
        if (decimalNumber == 0) {
            System.out.println(0);
            return;}

        while (decimalNumber != 0) {
            int decimal = 0;
            decimal = decimalNumber % 2;

            stackOfNumbers.push(decimal);

            decimalNumber /= 2;
        }
        int size=stackOfNumbers.size();
        for (int i = 0; i < size; i++) {
            System.out.print(stackOfNumbers.pop());
        }
    }
}

