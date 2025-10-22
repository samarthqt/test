package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;

import com.pageobjects.CheckoutPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

public class PayPalPaymentSteps extends CheckoutPage {

    @Given("a product is available in the shopping cart")
    public void aProductIsAvailableInTheShoppingCart() {
        addProductToCart("Sample Product", "1");
    }

    @When("the user navigates to the shopping cart page")
    public void theUserNavigatesToTheShoppingCartPage() {
        navigateToShoppingCart();
    }

    @Then("the shopping cart page is displayed with the selected product")
    public void theShoppingCartPageIsDisplayedWithTheSelectedProduct() {
        verifyProductInCart("Sample Product");
    }

    @When("the user selects 'Proceed to Checkout'")
    public void theUserSelectsProceedToCheckout() {
        proceedToCheckout();
    }

    @Then("the checkout page is displayed")
    public void theCheckoutPageIsDisplayed() {
        verifyCheckoutPageDisplayed();
    }

    @When("the user selects 'PayPal' as the payment method")
    public void theUserSelectsPayPalAsThePaymentMethod() {
        selectPaymentMethod("PayPal");
    }

    @Then("the user is redirected to the PayPal login page")
    public void theUserIsRedirectedToThePayPalLoginPage() {
        verifyPayPalLoginPageDisplayed();
    }

    @When("the user logs into PayPal with valid credentials")
    public void theUserLogsIntoPayPalWithValidCredentials() {
        loginToPayPal("user@example.com", "password123");
    }

    @Then("the PayPal login is successful")
    public void thePayPalLoginIsSuccessful() {
        verifyPayPalLoginSuccess();
    }

    @When("the user authorizes the payment")
    public void theUserAuthorizesThePayment() {
        authorizePayPalPayment();
    }

    @Then("the payment is authorized and processed")
    public void thePaymentIsAuthorizedAndProcessed() {
        verifyPaymentProcessed();
    }

    @When("the user verifies the order confirmation page is displayed")
    public void theUserVerifiesTheOrderConfirmationPageIsDisplayed() {
        verifyOrderConfirmationPageDisplayed();
    }

    @Then("the order confirmation page is displayed with order details")
    public void theOrderConfirmationPageIsDisplayedWithOrderDetails() {
        verifyOrderDetails();
    }

    @When("the user checks the email inbox for a confirmation email")
    public void theUserChecksTheEmailInboxForAConfirmationEmail() {
        checkEmailForConfirmation();
    }

    @Then("the order confirmation email is received in the inbox")
    public void theOrderConfirmationEmailIsReceivedInTheInbox() {
        verifyConfirmationEmailReceived();
    }
}