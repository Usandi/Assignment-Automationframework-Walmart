package com.Project.WalmartCart.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitsUtil {
    //private static Logger log = LogManager.getLogger(ExcelHelper.class);

    public static WebElement exwait(WebDriver driver, long timeInSecs, WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeInSecs);
            element = wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            //log.error("Explicity wait for element ");
            //log.error(e.getMessage());
        }
        return element;
    }
    public static void imwait(WebDriver driver, long timeInSecs, TimeUnit unit) {
        driver.manage().timeouts().implicitlyWait(timeInSecs,unit);
    }
}
