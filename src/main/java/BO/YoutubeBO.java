package BO;

import PO.YoutubeSearchPO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static driver.DriverProvider.getDriver;

public class YoutubeBO {
    private final WebDriver driver = getDriver();
    private final YoutubeSearchPO youtubeSearchPO = new YoutubeSearchPO();

    public YoutubeBO search(String query) {
        driver.get("https://youtube.com/");
        youtubeSearchPO.search(query);
        return this;
    }

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
    public void playFirstVideo() {
        youtubeSearchPO.runFirstVideo();
    }

}
