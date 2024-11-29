package BO;

import PO.YoutubeLoginPO;
import org.openqa.selenium.WebDriver;

import static driver.DriverProvider.getDriver;

public class YoutubeLoginBO {
    private final WebDriver driver = getDriver();
    private final YoutubeLoginPO loginPO = new YoutubeLoginPO();

    public YoutubeLoginBO goToYoutubeHomePage() {
        driver.get("https://youtube.com/");
        return this;
    }

    public YoutubeLoginBO loginToYouTube(String email, String password) {
        loginPO.login(email, password);
        return this;
    }

    public boolean verifyLogin() {
        return loginPO.isUserLoggedIn();
    }
}
