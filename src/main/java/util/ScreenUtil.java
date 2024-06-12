package util;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class ScreenUtil {
    private WebDriver driver;

    public ScreenUtil(WebDriver driver) {
        this.driver = driver;
    }

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
}