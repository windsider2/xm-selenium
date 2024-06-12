package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private static final String HEADER_XPATH = "//div[@class ='xm_app_stickyHeader__container text-left']//p";

    public String getHeader() {
        return getElementByXpath(HEADER_XPATH).getText();
    }

    public void navigateToHomePage() {
        driver.get("https://www.xm.com/");
    }

    public void clickMenu() {
        WebElement menu = getElementByXpath("//button[@class='toggleLeftNav']");
        if (menu.isDisplayed()) {
            menu.click();
        }
    }

    public void clickTab(String tab) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        WebElement tab2 = getElementByXpath("//a[@aria-controls='researchMenu']");
        js.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", tab2);
        js.executeScript("arguments[0].click();", tab2);
        //tab2.click();
    }
}
