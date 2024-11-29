package PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static driver.DriverProvider.getDriver;

public class YoutubeLoginPO {
    private final WebDriver driver = getDriver();

    @FindBy(xpath = "//a[contains(@href, 'ServiceLogin')]")
    private WebElement signInButton;

    @FindBy(id = "identifierId")
    private WebElement emailInput;

    @FindBy(xpath = "//span[contains(text(),'Next') or contains(text(),'Далі')]")
    private WebElement nextButton;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//ytd-topbar-menu-button-renderer[@id='avatar-btn']")
    private WebElement avatarButton;

    public YoutubeLoginPO() {
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();

        wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();

        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    public boolean isUserLoggedIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOf(avatarButton)).isDisplayed();
    }
}
