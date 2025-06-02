package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class PaymentPage extends WebReusableComponents {

    protected By paymentMethodsLink = By.id("paymentMethods");
    protected By addPaymentMethodButton = By.id("addPaymentMethod");
    protected By txtCardNumber = By.id("cardNumber");
    protected By txtCardHolderName = By.id("cardHolderName");
    protected By txtExpiryDate = By.id("expiryDate");
    protected By txtCVV = By.id("cvv");
    protected By savePaymentMethodButton = By.id("savePaymentMethod");
    protected By savedCards = By.cssSelector(".saved-card");
    protected By removeCardButton(String lastFourDigits) {
        return By.xpath("//div[contains(text(), '**** **** **** " + lastFourDigits + "')]/following-sibling::button[@class='remove']");
    }
    protected By btnProceedToCheckout = By.id("proceedToCheckout");
    protected By txtFullName = By.id("fullName");
    protected By txtAddress = By.id("address");
    protected By txtCity = By.id("city");
    protected By txtPostalCode = By.id("postalCode");
    protected By txtPhone = By.id("phone");
    protected By paymentMethodDropdown = By.id("paymentMethod");
    protected By btnPlaceOrder = By.id("placeOrder");
    protected By orderConfirmationMessage = By.id("orderConfirmationMessage");
    protected By btnPayWithPayPal = By.id("payWithPayPal");
    protected By btnLoginToPayPal = By.id("paypalLogin");
    protected By btnConfirmPayPalPayment = By.id("confirmPaypalPayment");
    protected By expiredCardErrorMessage = By.id("expiredCardErrorMessage");
    protected By updatePaymentMethodButton = By.id("updatePaymentMethod");
    protected By retryPaymentButton = By.id("retryPayment");
    protected By btnRetry = By.id("retryButton");
    protected By errorMessage = By.id("errorMessage");
    protected By transactionLog = By.id("transactionLog");

    public PaymentPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToPaymentMethods() {
        waitUntilElementVisible(paymentMethodsLink, 3);
        clickElement(paymentMethodsLink);
    }

    public void addNewPaymentMethod(String cardNumber, String cardHolderName, String expiryDate, String cvv) {
        waitUntilElementVisible(addPaymentMethodButton, 3);
        clickElement(addPaymentMethodButton);
        enterText(txtCardNumber, cardNumber);
        enterText(txtCardHolderName, cardHolderName);
        enterText(txtExpiryDate, expiryDate);
        enterText(txtCVV, cvv);
        clickElement(savePaymentMethodButton);
    }

    public void verifyPaymentMethodSaved() {
        waitUntilElementVisible(savedCards, 3);
        List<WebElement> cards = getWebElementList(savedCards);
        Assert.assertFalse(cards.isEmpty(), "No saved payment methods found.");
    }

    public void removePaymentMethod(String lastFourDigits) {
        By removeButton = removeCardButton(lastFourDigits);
        waitUntilElementVisible(removeButton, 3);
        clickElement(removeButton);
    }

    public void verifyPaymentMethodRemoved(String lastFourDigits) {
        By cardLocator = removeCardButton(lastFourDigits);
        boolean isCardPresent = elementVisible(cardLocator);
        Assert.assertFalse(isCardPresent, "Card was not removed from saved payment methods.");
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout, 3);
        clickElement(btnProceedToCheckout);
    }

    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName, 3);
        enterText(txtFullName, fullName);
        enterText(txtAddress, address);
        enterText(txtCity, city);
        enterText(txtPostalCode, postalCode);
        enterText(txtPhone, phone);
    }

    public void selectPaymentMethod(String method) {
        waitUntilElementVisible(paymentMethodDropdown, 3);
        selectByValue(paymentMethodDropdown, method);
    }

    public void enterCreditCardDetails(String cardNumber, String expiryDate, String cvv) {
        waitUntilElementVisible(txtCardNumber, 3);
        enterText(txtCardNumber, cardNumber);
        enterText(txtExpiryDate, expiryDate);
        enterText(txtCVV, cvv);
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

    public void verifyErrorMessage(String expectedMessage) {
        waitUntilElementVisible(errorMessage, 3);
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Error message does not match.");
    }

    public void verifyRetryOptionAvailable() {
        waitUntilElementVisible(btnRetry, 3);
        Assert.assertTrue(isElementDisplayed(btnRetry), "Retry option is not available.");
    }

    public void selectRetryOption() {
        waitUntilElementVisible(btnRetry, 3);
        clickElement(btnRetry);
    }

    public void verifyTransactionLogged() {
        waitUntilElementVisible(transactionLog, 3);
        Assert.assertTrue(isElementDisplayed(transactionLog), "Transaction log is not visible.");
    }

    public void verifyErrorMessageForExpiredCard() {
        waitUntilElementVisible(expiredCardErrorMessage, 3);
        String errorMessage = getTextFromElement(expiredCardErrorMessage);
        Assert.assertTrue(errorMessage.contains("expired"), "Error message does not indicate expired card.");
    }

    public void updatePaymentMethodToValidCard() {
        waitUntilElementVisible(updatePaymentMethodButton, 3);
        clickElement(updatePaymentMethodButton);
    }

    public void retryPaymentAttempt() {
        waitUntilElementVisible(retryPaymentButton, 3);
        clickElement(retryPaymentButton);
    }

    public void verifyRetryOptionAccessibility() {
        waitUntilElementVisible(btnRetry, 3);
        Assert.assertTrue(isElementDisplayed(btnRetry), "Retry option is not accessible.");
    }

    public void verifyUserDataProtection() {
        // Logic to verify user data protection
    }

    public void verifyRetrySecurity() {
        // Logic to verify retry security
    }

    public void attemptPaymentWithExpiredCard() {
        // Logic to attempt payment with expired card
    }

    public void verifyExpiredCardLinked() {
        // Logic to verify expired card is linked
    }

    public void readErrorMessage() {
        // Logic to read error message
    }

    public void verifyErrorMessageCompliance() {
        // Logic to verify error message compliance
    }

    public void verifyErrorMessageConsistency() {
        // Logic to verify error message consistency
    }

    public void verifyNoFailedTransactionInOrderHistory() {
        // Logic to verify no failed transaction in order history
    }

    public void verifyErrorMessageClarity() {
        // Logic to verify error message clarity
    }

    public void loginToApplication() {
        // Logic to login to application
    }

    public void verifyRetryOptionForNetworkFailures() {
        // Logic to verify retry option for network failures
    }

    public void verifyTransactionInOrderHistory() {
        // Logic to verify transaction in order history
    }

    public void verifyLogoutSuccessful() {
        // Logic to verify logout successful
    }

    public void verifyTransactionConfirmationMessageDisplayed() {
        // Logic to verify transaction confirmation message displayed
    }

    public void verifyErrorMessageReceived() {
        // Logic to verify error message received
    }

    public void logoutFromApplication() {
        // Logic to logout from application
    }

    public void initiatePaymentMethodUpdate() {
        // Logic to initiate payment method update
    }

    public void verifyPaymentSubmissionFailed() {
        // Logic to verify payment submission failed
    }

    public void verifyPaymentProcessedSuccessfully() {
        // Logic to verify payment processed successfully
    }

    public void verifyRetryOptionUserFriendly() {
        // Logic to verify retry option is user-friendly
    }

    public void verifyCreditCardDetailsAccepted() {
        // Logic to verify credit card details accepted
    }

    public void enterProductDetails() {
        // Logic to enter product details
    }

    public void login() {
        // Logic to login
    }

    public void verifyErrorMessageAccessibility() {
        // Logic to verify error message accessibility
    }

    public void verifyTransactionLogged() {
        // Logic to verify transaction logged
    }

    public void accessRetryOption() {
        // Logic to access retry option
    }

    public void verifyNoDuplicateErrorMessages() {
        // Logic to verify no duplicate error messages
    }

    public void simulateRepeatedPaymentFailures() {
        // Logic to simulate repeated payment failures
    }

    public void initiatePaymentTransaction(String userId, double amount, String method) {
        // Logic to initiate payment transaction
    }

    public void logout() {
        // Logic to logout
    }

    public void enterProductIDAndMaxAmount() {
        // Logic to enter product ID and max amount
    }

    public void enterEmailAddress() {
        // Logic to enter email address
    }

    public void verifyBillingAddressAccepted() {
        // Logic to verify billing address accepted
    }

    public void selectPaymentMethod() {
        // Logic to select payment method
    }

    public void verifyTransactionFailure() {
        // Logic to verify transaction failure
    }

    public void submitPayment() {
        // Logic to submit payment
    }

    public void verifyCustomerSupportAvailable() {
        // Logic to verify customer support available
    }

    public void verifyGuidanceProvided() {
        // Logic to verify guidance provided
    }

    public void displayErrorMessage() {
        // Logic to display error message
    }

    public void verifyRetryWithSameMethod() {
        // Logic to verify retry with same method
    }

    public void verifyProductDetailsAccepted() {
        // Logic to verify product details accepted
    }

    public void verifyErrorMessageDetails() {
        // Logic to verify error message details
    }

    public void enterBillingAddress() {
        // Logic to enter billing address
    }

    public void verifyUserLoggedInSuccessfully() {
        // Logic to verify user logged in successfully
    }

    public void provideGuidanceOnExpiredCard() {
        // Logic to provide guidance on expired card
    }

    public void verifyStripePaymentMethodSelected() {
        // Logic to verify Stripe payment method selected
    }

    public void verifyNoDuplicateTransactions() {
        // Logic to verify no duplicate transactions
    }

    public void retryPaymentMultipleTimes() {
        // Logic to retry payment multiple times
    }

    public void verifyPaymentMethodUpdateSuccess() {
        // Logic to verify payment method update success
    }

    public void selectStripePaymentMethod() {
        // Logic to select Stripe payment method
    }

    public void verifyRetryOptionPersistence() {
        // Logic to verify retry option persistence
    }

    public void verifyRetryOptionAvailability() {
        // Logic to verify retry option availability
    }

    public void verifyDifferentPaymentMethodSelection() {
        // Logic to verify different payment method selection
    }

    public void verifyNoFailedTransactionInStripe() {
        // Logic to verify no failed transaction in Stripe
    }

    public void verifyUserLoggedOutSuccessfully() {
        // Logic to verify user logged out successfully
    }

    public void verifyProductIDAndMaxAmountAccepted() {
        // Logic to verify product ID and max amount accepted
    }

    public void verifyTransactionDetailsLoggedForAuditing() {
        // Logic to verify transaction details logged for auditing
    }

    public void verifyNoEmailNotificationReceived() {
        // Logic to verify no email notification received
    }

    public void submitPaymentMethodUpdate() {
        // Logic to submit payment method update
    }

    public void verifyEmailAddressAccepted() {
        // Logic to verify email address accepted
    }

    public void verifyTransactionRecordInStripeDashboard() {
        // Logic to verify transaction record in Stripe dashboard
    }

    public void verifyRetryOptionOnDevices() {
        // Logic to verify retry option on devices
    }

    public void verifyPaymentFailureDueToExpiredCard() {
        // Logic to verify payment failure due to expired card
    }

    public void verifyLoginSuccessful() {
        // Logic to verify login successful
    }

    public void verifyPaymentPageDisplayed() {
        // Logic to verify payment page displayed
    }

    public void simulateNetworkError() {
        // Logic to simulate network error
    }

    public void simulatePaymentFailure(String reason) {
        // Logic to simulate payment failure
    }

    public void verifyErrorPageDisplayed() {
        // Logic to verify error page displayed
    }

    public void navigateToPaymentPage() {
        // Logic to navigate to payment page
    }

    public void checkErrorMessage() {
        // Logic to check error message
    }

    public void verifyFailedTransactionLogged() {
        // Logic to verify failed transaction logged
    }

    public void verifySystemResponseTime() {
        // Logic to verify system response time
    }

    public void verifyNoAdditionalFees() {
        // Logic to verify no additional fees
    }

    public void verifyUserFriendlyErrorMessage() {
        // Logic to verify user-friendly error message
    }
}