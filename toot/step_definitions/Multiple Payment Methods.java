import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import io.cucumber.java.en.*;

public class PaymentSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("the user is on the checkout page")
    public void userOnCheckoutPage() {
        driver.get("http://example.com/checkout");
    }

    @When("the user selects {string} as the payment method")
    public void userSelectsPaymentMethod(String method) {
        WebElement paymentMethod = wait.until(ExpectedConditions.elementToBeClickable(By.id(method.toLowerCase() + "_option")));
        paymentMethod.click();
    }

    @And("the user enters valid credit card details")
    public void userEntersValidCreditCardDetails() {
        enterCardDetails("4111111111111111", "12/23", "123");
    }

    @And("the user enters valid debit card details")
    public void userEntersValidDebitCardDetails() {
        enterCardDetails("5500000000000004", "12/23", "123");
    }

    @And("the user enters invalid credit card details")
    public void userEntersInvalidCreditCardDetails() {
        enterCardDetails("1234567890123456", "12/23", "123");
    }

    @And("the user enters invalid debit card details")
    public void userEntersInvalidDebitCardDetails() {
        enterCardDetails("6543210987654321", "12/23", "123");
    }

    @And("the user submits the payment")
    public void userSubmitsPayment() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit_payment")));
        submitButton.click();
    }

    @Then("the payment should be processed successfully")
    public void paymentProcessedSuccessfully() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation_message")));
        Assert.assertTrue("Payment not processed", confirmationMessage.isDisplayed());
    }

    @Then("the payment should be declined")
    public void paymentShouldBeDeclined() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_message")));
        Assert.assertTrue("Payment was not declined", errorMessage.isDisplayed());
    }

    @And("the user should see a confirmation message")
    public void userSeesConfirmationMessage() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation_message")));
        Assert.assertTrue("Confirmation message not displayed", confirmationMessage.isDisplayed());
    }

    @And("the user should see an error message indicating invalid card details")
    public void userSeesErrorMessage() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_message")));
        Assert.assertTrue("Error message not displayed", errorMessage.isDisplayed());
    }

    @And("the user is redirected to the PayPal login page")
    public void userRedirectedToPayPal() {
        Assert.assertTrue("Not redirected to PayPal", driver.getCurrentUrl().contains("paypal.com"));
    }

    @And("the user logs in with valid PayPal credentials")
    public void userLogsInToPayPal() {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        emailField.sendKeys("user@example.com");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password123");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
    }

    @And("the user confirms the payment")
    public void userConfirmsPayment() {
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("confirm_payment")));
        confirmButton.click();
    }

    @And("the user cancels the payment")
    public void userCancelsPayment() {
        WebElement cancelButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cancel_payment")));
        cancelButton.click();
    }

    @Then("the user should be redirected back to the confirmation page")
    public void userRedirectedToConfirmationPage() {
        Assert.assertTrue("Not redirected to confirmation page", driver.getCurrentUrl().contains("confirmation"));
    }

    @Then("the user should be redirected back to the checkout page")
    public void userRedirectedToCheckoutPage() {
        Assert.assertTrue("Not redirected to checkout page", driver.getCurrentUrl().contains("checkout"));
    }

    @And("the payment should not be processed")
    public void paymentNotProcessed() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error_message")));
        Assert.assertTrue("Payment was processed", errorMessage.isDisplayed());
    }

    private void enterCardDetails(String cardNumber, String expiryDate, String cvv) {
        WebElement cardNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("card_number")));
        cardNumberField.sendKeys(cardNumber);
        WebElement expiryDateField = driver.findElement(By.id("expiry_date"));
        expiryDateField.sendKeys(expiryDate);
        WebElement cvvField = driver.findElement(By.id("cvv"));
        cvvField.sendKeys(cvv);
    }
}