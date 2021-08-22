package org.example.Suite2;

import TestBase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test1 extends TestBase
{
    @Test
    public void Test1()
    {
        driver.get("https://www.google.com/ncr");
        Assert.assertEquals(driver.getTitle(),"Google");
    }
}
