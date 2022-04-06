package forms;
import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreatedWorkoutComponent extends AbstractComponent {

    public static final String CONTACT_TEXT_DATA_NAME_FIELD = "//p[@class='formSep' and contains(.,'%s')]";
    public static final String CONTACT_TEXT_DATA_FIELD ="//div[@class='formSep' and contains(.,'%s')]";
    String label;
    By textFieldContactLocator;

    public CreatedWorkoutComponent(WebDriver driver, String label) {
        super(driver);
        this.label = label;
        this.textFieldContactLocator = By.xpath(String.format(CONTACT_TEXT_DATA_FIELD, label));
    }
    @Override
    public boolean isComponentDisplayed() {
        try {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated((textFieldContactLocator)));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public String getValueWorkout() {
        return driver.findElement(textFieldContactLocator).getText();
    }
    public String getValueMinAndCalories() {
        return driver.findElement(By.xpath(String.format(CONTACT_TEXT_DATA_NAME_FIELD, label))).getText();
    }


}
