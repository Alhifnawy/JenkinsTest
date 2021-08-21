package org.example.Suite1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test2
{
    WebDriver driver;

    @Test
    public void Test2()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testautomationu.applitools.com/");
        Assert.assertEquals(driver.getTitle(),"Test Automation University | Applitools");
    }
}
