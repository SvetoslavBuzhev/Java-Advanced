package StackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumberWithStackDesi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String number:input) {
            stack.push(number);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}