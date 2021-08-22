package org.example.Suite1;

import Listeners.TestListeners;
import TestBase.TestBase;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import static utils.ExtentReports.ExtentTestManager.startTest;

@Listeners({TestListeners.class})
public class Test2 extends TestBase
{
    @Test(description = "This test goes to TAU Website")
    @Description("Test Automation University Website test case")
    public void Test2(Method method)
    {
        startTest(method.getName(), "Test Automation University Website test case.");

        driver.get("https://testautomationu.applitools.com/");
        Assert.assertEquals(driver.getTitle(),"Test Automation University | Applitools");
    }
}
