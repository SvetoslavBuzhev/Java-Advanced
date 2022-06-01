package FileStreamAndDirectoriesEx;

import java.io.*;

public class _03ALLCAPITALS {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Svetoslav\\Desktop\\SoftUni\\Files,Stream and Directories\\Exercise" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        FileInputStream fileInputStream=new FileInputStream(path);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(fileInputStream));

        FileOutputStream fileOutputStream=new FileOutputStream("Output-3");
        PrintWriter writer=new PrintWriter("Output-3");

        String readLine= bufferedReader.readLine();

        while (readLine!=null){

            for (char symbol:readLine.toCharArray()) {
                char ch=Character.toUpperCase(symbol);
                writer.print(ch);
            }
            writer.println();
            readLine= bufferedReader.readLine();
        }
        writer.close();
    }
}
