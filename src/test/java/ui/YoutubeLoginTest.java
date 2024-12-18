package ui;

import BO.YoutubeLoginBO;
import allure.AllureMethodListener;
import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import driver.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import util.PropertyReader;

@Listeners({YoutubeLoginBO.class, UniversalVideoListener.class, AllureMethodListener.class})
public class YoutubeLoginTest {

    @DataProvider(name = "loginDataProvider")
    public Object[][] loginDataProvider() {
        return new Object[][] {
                {"rogrogned@gmail.com", "passsuper"},

        };
    }

    @Test(dataProvider = "loginDataProvider")
    @Video
    public void testYoutubeLogin(String username, String password) {
        YoutubeLoginBO loginBO = new YoutubeLoginBO();

        loginBO.loginToYouTube(username, password);

        boolean isLoggedIn = loginBO.verifyLogin();
        Assert.assertTrue(isLoggedIn, "Login failed for user: " + username);
    }
}

