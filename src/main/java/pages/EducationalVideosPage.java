package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class EducationalVideosPage extends BasePage {
    private static final String VIDEO_XPATH_PATTERN = "//div[contains(@class, 'slick-track')]//div[contains(normalize-space(), '%s')]";
    private static final String INTRO_TO_MARKETS_BUTTON_XPATH = "//button[text()='Intro to the Markets']";
    private static final String VIDEO_PLAYER_IFRAME_XPATH = "//iframe[@title='Video Player']";
    private static final String PLAY_VIDEO_BUTTON_XPATH = "//div[@aria-label='Play Video']";
    public static final String PLAYER_PROGRESS_TIME_XPATH = "//div[@class='player-progress-time']";

    public EducationalVideosPage(WebDriver driver) {
        super(driver);
    }

    public void startVideoAndVerifyProgressTime(String title, String progressTime) {
        final WebElement video = getElementByXpath(format(VIDEO_XPATH_PATTERN, title));
        final WebElement button = getElementByXpath(INTRO_TO_MARKETS_BUTTON_XPATH);
        jsUtil.scrollIntoView(button);
        button.click();
        jsUtil.scrollIntoView(video);
        try {
            video.click();
        } catch (ElementNotInteractableException e) {
            jsUtil.jsClick(video);
        }

        final WebElement playerFrame = getElementByXpath(VIDEO_PLAYER_IFRAME_XPATH);
        driver.switchTo().frame(playerFrame);
        final WebElement playButton = shouldBeClickable(PLAY_VIDEO_BUTTON_XPATH);
        jsUtil.scrollIntoView(playButton);
        try {
            playButton.click();
        } catch (ElementClickInterceptedException e) {
            jsUtil.jsClick(playButton);
        }
        final WebElement playerProgress = getElementByXpath(PLAYER_PROGRESS_TIME_XPATH);
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
