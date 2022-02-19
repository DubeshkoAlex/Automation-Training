package pages.cloudGooglePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.cloudGooglePage.calculatorPageElements.EstimateBlock;
import pages.cloudGooglePage.calculatorPageElements.InstancesBlock;

public class CloudGooglePricingCalculatorPage extends BasePage {

    @FindBy(xpath = "//div[@title='Compute Engine']/parent::md-tab-item")
    private WebElement computeEngineElement;

    public CloudGooglePricingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public CloudGooglePricingCalculatorPage switchToMyFrame(){
        driver.switchTo().frame(0).switchTo().frame("myFrame");
        return this;
    }

    public CloudGooglePricingCalculatorPage clickOnComputeEngineElement(){
        computeEngineElement.click();
        return this;
    }

    public CloudGooglePricingCalculatorPage fillInstancesBlock(){
        InstancesBlock instancesBlock = new InstancesBlock(driver);
        instancesBlock
                .pasteTextToNumberOfElementInput()
                .scrollToOperationSystemSoftwareMenu()
                .clickToSeriesMenu()
                .clickToSeriesMenuOptionN1()
                .clickToMachineTypeMenu()
                .clickToMachineTypeMenuStandart()
                .clickToComputeServerAddGPUs()
                .clickToGpuTypeMenu()
                .clickToGpuTypeMenuTeslaV100()
                .clickToNumberOfGpuMenu()
                .clickToNumberOfGpuMenuElement1()
                .clickToLocalSSDMenu()
                .clickToLocalSSDMenuElement2x375Gb()
                .clickToDataCenterLocationMenu()
                .clickToDataCenterLocationMenuElementFrankfurt()
                .scrollToDataCenterLocationMenu()
                .clickToCommittedUsageMenu()
                .clickToCommittedUsageMenuElement1Year()
                .clickToAddToEstimateEngineFormButton()
        ;
        return this;
    }

    public CloudGooglePricingCalculatorPage checkEstimateBlockValues(){
        EstimateBlock estimateBlock = new EstimateBlock(driver);
        estimateBlock
                .checkRegion()
                .checkCommitmentTerm()
                .checkVmClass()
                .checkInstanceType()
                .checkLocalSSD()
                .checkCost()
        ;
        return this;
    }

    public CloudGooglePricingCalculatorPage emailEstimate(){
        EstimateBlock estimateBlock = new EstimateBlock(driver);
        estimateBlock
                .clickOnEmailEstimateButton()
                .fillEmailEstimateBlock();
        return this;
    }

    public String getCostInCalculator(){
        EstimateBlock estimateBlock = new EstimateBlock(driver);
        return estimateBlock.getCost();
    }
}
