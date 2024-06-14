package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class EconomicCalendarPage extends BasePage {
    private static final String SLIDER_THUMB_XPATH = "//div[@class='tc-slider-timezone-container']//mat-slider[@role='slider']";
    private static final String TIME_ZONE_XPATH = "//div[contains(@class, 'tc-economic-calendar-view-container-filter-n-list tc-normal-background')]//span//div[@class='ng-star-inserted']";
    private static final String IFRAME_XPATH = "//iframe[@title='iframe']";
    private static final String SHOW_TIME_FILTER_XPATH = "//span[@aria-label='Show time filter']";
    private static final String ECONOMIC_CALENDAR_HEADER_XPATH = "//span[@class='tc-economic-calendar-item-header-left-title tc-normal-text']";


    public EconomicCalendarPage(WebDriver driver) {
        super(driver);
    }

    public String dragSliderAndGetDate(String timePoint) {
        WebElement frame = getElementByXpath(IFRAME_XPATH);
        driver.switchTo().frame(frame);
        WebElement timeMark = getElementByXpath(TIME_ZONE_XPATH);
        int moveCount = 0;
        String date = "";
        if (isElementPresent(SHOW_TIME_FILTER_XPATH)) {
            WebElement timeFilter = getElementByXpath(SHOW_TIME_FILTER_XPATH);
            jsUtil.scrollIntoView(timeFilter);
            timeFilter.click();
        }

        while (!timeMark.getAttribute("innerHTML").equals(timePoint)) {
            shouldBeClickable(SLIDER_THUMB_XPATH).sendKeys(Keys.ARROW_RIGHT);
            timeMark = getElementByXpath(TIME_ZONE_XPATH);
            date = getElementByXpath(ECONOMIC_CALENDAR_HEADER_XPATH).getText();
            moveCount++;
            if (moveCount > 6) {
                throw new RuntimeException(format("No timezone found for %s after adjusting the time slider.", timePoint));
            }
        }
        driver.switchTo().defaultContent();
        return date;
    }
}
