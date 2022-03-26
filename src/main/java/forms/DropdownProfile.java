package forms;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DropdownProfile extends AbstractComponent {

    private static final String DROPDOWN_LOCATOR_PATTERN =
            "//label[contains(.,'%s')]/ancestor::div[contains(@class,'formSep')]//select";
    private String label;
    private By dropdownLocator;
    private static final String OPTION_LIST_PATTERN =
            "//label[contains(.,'%s')]/ancestor::div[contains(@class,'formSep')]" +
                    "//select//option[text()='%s']";


    public DropdownProfile(WebDriver driver,String label) {
        super(driver);
        this.label=label;
        this.dropdownLocator = By.xpath(String.format(DROPDOWN_LOCATOR_PATTERN,label));
    }

    @Override
    public boolean isComponentDisplayed()  {
        return driver.findElement(dropdownLocator).isDisplayed();
    }

    private void openOptions() {
        driver.findElement(dropdownLocator).click();
    }

    public void selectOption(String optionName) {
        openOptions();
        By optionLocator = By.xpath(String.format(OPTION_LIST_PATTERN, optionName));
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        driver.findElement(optionLocator).click();
    }
}
