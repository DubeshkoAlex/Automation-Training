package page.cloudGooglePage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.AbstractPage;

import java.util.List;

public class ResultsSearchPage extends AbstractPage {

    private final String PAGE_URL = "https://cloud.google.com/s/results?q";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class='gs-title']//b[text()='Google Cloud Pricing Calculator']")
    private List<WebElement> googleCloudPricingCalculatorLink;

    public ResultsSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public ResultsSearchPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public PricingCalculatorPage openPricingCalculatorLink(){
        int tryCount = 0;
        while(googleCloudPricingCalculatorLink.size()==0 && tryCount<5){
            driver.manage().deleteAllCookies();
            driver.navigate().refresh();
            tryCount++;
        }
        googleCloudPricingCalculatorLink.get(0).click();
        logger.info("Link opened");
        return new PricingCalculatorPage(driver);
    }
}
