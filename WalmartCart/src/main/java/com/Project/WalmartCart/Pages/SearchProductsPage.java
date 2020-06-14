package com.Project.WalmartCart.Pages;

import com.Project.WalmartCart.Base.BasePage;
import com.Project.WalmartCart.Utils.LoggerListener;
import com.Project.WalmartCart.Utils.WaitsUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchProductsPage extends BasePage {
    private static Logger log = LogManager.getLogger(LoggerListener.class);

    @FindBy(how = How.CSS, using = "#searchProductResult > ul > li")
    List<WebElement> products;
    @FindBy(how = How.CSS, using = "#mainSearchContent > div:nth-child(3) > div.paginator.outline > ul > li:nth-child(8) > a")
    WebElement numberofPages;


    public SearchProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Object[] getProductsData() throws InterruptedException {
        Thread.sleep(500);
        //WaitsUtil.imwait(driver,30, TimeUnit.SECONDS);
        int results = products.size(); // number of products dispalyed per page
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollBy(0,200)");
        //WaitsUtil.exwait(driver,30, numberofPages);
        String numpages = numberofPages.getText(); // total number of pages
        log.info("There are "+ results+ " products displayed in this page");
        log.info(numpages+ " pages were resulted with the search");

        return new Object[] {results,numpages};// returns to SearchProductsPageTest(BasePageTest)
    }

}
