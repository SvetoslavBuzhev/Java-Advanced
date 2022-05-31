package SetAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _06FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = "";


        Map<String, String> workersEmail = new LinkedHashMap<>();
        while (true) {
            name = scan.nextLine();
            if (name.equals("stop")){
                break;
            }
            String email = scan.nextLine();
            if (!(email.endsWith("us") || (email.endsWith("uk") || (email.endsWith("com"))))) {
                workersEmail.putIfAbsent(name, email);
            }
        }
        workersEmail.entrySet()
                .stream()
                .forEach(resource -> System.out.printf("%s -> %s%n", resource.getKey(), resource.getValue()));
    }
}
