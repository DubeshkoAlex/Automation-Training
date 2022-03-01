package page.cloudGooglePage.calculatorPageElements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.AbstractElement;
import utils.Scroller;


public class EmailBlock extends AbstractElement {

    private Scroller scroller = new Scroller();

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//input[contains(@ng-model,'user.email')]")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;

    public EmailBlock(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    public EmailBlock putDataIntoEmailBlock(){
        driver.switchTo().frame(0).switchTo().frame("myFrame");
        emailInput.sendKeys(Keys.CONTROL + "V");
        return this;
    }

    public EstimateBlock sendEmail(){
        scroller.scrollToElement(emailInput);
        sendEmailButton.click();
        logger.info("email was sent");
        return new EstimateBlock(driver);
    }

}
