package StackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MyMathPotato {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int numberOfTosses = scan.nextInt();
        ArrayDeque<String> queueKids = new ArrayDeque<>();
        Collections.addAll(queueKids, input);

        int circle = 1;

        for (int i = numberOfTosses+1 ; i >= 0 ; i++) {
            if (queueKids.size()==1){
                System.out.println("Last is " + queueKids.peek());
                break;
            }
            if (i%numberOfTosses==0){
                if (!isPrime(circle++)){
                    System.out.println("Removed " + queueKids.poll());
                }else {
                    System.out.println("Prime " +  queueKids.peek());
                }
            }else {
                queueKids.offer(queueKids.poll());
            }
        }
    }

    private static boolean isPrime(int circle) {
        int count=0;
        for (int i = 1; i <= circle; i++) {
            if (circle%i==0){
                count++;
            }
        }
        return count==2;
    }
}
