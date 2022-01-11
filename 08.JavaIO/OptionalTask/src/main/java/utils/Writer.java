package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class Writer {
    public static void writeToFile(String fileName, boolean append, String info) {
        try {
            if(!new File(fileName).exists()) {
                new File(fileName.substring(0,fileName.lastIndexOf("/"))).mkdirs();
                new File(fileName).createNewFile();
            }
            new File(fileName).delete();
            new File(fileName).createNewFile();
            FileWriter writer = new FileWriter(Paths.get(fileName).toFile(), append);
            writer.write(info);
            if (append) {
                writer.write("\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
