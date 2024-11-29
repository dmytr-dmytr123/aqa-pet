package BO;

import PO.YoutubeThemePO;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import static driver.DriverProvider.getDriver;

public class YoutubeThemeBO {
    private static final Logger logger = LogManager.getLogger(YoutubeThemeBO.class);
    private final WebDriver driver = getDriver();
    private final YoutubeThemePO youtubeThemePO = new YoutubeThemePO(driver);

    @Step("Navigating to youtube home page")
    public YoutubeThemeBO goToYoutubeHomePage() {
        logger.info("navigating to youTube home page");
        driver.get("https://youtube.com/");
        return this;
    }

    @Step("Changing theme to dark")
    public boolean changeToDarkTheme() {
        logger.info("opening settings menu");
        youtubeThemePO.openSettingsMenu();

        logger.info("opening appearance settings");
        youtubeThemePO.openAppearanceSettings();

        logger.info("selecting dark theme");
        youtubeThemePO.selectDarkTheme();

        logger.info("dark theme selected successfully");
        return true;
    }
}
