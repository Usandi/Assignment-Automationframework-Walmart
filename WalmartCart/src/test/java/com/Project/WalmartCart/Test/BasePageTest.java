package com.Project.WalmartCart.Test;

import com.Project.WalmartCart.Base.BasePage;
import com.Project.WalmartCart.Base.BaseSetUp;
import com.Project.WalmartCart.Pages.CartPage;
import com.Project.WalmartCart.Pages.ProductPage;
import com.Project.WalmartCart.Pages.SearchProductsPage;
import com.Project.WalmartCart.Pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*go to website - Walmart.com
 * search for infant toys, get page title and assert
 * check products, get number of items per page, number of pages and assert the info
 * start display item details and look for Fisher-Price products then click the first Fisher-Price product
 * get item number, item description and assert the info
 * add that product to cart, get page title
 * get the item description again
 * assert the item description if chosen product is added to the cart
 *
 * BasePage - search and click
 * SearchResultPage - get page title and assert
 * SearchProductsPage - get number of products per page, number of pages and assert
 * ProductPage - click the first specific product, get item number, item description, add to cart and assert info
 * CartPage - get page title, item description and assert if the chosen product is same as the product in the cart*/

public class BasePageTest extends BaseSetUp {
    BasePage basepage;

    @DataProvider(name="searchData") // data to search and assert page title
    public Object[][] sData() {
        return new String[][] { {"infant toys", "infant toys - Walmart.com"} };
    }

    @DataProvider(name="productsData") // data to assert number of items per page and number of pages
    public Object[][] pData() {
        return new Object[][] { {40, "25"} };
    }

    @DataProvider(name="productData") // data to assert item number and item description
    public Object[][] proData() {
        return new String[][] { {"Walmart # 579798970", "Fisher-Price Baby’s First Blocks & Rock-a-Stack, Plant-Based Toys"} };
    }

    @DataProvider(name="cartData") // data to assert cart page title and cart item description
    public Object[][] cData() {
        return new String[][] { {"Fisher-Price Baby’s First Blocks & Rock-a-Stack, Plant-Based Toys - Walmart.com - Walmart.com", "Fisher-Price Baby’s First Blocks & Rock-a-Stack, Plant-Based Toys"} };
    }

    @Test (dataProvider = "searchData")
    public void SearchResultPageTest(String searchWord, String expctedpgtitle) throws InterruptedException {
        basepage = new BasePage(driver);
        SearchResultPage srp = basepage.Search(searchWord);//SearchResultPage returned by search() from BasePage
        Assert.assertEquals(srp.getpgTitle(), expctedpgtitle);
    }

    @Test(dataProvider = "productsData", dependsOnMethods = {"SearchResultPageTest"})
    public void SearchProductsPageTest(int numproductsperpage, String tnumpages) throws InterruptedException {
        basepage = new BasePage(driver);
        SearchProductsPage spp = basepage.productsData();
        Object productsinfo[] = spp.getProductsData();
        Assert.assertEquals(productsinfo[0],numproductsperpage);
        Assert.assertEquals(productsinfo[1],tnumpages);
    }

    @Test(dataProvider = "productData", dependsOnMethods = {"SearchProductsPageTest"})
    public void ProductPageTest(String itemnum, String itemdes) throws InterruptedException {
        basepage = new BasePage(driver);
        ProductPage pp = basepage.productData();
        String productinfo[] = pp.getProductData();
        Assert.assertEquals(productinfo[0],itemnum);
        Assert.assertEquals(productinfo[1],itemdes);
    }

    @Test(dataProvider = "cartData", dependsOnMethods = {"ProductPageTest"})
    public void CartPageTest(String pgtitle, String cartitemdes) throws InterruptedException {
        basepage = new BasePage(driver);
        CartPage cp = basepage.cartData();
        String cartinfo[] = cp.getCartData();
        Assert.assertEquals(cartinfo[0],pgtitle);
        Assert.assertEquals(cartinfo[1],cartitemdes);
    }
}
