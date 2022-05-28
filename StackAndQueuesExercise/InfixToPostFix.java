package StackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostFix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");

        int powerOfOperator1 = 1;
        int powerOfOperator2 = 2;

        ArrayDeque<String> numbersQueue = new ArrayDeque<>();
        ArrayDeque<String> operatorsStack = new ArrayDeque<>();
        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("+") || input[i].equals("-") || input[i].equals("/") || input[i].equals("*")
                    || input[i].equals("(") || input[i].equals(")")) {
                if (input[i].equals("(")) {
                    operatorsStack.push(input[i]);
                } else if (input[i].equals("+")) {

                    if ((!operatorsStack.isEmpty() && (operatorsStack.peek().equals("/") || operatorsStack.peek().equals("*")))
                            || (!operatorsStack.isEmpty() && operatorsStack.peek().equals("+"))) {
                        numbersQueue.offer(operatorsStack.pop());
                        operatorsStack.push(input[i]);
                    } else {
                        operatorsStack.push(input[i]);
                    }
                } else if (input[i].equals("-")) {
                    if ((!operatorsStack.isEmpty() && (operatorsStack.peek().equals("/") || operatorsStack.peek().equals("*")))
                            || (!operatorsStack.isEmpty() && operatorsStack.peek().equals("-"))) {
                        numbersQueue.offer(operatorsStack.pop());
                        operatorsStack.push(input[i]);
                    } else {
                        operatorsStack.push(input[i]);
                    }
                } else if (input[i].equals(")")) {
                    do {
                        String lastOperator=operatorsStack.pop();
                        numbersQueue.offer(lastOperator);
                    }while (!operatorsStack.peek().equals("("));
                    operatorsStack.pop();
                } else {
                    if (input[i].equals(operatorsStack.peek()) ){
                        operatorsStack.push(input[i]);
                    } else {
                        operatorsStack.push(input[i]);
                    }
                }
            } else
                numbersQueue.offer(input[i]);
        }
        for (String operator : operatorsStack) {
            numbersQueue.offer(operator);
            operatorsStack.pop();
        }
        for (String ch : numbersQueue) {
            System.out.print(ch + " ");
        }

    }
}
