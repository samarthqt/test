package com.page_objects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.framework.reusable.WebReusableComponents;
import org.testng.Assert;
import java.util.List;

public class UserProfilePage extends WebReusableComponents {

    protected By userProfileLink = By.id("userProfile");
    protected By savedInformationSection = By.id("savedInformation");
    protected By editShippingAddressButton = By.id("editShippingAddress");
    protected By editBillingAddressButton = By.id("editBillingAddress");
    protected By txtShippingAddressLine = By.id("shippingAddressLine");
    protected By txtShippingCity = By.id("shippingCity");
    protected By txtShippingState = By.id("shippingState");
    protected By txtShippingPostalCode = By.id("shippingPostalCode");
    protected By txtShippingCountry = By.id("shippingCountry");
    protected By txtBillingAddressLine = By.id("billingAddressLine");
    protected By txtBillingCity = By.id("billingCity");
    protected By txtBillingState = By.id("billingState");
    protected By txtBillingPostalCode = By.id("billingPostalCode");
    protected By txtBillingCountry = By.id("billingCountry");
    protected By saveChangesButton = By.id("saveChanges");
    protected By confirmationMessage = By.id("confirmationMessage");
    protected By logoutButton = By.id("logout");
    protected By loginButton = By.id("login");

    public UserProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToUserProfile() {
        waitUntilElementVisible(userProfileLink, 3);
        clickElement(userProfileLink);
    }

    public void accessSavedInformationSection() {
        waitUntilElementVisible(savedInformationSection, 3);
        clickElement(savedInformationSection);
    }

    public void editShippingAddress(String addressLine, String city, String state, String postalCode, String country) {
        waitUntilElementVisible(editShippingAddressButton, 3);
        clickElement(editShippingAddressButton);
        enterText(txtShippingAddressLine, addressLine);
        enterText(txtShippingCity, city);
        enterText(txtShippingState, state);
        enterText(txtShippingPostalCode, postalCode);
        enterText(txtShippingCountry, country);
    }

    public void editBillingAddress(String addressLine, String city, String state, String postalCode, String country) {
        waitUntilElementVisible(editBillingAddressButton, 3);
        clickElement(editBillingAddressButton);
        enterText(txtBillingAddressLine, addressLine);
        enterText(txtBillingCity, city);
        enterText(txtBillingState, state);
        enterText(txtBillingPostalCode, postalCode);
        enterText(txtBillingCountry, country);
    }

    public void saveChanges() {
        waitUntilElementVisible(saveChangesButton, 3);
        clickElement(saveChangesButton);
    }

    public void verifyChangesSaved() {
        waitUntilElementVisible(confirmationMessage, 3);
        String message = getTextFromElement(confirmationMessage);
        Assert.assertEquals(message, "Changes saved successfully.", "Confirmation message does not match.");
    }

    public void logout() {
        waitUntilElementVisible(logoutButton, 3);
        clickElement(logoutButton);
    }

    public void login() {
        waitUntilElementVisible(loginButton, 3);
        clickElement(loginButton);
    }

    public void verifyUpdatedInformation() {
        accessSavedInformationSection();
        List<WebElement> shippingInfo = getWebElementList(By.cssSelector(".shipping-info"));
        List<WebElement> billingInfo = getWebElementList(By.cssSelector(".billing-info"));
        Assert.assertFalse(shippingInfo.isEmpty(), "Updated shipping information not displayed.");
        Assert.assertFalse(billingInfo.isEmpty(), "Updated billing information not displayed.");
    }
}