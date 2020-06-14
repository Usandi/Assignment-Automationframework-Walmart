package com.Project.WalmartCart.Base;

import com.Project.WalmartCart.Utils.ConfigUtil;
import com.Project.WalmartCart.Utils.Constants;
import com.Project.WalmartCart.Utils.ScreenShotsUtil;
import com.Project.WalmartCart.Utils.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public class BaseSetUp {
    protected WebDriver driver;
    protected static String url;
    protected static String browser;

    @BeforeSuite
    public void beforeSuite() throws IOException {
        ConfigUtil cutil = new ConfigUtil( Constants.RESOURCES_PATH + "/Test-Suites"+"/Config.Properties");

        url = cutil.getProperty("stageUrl");
        browser = cutil.getProperty("browser");
    }

    @BeforeTest
    public void initializedriver() {
        driver = WebDriverUtil.getDriver(browser);// getDriver() from WebdriverHelper class
        driver.get(url);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @AfterMethod // take screen shots when test fails
    public void takeScreenShots(ITestResult testresults) {
        if (ITestResult.FAILURE == testresults.getStatus()) {
            ScreenShotsUtil.screenShots(testresults.getName(),driver);
        }
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit(); // close all the windows
    }
}
