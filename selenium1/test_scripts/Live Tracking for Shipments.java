package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pageobjects.CartPage;
import static org.testng.Assert.*;

public class CartManagementTest {

    private CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        cartPage = new CartPage();
        cartPage.openCart();
    }

    @Test
    public void testAddProductToCart() {
        cartPage.addProductToCart();
        cartPage.verifyProductInCart("Sample Product");
    }

    @Test
    public void testUpdateProductQuantity() {
        cartPage.updateProductQuantity("2");
        cartPage.verifyProductQuantity("2");
    }

    @Test
    public void testRemoveProductFromCart() {
        cartPage.removeProductFromCart();
        cartPage.verifyCartIsEmpty();
    }

    @AfterMethod
    public void tearDown() {
        // Code to close browser or clean up after tests
    }
}