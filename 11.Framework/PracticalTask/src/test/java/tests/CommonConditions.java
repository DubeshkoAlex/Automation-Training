package tests;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.TabManager;
import utils.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;
    protected TabManager tabManager;

    @BeforeMethod
    public void setUp(){
        driver = DriverSingleton.getDriver();
        tabManager = new TabManager().initTabManager();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
