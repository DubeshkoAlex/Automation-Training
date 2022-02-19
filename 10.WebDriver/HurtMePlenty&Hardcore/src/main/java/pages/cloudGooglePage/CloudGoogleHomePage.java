package pages.cloudGooglePage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import static constants.Constants.TextVariables.SEARCH_TEXT;

public class CloudGoogleHomePage extends BasePage {

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchInput;


    public CloudGoogleHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public CloudGoogleHomePage pressSearchInput(){
        searchInput.click();
        return this;
    }

    public CloudGoogleHomePage pasteTextIntoSearchInput(){
        searchInput.sendKeys(SEARCH_TEXT);
        return this;
    }

    public CloudGoogleHomePage pressEnterOnSearchInput(){
        searchInput.sendKeys(Keys.ENTER);
        return this;
    }

}
