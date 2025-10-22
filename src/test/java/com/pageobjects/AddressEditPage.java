package com.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AddressEditPage extends WebReusableComponents {

    protected By myAccountLink = By.id("myAccount");
    protected By addressesSectionLink = By.id("addressesSection");
    protected By editAddressButton = By.cssSelector(".edit-address");
    protected By txtAddress = By.id("address");
    protected By saveButton = By.id("saveAddress");
    protected By addressList = By.cssSelector(".address-list");

    public AddressEditPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(elementVisible(myAccountLink), "User is not logged in.");
    }

    public void navigateToMyAccount() {
        waitUntilElementVisible(myAccountLink, 3);
        clickElement(myAccountLink);
    }

    public void verifyAccountPageDisplayed() {
        Assert.assertTrue(elementVisible(addressesSectionLink), "Account page is not displayed.");
    }

    public void verifyExistingAddressPresent() {
        Assert.assertTrue(elementVisible(editAddressButton), "No existing address found.");
    }

    public void selectAddressesSection() {
        waitUntilElementVisible(addressesSectionLink, 3);
        clickElement(addressesSectionLink);
    }

    public void verifyAddressesSectionDisplayed() {
        Assert.assertTrue(elementVisible(editAddressButton), "Addresses section is not displayed.");
    }

    public void chooseAddressToEdit() {
        waitUntilElementVisible(editAddressButton, 3);
        clickElement(editAddressButton);
    }

    public void verifyEditAddressFormDisplayed() {
        Assert.assertTrue(elementVisible(txtAddress), "Edit address form is not displayed.");
    }

    public void modifyAddress(String newAddress) {
        enterText(txtAddress, newAddress);
    }

    public void saveAddressChanges() {
        clickElement(saveButton);
    }

    public void verifyAddressSaved() {
        waitUntilElementVisible(addressList, 3);
        Assert.assertTrue(elementVisible(addressList), "Edited address is not saved.");
    }

    public void verifyEditedAddressInList() {
        WebElement addressElement = findElement(By.xpath("//div[contains(text(), '789 Oak Avenue, Anytown, USA, 12345')]");
        Assert.assertNotNull(addressElement, "Edited address does not appear in the list.");
    }
}