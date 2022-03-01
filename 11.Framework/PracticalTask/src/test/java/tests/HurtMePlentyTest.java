package tests;

import model.Instances;
import org.testng.Assert;
import org.testng.annotations.*;
import page.cloudGooglePage.MainPage;
import service.ConstantData;
import service.InstancesCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class HurtMePlentyTest extends CommonConditions{

    @Test
    public void checkFieldsData(){
        Instances testDataInstances = InstancesCreator.getParametersFromProperty();
        Instances actualInstances = new MainPage(driver)
                .openPage()
                .invokeNewSearchRequest(ConstantData.getSearchingRequest())
                .openPricingCalculatorLink()
                .chooseComputeEngineElement()
                .putDataIntoInstancesBlock(testDataInstances)
                .getEstimatedInstancesWithRequiredFields();
        Assert.assertTrue(testDataInstances.equalsBySmokeTestParam(actualInstances));
    }

    @Test
    public void priceCheck(){
        Instances testDataInstances = InstancesCreator.getParametersFromProperty();
        String actualCost = new MainPage(driver)
                .openPage()
                .invokeNewSearchRequest(ConstantData.getSearchingRequest())
                .openPricingCalculatorLink()
                .chooseComputeEngineElement()
                .putDataIntoInstancesBlock(testDataInstances)
                .getEstimatedCost();
        assertThat(actualCost,is(equalTo(ConstantData.getExpectedCost())));
    }

}
