package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.DriverManager;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class BasePage {
    public WebDriver driver;
    protected BasePage(WebDriver driver){
        this.driver = driver;
    }

    private static final int DRIVER_DEFAULT_WAIT_TIMEOUT = 15;

    public void setScreenResolution(String resolution) {
        switch (resolution.toLowerCase()) {
            case "max":
                driver.manage().window().maximize();
                break;
            case "1024 x 768":
                driver.manage().window().setSize(new Dimension(1024, 768));
                break;
            case "800 x 600":
                driver.manage().window().setSize(new Dimension(800, 600));
                break;
            default:
                throw new RuntimeException("Screen resolution must be set with value 'max', '1024 x 768' or '800 x 600'");
        }
    }

    protected WebElement getElementByXpath(String xpath) {
        return new WebDriverWait(driver, ofSeconds(DRIVER_DEFAULT_WAIT_TIMEOUT))
                .until(presenceOfElementLocated(By.xpath(xpath)));
    }


}
