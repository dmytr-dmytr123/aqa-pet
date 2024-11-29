package ui;

import BO.YoutubeLoginBO;
import driver.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.PropertyReader;

public class YoutubeLoginTest {

    @Test
    public void testYoutubeLogin() {

        YoutubeLoginBO loginBO=new YoutubeLoginBO();

        //get properties
        String login = (String) new PropertyReader().getProperty("login");
        String pass = (String) new PropertyReader().getProperty("pass");

        //login
        loginBO.loginToYouTube(login, pass);

        //verify login
        boolean isLoggedIn = loginBO.verifyLogin();
        Assert.assertTrue(isLoggedIn, "Login failed!");
    }

}
