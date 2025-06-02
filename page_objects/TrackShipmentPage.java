package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class TrackShipmentPage extends WebReusableComponents {

    protected final By customerIdField = By.id("customerId");
    protected final By loginButton = By.id("loginButton");
    protected final By trackShipmentSection = By.id("trackShipmentSection");
    protected final By shipmentIdField = By.id("shipmentId");
    protected final By errorMessage = By.id("errorMessage");
    protected final By logoutButton = By.id("logoutButton");

    public TrackShipmentPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyCustomerAccount(String customerId) {
        waitUntilElementVisible(customerIdField, 3);
        enterText(customerIdField, customerId);
        Assert.assertTrue(isElementVisible(customerIdField), "Customer ID field is not visible.");
    }

    public void loginToAccount(String username, String password) {
        enterText(By.id("username"), username);
        enterText(By.id("password"), password);
        clickElement(loginButton);
        verifyLoginSuccess();
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(isElementVisible(By.id("accountDashboard")), "Login was not successful.");
    }

    public void navigateToTrackShipment() {
        clickElement(By.id("trackShipmentLink"));
        verifyTrackShipmentSectionDisplayed();
    }

    public void verifyTrackShipmentSectionDisplayed() {
        Assert.assertTrue(isElementVisible(trackShipmentSection), "Track Shipment section is not displayed.");
    }

    public void enterShipmentID(String shipmentId) {
        enterText(shipmentIdField, shipmentId);
        clickElement(By.id("searchButton"));
        verifyInvalidShipmentIDErrorMessage();
    }

    public void verifyInvalidShipmentIDErrorMessage() {
        String actualMessage = getTextFromElement(errorMessage);
        Assert.assertEquals(actualMessage, "Invalid Shipment ID.", "Error message does not match.");
    }

    public void refreshPage() {
        driver.navigate().refresh();
        verifyErrorMessagePersists();
    }

    public void verifyErrorMessagePersists() {
        Assert.assertTrue(isElementVisible(errorMessage), "Error message does not persist.");
        Assert.assertFalse(isElementVisible(By.id("shipmentDetails")), "Shipment details are displayed.");
    }

    public void logoutOfAccount() {
        clickElement(logoutButton);
        verifyLogoutSuccess();
    }

    public void verifyLogoutSuccess() {
        Assert.assertTrue(isElementVisible(By.id("loginPage")), "Logout was not successful.");
    }

    private void waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    private void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    private boolean isElementVisible(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private String getTextFromElement(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }
}