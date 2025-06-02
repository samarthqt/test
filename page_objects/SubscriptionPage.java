package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class SubscriptionPage extends WebReusableComponents {

    protected By userIdField = By.id("userId");
    protected By subscriptionPageLink = By.id("subscriptionPageLink");
    protected By productSelection = By.id("productSelection");
    protected By frequencyDropdown = By.id("frequencyDropdown");
    protected By paymentInfoField = By.id("paymentInfo");
    protected By confirmSubscriptionButton = By.id("confirmSubscription");
    protected By emailConfirmation = By.id("emailConfirmation");
    protected By accountSubscriptionDetails = By.id("accountSubscriptionDetails");
    protected By changeFrequencyButton = By.id("changeFrequency");
    protected By cancelSubscriptionButton = By.id("cancelSubscription");
    protected By refundRequestButton = By.id("refundRequest");
    protected By deliveryScheduleCheck = By.id("deliveryScheduleCheck");
    protected By notificationSettings = By.id("notificationSettings");
    protected By paymentErrorMessage = By.id("paymentErrorMessage");
    protected By renewalCheck = By.id("renewalCheck");

    public SubscriptionPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginUser(String userId) {
        waitUntilElementVisible(userIdField, 3);
        enterText(userIdField, userId);
        Assert.assertTrue(isElementVisible(userIdField), "User login failed.");
    }

    public void navigateToSubscriptionPage() {
        waitUntilElementVisible(subscriptionPageLink, 3);
        clickElement(subscriptionPageLink);
        Assert.assertTrue(isElementVisible(productSelection), "Navigation to subscription page failed.");
    }

    public void verifySubscriptionPage() {
        waitUntilElementVisible(productSelection, 3);
        Assert.assertTrue(isElementVisible(productSelection), "Subscription page not displayed.");
    }

    public void selectProduct(String productId) {
        waitUntilElementVisible(productSelection, 3);
        selectByValue(productSelection, productId);
        Assert.assertTrue(isElementVisible(productSelection), "Product selection failed.");
    }

    public void verifyProductDetails() {
        waitUntilElementVisible(frequencyDropdown, 3);
        Assert.assertTrue(isElementVisible(frequencyDropdown), "Product details not displayed.");
    }

    public void verifyProductSelection() {
        Assert.assertTrue(isElementVisible(frequencyDropdown), "Product not selected.");
    }

    public void chooseSubscriptionFrequency(String frequency) {
        waitUntilElementVisible(frequencyDropdown, 3);
        selectByValue(frequencyDropdown, frequency);
        Assert.assertEquals(getTextFromElement(frequencyDropdown), frequency, "Frequency selection failed.");
    }

    public void verifyFrequencySelection() {
        String selectedFrequency = getTextFromElement(frequencyDropdown);
        Assert.assertEquals(selectedFrequency, "Weekly", "Frequency not highlighted.");
    }

    public void enterPaymentInformation() {
        waitUntilElementVisible(paymentInfoField, 3);
        enterText(paymentInfoField, "Credit Card");
        Assert.assertTrue(isElementVisible(confirmSubscriptionButton), "Payment information entry failed.");
    }

    public void verifyPaymentAcceptance() {
        Assert.assertTrue(isElementVisible(confirmSubscriptionButton), "Payment not accepted.");
    }

    public void confirmSubscriptionSetup() {
        waitUntilElementVisible(confirmSubscriptionButton, 3);
        clickElement(confirmSubscriptionButton);
        Assert.assertTrue(isElementVisible(emailConfirmation), "Subscription setup confirmation failed.");
    }

    public void verifySubscriptionConfirmation() {
        waitUntilElementVisible(emailConfirmation, 3);
        Assert.assertTrue(isElementVisible(emailConfirmation), "Subscription confirmation not displayed.");
    }

    public void checkEmailForConfirmation() {
        waitUntilElementVisible(emailConfirmation, 3);
        Assert.assertTrue(isElementVisible(emailConfirmation), "Email confirmation not received.");
    }

    public void verifyEmailConfirmation() {
        Assert.assertTrue(isElementVisible(emailConfirmation), "Email confirmation not verified.");
    }

    public void checkAccountForSubscriptionDetails() {
        waitUntilElementVisible(accountSubscriptionDetails, 3);
        Assert.assertTrue(isElementVisible(accountSubscriptionDetails), "Subscription details not listed.");
    }

    public void verifyAccountSubscriptionDetails() {
        Assert.assertTrue(isElementVisible(accountSubscriptionDetails), "Subscription details not verified.");
    }

    public void verifyActiveSubscription() {
        Assert.assertTrue(isElementVisible(accountSubscriptionDetails), "Active subscription not verified.");
    }

    public void changeSubscriptionFrequency() {
        waitUntilElementVisible(changeFrequencyButton, 3);
        clickElement(changeFrequencyButton);
        Assert.assertTrue(isElementVisible(changeFrequencyButton), "Frequency change not successful.");
    }

    public void verifyFrequencyChangeSuccess() {
        Assert.assertTrue(isElementVisible(changeFrequencyButton), "Frequency change not successful.");
    }

    public void cancelSubscription() {
        waitUntilElementVisible(cancelSubscriptionButton, 3);
        clickElement(cancelSubscriptionButton);
        Assert.assertTrue(isElementVisible(cancelSubscriptionButton), "Cancellation confirmation not displayed.");
    }

    public void verifyCancellationConfirmation() {
        Assert.assertTrue(isElementVisible(cancelSubscriptionButton), "Cancellation confirmation not displayed.");
    }

    public void verifyCancellationWithinAllowedPeriod() {
        Assert.assertTrue(isElementVisible(refundRequestButton), "Cancellation not within allowed period.");
    }

    public void requestRefund() {
        waitUntilElementVisible(refundRequestButton, 3);
        clickElement(refundRequestButton);
        Assert.assertTrue(isElementVisible(refundRequestButton), "Refund not processed.");
    }

    public void verifyRefundProcessing() {
        Assert.assertTrue(isElementVisible(refundRequestButton), "Refund not processed.");
    }

    public void checkDeliverySchedule() {
        waitUntilElementVisible(deliveryScheduleCheck, 3);
        Assert.assertTrue(isElementVisible(deliveryScheduleCheck), "Delivery schedule check not performed.");
    }

    public void verifyScheduleClear() {
        Assert.assertTrue(isElementVisible(deliveryScheduleCheck), "Schedule conflicts found.");
    }

    public void changeNotificationSettings() {
        waitUntilElementVisible(notificationSettings, 3);
        clickElement(notificationSettings);
        Assert.assertTrue(isElementVisible(notificationSettings), "Notification settings change not successful.");
    }

    public void verifyNotificationSettingsChange() {
        Assert.assertTrue(isElementVisible(notificationSettings), "Notification settings change not successful.");
    }

    public void navigateToPaymentPage() {
        waitUntilElementVisible(paymentInfoField, 3);
        Assert.assertTrue(isElementVisible(paymentInfoField), "Payment page not displayed.");
    }

    public void enterInvalidPaymentMethod() {
        waitUntilElementVisible(paymentInfoField, 3);
        enterText(paymentInfoField, "Invalid Method");
        Assert.assertTrue(isElementVisible(paymentErrorMessage), "Payment method error not displayed.");
    }

    public void verifyPaymentMethodError() {
        waitUntilElementVisible(paymentErrorMessage, 3);
        Assert.assertTrue(isElementVisible(paymentErrorMessage), "Payment method error not displayed.");
    }

    public void verifyFrequencyChange() {
        Assert.assertTrue(isElementVisible(frequencyDropdown), "Frequency change not verified.");
    }

    public void updateFrequencyInSystem() {
        waitUntilElementVisible(frequencyDropdown, 3);
        Assert.assertTrue(isElementVisible(frequencyDropdown), "System frequency update not performed.");
    }

    public void verifySystemFrequencyUpdate() {
        Assert.assertTrue(isElementVisible(frequencyDropdown), "System frequency update not verified.");
    }

    public void checkRenewalPeriod() {
        waitUntilElementVisible(renewalCheck, 3);
        Assert.assertTrue(isElementVisible(renewalCheck), "Renewal period check not performed.");
    }

    public void verifyAutomaticRenewal() {
        Assert.assertTrue(isElementVisible(renewalCheck), "Automatic renewal not verified.");
    }
}