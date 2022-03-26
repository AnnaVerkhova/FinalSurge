package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FinalLoginPage extends BasePage{

    public static final String BASE_URL = "https://log.finalsurge.com/";
    public static final By EMAIL = By.cssSelector("[name='login_name']");
    public static final By PASSWORD = By.cssSelector("[name='login_password']");
    public static final By LOGIN_BUTTON = By.xpath("//div/button[contains(.,'Login')]");

    public FinalLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageLoaded() {
     explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
    }

    public void login(String email,String password){
        driver.findElement(EMAIL).sendKeys(email);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }
    @Override
    public BasePage openPage() {
        driver.get(BASE_URL);
        return this;
    }
}
