package com.cucumber.test_scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.page_objects.CheckoutPage;
import com.framework.reusable.WebReusableComponents;

public class AutoFillOptionsTest extends WebReusableComponents {

    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setUp() {
        checkoutPage = new CheckoutPage();
        navigateToCheckoutPage();
    }

    @Test
    public void testAutoFillOptionsForSavedAddresses() {
        checkoutPage.clickOnShippingAddressField();
        checkoutPage.verifyAutoFillSuggestionsDisplayed();
        checkoutPage.selectSavedAddressFromSuggestions();
        checkoutPage.verifyShippingFieldsAutoFilled();

        checkoutPage.clickOnBillingAddressField();
        checkoutPage.verifyAutoFillSuggestionsDisplayed();
        checkoutPage.selectSavedAddressFromSuggestions();
        checkoutPage.verifyBillingFieldsAutoFilled();
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }

    private void navigateToCheckoutPage() {
        // Logic to navigate to the checkout page
    }

    private void closeBrowser() {
        // Logic to close the browser
    }
}