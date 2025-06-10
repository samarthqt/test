package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CheckoutPage;

public class PaymentMethodsSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @When("the user proceeds to the payment section")
    public void theUserProceedsToThePaymentSection() {
        proceedToPaymentSection();
    }

    @Then("all available payment options should be displayed")
    public void allAvailablePaymentOptionsShouldBeDisplayed() {
        verifyPaymentOptionsDisplayed();
    }

    @Given("all available payment options are displayed")
    public void allAvailablePaymentOptionsAreDisplayed() {
        verifyPaymentOptionsDisplayed();
    }

    @When("the user selects a valid payment method")
    public void theUserSelectsAValidPaymentMethod() {
        selectValidPaymentMethod();
    }

    @Then("the system should validate the selected payment method")
    public void theSystemShouldValidateTheSelectedPaymentMethod() {
        validateSelectedPaymentMethod();
    }

    @Given("the user has selected a valid payment method")
    public void theUserHasSelectedAValidPaymentMethod() {
        selectValidPaymentMethod();
    }

    @When("the payment method is validated successfully")
    public void thePaymentMethodIsValidatedSuccessfully() {
        validateSelectedPaymentMethod();
    }

    @Then("the user should receive a confirmation of successful payment method selection")
    public void theUserShouldReceiveAConfirmationOfSuccessfulPaymentMethodSelection() {
        verifyPaymentMethodConfirmation();
    }

    @Given("the user selects an invalid payment method")
    public void theUserSelectsAnInvalidPaymentMethod() {
        selectInvalidPaymentMethod();
    }

    @When("the system attempts to validate the selected payment method")
    public void theSystemAttemptsToValidateTheSelectedPaymentMethod() {
        attemptToValidateInvalidPaymentMethod();
    }

    @Then("the user should be prompted to choose another payment option")
    public void theUserShouldBePromptedToChooseAnotherPaymentOption() {
        promptUserToChooseAnotherOption();
    }

    @Given("the user accesses the checkout page on any device")
    public void theUserAccessesTheCheckoutPageOnAnyDevice() {
        navigateToCheckoutPage();
    }

    @When("the user navigates to the payment section")
    public void theUserNavigatesToThePaymentSection() {
        proceedToPaymentSection();
    }

    @Then("the UI should be intuitive and responsive across all devices")
    public void theUIShouldBeIntuitiveAndResponsiveAcrossAllDevices() {
        verifyUIResponsiveness();
    }
}