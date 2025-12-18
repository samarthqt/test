package com.cucumber.test_scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.page_objects.CheckoutPage;
import com.framework.reusable.WebReusableComponents;
import org.testng.Assert;

public class PaymentFailureTest extends WebReusableComponents {

    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUp() {
        checkoutPage = new CheckoutPage();
        navigateToCart();
    }

    @Test
    public void verifyErrorHandlingForPaymentFailures() {
        checkoutPage.proceedToCheckout();
        checkoutPage.selectPaymentMethod("Credit Card");
        checkoutPage.enterCreditCardDetails("4111111111111111", "12/25", "123");
        simulatePaymentGatewayFailure();
        checkoutPage.clickPayNow();
        String errorMessage = checkoutPage.getPaymentFailureMessage();
        Assert.assertEquals(errorMessage, "Payment failed. Please try again.", "Error message does not match.");
        boolean canRetry = checkoutPage.canRetryPayment();
        Assert.assertTrue(canRetry, "User is not allowed to retry payment.");
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }

    private void simulatePaymentGatewayFailure() {
        // Logic to simulate payment gateway failure
    }

    private void navigateToCart() {
        // Logic to navigate to the shopping cart
    }

    private void closeBrowser() {
        // Logic to close the browser
    }
}