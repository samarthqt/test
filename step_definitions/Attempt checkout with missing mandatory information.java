package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CheckoutPage;

public class CheckoutSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has items in the shopping cart")
    public void theUserHasItemsInTheShoppingCart() {
        // Assume items are already in the cart
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @When("the user proceeds to checkout without entering the shipping address")
    public void theUserProceedsToCheckoutWithoutEnteringTheShippingAddress() {
        proceedToCheckoutWithoutShippingAddress();
    }

    @When("the user enters an incorrect billing address format")
    public void theUserEntersAnIncorrectBillingAddressFormat() {
        enterIncorrectBillingAddress();
    }

    @When("the user leaves the payment method field empty and attempts checkout")
    public void theUserLeavesThePaymentMethodFieldEmptyAndAttemptsCheckout() {
        leavePaymentMethodEmptyAndCheckout();
    }

    @When("the user enters an invalid credit card number and attempts checkout")
    public void theUserEntersAnInvalidCreditCardNumberAndAttemptsCheckout() {
        enterInvalidCreditCardNumberAndCheckout();
    }

    @When("the user enters expired credit card details and attempts checkout")
    public void theUserEntersExpiredCreditCardDetailsAndAttemptsCheckout() {
        enterExpiredCreditCardDetailsAndCheckout();
    }

    @When("the user attempts checkout without agreeing to terms and conditions")
    public void theUserAttemptsCheckoutWithoutAgreeingToTermsAndConditions() {
        attemptCheckoutWithoutAgreeingToTerms();
    }

    @When("the user attempts to use a promo code that is expired")
    public void theUserAttemptsToUseAPromoCodeThatIsExpired() {
        useExpiredPromoCode();
    }

    @When("the user attempts checkout with an invalid CVV number")
    public void theUserAttemptsCheckoutWithAnInvalidCVVNumber() {
        enterInvalidCVVAndCheckout();
    }

    @When("the user attempts checkout with incorrect zip code for billing address")
    public void theUserAttemptsCheckoutWithIncorrectZipCodeForBillingAddress() {
        enterIncorrectZipCodeAndCheckout();
    }

    @When("the user attempts checkout with incorrect cardholder name")
    public void theUserAttemptsCheckoutWithIncorrectCardholderName() {
        enterIncorrectCardholderNameAndCheckout();
    }

    @When("the user attempts checkout with incorrect expiration date")
    public void theUserAttemptsCheckoutWithIncorrectExpirationDate() {
        enterIncorrectExpirationDateAndCheckout();
    }

    @When("the user attempts checkout with incorrect shipping address format")
    public void theUserAttemptsCheckoutWithIncorrectShippingAddressFormat() {
        enterIncorrectShippingAddressFormat();
    }

    @When("the user attempts checkout with missing phone number for shipping address")
    public void theUserAttemptsCheckoutWithMissingPhoneNumberForShippingAddress() {
        enterMissingPhoneNumberAndCheckout();
    }

    @Then("an error message is displayed indicating missing shipping information")
    public void anErrorMessageIsDisplayedIndicatingMissingShippingInformation() {
        verifyErrorMessage("Missing shipping information");
    }

    @Then("an error message is displayed indicating incorrect billing address format")
    public void anErrorMessageIsDisplayedIndicatingIncorrectBillingAddressFormat() {
        verifyErrorMessage("Incorrect billing address format");
    }

    @Then("an error message is displayed indicating missing payment information")
    public void anErrorMessageIsDisplayedIndicatingMissingPaymentInformation() {
        verifyErrorMessage("Missing payment information");
    }

    @Then("an error message is displayed indicating invalid credit card number")
    public void anErrorMessageIsDisplayedIndicatingInvalidCreditCardNumber() {
        verifyErrorMessage("Invalid credit card number");
    }

    @Then("an error message is displayed indicating expired credit card details")
    public void anErrorMessageIsDisplayedIndicatingExpiredCreditCardDetails() {
        verifyErrorMessage("Expired credit card details");
    }

    @Then("an error message is displayed indicating agreement to terms is required")
    public void anErrorMessageIsDisplayedIndicatingAgreementToTermsIsRequired() {
        verifyErrorMessage("Agreement to terms is required");
    }

    @Then("an error message is displayed indicating promo code is expired")
    public void anErrorMessageIsDisplayedIndicatingPromoCodeIsExpired() {
        verifyErrorMessage("Promo code is expired");
    }

    @Then("an error message is displayed indicating invalid CVV number")
    public void anErrorMessageIsDisplayedIndicatingInvalidCVVNumber() {
        verifyErrorMessage("Invalid CVV number");
    }

    @Then("an error message is displayed indicating incorrect zip code")
    public void anErrorMessageIsDisplayedIndicatingIncorrectZipCode() {
        verifyErrorMessage("Incorrect zip code");
    }

    @Then("an error message is displayed indicating incorrect cardholder name")
    public void anErrorMessageIsDisplayedIndicatingIncorrectCardholderName() {
        verifyErrorMessage("Incorrect cardholder name");
    }

    @Then("an error message is displayed indicating incorrect expiration date")
    public void anErrorMessageIsDisplayedIndicatingIncorrectExpirationDate() {
        verifyErrorMessage("Incorrect expiration date");
    }

    @Then("an error message is displayed indicating incorrect shipping address format")
    public void anErrorMessageIsDisplayedIndicatingIncorrectShippingAddressFormat() {
        verifyErrorMessage("Incorrect shipping address format");
    }

    @Then("an error message is displayed indicating missing phone number")
    public void anErrorMessageIsDisplayedIndicatingMissingPhoneNumber() {
        verifyErrorMessage("Missing phone number");
    }
}