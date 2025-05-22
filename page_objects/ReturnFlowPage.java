package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ReturnFlowPage extends WebReusableComponents {

    private WebDriver driver;

    protected By btnLogin = By.id(loginButton);
    protected By dashboard = By.id(accountDashboard);
    protected By orderDetailsSection = By.id(orderDetailsSection);
    protected By btnInitiateReturn = By.id(initiateReturnButton);
    protected By returnForm = By.id(returnForm);
    protected By confirmationEmail = By.id(confirmationEmail);
    protected By cxEmail = By.id(cxEmail);
    protected By accessCodeStatus = By.id(accessCodeStatus);

    public ReturnFlowPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyPurchaseOfAccessCode() {
        Assert.assertTrue(isElementPresent(By.id(achieveAccessCode)), Achieve access code not purchased.);
    }

    public void verifyPurchaseDateWithinEligiblePeriod() {
        String purchaseDate = getTextFromElement(By.id(purchaseDate));
        Assert.assertTrue(isWithinLast14Days(purchaseDate), Purchase not within eligible period.);
    }

    public void loginToBFWStore() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyAccountDashboardDisplayed() {
        waitUntilElementVisible(dashboard, 3);
        Assert.assertTrue(isElementVisible(dashboard), Account dashboard not displayed.);
    }

    public void verifyCustomerLoggedIn() {
        Assert.assertTrue(isElementVisible(dashboard), Customer not logged in.);
    }

    public void navigateToOrderDetailsSection() {
        waitUntilElementVisible(orderDetailsSection, 3);
        clickElement(orderDetailsSection);
    }

    public void verifyOrderDetailsDisplayed() {
        waitUntilElementVisible(By.id(recentPurchases), 3);
        Assert.assertTrue(isElementVisible(By.id(recentPurchases)), Order details not displayed.);
    }

    public void verifyOnOrderDetailsSection() {
        Assert.assertTrue(isElementVisible(orderDetailsSection), Not on Order Details section.);
    }

    public void selectOrderWithID(String orderID) {
        waitUntilElementVisible(By.id(order + orderID), 3);
        clickElement(By.id(order + orderID));
    }

    public void verifyOrderDetailsForID(String orderID) {
        waitUntilElementVisible(By.id(orderDetails + orderID), 3);
        Assert.assertTrue(isElementVisible(By.id(orderDetails + orderID)), Order details for ID  + orderID +  not displayed.);
    }

    public void verifyViewingOrderDetailsForID(String orderID) {
        Assert.assertTrue(isElementVisible(By.id(orderDetails + orderID)), Not viewing order details for ID  + orderID + .);
    }

    public void clickInitiateReturnButton() {
        waitUntilElementVisible(btnInitiateReturn, 3);
        clickElement(btnInitiateReturn);
    }

    public void verifyInitiateReturnFormDisplayed() {
        waitUntilElementVisible(returnForm, 3);
        Assert.assertTrue(isElementVisible(returnForm), Initiate Return form not displayed.);
    }

    public void completeAndSubmitReturnForm() {
        fillReturnFormDetails();
        submitReturnForm();
    }

    public void verifyReturnRequestSubmission() {
        Assert.assertTrue(isElementVisible(By.id(returnRequestConfirmation)), Return request not submitted successfully.);
    }

    public void processRefundByBraintree() {
        initiateRefundProcess();
    }

    public void verifyImmediateRefundProcessing() {
        Assert.assertTrue(isElementVisible(By.id(refundConfirmation)), Refund not processed immediately.);
    }

    public void checkCustomerEmailForConfirmation() {
        openEmailClient();
        verifyEmailReceived(confirmationEmail);
    }

    public void verifyConfirmationEmailReceived() {
        Assert.assertTrue(isElementVisible(confirmationEmail), Confirmation email not received.);
    }

    public void sendDailyReturnRequestEmailToCX() {
        initiateEmailToCX();
    }

    public void verifyOrderDetailsInCXEmail() {
        Assert.assertTrue(isElementVisible(cxEmail), Order details not present in CX email.);
    }

    public void checkCXSystemForReturnRequest() {
        accessCXSystem();
        verifyReturnRequestInCXSystem();
    }

    public void verifyCXActionOnReturnRequest() {
        Assert.assertTrue(isElementVisible(By.id(cxActionConfirmation)), CX did not take appropriate action.);
    }

    public void verifyAccessCodeRedemption() {
        Assert.assertTrue(isElementVisible(By.id(accessCodeRedeemed)), Access code not redeemed.);
    }

    public void revokeAccessToAchieveCourse() {
        initiateAccessRevocation();
    }

    public void verifyAccessCodeNotRedeemed() {
        Assert.assertFalse(isElementVisible(By.id(accessCodeRedeemed)), Access code was redeemed.);
    }

    public void zeroOutAccessCode() {
        initiateAccessCodeZeroing();
    }

    public void verifyRefundCompletion() {
        Assert.assertTrue(isElementVisible(By.id(refundCompletion)), Refund not completed.);
    }

    public void verifyAccessCodeInvalidity() {
        Assert.assertFalse(isElementVisible(accessCodeStatus), Access code is still valid.);
    }
}