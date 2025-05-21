import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import io.cucumber.java.en.*;
import java.time.Duration;

public class PaymentStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    CheckoutPage checkoutPage;

    @Given("the user is on the checkout page")
    public void the_user_is_on_the_checkout_page() {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        checkoutPage = new CheckoutPage(driver);
        driver.get("http://example.com/checkout");
    }

    @When("the user selects {string} as the payment method")
    public void the_user_selects_as_the_payment_method(String paymentMethod) {
        checkoutPage.selectPaymentMethod(paymentMethod);
    }

    @When("the user enters valid payment details")
    public void the_user_enters_valid_payment_details() {
        checkoutPage.enterValidPaymentDetails();
    }

    @When("the user enters invalid credit card details")
    public void the_user_enters_invalid_credit_card_details() {
        checkoutPage.enterInvalidCreditCardDetails();
    }

    @When("the user enters invalid PayPal account details")
    public void the_user_enters_invalid_paypal_account_details() {
        checkoutPage.enterInvalidPayPalDetails();
    }

    @When("the user decides to cancel the payment")
    public void the_user_decides_to_cancel_the_payment() {
        checkoutPage.cancelPayment();
    }

    @When("the user confirms the payment")
    public void the_user_confirms_the_payment() {
        checkoutPage.confirmPayment();
    }

    @Then("the payment should be processed successfully")
    public void the_payment_should_be_processed_successfully() {
        Assert.assertTrue(checkoutPage.isPaymentSuccessful());
    }

    @Then("the payment should not be processed")
    public void the_payment_should_not_be_processed() {
        Assert.assertFalse(checkoutPage.isPaymentSuccessful());
    }

    @Then("the user should see a confirmation message")
    public void the_user_should_see_a_confirmation_message() {
        Assert.assertTrue(checkoutPage.isConfirmationMessageDisplayed());
    }

    @Then("the user should see an error message indicating invalid payment details")
    public void the_user_should_see_an_error_message_indicating_invalid_payment_details() {
        Assert.assertTrue(checkoutPage.isErrorMessageDisplayed());
    }

    @Then("the user should be redirected back to the checkout page")
    public void the_user_should_be_redirected_back_to_the_checkout_page() {
        Assert.assertTrue(checkoutPage.isOnCheckoutPage());
    }

    @Then("the user should receive a confirmation email")
    public void the_user_should_receive_a_confirmation_email() {
        Assert.assertTrue(checkoutPage.isConfirmationEmailReceived());
    }
}