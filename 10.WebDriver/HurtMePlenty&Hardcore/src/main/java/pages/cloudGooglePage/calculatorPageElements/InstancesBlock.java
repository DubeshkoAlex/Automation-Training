package pages.cloudGooglePage.calculatorPageElements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import static constants.Constants.TextVariables.NUMBER_OF_ELEMENTS;

public class InstancesBlock extends BasePage {

    private static final String mdSelect = "//md-select[contains(@ng-model,'computeServer.";
    private static final String mdOption = "//md-option[contains";

    @FindBy(xpath = "//input[contains(@ng-model,'computeServer.quantity')]")
    private WebElement numberOfElementInput;

    @FindBy(xpath = mdSelect + "os')]")
    private WebElement operationSystemSoftwareMenu;

    @FindBy(xpath = mdSelect + "series')]")
    private WebElement seriesMenu;

    @FindBy(xpath = mdOption + "(@value,'n1')]")
    private WebElement seriesMenuOptionN1;

    @FindBy(xpath = mdSelect + "instance')]")
    private WebElement machineTypeMenu;

    @FindBy(xpath = mdOption + "(@value,'N1-STANDARD-8')]")
    private WebElement getMachineTypeMenuStandart;

    @FindBy(xpath = "//md-checkbox[contains(@ng-model,'computeServer.addGPUs')]")
    private WebElement computeServerAddGPUs;

    @FindBy(xpath = mdSelect + "gpuType')]")
    private WebElement gpuTypeMenu;

    @FindBy(xpath = mdOption + "(@value,'NVIDIA_TESLA_V100')]")
    private WebElement gpuTypeMenuTeslaV100;

    @FindBy(xpath = mdSelect + "gpuCount')]")
    private WebElement numberOfGpuMenu;

    @FindBy(xpath = mdOption + "(@ng-repeat,'supportedGpuNumbers') and @value='1']")
    private WebElement numberOfGpuMenuElement1;

    @FindBy(xpath = mdSelect + "ssd')]")
    private WebElement localSSDMenu;

    @FindBy(xpath = mdOption + "(@ng-repeat,'dynamicSsd.computeServer') and @value='2']")
    private WebElement localSSDMenuElement2x375Gb;

    @FindBy(xpath = mdSelect + "location')]")
    private WebElement dataCenterLocationMenu;

    @FindBy(xpath = mdOption + "(@ng-repeat,'inputRegionText.computeServer') and @value='europe-west3']")
    private WebElement dataCenterLocationMenuElementFrankfurt;

    @FindBy(xpath = mdSelect + "cud')]")
    private WebElement committedUsageMenu;

    @FindBy(xpath = "//div[contains(@class,'md-active')]//md-option[@ng-value='1']")
    private WebElement committedUsageMenuElement1Year;

    @FindBy(xpath = "//button[contains(@ng-click,'addComputeServer(ComputeEngineForm)')]")
    private WebElement addToEstimateEngineFormButton;

    public InstancesBlock(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    private InstancesBlock scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        return this;
    }

    public InstancesBlock pasteTextToNumberOfElementInput(){
        numberOfElementInput.sendKeys(NUMBER_OF_ELEMENTS);
        return this;
    }

    public InstancesBlock scrollToOperationSystemSoftwareMenu(){
        webElementIsVisible(operationSystemSoftwareMenu);
        scrollToElement(operationSystemSoftwareMenu);
        return this;
    }

    public InstancesBlock clickToSeriesMenu(){
        seriesMenu.click();
        return this;
    }

    public InstancesBlock clickToSeriesMenuOptionN1(){
        webElementIsVisible(seriesMenuOptionN1);
        seriesMenuOptionN1.click();
        return this;
    }

    public InstancesBlock clickToMachineTypeMenu(){
        machineTypeMenu.click();
        return this;
    }

    public InstancesBlock clickToMachineTypeMenuStandart(){
        webElementIsVisible(getMachineTypeMenuStandart);
        getMachineTypeMenuStandart.click();
        return this;
    }

    public InstancesBlock clickToComputeServerAddGPUs(){
        computeServerAddGPUs.click();
        return this;
    }

    public InstancesBlock clickToGpuTypeMenu(){
        gpuTypeMenu.click();
        return this;
    }

    public InstancesBlock clickToGpuTypeMenuTeslaV100(){
        webElementIsVisible(gpuTypeMenuTeslaV100);
        gpuTypeMenuTeslaV100.click();
        return this;
    }

    public InstancesBlock clickToNumberOfGpuMenu(){
        numberOfGpuMenu.click();
        return this;
    }

    public InstancesBlock clickToNumberOfGpuMenuElement1(){
        webElementIsVisible(numberOfGpuMenuElement1);
        numberOfGpuMenuElement1.click();
        return this;
    }

    public InstancesBlock clickToLocalSSDMenu(){
        localSSDMenu.click();
        return this;
    }

    public InstancesBlock clickToLocalSSDMenuElement2x375Gb(){
        webElementIsVisible(localSSDMenuElement2x375Gb);
        localSSDMenuElement2x375Gb.click();
        return this;
    }

    public InstancesBlock clickToDataCenterLocationMenu(){
        dataCenterLocationMenu.click();
        return this;
    }

    public InstancesBlock clickToDataCenterLocationMenuElementFrankfurt(){
        webElementIsVisible(dataCenterLocationMenuElementFrankfurt);
        dataCenterLocationMenuElementFrankfurt.click();
        return this;
    }

    public InstancesBlock scrollToDataCenterLocationMenu(){
        scrollToElement(dataCenterLocationMenu);
        return this;
    }

    public InstancesBlock clickToCommittedUsageMenu(){
        committedUsageMenu.click();
        return this;
    }

    public InstancesBlock clickToCommittedUsageMenuElement1Year(){
        webElementIsVisible(committedUsageMenuElement1Year);
        committedUsageMenuElement1Year.click();
        return this;
    }

    public InstancesBlock clickToAddToEstimateEngineFormButton(){
        addToEstimateEngineFormButton.click();
        return this;
    }
}
