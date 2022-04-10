package finalsurge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.MainStep;
import utils.CapabilitiesGenerator;
import utils.PropertyUtils;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected MainStep mainStep;


    @BeforeMethod
    public void setup() {
        System.out.println(System.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        mainStep = new MainStep(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
