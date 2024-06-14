package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.JsUtil;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public abstract class BasePage {
    public WebDriver driver;
    protected JsUtil jsUtil;
    private static final int DRIVER_DEFAULT_WAIT_TIMEOUT = 20;

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

    public boolean isElementPresent(String xpath) {
        try {
            new WebDriverWait(driver, ofSeconds(4))
                    .until(presenceOfElementLocated(By.xpath(xpath)));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected ExpectedCondition<Boolean> textToBePresentInElement(final WebElement element, final String text) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    String elementText = element.getAttribute("innerHTML");
                    return elementText.contains(text);
                } catch (StaleElementReferenceException var3) {
                    return false;
                }
            }

            public String toString() {
                return String.format("text ('%s') to be present in element %s", text, element);
            }
        };
    }
}
