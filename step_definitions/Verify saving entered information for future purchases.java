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
    public void theCheckoutPageIsDisplayed() {
        verifyCheckoutPageDisplayed();
    }

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        verifyCheckoutPageDisplayed();
    }

    @When("the user enters new shipping address {string}")
    public void theUserEntersNewShippingAddress(String address) {
        enterShippingAddress(address);
    }

    @When("the user enters billing address {string}")
    public void theUserEntersBillingAddress(String address) {
        enterBillingAddress(address);
    }

    @Then("the shipping and billing address details are entered correctly")
    public void theAddressDetailsAreEnteredCorrectly() {
        verifyAddressDetailsEntered();
    }

    @Given("the user has entered shipping and billing addresses")
    public void theUserHasEnteredAddresses() {
        verifyAddressDetailsEntered();
    }

    @When("the user enters phone number {string}")
    public void theUserEntersPhoneNumber(String phoneNumber) {
        enterPhoneNumber(phoneNumber);
    }

    @When("the user enters email address {string}")
    public void theUserEntersEmailAddress(String email) {
        enterEmailAddress(email);
    }

    @Then("the phone number and email are entered correctly")
    public void theContactDetailsAreEnteredCorrectly() {
        verifyContactDetailsEntered();
    }

    @Given("the user has entered contact details")
    public void theUserHasEnteredContactDetails() {
        verifyContactDetailsEntered();
    }

    @When("the user clicks 'Save for Future' to store the information")
    public void theUserClicksSaveForFuture() {
        clickSaveForFuture();
    }

    @Then("the information is saved successfully without errors")
    public void theInformationIsSavedSuccessfully() {
        verifyInformationSavedSuccessfully();
    }

    @Given("the user has saved information for future use")
    public void theUserHasSavedInformation() {
        verifyInformationSavedSuccessfully();
    }

    @When("the user navigates to account settings")
    public void theUserNavigatesToAccountSettings() {
        navigateToAccountSettings();
    }

    @Then("the newly entered information appears in the list of saved addresses and contact details")
    public void theInformationAppearsInAccountSettings() {
        verifyInformationInAccountSettings();
    }

    @When("the user logs out and logs back in")
    public void theUserLogsOutAndBackIn() {
        logoutAndLogin();
    }

    @Then("the saved information persists across sessions")
    public void theInformationPersistsAcrossSessions() {
        verifyInformationPersistence();
    }

    @When("the user attempts a new purchase")
    public void theUserAttemptsANewPurchase() {
        attemptNewPurchase();
    }

    @Then("the checkout process uses saved information without requiring re-entry")
    public void theCheckoutUsesSavedInformation() {
        verifyCheckoutUsesSavedInformation();
    }

    @Given("the user has used saved information for a purchase")
    public void theUserHasUsedSavedInformation() {
        verifyCheckoutUsesSavedInformation();
    }

    @When("the user completes the checkout process")
    public void theUserCompletesCheckout() {
        completeCheckoutProcess();
    }

    @Then("a confirmation message is displayed indicating the use of saved information")
    public void theConfirmationMessageIsDisplayed() {
        verifyConfirmationMessageDisplayed();
    }

    @Given("the user attempts to save information")
    public void theUserAttemptsToSaveInformation() {
        attemptToSaveInformation();
    }

    @When("the user clicks 'Save for Future'")
    public void theUserClicksSaveForFutureAgain() {
        clickSaveForFuture();
    }

    @Then("no error messages are displayed and information is saved successfully")
    public void noErrorMessagesAndInformationSaved() {
        verifyNoErrorMessagesAndInformationSaved();
    }

    @When("the user edits the saved information")
    public void theUserEditsSavedInformation() {
        editSavedInformation();
    }

    @Then("the saved information can be edited and updated correctly")
    public void theInformationIsEditedCorrectly() {
        verifyInformationEditedCorrectly();
    }

    @When("the user enters international address details")
    public void theUserEntersInternationalAddressDetails() {
        enterInternationalAddressDetails();
    }

    @Then("international addresses are entered, saved, and accepted correctly")
    public void internationalAddressesAreHandledCorrectly() {
        verifyInternationalAddressesHandledCorrectly();
    }

    @When("the user enters information in different valid formats")
    public void theUserEntersInformationInDifferentFormats() {
        enterInformationInDifferentFormats();
    }

    @Then("information in different valid formats is saved correctly")
    public void informationInDifferentFormatsIsSavedCorrectly() {
        verifyInformationInDifferentFormatsSavedCorrectly();
    }

    @When("the user deletes the saved information")
    public void theUserDeletesSavedInformation() {
        deleteSavedInformation();
    }

    @Then("the saved information can be deleted successfully")
    public void theInformationIsDeletedSuccessfully() {
        verifyInformationDeletedSuccessfully();
    }

    @When("the user makes a future transaction")
    public void theUserMakesAFutureTransaction() {
        makeFutureTransaction();
    }

    @Then("the saved information is automatically used in future transactions")
    public void theInformationIsUsedInFutureTransactions() {
        verifyInformationUsedInFutureTransactions();
    }

    @When("the user saves multiple addresses")
    public void theUserSavesMultipleAddresses() {
        saveMultipleAddresses();
    }

    @Then("multiple addresses can be saved and selected for future transactions")
    public void multipleAddressesAreHandledCorrectly() {
        verifyMultipleAddressesHandledCorrectly();
    }
}