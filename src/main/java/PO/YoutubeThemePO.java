package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YoutubeThemePO {
    private WebDriver driver;

    @FindBy(xpath = "//yt-icon-button[@id='button']\n")
    private WebElement settingsButton;

    @FindBy(xpath = "//ytd-popup-container//ytd-toggle-theme-compact-link-renderer\n")
    private WebElement appearanceOption;

    @FindBy(xpath = "//yt-formatted-string[text()='Темна тема']")
    private WebElement darkThemeOption;

    public YoutubeThemePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openSettingsMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(settingsButton)).click();
    }

    public void openAppearanceSettings() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(appearanceOption)).click();
    }

    public void selectDarkTheme() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(darkThemeOption)).click();
    }
}
