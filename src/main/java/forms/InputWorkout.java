package forms;

import components.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputWorkout extends AbstractComponent {

    public static final String INPUT_LOCATOR_PATTERN =
            "//input[@id='%s']";

    public static final By HOW_I_FEEL= By.xpath("//input[@id='hf_great']");
    public static final By IS_RACE= By.xpath("//input[@id='IsRace']");

    private String label;
    private By inputLocator;


    public InputWorkout(WebDriver driver,String label) {
        super(driver);
        this.label=label;
        this.inputLocator = By.xpath(String.format(INPUT_LOCATOR_PATTERN, label));
    }

   public void click(){
        driver.findElement(HOW_I_FEEL).click();
   }
    public void click2(){
        driver.findElement(IS_RACE).click();
    }

    @Override
    public boolean isComponentDisplayed()  {
        return driver.findElement(inputLocator).isDisplayed();
    }
    public void input(String text) {
        driver.findElement(inputLocator).sendKeys(text);
    }

}
