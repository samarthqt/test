package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;

import com.pageobjects.CheckoutPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

public class CheckoutSteps extends CheckoutPage {

    @Given("the user navigates to the shopping cart page")
    public void theUserNavigatesToTheShoppingCartPage() {
        navigateToShoppingCartPage();
    }

    @Given("the shopping cart page is displayed with the selected product")
    public void theShoppingCartPageIsDisplayedWithTheSelectedProduct() {
        verifyShoppingCartPageDisplayed();
    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        proceedToCheckout();
    }

    @When("the checkout page is displayed")
    public void theCheckoutPageIsDisplayed() {
        verifyCheckoutPageDisplayed();
    }

    @When("the user selects \"Credit Card\" as the payment method")
    public void theUserSelectsCreditCardAsThePaymentMethod() {
        selectPaymentMethod("Credit Card");
    }

    @When("the credit card payment form is displayed")
    public void theCreditCardPaymentFormIsDisplayed() {
        verifyCreditCardFormDisplayed();
    }

    @When("the user enters invalid credit card details with number \"{string}\", expiration date \"{string}\", and CVV \"{string}\"")
    public void theUserEntersInvalidCreditCardDetails(String cardNumber, String expirationDate, String cvv) {
        enterCreditCardDetails(cardNumber, expirationDate, cvv);
    }

    @When("the user tries to complete the payment process")
    public void theUserTriesToCompleteThePaymentProcess() {
        attemptToCompletePayment();
    }

    @Then("an error message is displayed indicating invalid credit card information")
    public void anErrorMessageIsDisplayedIndicatingInvalidCreditCardInformation() {
        verifyInvalidCreditCardErrorMessage();
    }
}