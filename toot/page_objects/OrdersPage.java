package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import .time.Duration;

public class OrdersPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToOrdersModule() {
        WebElement ordersModule = wait.until(ExpectedConditions.elementToBeClickable(By.id(orders_module)));
        ordersModule.click();
    }

    public boolean isOrdersListDisplayed() {
        WebElement ordersList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(orders_list)));
        return ordersList.isDisplayed();
    }

    public void selectOrderById(String orderId) {
        WebElement order = wait.until(ExpectedConditions.elementToBeClickable(By.id(order_ + orderId)));
        order.click();
    }

    public boolean isOrderDetailsDisplayed(String orderId) {
        WebElement orderDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(order_details_ + orderId)));
        return orderDetails.isDisplayed();
    }

    public void updateShipmentStatus(String status) {
        WebElement shipmentStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(shipment_status)));
        shipmentStatus.clear();
        shipmentStatus.sendKeys(status);
        WebElement updateButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(update_status_button)));
        updateButton.click();
    }

    public boolean isShipmentStatusUpdated(String expectedStatus) {
        WebElement updatedStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(updated_status)));
        return updatedStatus.getText().equals(expectedStatus);
    }

    public boolean ordersExist(int startId, int endId) {
        for (int i = startId; i <= endId; i++) {
            WebElement order = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(order_ + i)));
            if (!order.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean customersSubscribedToAlerts() {
        WebElement alertSubscription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(alert_subscription)));
        return alertSubscription.isDisplayed();
    }

    public boolean isOrdersModuleDisplayed() {
        WebElement ordersModuleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(orders_module)));
        return ordersModuleElement.isDisplayed();
    }

    public String getCustomerEmail() {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(customer_email)));
        return emailElement.getText();
    }

    public void selectOrders(int startId, int endId) {
        for (int i = startId; i <= endId; i++) {
            WebElement order = wait.until(ExpectedConditions.elementToBeClickable(By.id(order_ + i)));
            order.click();
        }
    }

    public boolean areOrderDetailsDisplayed(int startId, int endId) {
        for (int i = startId; i <= endId; i++) {
            WebElement orderDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(order_details_ + i)));
            if (!orderDetails.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public boolean isShipmentStatusDispatched(int startId, int endId) {
        for (int i = startId; i <= endId; i++) {
            WebElement status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(status_ + i)));
            if (!status.getText().equals(Dispatched)) {
                return false;
            }
        }
        return true;
    }

    public void updateShipmentStatusToDispatched(int startId, int endId) {
        for (int i = startId; i <= endId; i++) {
            WebElement statusDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id(status_dropdown_ + i)));
            statusDropdown.click();
            WebElement dispatchedOption = wait.until(ExpectedConditions.elementToBeClickable(By.id(status_dispatched_ + i)));
            dispatchedOption.click();
            WebElement updateButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(update_button_ + i)));
            updateButton.click();
        }
    }

    public boolean isShipmentStatusUpdatedToDispatched(int startId, int endId) {
        for (int i = startId; i <= endId; i++) {
            WebElement updatedStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(updated_status_ + i)));
            if (!updatedStatus.getText().equals(Dispatched)) {
                return false;
            }
        }
        return true;
    }

    public void monitorAlertSystem() {
        WebElement alertSystem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(alert_system)));
        alertSystem.click();
    }

    public boolean areAlertsSentWithoutDelay(String email, int startId, int endId) {
        for (int i = startId; i <= endId; i++) {
            WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(alert_ + i)));
            if (!alert.getText().contains(email)) {
                return false;
            }
        }
        return true;
    }

    public boolean isSystemPerformanceOptimal() {
        WebElement performanceIndicator = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(performance_indicator)));
        return performanceIndicator.getText().equals(Optimal);
    }

    public boolean isNoAlertMessageDisplayed() {
        WebElement noAlertMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(no_alert_message)));
        return noAlertMessage.isDisplayed();
    }

    public boolean isErrorMessageLogged() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(error_message_invalid_email)));
        return errorMessage.isDisplayed();
    }
}