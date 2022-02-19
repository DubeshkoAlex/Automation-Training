package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PastebinHomePage extends BasePage{

    public PastebinHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement codeInput;

    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement pasteNameTitleInput;

    @FindBy(id="select2-postform-format-container")
    private WebElement syntaxHighlightingListBox;

    @FindBy(id="select2-postform-expiration-container")
    private WebElement pasteExpirationListBox;

    @FindBy(xpath = "//li[@aria-label='------ POPULAR LANGUAGES -------']//li[@class='select2-results__option' and text()='Bash']")
    private WebElement syntaxHighlightingListBoxBashElement;

    @FindBy(xpath = "//li[@class='select2-results__option' and text()='10 Minutes']")
    private WebElement pasteExpirationListBoxTenMinutesElement;

    @FindBy(xpath = "//div[@class='content__title -paste']")
    private WebElement optionalPastTitleLabel;

    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement createNewPasteButton;


    public PastebinHomePage pasteInCodeInput(String text){
        codeInput.sendKeys(text);
        return this;
    }

    public PastebinHomePage clickOnPasteExpirationListBox(){
        pasteExpirationListBox.click();
        return this;
    }

    private PastebinHomePage scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    public PastebinHomePage scrollToOptionalPastTitle(){
        return scrollToElement(optionalPastTitleLabel);
    }

    public PastebinHomePage clickOnPasteExpirationListBoxElement(){
        pasteExpirationListBoxTenMinutesElement.click();
        return this;
    }

    public PastebinHomePage pasteInPasteNameTitleInput(String text){
        pasteNameTitleInput.sendKeys(text);
        return this;
    }

    public PastebinHomePage clickOnCreateNewPasteButton(){
        createNewPasteButton.click();
        return this;
    }

    public PastebinHomePage clickOnSyntaxHighlightingListBox(){
        syntaxHighlightingListBox.click();
        return this;
    }

    public PastebinHomePage clickOnSyntaxHighlightingListBoxElement(){
        syntaxHighlightingListBoxBashElement.click();
        return this;
    }

}
