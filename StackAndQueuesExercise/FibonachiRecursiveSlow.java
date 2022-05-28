package StackAndQueuesExercise;

import java.util.Scanner;

public class FibonachiRecursiveSlow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int fibonacciNumber = scan.nextInt();

        if (fibonacciNumber < 2 || fibonacciNumber > 49) {
            throw new ArithmeticException("Invalid input");
        }

        long result = fib(fibonacciNumber);
        System.out.println(result);
    }

    public static int fib(int n) {
        if(n<2){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
}
