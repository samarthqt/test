package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import .time.Duration;

public class PaymentGatewayPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public PaymentGatewayPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectStripe() {
        WebElement stripeOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(stripe_option)));
        stripeOption.click();
        assert stripeOption.isDisplayed() : Stripe option not selected;
    }

    public void proceedToCheckout() {
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(checkout_button)));
        checkoutButton.click();
        assert checkoutButton.isDisplayed() : Checkout button not clicked;
    }

    public void enterPaymentDetails(String cardNumber, String expiryDate, String cvv) {
        WebElement cardNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(card_number)));
        cardNumberField.sendKeys(cardNumber);
        WebElement expiryDateField = driver.findElement(By.id(expiry_date));
        expiryDateField.sendKeys(expiryDate);
        WebElement cvvField = driver.findElement(By.id(cvv));
        cvvField.sendKeys(cvv);
        assert cardNumberField.isDisplayed() && expiryDateField.isDisplayed() && cvvField.isDisplayed() : Payment details not entered correctly;
    }

    public boolean isPaymentProcessedSuccessfully() {
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(payment_success)));
        return successMessage.isDisplayed();
    }

    public boolean isConfirmationReceived() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(confirmation_message)));
        return confirmationMessage.isDisplayed();
    }

    public void selectPayPal() {
        WebElement paypalOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(paypal_option)));
        paypalOption.click();
        assert paypalOption.isDisplayed() : PayPal option not selected;
    }

    public boolean isRedirectedToPayPalLoginPage() {
        WebElement paypalLoginPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(paypal_login)));
        return paypalLoginPage.isDisplayed();
    }

    public void loginToPayPal(String email, String password) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(paypal_email)));
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.id(paypal_password));
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id(paypal_login_button));
        loginButton.click();
        assert emailField.isDisplayed() && passwordField.isDisplayed() : PayPal login details not entered correctly;
    }

    public void confirmPayPalPayment() {
        WebElement confirmPaymentButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(confirm_payment)));
        confirmPaymentButton.click();
        assert confirmPaymentButton.isDisplayed() : PayPal payment not confirmed;
    }

    public boolean isPaymentDeclined() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(payment_error)));
        return errorMessage.isDisplayed();
    }

    public boolean isErrorMessageReceived() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(error_message)));
        return errorMessage.isDisplayed();
    }

    public boolean isLoginErrorDisplayed() {
        WebElement loginErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(login_error)));
        return loginErrorMessage.isDisplayed();
    }

    public boolean isOnCheckoutPage() {
        WebElement checkoutPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(checkout_page)));
        return checkoutPage.isDisplayed();
    }

    public void selectPaymentProvider(String providerId) {
        WebElement paymentProviderDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(payment_provider)));
        paymentProviderDropdown.click();
        WebElement providerOption = driver.findElement(By.id(providerId));
        providerOption.click();
        assert providerOption.isDisplayed() : Payment provider not selected;
    }

    public boolean isSelectedProviderDisplayed() {
        WebElement selectedProvider = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(selected_provider)));
        return selectedProvider.isDisplayed();
    }

    public boolean isPaymentSuccessDisplayed() {
        WebElement paymentSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(payment_success)));
        return paymentSuccess.isDisplayed();
    }

    public boolean isConfirmationMessageDisplayed() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(confirmation_message)));
        return confirmationMessage.isDisplayed();
    }

    public boolean isTransactionDetailsDisplayed() {
        WebElement transactionId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(transaction_id)));
        WebElement amount = driver.findElement(By.id(amount));
        WebElement paymentMethod = driver.findElement(By.id(payment_method));
        return transactionId.isDisplayed() && amount.isDisplayed() && paymentMethod.isDisplayed();
    }
}