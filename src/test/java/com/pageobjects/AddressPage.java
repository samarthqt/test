package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.List;

public class AddressPage extends WebReusableComponents {

    public AddressPage() {
        PageFactory.initElements(driver, this);
    }

    private By myAccountLink = By.id("myAccount");
    private By addressesSectionLink = By.id("addressesSection");
    private By addNewAddressButton = By.id("addNewAddress");
    private By addressForm = By.id("addressForm");
    private By addressField = By.id("addressField");
    private By saveAddressButton = By.id("saveAddress");
    private By addressList = By.cssSelector(".address-list");
    private By errorMessage = By.id("errorMessage");

    public void loginToAccount() {
        // Dummy implementation for login
    }

    public void navigateToMyAccount() {
        waitUntilElementVisible(myAccountLink, 3);
        clickElement(myAccountLink);
    }

    public void verifyAccountPageDisplayed() {
        Assert.assertTrue(elementVisible(myAccountLink), "Account page is not displayed.");
    }

    public void selectAddressesSection() {
        waitUntilElementVisible(addressesSectionLink, 3);
        clickElement(addressesSectionLink);
    }

    public void verifyAddressesSectionDisplayed() {
        Assert.assertTrue(elementVisible(addressesSectionLink), "Addresses section is not displayed.");
    }

    public void chooseToAddNewAddress() {
        waitUntilElementVisible(addNewAddressButton, 3);
        clickElement(addNewAddressButton);
    }

    public void verifyAddNewAddressFormDisplayed() {
        Assert.assertTrue(elementVisible(addressForm), "Add new address form is not displayed.");
    }

    public void enterAddressDetails(String address) {
        enterText(addressField, address);
    }

    public void saveNewAddress() {
        clickElement(saveAddressButton);
    }

    public void verifyAddressSaved() {
        waitUntilElementVisible(addressList, 3);
        List<WebElement> addresses = getWebElementList(addressList);
        Assert.assertFalse(addresses.isEmpty(), "No addresses found in the address list.");
    }

    public void verifyAddressInList() {
        // Implementation to verify address in list
    }

    public void enterAddress(String address) {
        enterText(addressField, address);
    }

    public void tryToSaveInvalidAddress() {
        clickElement(saveAddressButton);
    }

    public void verifyInvalidAddressErrorMessage() {
        waitUntilElementVisible(errorMessage, 3);
        WebElement error = getWebElement(errorMessage);
        Assert.assertTrue(error.isDisplayed(), "Error message for invalid address format is not displayed.");
    }
}
