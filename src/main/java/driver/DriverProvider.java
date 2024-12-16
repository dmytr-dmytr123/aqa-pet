package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.PropertyReader;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverProvider {
    private static WebDriver driver;


    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = PropertyReader.getProperty("browser");
            if (browser == null || browser.isEmpty()) {
                browser = "chrome";
            }

            switch (browser.toLowerCase()) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    options.addPreference("general.useragent.override", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) Gecko/20100101 Firefox/89.0");
                    driver = new FirefoxDriver(options);
                    break;
                }

                case "chrome": {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-blink-features=AutomationControlled");
                    options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                    options.setExperimentalOption("useAutomationExtension", false);
                    options.addArguments("--disable-popup-blocking");
                    options.addArguments("--incognito");
                    options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.4577.63 Safari/537.36");

                    driver = new ChromeDriver(options);
                    break;
                }

            }

            driver.manage().window().maximize();
        }
        return driver;
    }


    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
