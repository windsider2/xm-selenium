package pages;

import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class ResearchAndEducationPage extends BasePage {
    public ResearchAndEducationPage(WebDriver driver) {
        super(driver);
    }

    private static String EDUCATION_VIDEOS_XPATH_PATTERN = "//ul[@id='main-nav']//li/a[contains(text(), '%s')]";

    public void selectVideoByTitle(String videoTitle) {
        getElementByXpath(format(EDUCATION_VIDEOS_XPATH_PATTERN, videoTitle)).click();
    }
}
