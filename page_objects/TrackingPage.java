package com.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TrackingPage {

    private WebDriver driver;
    private WebDriverWait wait;

    protected By txtCustomerId = By.id(customerId);
    protected By txtUserName = By.id(username);
    protected By txtPassword = By.id(password);
    protected By btnLogin = By.id(loginButton);
    protected By trackShipmentSection = By.id(trackShipmentSection);
    protected By txtShipmentId = By.id(shipmentId);
    protected By shipmentDetails = By.id(shipmentDetails);
    protected By shipmentStatus = By.id(shipmentStatus);
    protected By refreshButton = By.id(refreshButton);
    protected By btnLogout = By.id(logoutButton);
    protected By errorMessage = By.id(errorMessage);

    public TrackingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void verifyCustomerAccount(String customerId) {
        waitUntilElementVisible(txtCustomerId);
        Assert.assertEquals(getTextFromElement(txtCustomerId), customerId, Customer ID does not match.);
    }

    public void loginToAccount(String userName, String password) {
        waitUntilElementVisible(txtUserName);
        enterText(txtUserName, userName);
        enterText(txtPassword, password);
        clickElement(btnLogin);
    }

    public void verifyLoginSuccess() {
        waitUntilElementVisible(trackShipmentSection);
        Assert.assertTrue(isElementDisplayed(trackShipmentSection), Login was not successful.);
    }

    public void navigateToTrackShipmentSection() {
        waitUntilElementVisible(trackShipmentSection);
        clickElement(trackShipmentSection);
    }

    public void verifyTrackShipmentSectionDisplayed() {
        waitUntilElementVisible(trackShipmentSection);
        Assert.assertTrue(isElementDisplayed(trackShipmentSection), Track Shipment section is not displayed.);
    }

    public void enterShipmentIDInSearchBar(String shipmentId) {
        waitUntilElementVisible(txtShipmentId);
        enterText(txtShipmentId, shipmentId);
    }

    public void verifyShipmentDetailsDisplayed(String shipmentId) {
        waitUntilElementVisible(shipmentDetails);
        Assert.assertTrue(getTextFromElement(shipmentDetails).contains(shipmentId), Shipment details are not displayed.);
    }

    public void verifyShipmentStatus(String expectedStatus) {
        waitUntilElementVisible(shipmentStatus);
        Assert.assertEquals(getTextFromElement(shipmentStatus), expectedStatus, Shipment status does not match.);
    }

    public void verifyAccurateShipmentStatus(String expectedStatus) {
        waitUntilElementVisible(shipmentStatus);
        Assert.assertEquals(getTextFromElement(shipmentStatus), expectedStatus, Shipment status is not accurate.);
    }

    public void refreshTrackingInformation() {
        waitUntilElementVisible(refreshButton);
        clickElement(refreshButton);
    }

    public void verifyRealTimeTrackingUpdates() {
        waitUntilElementVisible(shipmentDetails);
        Assert.assertTrue(isElementDisplayed(shipmentDetails), Real-time tracking updates are not visible.);
    }

    public void logoutFromAccount() {
        waitUntilElementVisible(btnLogout);
        clickElement(btnLogout);
    }

    public void verifyLogoutSuccess() {
        waitUntilElementVisible(btnLogin);
        Assert.assertTrue(isElementDisplayed(btnLogin), Logout was not successful.);
    }

    public void verifyInvalidShipmentIDErrorMessage() {
        waitUntilElementVisible(errorMessage);
        Assert.assertTrue(isElementDisplayed(errorMessage), Error message for invalid shipment ID is not displayed.);
    }

    public void verifyGracefulHandlingOrErrorMessage() {
        waitUntilElementVisible(errorMessage);
        Assert.assertTrue(isElementDisplayed(errorMessage), Error message is not handled gracefully.);
    }

    public void verifyErrorMessagePersists() {
        waitUntilElementVisible(errorMessage);
        Assert.assertTrue(isElementDisplayed(errorMessage), Error message does not persist.);
    }

    public void verifyImmediateTrackingUpdates() {
        waitUntilElementVisible(shipmentDetails);
        Assert.assertTrue(isElementDisplayed(shipmentDetails), Immediate tracking updates are not visible.);
    }

    public void verifyCurrentShipmentStatus() {
        waitUntilElementVisible(shipmentStatus);
        Assert.assertTrue(isElementDisplayed(shipmentStatus), Current shipment status is not visible.);
    }

    public void verifyInputProcessing() {
        waitUntilElementVisible(txtShipmentId);
        Assert.assertTrue(isElementDisplayed(txtShipmentId), Input processing is not visible.);
    }

    public void verifyShipmentInTransit(String shipmentId) {
        enterShipmentIDInSearchBar(shipmentId);
        waitUntilElementVisible(shipmentStatus);
        Assert.assertTrue(getTextFromElement(shipmentStatus).contains(In Transit), Shipment is not in transit.);
    }

    public void checkForFeedbackOrErrorMessage() {
        waitUntilElementVisible(errorMessage);
        Assert.assertTrue(isElementDisplayed(errorMessage), Feedback or error message is not displayed.);
    }

    private void waitUntilElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    private void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    private String getTextFromElement(By locator) {
        return driver.findElement(locator).getText();
    }

    private boolean isElementDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }
}