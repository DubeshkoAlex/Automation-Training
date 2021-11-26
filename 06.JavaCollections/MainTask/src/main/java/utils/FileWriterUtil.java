package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class FileWriterUtil {
    public static void toTextFile(String fileName, boolean append,String message, String info){
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
}

