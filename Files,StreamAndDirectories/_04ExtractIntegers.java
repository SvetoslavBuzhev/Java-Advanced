package FilesStreamAndDirectories;

import java.io.*;
import java.util.Scanner;

public class _04ExtractIntegers {
    public static void main(String[] args) {

        String input = "input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(input);
            Scanner scan = new Scanner(fileInputStream);

            PrintWriter writer = new PrintWriter(new FileOutputStream("IntegerReader.txt"));

            while (scan.hasNext()) {
                if (scan.hasNextInt()) {
                    int Integer = scan.nextInt();
                    writer.println(Integer);
                }
                scan.next();
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e.getMessage());
        }
    }
}
