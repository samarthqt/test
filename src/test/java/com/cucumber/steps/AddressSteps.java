package com.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.framework.cucumber.TestHarness;
import com.pageobjects.AddressBookPage;

public class AddressSteps {

    private AddressBookPage addressBookPage = new AddressBookPage();
    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the address book page")
    public void theUserIsOnTheAddressBookPage() {
        addressBookPage.navigateToAddressBook();
    }

    @When("the user adds a new address with {string}, {string}, {string}, {string}, {string}")
    public void theUserAddsANewAddressWith(String addressLine1, String city, String state, String postalCode, String country) {
        addressBookPage.addNewAddress(addressLine1, city, state, postalCode, country);
    }

    @Then("the new address should be saved in the address book")
    public void theNewAddressShouldBeSavedInTheAddressBook() {
        addressBookPage.verifyAddressSaved();
    }

    @When("the user views all saved addresses")
    public void theUserViewsAllSavedAddresses() {
        addressBookPage.verifyAddressSaved();
    }

    @Then("the address book should display all saved addresses")
    public void theAddressBookShouldDisplayAllSavedAddresses() {
        addressBookPage.verifyAddressSaved();
    }

    @When("the user removes the address with {string}")
    public void theUserRemovesTheAddressWith(String addressLine1) {
        addressBookPage.removeAddress(addressLine1);
    }

    @Then("the address should be removed from the address book")
    public void theAddressShouldBeRemovedFromTheAddressBook() {
        addressBookPage.verifyAddressRemoved(testHarness.getData("AddressBookData", "AddressLine1"));
    }
}
