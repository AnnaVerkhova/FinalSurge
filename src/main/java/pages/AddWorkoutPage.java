package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddWorkoutPage extends BasePage{
    public AddWorkoutPage(WebDriver driver) {
        super(driver);
    }
    public static final By HEADER = By.xpath("//ul[@id='breadcrumbs']//li//a[contains(.,'Add Workout')]");
    private static final String BASE_URL ="https://log.finalsurge.com/WorkoutAdd.cshtml";



    public static final By RUNNING_BUTTON = By.xpath("//div//a[@data-code='run']//i[@class='icon-chevron-left' and contains(.,Run)]");
    public static final By SAVE_BUTTON = By.xpath("//input[@id='saveButton']");

    @Override
    public void waitPageLoaded() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER));
    }

    @Override
    public BasePage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    public void addRunningWorkout (){
        driver.findElement(RUNNING_BUTTON).click();
    }

    public void saveWorkout(){
        driver.findElement(SAVE_BUTTON).click();
    }

}
