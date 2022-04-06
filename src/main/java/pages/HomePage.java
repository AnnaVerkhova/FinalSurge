package pages;

import components.buttons.EditProfileButton;
import components.buttons.SettingsButton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private static final String BASE_URL = "https://log.finalsurge.com/";
    public static final By HEADER = By.xpath("//a[contains(.,'Dashboard')]");

    Logger log = LogManager.getLogger(HomePage.class);


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER));
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public void openSettingsPage() {
        log.info("Click [{}] button ","Settings");
        driver.findElement(SettingsButton.SETTINGS_BUTTON_LABEL).click();
    }
}

