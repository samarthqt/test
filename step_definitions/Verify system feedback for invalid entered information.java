package com.cucumber.steps;

import com.page_objects.CheckoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps extends CheckoutPage {

    @Given("the user account is logged in")
    public void theUserAccountIsLoggedIn() {
        loginToAccount();
    }

    @When("the user navigates to the checkout page")
    public void theUserNavigatesToTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @Then("the checkout page is displayed with options to enter shipping and billing addresses")
    public void theCheckoutPageIsDisplayed() {
        verifyCheckoutPageDisplayed();
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        verifyCheckoutPageDisplayed();
    }

    @When("the user enters invalid shipping address {string}")
    public void theUserEntersInvalidShippingAddress(String address) {
        enterShippingAddress(address);
    }

    @When("the user enters invalid billing address {string}")
    public void theUserEntersInvalidBillingAddress(String address) {
        enterBillingAddress(address);
    }

    @Then("the system displays error messages indicating invalid address format")
    public void theSystemDisplaysErrorMessagesForInvalidAddress() {
        verifyInvalidAddressErrorMessage();
    }

    @When("the user enters invalid phone number {string}")
    public void theUserEntersInvalidPhoneNumber(String phoneNumber) {
        enterPhoneNumber(phoneNumber);
    }

    @When("the user enters invalid email {string}")
    public void theUserEntersInvalidEmail(String email) {
        enterEmail(email);
    }

    @Then("the system displays error messages indicating invalid phone number and email format")
    public void theSystemDisplaysErrorMessagesForInvalidPhoneAndEmail() {
        verifyInvalidPhoneAndEmailErrorMessage();
    }

    @Given("the user has entered invalid information on the checkout page")
    public void theUserHasEnteredInvalidInformation() {
        enterInvalidInformation();
    }

    @When("the user attempts to save the invalid information")
    public void theUserAttemptsToSaveInvalidInformation() {
        attemptToSaveInformation();
    }

    @Then("the system prevents saving and displays error feedback")
    public void theSystemPreventsSavingAndDisplaysErrorFeedback() {
        verifySavePreventionAndErrorFeedback();
    }

    @Given("the system has displayed error messages for invalid information")
    public void theSystemHasDisplayedErrorMessages() {
        verifyErrorMessagesDisplayed();
    }

    @Then("the error messages are clear and informative, guiding users to correct the information")
    public void theErrorMessagesAreClearAndInformative() {
        verifyErrorMessageClarity();
    }

    @Given("the user has corrected the invalid information")
    public void theUserHasCorrectedInvalidInformation() {
        correctInvalidInformation();
    }

    @When("the user attempts to save the corrected information")
    public void theUserAttemptsToSaveCorrectedInformation() {
        attemptToSaveCorrectedInformation();
    }

    @Then("the system accepts corrected information and saves successfully")
    public void theSystemAcceptsCorrectedInformation() {
        verifySuccessfulSave();
    }

    @When("the user enters incomplete address information")
    public void theUserEntersIncompleteAddressInformation() {
        enterIncompleteAddressInformation();
    }

    @Then("the system prompts the user to complete the address entry before proceeding")
    public void theSystemPromptsToCompleteAddressEntry() {
        verifyPromptToCompleteAddress();
    }

    @When("the user enters invalid international address formats")
    public void theUserEntersInvalidInternationalAddressFormats() {
        enterInvalidInternationalAddress();
    }

    @Then("the system provides feedback and error messages for invalid international address formats")
    public void theSystemProvidesFeedbackForInvalidInternationalAddress() {
        verifyInternationalAddressErrorMessage();
    }

    @When("the user attempts to checkout")
    public void theUserAttemptsToCheckout() {
        attemptToCheckout();
    }

    @Then("the system prevents checkout and displays error messages for invalid information")
    public void theSystemPreventsCheckout() {
        verifyCheckoutPreventionAndErrorMessages();
    }

    @When("the user enters invalid characters in address fields")
    public void theUserEntersInvalidCharactersInAddressFields() {
        enterInvalidCharactersInAddress();
    }

    @Then("the system flags invalid characters and prevents saving")
    public void theSystemFlagsInvalidCharacters() {
        verifyInvalidCharacterFlagging();
    }

    @When("the user enters invalid email formats")
    public void theUserEntersInvalidEmailFormats() {
        enterInvalidEmailFormats();
    }

    @Then("the system displays error messages for invalid email formats")
    public void theSystemDisplaysErrorMessagesForInvalidEmailFormats() {
        verifyInvalidEmailFormatErrorMessage();
    }

    @When("the user enters invalid phone number formats")
    public void theUserEntersInvalidPhoneNumberFormats() {
        enterInvalidPhoneNumberFormats();
    }

    @Then("the system displays error messages for invalid phone number formats")
    public void theSystemDisplaysErrorMessagesForInvalidPhoneNumberFormats() {
        verifyInvalidPhoneNumberFormatErrorMessage();
    }

    @When("the user leaves required fields empty")
    public void theUserLeavesRequiredFieldsEmpty() {
        leaveRequiredFieldsEmpty();
    }

    @Then("the system prompts the user to fill in missing required fields")
    public void theSystemPromptsToFillInMissingFields() {
        verifyPromptForMissingFields();
    }

    @When("the user enters invalid postal codes")
    public void theUserEntersInvalidPostalCodes() {
        enterInvalidPostalCodes();
    }

    @Then("the system displays error messages for invalid postal codes")
    public void theSystemDisplaysErrorMessagesForInvalidPostalCodes() {
        verifyInvalidPostalCodeErrorMessage();
    }

    @Then("the system prevents saving and prompts the user to correct invalid information")
    public void theSystemPreventsSavingAndPromptsCorrection() {
        verifySavePreventionAndCorrectionPrompt();
    }
}