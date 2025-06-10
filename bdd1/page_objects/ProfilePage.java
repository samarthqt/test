package bdd1.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class ProfilePage extends WebReusableComponents {

    protected By lblRelease = By.id("releaseLabel");
    protected By lblLastDeployedDate = By.id("lastDeployedDateLabel");
    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By addressBookLink = By.id("addressBook");
    protected By addAddressButton = By.id("addAddress");
    protected By txtAddressLine1 = By.id("addressLine1");
    protected By txtCity = By.id("city");
    protected By txtState = By.id("state");
    protected By txtPostalCode = By.id("postalCode");
    protected By txtCountry = By.id("country");
    protected By saveAddressButton = By.id("saveAddress");
    protected By addressEntries = By.cssSelector(".address-entry");

    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    public void loginAsAdmin() {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, "admin");
        enterText(txtPassword, "admin123");
        clickElement(btnLogin);
        Assert.assertTrue(isElementDisplayed(lblRelease), "Admin login failed.");
    }

    public void loginAsUser() {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, "user");
        enterText(txtPassword, "user123");
        clickElement(btnLogin);
        Assert.assertTrue(isElementDisplayed(lblRelease), "User login failed.");
    }

    public void navigateToProfilePage() {
        launchUrl(getAppUrl());
        maximizeWindow();
        Assert.assertTrue(isElementDisplayed(lblRelease), "Navigation to profile page failed.");
    }

    public void verifyLabelDisplayed(String label) {
        By locator = getLabelLocator(label);
        waitUntilElementVisible(locator, 3);
        Assert.assertTrue(isElementDisplayed(locator), label + " label is not displayed.");
    }

    public void verifyLabelValue(String label) {
        By locator = getLabelLocator(label);
        waitUntilElementVisible(locator, 3);
        String value = getTextFromElement(locator);
        Assert.assertNotNull(value, label + " label does not have an appropriate value.");
    }

    public void addNewAddress(String addressLine1, String city, String state, String postalCode, String country) {
        waitUntilElementVisible(addAddressButton, 3);
        clickElement(addAddressButton);
        enterText(txtAddressLine1, addressLine1);
        enterText(txtCity, city);
        enterText(txtState, state);
        enterText(txtPostalCode, postalCode);
        enterText(txtCountry, country);
        clickElement(saveAddressButton);
        verifyAddressSaved();
    }

    public void verifyAddressSaved() {
        waitUntilElementVisible(addressEntries, 3);
        List<WebElement> addresses = getWebElementList(addressEntries);
        Assert.assertFalse(addresses.isEmpty(), "No addresses found in the address book.");
    }

    private By getLabelLocator(String label) {
        switch (label) {
            case "Release":
                return lblRelease;
            case "Last Deployed Date":
                return lblLastDeployedDate;
            default:
                throw new IllegalArgumentException("Invalid label: " + label);
        }
    }
}