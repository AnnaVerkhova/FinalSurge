package pages;

import components.buttons.EditProfileButton;
import components.buttons.SettingsButton;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private static final String BASE_URL = "https://log.finalsurge.com/";
    public static final By HEADER = By.xpath("//a[contains(.,'Dashboard')]");
    public static final By HOMEPAGE_WORKOUTS = By.xpath("//div[@id='fade-menu']//a[@class='arrow_down' and contains(.,'Workouts')]");
    public static final By HOMEPAGE_ADDWORKOUT = By.xpath("//div[@id='fade-menu']//a[contains(.,'Add Workout')]");

    // public static final By HOMEPAGE_WORKOUTS_WEB= By.xpath("//div[@id='fade-menu']//a[@class='arrow_down' and contains(.,'Workouts')]");


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
        driver.findElement(SettingsButton.SETTINGS_BUTTON_LABEL).click();
    }

    public void openAddWorkoutButton() {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(HOMEPAGE_WORKOUTS);
        action.moveToElement(we).moveToElement(driver.findElement(HOMEPAGE_WORKOUTS)).build().perform();
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HOMEPAGE_ADDWORKOUT));
        driver.findElement(HOMEPAGE_ADDWORKOUT).click();

    }
}

