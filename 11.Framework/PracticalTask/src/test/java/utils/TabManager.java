package utils;

import driver.DriverSingleton;
import org.openqa.selenium.*;
import java.util.*;

public class TabManager {

    private static Map<Integer,String> tabs;
    private static final WebDriver driver = DriverSingleton.getDriver();

    public TabManager(){}

    public TabManager initTabManager(){
        if(null==tabs){
            tabs = new HashMap<>();
            tabs.put(1,driver.getWindowHandle());
        }
        return this;
    }

    public void switchToTab(int tabNumber){
        driver.switchTo().window(tabs.get(tabNumber));
    }

    public void openNewTab() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        Set<String> currentWindows = driver.getWindowHandles();
        currentWindows.removeAll(tabs.values());
        tabs.put(tabs.size()+1, new ArrayList<>(currentWindows).get(0));
        switchToTab(tabs.size());
    }

}
