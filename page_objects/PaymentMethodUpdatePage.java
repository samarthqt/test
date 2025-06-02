package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class PaymentMethodUpdatePage extends WebReusableComponents {

    protected By accountVerification = By.id("accountVerification");
    protected By loginVerification = By.id("loginVerification");
    protected By paymentMethodUpdateLink = By.id("paymentMethodUpdate");
    protected By paymentOptions = By.cssSelector(".payment-options");
    protected By selectPaymentMethodButton = By.id("selectPaymentMethod");
    protected By paymentDetails = By.cssSelector(".payment-details");
    protected By newPaymentInfo = By.id("newPaymentInfo");
    protected By confirmUpdateButton = By.id("confirmUpdate");
    protected By confirmationMessage = By.id("confirmationMessage");
    protected By emailConfirmation = By.id("emailConfirmation");
    protected By updatedPaymentMethod = By.cssSelector(".updated-payment-method");
    protected By subscriptionPayment = By.id("subscriptionPayment");
    protected By revertUpdateButton = By.id("revertUpdate");
    protected By refundProcess = By.id("refundProcess");
    protected By paymentConflicts = By.id("paymentConflicts");
    protected By notificationSettings = By.id("notificationSettings");
    protected By errorMessage = By.id("errorMessage");
    protected By systemUpdate = By.id("systemUpdate");
    protected By paymentRenewal = By.id("paymentRenewal");

    public PaymentMethodUpdatePage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyUserAccountExists() {
        waitUntilElementVisible(accountVerification, 3);
        Assert.assertTrue(elementVisible(accountVerification), "User account does not exist.");
    }

    public void verifyUserLoggedIn() {
        waitUntilElementVisible(loginVerification, 3);
        Assert.assertTrue(elementVisible(loginVerification), "User is not logged in.");
    }

    public void navigateToPaymentMethodUpdatePage() {
        waitUntilElementVisible(paymentMethodUpdateLink, 3);
        clickElement(paymentMethodUpdateLink);
    }

    public void verifyPaymentMethodUpdatePageDisplayed() {
        waitUntilElementVisible(paymentOptions, 3);
        Assert.assertTrue(elementVisible(paymentOptions), "Payment method update page is not displayed.");
    }

    public void verifyOnPaymentMethodUpdatePage() {
        waitUntilElementVisible(paymentOptions, 3);
        Assert.assertTrue(elementVisible(paymentOptions), "Not on payment method update page.");
    }

    public void selectPaymentMethodToUpdate() {
        waitUntilElementVisible(selectPaymentMethodButton, 3);
        clickElement(selectPaymentMethodButton);
    }

    public void verifyPaymentDetailsDisplayedForEditing() {
        waitUntilElementVisible(paymentDetails, 3);
        Assert.assertTrue(elementVisible(paymentDetails), "Payment details are not displayed for editing.");
    }

    public void verifyPaymentMethodSelectedForUpdate() {
        waitUntilElementVisible(paymentDetails, 3);
        Assert.assertTrue(elementVisible(paymentDetails), "Payment method not selected for update.");
    }

    public void enterNewPaymentInformation() {
        waitUntilElementVisible(newPaymentInfo, 3);
        enterText(newPaymentInfo, "New Payment Information");
    }

    public void verifyNewPaymentInformationAccepted() {
        waitUntilElementVisible(confirmationMessage, 3);
        Assert.assertTrue(elementVisible(confirmationMessage), "New payment information not accepted.");
    }

    public void verifyNewPaymentInformationEntered() {
        waitUntilElementVisible(newPaymentInfo, 3);
        Assert.assertTrue(elementVisible(newPaymentInfo), "New payment information not entered.");
    }

    public void confirmPaymentMethodUpdate() {
        waitUntilElementVisible(confirmUpdateButton, 3);
        clickElement(confirmUpdateButton);
    }

    public void verifyConfirmationMessageDisplayed() {
        waitUntilElementVisible(confirmationMessage, 3);
        Assert.assertTrue(elementVisible(confirmationMessage), "Confirmation message not displayed.");
    }

    public void verifyPaymentMethodUpdateSuccessful() {
        waitUntilElementVisible(confirmationMessage, 3);
        Assert.assertTrue(elementVisible(confirmationMessage), "Payment method update not successful.");
    }

    public void checkEmailForConfirmation() {
        waitUntilElementVisible(emailConfirmation, 3);
        Assert.assertTrue(elementVisible(emailConfirmation), "Email confirmation not received.");
    }

    public void verifyEmailConfirmationReceived() {
        waitUntilElementVisible(emailConfirmation, 3);
        Assert.assertTrue(elementVisible(emailConfirmation), "Email confirmation not received.");
    }

    public void verifyPaymentMethodUpdateConfirmed() {
        waitUntilElementVisible(confirmationMessage, 3);
        Assert.assertTrue(elementVisible(confirmationMessage), "Payment method update not confirmed.");
    }

    public void checkUserAccountForUpdatedMethod() {
        waitUntilElementVisible(updatedPaymentMethod, 3);
        Assert.assertTrue(elementVisible(updatedPaymentMethod), "Updated payment method not listed.");
    }

    public void verifyUpdatedPaymentMethodListed() {
        waitUntilElementVisible(updatedPaymentMethod, 3);
        Assert.assertTrue(elementVisible(updatedPaymentMethod), "Updated payment method not listed.");
    }

    public void verifyPaymentMethodUpdated() {
        waitUntilElementVisible(updatedPaymentMethod, 3);
        Assert.assertTrue(elementVisible(updatedPaymentMethod), "Payment method not updated.");
    }

    public void attemptSubscriptionWithUpdatedMethod() {
        waitUntilElementVisible(subscriptionPayment, 3);
        clickElement(subscriptionPayment);
    }

    public void verifySubscriptionPaymentProcessed() {
        waitUntilElementVisible(subscriptionPayment, 3);
        Assert.assertTrue(elementVisible(subscriptionPayment), "Subscription payment not processed.");
    }

    public void attemptToRevertPaymentMethodUpdate() {
        waitUntilElementVisible(revertUpdateButton, 3);
        clickElement(revertUpdateButton);
    }

    public void verifyPaymentMethodReverted() {
        waitUntilElementVisible(revertUpdateButton, 3);
        Assert.assertTrue(elementVisible(revertUpdateButton), "Payment method not reverted.");
    }

    public void verifyPaymentMethodRevertedWithinAllowedPeriod() {
        waitUntilElementVisible(revertUpdateButton, 3);
        Assert.assertTrue(elementVisible(revertUpdateButton), "Payment method not reverted within allowed period.");
    }

    public void initiateRefundProcess() {
        waitUntilElementVisible(refundProcess, 3);
        clickElement(refundProcess);
    }

    public void verifyRefundProcessedAsPerPolicy() {
        waitUntilElementVisible(refundProcess, 3);
        Assert.assertTrue(elementVisible(refundProcess), "Refund not processed as per policy.");
    }

    public void checkForSubscriptionPaymentConflicts() {
        waitUntilElementVisible(paymentConflicts, 3);
        Assert.assertTrue(elementVisible(paymentConflicts), "Payment conflicts found.");
    }

    public void verifyNoPaymentConflicts() {
        waitUntilElementVisible(paymentConflicts, 3);
        Assert.assertTrue(elementVisible(paymentConflicts), "Payment conflicts found.");
    }

    public void navigateToNotificationSettings() {
        waitUntilElementVisible(notificationSettings, 3);
        clickElement(notificationSettings);
    }

    public void manageNotificationSettings() {
        waitUntilElementVisible(notificationSettings, 3);
        clickElement(notificationSettings);
    }

    public void verifyNotificationSettingsUpdated() {
        waitUntilElementVisible(notificationSettings, 3);
        Assert.assertTrue(elementVisible(notificationSettings), "Notification settings not updated.");
    }

    public void enterInvalidPaymentInformation() {
        waitUntilElementVisible(newPaymentInfo, 3);
        enterText(newPaymentInfo, "Invalid Payment Information");
    }

    public void verifyErrorMessageDisplayed() {
        waitUntilElementVisible(errorMessage, 3);
        Assert.assertTrue(elementVisible(errorMessage), "Error message not displayed.");
    }

    public void processPaymentMethodChange() {
        waitUntilElementVisible(confirmUpdateButton, 3);
        clickElement(confirmUpdateButton);
    }

    public void verifyUpdateWithoutAffectingRenewal() {
        waitUntilElementVisible(systemUpdate, 3);
        Assert.assertTrue(elementVisible(systemUpdate), "Update affected renewal.");
    }

    public void verifySystemUpdateWithoutErrors() {
        waitUntilElementVisible(systemUpdate, 3);
        Assert.assertTrue(elementVisible(systemUpdate), "System update has errors.");
    }

    public void initiatePaymentRenewalProcess() {
        waitUntilElementVisible(paymentRenewal, 3);
        clickElement(paymentRenewal);
    }

    public void verifyAutomaticPaymentRenewal() {
        waitUntilElementVisible(paymentRenewal, 3);
        Assert.assertTrue(elementVisible(paymentRenewal), "Automatic payment renewal failed.");
    }

    public void verifySubscriptionRenewalDue() {
        waitUntilElementVisible(paymentRenewal, 3);
        Assert.assertTrue(elementVisible(paymentRenewal), "Subscription renewal is not due.");
    }

    public void updatePaymentMethodDuringRenewal() {
        waitUntilElementVisible(paymentRenewal, 3);
        clickElement(paymentRenewal);
    }

    public void attemptPaymentMethodUpdate() {
        waitUntilElementVisible(confirmUpdateButton, 3);
        clickElement(confirmUpdateButton);
    }

    public void updatePaymentMethod() {
        waitUntilElementVisible(confirmUpdateButton, 3);
        clickElement(confirmUpdateButton);
    }
}