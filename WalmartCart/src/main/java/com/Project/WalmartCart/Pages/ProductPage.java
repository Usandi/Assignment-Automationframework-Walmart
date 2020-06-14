package com.Project.WalmartCart.Pages;

import com.Project.WalmartCart.Base.BasePage;
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

public class ProductPage extends SearchProductsPage {
    private static Logger log = LogManager.getLogger(LoggerListener.class);

    @FindBy(how = How.CSS, using = ".wm-item-number")
    WebElement itemNumber;
    @FindBy(how = How.CSS, using = "h1")
    WebElement itemDescription;
    @FindBy(how = How.CSS, using = ".spin-button-children")
    WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String[] getProductData() {
        String itemnumber = null;
        String itemdescription = null;
        for (WebElement p: super.products) { // iterate thru the products
            log.info(p.getText() + "\n"); // dispaly item description
            String text = p.getText(); //item descriptions dispalyed
            if (text.contains("Fisher-Price")) {
                products.get(1).click();
                itemnumber = itemNumber.getText(); // get item number
                WaitsUtil.exwait(driver, 30, itemDescription);
                itemdescription = itemDescription.getText(); // item description
                log.info("Item description for the selected item before cart is :" + itemDescription.getText());
                WaitsUtil.exwait(driver, 30, addToCartButton);
                addToCartButton.click();
                break;
            }
        }
        return new String[] {itemnumber, itemdescription}; // returns to ProductPageTest(BasePageTest)
    }
}
