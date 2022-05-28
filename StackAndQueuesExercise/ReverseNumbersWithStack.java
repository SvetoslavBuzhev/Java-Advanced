package StackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String[] input=scan.nextLine().split(" ");
        ArrayDeque<String> stack=new ArrayDeque<>();
        ArrayDeque<String> newStack=new ArrayDeque<>();
        for (int i =0;i<input.length;i++){
            stack.push(input[i]);
        }
        int stackSize=stack.size();
        for (int i = 0; i < stackSize; i++) {
            newStack.add(stack.pop());
        }
        for (String number:newStack) {
            System.out.print(number+" ");
        }
    }
}
