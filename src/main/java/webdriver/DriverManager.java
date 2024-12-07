package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private static void buildDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver webDriver = WebDriverManager.chromedriver()
                .capabilities(options)
                .create();
        driver.set(webDriver);
    }

    public static WebDriver getWebdriver() {
        if (driver.get() == null) {
            buildDriver();
        }
        return driver.get();
    }
}
