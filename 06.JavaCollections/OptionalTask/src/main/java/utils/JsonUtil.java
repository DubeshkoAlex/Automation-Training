package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Paths;

public class JsonUtil {
    public static <T> T fromJsonFile(String fileName, Class<T> className){
        LogUtil.info(String.format("Converting from JsonFile to %s.", className));
        ObjectMapper mapper = new ObjectMapper();
        T result = null;
        try {
            result = mapper.readValue(Paths.get(fileName).toFile(), className);
        } catch (IOException e) {
            LogUtil.error(e.toString());
        }
        return result;
    }
}
