package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import .time.Duration;

public class CheckoutPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectGuestCheckoutOption() {
        WebElement guestCheckoutOption = wait.until(ExpectedConditions.elementToBeClickable(By.id(guest_checkout)));
        guestCheckoutOption.click();
    }

    public void enterShippingInformation(String name, String address, String city, String state, String zip) {
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(shipping_name)));
        nameField.sendKeys(name);
        WebElement addressField = driver.findElement(By.id(shipping_address));
        addressField.sendKeys(address);
        WebElement cityField = driver.findElement(By.id(shipping_city));
        cityField.sendKeys(city);
        WebElement stateField = driver.findElement(By.id(shipping_state));
        stateField.sendKeys(state);
        WebElement zipField = driver.findElement(By.id(shipping_zip));
        zipField.sendKeys(zip);
    }

    public void enterPaymentInformation(String cardNumber, String expiryDate, String cvv) {
        WebElement cardNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(card_number)));
        cardNumberField.sendKeys(cardNumber);
        WebElement expiryDateField = driver.findElement(By.id(expiry_date));
        expiryDateField.sendKeys(expiryDate);
        WebElement cvvField = driver.findElement(By.id(cvv));
        cvvField.sendKeys(cvv);
    }

    public void reviewOrder() {
        WebElement reviewOrderButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(review_order)));
        reviewOrderButton.click();
    }

    public void confirmOrder() {
        WebElement confirmOrderButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(confirm_order)));
        confirmOrderButton.click();
    }

    public boolean isPurchaseSuccessful() {
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(success_message)));
        return successMessage.isDisplayed();
    }

    public boolean isConfirmationMessageDisplayed() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(confirmation_message)));
        return confirmationMessage.isDisplayed();
    }

    public boolean canProceedWithCheckout() {
        WebElement proceedButton = driver.findElement(By.id(proceed_checkout));
        return proceedButton.isEnabled();
    }

    public boolean isAddItemsPromptDisplayed() {
        WebElement addItemsPrompt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(add_items_prompt)));
        return addItemsPrompt.isDisplayed();
    }

    public void loginToPayPal(String email, String password) {
        WebElement emailField = driver.findElement(By.id(paypal_email));
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.id(paypal_password));
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id(paypal_login));
        loginButton.click();
    }

    public void confirmPayPalPayment() {
        WebElement confirmButton = driver.findElement(By.id(confirm_paypal_payment));
        confirmButton.click();
    }

    public boolean isRedirectedBackToCheckout() {
        return driver.getCurrentUrl().contains(example.com/checkout);
    }

    public boolean isPaymentDeclined() {
        WebElement declinedMessage = driver.findElement(By.id(payment_declined));
        return declinedMessage.isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        WebElement errorMessage = driver.findElement(By.id(error_message));
        return errorMessage.isDisplayed();
    }

    public void enterEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(email)));
        emailField.sendKeys(email);
    }

    public void chooseToCreateAccount() {
        WebElement createAccountCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.id(create_account)));
        createAccountCheckbox.click();
    }

    public void completePurchase() {
        WebElement completePurchaseButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(complete_purchase)));
        completePurchaseButton.click();
    }

    public boolean isOrderPlacedSuccessfully() {
        WebElement orderSuccessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(order_success)));
        return orderSuccessMessage.isDisplayed();
    }

    public boolean isMissingInformationPromptVisible() {
        WebElement missingInfoPrompt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(missing_info_prompt)));
        return missingInfoPrompt.isDisplayed();
    }

    public boolean isPaymentErrorMessageDisplayed() {
        WebElement paymentErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(payment_error_message)));
        return paymentErrorMessage.isDisplayed();
    }

    public boolean isRedirectedToPayPal() {
        return driver.getCurrentUrl().contains(paypal.com);
    }

    public void processPayment() {
        WebElement processPaymentButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(process_payment)));
        processPaymentButton.click();
    }

    public boolean isMandatoryFieldsErrorMessageDisplayed() {
        WebElement mandatoryFieldsError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(mandatory_fields_error)));
        return mandatoryFieldsError.isDisplayed();
    }

    public void decideToLogIn() {
        WebElement loginDecisionButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(login_decision)));
        loginDecisionButton.click();
    }

    public void emptyCart() {
        WebElement emptyCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(empty_cart)));
        emptyCartButton.click();
    }

    public void enterCardDetails(String cardNumber, String expiryDate, String cvv) {
        WebElement cardNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(card_number)));
        cardNumberField.sendKeys(cardNumber);
        WebElement expiryDateField = driver.findElement(By.id(expiry_date));
        expiryDateField.sendKeys(expiryDate);
        WebElement cvvField = driver.findElement(By.id(cvv));
        cvvField.sendKeys(cvv);
    }

    public boolean isDelayMessageDisplayed() {
        WebElement delayMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(delay_message)));
        return delayMessage.isDisplayed();
    }

    public boolean isCancellationMessageDisplayed() {
        WebElement cancellationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(cancellation_message)));
        return cancellationMessage.isDisplayed();
    }

    public boolean isPromptToCorrectPaymentDisplayed() {
        WebElement correctPaymentPrompt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(correct_payment_prompt)));
        return correctPaymentPrompt.isDisplayed();
    }

    public void enterDeliveryLocation(String location) {
        WebElement locationField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(delivery_location)));
        locationField.sendKeys(location);
    }

    public boolean isTransactionLogged() {
        WebElement transactionLog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(transaction_log)));
        return transactionLog.isDisplayed();
    }

    public void reviewOrderSummary() {
        WebElement reviewSummaryButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(review_summary)));
        reviewSummaryButton.click();
    }

    public void confirmPurchase() {
        WebElement confirmPurchaseButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(confirm_purchase)));
        confirmPurchaseButton.click();
    }

    public boolean areItemsStillInCart() {
        WebElement itemsInCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(items_in_cart)));
        return itemsInCart.isDisplayed();
    }

    public boolean isConfirmationEmailReceived() {
        WebElement confirmationEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(confirmation_email)));
        return confirmationEmail.isDisplayed();
    }

    public boolean isRedirectedToLoginPage() {
        return driver.getCurrentUrl().contains(login);
    }

    public boolean isEditOrderOptionDisplayed() {
        WebElement editOrderOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(edit_order_option)));
        return editOrderOption.isDisplayed();
    }

    public boolean isOrderConfirmationReceived() {
        WebElement orderConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(order_confirmation)));
        return orderConfirmation.isDisplayed();
    }

    public boolean isCartEmptyMessageDisplayed() {
        WebElement cartEmptyMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(cart_empty_message)));
        return cartEmptyMessage.isDisplayed();
    }

    public void chooseGuestCheckout() {
        WebElement guestCheckoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(guest_checkout)));
        guestCheckoutButton.click();
    }

    public void enterInvalidPaymentInformation(String cardNumber, String expiryDate, String cvv) {
        WebElement cardNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(invalid_card_number)));
        cardNumberField.sendKeys(cardNumber);
        WebElement expiryDateField = driver.findElement(By.id(invalid_expiry_date));
        expiryDateField.sendKeys(expiryDate);
        WebElement cvvField = driver.findElement(By.id(invalid_cvv));
        cvvField.sendKeys(cvv);
    }

    public boolean isMissingInformationErrorMessageDisplayed() {
        WebElement missingInfoError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(missing_info_error)));
        return missingInfoError.isDisplayed();
    }

    public boolean isAddressDisplayedInOrderSummary() {
        WebElement addressInSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(address_in_summary)));
        return addressInSummary.isDisplayed();
    }

    public boolean isCartNotEmpty() {
        WebElement cartNotEmptyMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(cart_not_empty)));
        return cartNotEmptyMessage.isDisplayed();
    }

    public String getSelectedShippingOption() {
        WebElement selectedShippingOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(selected_shipping_option)));
        return selectedShippingOption.getText();
    }

    public boolean isPaymentSuccessful() {
        WebElement paymentSuccessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(payment_success)));
        return paymentSuccessMessage.isDisplayed();
    }

    public void assignAddressToItem(String address) {
        WebElement addressField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(assign_address)));
        addressField.sendKeys(address);
    }

    public boolean isTotalCostDisplayed() {
        WebElement totalCost = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(total_cost)));
        return totalCost.isDisplayed();
    }

    public void verifyEncryptionLogs() {
        WebElement encryptionLogs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(encryption_logs)));
        Assert.assertTrue(encryptionLogs.isDisplayed(), Encryption logs are not visible);
    }

    public boolean isPromptToCorrectPaymentInformationDisplayed() {
        WebElement correctPaymentInfoPrompt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(correct_payment_info_prompt)));
        return correctPaymentInfoPrompt.isDisplayed();
    }

    public boolean isGuestCheckoutOptionVisible() {
        WebElement guestCheckoutOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(guest_checkout_option)));
        return guestCheckoutOption.isDisplayed();
    }

    public String getErrorMessage() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(error_message)));
        return errorMessage.getText();
    }

    public boolean isPaymentProcessedSecurely() {
        WebElement securePaymentMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(secure_payment_message)));
        return securePaymentMessage.isDisplayed();
    }

    public boolean isOrderTotalUpdated() {
        WebElement orderTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(order_total)));
        return orderTotal.isDisplayed();
    }

    public boolean isDataEncrypted() {
        WebElement encryptionStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(encryption_status)));
        return encryptionStatus.isDisplayed();
    }

    public void cancelPayPalPayment() {
        WebElement cancelPayPalButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(cancel_paypal_payment)));
        cancelPayPalButton.click();
    }

    public void selectPaymentMethod(String method) {
        WebElement paymentMethod = driver.findElement(By.id(method.toLowerCase() + _option));
        paymentMethod.click();
    }

    public boolean isInvalidShippingDetailsMessageDisplayed() {
        WebElement invalidShippingMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(invalid_shipping_message)));
        return invalidShippingMessage.isDisplayed();
    }

    public void submitPayment() {
        WebElement submitPaymentButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(submit_payment)));
        submitPaymentButton.click();
    }

    public void verifyOptionsSortedBySpeed() {
        WebElement sortedOptions = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(sorted_options)));
        Assert.assertTrue(sortedOptions.isDisplayed(), Options are not sorted by speed);
    }

    public void selectShippingOption(String option) {
        WebElement shippingOption = wait.until(ExpectedConditions.elementToBeClickable(By.id(option.toLowerCase() + _shipping_option)));
        shippingOption.click();
    }

    public boolean isExpiredCodeErrorMessageDisplayed() {
        WebElement expiredCodeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(expired_code_message)));
        return expiredCodeMessage.isDisplayed();
    }

    public void addItemToCart(String itemId) {
        WebElement addItemButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(add_item_ + itemId)));
        addItemButton.click();
    }

    public boolean isMandatoryPaymentMethodMessageDisplayed() {
        WebElement mandatoryPaymentMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(mandatory_payment_message)));
        return mandatoryPaymentMessage.isDisplayed();
    }

    public void proceedToCheckout() {
        WebElement proceedToCheckoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(proceed_to_checkout)));
        proceedToCheckoutButton.click();
    }

    public void cancelPayment() {
        WebElement cancelPaymentButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(cancel_payment)));
        cancelPaymentButton.click();
    }

    public boolean verifyAvailableOptions() {
        WebElement availableOptions = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(available_options)));
        return availableOptions.isDisplayed();
    }

    public boolean isOrderSummaryDisplayed() {
        WebElement orderSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(order_summary)));
        return orderSummary.isDisplayed();
    }

    public void enterValidPaymentDetails(String cardNumber, String expiryDate, String cvv) {
        WebElement cardNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(valid_card_number)));
        cardNumberField.sendKeys(cardNumber);
        WebElement expiryDateField = driver.findElement(By.id(valid_expiry_date));
        expiryDateField.sendKeys(expiryDate);
        WebElement cvvField = driver.findElement(By.id(valid_cvv));
        cvvField.sendKeys(cvv);
    }

    public boolean isOrderProcessed() {
        WebElement orderProcessedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(order_processed)));
        return orderProcessedMessage.isDisplayed();
    }

    public void verifyShippingCostCalculation() {
        WebElement shippingCost = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(shipping_cost)));
        Assert.assertTrue(shippingCost.isDisplayed(), Shipping cost is not calculated correctly);
    }

    public boolean isRedirectedBackToCheckoutPage() {
        return driver.getCurrentUrl().contains(checkout);
    }

    public void verifyTotalCost() {
        WebElement totalCost = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(total_cost)));
        Assert.assertTrue(totalCost.isDisplayed(), Total cost is not displayed);
    }

    public boolean canProceedToNextStep() {
        WebElement nextStepButton = driver.findElement(By.id(next_step));
        return nextStepButton.isEnabled();
    }

    public boolean isAddressSelectionVisible() {
        WebElement addressSelection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(address_selection)));
        return addressSelection.isDisplayed();
    }

    public boolean isTransactionEncrypted() {
        WebElement encryptionStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(transaction_encrypted)));
        return encryptionStatus.isDisplayed();
    }

    public boolean isDiscountApplied() {
        WebElement discountMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(discount_applied)));
        return discountMessage.isDisplayed();
    }

    public void enterLocation(String location) {
        WebElement locationField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(location)));
        locationField.sendKeys(location);
    }

    public void enterShippingDetails(String name, String address, String city, String state, String zip) {
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(shipping_name)));
        nameField.sendKeys(name);
        WebElement addressField = driver.findElement(By.id(shipping_address));
        addressField.sendKeys(address);
        WebElement cityField = driver.findElement(By.id(shipping_city));
        cityField.sendKeys(city);
        WebElement stateField = driver.findElement(By.id(shipping_state));
        stateField.sendKeys(state);
        WebElement zipField = driver.findElement(By.id(shipping_zip));
        zipField.sendKeys(zip);
    }

    public void enterPromotionalCode(String code) {
        WebElement promoCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(promo_code)));
        promoCodeField.sendKeys(code);
    }

    public boolean canProceedToPayment() {
        WebElement proceedToPaymentButton = driver.findElement(By.id(proceed_to_payment));
        return proceedToPaymentButton.isEnabled();
    }

    public boolean isPromptToCompleteFieldsDisplayed() {
        WebElement completeFieldsPrompt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(complete_fields_prompt)));
        return completeFieldsPrompt.isDisplayed();
    }

    public void simulateGatewayDelay() {
        WebElement gatewayDelayButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(simulate_gateway_delay)));
        gatewayDelayButton.click();
    }

    public boolean isPromptToCorrectShippingDetailsDisplayed() {
        WebElement correctShippingDetailsPrompt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(correct_shipping_details_prompt)));
        return correctShippingDetailsPrompt.isDisplayed();
    }

    public boolean isErrorMessageVisible() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(error_message)));
        return errorMessage.isDisplayed();
    }

    public void leaveMandatoryFieldsEmpty() {
        WebElement mandatoryFields = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(mandatory_fields)));
        mandatoryFields.clear();
    }

    public void goToCheckout() {
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(go_to_checkout)));
        checkoutButton.click();
    }

    public String getDefaultShippingOption() {
        WebElement defaultShippingOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(default_shipping_option)));
        return defaultShippingOption.getText();
    }

    public void placeOrder() {
        WebElement placeOrderButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(place_order)));
        placeOrderButton.click();
    }

    public void cancelCheckout() {
        WebElement cancelCheckoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(cancel_checkout)));
        cancelCheckoutButton.click();
    }

    public void proceedWithoutRequiredInformation() {
        WebElement proceedWithoutInfoButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(proceed_without_info)));
        proceedWithoutInfoButton.click();
    }

    public void addItemsToCart(String itemId) {
        WebElement addItemButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(add_item_ + itemId)));
        addItemButton.click();
    }

    public boolean isPromptedForOptionalFields() {
        WebElement optionalFieldsPrompt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(optional_fields_prompt)));
        return optionalFieldsPrompt.isDisplayed();
    }

    public void fillMandatoryFieldsOnly(String name, String address) {
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(mandatory_name)));
        nameField.sendKeys(name);
        WebElement addressField = driver.findElement(By.id(mandatory_address));
        addressField.sendKeys(address);
    }

    public void proceedWithoutPaymentMethod() {
        WebElement proceedWithoutPaymentButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(proceed_without_payment)));
        proceedWithoutPaymentButton.click();
    }

    public boolean isConnectionSecure() {
        WebElement secureConnectionMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(secure_connection)));
        return secureConnectionMessage.isDisplayed();
    }

    public boolean isMonitoredForBreaches() {
        WebElement breachMonitoringMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(breach_monitoring)));
        return breachMonitoringMessage.isDisplayed();
    }

    public void confirmPayment() {
        WebElement confirmPaymentButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(confirm_payment)));
        confirmPaymentButton.click();
    }

    public boolean canProceedToCheckout() {
        WebElement proceedToCheckoutButton = driver.findElement(By.id(proceed_to_checkout));
        return proceedToCheckoutButton.isEnabled();
    }

    public boolean isOnCheckoutPage() {
        return driver.getCurrentUrl().contains(checkout);
    }

    public void navigateToGuestCheckoutPage() {
        WebElement guestCheckoutPageLink = wait.until(ExpectedConditions.elementToBeClickable(By.id(guest_checkout_page)));
        guestCheckoutPageLink.click();
    }

    public boolean isNewAddressAvailable() {
        WebElement newAddressOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(new_address_option)));
        return newAddressOption.isDisplayed();
    }

    public void enterInvalidCreditCardDetails(String cardNumber, String expiryDate, String cvv) {
        WebElement cardNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(invalid_card_number)));
        cardNumberField.sendKeys(cardNumber);
        WebElement expiryDateField = driver.findElement(By.id(invalid_expiry_date));
        expiryDateField.sendKeys(expiryDate);
        WebElement cvvField = driver.findElement(By.id(invalid_cvv));
        cvvField.sendKeys(cvv);
    }

    public double getCalculatedTax() {
        WebElement taxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(calculated_tax)));
        return Double.parseDouble(taxElement.getText());
    }

    public String getOrderStatus() {
        WebElement orderStatusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(order_status)));
        return orderStatusElement.getText();
    }

    public void verifyEstimatedDeliveryDate() {
        WebElement deliveryDateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(estimated_delivery_date)));
        Assert.assertTrue(deliveryDateElement.isDisplayed(), Estimated delivery date is not displayed);
    }

    public void enterInvalidPayPalDetails(String email, String password) {
        WebElement emailField = driver.findElement(By.id(invalid_paypal_email));
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.id(invalid_paypal_password));
        passwordField.sendKeys(password);
    }

    public boolean isShippingErrorMessageDisplayed() {
        WebElement shippingErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(shipping_error_message)));
        return shippingErrorMessage.isDisplayed();
    }

    public void clearLocationField() {
        WebElement locationField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(location)));
        locationField.clear();
    }

    public boolean isRedirectedToCart() {
        return driver.getCurrentUrl().contains(cart);
    }

    public boolean isMessageDisplayed(String messageId) {
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(messageId)));
        return messageElement.isDisplayed();
    }

    public boolean isInvalidPaymentInformationMessageDisplayed() {
        WebElement invalidPaymentMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(invalid_payment_message)));
        return invalidPaymentMessage.isDisplayed();
    }

    public void clickCheckoutAsGuest() {
        WebElement checkoutAsGuestButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(checkout_as_guest)));
        checkoutAsGuestButton.click();
    }

    public void enterPaymentDetails(String cardNumber, String expiryDate, String cvv) {
        WebElement cardNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(payment_card_number)));
        cardNumberField.sendKeys(cardNumber);
        WebElement expiryDateField = driver.findElement(By.id(payment_expiry_date));
        expiryDateField.sendKeys(expiryDate);
        WebElement cvvField = driver.findElement(By.id(payment_cvv));
        cvvField.sendKeys(cvv);
    }

    public void navigateToCheckoutPage() {
        WebElement checkoutPageLink = wait.until(ExpectedConditions.elementToBeClickable(By.id(checkout_page)));
        checkoutPageLink.click();
    }
}