package SetAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05PhoneBook {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);

        Map<String,String> mapOfPhones=new LinkedHashMap<>();

        String input=scan.nextLine();

        while (!input.equals("search")){
            String[] inputSplit=input.split("-");
            mapOfPhones.put(inputSplit[0],inputSplit[1]);
            input=scan.nextLine();
        }
        input=scan.nextLine();
        while (!input.equals("stop")){

            if (mapOfPhones.containsKey(input)) {
                System.out.printf("%s -> %s%n",input,mapOfPhones.get(input));

            }
            else {
                System.out.printf("Contact %s does not exist.%n",input);
            }
            input=scan.nextLine();
        }
    }
}
