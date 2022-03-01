package tests;

import model.Instances;
import org.testng.annotations.Test;
import page.cloudGooglePage.MainPage;
import page.cloudGooglePage.calculatorPageElements.EmailBlock;
import page.youpmailPage.CheckingEmailPage;
import page.youpmailPage.YopmailHomePage;
import service.ConstantData;
import service.InstancesCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class HardcoreTest extends CommonConditions {

    @Test
    public void postPriceCheck(){
        Instances testDataInstances = InstancesCreator.getParametersFromProperty();
        EmailBlock emailGoogleCloudBlock = new MainPage(driver)
                                                .openPage()
                                                .invokeNewSearchRequest(ConstantData.getSearchingRequest())
                                                .openPricingCalculatorLink()
                                                .chooseComputeEngineElement()
                                                .putDataIntoInstancesBlock(testDataInstances)
                                                .clickOnSendEstimationByEmail();
        tabManager.openNewTab();
        CheckingEmailPage checkingEmailPage =new YopmailHomePage(driver)
                                                    .openPage()
                                                    .generateRandomEmail()
                                                    .copyEmailIntoClipboard()
                                                    .openPost()
        ;
        tabManager.switchToTab(1);
        String estimatedCost = emailGoogleCloudBlock
                                    .putDataIntoEmailBlock()
                                    .sendEmail()
                                    .getEstimatedCost()
        ;
        tabManager.switchToTab(2);
        String costFromLetter = checkingEmailPage.getCost();
        tabManager.switchToTab(1);
        assertThat(estimatedCost,is(equalTo(costFromLetter)));
    }

}
