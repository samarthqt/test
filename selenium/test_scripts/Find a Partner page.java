package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pageobjects.CheckoutPage;
import com.framework.reusable.WebReusableComponents;

public class CheckoutTest extends WebReusableComponents {

    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUp() {
        launchUrl(getAppUrl() + "/cart");
        checkoutPage = new CheckoutPage();
    }

    @Test
    public void testSuccessfulCheckout() {
        checkoutPage.proceedToCheckout();
        checkoutPage.enterShippingDetails("John Doe", "123 Elm St", "Springfield", "12345", "555-1234");
        checkoutPage.selectPaymentMethod("CreditCard");
        checkoutPage.placeOrder();
        checkoutPage.verifyOrderConfirmation("Your order has been placed successfully.");
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}