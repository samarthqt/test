package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

import com.pageobjects.AddressEditPage;

public class AddressEditSteps extends AddressEditPage {

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() {
        verifyUserLoggedIn();
    }

    @When("the user navigates to the 'My Account' section")
    public void theUserNavigatesToTheMyAccountSection() {
        navigateToMyAccount();
    }

    @Then("the user account page is displayed")
    public void theUserAccountPageIsDisplayed() {
        verifyAccountPageDisplayed();
    }

    @Then("an existing address is present in the profile")
    public void anExistingAddressIsPresentInTheProfile() {
        verifyExistingAddressPresent();
    }

    @When("the user selects the 'Addresses' section")
    public void theUserSelectsTheAddressesSection() {
        selectAddressesSection();
    }

    @Then("the addresses section is displayed")
    public void theAddressesSectionIsDisplayed() {
        verifyAddressesSectionDisplayed();
    }

    @When("the user chooses an existing address to edit")
    public void theUserChoosesAnExistingAddressToEdit() {
        chooseAddressToEdit();
    }

    @Then("the edit address form is displayed")
    public void theEditAddressFormIsDisplayed() {
        verifyEditAddressFormDisplayed();
    }

    @When("the user modifies the address to {string}")
    public void theUserModifiesTheAddressTo(String newAddress) {
        modifyAddress(newAddress);
    }

    @When("the user saves the changes")
    public void theUserSavesTheChanges() {
        saveAddressChanges();
    }

    @Then("the edited address is saved in the user's account")
    public void theEditedAddressIsSavedInTheUsersAccount() {
        verifyAddressSaved();
    }

    @Then("the edited address appears correctly in the list of addresses")
    public void theEditedAddressAppearsCorrectlyInTheListOfAddresses() {
        verifyEditedAddressInList();
    }
}