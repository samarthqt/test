package com.cucumber.steps;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import com.framework.cucumber.TestHarness;

import com.pageobjects.CheckoutPage;

public class CheckoutSteps extends CheckoutPage {

    @Given("the user accesses the checkout page")
    public void theUserAccessesTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @When("the user navigates to the checkout page")
    public void theUserNavigatesToTheCheckoutPage() {
        verifyCheckoutPageDisplayed();
    }

    @Then("the checkout page is displayed")
    public void theCheckoutPageIsDisplayed() {
        assertCheckoutPageDisplayed();
    }

    @Given("items are in the cart")
    public void itemsAreInTheCart() {
        verifyItemsInCart();
    }

    @When("the user selects 'Checkout as Guest' option")
    public void theUserSelectsCheckoutAsGuestOption() {
        selectGuestCheckoutOption();
    }

    @Then("the guest checkout form is displayed")
    public void theGuestCheckoutFormIsDisplayed() {
        assertGuestCheckoutFormDisplayed();
    }

    @Given("the guest checkout form is displayed")
    public void theGuestCheckoutFormIsDisplayedAgain() {
        assertGuestCheckoutFormDisplayed();
    }

    @When("the user enters shipping address details as \"{string}\"")
    public void theUserEntersShippingAddressDetailsAs(String address) {
        enterShippingAddressDetails(address);
    }

    @Then("the shipping address is accepted and validated")
    public void theShippingAddressIsAcceptedAndValidated() {
        assertShippingAddressValidated();
    }

    @Given("the shipping address is validated")
    public void theShippingAddressIsValidated() {
        assertShippingAddressValidated();
    }

    @When("the user selects a shipping method")
    public void theUserSelectsAShippingMethod() {
        selectShippingMethod();
    }

    @Then("the shipping method is selected")
    public void theShippingMethodIsSelected() {
        assertShippingMethodSelected();
    }

    @Given("a shipping method is selected")
    public void aShippingMethodIsSelected() {
        assertShippingMethodSelected();
    }

    @When("the user enters payment details using a valid credit card")
    public void theUserEntersPaymentDetailsUsingAValidCreditCard() {
        enterPaymentDetails();
    }

    @Then("the payment details are accepted and validated")
    public void thePaymentDetailsAreAcceptedAndValidated() {
        assertPaymentDetailsValidated();
    }

    @Given("the payment details are validated")
    public void thePaymentDetailsAreValidated() {
        assertPaymentDetailsValidated();
    }

    @When("the user reviews the order summary")
    public void theUserReviewsTheOrderSummary() {
        reviewOrderSummary();
    }

    @Then("the order summary displays correct items and total")
    public void theOrderSummaryDisplaysCorrectItemsAndTotal() {
        assertOrderSummaryCorrect();
    }

    @Given("the order summary is correct")
    public void theOrderSummaryIsCorrect() {
        assertOrderSummaryCorrect();
    }

    @When("the user clicks 'Place Order' button")
    public void theUserClicksPlaceOrderButton() {
        placeOrder();
    }

    @Then("the order is placed successfully and a confirmation message is displayed")
    public void theOrderIsPlacedSuccessfullyAndAConfirmationMessageIsDisplayed() {
        assertOrderPlacedSuccessfully();
    }

    @Given("the order is placed successfully")
    public void theOrderIsPlacedSuccessfully() {
        assertOrderPlacedSuccessfully();
    }

    @When("the user checks their email")
    public void theUserChecksTheirEmail() {
        checkEmailForConfirmation();
    }

    @Then("the order confirmation email is received")
    public void theOrderConfirmationEmailIsReceived() {
        assertOrderConfirmationEmailReceived();
    }
}

