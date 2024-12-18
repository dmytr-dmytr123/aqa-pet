package BO;

import PO.YoutubeSearchPO;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IExecutionListener;
import org.testng.ISuiteListener;
import org.testng.ITestListener;

import java.io.ByteArrayInputStream;
import java.time.Duration;

import static allure.AllureHelper.attachHtml;
import static allure.AllureHelper.attachScreenshot;
import static driver.DriverProvider.getDriver;

public class YoutubeBO implements ITestListener, ISuiteListener, IExecutionListener {
    private final WebDriver driver = getDriver();
    private static final Logger logger = LogManager.getLogger(YoutubeBO.class);
    private final YoutubeSearchPO youtubeSearchPO = new YoutubeSearchPO();
    @Step("Search for query")
    public YoutubeBO search(String query) {
        logger.info("Navigating to YouTube home page");
        driver.get("https://youtube.com/");
        youtubeSearchPO.search(query);

        return this;
    }
    @Step("Check if search results are displayed")
    public void checkResults() {
        logger.info("check results");

        try {
            Thread.sleep(2000);
            WebElement results = driver.findElement(By.id("contents"));
            if (results.isDisplayed()) {
                System.out.println("results displayed");
            } else {
                System.out.println("no found");
            }
        } catch (Exception e) {
            logger.info("error checking results");

            System.out.println("error while checking the results: " + e.getMessage());
        }

    }
    @Step("Play the first video from search results")
    public void playFirstVideo() {
        logger.info("run first video");
        youtubeSearchPO.runFirstVideo();

    }






}
