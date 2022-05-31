package FilesStreamAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _01ReadFiles {
    public static void main(String[] args)  {

       String path="input.txt";



       try(FileInputStream fileInputStream=new FileInputStream(path)){
           System.out.println("The File has been opened");
           int Byte=fileInputStream.read();
           while(Byte>=0){
               System.out.print(Integer.toBinaryString(Byte));
               Byte=fileInputStream.read();
           }
       }catch (FileNotFoundException e){
           System.out.println("The File has not been opened"+e.getMessage());
       }catch (IOException e){
           System.out.println("Can't read or write to/from file");
       }
    }
}
