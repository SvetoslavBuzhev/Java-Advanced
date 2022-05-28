package StackAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTexdEditorV2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder text=new StringBuilder();

        int numberOfCommands=Integer.parseInt(scan.nextLine());

        ArrayDeque<String> commands=new ArrayDeque<>();
        ArrayDeque<String> undoText=new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String[] command=scan.nextLine().split(" ");
            switch (command[0]){
                case "1"://add
                    undoText.push(text.toString());
                    commands.push("1");
                    text.append(command[1]);
                    break;
                case "2"://remove
                    undoText.push(text.toString());
                    commands.push("2");
                    removeElement(Integer.parseInt(command[1]),text);
                    break;
                case "3"://getCharAt
                    char ch=text.charAt(Integer.parseInt(command[1])-1);
                    System.out.println(ch);
                    break;
                case "4"://undo
                    String lastCommand=commands.pop();
                    if (lastCommand.equals("1")){
                        text=new StringBuilder(undoText.pop());
                    } else if (lastCommand.equals("2")) {
                        text=new StringBuilder(undoText.pop());
                    }else{
                        System.out.println("Wrong undo command");
                    }
                    break;
            }
        }
    }
    public static void removeElement(int elements,StringBuilder text){
        for (int i = 0; i < elements; i++) {
            text.deleteCharAt(text.length()-1);
        }
    }
}
