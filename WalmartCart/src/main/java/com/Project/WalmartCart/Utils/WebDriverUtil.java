package com.Project.WalmartCart.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtil {
    //private static Logger log = LogManager.getLogger(ExcelHelper.class);

    //Factory design pattern
    public static WebDriver getDriver(String browsername) {
        WebDriver driver;

        switch (browsername) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", Constants.RESOURCES_PATH +"\\DriversToBeUsed\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", Constants.RESOURCES_PATH +"\\DriversToBeUsed\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                System.setProperty("webdriver.gecko.driver", Constants.RESOURCES_PATH +"\\DriversToBeUsed\\geckodriver.exe");
                driver = new FirefoxDriver();
        }
        return driver;
    }
}
