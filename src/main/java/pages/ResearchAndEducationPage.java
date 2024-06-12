package pages;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class ResearchAndEducationPage extends BasePage {
    private static final String VIDEO_LINK_XPATH_PATTERN = "//div[@id='researchMenu']//a[contains(@href, '%s')]";
    public ResearchAndEducationPage(WebDriver driver) {
        super(driver);
    }

    public void selectVideoByTitle(String link) {
        WebElement videoLink = getElementByXpath(format(VIDEO_LINK_XPATH_PATTERN, link));
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        jsUtil.scrollIntoView(videoLink);
        try {
            videoLink.click();
        } catch (ElementNotInteractableException e) {
            js.executeScript("arguments[0].click();", link);
        }
    }
}
