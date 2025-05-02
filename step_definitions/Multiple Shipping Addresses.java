package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MultipleShippingAddressesSteps extends MultipleShippingAddressesPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        navigateToCheckoutPage();
    }

    @When("the user selects the option to ship items to multiple addresses")
    public void theUserSelectsTheOptionToShipItemsToMultipleAddresses() {
        selectMultipleShippingAddressesOption();
    }

    @Then("the user should be presented with a list of items in the order")
    public void theUserShouldBePresentedWithAListOfItemsInTheOrder() {
        verifyItemsListDisplayed();
    }

    @Then("each item should have an option to select a shipping address")
    public void eachItemShouldHaveAnOptionToSelectAShippingAddress() {
        verifyShippingAddressOptionForItems();
    }

    @Given("the user has selected multiple shipping addresses option")
    public void theUserHasSelectedMultipleShippingAddressesOption() {
        verifyMultipleShippingAddressesOptionSelected();
    }

    @When("the user assigns different addresses to each item")
    public void theUserAssignsDifferentAddressesToEachItem() {
        assignDifferentAddressesToItems();
    }

    @Then("each item should display the selected shipping address")
    public void eachItemShouldDisplayTheSelectedShippingAddress() {
        verifySelectedShippingAddressesForItems();
    }

    @Given("the user has assigned different shipping addresses to items")
    public void theUserHasAssignedDifferentShippingAddressesToItems() {
        verifyDifferentShippingAddressesAssigned();
    }

    @When("the user confirms the shipping address selection")
    public void theUserConfirmsTheShippingAddressSelection() {
        confirmShippingAddressSelection();
    }

    @Then("the system should save the shipping address for each item")
    public void theSystemShouldSaveTheShippingAddressForEachItem() {
        verifyShippingAddressesSaved();
    }

    @Then("the order summary should reflect the different shipping addresses")
    public void theOrderSummaryShouldReflectTheDifferentShippingAddresses() {
        verifyOrderSummaryReflectsShippingAddresses();
    }

    @Given("the user has saved the shipping address selection")
    public void theUserHasSavedTheShippingAddressSelection() {
        verifyShippingAddressSelectionSaved();
    }

    @When("the user chooses to edit the shipping addresses")
    public void theUserChoosesToEditTheShippingAddresses() {
        editShippingAddresses();
    }

    @Then("the user should be able to change the shipping addresses for items")
    public void theUserShouldBeAbleToChangeTheShippingAddressesForItems() {
        verifyShippingAddressesCanBeChanged();
    }

    @Then("the changes should be reflected in the order summary")
    public void theChangesShouldBeReflectedInTheOrderSummary() {
        verifyOrderSummaryReflectsChanges();
    }

    @Given("the user has finalized the shipping addresses")
    public void theUserHasFinalizedTheShippingAddresses() {
        verifyShippingAddressesFinalized();
    }

    @When("the user completes the order process")
    public void theUserCompletesTheOrderProcess() {
        completeOrderProcess();
    }

    @Then("the order confirmation should list all items with their respective shipping addresses")
    public void theOrderConfirmationShouldListAllItemsWithTheirRespectiveShippingAddresses() {
        verifyOrderConfirmationListsShippingAddresses();
    }

    @Then("the user should receive a confirmation email with the shipping details for each item")
    public void theUserShouldReceiveAConfirmationEmailWithTheShippingDetailsForEachItem() {
        verifyConfirmationEmailReceived();
    }
}