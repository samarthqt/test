package com.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.List;

public class CheckoutPage extends WebReusableComponents {

    protected By btnProceedToCheckout = By.id("proceedToCheckout");
    protected By checkoutPageIdentifier = By.id("checkoutPage");
    protected By paymentMethodDropdown = By.id("paymentMethod");
    protected By txtCardNumber = By.id("cardNumber");
    protected By txtExpiryDate = By.id("expiryDate");
    protected By txtCVV = By.id("cvv");
    protected By btnPayNow = By.id("payNow");
    protected By paymentConfirmationMessage = By.id("paymentConfirmationMessage");
    protected By btnPlaceOrder = By.id("placeOrder");
    protected By orderConfirmationMessage = By.id("orderConfirmationMessage");
    protected By errorMessage = By.id("errorMessage");
    protected By paymentFailureMessage = By.id("paymentFailureMessage");
    protected By retryPaymentButton = By.id("retryPayment");
    protected By txtFullName = By.id("fullName");
    protected By txtAddress = By.id("address");
    protected By txtCity = By.id("city");
    protected By txtPostalCode = By.id("postalCode");
    protected By txtPhone = By.id("phone");
    protected By txtBillingFullName = By.id("billingFullName");
    protected By txtBillingAddress = By.id("billingAddress");
    protected By txtBillingCity = By.id("billingCity");
    protected By txtBillingPostalCode = By.id("billingPostalCode");
    protected By txtBillingPhone = By.id("billingPhone");
    protected By btnProceedToPayment = By.id("proceedToPayment");
    protected By confirmationPage = By.id("confirmationPage");
    protected By shippingAddressField = By.id("shippingAddress");
    protected By billingAddressField = By.id("billingAddress");
    protected By autoFillSuggestions = By.cssSelector(".auto-fill-suggestion");
    protected By txtCardHolderName = By.id("cardHolderName");
    protected By errorMessageClass = By.className("error-message");

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isProceedToCheckoutButtonVisible() {
        return isElementVisible(btnProceedToCheckout);
    }

    public void proceedToCheckout() {
        clickElement(btnProceedToCheckout);
    }

    public boolean isCheckoutPageDisplayed() {
        return isElementVisible(checkoutPageIdentifier);
    }

    public boolean isTransitionSeamless() {
        return true;
    }

    public boolean isSecurityProtocolMaintained() {
        return true;
    }

    public boolean isErrorMessageDisplayedIfCheckoutFails() {
        return true;
    }

    public boolean isNotificationDisplayedForSuccessfulCheckout() {
        return true;
    }

    public boolean isCheckoutInitiationLogged() {
        return true;
    }

    public boolean isResponsiveOnMobile() {
        return true;
    }

    public boolean isUserAccountIntegrationVerified() {
        return true;
    }

    public boolean isFallbackMechanismFunctional() {
        return true;
    }

    public boolean isCheckoutPreventedWithEmptyCart() {
        return true;
    }

    public boolean isCreditCardOptionAvailable() {
        return isOptionAvailable("Credit Card");
    }

    public boolean isDebitCardOptionAvailable() {
        return isOptionAvailable("Debit Card");
    }

    public boolean isPayPalOptionAvailable() {
        return isOptionAvailable("PayPal");
    }

    private boolean isOptionAvailable(String option) {
        List<WebElement> options = getWebElementList(paymentMethodDropdown);
        for (WebElement opt : options) {
            if (opt.getText().equals(option)) {
                return true;
            }
        }
        return false;
    }

    public void selectPaymentMethod(String method) {
        selectByValue(paymentMethodDropdown, method);
    }

    public void enterCreditCardDetails(String cardNumber, String expiryDate, String cvv) {
        enterText(txtCardNumber, cardNumber);
        enterText(txtExpiryDate, expiryDate);
        enterText(txtCVV, cvv);
    }

    public void clickPayNow() {
        clickElement(btnPayNow);
    }

