package FileStreamAndDirectoriesEx;

import java.io.*;
import java.util.Set;

public class _04CountCharTypes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Svetoslav\\Desktop\\SoftUni\\Files,Stream and Directories\\Exercise" +
                "\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        FileInputStream fileInputStream=new FileInputStream(path);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(fileInputStream));

        FileOutputStream fileOutputStream=new FileOutputStream("Output-4");
        PrintWriter writer=new PrintWriter("Output-4");

        String readLine= bufferedReader.readLine();

        Set<Character> vowels = Set.of('a','e','u','o','i');
        Set<Character> Punctuation = Set.of(',','.','!','?');

        int vowelsCount=0;
        int punctuationCount=0;
        int Consonants=0;


        while (readLine!=null){
            for (char ch:readLine.toCharArray()) {
                if (vowels.contains(ch)){
                    vowelsCount++;
                }else if(Punctuation.contains(ch)){
                    punctuationCount++;
                }else if (ch!=' '){
                    Consonants++;
                }
            }
            readLine= bufferedReader.readLine();
        }
        writer.println("Vowels: "+vowelsCount);
        writer.println("Consonants: "+Consonants);
        writer.println("Punctuation: "+punctuationCount);

        writer.close();
    }
}
