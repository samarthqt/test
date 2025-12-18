package com.cucumber.test_scripts;

import com.page_objects.CheckoutPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class ValidationOfAddressAndPaymentDetailsTest {

    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUp() {
        checkoutPage = new CheckoutPage();
    }

    @Test
    public void testInvalidShippingAddress() {
        checkoutPage.enterShippingDetails("", "", "", "", "");
        assertTrue(checkoutPage.isErrorMessageDisplayed("Invalid shipping address"), "Error message for invalid shipping address not displayed.");
    }

    @Test
    public void testInvalidBillingAddress() {
        checkoutPage.enterBillingDetails("", "", "", "", "");
        assertTrue(checkoutPage.isErrorMessageDisplayed("Invalid billing address"), "Error message for invalid billing address not displayed.");
    }

    @Test
    public void testInvalidPaymentMethodDetails() {
        checkoutPage.enterPaymentDetails("", "", "", "");
        assertTrue(checkoutPage.isErrorMessageDisplayed("Invalid payment details"), "Error message for invalid payment details not displayed.");
    }

    @Test
    public void testCorrectShippingAddress() {
        checkoutPage.enterShippingDetails("John Doe", "123 Elm St", "Springfield", "12345", "555-1234");
        assertTrue(checkoutPage.isShippingAddressAccepted(), "Shipping address not accepted.");
    }

    @Test
    public void testCorrectBillingAddress() {
        checkoutPage.enterBillingDetails("John Doe", "123 Elm St", "Springfield", "12345", "555-1234");
        assertTrue(checkoutPage.isBillingAddressAccepted(), "Billing address not accepted.");
    }

    @Test
    public void testCorrectPaymentMethodDetails() {
        checkoutPage.enterPaymentDetails("4111111111111111", "John Doe", "12/25", "123");
        assertTrue(checkoutPage.isPaymentDetailsAccepted(), "Payment details not accepted.");
    }

    @AfterMethod
    public void tearDown() {
        // Clean up resources
    }
}