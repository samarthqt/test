package com.cucumber.test_scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.page_objects.CheckoutPage;
import com.framework.cucumber.TestHarness;

public class NotificationsTest {

    private CheckoutPage checkoutPage;
    private TestHarness testHarness;

    @BeforeMethod
    public void setUp() {
        testHarness = new TestHarness();
        checkoutPage = new CheckoutPage();
    }

    @Test
    public void testSuccessfulInformationEntry() {
        String fullName = testHarness.getData("CheckoutData", "FullName");
        String address = testHarness.getData("CheckoutData", "Address");
        String city = testHarness.getData("CheckoutData", "City");
        String postalCode = testHarness.getData("CheckoutData", "PostalCode");
        String phone = testHarness.getData("CheckoutData", "Phone");
        String paymentMethod = testHarness.getData("CheckoutData", "PaymentMethod");
        String expectedMessage = testHarness.getData("CheckoutData", "ExpectedConfirmationMessage");

        checkoutPage.enterShippingDetails(fullName, address, city, postalCode, phone);
        checkoutPage.selectPaymentMethod(paymentMethod);
        checkoutPage.placeOrder();
        checkoutPage.verifyOrderConfirmation(expectedMessage);
    }

    @AfterMethod
    public void tearDown() {
        // Add any necessary cleanup code here
    }
}