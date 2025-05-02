package com.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.List;
import org.openqa.selenium.WebElement;

public class ShippingAddressPage extends WebReusableComponents {

    protected By shippingAddressSectionLink = By.id("shippingAddressSection");
    protected By addAddressButton = By.id("addAddress");
    protected By txtAddressLine1 = By.id("addressLine1");
    protected By txtCity = By.id("city");
    protected By txtState = By.id("state");
    protected By txtPostalCode = By.id("postalCode");
    protected By txtCountry = By.id("country");
    protected By saveAddressButton = By.id("saveAddress");
    protected By addressEntries = By.cssSelector(".address-entry");
    protected By confirmationMessage = By.id("confirmationMessage");
    protected By editAddressButton(String addressLine1) {
        return By.xpath("//div[contains(text(), '" + addressLine1 + "')]/following-sibling::button[@class='edit']");
    }
    protected By deleteAddressButton(String addressLine1) {
        return By.xpath("//div[contains(text(), '" + addressLine1 + "')]/following-sibling::button[@class='delete']");
    }

    public void navigateToShippingAddressSection() {
        waitUntilElementVisible(shippingAddressSectionLink, 3);
        clickElement(shippingAddressSectionLink);
    }

    public void selectAddNewAddressOption() {
        waitUntilElementVisible(addAddressButton, 3);
        clickElement(addAddressButton);
    }

    public void enterAddressDetails() {
        enterText(txtAddressLine1, "123 Main St");
        enterText(txtCity, "Anytown");
        enterText(txtState, "Anystate");
        enterText(txtPostalCode, "12345");
        enterText(txtCountry, "USA");
        clickElement(saveAddressButton);
    }

    public void verifyAddressSaved() {
        waitUntilElementVisible(addressEntries, 3);
        List<WebElement> addresses = getWebElementList(addressEntries);
        Assert.assertFalse(addresses.isEmpty(), "No addresses found in the shipping address section.");
    }

    public void verifyConfirmationMessage() {
        waitUntilElementVisible(confirmationMessage, 3);
        Assert.assertTrue(elementVisible(confirmationMessage), "Confirmation message not displayed.");
    }

    public void addMultipleAddresses() {
        // Logic to add multiple addresses
    }

    public void verifyAllAddressesStored() {
        // Logic to verify all addresses are stored
    }

    public void viewAllSavedAddresses() {
        // Logic to view all saved addresses
    }

    public void verifyMultipleAddressesSaved() {
        // Logic to verify multiple addresses are saved
    }

    public void proceedToCheckout() {
        // Logic to proceed to checkout
    }

    public void verifyListOfSavedAddresses() {
        // Logic to verify list of saved addresses
    }

    public void selectShippingAddress() {
        // Logic to select a shipping address
    }

    public void verifyAtLeastOneAddressSaved() {
        // Logic to verify at least one address is saved
    }

    public void selectAddressToEdit() {
        // Logic to select an address to edit
    }

    public void updateAddressDetails() {
        // Logic to update address details
    }

    public void verifyChangesSaved() {
        // Logic to verify changes are saved
    }

    public void selectAddressToDelete() {
        // Logic to select an address to delete
    }

    public void verifyAddressRemoved() {
        // Logic to verify address is removed
    }
}