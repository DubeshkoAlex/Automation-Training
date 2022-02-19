package tests;

import common.CommonActions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import pages.*;
import pages.cloudGooglePage.CloudGoogleHomePage;
import pages.cloudGooglePage.CloudGooglePricingCalculatorPage;
import pages.cloudGooglePage.CloudGoogleResultSearchPage;
import pages.yopmailPage.YopmailPage;

import static common.Config.HOLD_BROWSER_OPEN;

public abstract class BaseTest {
    protected static WebDriver driver = CommonActions.createDriver();
    protected static BasePage basePage = new BasePage(driver);
    protected static CloudGoogleHomePage CloudHomePage = new CloudGoogleHomePage(driver);
    protected static CloudGoogleResultSearchPage cloudGoogleSearchPage = new CloudGoogleResultSearchPage(driver);
    protected static CloudGooglePricingCalculatorPage cloudGooglePricingCalculatorPage = new CloudGooglePricingCalculatorPage(driver);
    protected static YopmailPage yopmailPage = new YopmailPage(driver);

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
