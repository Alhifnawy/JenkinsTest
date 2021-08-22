package org.example.Suite2;

import Listeners.TestListeners;
import TestBase.TestBase;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import static utils.ExtentReports.ExtentTestManager.startTest;

@Listeners({TestListeners.class})
public class Test1 extends TestBase
{
    @Test(description = "This test goes to Google Website")
    @Description("Google Website test case")
    public void Test1(Method method)
    {
        startTest(method.getName(), "Google Website test case.");

        driver.get("https://www.google.com/ncr");
        Assert.assertEquals(driver.getTitle(),"Google");
    }
}
