package com.Project.WalmartCart.Base;

import com.Project.WalmartCart.Pages.CartPage;
import com.Project.WalmartCart.Pages.ProductPage;
import com.Project.WalmartCart.Pages.SearchProductsPage;
import com.Project.WalmartCart.Pages.SearchResultPage;
import com.Project.WalmartCart.Utils.WaitsUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {
    protected WebDriver driver;

    //factory annotations
    @FindBy(how = How.ID,using = "global-search-input")
    WebElement searchbox;
    @FindBy(how = How.ID,using = "global-search-submit")
    WebElement searchbutton;

    public BasePage(WebDriver driver) { //constructor
        this.driver = driver; //initialize the driver object
        PageFactory.initElements(driver, this);
    }

    public SearchResultPage Search(String searchProducts) throws InterruptedException { //returns SearchResultsPage
        searchbox.sendKeys(searchProducts); // search website
        WaitsUtil.exwait(driver,20, searchbutton);
        searchbutton.click(); // click search button
        return new SearchResultPage(driver);
    }

    public SearchProductsPage productsData() {
        return new SearchProductsPage(driver);
    }

    public ProductPage productData() {
        return new ProductPage(driver);
    }

    public CartPage cartData() {
        return new CartPage(driver);
    }
}
