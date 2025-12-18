package com.cucumber.test_scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.page_objects.CheckoutPage;
import com.framework.reusable.WebReusableComponents;
import static org.testng.Assert.assertTrue;

public class CheckoutTest extends WebReusableComponents {

    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUp() {
        checkoutPage = new CheckoutPage();
        navigateToCheckoutPage();
    }

    @Test
    public void testEnterValidShippingAndBillingInformation() {
        checkoutPage.enterShippingDetails("John Doe", "123 Elm St", "Springfield", "12345", "555-1234");
        checkoutPage.enterBillingDetails("John Doe", "123 Elm St", "Springfield", "12345", "555-1234");
        checkoutPage.enterPaymentMethodDetails("Credit Card", "4111111111111111", "12/25", "123");
        checkoutPage.proceedToPayment();
        assertTrue(checkoutPage.isConfirmationPageDisplayed(), "Confirmation page is not displayed.");
        assertTrue(checkoutPage.isInformationCorrect("John Doe", "123 Elm St", "Springfield", "12345", "555-1234"), "Information is not displayed correctly.");
        checkoutPage.submitOrder();
        assertTrue(checkoutPage.isOrderConfirmed(), "Order was not confirmed.");
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }

    private void navigateToCheckoutPage() {
        // Logic to navigate to checkout page
    }
}