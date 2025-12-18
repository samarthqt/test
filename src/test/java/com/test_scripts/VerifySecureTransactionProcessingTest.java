package com.cucumber.test_scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.page_objects.CheckoutPage;
import com.framework.reusable.WebReusableComponents;

public class VerifySecureTransactionProcessingTest extends WebReusableComponents {

    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUp() {
        initializeDriver();
        checkoutPage = new CheckoutPage();
    }

    @Test
    public void verifySecureTransactionProcessing() {
        checkoutPage.proceedToCheckout();
        checkoutPage.selectPaymentMethod("Credit Card");
        checkoutPage.enterCreditCardDetails("4111111111111111", "12/25", "123");
        checkoutPage.placeOrder();
        checkoutPage.verifyOrderConfirmation("Your order has been placed successfully.");
        // Additional assertions for secure transaction, logging, and responsiveness can be added here.
    }

    @AfterMethod
    public void tearDown() {
        closeDriver();
    }
}