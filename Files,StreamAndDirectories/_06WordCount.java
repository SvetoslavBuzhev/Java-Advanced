package FileStreamAndDirectoriesEx;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class _06WordCount {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Svetoslav\\Desktop\\SoftUni\\Files,Stream and Directories\\Exercise\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";

        FileInputStream fileInputStream = new FileInputStream(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

        FileOutputStream fileOutputStream = new FileOutputStream("results.txt");
        PrintWriter writer = new PrintWriter("results.txt");

        int read = bufferedReader.read();

        Set<String> wordsToCheck = new LinkedHashSet<>();
        Map<String, Integer> countOfWords = new LinkedHashMap<>();

        while (read != -1) {
            StringBuilder word = new StringBuilder();
            while (read != ' ' && read != -1) {
                word.append((char) read);
                read = bufferedReader.read();
            }
            wordsToCheck.add(word.toString());
            read = bufferedReader.read();
        }
        fileInputStream = new FileInputStream("C:\\Users\\Svetoslav\\Desktop\\SoftUni\\Files,Stream and Directories\\Exercise\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");
        bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        read = bufferedReader.read();
        while (read != -1) {
            StringBuilder word = new StringBuilder();
            while (read != ' ' && read != -1) {
                word.append((char) read);
                read = bufferedReader.read();
            }
            if (wordsToCheck.contains(word.toString())){
                countOfWords.putIfAbsent(word.toString(),0);
                countOfWords.put(word.toString(), countOfWords.get(word.toString())+1);
            }
            read= bufferedReader.read();
        }
        countOfWords.entrySet()
                .forEach(word -> {
                    writer.println(word.getKey() + " - " + word.getValue());
                });
        writer.close();
    }
}
