package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static constants.Constants.Url.CLOUD_GOOGLE_URL;
import static constants.Constants.Url.YOPMAIL_URL;

public class HurtMePlentyAndHardcoreTest extends BaseTest {

    @BeforeTest
    public static void inputData(){
        basePage.open(CLOUD_GOOGLE_URL,"tab1");
        CloudHomePage
                .pressSearchInput()
                .pasteTextIntoSearchInput()
                .pressEnterOnSearchInput()
        ;
        cloudGoogleSearchPage.clickOnPricingCalculatorLink();
        cloudGooglePricingCalculatorPage
                .switchToMyFrame()
                .clickOnComputeEngineElement()
                .fillInstancesBlock()
        ;
    }

    @Test
    public static void hurtMePlenty(){
        cloudGooglePricingCalculatorPage.checkEstimateBlockValues();
    }

    @Test
    public static void hardcore() {
        basePage.openNewTab();
        basePage.open(YOPMAIL_URL,"tab2");
        yopmailPage
                .clickOnEmailRandomGenerate()
                .clickCopyEmailToClipboard();
        basePage.switchToTab("tab1");
        cloudGooglePricingCalculatorPage
                .switchToMyFrame()
                .emailEstimate();
        String expectedValue = cloudGooglePricingCalculatorPage.getCostInCalculator();
        basePage.switchToTab("tab2");
        yopmailPage
                .clickCheckEmail()
                .refresh()
                .switchToIfMailFrame()
        ;
        String actualValue = yopmailPage.getCostInTheLetter();
        Assert.assertEquals(actualValue,expectedValue);
    }
}
