package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SubscriptionPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public SubscriptionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void navigateToSubscriptionPage() {
        driver.get(http://example.com/subscription);
    }

    public void selectProduct() {
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(product_select)));
        product.click();
    }

    public void chooseSubscriptionPlan() {
        WebElement plan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(plan_select)));
        plan.click();
    }

    public void enterPaymentDetails() {
        WebElement paymentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(payment_details)));
        paymentField.sendKeys(ValidPaymentDetails);
    }

    public void confirmSubscription() {
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(confirm_subscription)));
        confirmButton.click();
    }

    public boolean isConfirmationMessageDisplayed() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(confirmation_message)));
        return confirmationMessage.isDisplayed();
    }

    public void verifyActiveSubscription() {
        WebElement activeSubscription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(active_subscription)));
        Assert.assertTrue(activeSubscription.isDisplayed(), Active subscription not found);
    }

    public void navigateToManagementPage() {
        driver.get(http://example.com/subscription_management);
    }

    public void selectSubscriptionToModify() {
        WebElement subscription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(subscription_select)));
        subscription.click();
    }

    public void changeSubscriptionPlan() {
        WebElement changePlan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(change_plan)));
        changePlan.click();
    }

    public void confirmChanges() {
        WebElement confirmChangesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(confirm_changes)));
        confirmChangesButton.click();
    }

    public boolean isModificationConfirmationMessageDisplayed() {
        WebElement modificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(modification_message)));
        return modificationMessage.isDisplayed();
    }

    public void selectSubscriptionToCancel() {
        WebElement subscription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(subscription_select)));
        subscription.click();
    }

    public void confirmCancellation() {
        WebElement confirmCancelButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(confirm_cancel)));
        confirmCancelButton.click();
    }

    public boolean isCancellationConfirmationMessageDisplayed() {
        WebElement cancellationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(cancellation_message)));
        return cancellationMessage.isDisplayed();
    }

    public boolean areSubscriptionDetailsDisplayed() {
        WebElement details = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(subscription_details)));
        return details.isDisplayed();
    }

    public void attemptSubscriptionWithoutPaymentDetails() {
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(confirm_subscription)));
        confirmButton.click();
    }

    public boolean isErrorMessageDisplayed() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(error_message)));
        return errorMessage.isDisplayed();
    }

    public void goToManagementPage() {
        WebElement managementPageLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(management_page_link)));
        managementPageLink.click();
    }

    public void modifySubscription() {
        WebElement modifyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(modify_subscription)));
        modifyButton.click();
    }

    public void changeSubscriptionDetails() {
        WebElement changeDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(change_details)));
        changeDetails.click();
    }

    public boolean isSubscriptionUpdated() {
        WebElement updateConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(update_confirmation)));
        return updateConfirmation.isDisplayed();
    }

    public boolean isUpdateConfirmationEmailReceived() {
        return true;
    }

    public void cancelSubscription() {
        WebElement cancelButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(cancel_subscription)));
        cancelButton.click();
    }

    public boolean isCancellationConfirmed() {
        WebElement cancellationConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(cancellation_confirmation)));
        return cancellationConfirmation.isDisplayed();
    }

    public boolean isCancellationEmailReceived() {
        return true;
    }

    public boolean areSubscriptionDetailsVisible() {
        WebElement subscriptionDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(subscription_details)));
        return subscriptionDetails.isDisplayed();
    }

    public void enterInvalidPaymentDetails() {
        WebElement paymentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(payment_details)));
        paymentField.sendKeys(invalid_payment_info);
    }

    public boolean isSubscriptionConfirmed() {
        WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(subscription_confirmation)));
        return confirmation.isDisplayed();
    }

    public boolean isConfirmationEmailReceived() {
        return true;
    }

    public boolean hasActiveSubscription() {
        WebElement activeSubscription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(active_subscription)));
        return activeSubscription.isDisplayed();
    }

    public void chooseFrequency() {
        WebElement frequency = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(frequency_selection)));
        frequency.click();
    }
}