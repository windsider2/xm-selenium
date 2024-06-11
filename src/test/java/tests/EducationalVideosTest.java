package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EducationalVideosPage;
import pages.HomePage;
import pages.PrivacyModalDialog;
import pages.ResearchAndEducationPage;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EducationalVideosTest extends BaseTest {
    private HomePage homePage;
    @BeforeMethod
    public void setResolution() {
        homePage= new HomePage(driver);
        homePage.navigateHomePage();
        new PrivacyModalDialog(driver).clickButton("ACCEPT ALL");
        homePage.setScreenResolution("max");
    }

    @Test
    public void playTimeTest() throws InterruptedException {
        EducationalVideosPage educationalVideosPage = new EducationalVideosPage(driver);
                assertThat( homePage.getHeader())
                        .isEqualTo("Trade On the Go with the All-In-One XM App.");
        homePage.clickTab("RESEARCH");
         new ResearchAndEducationPage(driver).selectVideoByTitle("Educational Videos");
        assertThat(educationalVideosPage.getHeaderText().trim())
                .isEqualTo("FOREX TRADING COURSE");
        educationalVideosPage.startVideoAndVerifyProgressTime("Lesson 1.1", "00:05");

    }
}
