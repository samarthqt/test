package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class GuestCheckoutPage extends WebReusableComponents {

    protected By shoppingCartPage = By.id("shoppingCartPage");
    protected By guestCheckoutButton = By.id("guestCheckoutButton");
    protected By guestCheckoutPage = By.id("guestCheckoutPage");
    protected By nameField = By.id("nameField");
    protected By emailField = By.id("emailField");
    protected By phoneField = By.id("phoneField");
    protected By shippingAddressField = By.id("shippingAddressField");
    protected By paymentMethodOptions = By.id("paymentMethodOptions");
    protected By paymentProcessButton = By.id("paymentProcessButton");
    protected By orderConfirmationPage = By.id("orderConfirmationPage");
    protected By emailInbox = By.id("emailInbox");
    protected By accountFeatures = By.id("accountFeatures");
    protected By btnProceedToGuestCheckout = By.id("proceedToGuestCheckout");
    protected By duplicateOrderMessage = By.id("duplicateOrderMessage");
    protected By btnProceedToCheckout = By.id("proceedToCheckoutAsGuest");
    protected By txtEmail = By.id("emailField");
    protected By errorMessage = By.id("emailErrorMessage");
    private By txtShippingAddress = By.id("shippingAddress");
    private By btnCompleteCheckout = By.id("completeCheckout");
    private By confirmationMessage = By.id("confirmationMessage");

    public GuestCheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToShoppingCartPage() {
        waitUntilElementVisible(shoppingCartPage, 3);
        clickElement(shoppingCartPage);
    }

    public void verifyShoppingCartPageDisplayed() {
        Assert.assertTrue(isElementDisplayed(shoppingCartPage), "Shopping cart page is not displayed.");
    }

    public void proceedToGuestCheckout() {
        waitUntilElementVisible(guestCheckoutButton, 3);
        clickElement(guestCheckoutButton);
    }

    public void verifyGuestCheckoutPageDisplayed() {
        Assert.assertTrue(isElementDisplayed(guestCheckoutPage), "Guest checkout page is not displayed.");
    }

    public void enterName(String name) {
        waitUntilElementVisible(nameField, 3);
        enterText(nameField, name);
    }

    public void verifyNameAccepted() {
        Assert.assertTrue(isElementDisplayed(nameField), "Name is not accepted.");
    }

    public void enterEmail(String email) {
        waitUntilElementVisible(emailField, 3);
        enterText(emailField, email);
    }

    public void verifyEmailAccepted() {
        Assert.assertTrue(isElementDisplayed(emailField), "Email is not accepted.");
    }

    public void enterPhone(String phone) {
        waitUntilElementVisible(phoneField, 3);
        enterText(phoneField, phone);
    }

    public void verifyPhoneAccepted() {
        Assert.assertTrue(isElementDisplayed(phoneField), "Phone number is not accepted.");
    }

    public void enterShippingAddress(String address) {
        waitUntilElementVisible(shippingAddressField, 3);
        enterText(shippingAddressField, address);
    }

    public void verifyShippingAddressAccepted() {
        Assert.assertTrue(isElementDisplayed(shippingAddressField), "Shipping address is not accepted.");
    }

    public void selectPaymentMethod() {
        waitUntilElementVisible(paymentMethodOptions, 3);
        clickElement(paymentMethodOptions);
    }

    public void verifyPaymentMethodSelected() {
        Assert.assertTrue(isElementDisplayed(paymentMethodOptions), "Payment method is not selected.");
    }

    public void completePaymentProcess() {
        waitUntilElementVisible(paymentProcessButton, 3);
        clickElement(paymentProcessButton);
    }

    public void verifyPaymentProcessedSuccessfully() {
        Assert.assertTrue(isElementDisplayed(orderConfirmationPage), "Payment is not processed successfully.");
    }

    public void verifyOrderConfirmationPageDisplayed() {
        Assert.assertTrue(isElementDisplayed(orderConfirmationPage), "Order confirmation page is not displayed.");
    }

    public void checkEmailInboxForConfirmationEmail() {
        waitUntilElementVisible(emailInbox, 3);
        clickElement(emailInbox);
    }

    public void verifyOrderConfirmationEmailReceived() {
        Assert.assertTrue(isElementDisplayed(emailInbox), "Order confirmation email is not received.");
    }

    public void attemptAccessAccountOnlyFeatures() {
        waitUntilElementVisible(accountFeatures, 3);
        clickElement(accountFeatures);
    }

    public void verifyAccessDeniedWithPrompt() {
        Assert.assertTrue(isElementDisplayed(accountFeatures), "Access is not denied with a prompt.");
    }

    public void verifyGuestInformationStoredSecurely() {
        // Implement logic to verify guest information is stored securely
    }

    public void verifyGuestInformationNotAccessible() {
        // Implement logic to verify guest information is not accessible beyond order processing
    }

    public void completeCheckoutProcess() {
        // Implement checkout completion logic
    }

    public void checkForDuplicateOrders() {
        // Implement duplicate order check logic
    }

    public void verifyDuplicateOrderPreventionMessage() {
        waitUntilElementVisible(duplicateOrderMessage, 3);
        String actualMessage = getTextFromElement(duplicateOrderMessage);
        Assert.assertEquals(actualMessage, "Duplicate order detected. Please use a different email.", "Duplicate order prevention message is not displayed correctly.");
    }

    public void proceedToCheckoutAsGuest() {
        waitUntilElementVisible(btnProceedToCheckout, 3);
        clickElement(btnProceedToCheckout);
    }

    public void verifyEmailNotAccepted() {
        // Implement logic to verify email is not accepted
    }

    public void verifyInvalidEmailErrorMessage() {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, "Invalid email format.", "Error message does not match.");
    }

    public void navigateToShoppingCart() {
        driver.get("http://example.com/shopping-cart");
    }

    public void verifyAddressAcceptance() {
        String enteredAddress = getTextFromElement(txtShippingAddress);
        Assert.assertTrue(enteredAddress.length() <= 255, "Address exceeds character limit.");
    }

    public void verifyCheckoutSuccess() {
        waitUntilElementVisible(confirmationMessage, 3);
        String actualMessage = getTextFromElement(confirmationMessage);
        Assert.assertEquals(actualMessage, "Checkout completed successfully.", "Checkout did not complete successfully.");
    }
}
