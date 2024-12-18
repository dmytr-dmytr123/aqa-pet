package ui;

import BO.YoutubeBO;
import BO.YoutubeThemeBO;
import allure.AllureMethodListener;
import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import driver.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({YoutubeThemeBO.class, UniversalVideoListener.class, AllureMethodListener.class})
public class YoutubeThemeTest {
    @Test
    @Video
    public void testChangeToDarkThemeUnlogged() {
        //change theme and verify
        YoutubeThemeBO themeBO = new YoutubeThemeBO();
        Assert.assertTrue(themeBO.goToYoutubeHomePage().changeToDarkTheme(),"change theme Failed!");

    }


}