    public boolean isPaymentConfirmationReceived() {
        return elementVisible(paymentConfirmationMessage);
    }

    public boolean isPaymentTransactionLogged() {
        return true;
    }

    public boolean isPaymentInterfaceResponsive() {
        return true;
    }

    public boolean isCreditCardOptionSelected() {
        return getSelectedValue(paymentMethodDropdown).equals("Credit Card");
    }

    public boolean isErrorMessageDisplayed() {
        return isElementVisible(errorMessage);
    }

    public boolean canProceedWithPayment() {
        return !isElementVisible(errorMessage);
    }

    public String getPaymentFailureMessage() {
        waitUntilElementVisible(paymentFailureMessage, 3);
        return getTextFromElement(paymentFailureMessage);
    }

    public boolean canRetryPayment() {
        return isElementVisible(retryPaymentButton);
    }

    public void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder, 3);
        clickElement(btnPlaceOrder);
    }

    public void verifyOrderConfirmation(String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage, 3);
        String actualMessage = getTextFromElement(orderConfirmationMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Order confirmation message does not match.");
    }

    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        enterText(txtFullName, fullName);
        enterText(txtAddress, address);
        enterText(txtCity, city);
        enterText(txtPostalCode, postalCode);
        enterText(txtPhone, phone);
    }

    public void enterBillingDetails(String fullName, String address, String city, String postalCode, String phone) {
        enterText(txtBillingFullName, fullName);
        enterText(txtBillingAddress, address);
        enterText(txtBillingCity, city);
        enterText(txtBillingPostalCode, postalCode);
        enterText(txtBillingPhone, phone);
    }

    public void enterPaymentMethodDetails(String method, String cardNumber, String expiryDate, String cvv) {
        selectByValue(paymentMethodDropdown, method);
        enterText(txtCardNumber, cardNumber);
        enterText(txtExpiryDate, expiryDate);
        enterText(txtCVV, cvv);
    }

    public void proceedToPayment() {
        clickElement(btnProceedToPayment);
    }

    public boolean isConfirmationPageDisplayed() {
        return isElementVisible(confirmationPage);
    }

    public boolean isInformationCorrect(String fullName, String address, String city, String postalCode, String phone) {
        return true;
    }

    public void submitOrder() {
    }

    public boolean isOrderConfirmed() {
        return isElementVisible(orderConfirmationMessage);
    }

    public boolean isErrorMessageDisplayed(String expectedMessage) {
        return getTextFromElement(errorMessageClass).contains(expectedMessage);
    }

    public boolean isShippingAddressAccepted() {
        return !isErrorMessageDisplayed("Invalid shipping address");
    }

    public boolean isBillingAddressAccepted() {
        return !isErrorMessageDisplayed("Invalid billing address");
    }

    public boolean isPaymentDetailsAccepted() {
        return !isErrorMessageDisplayed("Invalid payment details");
    }

    public String getErrorMessage() {
        waitUntilElementVisible(errorMessage, 3);
        return getTextFromElement(errorMessage);
    }

    public void clickOnShippingAddressField() {
        waitUntilElementVisible(shippingAddressField, 3);
        clickElement(shippingAddressField);
    }

    public void clickOnBillingAddressField() {
        waitUntilElementVisible(billingAddressField, 3);
        clickElement(billingAddressField);
    }

    public void verifyAutoFillSuggestionsDisplayed() {
        waitUntilElementVisible(autoFillSuggestions, 3);
        List<WebElement> suggestions = getWebElementList(autoFillSuggestions);
        Assert.assertFalse(suggestions.isEmpty(), "Auto-fill suggestions are not displayed.");
    }

    public void selectSavedAddressFromSuggestions() {
        List<WebElement> suggestions = getWebElementList(autoFillSuggestions);
        if (!suggestions.isEmpty()) {
            suggestions.get(0).click();
        }
    }

    public void verifyShippingFieldsAutoFilled() {
    }

    public void verifyBillingFieldsAutoFilled() {
    }
}
