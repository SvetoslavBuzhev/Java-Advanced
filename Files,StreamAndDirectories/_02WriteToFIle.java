package FilesStreamAndDirectories;

import java.io.*;
import java.util.Set;

public class _02WriteToFIle {
    public static void main(String[] args) {

        String path="input.txt";
        Set<Character> symbols=Set.of('!','?',',','.');

        try{
            FileInputStream fileInputStream=new FileInputStream(path);
            FileOutputStream fileOutputStream=new FileOutputStream("Output.txt");

            PrintWriter writer=new PrintWriter("Output.txt");
            int read=fileInputStream.read();
            while (read>=0){
                if (!symbols.contains(read)){
                    writer.print((char)read);
                }
                read=fileInputStream.read();
            }
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
