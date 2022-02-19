package pages.cloudGooglePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class CloudGoogleResultSearchPage extends BasePage {

    @FindBy(xpath = "//div[@class='gs-title']//b[text()='Google Cloud Pricing Calculator']")
    private WebElement googleCloudPricingCalculatorLink;

    public CloudGoogleResultSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public CloudGoogleResultSearchPage clickOnPricingCalculatorLink(){
        webElementIsVisible(googleCloudPricingCalculatorLink);
        googleCloudPricingCalculatorLink.click();
        return this;
    }
}
