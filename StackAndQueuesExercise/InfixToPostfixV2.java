package StackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class InfixToPostfixV2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        ArrayDeque<String> QueueOutput = new ArrayDeque<>();
        ArrayDeque<String> OperatorStack = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            String in = input[i];
            switch (in) {
                case "+":
                case "-":
                    if (OperatorStack.isEmpty()) {
                        OperatorStack.push(in);
                    } else {
                        if (OperatorStack.peek().equals("*") || OperatorStack.peek().equals("/") || OperatorStack.peek().equals("+")
                                || OperatorStack.peek().equals("-")) {
                            QueueOutput.offer(OperatorStack.pop());
                            OperatorStack.push(in);
                        } else {
                            OperatorStack.push(in);
                        }
                    }
                    break;
                case "*":
                case "/":
                case "(":
                    OperatorStack.push(in);
                    break;
                case ")":
                    while (!OperatorStack.peek().equals("(")) {
                        QueueOutput.offer(OperatorStack.pop());
                    }
                    OperatorStack.pop();
                    break;
                default:
                    QueueOutput.offer(in);
            }
        }
        for (String element : OperatorStack) {
            QueueOutput.offer(element);
        }
        for (String element : QueueOutput) {
            System.out.print(element + " ");
        }
    }
}
