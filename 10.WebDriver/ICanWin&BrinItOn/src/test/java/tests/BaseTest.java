package tests;

import common.CommonActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import pages.BasePage;
import pages.PastebinHomePage;
import pages.PastebinNewPastePage;

import static common.Config.HOLD_BROWSER_OPEN;

public abstract class BaseTest {
    protected static WebDriver driver = CommonActions.createDriver();
    protected static BasePage basePage = new BasePage(driver);
    protected static PastebinHomePage page = new PastebinHomePage(driver);
    protected static PastebinNewPastePage newPastePage = new PastebinNewPastePage(driver);

    @AfterSuite(alwaysRun = true)
    public void close(){
        if(!HOLD_BROWSER_OPEN){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.quit();
        }
    }

}
