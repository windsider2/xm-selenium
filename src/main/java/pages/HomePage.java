package pages;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private static final String HEADER_XPATH = "//div[@class ='xm_app_stickyHeader__container text-left']//p";
    private static final String MENU_BUTTON_XPATH = "//button[@class='toggleLeftNav']";
    private static final String RESEARCH_MENU_LINK_XPATH = "//a[@aria-controls='researchMenu']";


    public String getHeader() {
        return getElementByXpath(HEADER_XPATH).getText();
    }

    public void navigateToHomePage() {
        driver.get("https://www.xm.com/");
    }

    public void clickMenu() {
        final WebElement menu = getElementByXpath(MENU_BUTTON_XPATH);
        if (menu.isDisplayed()) {
            menu.click();
        }
    }

    public void clickTabResearchMenu() {
        final WebElement tabLink = getElementByXpath(RESEARCH_MENU_LINK_XPATH);
        jsUtil.scrollIntoView(tabLink);
        try {
            tabLink.click();
        } catch (ElementNotInteractableException e) {
            jsUtil.jsClick(tabLink);
        }
    }
}
