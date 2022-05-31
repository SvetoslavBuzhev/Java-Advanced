package SetAndMapsAdvancedExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        Set<String> setInput=new LinkedHashSet<>();

        int wordsCount=Integer.parseInt(scan.nextLine());

        for (int i = 0; i < wordsCount; i++) {
            setInput.add(scan.nextLine());
        }
        for (String element:setInput) {
            System.out.println(element);
        }
    }
}
