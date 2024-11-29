package ui;

import BO.YoutubeBO;
import BO.YoutubeThemeBO;
import driver.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class YoutubeThemeTest {

    @Test
    public void testChangeToDarkThemeUnlogged() {
        //change theme and verify
        YoutubeThemeBO themeBO = new YoutubeThemeBO();
        Assert.assertTrue(themeBO.goToYoutubeHomePage().changeToDarkTheme(),"change theme Failed!");

    }


}
