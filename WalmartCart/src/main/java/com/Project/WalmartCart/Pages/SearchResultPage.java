package com.Project.WalmartCart.Pages;

import com.Project.WalmartCart.Base.BasePage;
import com.Project.WalmartCart.Utils.WaitsUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public String getpgTitle() throws InterruptedException {
        Thread.sleep(500);
        //WaitsUtil.imwait(driver, 30, TimeUnit.SECONDS);

        return driver.getTitle(); // returns page title to SearchResultPageTest(BasePageTest)
    }
}
