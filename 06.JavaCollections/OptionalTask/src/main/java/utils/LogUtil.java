package utils;

import org.apache.log4j.Logger;

public class LogUtil {
    private static final Logger LOGGER = Logger.getLogger(LogUtil.class.getName());

    public static void info(String message){
        LOGGER.info(message);
    }

    public static void error(String message){
        LOGGER.error(message);
    }
}
