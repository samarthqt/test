package com.cucumber.test_scripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import com.page_objects.CheckoutPage;
import com.framework.reusable.WebReusableComponents;
import org.testng.Assert;

public class PaymentOptionsTest extends WebReusableComponents {

    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUp() {
        checkoutPage = new CheckoutPage();
        checkoutPage.proceedToCheckout();
    }

    @Test
    public void verifyMultiplePaymentOptions() {
        Assert.assertTrue(checkoutPage.isCreditCardOptionAvailable(), "Credit card payment option is not displayed.");
        Assert.assertTrue(checkoutPage.isDebitCardOptionAvailable(), "Debit card payment option is not displayed.");
        Assert.assertTrue(checkoutPage.isPayPalOptionAvailable(), "PayPal payment option is not displayed.");

        checkoutPage.selectPaymentMethod("Credit Card");
        checkoutPage.enterCreditCardDetails("4111111111111111", "12/25", "123");
        checkoutPage.clickPayNow();

        Assert.assertTrue(checkoutPage.isPaymentConfirmationReceived(), "Payment confirmation notification not received.");
        Assert.assertTrue(checkoutPage.isPaymentTransactionLogged(), "Payment transaction is not logged.");
        Assert.assertTrue(checkoutPage.isPaymentInterfaceResponsive(), "Payment interface is not responsive.");
    }

    @AfterMethod
    public void tearDown() {
        // Add any necessary cleanup code here
    }
}