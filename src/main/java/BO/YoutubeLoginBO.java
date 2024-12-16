package BO;

import PO.YoutubeLoginPO;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IExecutionListener;
import org.testng.ISuiteListener;
import org.testng.ITestListener;

import static driver.DriverProvider.getDriver;

public class YoutubeLoginBO implements ITestListener, ISuiteListener, IExecutionListener {
    private final WebDriver driver = getDriver();
    private final YoutubeLoginPO loginPO = new YoutubeLoginPO();
    private static final Logger logger = LogManager.getLogger(YoutubeLoginBO.class);

    @Step("Navigating to youtube home page")
    public YoutubeLoginBO goToYoutubeHomePage() {
        logger.info("Navigating to YouTube home page");
        driver.get("https://youtube.com/");
        return this;
    }

    @Step("Logging in with email")
    public YoutubeLoginBO loginToYouTube(String email, String password) {
        logger.info("starting login process for user: {}", email);
        loginPO.login(email, password);
        logger.info("login process completed for user: {}", email);
        return this;
    }

    @Step("Verifying login status")
    public boolean verifyLogin() {
        logger.info("verifying if the user is logged in");
        boolean isLoggedIn = loginPO.isUserLoggedIn();
        logger.info("user login status: {}", isLoggedIn ? "logged In" : "not logged in");
        return isLoggedIn;
    }
}
