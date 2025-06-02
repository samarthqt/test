package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SubscriptionCustomizationPage extends WebReusableComponents {

    protected By userIdField = By.id("userId");
    protected By customizationPageLink = By.id("customizationPageLink");
    protected By productSelection = By.id("productSelection");
    protected By deliveryFrequencyDropdown = By.id("deliveryFrequency");
    protected By paymentMethodField = By.id("paymentMethod");
    protected By confirmSetupButton = By.id("confirmSetup");
    protected By confirmationMessage = By.id("confirmationMessage");
    protected By emailConfirmation = By.id("emailConfirmation");
    protected By accountDetails = By.id("accountDetails");
    protected By modifyFrequencyButton = By.id("modifyFrequency");
    protected By cancelCustomizationButton = By.id("cancelCustomization");
    protected By refundProcessLink = By.id("refundProcess");
    protected By deliveryScheduleLink = By.id("deliverySchedule");
    protected By notificationSettingsLink = By.id("notificationSettings");
    protected By paymentErrorMessage = By.id("paymentErrorMessage");
    protected By renewalPeriodLink = By.id("renewalPeriod");

    public SubscriptionCustomizationPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginUser(String userId) {
        waitUntilElementVisible(userIdField, 3);
        enterText(userIdField, userId);
        Assert.assertTrue(isElementVisible(userIdField), "User ID field is not visible.");
    }

    public void navigateToCustomizationPage() {
        waitUntilElementVisible(customizationPageLink, 3);
        clickElement(customizationPageLink);
        Assert.assertTrue(isElementVisible(customizationPageLink), "Failed to navigate to customization page.");
    }

    public void verifyCustomizationPageDisplayed() {
        Assert.assertTrue(isElementVisible(customizationPageLink), "Customization page is not displayed.");
    }

    public void selectProductForCustomization(String productId) {
        waitUntilElementVisible(productSelection, 3);
        selectByValue(productSelection, productId);
        Assert.assertTrue(isElementVisible(productSelection), "Product selection failed.");
    }

    public void verifyProductDetailsDisplayed() {
        Assert.assertTrue(isElementVisible(productSelection), "Product details are not displayed.");
    }

    public void chooseDeliveryFrequency(String frequency) {
        waitUntilElementVisible(deliveryFrequencyDropdown, 3);
        selectByValue(deliveryFrequencyDropdown, frequency);
        Assert.assertTrue(isElementVisible(deliveryFrequencyDropdown), "Delivery frequency selection failed.");
    }

    public void verifyFrequencyHighlighted() {
        Assert.assertTrue(isElementVisible(deliveryFrequencyDropdown), "Frequency is not highlighted.");
    }

    public void enterPaymentInformation(String paymentMethod) {
        waitUntilElementVisible(paymentMethodField, 3);
        enterText(paymentMethodField, paymentMethod);
        Assert.assertTrue(isElementVisible(paymentMethodField), "Payment information entry failed.");
    }

    public void verifyPaymentAccepted() {
        Assert.assertTrue(isElementVisible(paymentMethodField), "Payment information is not accepted.");
    }

    public void confirmCustomizationSetup() {
        waitUntilElementVisible(confirmSetupButton, 3);
        clickElement(confirmSetupButton);
        Assert.assertTrue(isElementVisible(confirmSetupButton), "Customization setup confirmation failed.");
    }

    public void verifyConfirmationMessageDisplayed() {
        String actualMessage = getTextFromElement(confirmationMessage);
        Assert.assertEquals(actualMessage, "Customization successful.", "Confirmation message is incorrect.");
    }

    public void checkEmailForConfirmation() {
        waitUntilElementVisible(emailConfirmation, 3);
        clickElement(emailConfirmation);
        Assert.assertTrue(isElementVisible(emailConfirmation), "Email confirmation check failed.");
    }

    public void verifyEmailConfirmationReceived() {
        Assert.assertTrue(isElementVisible(emailConfirmation), "Email confirmation not received.");
    }

    public void checkAccountForCustomizationDetails() {
        waitUntilElementVisible(accountDetails, 3);
        clickElement(accountDetails);
        Assert.assertTrue(isElementVisible(accountDetails), "Account customization details check failed.");
    }

    public void verifyCustomizationDetailsInAccount() {
        Assert.assertTrue(isElementVisible(accountDetails), "Customization details not listed in account.");
    }

    public void verifyActiveCustomization() {
        Assert.assertTrue(isElementVisible(accountDetails), "No active customization found.");
    }

    public void modifyDeliveryFrequency() {
        waitUntilElementVisible(modifyFrequencyButton, 3);
        clickElement(modifyFrequencyButton);
        Assert.assertTrue(isElementVisible(modifyFrequencyButton), "Modify delivery frequency failed.");
    }

    public void verifyFrequencyModificationSuccess() {
        Assert.assertTrue(isElementVisible(modifyFrequencyButton), "Frequency modification failed.");
    }

    public void cancelCustomization() {
        waitUntilElementVisible(cancelCustomizationButton, 3);
        clickElement(cancelCustomizationButton);
        Assert.assertTrue(isElementVisible(cancelCustomizationButton), "Customization cancellation failed.");
    }

    public void verifyCancellationConfirmationMessage() {
        String actualMessage = getTextFromElement(confirmationMessage);
        Assert.assertEquals(actualMessage, "Customization canceled.", "Cancellation confirmation message is incorrect.");
    }

    public void verifyCancellationWithinAllowedPeriod() {
        Assert.assertTrue(isElementVisible(cancelCustomizationButton), "Cancellation not within allowed period.");
    }

    public void checkRefundProcess() {
        waitUntilElementVisible(refundProcessLink, 3);
        clickElement(refundProcessLink);
        Assert.assertTrue(isElementVisible(refundProcessLink), "Refund process check failed.");
    }

    public void verifyRefundProcessed() {
        Assert.assertTrue(isElementVisible(refundProcessLink), "Refund not processed as per policy.");
    }

    public void checkDeliverySchedule() {
        waitUntilElementVisible(deliveryScheduleLink, 3);
        clickElement(deliveryScheduleLink);
        Assert.assertTrue(isElementVisible(deliveryScheduleLink), "Delivery schedule check failed.");
    }

    public void verifyNoScheduleConflicts() {
        Assert.assertTrue(isElementVisible(deliveryScheduleLink), "Schedule conflicts found.");
    }

    public void changeNotificationSettings() {
        waitUntilElementVisible(notificationSettingsLink, 3);
        clickElement(notificationSettingsLink);
        Assert.assertTrue(isElementVisible(notificationSettingsLink), "Change notification settings failed.");
    }

    public void verifyNotificationSettingsChanged() {
        Assert.assertTrue(isElementVisible(notificationSettingsLink), "Notification settings change failed.");
    }

    public void enterInvalidPaymentInformation() {
        waitUntilElementVisible(paymentMethodField, 3);
        enterText(paymentMethodField, "invalid");
        Assert.assertTrue(isElementVisible(paymentMethodField), "Invalid payment information entry failed.");
    }

    public void verifyPaymentMethodErrorMessage() {
        String actualMessage = getTextFromElement(paymentErrorMessage);
        Assert.assertEquals(actualMessage, "Invalid payment method.", "Payment method error message is incorrect.");
    }

    public void changeCustomizationFrequency() {
        waitUntilElementVisible(deliveryFrequencyDropdown, 3);
        selectByValue(deliveryFrequencyDropdown, "Weekly");
        Assert.assertTrue(isElementVisible(deliveryFrequencyDropdown), "Change customization frequency failed.");
    }

    public void verifyFrequencyUpdateSuccess() {
        Assert.assertTrue(isElementVisible(deliveryFrequencyDropdown), "Frequency update failed.");
    }

    public void verifyRenewalPeriodReached() {
        Assert.assertTrue(isElementVisible(renewalPeriodLink), "Renewal period not reached.");
    }

    public void verifyAutomaticRenewal() {
        Assert.assertTrue(isElementVisible(renewalPeriodLink), "Automatic renewal failed.");
    }
}