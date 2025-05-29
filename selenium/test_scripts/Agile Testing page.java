package com.tests;

import com.pageobjects.CartPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.assertTrue;

public class CartManagementTest {

    private CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        cartPage = new CartPage();
        cartPage.navigateToProductDetailsPage();
    }

    @Test
    public void testAddProductToCart() {
        cartPage.addProductToCart();
        cartPage.openCart();
        assertTrue(cartPage.isProductInCart("Product Name"), "Product should be in the cart.");
    }

    @Test
    public void testUpdateProductQuantity() {
        cartPage.openCart();
        cartPage.updateProductQuantity("2");
        assertTrue(cartPage.isProductQuantityUpdated("2"), "Product quantity should be updated.");
    }

    @Test
    public void testRemoveProductFromCart() {
        cartPage.openCart();
        cartPage.removeProductFromCart();
        assertTrue(cartPage.isCartEmpty(), "Cart should be empty.");
    }

    @AfterMethod
    public void tearDown() {
        cartPage.closeBrowser();
    }
}