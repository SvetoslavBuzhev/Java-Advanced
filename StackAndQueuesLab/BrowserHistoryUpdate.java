package StackAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayDeque<String> backedUrls = new ArrayDeque<>();
        ArrayDeque<String> forwardUrls = new ArrayDeque<>();

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (backedUrls.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    forwardUrls.push(backedUrls.pop());
                    System.out.println(backedUrls.peek());
                }

            } else if (input.equals("forward")) {
                if (forwardUrls.size()==0){
                    System.out.println("no next URLs");
                }else {
                        System.out.println(forwardUrls.peek());
                        backedUrls.push(forwardUrls.pop());
                }
            } else {
                backedUrls.push(input);
                System.out.println(backedUrls.peek());
                forwardUrls.clear();
            }
            input = scan.nextLine();
        }
    }
}

