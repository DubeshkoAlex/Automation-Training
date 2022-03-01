package page.youpmailPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.AbstractPage;
import utils.StringUtils;


import java.util.List;


public class CheckingEmailPage extends AbstractPage {

    private final String PAGE_URL = "https://yopmail.com/ru/wm";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "refresh")
    private WebElement refreshButton;
    @FindBy(xpath = "//table//td[4]")
    private List<WebElement> costInTheLetter;
    @FindBy(xpath = "//div[@class='bname']")
    private WebElement emailAddress;


    public CheckingEmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public CheckingEmailPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public String getEmailAddress(){
        return emailAddress.getText();
    }

    public String getCost(){
        int tryCount = 0;
        do{
            driver.navigate().refresh();
            driver.switchTo().frame("ifmail");
            tryCount++;
            logger.info("refresh number: " + tryCount + "/5");
            logger.info("costInTheLetter.size()==" + costInTheLetter.size());
        }while (costInTheLetter.size()==0 && tryCount<5);
        logger.info("Final costInTheLetter.size()==" + costInTheLetter.size());
        return StringUtils.getValue(costInTheLetter.get(0),"(?<=USD\\s)[\\d,.]*");
    }

}
