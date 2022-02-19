package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Locale;

import static constants.Constants.TextVariables.*;

public class PastebinNewPastePage extends BasePage{

    public PastebinNewPastePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='info-top']/h1")
    private WebElement newPasteHeader;

    @FindBy(xpath = "//div[@class='left']/a")
    private WebElement syntaxButton;

     @FindBy(xpath = "//div[@class='de1']")
    private static List<WebElement> resultCode;


     public PastebinNewPastePage checkHeaderShouldBeLikePasteNameTitle(){
         Assert.assertEquals(newPasteHeader.getText(),PASTE_NAME_TITLE_2);
         return this;
     }

     public PastebinNewPastePage checkSyntaxShouldBeBash(){
         Assert.assertEquals(syntaxButton.getText().toLowerCase(Locale.ROOT),SYNTAX_VALUE);
         return this;
     }

     public PastebinNewPastePage checkCodeShouldBeLikeInSecondPoint(){
         StringBuilder resultCodeText = new StringBuilder("");
         resultCode.forEach(element -> {
             resultCodeText.append(element.getText()).append("\n");
         });
         resultCodeText.deleteCharAt(resultCodeText.length()-1);
         Assert.assertEquals(resultCodeText.toString(), CODE_2);
         return this;
     }


}
