
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import .time.Duration;

public class TrackingPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By trackShipmentLink = By.id(track_shipment_link);
    private final By trackShipmentSection = By.id(track_shipment_section);
    private final By shipmentIdField = By.id(shipment_id);
    private final By searchButton = By.id(search_button);
    private final By shipmentDetails = By.id(shipment_details);
    private final By shipmentStatus = By.id(shipment_status);
    private final By refreshButton = By.id(refresh_button);
    private final By usernameField = By.id(username);
    private final By passwordField = By.id(password);
    private final By loginButton = By.id(login_button);
    private final By dashboardElement = By.id(dashboard);
    private final By errorMessage = By.id(error_message);
    private final By feedbackMessage = By.id(feedback_message);
    private final By gracefulHandlingMessage = By.id(graceful_handling_message);
    private final By logoutButton = By.id(logout_button);
    private final By loginPage = By.id(login_page);

    public TrackingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToTrackShipment() {
        WebElement trackShipment = wait.until(ExpectedConditions.elementToBeClickable(trackShipmentLink));
        trackShipment.click();
        Assert.assertTrue(isTrackShipmentSectionDisplayed(), Track Shipment section is not displayed.);
    }

    public void enterUsername(String username) {
        WebElement usernameElem = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        usernameElem.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordElem = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElem.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
        Assert.assertTrue(isDashboardDisplayed(), Dashboard is not displayed after login.);
    }

    public boolean isDashboardDisplayed() {
        WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardElement));
        return dashboard.isDisplayed();
    }

    public boolean isTrackShipmentSectionDisplayed() {
        WebElement trackSection = wait.until(ExpectedConditions.visibilityOfElementLocated(trackShipmentSection));
        return trackSection.isDisplayed();
    }

    public void enterShipmentId(String shipmentId) {
        WebElement shipmentIdElem = wait.until(ExpectedConditions.visibilityOfElementLocated(shipmentIdField));
        shipmentIdElem.sendKeys(shipmentId);
        clickSearchButton();
    }

    public void clickSearchButton() {
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchBtn.click();
        Assert.assertTrue(isShipmentDetailsDisplayed(), Shipment details are not displayed.);
    }

    public boolean isShipmentDetailsDisplayed() {
        WebElement details = wait.until(ExpectedConditions.visibilityOfElementLocated(shipmentDetails));
        return details.isDisplayed();
    }

    public String getShipmentStatus() {
        WebElement status = wait.until(ExpectedConditions.visibilityOfElementLocated(shipmentStatus));
        return status.getText();
    }

    public void refreshTrackingInformation() {
        WebElement refreshBtn = wait.until(ExpectedConditions.elementToBeClickable(refreshButton));
        refreshBtn.click();
        Assert.assertTrue(isTrackingInformationUpdated(), Tracking information is not updated.);
    }

    public boolean isTrackingInformationUpdated() {
        // Implement logic to verify if tracking information is updated
        return true; // Placeholder for actual implementation
    }

    public boolean isErrorMessageDisplayed() {
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return error.isDisplayed();
    }

    public boolean isFeedbackMessageDisplayed() {
        WebElement feedback = wait.until(ExpectedConditions.visibilityOfElementLocated(feedbackMessage));
        return feedback.isDisplayed();
    }

    public boolean isGracefulHandlingMessageDisplayed() {
        WebElement gracefulMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(gracefulHandlingMessage));
        return gracefulMessage.isDisplayed();
    }

    public void clickLogoutButton() {
        WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutBtn.click();
        Assert.assertTrue(isLoginPageDisplayed(), Login page is not displayed after logout.);
    }

    public boolean isLoginPageDisplayed() {
        WebElement loginPg = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage));
        return loginPg.isDisplayed();
    }
}
