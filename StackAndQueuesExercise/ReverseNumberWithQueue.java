package StackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumberWithQueue {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String[] input=scan.nextLine().split("\\s+");
        ArrayDeque<String> queue = new ArrayDeque<>();


        for (int i = 0; i <input.length ; i++) {
            queue.offer(input[i]);
        }
        int sizeOfQueue= queue.size();
        for (int i = 0; i < sizeOfQueue; i++) {
            queue.offer(queue.poll());
        }
        for (String number:queue) {
            System.out.print(number+" ");
        }
    }
}
