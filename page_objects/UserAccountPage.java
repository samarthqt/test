package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import .util.List;

public class UserAccountPage extends WebReusableComponents {

    protected By accountSettingsLink = By.id("accountSettings");
    protected By addressesSectionLink = By.id("addressesSection");
    protected By shippingAddressField = By.id("shippingAddress");
    protected By billingAddressField = By.id("billingAddress");
    protected By saveButton = By.id("saveButton");
    protected By editOption = By.id("editOption");
    protected By deleteOption = By.id("deleteOption");
    protected By confirmationMessage = By.id("confirmationMessage");
    protected By addressEntries = By.cssSelector(".address-entry");

    public UserAccountPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginToAccount() {
        // Logic to log into the account
        // Example: navigate to login page, enter credentials, submit form
    }

    public void navigateToAccountSettings() {
        waitUntilElementVisible(accountSettingsLink, 3);
        clickElement(accountSettingsLink);
    }

    public void verifyAccountSettingsPageDisplayed() {
        Assert.assertTrue(isElementVisible(accountSettingsLink), "Account settings page is not displayed.");
    }

    public void clickAddressesSection() {
        waitUntilElementVisible(addressesSectionLink, 3);
        clickElement(addressesSectionLink);
    }

    public void verifyAddressesSectionOpened() {
        Assert.assertTrue(isElementVisible(addressesSectionLink), "Addresses section is not opened.");
    }

    public void enterShippingAddressDetails(String shippingAddress) {
        waitUntilElementVisible(shippingAddressField, 3);
        enterText(shippingAddressField, shippingAddress);
    }

    public void enterBillingAddressDetails(String billingAddress) {
        waitUntilElementVisible(billingAddressField, 3);
        enterText(billingAddressField, billingAddress);
    }

    public void clickSaveButton() {
        waitUntilElementVisible(saveButton, 3);
        clickElement(saveButton);
    }

    public void verifyInformationSavedSuccessfully() {
        String actualMessage = getTextFromElement(confirmationMessage);
        Assert.assertEquals(actualMessage, "Information saved successfully.", "Information was not saved successfully.");
    }

    public void logoutAndLogin() {
        // Logic to logout and login
        // Example: click logout button, navigate to login page, enter credentials, submit form
    }

    public void verifySavedInformationDisplayedCorrectly() {
        waitUntilElementVisible(addressEntries, 3);
        List<WebElement> addresses = getWebElementList(addressEntries);
        Assert.assertFalse(addresses.isEmpty(), "No addresses found in the address book.");
    }

    public void makePurchaseUsingSavedBillingInformation() {
        // Logic to make purchase using saved billing information
        // Example: select saved billing address, proceed with checkout
    }

    public void verifyPurchaseCompletedSuccessfully() {
        // Logic to verify purchase completion
        // Example: check for order confirmation message
    }

    public void checkEditOptionAvailable() {
        Assert.assertTrue(isElementVisible(editOption), "Edit option is not available.");
    }

    public void verifyEditOptionAvailable() {
        Assert.assertTrue(isElementVisible(editOption), "Edit option is not available.");
    }

    public void editAndSaveShippingInformation() {
        // Logic to edit and save shipping information
        // Example: click edit, modify details, save changes
    }

    public void verifyEditedInformationSavedSuccessfully() {
        String actualMessage = getTextFromElement(confirmationMessage);
        Assert.assertEquals(actualMessage, "Information saved successfully.", "Edited information was not saved successfully.");
    }

    public void verifyChangesReflectedCorrectly() {
        // Logic to verify changes reflected
        // Example: check updated address details in the address book
    }

    public void makePurchaseUsingEditedShippingInformation() {
        // Logic to make purchase using edited shipping information
        // Example: select edited shipping address, proceed with checkout
    }

    public void verifyPurchaseCompletedSuccessfullyWithEditedInformation() {
        // Logic to verify purchase completion with edited information
        // Example: check for order confirmation message
    }

    public void checkDeleteOptionAvailable() {
        Assert.assertTrue(isElementVisible(deleteOption), "Delete option is not available.");
    }

    public void verifyDeleteOptionAvailable() {
        Assert.assertTrue(isElementVisible(deleteOption), "Delete option is not available.");
    }

    public void deleteAndConfirmShippingInformation() {
        // Logic to delete and confirm shipping information
        // Example: click delete, confirm deletion
    }

    public void verifyInformationDeletedSuccessfully() {
        By addressLocator = deleteOption;
        boolean isAddressPresent = elementVisible(addressLocator);
        Assert.assertFalse(isAddressPresent, "Information was not deleted successfully.");
    }
}