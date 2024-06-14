package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class EducationalVideosPage extends BasePage {
    private static final String VIDEO_XPATH_PATTERN = "//div[contains(@class, 'slick-track')]//div[contains(normalize-space(), '%s')]";
    private static final String INTRO_TO_MARKETS_BUTTON_XPATH = "//button[text()='Intro to the Markets']";
    private static final String VIDEO_PLAYER_IFRAME_XPATH = "//iframe[@title='Video Player']";
    private static final String PLAY_VIDEO_BUTTON_XPATH = "//div[@aria-label='Play Video']";
    private static final String PLAYER_PROGRESS_TIME_XPATH = "//div[@class='player-progress-time']";

    public EducationalVideosPage(WebDriver driver) {
        super(driver);
    }

    public void playVideoAndVerifyProgressTime(String title, String progressTime) {
        final WebElement video = getElementByXpath(format(VIDEO_XPATH_PATTERN, title));
        final WebElement introToMarketsButton = getElementByXpath(INTRO_TO_MARKETS_BUTTON_XPATH);
        jsUtil.scrollIntoView(introToMarketsButton);
        introToMarketsButton.click();
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
        new WebDriverWait(driver, ofSeconds(DRIVER_DEFAULT_WAIT_TIMEOUT))
                .until(textToBePresentInElement(playerProgress, progressTime));
        driver.switchTo().defaultContent();
    }

}
