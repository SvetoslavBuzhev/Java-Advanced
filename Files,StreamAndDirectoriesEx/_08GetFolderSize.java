package FileStreamAndDirectoriesEx;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Objects;

public class _08GetFolderSize {

    public static void main(String args[]) {
        File file = new File("C:\\Users\\Svetoslav\\Desktop\\SoftUni\\Files,Stream and Directories\\Exercise\\" +
                "04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");
        ArrayDeque<File> dirs = new ArrayDeque<>();

        dirs.offer(file);
        long folderSize = 0;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            assert nestedFiles != null;
            for (File nestedFile : nestedFiles)
                if (nestedFile.isDirectory()) {
                    dirs.offer(nestedFile);
                } else {
                    folderSize += nestedFile.length();
                }
        }
        System.out.printf("Folder size: %d", folderSize);
    }
}

