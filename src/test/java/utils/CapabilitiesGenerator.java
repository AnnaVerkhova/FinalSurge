package utils;

import org.openqa.selenium.chrome.ChromeOptions;

public class CapabilitiesGenerator {

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        String driverPath = "src/test/resources/webDrivers";
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println("Operational system: " + os + "; Driver path: " + driverPath);
        if (os.contains("win")) {
            System.setProperty("webdriver.chrome.driver", driverPath + "/Windows/chromedriver.exe");
        } else if (os.contains("webDrivers/mac")) {
            System.setProperty("webdriver.chrome.driver", driverPath + "/MAC/chromedriver");
        }
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        //options.addArguments("--headless"); // only if you are ACTUALLY running headless
        //options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
        //options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
        //options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
        //options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
        //options.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
        return options;
    }

}