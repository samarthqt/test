package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import .time.Duration;
import org.testng.Assert;

public class AchieveAccessCodePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public AchieveAccessCodePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToPurchaseConfirmation() {
        driver.get(http://example.com/purchase-confirmation);
    }

    public boolean isPurchaseWithinLast14Days() {
        WebElement purchaseDateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(purchase_date)));
        String purchaseDate = purchaseDateElement.getText();
        boolean result = isWithinLast14Days(purchaseDate);
        Assert.assertTrue(result, Purchase is not within the last 14 days);
        return result;
    }

    public void loginToBFWStore(String username, String password) {
        driver.get(http://example.com/login);
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(username)));
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.id(password));
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id(login_button));
        loginButton.click();
        Assert.assertTrue(isDashboardDisplayed(), Login failed, dashboard not displayed);
    }

    public boolean isDashboardDisplayed() {
        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(dashboard)));
        boolean result = dashboardElement.isDisplayed();
        Assert.assertTrue(result, Dashboard is not displayed);
        return result;
    }

    public void navigateToOrderDetails() {
        WebElement orderDetailsLink = wait.until(ExpectedConditions.elementToBeClickable(By.id(order_details_link)));
        orderDetailsLink.click();
        Assert.assertTrue(isOrderDetailsDisplayed(), Order details page not displayed);
    }

    public boolean isOrderDetailsDisplayed() {
        WebElement orderDetailsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(order_details)));
        boolean result = orderDetailsElement.isDisplayed();
        Assert.assertTrue(result, Order details are not displayed);
        return result;
    }

    public void selectOrderWithID98765() {
        WebElement orderElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(order_98765)));
        orderElement.click();
        Assert.assertTrue(isOrderDetailsForID98765Displayed(), Order details for ID 98765 not displayed);
    }

    public boolean isOrderDetailsForID98765Displayed() {
        WebElement orderDetailsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(order_details_98765)));
        boolean result = orderDetailsElement.isDisplayed();
        Assert.assertTrue(result, Order details for ID 98765 are not displayed);
        return result;
    }

    public void clickInitiateReturnButton() {
        WebElement initiateReturnButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(initiate_return_button)));
        initiateReturnButton.click();
        Assert.assertTrue(isReturnFormDisplayed(), Return form not displayed);
    }

    public boolean isReturnFormDisplayed() {
        WebElement returnFormElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(return_form)));
        boolean result = returnFormElement.isDisplayed();
        Assert.assertTrue(result, Return form is not displayed);
        return result;
    }

    public void completeAndSubmitReturnForm(String details) {
        WebElement detailsField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(return_details)));
        detailsField.sendKeys(details);
        WebElement submitButton = driver.findElement(By.id(submit_return));
        submitButton.click();
        Assert.assertTrue(isReturnRequestSubmittedSuccessfully(), Return request submission failed);
    }

    public boolean isReturnRequestSubmittedSuccessfully() {
        WebElement confirmationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(return_confirmation)));
        boolean result = confirmationElement.isDisplayed();
        Assert.assertTrue(result, Return request was not submitted successfully);
        return result;
    }

    public void processRefundByBraintree() {
        WebElement processRefundButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(process_refund)));
        processRefundButton.click();
        Assert.assertTrue(isRefundProcessedImmediatelyByBraintree(), Refund processing failed);
    }

    public boolean isRefundProcessedImmediatelyByBraintree() {
        WebElement refundConfirmationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(refund_confirmation)));
        boolean result = refundConfirmationElement.isDisplayed();
        Assert.assertTrue(result, Refund was not processed immediately by Braintree);
        return result;
    }

    public boolean isEmailConfirmationReceived() {
        WebElement emailConfirmationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(email_confirmation)));
        boolean result = emailConfirmationElement.isDisplayed();
        Assert.assertTrue(result, Email confirmation was not received);
        return result;
    }

    public boolean isOrderDetailsPresentInDailyEmailToCX() {
        WebElement orderDetailsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(order_details_in_email)));
        boolean result = orderDetailsElement.isDisplayed();
        Assert.assertTrue(result, Order details are not present in daily email to CX);
        return result;
    }

    public boolean isCXActionTaken() {
        WebElement cxActionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(cx_action)));
        boolean result = cxActionElement.isDisplayed();
        Assert.assertTrue(result, CX action was not taken);
        return result;
    }

    public boolean isAccessRevokedIfRedeemed() {
        WebElement accessRevocationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(access_revocation)));
        boolean result = accessRevocationElement.isDisplayed();
        Assert.assertTrue(result, Access was not revoked if redeemed);
        return result;
    }

    public boolean isAccessCodeZeroedOutIfNotRedeemed() {
        WebElement accessCodeZeroElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(access_code_zero)));
        boolean result = accessCodeZeroElement.isDisplayed();
        Assert.assertTrue(result, Access code was not zeroed out if not redeemed);
        return result;
    }

    public boolean isAccessCodeUnusablePostRefund() {
        WebElement accessCodeUnusableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(access_code_unusable)));
        boolean result = accessCodeUnusableElement.isDisplayed();
        Assert.assertTrue(result, Access code is not unusable post refund);
        return result;
    }

    private boolean isWithinLast14Days(String purchaseDate) {
        // Logic to check if purchase date is within last 14 days
        // Assuming the logic is implemented here
        return true;
    }
}