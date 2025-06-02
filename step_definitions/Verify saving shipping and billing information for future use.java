package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.UserAccountPage;

public class UserAccountSteps extends UserAccountPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() {
        loginToAccount();
    }

    @When("the user navigates to the user account settings")
    public void theUserNavigatesToTheUserAccountSettings() {
        navigateToAccountSettings();
    }

    @Then("the user account settings page is displayed")
    public void theUserAccountSettingsPageIsDisplayed() {
        verifyAccountSettingsPageDisplayed();
    }

    @When("the user clicks on the 'Addresses' section")
    public void theUserClicksOnTheAddressesSection() {
        clickAddressesSection();
    }

    @Then("the addresses section is opened")
    public void theAddressesSectionIsOpened() {
        verifyAddressesSectionOpened();
    }

    @When("the user enters shipping address details as {string}")
    public void theUserEntersShippingAddressDetailsAs(String shippingAddress) {
        enterShippingAddressDetails(shippingAddress);
    }

    @When("the user enters billing address details as {string}")
    public void theUserEntersBillingAddressDetailsAs(String billingAddress) {
        enterBillingAddressDetails(billingAddress);
    }

    @When("the user clicks the 'Save' button")
    public void theUserClicksTheSaveButton() {
        clickSaveButton();
    }

    @Then("the shipping and billing information is saved successfully")
    public void theShippingAndBillingInformationIsSavedSuccessfully() {
        verifyInformationSavedSuccessfully();
    }

    @When("the user logs out and logs back into the user account")
    public void theUserLogsOutAndLogsBackIntoTheUserAccount() {
        logoutAndLogin();
    }

    @Then("the saved shipping and billing information is displayed correctly")
    public void theSavedShippingAndBillingInformationIsDisplayedCorrectly() {
        verifySavedInformationDisplayedCorrectly();
    }

    @When("the user attempts to make a purchase using the saved billing information")
    public void theUserAttemptsToMakeAPurchaseUsingTheSavedBillingInformation() {
        makePurchaseUsingSavedBillingInformation();
    }

    @Then("the purchase is completed successfully using saved billing information")
    public void thePurchaseIsCompletedSuccessfullyUsingSavedBillingInformation() {
        verifyPurchaseCompletedSuccessfully();
    }

    @When("the user checks if there is an option to edit saved information")
    public void theUserChecksIfThereIsAnOptionToEditSavedInformation() {
        checkEditOptionAvailable();
    }

    @Then("the option to edit saved information is available")
    public void theOptionToEditSavedInformationIsAvailable() {
        verifyEditOptionAvailable();
    }

    @When("the user edits the saved shipping information and saves changes")
    public void theUserEditsTheSavedShippingInformationAndSavesChanges() {
        editAndSaveShippingInformation();
    }

    @Then("the edited shipping information is saved successfully")
    public void theEditedShippingInformationIsSavedSuccessfully() {
        verifyEditedInformationSavedSuccessfully();
    }

    @Then("the changes to shipping information are reflected correctly")
    public void theChangesToShippingInformationAreReflectedCorrectly() {
        verifyChangesReflectedCorrectly();
    }

    @When("the user attempts a purchase using the edited shipping information")
    public void theUserAttemptsAPurchaseUsingTheEditedShippingInformation() {
        makePurchaseUsingEditedShippingInformation();
    }

    @Then("the purchase is completed successfully using edited shipping information")
    public void thePurchaseIsCompletedSuccessfullyUsingEditedShippingInformation() {
        verifyPurchaseCompletedSuccessfullyWithEditedInformation();
    }

    @When("the user checks if there is an option to delete the saved information")
    public void theUserChecksIfThereIsAnOptionToDeleteTheSavedInformation() {
        checkDeleteOptionAvailable();
    }

    @Then("the option to delete saved information is available")
    public void theOptionToDeleteSavedInformationIsAvailable() {
        verifyDeleteOptionAvailable();
    }

    @When("the user deletes the saved shipping information and confirms deletion")
    public void theUserDeletesTheSavedShippingInformationAndConfirmsDeletion() {
        deleteAndConfirmShippingInformation();
    }

    @Then("the shipping information is deleted successfully")
    public void theShippingInformationIsDeletedSuccessfully() {
        verifyInformationDeletedSuccessfully();
    }
}