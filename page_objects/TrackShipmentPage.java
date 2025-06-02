package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class TrackShipmentPage extends WebReusableComponents {

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By sectionTrackShipment = By.id("trackShipmentSection");
    protected By txtShipmentID = By.id("shipmentID");
    protected By btnSearch = By.id("searchButton");
    protected By feedbackMessage = By.id("feedbackMessage");
    protected By btnLogout = By.id("logoutButton");

    public TrackShipmentPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Logs into the account using the provided username and password.
     * @param userName The username to enter.
     * @param password The password to enter.
     */
    public void loginToAccount(String userName, String password) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, userName);
        enterText(txtPassword, password);
        clickElement(btnLogin);
    }

    /**
     * Verifies that login was successful by checking the visibility of the track shipment section.
     */
    public void verifyLoginSuccess() {
        Assert.assertTrue(isElementVisible(sectionTrackShipment), "Login failed.");
    }

    /**
     * Navigates to the specified section.
     * @param sectionName The name of the section to navigate to.
     */
    public void navigateToSection(String sectionName) {
        waitUntilElementVisible(sectionTrackShipment, 3);
        clickElement(sectionTrackShipment);
    }

    /**
     * Verifies that the specified section is displayed.
     * @param sectionName The name of the section to verify.
     */
    public void verifySectionDisplayed(String sectionName) {
        Assert.assertTrue(isElementVisible(sectionTrackShipment), sectionName + " section is not displayed.");
    }

    /**
     * Enters the shipment ID and initiates a search.
     * @param shipmentID The shipment ID to enter.
     */
    public void enterShipmentID(String shipmentID) {
        waitUntilElementVisible(txtShipmentID, 3);
        enterText(txtShipmentID, shipmentID);
        clickElement(btnSearch);
    }

    /**
     * Verifies that the input processing is successful without errors.
     */
    public void verifyInputProcessing() {
        Assert.assertFalse(isElementVisible(feedbackMessage), "System crashed or displayed errors.");
    }

    /**
     * Checks for feedback or error messages.
     */
    public void checkForFeedbackOrErrorMessage() {
        waitUntilElementVisible(feedbackMessage, 3);
    }

    /**
     * Verifies that error messages are displayed or input is handled gracefully.
     */
    public void verifyErrorMessageOrGracefulHandling() {
        String message = getTextFromElement(feedbackMessage);
        Assert.assertTrue(message.contains("error") || message.contains("handled"), "Input not handled gracefully.");
    }

    /**
     * Logs out from the account.
     */
    public void logoutFromAccount() {
        waitUntilElementVisible(btnLogout, 3);
        clickElement(btnLogout);
    }

    /**
     * Verifies that logout was successful by checking the invisibility of the track shipment section.
     */
    public void verifyLogoutSuccess() {
        Assert.assertFalse(isElementVisible(sectionTrackShipment), "Logout failed.");
    }
}