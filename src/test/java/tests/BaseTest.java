package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import webdriver.DriverManager;

public abstract class BaseTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new DriverManager().getWebdriver();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}