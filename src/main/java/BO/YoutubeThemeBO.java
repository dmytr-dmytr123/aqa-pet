package BO;

import PO.YoutubeThemePO;
import org.openqa.selenium.WebDriver;

import static driver.DriverProvider.getDriver;

public class YoutubeThemeBO {
    private final WebDriver driver = getDriver();
    private final YoutubeThemePO youtubeThemePO = new YoutubeThemePO(driver);

    public YoutubeThemeBO goToYoutubeHomePage() {
        driver.get("https://youtube.com/");
        return this;
    }
    public boolean changeToDarkTheme() {
        youtubeThemePO.openSettingsMenu();
        youtubeThemePO.openAppearanceSettings();
        youtubeThemePO.selectDarkTheme();
        return true;
    }
}
