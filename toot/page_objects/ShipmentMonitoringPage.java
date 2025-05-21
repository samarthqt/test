package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import .time.Duration;

public class ShipmentMonitoringPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ShipmentMonitoringPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String username, String password) {
        driver.get(http://example.com/login);
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(username)));
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.id(password));
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id(login_button));
        loginButton.click();
    }

    public boolean isUserLoggedIn() {
        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(dashboard)));
        return dashboardElement.isDisplayed();
    }

    public String getCustomerId() {
        WebElement customerIdElement = driver.findElement(By.id(customer_id));
        return customerIdElement.getText();
    }

    public void navigateToTrackShipment() {
        WebElement trackShipmentLink = wait.until(ExpectedConditions.elementToBeClickable(By.id(track_shipment_link)));
        trackShipmentLink.click();
    }

    public boolean isTrackShipmentSectionDisplayed() {
        WebElement trackShipmentSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(track_shipment_section)));
        return trackShipmentSection.isDisplayed();
    }

    public void enterShipmentId(String shipmentId) {
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(shipment_search_bar)));
        searchBar.sendKeys(shipmentId);
        WebElement searchButton = driver.findElement(By.id(search_button));
        searchButton.click();
    }

    public boolean areShipmentDetailsDisplayed(String shipmentId) {
        WebElement shipmentDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(shipment_details)));
        return shipmentDetails.getText().contains(shipmentId);
    }

    public boolean isErrorMessageDisplayed() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(error_message)));
        return errorMessage.isDisplayed();
    }

    public boolean isFeedbackMessageDisplayed() {
        WebElement feedbackMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(feedback_message)));
        return feedbackMessage.isDisplayed();
    }

    public String getCurrentLocation() {
        WebElement currentLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(current_location)));
        return currentLocation.getText();
    }

    public String getEstimatedDeliveryTime() {
        WebElement estimatedDeliveryTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(estimated_delivery_time)));
        return estimatedDeliveryTime.getText();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void logout() {
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(logout_button)));
        logoutButton.click();
    }

    public boolean isUserLoggedOut() {
        WebElement loginPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(login_page)));
        return loginPageElement.isDisplayed();
    }

    public boolean isLoginPageDisplayed() {
        WebElement loginPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(login_page)));
        return loginPageElement.isDisplayed();
    }
}