package com.cucumber.test_scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.page_objects.CheckoutPage;
import com.framework.reusable.WebReusableComponents;
import org.testng.Assert;

public class ErrorHandlingTest extends WebReusableComponents {

    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUp() {
        checkoutPage = new CheckoutPage();
        launchApplication();
    }

    @Test
    public void testIncompleteShippingAddress() {
        checkoutPage.proceedToCheckout();
        checkoutPage.enterShippingDetails("", "", "", "", "");
        checkoutPage.placeOrder();
        String errorMessage = checkoutPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Shipping address is incomplete.", "Error message for incomplete shipping address does not match.");
    }

    @Test
    public void testIncompleteBillingAddress() {
        checkoutPage.proceedToCheckout();
        checkoutPage.enterBillingDetails("", "", "", "", "");
        checkoutPage.placeOrder();
        String errorMessage = checkoutPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Billing address is incomplete.", "Error message for incomplete billing address does not match.");
    }

    @Test
    public void testIncompletePaymentDetails() {
        checkoutPage.proceedToCheckout();
        checkoutPage.selectPaymentMethod("");
        checkoutPage.placeOrder();
        String errorMessage = checkoutPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Payment details are incomplete.", "Error message for incomplete payment details does not match.");
    }

    @AfterMethod
    public void tearDown() {
        closeApplication();
    }
}