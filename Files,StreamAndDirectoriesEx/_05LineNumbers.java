package FileStreamAndDirectoriesEx;

import java.io.*;

public class _05LineNumbers {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Svetoslav\\Desktop\\SoftUni\\Files,Stream and Directories\\Exercise\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";

        FileInputStream fileInputStream=new FileInputStream(path);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(fileInputStream));

        FileOutputStream fileOutputStream=new FileOutputStream("Output-5");
        PrintWriter writer=new PrintWriter("Output-5");

        String readLine= bufferedReader.readLine();

        int LineCounter=1;

        while (readLine!=null){
            writer.print(LineCounter+". ");
            writer.print(readLine);
            writer.println();
            readLine=bufferedReader.readLine();
            LineCounter++;
        }
        writer.close();
    }
}
