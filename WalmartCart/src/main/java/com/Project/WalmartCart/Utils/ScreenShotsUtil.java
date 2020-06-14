package com.Project.WalmartCart.Utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenShotsUtil {
    public static void screenShots(String filename1, WebDriver driver) {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(file,new File("C:\\Usha\\WalmartCart\\src\\main\\Resources\\ScreenShots"+filename1+System.currentTimeMillis()+".png"));
            //C:\Usha\MyFaceAutomationFramework\Resources\ScreenShots\ScreenShotsSigninDataTest1590890128718.png
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
