package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class EducationalVideosPage extends BasePage {
    public EducationalVideosPage(WebDriver driver) {
        super(driver);
    }


    private static final String HEADER_XPATH = "//h1";
    private static final String VIDEO_XPATH_PATTERN = "//div[contains(@class, 'slick-track')]//div[contains(normalize-space(), '%s')]";

    public String getHeaderText() {
        return getElementByXpath(HEADER_XPATH).getText();
    }

    public void startVideoAndVerifyProgressTime(String title, String progressTime) throws InterruptedException {
        WebElement video = getElementByXpath(format(VIDEO_XPATH_PATTERN, title));
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", video);
        video.click();
        WebElement playerFrame = getElementByXpath("//iframe[@title='Video Player']");
        driver.switchTo().frame(playerFrame);
        WebElement playButton = getElementByXpath("//div[@aria-label='Play Video']");
        playButton.click();
        WebElement playerProgress = getElementByXpath("//div[@class='player-progress-time']");
        new WebDriverWait(driver, ofSeconds(7))
                .until(textToBePresentInElement(playerProgress, progressTime));
        driver.switchTo().defaultContent();
    }

    private  ExpectedCondition<Boolean> textToBePresentInElement(final WebElement element, final String text) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                try {
                    String elementText = element.getAttribute("innerHTML");
                    return elementText.contains(text);
                } catch (StaleElementReferenceException var3) {
                    return false;
                }
            }

            public String toString() {
                return String.format("text ('%s') to be present in element %s", text, element);
            }
        };
    }

}
