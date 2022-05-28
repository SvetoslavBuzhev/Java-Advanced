package StackAndQueuesExercise;

import java.util.Scanner;

public class FinonacciRecursiveFast {
    public static long[] memory;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int number=scan.nextInt();
        memory=new long[number+1];
        long result=fib(number-1)+fib(number-2);
        System.out.println(result);
    }
    public static long fib(int number){
        if (number<2){
            return 1;
        } else if (memory[number]!=0) {
            return memory[number];
        }
        memory[number]=fib(number-1)+fib(number-2);
        return memory[number];
    }
}
