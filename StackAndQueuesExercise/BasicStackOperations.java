package StackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String[] inputFirstLine=scan.nextLine().split(" ");
        int numbersToPush=Integer.parseInt(inputFirstLine[0]);
        int numbersToPop=Integer.parseInt(inputFirstLine[1]);
        int numberToCheck=Integer.parseInt(inputFirstLine[2]);



        ArrayDeque<Integer> numberStack=new ArrayDeque<>();

        for (int i = 0; i < numbersToPush; i++) {
            int readNumber=scan.nextInt();
            numberStack.push(readNumber);
        }
        for (int i = 0; i < numbersToPop; i++) {
            numberStack.pop();
        }
        if (numberStack.size()==0){
            System.out.println(0);
        } else if (isNumber(numberToCheck,numberStack)){
            System.out.println("true");
        }else {
            System.out.println(StackSmallestNumber(numberStack));
        }
    }

    private static int StackSmallestNumber(ArrayDeque<Integer> numberStack) {
        int lowestNumber=Integer.MAX_VALUE;
        for (Integer number:numberStack) {
            if (number<lowestNumber){
                lowestNumber=number;
            }
        }return lowestNumber;
    }

    public static boolean isNumber(int numberToCheck,ArrayDeque <Integer> numberStack){
        for (Integer number:numberStack) {
            if(numberToCheck==number){
                return  true;
            }
        }return false;
    }
}
