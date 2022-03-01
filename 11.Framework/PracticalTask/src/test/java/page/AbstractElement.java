package page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractElement {
    protected WebDriver driver;

    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractElement(WebDriver driver){this.driver = driver;}
}
