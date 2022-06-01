package FileStreamAndDirectoriesEx;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class _07MergeFiles {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Svetoslav\\Desktop\\SoftUni\\Files,Stream and Directories\\Exercise\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";

        FileInputStream fileInputStream = new FileInputStream(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

        FileOutputStream fileOutputStream = new FileOutputStream("result.txt");
        PrintWriter writer = new PrintWriter("result.txt");

        String readLine = bufferedReader.readLine();



        while (readLine !=null) {
            writer.println(readLine);
            readLine= bufferedReader.readLine();
        }
        fileInputStream = new FileInputStream("C:\\Users\\Svetoslav\\Desktop\\SoftUni\\Files,Stream and Directories\\Exercise\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");
        bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        readLine  = bufferedReader.readLine();
        while (readLine != null) {
            writer.println(readLine);
            readLine= bufferedReader.readLine();
        }
        writer.close();
    }
}
