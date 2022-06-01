package FileStreamAndDirectoriesEx;

import java.io.*;

public class _01SumLines {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Svetoslav\\Desktop\\SoftUni\\Files,Stream and Directories\\Exercise" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        FileInputStream fileInputStream=new FileInputStream(path);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(fileInputStream));
        FileOutputStream fileOutputStream=new FileOutputStream("Output-1");
        PrintWriter writer=new PrintWriter("Output-1");

        String readLine=bufferedReader.readLine();

        while (readLine!=null){
            int sum=0;
            for (int i = 0; i < readLine.length(); i++) {
                int charValue=readLine.charAt(i);
                sum+=charValue;
            }
            writer.println(sum);
            readLine= bufferedReader.readLine();
        }
        writer.close();;
    }
}
