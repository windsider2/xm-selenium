package tests;

import listeners.ScreenshotListener;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import webdriver.DriverManager;
@Listeners(ScreenshotListener.class)
public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp(ITestContext context) {
        driver = DriverManager.getWebdriver();
        context.setAttribute("driver", driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}