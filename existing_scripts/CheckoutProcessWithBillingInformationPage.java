package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class CheckoutProcessWithBillingInformationPage extends WebReusableComponents {

    protected By btnLogin = By.id("loginButton");
    protected By btnProceedToCheckout = By.id("proceedToCheckout");
    protected By shippingInfo = By.id("shippingInfo");
    protected By billingInfo = By.id("billingInfo");
    protected By btnProceedToPayment = By.id("proceedToPayment");
    protected By paymentPage = By.id("paymentPage");
    protected By orderPlacement = By.id("orderPlacement");
    protected By billingError = By.id("billingError");

    public void loginUser() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void navigateToShoppingCart() {
        waitUntilElementVisible(By.id("shoppingCart"), 3);
        clickElement(By.id("shoppingCart"));
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout, 3);
        clickElement(btnProceedToCheckout);
    }

    public void enterShippingInformation() {
        waitUntilElementVisible(shippingInfo, 3);
        enterText(shippingInfo, "Valid shipping information");
    }

    public void enterBillingInformation() {
        waitUntilElementVisible(billingInfo, 3);
        enterText(billingInfo, "Valid billing information");
    }

    public void proceedToPayment() {
        waitUntilElementVisible(btnProceedToPayment, 3);
        clickElement(btnProceedToPayment);
    }

    public void verifyRedirectionToPaymentPage() {
        Assert.assertTrue(getTextFromElement(paymentPage).contains("Payment"), "Redirection to payment page failed.");
    }

    public void verifyShippingInformation() {
        Assert.assertTrue(getTextFromElement(shippingInfo).contains("Valid shipping information"), "Shipping information incorrect.");
    }

    public void verifyBillingInformation() {
        Assert.assertTrue(getTextFromElement(billingInfo).contains("Valid billing information"), "Billing information incorrect.");
    }

    public void completeCheckoutProcess() {
        waitUntilElementVisible(orderPlacement, 3);
        clickElement(orderPlacement);
    }

    public void verifyOrderPlacement() {
        Assert.assertTrue(getTextFromElement(orderPlacement).contains("Order placed"), "Order placement failed.");
    }

    public void leaveBillingInformationSection(String billingStatus) {
        if (billingStatus.equals("blank")) {
            enterText(billingInfo, "");
        }
    }

    public void attemptToProceedToPayment() {
        clickElement(btnProceedToPayment);
    }

    public void verifySystemOutcome(String outcome) {
        if (outcome.contains("prevents")) {
            Assert.assertTrue(getTextFromElement(billingError).contains("error"), "Expected error not displayed.");
        } else {
            Assert.assertFalse(getTextFromElement(billingError).contains("error"), "Unexpected error displayed.");
        }
    }
}
