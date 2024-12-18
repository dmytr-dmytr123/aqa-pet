package allure;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

import static allure.AllureHelper.attachHtml;
import static allure.AllureHelper.attachScreenshot;
import static driver.DriverProvider.getDriver;

public class AllureMethodListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriver driver = getDriver();
            attachScreenshot(driver, "before method execution: " + method.getTestMethod().getMethodName());
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            WebDriver driver = getDriver();
            attachScreenshot(driver, "after method execution: " + method.getTestMethod().getMethodName());
            attachHtml("page source", driver.getPageSource());
        }
    }
}
