package tests;

import dataproviders.ScreenResolutionProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import pages.EconomicCalendarPage;
import pages.HomePage;
import pages.PrivacyModalDialog;
import pages.ResearchAndEducationPage;
import util.ScreenUtil;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static util.DateUtil.*;

public class EconomicCalendarTest extends BaseTest {
    private String resolution;

    @Factory(dataProviderClass = ScreenResolutionProvider.class, dataProvider = "resolution")
    public EconomicCalendarTest(String resolution) {
        this.resolution = resolution;
    }
    private HomePage homePage;
    @BeforeMethod
    public void setResolution() {
        homePage= new HomePage(driver);
        homePage.navigateToHomePage();
        new PrivacyModalDialog(driver).clickButton("ACCEPT ALL");
        new ScreenUtil(driver).setScreenResolution(resolution);
    }

    @Test(dataProvider = "dateProvider")
    public void calendarTest(String timeMark, String expectedDate) {
        homePage.clickMenu();
        homePage.clickTabResearchMenu();
        new ResearchAndEducationPage(driver).selectVideoByLink("economicCalendar");
        String actualDate = new EconomicCalendarPage(driver).dragSliderAndGetDate(timeMark);
        assertThat(actualDate)
                .as("Wrong date after time slider adjustment")
                .isEqualTo(expectedDate);
    }

    @DataProvider
    private static Object[][] dateProvider() {
        return new Object[][]{
                {"Today", getCurrentDate()},
                {"Tomorrow", getTomorrowDate()},
                {"Next Week", getNextWeekDate()}
        };
    }
}

