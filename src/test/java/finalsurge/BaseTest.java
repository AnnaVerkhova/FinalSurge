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
        String driverPath = PropertyUtils.getEnv("mac_driver_path");
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        options.addArguments("--disable-notifications");
//        options.addArguments("--ignore-popup-blocking");
//        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        mainStep = new MainStep(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
