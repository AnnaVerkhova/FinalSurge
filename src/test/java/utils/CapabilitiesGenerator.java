package utils;

import org.openqa.selenium.chrome.ChromeOptions;

public class CapabilitiesGenerator {

    public static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        String os = System.getProperty("os.name").toLowerCase();
        String driverPath= null;
        if (os.contains("win")) {
            driverPath = PropertyUtils.getEnv("win_driver_path");
            System.setProperty("webdriver.chrome.driver", driverPath);
        } else if (os.contains("mac")) {
            driverPath = PropertyUtils.getEnv("mac_driver_path");
            System.setProperty("webdriver.chrome.driver", driverPath);
        }

        System.out.println("Operational system: " + os + "; Driver path: " + driverPath);
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
         options.addArguments("--headless"); // only if you are ACTUALLY running headless
        //options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
        //options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
        //options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
        //options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
        //options.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
        return options;
    }
}
