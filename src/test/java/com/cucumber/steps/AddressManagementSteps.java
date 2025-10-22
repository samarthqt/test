package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

import com.pageobjects.AddressManagementPage;

public class AddressManagementSteps extends AddressManagementPage {

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() {
        verifyUserLoggedIn();
    }

    @Given("at least one address is present in the profile")
    public void atLeastOneAddressIsPresentInTheProfile() {
        verifyAddressPresent();
    }

    @When("the user navigates to the 'My Account' section")
    public void theUserNavigatesToTheMyAccountSection() {
        navigateToMyAccount();
    }

    @Then("the user account page is displayed")
    public void theUserAccountPageIsDisplayed() {
        verifyAccountPageDisplayed();
    }

    @When("the user selects the 'Addresses' section")
    public void theUserSelectsTheAddressesSection() {
        selectAddressesSection();
    }

    @Then("the addresses section is displayed")
    public void theAddressesSectionIsDisplayed() {
        verifyAddressesSectionDisplayed();
    }

    @When("the user selects an address to delete")
    public void theUserSelectsAnAddressToDelete() {
        selectAddressToDelete();
    }

    @Then("address options are displayed")
    public void addressOptionsAreDisplayed() {
        verifyAddressOptionsDisplayed();
    }

    @When("the user chooses the 'Delete' option for the selected address")
    public void theUserChoosesTheDeleteOptionForTheSelectedAddress() {
        chooseDeleteOption();
    }

    @Then("a confirmation prompt is displayed")
    public void aConfirmationPromptIsDisplayed() {
        verifyConfirmationPromptDisplayed();
    }

    @When("the user confirms the deletion")
    public void theUserConfirmsTheDeletion() {
        confirmDeletion();
    }

    @Then("the address is deleted from the user's profile")
    public void theAddressIsDeletedFromTheUsersProfile() {
        verifyAddressDeleted();
    }

    @Then("the deleted address is not listed in the user's addresses")
    public void theDeletedAddressIsNotListedInTheUsersAddresses() {
        verifyAddressNotListed();
    }
}