package pages.cloudGooglePage.calculatorPageElements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class EmailEstimateBlock extends BasePage {

    @FindBy(xpath = "//input[contains(@ng-model,'user.email')]")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;

    public EmailEstimateBlock(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public EmailEstimateBlock pasteEmailIntoEmailEstimateBlockFromClipboard(){
        emailInput.click();
        emailInput.sendKeys(Keys.CONTROL + "V");
        return this;
    }

    public EmailEstimateBlock clickOnSendEmailButton(){
        sendEmailButton.click();
        return this;
    }

}
