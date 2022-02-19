package pages.yopmailPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class YopmailPage extends BasePage {

    @FindBy(xpath = "//div[@id='listeliens']/a[@href='email-generator']")
    private WebElement emailRandomGenerate;

    @FindBy(xpath = "//button[@onclick=\"clipboard('egen')\"]")
    private WebElement copyEmailTiClipboard;

    @FindBy(xpath = "//button[@onclick=\"egengo();\"]")
    private WebElement checkEmail;

    @FindBy(id = "refresh")
    private WebElement refreshButton;

    @FindBy(xpath = "//table//td[4]")
    private WebElement costInTheLetter;


    public YopmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public YopmailPage clickOnEmailRandomGenerate(){
        emailRandomGenerate.click();
        return this;
    }

    public YopmailPage clickCopyEmailToClipboard(){
        copyEmailTiClipboard.click();
        return this;
    }

    public YopmailPage clickCheckEmail(){
        checkEmail.click();
        return this;
    }

    public YopmailPage refresh(){
        webElementIsVisible(refreshButton);
        refreshButton.click();
        return this;
    }

    public YopmailPage switchToIfMailFrame(){
        driver.switchTo().frame("ifmail");
        return this;
    }

    public String getCostInTheLetter(){
        webElementIsVisible(costInTheLetter);
        return costInTheLetter.getText();
    }

}
