package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.JsUtil;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public abstract class BasePage {
    public WebDriver driver;
    protected JsUtil jsUtil;
    private static final int DRIVER_DEFAULT_WAIT_TIMEOUT = 15;

    protected BasePage(WebDriver driver){
        this.driver = driver;
        jsUtil = new JsUtil(driver);
    }

    protected WebElement getElementByXpath(String xpath) {
        return new WebDriverWait(driver, ofSeconds(DRIVER_DEFAULT_WAIT_TIMEOUT))
                .until(presenceOfElementLocated(By.xpath(xpath)));
    }

    protected WebElement shouldBeClickable(String xpath) {
        return new WebDriverWait(driver, ofSeconds(DRIVER_DEFAULT_WAIT_TIMEOUT))
                .until(elementToBeClickable(By.xpath(xpath)));
    }
}
