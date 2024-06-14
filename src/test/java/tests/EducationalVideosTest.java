package tests;

import dataproviders.ScreenResolutionProvider;
import org.testng.annotations.BeforeMethod;
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

    @Factory(dataProviderClass = ScreenResolutionProvider.class, dataProvider = "resolution")
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
        assertThat(homePage.getHeader())
                        .isEqualTo("Trade On the Go with the All-In-One XM App.");
        homePage.clickMenu();
        homePage.clickTabResearchMenu();
        new ResearchAndEducationPage(driver).selectVideoByLink("educational-videos");
        new EducationalVideosPage(driver).playVideoAndVerifyProgressTime("Lesson 1.1", "00:05");
    }
}

