package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pageobjects.CartPage;
import com.pageobjects.CheckoutPage;
import com.pageobjects.LoginPage;
import static org.testng.Assert.assertTrue;

public class CheckoutTest {

    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        loginPage = new LoginPage();
        loginPage.launchUrl(loginPage.getAppUrl());
        loginPage.maximizeWindow();
    }

    @Test
    public void testUserCheckoutProcess() {
        loginPage.enterUserName("validUser");
        loginPage.enterPassword("validPassword");
        loginPage.clickLoginButton();
        cartPage.addProductToCart();
        cartPage.openCart();
        cartPage.verifyProductInCart("ProductName");
        checkoutPage.proceedToCheckout();
        checkoutPage.enterShippingDetails("John Doe", "123 Elm St", "Springfield", "12345", "555-1234");
        checkoutPage.selectPaymentMethod("CreditCard");
        checkoutPage.placeOrder();
        assertTrue(checkoutPage.verifyOrderConfirmation("Order Confirmed"));
    }

    @AfterMethod
    public void tearDown() {
        // Code to close browser or clean up after test
    }
}