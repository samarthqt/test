package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class ShipmentPage extends WebReusableComponents {

    private WebDriver driver;
    private WebDriverWait wait;

    protected By loginButton = By.id(loginButton);
    protected By trackShipmentSection = By.id(trackShipmentSection);
    protected By searchBar = By.id(searchBar);
    protected By shipmentDetails = By.id(shipmentDetails);
    protected By currentLocation = By.id(currentLocation);
    protected By estimatedDeliveryTime = By.id(estimatedDeliveryTime);
    protected By logoutButton = By.id(logoutButton);
    protected By customerIdField = By.id(customerId);
    protected By ordersModule = By.id(ordersModule);
    protected By orderDetails = By.id(orderDetails);
    protected By shipmentStatus = By.id(shipmentStatus);
    protected By alertSystem = By.id(alertSystem);
    protected By dashboard = By.id(dashboard);

    public ShipmentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void verifyTrackShipmentSectionDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(trackShipmentSection));
        Assert.assertTrue(driver.findElement(trackShipmentSection).isDisplayed(), Track Shipment section is not displayed.);
    }

    public void refreshPage() {
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
    }

    public void verifyErrorMessageDisplayed(String expectedMessage) {
        WebElement errorMessage = driver.findElement(By.id(errorMessage));
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        Assert.assertEquals(errorMessage.getText(), expectedMessage, Error message does not match.);
    }

    public void verifyCurrentLocation(String location) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(currentLocation));
        Assert.assertEquals(driver.findElement(currentLocation).getText(), location, Current location is not displayed correctly.);
    }

    public void verifyAlertMessage(String expectedMessage) {
        WebElement alertMessage = driver.findElement(By.id(alertMessage));
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        Assert.assertEquals(alertMessage.getText(), expectedMessage, Alert message does not match.);
    }

    public void verifyCustomerAccount(String customerId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerIdField));
        driver.findElement(customerIdField).sendKeys(customerId);
        Assert.assertTrue(driver.findElement(customerIdField).getAttribute(value).equals(customerId), Customer ID is not entered correctly.);
    }

    public void logoutFromAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        driver.findElement(logoutButton).click();
        Assert.assertTrue(driver.findElement(loginButton).isDisplayed(), Logout failed.);
    }

    public void verifyOrderExists(int orderId) {
        WebElement orderElement = driver.findElement(By.id(order_ + orderId));
        wait.until(ExpectedConditions.visibilityOf(orderElement));
        Assert.assertTrue(orderElement.isDisplayed(), Order does not exist.);
    }

    public void verifyErrorMessagePersists(String expectedMessage) {
        WebElement errorMessage = driver.findElement(By.id(errorMessage));
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        Assert.assertEquals(errorMessage.getText(), expectedMessage, Error message does not persist.);
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        driver.findElement(logoutButton).click();
        Assert.assertTrue(driver.findElement(loginButton).isDisplayed(), Logout failed.);
    }

    public void verifyRealTimeUpdates() {
        WebElement updatesElement = driver.findElement(By.id(realTimeUpdates));
        wait.until(ExpectedConditions.visibilityOf(updatesElement));
        Assert.assertTrue(updatesElement.isDisplayed(), Real-time updates are not displayed.);
    }

    public void verifyEstimatedDeliveryTime(String time) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(estimatedDeliveryTime));
        Assert.assertEquals(driver.findElement(estimatedDeliveryTime).getText(), time, Estimated delivery time is not displayed correctly.);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
        Assert.assertTrue(driver.findElement(trackShipmentSection).isDisplayed(), Login failed.);
    }

    public void verifyAlertSent(String email, String status) {
        WebElement alertElement = driver.findElement(By.id(alert_ + email));
        wait.until(ExpectedConditions.visibilityOf(alertElement));
        Assert.assertTrue(alertElement.getText().contains(status), Alert was not sent.);
    }

    public void updateShipmentStatus(String status) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(shipmentStatus));
        driver.findElement(shipmentStatus).sendKeys(status);
        Assert.assertTrue(driver.findElement(shipmentStatus).getAttribute(value).equals(status), Shipment status update failed.);
    }

    public void enterUserName(String userName) {
        WebElement usernameField = driver.findElement(By.id(username));
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(userName);
        Assert.assertTrue(usernameField.getAttribute(value).equals(userName), Username is not entered correctly.);
    }

    public void verifyLogoutSuccess() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        Assert.assertTrue(driver.findElement(loginButton).isDisplayed(), Logout was not successful.);
    }

    public void enterShipmentIDInSearchBar(String shipmentId) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
        driver.findElement(searchBar).sendKeys(shipmentId);
        driver.findElement(By.id(searchButton)).click();
        Assert.assertTrue(driver.findElement(shipmentDetails).getText().contains(shipmentId), Shipment ID search failed.);
    }

    public void selectOrder(int orderId) {
        WebElement orderElement = driver.findElement(By.id(order_ + orderId));
        wait.until(ExpectedConditions.elementToBeClickable(orderElement));
        orderElement.click();
        Assert.assertTrue(driver.findElement(orderDetails).isDisplayed(), Order selection failed.);
    }

    public void verifyShipmentStatus(String status) {
        WebElement statusElement = driver.findElement(By.id(shipmentStatus_ + status));
        wait.until(ExpectedConditions.visibilityOf(statusElement));
        Assert.assertTrue(statusElement.isDisplayed(), Shipment status is not displayed.);
    }

    public void verifyShipmentInTransit(String shipmentId) {
        WebElement shipmentElement = driver.findElement(By.id(shipment_ + shipmentId));
        wait.until(ExpectedConditions.visibilityOf(shipmentElement));
        Assert.assertTrue(shipmentElement.getText().contains(In Transit), Shipment is not in transit.);
    }

    public void loginToSystem(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickLoginButton();
    }

    public void verifyCustomerAlertReceived() {
        WebElement alertElement = driver.findElement(By.id(customerAlert));
        wait.until(ExpectedConditions.visibilityOf(alertElement));
        Assert.assertTrue(alertElement.isDisplayed(), Customer alert was not received.);
    }

    public void verifyOrdersModuleDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ordersModule));
        Assert.assertTrue(driver.findElement(ordersModule).isDisplayed(), Orders module is not displayed.);
    }

    public void verifyShipmentIDProcessing(String shipmentId) {
        WebElement shipmentElement = driver.findElement(By.id(shipment_ + shipmentId));
        wait.until(ExpectedConditions.visibilityOf(shipmentElement));
        Assert.assertTrue(shipmentElement.getText().contains(Processing), Shipment ID is not processing.);
    }

    public void verifyShipmentStatusUpdated(String status) {
        WebElement statusElement = driver.findElement(By.id(shipmentStatus_ + status));
        wait.until(ExpectedConditions.visibilityOf(statusElement));
        Assert.assertEquals(statusElement.getText(), status, Shipment status update failed.);
    }

    public void verifyCurrentLocationDisplayed(String location) {
        WebElement locationElement = driver.findElement(By.id(currentLocation_ + location));
        wait.until(ExpectedConditions.visibilityOf(locationElement));
        Assert.assertTrue(locationElement.isDisplayed(), Current location is not displayed.);
    }

    public void verifyOrderDetailsDisplayed(int orderId) {
        WebElement orderElement = driver.findElement(By.id(orderDetails_ + orderId));
        wait.until(ExpectedConditions.visibilityOf(orderElement));
        Assert.assertTrue(orderElement.isDisplayed(), Order details are not displayed.);
    }

    public void logoutOfAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        driver.findElement(logoutButton).click();
        Assert.assertTrue(driver.findElement(loginButton).isDisplayed(), Logout failed.);
    }

    public void verifyNoShipmentDetailsDisplayed(String shipmentId) {
        WebElement shipmentElement = driver.findElement(By.id(shipmentDetails_ + shipmentId));
        wait.until(ExpectedConditions.invisibilityOf(shipmentElement));
        Assert.assertFalse(shipmentElement.isDisplayed(), Shipment details are displayed.);
    }

    public void verifyEstimatedDeliveryTimeDisplayed(String time) {
        WebElement timeElement = driver.findElement(By.id(estimatedDeliveryTime_ + time));
        wait.until(ExpectedConditions.visibilityOf(timeElement));
        Assert.assertTrue(timeElement.isDisplayed(), Estimated delivery time is not displayed.);
    }

    public void enterShipmentID(String shipmentId) {
        WebElement shipmentField = driver.findElement(By.id(shipmentId));
        wait.until(ExpectedConditions.visibilityOf(shipmentField));
        shipmentField.sendKeys(shipmentId);
        Assert.assertTrue(shipmentField.getAttribute(value).equals(shipmentId), Shipment ID is not entered correctly.);
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        driver.findElement(logoutButton).click();
        Assert.assertTrue(driver.findElement(loginButton).isDisplayed(), Logout failed.);
    }

    public void verifyDashboardDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
        Assert.assertTrue(driver.findElement(dashboard).isDisplayed(), Dashboard is not displayed.);
    }

    public void navigateToOrdersModule() {
        wait.until(ExpectedConditions.elementToBeClickable(ordersModule));
        driver.findElement(ordersModule).click();
        Assert.assertTrue(driver.findElement(orderDetails).isDisplayed(), Navigation to Orders module failed.);
    }

    public void waitForMinutes(int minutes) {
        try {
            Thread.sleep(minutes * 60 * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void verifyShipmentIDFeedback(String shipmentId) {
        WebElement feedbackElement = driver.findElement(By.id(shipmentFeedback_ + shipmentId));
        wait.until(ExpectedConditions.visibilityOf(feedbackElement));
        Assert.assertTrue(feedbackElement.isDisplayed(), Shipment ID feedback is not displayed.);
    }

    public void loginToAccount(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickLoginButton();
    }

    public void verifyCustomerSubscription() {
        WebElement subscriptionElement = driver.findElement(By.id(customerSubscription));
        wait.until(ExpectedConditions.visibilityOf(subscriptionElement));
        Assert.assertTrue(subscriptionElement.isDisplayed(), Customer subscription is not verified.);
    }

    public void verifyShipmentDetailsDisplayed(String shipmentId) {
        WebElement shipmentElement = driver.findElement(By.id(shipmentDetails_ + shipmentId));
        wait.until(ExpectedConditions.visibilityOf(shipmentElement));
        Assert.assertTrue(shipmentElement.isDisplayed(), Shipment details are not displayed.);
    }

    public void verifyLoginSuccess() {
        WebElement successElement = driver.findElement(By.id(loginSuccess));
        wait.until(ExpectedConditions.visibilityOf(successElement));
        Assert.assertTrue(successElement.isDisplayed(), Login was not successful.);
    }

    public void checkAlertSystem() {
        wait.until(ExpectedConditions.elementToBeClickable(alertSystem));
        driver.findElement(alertSystem).click();
        Assert.assertTrue(driver.findElement(By.id(alertConfirmation)).isDisplayed(), Alert system check failed.);
    }

    private void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.id(password));
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
        Assert.assertTrue(passwordField.getAttribute(value).equals(password), Password is not entered correctly.);
    }

    private boolean isCustomerAccountValid(String customerId) {
        // Logic to verify customer account validity
        return true;
    }

    private boolean isShipmentInTransit(String shipmentId) {
        // Logic to verify shipment in transit
        return true;
    }

    private boolean isLoginSuccessful() {
        // Logic to verify login success
        return true;
    }
}