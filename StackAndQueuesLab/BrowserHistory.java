package StackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input=scan.nextLine();
        ArrayDeque<String> stackOfUrls=new ArrayDeque<>();

        while(!input.equals("Home")){
            if (input.equals("back")){
                if (stackOfUrls.size()<=1) {
                    System.out.println("no previous URLs");
                }
                else {
                    stackOfUrls.pop();
                    System.out.println(stackOfUrls.peek());
                }
            }else {
                    stackOfUrls.push(input);
                    System.out.println(stackOfUrls.peek());
            }
            input=scan.nextLine();
        }
    }
}
