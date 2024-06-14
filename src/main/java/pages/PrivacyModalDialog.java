package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class PrivacyModalDialog extends BasePage {
    public PrivacyModalDialog(WebDriver driver) {
        super(driver);
    }

    private static final String ACCEPT_ALL_BUTTON_XPATH = "//div[@class='modal-content']//div[@class='modal-footer']//button[contains(text(), '%s')]";

    public void clickButton(String button) {
        if (isElementPresent(format(ACCEPT_ALL_BUTTON_XPATH, button))) {
            final WebElement dialogButton = getElementByXpath(format(ACCEPT_ALL_BUTTON_XPATH, button));
            if (dialogButton.isDisplayed()) {
                dialogButton.click();
            }
        }
    }
}
