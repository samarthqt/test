package com.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.List;

public class AddressManagementPage extends WebReusableComponents {

    protected By myAccountLink = By.id("myAccount");
    protected By addressesSectionLink = By.id("addressesSection");
    protected By addressOptions = By.cssSelector(".address-options");
    protected By deleteOption = By.cssSelector(".delete-option");
    protected By confirmationPrompt = By.id("confirmationPrompt");
    protected By addressList = By.cssSelector(".address-list");

    public AddressManagementPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyUserLoggedIn() {
        // Implement logic to verify user is logged in
        Assert.assertTrue(isUserLoggedIn(), "User is not logged in.");
    }

    public void verifyAddressPresent() {
        // Implement logic to verify at least one address is present
        List<WebElement> addresses = getWebElementList(addressList);
        Assert.assertFalse(addresses.isEmpty(), "No addresses found in the profile.");
    }

    public void navigateToMyAccount() {
        waitUntilElementVisible(myAccountLink, 3);
        clickElement(myAccountLink);
    }

    public void verifyAccountPageDisplayed() {
        // Implement logic to verify account page is displayed
        Assert.assertTrue(isElementVisible(myAccountLink), "Account page is not displayed.");
    }

    public void selectAddressesSection() {
        waitUntilElementVisible(addressesSectionLink, 3);
        clickElement(addressesSectionLink);
    }

    public void verifyAddressesSectionDisplayed() {
        // Implement logic to verify addresses section is displayed
        Assert.assertTrue(isElementVisible(addressesSectionLink), "Addresses section is not displayed.");
    }

    public void selectAddressToDelete() {
        // Implement logic to select an address to delete
        WebElement address = getWebElementList(addressList).get(0);
        address.click();
    }

    public void verifyAddressOptionsDisplayed() {
        // Implement logic to verify address options are displayed
        Assert.assertTrue(isElementVisible(addressOptions), "Address options are not displayed.");
    }

    public void chooseDeleteOption() {
        waitUntilElementVisible(deleteOption, 3);
        clickElement(deleteOption);
    }

    public void verifyConfirmationPromptDisplayed() {
        // Implement logic to verify confirmation prompt is displayed
        Assert.assertTrue(isElementVisible(confirmationPrompt), "Confirmation prompt is not displayed.");
    }

    public void confirmDeletion() {
        // Implement logic to confirm deletion
        clickElement(confirmationPrompt);
    }

    public void verifyAddressDeleted() {
        // Implement logic to verify address is deleted
        List<WebElement> addresses = getWebElementList(addressList);
        Assert.assertTrue(addresses.isEmpty(), "Address was not deleted from the profile.");
    }

    public void verifyAddressNotListed() {
        // Implement logic to verify deleted address is not listed
        List<WebElement> addresses = getWebElementList(addressList);
        Assert.assertTrue(addresses.isEmpty(), "Deleted address is still listed.");
    }
}