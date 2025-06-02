package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class RefundPage extends WebReusableComponents {

    protected By btnLogin = By.id("loginButton");
    protected By orderHistorySection = By.id("orderHistorySection");
    protected By transactionDetails = By.id("transactionDetails");
    protected By btnRequestRefund = By.id("requestRefundButton");
    protected By refundForm = By.id("refundForm");
    protected By txtRefundAmount = By.id("refundAmount");
    protected By txtRefundReason = By.id("refundReason");
    protected By paymentGatewayDropdown = By.id("paymentGateway");
    protected By btnSubmitRefund = By.id("submitRefundButton");
    protected By refundStatus = By.id("refundStatus");
    protected By emailNotification = By.id("emailNotification");
    protected By btnLogout = By.id("logoutButton");
    protected By errorMessage = By.id("errorMessage");

    public RefundPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginWithValidCredentials() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void navigateToOrderHistory() {
        waitUntilElementVisible(orderHistorySection, 3);
        clickElement(orderHistorySection);
    }

    public void verifyOrderHistoryDisplayed() {
        Assert.assertTrue(isElementVisible(orderHistorySection), "Order history is not displayed.");
    }

    public void selectEligibleTransactionForRefund() {
        waitUntilElementVisible(transactionDetails, 3);
        clickElement(transactionDetails);
    }

    public void verifyTransactionDetailsDisplayed() {
        Assert.assertTrue(isElementVisible(transactionDetails), "Transaction details are not displayed.");
    }

    public void clickRequestRefundButton() {
        waitUntilElementVisible(btnRequestRefund, 3);
        clickElement(btnRequestRefund);
    }

    public void verifyRefundRequestFormDisplayed() {
        Assert.assertTrue(isElementVisible(refundForm), "Refund request form is not displayed.");
    }

    public void enterRefundDetails() {
        waitUntilElementVisible(txtRefundAmount, 3);
        enterText(txtRefundAmount, "100");
        enterText(txtRefundReason, "Product defect");
    }

    public void verifyRefundDetailsEntered() {
        Assert.assertEquals(getTextFromElement(txtRefundAmount), "100", "Refund amount is incorrect.");
        Assert.assertEquals(getTextFromElement(txtRefundReason), "Product defect", "Refund reason is incorrect.");
    }

    public void selectPaymentGateway() {
        waitUntilElementVisible(paymentGatewayDropdown, 3);
        selectByValue(paymentGatewayDropdown, "Gateway1");
    }

    public void verifyPaymentGatewaySelected() {
        Assert.assertEquals(getSelectedValue(paymentGatewayDropdown), "Gateway1", "Payment gateway is not selected.");
    }

    public void submitRefundRequest() {
        waitUntilElementVisible(btnSubmitRefund, 3);
        clickElement(btnSubmitRefund);
    }

    public void verifyRefundRequestSubmitted() {
        Assert.assertTrue(isElementVisible(refundStatus), "Refund request is not submitted.");
    }

    public void verifyRefundStatusInTransactionHistory() {
        Assert.assertTrue(isElementVisible(refundStatus), "Refund status is not updated.");
    }

    public void checkEmailNotificationForRefundConfirmation() {
        waitUntilElementVisible(emailNotification, 3);
        clickElement(emailNotification);
    }

    public void verifyEmailNotificationReceived() {
        Assert.assertTrue(isElementVisible(emailNotification), "Email notification is not received.");
    }

    public void verifyRefundAmountCreditedBack() {
        Assert.assertTrue(isElementVisible(refundStatus), "Refund amount is not credited back.");
    }

    public void logoutFromApplication() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    public void verifyUserLoggedOut() {
        Assert.assertTrue(isElementVisible(btnLogin), "User is not logged out.");
    }

    public void completeRefundProcessUsingOneGateway() {
        selectPaymentGateway();
        submitRefundRequest();
    }

    public void repeatRefundProcessUsingDifferentGateway() {
        selectByValue(paymentGatewayDropdown, "Gateway2");
        submitRefundRequest();
    }

    public void navigateToRefundRequestForm() {
        clickElement(refundForm);
    }

    public void attemptRefundWithInvalidAmount() {
        enterText(txtRefundAmount, "1000");
        clickElement(btnSubmitRefund);
    }

    public void verifyErrorMessageForInvalidRefundAmount() {
        Assert.assertEquals(getTextFromElement(errorMessage), "invalid refund amount", "Error message is incorrect.");
    }

    public void attemptRefundWithoutPaymentGateway() {
        enterText(txtRefundAmount, "100");
        clickElement(btnSubmitRefund);
    }

    public void verifyErrorMessageForMissingPaymentGateway() {
        Assert.assertEquals(getTextFromElement(errorMessage), "missing payment gateway selection", "Error message is incorrect.");
    }

    public void attemptRefundWithInvalidTransactionID() {
        enterText(txtRefundAmount, "100");
        enterText(txtRefundReason, "Invalid ID");
        clickElement(btnSubmitRefund);
    }

    public void verifyErrorMessageForInvalidTransactionID() {
        Assert.assertEquals(getTextFromElement(errorMessage), "invalid transaction ID", "Error message is incorrect.");
    }
}