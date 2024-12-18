package allure;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class AllureHelper {
    public static void attachScreenshot(WebDriver driver, String name) {
        if (driver instanceof TakesScreenshot) {
            Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
    }
    public static void attachHtml(String name, String content) {
        Allure.addAttachment(name, "text/html", content, ".html");
    }
}
