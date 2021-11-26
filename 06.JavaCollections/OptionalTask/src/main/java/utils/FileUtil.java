package utils;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtil {
    public static void write(String fileName, boolean append, String message, String info){
        LogUtil.info(String.format("Trying to write result in file %s.", fileName));
        try(FileWriter writer = new FileWriter(Paths.get(fileName).toFile(), append))
        {
            writer.write(message);
            writer.write("\n");
            writer.write(info);
            writer.write("\n\n");
            writer.flush();
            LogUtil.info("Successful recording");
        }
        catch(IOException exception){
            LogUtil.error(exception.getMessage());
        }
    }

    public static void write(String fileName, boolean append, List<String> strings){
        LogUtil.info(String.format("Trying to write result in file %s.", fileName));
        try(FileWriter writer = new FileWriter(Paths.get(fileName).toFile(), append))
        {
            for (String string:strings) {
                writer.write(string);
                writer.write("\n");
            }
            writer.flush();
        }
        catch(IOException exception){
            LogUtil.error(exception.getMessage());
        }
    }

    public static List<String> read(String fileName){
        LogUtil.info(String.format("Trying to write result in file %s.", fileName));
        List<String> fileStrings = new ArrayList<>();
        try(FileReader reader = new FileReader(Paths.get(fileName).toFile()))
        {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()){
                fileStrings.add(scanner.nextLine());
            }
            LogUtil.info("Successful reading");
        }
        catch(IOException exception){
            LogUtil.error(exception.getMessage());
        }
        return fileStrings;
    }
}

