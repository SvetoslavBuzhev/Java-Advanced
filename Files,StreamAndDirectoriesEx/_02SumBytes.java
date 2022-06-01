package FileStreamAndDirectoriesEx;

import java.io.*;

public class _02SumBytes {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Svetoslav\\Desktop\\SoftUni\\Files,Stream and Directories\\Exercise" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        FileInputStream fileInputStream = new FileInputStream(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        FileOutputStream fileOutputStream = new FileOutputStream("Output-2");
        PrintWriter writer = new PrintWriter("Output-2");

        String readLine = bufferedReader.readLine();
        long sum = 0;
        while (readLine != null) {

            for (int i = 0; i < readLine.length(); i++) {
                int charValue = readLine.charAt(i);
                sum += charValue;
            }
            readLine = bufferedReader.readLine();
        }
        System.out.println(sum);
        writer.println(sum);
        writer.close();

    }
}

