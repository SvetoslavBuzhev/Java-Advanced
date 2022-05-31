package FilesStreamAndDirectories;

import java.io.*;

public class _03CopyText {
    public static void main(String[] args) {

        String path = "input.txt";

        try{
            FileInputStream fileInputStream=new FileInputStream(path);
            FileOutputStream fileOutputStream=new FileOutputStream("Output.txt");

            PrintWriter writer=new PrintWriter("Output.txt");

            int read=fileInputStream.read();
            while(read>=0){
                if ((char)read==' '){
                    writer.print(" ");
                }else if ((char)read=='\n'){
                    writer.println();
                }else {
                    writer.print(read);
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
