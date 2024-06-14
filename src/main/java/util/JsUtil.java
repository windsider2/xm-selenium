package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsUtil {
    private WebDriver driver;
    private JavascriptExecutor js;

    public JsUtil(WebDriver driver) {
        this.driver = driver;
        js = ((JavascriptExecutor) driver);
    }

    public void scrollIntoView(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", element);
    }

    public void jsClick(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }
}
