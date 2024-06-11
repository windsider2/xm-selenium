package pages;

import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private static final String HEADER_XPATH = "//div[@class ='xm_app_stickyHeader__container text-left']//p";
    private static final String TAB_XPATH_PATTERN = "//*[@id='main-nav']//li/a[contains(normalize-space(), '%s')]";

    public String getHeader() {
        return getElementByXpath(HEADER_XPATH).getText();
    }

    public void navigateHomePage() {
        driver.get("https://www.xm.com/");
    }

    public void clickTab(String tab) {
        getElementByXpath(format(TAB_XPATH_PATTERN, tab)).click();
    }
}
