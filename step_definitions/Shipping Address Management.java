package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShippingAddressSteps extends ShippingAddressPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user is logged into their account")
    public void aUserIsLoggedIntoTheirAccount() {
        loginToAccount();
    }

    @When("the user navigates to the shipping address section")
    public void theUserNavigatesToTheShippingAddressSection() {
        navigateToShippingAddressSection();
    }

    @When("the user selects the option to add a new address")
    public void theUserSelectsTheOptionToAddANewAddress() {
        selectAddNewAddressOption();
    }

    @When("the user enters valid address details")
    public void theUserEntersValidAddressDetails() {
        enterAddressDetails();
    }

    @Then("the new shipping address is saved successfully")
    public void theNewShippingAddressIsSavedSuccessfully() {
        verifyAddressSaved();
    }

    @Then("the user receives a confirmation message")
    public void theUserReceivesAConfirmationMessage() {
        verifyConfirmationMessage();
    }

    @When("the user adds multiple addresses")
    public void theUserAddsMultipleAddresses() {
        addMultipleAddresses();
    }

    @Then("all the addresses are stored successfully")
    public void allTheAddressesAreStoredSuccessfully() {
        verifyAllAddressesStored();
    }

    @Then("the user can view all saved addresses")
    public void theUserCanViewAllSavedAddresses() {
        viewAllSavedAddresses();
    }

    @Given("a user has multiple shipping addresses saved")
    public void aUserHasMultipleShippingAddressesSaved() {
        verifyMultipleAddressesSaved();
    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        proceedToCheckout();
    }

    @Then("the user is presented with a list of saved shipping addresses")
    public void theUserIsPresentedWithAListOfSavedShippingAddresses() {
        verifyListOfSavedAddresses();
    }

    @Then("the user can select one of the saved addresses for shipping")
    public void theUserCanSelectOneOfTheSavedAddressesForShipping() {
        selectShippingAddress();
    }

    @Given("the user has at least one shipping address saved")
    public void theUserHasAtLeastOneShippingAddressSaved() {
        verifyAtLeastOneAddressSaved();
    }

    @When("the user selects an address to edit")
    public void theUserSelectsAnAddressToEdit() {
        selectAddressToEdit();
    }

    @When("the user updates the address details")
    public void theUserUpdatesTheAddressDetails() {
        updateAddressDetails();
    }

    @Then("the changes are saved successfully")
    public void theChangesAreSavedSuccessfully() {
        verifyChangesSaved();
    }

    @Given("the user has multiple shipping addresses saved")
    public void theUserHasMultipleShippingAddressesSaved() {
        verifyMultipleAddressesSaved();
    }

    @When("the user selects an address to delete")
    public void theUserSelectsAnAddressToDelete() {
        selectAddressToDelete();
    }

    @Then("the address is removed from the list of saved addresses")
    public void theAddressIsRemovedFromTheListOfSavedAddresses() {
        verifyAddressRemoved();
    }
}