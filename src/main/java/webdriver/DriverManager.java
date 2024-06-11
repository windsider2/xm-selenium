package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private WebDriver driver;

    private WebDriver buildDriver() {
         System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //driver = new ChromeDriver();
        driver = WebDriverManager.chromedriver()
                .capabilities(options)
                .create();
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getWebdriver() {
        if (driver == null) {
            driver = buildDriver();
        }
        return driver;
    }


}
