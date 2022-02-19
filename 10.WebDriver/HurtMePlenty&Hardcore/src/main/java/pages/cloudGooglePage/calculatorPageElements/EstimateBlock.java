package pages.cloudGooglePage.calculatorPageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static constants.Constants.VariablesForChecking.*;

public class EstimateBlock extends BasePage {

    private static final String divContains = "//div[contains(@class,'md-list-item-text') and contains(text(),";

    @FindBy(xpath = divContains + "'Region')]")
    private WebElement region;

    @FindBy(xpath = divContains + "'Commitment term')]")
    private WebElement commitmentTerm;

    @FindBy(xpath = divContains + "'VM class')]")
    private WebElement vmClass;

    @FindBy(xpath = divContains + "'Instance type')]")
    private WebElement instanceType;

    @FindBy(xpath = divContains + "'Instance type')]//sub[@class='ng-scope']")
    private WebElement instanceTypeTextForExclusion;

    @FindBy(xpath = divContains + "'Local SSD')]")
    private WebElement localSSD;

    @FindBy(xpath = divContains + "'Local SSD')]//sub[@class='ng-scope']")
    private WebElement localSSDTextForExclusion;

    @FindBy(xpath = "//div[contains(@class,'md-list-item-text')]/b[contains(text(),'Cost')]")
    private WebElement cost;

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement emailEstimateButton;


    public EstimateBlock(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public EstimateBlock checkRegion(){
        String actualValue = region.getText().replaceAll("Region: ","");
        Assert.assertEquals(actualValue,REGION);
        return this;
    }

    public EstimateBlock checkCommitmentTerm(){
        String actualValue = commitmentTerm.getText().replaceAll("Commitment term: ","");
        Assert.assertEquals(actualValue,COMMITMENT_TERM);
        return this;
    }

    public EstimateBlock checkVmClass(){
        String actualValue = vmClass.getText().replaceAll("VM class: ","");
        Assert.assertEquals(actualValue,VM_CLASS);
        return this;
    }

    public EstimateBlock checkInstanceType(){
        String actualValue = instanceType.getText()
                                         .replaceAll("Instance type: ","")
                                         .replaceAll(instanceTypeTextForExclusion.getText(),"")
                                         .replaceAll(" ","")
                                         .replaceAll("\n","");
        Assert.assertEquals(actualValue,INSTANCE_TYPE);
        return this;
    }

    public EstimateBlock checkLocalSSD(){
        String actualValue = localSSD.getText()
                .replaceAll("Local SSD: ","")
                .replaceAll(localSSDTextForExclusion.getText(),"")
                .replaceAll(" ","")
                .replaceAll("\n","")
                .replaceAll("GiB"," GiB");
        Assert.assertEquals(actualValue,LOCAL_SSD);
        return this;
    }

    public String getCost(){
        StringBuilder actualValue = new StringBuilder();
        Matcher matcher = Pattern.compile("USD[ ,.\\d]+\\d").matcher(cost.getText());
        while (matcher.find()){
            actualValue.append(cost.getText(), matcher.start(), matcher.end());
        }
        return actualValue.toString();
    }

    public EstimateBlock checkCost(){
        String actualValue = getCost();
        Assert.assertEquals(actualValue.toString(),COST);
        return this;
    }

    public EstimateBlock clickOnEmailEstimateButton(){
        webElementIsVisible(emailEstimateButton);
        emailEstimateButton.click();
        return this;
    }

    public EstimateBlock fillEmailEstimateBlock(){
        EmailEstimateBlock emailEstimateBlock = new EmailEstimateBlock(driver);
        emailEstimateBlock
                .pasteEmailIntoEmailEstimateBlockFromClipboard()
                .clickOnSendEmailButton();
        return this;
    }
}
