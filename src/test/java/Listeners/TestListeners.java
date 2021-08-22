package Listeners;

import TestBase.TestBase;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.Objects;

import static utils.ExtentReports.ExtentTestManager.getTest;
import static utils.ExtentReports.ManagerExtent.getExtentReports;

public class TestListeners extends TestBase implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message){
        return message;
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        iTestContext.setAttribute("WebDriver", this.driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        getExtentReports().flush();
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        //ExtentReports log operation for passed tests.
        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((TestBase) testClass).getDriver();

        //Allure ScreenShotRobot and SaveTestLog
        if (driver instanceof WebDriver) {
            Allure.addAttachment(getTestMethodName(iTestResult),
                    new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        }

        //Save a log on allure.
        saveTextLog(getTestMethodName(iTestResult) + " Succeeded and screenshot taken!");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((TestBase) testClass).getDriver();


        //Allure ScreenShotRobot and SaveTestLog
        if (driver instanceof WebDriver) {
            Allure.addAttachment(getTestMethodName(iTestResult),
                    new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        }
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
    }
}
