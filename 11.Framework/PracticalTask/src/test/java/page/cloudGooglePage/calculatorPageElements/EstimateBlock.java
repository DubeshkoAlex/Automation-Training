package page.cloudGooglePage.calculatorPageElements;

import model.Instances;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.AbstractElement;
import utils.StringUtils;


public class EstimateBlock extends AbstractElement {

    private final Logger logger = LogManager.getRootLogger();

    private static final String divContains = "//div[contains(@class,'md-list-item-text') and contains(text(),";

    @FindBy(xpath = "//span[@class='ng-binding ng-scope']")
    private WebElement numberOfInstances;
    @FindBy(xpath = divContains + "'Region')]")
    private WebElement region;
    @FindBy(xpath = divContains + "'Commitment term')]")
    private WebElement commitmentTerm;
    @FindBy(xpath = divContains + "'VM class')]")
    private WebElement vmClass;
    @FindBy(xpath = divContains + "'Instance type')]")
    private WebElement instanceType;
    @FindBy(xpath = divContains + "'Local SSD')]")
    private WebElement localSSD;
    @FindBy(xpath = "//div[contains(@class,'md-list-item-text')]/b[contains(text(),'Cost')]")
    private WebElement cost;
    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement emailEstimateButton;

    public EstimateBlock(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    public Instances getEstimatedInstancesWithRequiredFields(){
        Instances instances = new Instances();
        instances.setNumberOfInstances(Integer.parseInt(getNumberOfInstances()));
        instances.setDataCenterLocation(getRegion());
        instances.setCommitedUsage(Integer.parseInt(getCommitmentTerm()));
        instances.setVmClass(getVmClass());
        instances.setInstanceType(getInstanceType());
        instances.setLocalSSD(getLocalSsd());
        logger.info("Data were written from estimate block to instances object");
        return instances;
    }

    public String getEstimatedCost(){
        return getCost();
    }

    public EmailBlock clickOnSendEstimationByEmail(){
        emailEstimateButton.click();
        return new EmailBlock(driver);
    }

    private String getNumberOfInstances(){
        return StringUtils.getValue(numberOfInstances,"\\d");
    }

    private String getRegion(){
        return StringUtils.getValue(region,"(?<=Region:\\s)[A-z]*");
    }

    private String getCommitmentTerm(){
        return StringUtils.getValue(commitmentTerm, "(?<=Commitment term:\\s)\\d*");
    }

    private String getVmClass(){
        return StringUtils.getValue(vmClass,"(?<=VM class:\\s)[A-z]*");
    }

    private String getInstanceType(){
        return StringUtils.getValue(instanceType,"(?<=Instance type:\\s)[A-z\\d\\-]*");
    }

    private String getLocalSsd(){
        return StringUtils.getValue(localSSD,"(?<=Local SSD:\\s)[A-z\\d]*");
    }

    private String getCost(){
        return StringUtils.getValue(cost,"(?<=Estimated Component Cost: USD\\s)[\\d,.]*");
    }

}
