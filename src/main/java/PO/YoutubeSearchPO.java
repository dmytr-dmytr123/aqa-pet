package PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static driver.DriverProvider.getDriver;

public class YoutubeSearchPO {
    private WebDriver driver = getDriver();

    @FindBy(name = "search_query")
    private WebElement searchBox;

    public YoutubeSearchPO() {
        PageFactory.initElements(driver, this);
    }

    public void search(String query) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.clear();
        searchBox.sendKeys(query);
        searchBox.submit();
    }
    public void runFirstVideo() {
        String firstVideoXPath = "(//ytd-video-renderer//a[@id='video-title'])[1]";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Adjust timeout as needed
        WebElement firstVideo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(firstVideoXPath)));
        firstVideo.click();
    }

}
