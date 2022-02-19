package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static constants.Constants.TimeoutVariable.EXPLICIT_WAIT;

public class BasePage {
    protected WebDriver driver;
    protected Map<String,String> tabs = new HashMap<>();

    public BasePage(WebDriver driver){
        this.driver = driver;
    }


    public void open(String url, String tabName){
        driver.get(url);
        tabs.put(tabName, driver.getWindowHandle());
    }

    public void openNewTab(){
        String window1 = driver.getWindowHandle();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        Set<String> currentWindows = driver.getWindowHandles();
        String window2 = null;
        for (String window:currentWindows) {
            if(!window.equals(window1)){
                window2 = window;
                break;
            }
        }
        driver.switchTo().window(window2);
    }

    public void switchToTab(String tabTo){
        driver.switchTo().window(tabs.get(tabTo));
    }

    public void closeTab(String tabName){
        driver.switchTo().window(tabs.get(tabName));
        driver.close();
        tabs.remove(tabName);
    }

    public WebElement webElementIsVisible(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
