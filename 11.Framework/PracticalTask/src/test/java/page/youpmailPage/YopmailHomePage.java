package page.youpmailPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.AbstractPage;

public class YopmailHomePage extends AbstractPage {

    private final String PAGE_URL = "https://yopmail.com/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//div[@id='listeliens']/a[@href='email-generator']")
    private WebElement emailRandomGenerate;

    public YopmailHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public YopmailHomePage openPage() {
        driver.navigate().to(PAGE_URL);
        logger.info("Yopmail page opened");
        return this;
    }

    public EmailGeneratedPage generateRandomEmail(){
        emailRandomGenerate.click();
        logger.info("email was generated");
        return new EmailGeneratedPage(driver);
    }
}
