public class ShippingAddressSteps {

    WebDriver driver;
    ManageShippingAddressesPage manageShippingAddressesPage;

    @Given("the user is logged into their account")
    public void userLoggedIn() {
        // Logic to ensure user is logged in
    }

    @Given("the user is on the Manage Shipping Addresses page")
    public void userOnManageShippingAddressesPage() {
        manageShippingAddressesPage = new ManageShippingAddressesPage(driver);
        manageShippingAddressesPage.navigateToManageShippingAddresses();
    }

    @When("the user clicks on Add New Address")
    public void userClicksAddNewAddress() {
        manageShippingAddressesPage.clickAddNewAddress();
    }

    @When("the user enters a valid shipping address")
    public void userEntersValidShippingAddress() {
        manageShippingAddressesPage.enterShippingAddress("123 Main St", "City", "State", "12345");
    }

    @When("the user saves the new address")
    public void userSavesNewAddress() {
        manageShippingAddressesPage.saveAddress();
    }

    @Then("the new address should be added to the list of stored addresses")
    public void newAddressAddedToList() {
        Assert.assertTrue(manageShippingAddressesPage.isAddressInList("123 Main St"));
    }

    @Given("the user has already stored one shipping address")
    public void userHasStoredOneAddress() {
        manageShippingAddressesPage.ensureAddressStored("123 Main St");
    }

    @When("the user enters another valid shipping address")
    public void userEntersAnotherValidShippingAddress() {
        manageShippingAddressesPage.enterShippingAddress("456 Elm St", "City", "State", "67890");
    }

    @Then("both addresses should be visible in the list of stored addresses")
    public void bothAddressesVisibleInList() {
        Assert.assertTrue(manageShippingAddressesPage.isAddressInList("123 Main St"));
        Assert.assertTrue(manageShippingAddressesPage.isAddressInList("456 Elm St"));
    }

    @Given("the user has multiple shipping addresses stored")
    public void userHasMultipleAddressesStored() {
        manageShippingAddressesPage.ensureMultipleAddressesStored();
    }

    @When("the user proceeds to checkout")
    public void userProceedsToCheckout() {
        manageShippingAddressesPage.proceedToCheckout();
    }

    @When("the user selects a stored shipping address")
    public void userSelectsStoredAddress() {
        manageShippingAddressesPage.selectShippingAddress("123 Main St");
    }

    @Then("the selected address should be used for the order")
    public void selectedAddressUsedForOrder() {
        Assert.assertTrue(manageShippingAddressesPage.isAddressUsedForOrder("123 Main St"));
    }

    @Given("the user has a stored shipping address")
    public void userHasStoredAddress() {
        manageShippingAddressesPage.ensureAddressStored("123 Main St");
    }

    @When("the user selects an address to edit")
    public void userSelectsAddressToEdit() {
        manageShippingAddressesPage.selectAddressToEdit("123 Main St");
    }

    @When("the user updates the address details")
    public void userUpdatesAddressDetails() {
        manageShippingAddressesPage.updateAddressDetails("789 Oak St", "New City", "New State", "54321");
    }

    @When("the user saves the changes")
    public void userSavesChanges() {
        manageShippingAddressesPage.saveAddress();
    }

    @Then("the updated address should be reflected in the list of stored addresses")
    public void updatedAddressReflectedInList() {
        Assert.assertTrue(manageShippingAddressesPage.isAddressInList("789 Oak St"));
    }

    @Given("the user has multiple stored shipping addresses")
    public void userHasMultipleStoredAddresses() {
        manageShippingAddressesPage.ensureMultipleAddressesStored();
    }

    @When("the user selects an address to delete")
    public void userSelectsAddressToDelete() {
        manageShippingAddressesPage.selectAddressToDelete("123 Main St");
    }

    @When("the user confirms the deletion")
    public void userConfirmsDeletion() {
        manageShippingAddressesPage.confirmDeletion();
    }

    @Then("the address should be removed from the list of stored addresses")
    public void addressRemovedFromList() {
        Assert.assertFalse(manageShippingAddressesPage.isAddressInList("123 Main St"));
    }

    @Then("the remaining addresses should still be visible")
    public void remainingAddressesVisible() {
        Assert.assertTrue(manageShippingAddressesPage.areRemainingAddressesVisible());
    }

    @When("the user enters an invalid shipping address")
    public void userEntersInvalidShippingAddress() {
        manageShippingAddressesPage.enterShippingAddress("", "", "", "");
    }

    @When("the user attempts to save the new address")
    public void userAttemptsToSaveNewAddress() {
        manageShippingAddressesPage.saveAddress();
    }

    @Then("an error message should be displayed")
    public void errorMessageDisplayed() {
        Assert.assertTrue(manageShippingAddressesPage.isErrorMessageDisplayed());
    }

    @Then("the invalid address should not be added to the list of stored addresses")
    public void invalidAddressNotAddedToList() {
        Assert.assertFalse(manageShippingAddressesPage.isAddressInList(""));
    }
}