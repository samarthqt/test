package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CheckoutPage;

public class CheckoutSteps extends CheckoutPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user account is logged in")
    public void theUserAccountIsLoggedIn() {
        loginToAccount();
    }

    @When("the user navigates to the checkout page")
    public void theUserNavigatesToTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @Then("the checkout page is displayed with options to enter shipping and billing addresses")
    public void theCheckoutPageIsDisplayedWithOptions() {
        verifyCheckoutPageOptions();
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        verifyOnCheckoutPage();
    }

    @When("the user enters international address details for shipping as {string}")
    public void theUserEntersInternationalAddressDetailsForShipping(String address) {
        enterShippingAddress(address);
    }

    @When("the user enters international address details for billing as {string}")
    public void theUserEntersInternationalAddressDetailsForBilling(String address) {
        enterBillingAddress(address);
    }

    @When("the user enters various international address formats")
    public void theUserEntersVariousInternationalAddressFormats() {
        enterVariousInternationalAddresses();
    }

    @When("the user enters a non-standard address format as {string}")
    public void theUserEntersANonStandardAddressFormat(String address) {
        enterNonStandardAddress(address);
    }

    @When("the user enters an international address")
    public void theUserEntersAnInternationalAddress() {
        enterInternationalAddress();
    }

    @When("the user enters international postal codes")
    public void theUserEntersInternationalPostalCodes() {
        enterInternationalPostalCodes();
    }

    @When("the user enters an international address with special characters")
    public void theUserEntersAnInternationalAddressWithSpecialCharacters() {
        enterAddressWithSpecialCharacters();
    }

    @When("the user enters an incomplete international address")
    public void theUserEntersAnIncompleteInternationalAddress() {
        enterIncompleteInternationalAddress();
    }

    @When("the user changes international address formats")
    public void theUserChangesInternationalAddressFormats() {
        changeInternationalAddressFormats();
    }

    @When("the system integrates with validation services")
    public void theSystemIntegratesWithValidationServices() {
        integrateWithValidationServices();
    }

    @When("the user saves an international address")
    public void theUserSavesAnInternationalAddress() {
        saveInternationalAddress();
    }

    @When("the user enters address details in different languages")
    public void theUserEntersAddressDetailsInDifferentLanguages() {
        enterAddressInDifferentLanguages();
    }

    @When("the user enters an unsupported international address format")
    public void theUserEntersAnUnsupportedInternationalAddressFormat() {
        enterUnsupportedAddressFormat();
    }

    @Given("the user is in their profile settings")
    public void theUserIsInTheirProfileSettings() {
        navigateToProfileSettings();
    }

    @When("the user changes the address format")
    public void theUserChangesTheAddressFormat() {
        changeAddressFormatInProfile();
    }

    @Then("the international address details are entered correctly")
    public void theInternationalAddressDetailsAreEnteredCorrectly() {
        verifyInternationalAddressEntry();
    }

    @Then("the system accepts multiple address formats without errors")
    public void theSystemAcceptsMultipleAddressFormatsWithoutErrors() {
        verifyMultipleAddressFormatsAccepted();
    }

    @Then("the system accepts non-standard formats and validates correctly")
    public void theSystemAcceptsNonStandardFormatsAndValidatesCorrectly() {
        verifyNonStandardFormatsAccepted();
    }

    @Then("the address fields accommodate and display international formats correctly")
    public void theAddressFieldsAccommodateAndDisplayInternationalFormatsCorrectly() {
        verifyAddressFieldsAccommodateInternationalFormats();
    }

    @Then("the system validates and accepts international postal codes correctly")
    public void theSystemValidatesAndAcceptsInternationalPostalCodesCorrectly() {
        verifyInternationalPostalCodesAccepted();
    }

    @Then("the system accepts special characters in international addresses without errors")
    public void theSystemAcceptsSpecialCharactersInInternationalAddressesWithoutErrors() {
        verifySpecialCharactersAccepted();
    }

    @Then("the system prompts the user to complete the address entry before proceeding")
    public void theSystemPromptsTheUserToCompleteTheAddressEntryBeforeProceeding() {
        verifyPromptForCompleteAddressEntry();
    }

    @Then("the system allows changes and updates to international address formats")
    public void theSystemAllowsChangesAndUpdatesToInternationalAddressFormats() {
        verifyAddressFormatChangesAllowed();
    }

    @Then("the system accepts validated addresses")
    public void theSystemAcceptsValidatedAddresses() {
        verifyValidatedAddressesAccepted();
    }

    @Then("the international addresses can be saved and used in future transactions")
    public void theInternationalAddressesCanBeSavedAndUsedInFutureTransactions() {
        verifyInternationalAddressesSaved();
    }

    @Then("the system supports multiple languages and accepts address entry in different languages")
    public void theSystemSupportsMultipleLanguagesAndAcceptsAddressEntryInDifferentLanguages() {
        verifyMultipleLanguagesSupported();
    }

    @Then("the system provides feedback and error messages for unsupported formats")
    public void theSystemProvidesFeedbackAndErrorMessagesForUnsupportedFormats() {
        verifyFeedbackForUnsupportedFormats();
    }

    @Then("the system updates and accepts address format changes in user profile")
    public void theSystemUpdatesAndAcceptsAddressFormatChangesInUserProfile() {
        verifyProfileAddressFormatChangesAccepted();
    }
}