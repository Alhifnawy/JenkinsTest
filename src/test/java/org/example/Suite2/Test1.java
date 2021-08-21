package org.example.Suite2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test1
{
    WebDriver driver;

    @Test
    public void Test1()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/ncr");
        Assert.assertEquals(driver.getTitle(),"Google");
    }
}
