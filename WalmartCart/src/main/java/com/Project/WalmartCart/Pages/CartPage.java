package com.Project.WalmartCart.Pages;

import com.Project.WalmartCart.Utils.LoggerListener;
import com.Project.WalmartCart.Utils.WaitsUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage extends ProductPage{
    private static Logger log = LogManager.getLogger(LoggerListener.class); // initialize the logger

    @FindBy(how = How.CSS, using = ".js-product-title [href]")
    WebElement cartItemDescription;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);// to initialize all web elements
    }

    public String[] getCartData() {
        String cartitemdescription = null;
        String title = driver.getTitle(); // get cart page title
        log.info("The page title for the item you selected is : "+title);
        WaitsUtil.exwait(driver, 30, cartItemDescription);
        cartitemdescription = cartItemDescription.getText(); // get item description added to the cart
        log.info("The item you added to cart is :"+cartitemdescription);

        return new String[] {title, cartitemdescription}; //returns page title and cart item description to CartPageTest(BasePageTest)
    }
}
