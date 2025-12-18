package com.cucumber.test_scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.page_objects.ProductListingPage;
import com.page_objects.CartPage;
import com.framework.reusable.WebReusableComponents;

public class AddProductToCartTest extends WebReusableComponents {

    private ProductListingPage productListingPage;
    private CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        productListingPage = new ProductListingPage();
        cartPage = new CartPage();
        navigateToPage("http://example.com/product-listing");
    }

    @Test
    public void testAddProductToCart() {
        productListingPage.selectProductById("101");
        productListingPage.addToCart();
        cartPage.openCart();
        cartPage.verifyProductDetailsInCart("Product Name", "1", "100.00");
        cartPage.verifySubtotalCalculation("100.00");
        cartPage.verifySuccessNotification();
        cartPage.verifyInventoryIntegration("101", 1);
        cartPage.verifyActionLogging();
        cartPage.verifyMobileInterface();
        cartPage.verifySecurityMeasures();
        logOutAndLogIn();
        cartPage.verifyCartPersistence("Product Name");
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }

    private void logOutAndLogIn() {
        // Implement logout and login logic
    }
}