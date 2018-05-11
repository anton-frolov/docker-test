package com.example.docker.test;
/**
 * Created by frolov on 02.05.2018.
 */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClientTest {
    private WebDriver driver;
    String url = "http://192.168.99.100:8080/docker-test/";

    @Ignore
    @BeforeClass
    public void setUp() throws IOException{


        System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        //driver = new InternetExplorerDriver();
        driver.manage().window();
    }


    @Ignore
    @Test
    public void verifyMainPageTittle() {
        driver.navigate().to(url);
        String getTitle = driver.getTitle();
        Assert.assertTrue(getTitle.equalsIgnoreCase("test docker"));
    }

    @Ignore
    @AfterClass
    public void tearDown() {
        if(driver!=null) {
            driver.quit();
        }
    }
}
