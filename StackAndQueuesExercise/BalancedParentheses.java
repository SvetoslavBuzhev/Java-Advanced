package StackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("");

        ArrayDeque<String> rightParentheses = new ArrayDeque<>();
        ArrayDeque<String> leftParentheses = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("(") || input[i].equals("{") || input[i].equals("[")) {
                rightParentheses.push(input[i]);
            } else {
                leftParentheses.offer(input[i]);
            }
        }
        if (!areEqual(rightParentheses, leftParentheses) ) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }

    }

    public static boolean areEqual(ArrayDeque<String> right, ArrayDeque<String> left) {
        if (right.size() == left.size()) {
            int size = right.size();
            for (int i = 0; i < size; i++) {
                if (right.peek().equals("(") && left.peek().equals(")")) {
                    right.pop();
                    left.poll();

                } else if (right.peek().equals("{") && left.peek().equals("}")) {
                    right.pop();
                    left.poll();
                } else if (right.peek().equals("[") && left.peek().equals("]")) {
                    right.pop();
                    left.poll();
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
