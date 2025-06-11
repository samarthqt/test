package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class WBSEfA_Page extends WebReusableComponents {

    protected By addressBookLink = By.id("addressBook");
    protected By addAddressButton = By.id("addAddress");
    protected By txtAddressLine1 = By.id("addressLine1");
    protected By txtCity = By.id("city");
    protected By txtState = By.id("state");
    protected By txtPostalCode = By.id("postalCode");
    protected By txtCountry = By.id("country");
    protected By saveAddressButton = By.id("saveAddress");
    protected By addressEntries = By.cssSelector(".address-entry");
    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");

    public WBSEfA_Page() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToAddressBook() {
        waitUntilElementVisible(addressBookLink, 3);
        clickElement(addressBookLink);
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
    }

    public void verifyAddressSaved() {
        waitUntilElementVisible(addressEntries, 3);
        List<WebElement> addresses = getWebElementList(addressEntries);
        Assert.assertFalse(addresses.isEmpty(), "No addresses found in the address book.");
    }

    public void removeAddress(String addressLine1) {
        By removeButton = removeAddressButton(addressLine1);
        waitUntilElementVisible(removeButton, 3);
        clickElement(removeButton);
    }

    public void verifyAddressRemoved(String addressLine1) {
        By addressLocator = removeAddressButton(addressLine1);
        boolean isAddressPresent = elementVisible(addressLocator);
        Assert.assertFalse(isAddressPresent, "Address was not removed from the address book.");
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyHomePageRedirection(String expectedURL) {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the homepage.");
    }

    private void waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    private void enterText(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    private List<WebElement> getWebElementList(By locator) {
        return driver.findElements(locator);
    }

    private boolean elementVisible(By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    private String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    private By removeAddressButton(String addressLine1) {
        return By.xpath("//div[contains(text(), '" + addressLine1 + "')]/following-sibling::button[@class='remove']");
    }
}