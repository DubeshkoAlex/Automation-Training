package page.cloudGooglePage.calculatorPageElements;

import model.Instances;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractElement;
import utils.Scroller;

import java.time.Duration;

public class InstancesBlock extends AbstractElement {

    private final Logger logger = LogManager.getRootLogger();

    private Scroller scroller = new Scroller();

    @FindBy(xpath = "//input[contains(@ng-model,'computeServer.quantity')]")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//md-checkbox[contains(@ng-model,'computeServer.addGPUs')]")
    private WebElement addGPUs;

    @FindBy(xpath = "//button[contains(@ng-click,'addComputeServer(ComputeEngineForm)')]")
    private WebElement addToEstimate;

    private static final String mdSelect = "//md-select[contains(@ng-model,'computeServer.";

    private final By operationSystemSoftwareMenuLocator = By.xpath(mdSelect + "os')]");
    private final By vmClassLocator = By.xpath(mdSelect + "class')]");
    private final By seriesLocator = By.xpath(mdSelect + "series')]");
    private final By instanceTypeLocator = By.xpath(mdSelect + "instance')]");
    private final By gpuTypeLocator = By.xpath(mdSelect + "gpuType')]");
    private final By gpuNumberLocator = By.xpath(mdSelect + "gpuCount')]");
    private final By localSsdLocator = By.xpath(mdSelect + "ssd')]");
    private final By dataCenterLocationLocator = By.xpath(mdSelect + "location')]");
    private final By committedUsageLocator = By.xpath(mdSelect + "cud')]");

    private static final String OS_OPTION_XPATH = "//div[contains(text(),'%s')]/parent::md-option";
    private static final String VM_OPTION_XPATH = "//md-select-menu[@style]//div[contains(text(),'%s')]";
    private static final String SERIES_OPTION_XPATH = "//md-option[contains(@ng-repeat,'computeServer.family')]/div[contains(text(),'%s')]";
    private static final String INSTANCE_TYPE_XPATH = "//md-option[contains(@ng-repeat,'instance in typeInfo')]/div[contains(text(),'%s')]";
    private static final String GPU_TYPE_OPTION_XPATH = "//md-option[contains(@ng-repeat,'gpuList')]/div[contains(text(),'%s')]";
    private static final String GPU_NUMBER_OPTION_XPATH = "//md-option[contains(@ng-repeat,'supportedGpuNumbers')]/div[contains(text(),'%s')]";
    private static final String LOCAL_SSD_OPTION_XPATH = "//md-option[contains(@ng-repeat,'dynamicSsd')]/div[contains(text(),'%s')]";
    private static final String DATA_CENTER_LOCATION_XPATH = "//md-option[contains(@ng-repeat,'inputRegionText.computeServer')]/div[contains(text(),'%s')]";
    private static final String COMMITTED_USAGE_OPTION_XPATH = "//div[contains(@class,'md-active')]//md-option[@value='%s']";

    public InstancesBlock(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    public EstimateBlock putDataIntoInstancesBlock(Instances instances){
        putInstancesNumber(instances.getNumberOfInstances());
        chooseOsOption(instances.getOperatingSystem());
        chooseVMOption(instances.getVmClass());
        scroller.scrollToElement(operationSystemSoftwareMenuLocator);
        chooseSeriesOption(instances.getSeries());
        chooseInstanceType(instances.getInstanceType());
        clickOnAddGPUs();
        chooseGpuType(instances.getGpuType());
        chooseGpuNumber(String.valueOf(instances.getGpuNumbers()));
        scroller.scrollToElement(gpuNumberLocator);
        chooseLocalSsd(instances.getLocalSSD());
        chooseDataCenterLocation(instances.getDataCenterLocation());
        chooseCommittedUsage(String.valueOf(instances.getCommitedUsage()));
        clickOnAddToEstimate();
        logger.info("Data added into instances block");
        return new EstimateBlock(driver);
    }

    private InstancesBlock putInstancesNumber(int number){
        numberOfInstances.sendKeys(String.valueOf(number));
        return this;
    }

    private InstancesBlock chooseMenu(By menuLocator, By optionLocator){
        new WebDriverWait(driver,Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(menuLocator)).click();
        WebElement option = new WebDriverWait(driver,Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(optionLocator));
        new WebDriverWait(driver,Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(option));
        option.click();
        return this;
    }

    private InstancesBlock chooseOsOption(String osOptionName){
        By osOptionsLocator = By.xpath(String.format(OS_OPTION_XPATH,osOptionName)); // пересмотреть
        chooseMenu(operationSystemSoftwareMenuLocator,osOptionsLocator);
        return this;
    }

    private InstancesBlock chooseVMOption(String vmOptionName){
        By vmOptionsLocator = By.xpath(String.format(VM_OPTION_XPATH,vmOptionName));
        chooseMenu(vmClassLocator,vmOptionsLocator);
        return this;
    }

    private InstancesBlock chooseSeriesOption(String seriesOptionName){
        By seriesOptionsLocator = By.xpath(String.format(SERIES_OPTION_XPATH,seriesOptionName));
        chooseMenu(seriesLocator,seriesOptionsLocator);
        return this;
    }

    private InstancesBlock chooseInstanceType(String instanceTypeOptionName){
        By instanceTypeOptionsLocator = By.xpath(String.format(INSTANCE_TYPE_XPATH,instanceTypeOptionName));
        chooseMenu(instanceTypeLocator,instanceTypeOptionsLocator);
        return this;
    }

    private InstancesBlock clickOnAddGPUs(){
        addGPUs.click();
        return this;
    }

    private InstancesBlock chooseGpuType(String gpuTypeOptionName){
        By gpuTypeOptionsLocator = By.xpath(String.format(GPU_TYPE_OPTION_XPATH,gpuTypeOptionName));
        chooseMenu(gpuTypeLocator,gpuTypeOptionsLocator);
        return this;
    }

    private InstancesBlock chooseGpuNumber(String gpuNumberOptionName){
        By gpuNumberOptionsLocator = By.xpath(String.format(GPU_NUMBER_OPTION_XPATH,gpuNumberOptionName));
        chooseMenu(gpuNumberLocator,gpuNumberOptionsLocator);
        return this;
    }

    private InstancesBlock chooseLocalSsd(String localSsdOptionName){
        By localSsdOptionsLocator = By.xpath(String.format(LOCAL_SSD_OPTION_XPATH,localSsdOptionName));
        chooseMenu(localSsdLocator,localSsdOptionsLocator);
        return this;
    }

    private InstancesBlock chooseDataCenterLocation(String dataCenterLocationOptionName){
        By dataCenterLocationOptionsLocator = By.xpath(String.format(DATA_CENTER_LOCATION_XPATH,dataCenterLocationOptionName));
        chooseMenu(dataCenterLocationLocator,dataCenterLocationOptionsLocator);
        return this;
    }

    private InstancesBlock chooseCommittedUsage(String committedUsageOptionName){
        By committedUsageOptionsLocator = By.xpath(String.format(COMMITTED_USAGE_OPTION_XPATH,committedUsageOptionName));
        chooseMenu(committedUsageLocator,committedUsageOptionsLocator);
        return this;
    }

    private InstancesBlock clickOnAddToEstimate(){
        addToEstimate.click();
        return this;
    }
}
