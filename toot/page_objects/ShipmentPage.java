package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import .time.Duration;

public class ShipmentPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public ShipmentPage(WebDriver driver) {
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

    public boolean isDashboardDisplayed() {
        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(dashboard)));
        return dashboardElement.isDisplayed();
    }

    public void navigateToOrdersModule() {
        WebElement ordersModule = driver.findElement(By.id(orders_module));
        ordersModule.click();
    }

    public boolean isOrdersListDisplayed() {
        WebElement ordersList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(orders_list)));
        return ordersList.isDisplayed();
    }

    public void selectOrder(String orderId) {
        WebElement orderElement = driver.findElement(By.id(order_ + orderId));
        orderElement.click();
    }

    public boolean isOrderDetailsDisplayed(String orderId) {
        WebElement orderDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(order_details_ + orderId)));
        return orderDetails.isDisplayed();
    }

    public String getShipmentStatus() {
        WebElement statusElement = driver.findElement(By.id(shipment_status));
        return statusElement.getText();
    }

    public void updateShipmentStatus(String status) {
        WebElement statusDropdown = driver.findElement(By.id(status_dropdown));
        statusDropdown.click();
        WebElement statusOption = driver.findElement(By.id(status_option_ + status));
        statusOption.click();
    }

    public boolean isShipmentStatusUpdated(String status) {
        WebElement statusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(shipment_status)));
        return status.equals(statusElement.getText());
    }

    public boolean isAlertSent() {
        WebElement alertElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(alert_sent)));
        return alertElement.isDisplayed();
    }

    public String getAlertMessage() {
        WebElement alertMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(alert_message)));
        return alertMessage.getText();
    }

    public void navigateToTrackShipment() {
        WebElement trackShipmentLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(track_shipment_link)));
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

    public boolean areShipmentDetailsDisplayed() {
        WebElement shipmentDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(shipment_details)));
        return shipmentDetails.isDisplayed();
    }

    public String getCurrentLocation() {
        WebElement locationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(current_location)));
        return locationElement.getText();
    }

    public String getEstimatedDeliveryTime() {
        WebElement deliveryTimeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(estimated_delivery_time)));
        return deliveryTimeElement.getText();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public boolean isUpdatedLocationDisplayed() {
        WebElement updatedLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(updated_location)));
        return updatedLocation.isDisplayed();
    }

    public boolean isUpdatedDeliveryTimeDisplayed() {
        WebElement updatedDeliveryTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(updated_delivery_time)));
        return updatedDeliveryTime.isDisplayed();
    }

    public void logout() {
        WebElement logoutButton = driver.findElement(By.id(logout_button));
        logoutButton.click();
    }

    public boolean isLoginPageDisplayed() {
        WebElement loginPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(login_page)));
        return loginPage.isDisplayed();
    }
}