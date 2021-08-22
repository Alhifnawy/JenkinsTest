package org.example.Suite1;

import TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test2 extends TestBase
{
    @Test
    public void Test2()
    {
        driver.get("https://testautomationu.applitools.com/");
        Assert.assertEquals(driver.getTitle(),"Test Automation University | Applitools");
    }
}
