package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private WebDriver driver;

    private WebDriver buildDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = WebDriverManager.chromedriver()
                .capabilities(options)
                .create();
        return driver;
    }

    public WebDriver getWebdriver() {
        if (driver == null) {
            driver = buildDriver();
        }
        return driver;
    }


}
