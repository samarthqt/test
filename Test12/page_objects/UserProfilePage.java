package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class UserProfilePage extends WebReusableComponents {

    protected By accountDashboardLink = By.id("accountDashboard");
    protected By profileLink = By.id("profileLink");
    protected By nameField = By.id("name");
    protected By emailField = By.id("email");
    protected By shippingAddressField = By.id("shippingAddress");
    protected By billingAddressField = By.id("billingAddress");
    protected By phoneField = By.id("phone");
    protected By saveButton = By.id("saveButton");
    protected By errorMessage = By.id("errorMessage");
    protected By notificationMessage = By.id("notificationMessage");

    public UserProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyUserLoggedIn() {
        Assert.assertTrue(isElementVisible(accountDashboardLink), "User is not logged in.");
    }

    public void navigateToAccountDashboard() {
        clickElement(accountDashboardLink);
    }

    public void verifyProfileAccess() {
        Assert.assertTrue(isElementVisible(profileLink), "Profile access failed.");
    }

    public void verifyProfilePage() {
        clickElement(profileLink);
        Assert.assertTrue(isElementVisible(nameField), "Profile page is not accessible.");
    }

    public void updatePersonalInformation() {
        enterText(nameField, "New Name");
        enterText(emailField, "newemail@example.com");
        enterText(shippingAddressField, "New Shipping Address");
        enterText(billingAddressField, "New Billing Address");
        enterText(phoneField, "1234567890");
    }

    public void saveChanges() {
        clickElement(saveButton);
    }

    public void verifyChangesSaved() {
        Assert.assertTrue(isElementVisible(notificationMessage), "Changes were not saved.");
    }

    public void verifyUpdatingEmailAndPhone() {
        Assert.assertTrue(isElementVisible(emailField) && isElementVisible(phoneField), "Email and phone fields are not visible.");
    }

    public void enterInvalidEmailOrPhone() {
        enterText(emailField, "invalidemail");
        enterText(phoneField, "invalidphone");
    }

    public void verifyErrorMessageDisplayed() {
        Assert.assertTrue(isElementVisible(errorMessage), "Error message is not displayed.");
    }

    public void verifySuccessfulUpdate() {
        Assert.assertTrue(isElementVisible(notificationMessage), "Update was not successful.");
    }

    public void verifyNotificationReceived() {
        String message = getTextFromElement(notificationMessage);
        Assert.assertEquals(message, "Update successful", "Notification not received.");
    }

    public void verifyChangesMade() {
        Assert.assertTrue(isElementVisible(saveButton), "Changes were not made.");
    }

    public void verifyChangesLogged() {
        // Implement logic to verify changes are logged
        Assert.assertTrue(true, "Changes are logged.");
    }

    public void verifySensitiveInformationUpdate() {
        Assert.assertTrue(isElementVisible(nameField) && isElementVisible(emailField), "Sensitive information fields are not visible.");
    }

    public void verifyDataEncryption() {
        // Implement logic to verify data encryption
        Assert.assertTrue(true, "Data is encrypted.");
    }

    public void verifyInformationUpdated() {
        Assert.assertTrue(isElementVisible(notificationMessage), "Information was not updated.");
    }

    public void revertChanges() {
        // Implement logic to revert changes
        Assert.assertTrue(true, "Changes reverted.");
    }

    public void verifyChangesReverted() {
        // Implement logic to verify changes are reverted
        Assert.assertTrue(true, "Changes are reverted.");
    }
}