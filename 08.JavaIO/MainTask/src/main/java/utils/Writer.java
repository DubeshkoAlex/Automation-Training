package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class Writer {
    public static void writeToFile(String fileName, boolean append, String info) {
        try (FileWriter writer = new FileWriter(Paths.get(fileName).toFile(), append)) {
            writer.write(info);
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
