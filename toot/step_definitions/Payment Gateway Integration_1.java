import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class PaymentGatewayStepDefinitions {

    WebDriver driver;
    WebDriverWait wait;

    public PaymentGatewayStepDefinitions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void givenUserSelectsStripe() {
        WebElement stripeOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("stripe_option")));
        stripeOption.click();
    }

    public void whenUserProceedsToCheckout() {
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout_button")));
        checkoutButton.click();
    }

    public void andUserEntersValidPaymentDetails() {
        WebElement cardNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("card_number")));
        cardNumberField.sendKeys("4111111111111111");
        WebElement expiryDateField = driver.findElement(By.id("expiry_date"));
        expiryDateField.sendKeys("12/23");
        WebElement cvvField = driver.findElement(By.id("cvv"));
        cvvField.sendKeys("123");
    }

    public void thenPaymentShouldBeProcessedSuccessfully() {
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payment_success")));
        Assert.assertTrue("Payment not processed successfully", successMessage.isDisplayed());
    }

    public void andUserShouldReceiveConfirmation() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation_message")));
        Assert.assertTrue("Confirmation not received", confirmationMessage.isDisplayed());
    }

    public void givenUserSelectsPayPal() {
        WebElement paypalOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("paypal_option")));
        paypalOption.click();
    }

    public void andUserIsRedirectedToPayPalLoginPage() {
        WebElement paypalLoginPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("paypal_login")));
        Assert.assertTrue("Not redirected to PayPal login page", paypalLoginPage.isDisplayed());
    }

    public void andUserLogsInWithValidPayPalCredentials() {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("paypal_email")));
        emailField.sendKeys("user@example.com");
        WebElement passwordField = driver.findElement(By.id("paypal_password"));
        passwordField.sendKeys("password123");
        WebElement loginButton = driver.findElement(By.id("paypal_login_button"));
        loginButton.click();
    }

    public void andUserConfirmsPayment() {
        WebElement confirmPaymentButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("confirm_payment")));
        confirmPaymentButton.click();
    }

    public void givenUserEntersInvalidPaymentDetails() {
        WebElement cardNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("card_number")));
        cardNumberField.sendKeys("1234567890123456");
        WebElement expiryDateField = driver.findElement(By.id("expiry_date"));
        expiryDateField.sendKeys("01/20");
        WebElement cvvField = driver.findElement(By.id("cvv"));
        cvvField.sendKeys("000");
    }

    public void thenPaymentShouldBeDeclined() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payment_error")));
        Assert.assertTrue("Payment not declined", errorMessage.isDisplayed());
    }

    public void andUserShouldReceiveErrorMessage() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_message")));
        Assert.assertTrue("Error message not received", errorMessage.isDisplayed());
    }

    public void givenUserEntersInvalidPayPalCredentials() {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("paypal_email")));
        emailField.sendKeys("invalid@example.com");
        WebElement passwordField = driver.findElement(By.id("paypal_password"));
        passwordField.sendKeys("wrongpassword");
        WebElement loginButton = driver.findElement(By.id("paypal_login_button"));
        loginButton.click();
    }

    public void thenUserShouldNotBeAbleToLogIn() {
        WebElement loginErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_error")));
        Assert.assertTrue("Login error message not displayed", loginErrorMessage.isDisplayed());
    }

    public void givenUserIsOnCheckoutPage() {
        WebElement checkoutPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout_page")));
        Assert.assertTrue("Not on checkout page", checkoutPage.isDisplayed());
    }

    public void whenUserSelectsPaymentProvider() {
        WebElement paymentProviderDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payment_provider")));
        paymentProviderDropdown.click();
        WebElement providerOption = driver.findElement(By.id("provider_option"));
        providerOption.click();
    }

    public void thenSelectedProviderShouldBeDisplayed() {
        WebElement selectedProvider = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("selected_provider")));
        Assert.assertTrue("Selected provider not displayed", selectedProvider.isDisplayed());
    }

    public void givenPaymentIsProcessedSuccessfully() {
        WebElement paymentSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payment_success")));
        Assert.assertTrue("Payment not processed successfully", paymentSuccess.isDisplayed());
    }

    public void whenUserReceivesConfirmation() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation_message")));
        Assert.assertTrue("Confirmation not received", confirmationMessage.isDisplayed());
    }

    public void thenConfirmationShouldIncludeDetails() {
        WebElement transactionId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transaction_id")));
        WebElement amount = driver.findElement(By.id("amount"));
        WebElement paymentMethod = driver.findElement(By.id("payment_method"));
        Assert.assertTrue("Transaction ID not included", transactionId.isDisplayed());
        Assert.assertTrue("Amount not included", amount.isDisplayed());
        Assert.assertTrue("Payment method not included", paymentMethod.isDisplayed());
    }
}