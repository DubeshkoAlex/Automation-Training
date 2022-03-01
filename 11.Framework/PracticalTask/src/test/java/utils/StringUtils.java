package utils;

import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static String getValue(WebElement element, String regexp){
        StringBuilder actualValue = new StringBuilder();
        Matcher matcher = Pattern.compile(regexp).matcher(element.getText());
        while (matcher.find()){
            actualValue.append(element.getText(), matcher.start(), matcher.end());
        }
        return actualValue.toString();
    }
}
