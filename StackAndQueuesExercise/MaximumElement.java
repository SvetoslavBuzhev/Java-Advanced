package StackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfCommands = scan.nextInt();
        scan.nextLine();
        if (numberOfCommands > 100000 || numberOfCommands < 1) {
            throw new ArithmeticException("Invalid number of commands");
        }
        ArrayDeque<Integer> numberStack = new ArrayDeque<>();
        for (int i = 0; i < numberOfCommands; i++) {
            int[] command = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            //push number
            if (command.length == 2) {
                if (command[1] > 1000000000 || command[1] < 1) {
                    throw new ArithmeticException("Invalid number of commands");
                } else {
                    int number = command[1];
                    numberStack.push(number);
                }
            } else {
                int typeOfCommand = command[0];
                //pop top element;
                if (typeOfCommand == 2) {
                    numberStack.pop();
                    //print stack
                } else if (typeOfCommand == 3) {
                    int maxElement = Integer.MIN_VALUE;
                    if (numberStack.isEmpty()) {
                        System.out.println(0);
                        break;
                    }
                    for (Integer number : numberStack) {
                        if (number > maxElement) {
                            maxElement = number;
                        }
                    }
                    System.out.println(maxElement);
                } else {
                    System.out.println("Wrong command");
                }
            }
        }
    }
}
