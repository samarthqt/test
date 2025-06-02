package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ReturnFlowPage extends WebReusableComponents {

    protected By orderIDField = By.id("orderID");
    protected By initiateReturnButton = By.id("initiateReturn");
    protected By returnForm = By.id("returnForm");
    protected By confirmationEmail = By.id("confirmationEmail");
    protected By cxSystemCheck = By.id("cxSystemCheck");
    protected By accessCodeStatus = By.id("accessCodeStatus");

    public ReturnFlowPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyPurchaseOfAchieveAccessCode() {
        WebElement element = waitUntilElementVisible(accessCodeStatus, 3);
        Assert.assertTrue(element.getText().contains("Achieve Access Code"), "Access code not purchased.");
    }

    public void verifyOrderID(String orderID) {
        WebElement element = waitUntilElementVisible(orderIDField, 3);
        Assert.assertEquals(element.getAttribute("value"), orderID, "Order ID does not match.");
    }

    public void verifyPurchaseWithinEligiblePeriod() {
        WebElement element = waitUntilElementVisible(orderIDField, 3);
        Assert.assertTrue(element.getText().contains("Eligible"), "Purchase not within eligible period.");
    }

    public void loginToBFWStore() {
        // Logic to log in to BFW store
        // Assuming login fields and button are defined elsewhere
        WebElement loginButton = waitUntilElementVisible(By.id("loginButton"), 3);
        loginButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login failed.");
    }

    public void verifyAccountDashboardDisplayed() {
        WebElement dashboard = waitUntilElementVisible(By.id("dashboard"), 3);
        Assert.assertTrue(dashboard.isDisplayed(), "Account dashboard not displayed.");
    }

    public void verifyCustomerLoggedIn() {
        WebElement userIcon = waitUntilElementVisible(By.id("userIcon"), 3);
        Assert.assertTrue(userIcon.isDisplayed(), "Customer not logged in.");
    }

    public void navigateToOrderDetailsSection() {
        WebElement orderDetailsLink = waitUntilElementVisible(By.id("orderDetailsLink"), 3);
        orderDetailsLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("order-details"), "Navigation to order details failed.");
    }

    public void verifyOrderDetailsDisplayed() {
        WebElement orderDetails = waitUntilElementVisible(By.id("orderDetails"), 3);
        Assert.assertTrue(orderDetails.isDisplayed(), "Order details not displayed.");
    }

    public void selectOrderWithID(String orderID) {
        WebElement orderElement = waitUntilElementVisible(By.xpath("//div[@data-order-id='" + orderID + "']"), 3);
        orderElement.click();
        Assert.assertTrue(orderElement.isSelected(), "Order with ID not selected.");
    }

    public void verifyOrderDetailsForID(String orderID) {
        WebElement orderElement = waitUntilElementVisible(By.xpath("//div[@data-order-id='" + orderID + "']"), 3);
        Assert.assertTrue(orderElement.isDisplayed(), "Order details for ID not displayed.");
    }

    public void clickInitiateReturnButton() {
        WebElement button = waitUntilElementVisible(initiateReturnButton, 3);
        button.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("return-form"), "Initiate return button click failed.");
    }

    public void verifyInitiateReturnFormDisplayed() {
        WebElement form = waitUntilElementVisible(returnForm, 3);
        Assert.assertTrue(form.isDisplayed(), "Initiate return form not displayed.");
    }

    public void completeAndSubmitReturnForm() {
        WebElement form = waitUntilElementVisible(returnForm, 3);
        // Assuming form fields are filled here
        WebElement submitButton = form.findElement(By.id("submitReturn"));
        submitButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("return-confirmation"), "Return form submission failed.");
    }

    public void verifyReturnRequestSubmission() {
        WebElement confirmation = waitUntilElementVisible(By.id("returnConfirmation"), 3);
        Assert.assertTrue(confirmation.isDisplayed(), "Return request submission not verified.");
    }

    public void processRefundByBraintree() {
        // Logic to process refund by Braintree
        WebElement refundButton = waitUntilElementVisible(By.id("refundButton"), 3);
        refundButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("refund-success"), "Refund processing failed.");
    }

    public void verifyImmediateRefundProcessing() {
        WebElement refundStatus = waitUntilElementVisible(By.id("refundStatus"), 3);
        Assert.assertTrue(refundStatus.getText().contains("Processed"), "Immediate refund processing not verified.");
    }

    public void checkEmailForConfirmation() {
        WebElement email = waitUntilElementVisible(confirmationEmail, 3);
        Assert.assertTrue(email.isDisplayed(), "Confirmation email not checked.");
    }

    public void verifyConfirmationEmailReceived() {
        WebElement email = waitUntilElementVisible(confirmationEmail, 3);
        Assert.assertTrue(email.getText().contains("Confirmation"), "Confirmation email not received.");
    }

    public void verifyOrderDetailsInDailyEmail() {
        WebElement email = waitUntilElementVisible(confirmationEmail, 3);
        Assert.assertTrue(email.getText().contains("Order Details"), "Order details not in daily email.");
    }

    public void checkCXSystemForReturnRequest() {
        WebElement cxCheck = waitUntilElementVisible(cxSystemCheck, 3);
        Assert.assertTrue(cxCheck.isDisplayed(), "CX system check for return request failed.");
    }

    public void verifyCXSystemAction() {
        WebElement cxAction = waitUntilElementVisible(cxSystemCheck, 3);
        Assert.assertTrue(cxAction.getText().contains("Action Taken"), "CX system action not verified.");
    }

    public void verifyAccessCodeRedemption() {
        WebElement accessCode = waitUntilElementVisible(accessCodeStatus, 3);
        Assert.assertTrue(accessCode.getText().contains("Redeemed"), "Access code redemption not verified.");
    }

    public void verifyAccessRevocation() {
        WebElement accessCode = waitUntilElementVisible(accessCodeStatus, 3);
        Assert.assertTrue(accessCode.getText().contains("Revoked"), "Access revocation not verified.");
    }

    public void verifyAccessCodeNotRedeemed() {
        WebElement accessCode = waitUntilElementVisible(accessCodeStatus, 3);
        Assert.assertFalse(accessCode.getText().contains("Redeemed"), "Access code should not be redeemed.");
    }

    public void verifyAccessCodeZeroedOut() {
        WebElement accessCode = waitUntilElementVisible(accessCodeStatus, 3);
        Assert.assertTrue(accessCode.getText().contains("Zeroed Out"), "Access code not zeroed out.");
    }

    public void attemptToUseAccessCode() {
        WebElement accessCode = waitUntilElementVisible(accessCodeStatus, 3);
        accessCode.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("access-denied"), "Access code usage attempt failed.");
    }

    public void verifyAccessCodeInvalid() {
        WebElement accessCode = waitUntilElementVisible(accessCodeStatus, 3);
        Assert.assertTrue(accessCode.getText().contains("Invalid"), "Access code not invalid.");
    }
}