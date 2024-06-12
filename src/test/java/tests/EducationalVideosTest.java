package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import pages.EducationalVideosPage;
import pages.HomePage;
import pages.PrivacyModalDialog;
import pages.ResearchAndEducationPage;
import util.ScreenUtil;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EducationalVideosTest extends BaseTest {
    private String resolution;

    @Factory(dataProvider = "dataMethod")
    public EducationalVideosTest(String resolution) {
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

    @Test
    public void playTimeTest() {
        final EducationalVideosPage educationalVideosPage = new EducationalVideosPage(driver);
        assertThat(homePage.getHeader())
                        .isEqualTo("Trade On the Go with the All-In-One XM App.");
        homePage.clickMenu();
        homePage.clickTabResearchMenu();
        new ResearchAndEducationPage(driver).selectVideoByTitle("educational-videos");
        educationalVideosPage.startVideoAndVerifyProgressTime("Lesson 1.1", "00:05");
    }

    @DataProvider
    private static Object[][] dataMethod() {
        return new Object[][]{{"max"}, {"1024 x 768"}, {"800 x 600"}};
    }
}
