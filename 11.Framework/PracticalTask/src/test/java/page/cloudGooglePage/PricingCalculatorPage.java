package page.cloudGooglePage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.AbstractPage;
import page.cloudGooglePage.calculatorPageElements.InstancesBlock;

public class PricingCalculatorPage extends AbstractPage {

    private final String PAGE_URL = "https://cloud.google.com/products/calculator#id=";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//div[@title='Compute Engine']/parent::md-tab-item")
    private WebElement computeEngineElement;

    public PricingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public PricingCalculatorPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    private PricingCalculatorPage switchToMyFrame(){
        driver.switchTo().frame(0).switchTo().frame("myFrame");
        return this;
    }

    public InstancesBlock chooseComputeEngineElement(){
        switchToMyFrame();
        computeEngineElement.click();
        logger.info("ComputeEngine element opened");
        return new InstancesBlock(driver);
    }
}
