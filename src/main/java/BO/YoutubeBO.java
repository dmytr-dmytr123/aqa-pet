package BO;

import PO.YoutubeSearchPO;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static driver.DriverProvider.getDriver;

public class YoutubeBO {
    private final WebDriver driver = getDriver();
    private final YoutubeSearchPO youtubeSearchPO = new YoutubeSearchPO();
    @Step("Search for query")
    public YoutubeBO search(String query) {
        driver.get("https://youtube.com/");
        youtubeSearchPO.search(query);
        return this;
    }
    @Step("Check if search results are displayed")
    public void checkResults() {
        try {
            Thread.sleep(2000);
            WebElement results = driver.findElement(By.id("contents"));
            if (results.isDisplayed()) {
                System.out.println("results displayed");
            } else {
                System.out.println("no found");
            }
        } catch (Exception e) {
            System.out.println("error while checking the results: " + e.getMessage());
        }
    }
    @Step("Play the first video from search results")
    public void playFirstVideo() {
        youtubeSearchPO.runFirstVideo();
    }





}
