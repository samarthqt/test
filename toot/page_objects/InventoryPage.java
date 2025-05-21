package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import .time.Duration;
import .util.List;
import .util.Map;

public class InventoryPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToInventoryModule() {
        driver.get(http://example.com/inventory);
    }

    public boolean isModuleActive() {
        WebElement moduleStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inventory_module_status)));
        return moduleStatus.isDisplayed();
    }

    public void setProductThreshold(int threshold) {
        WebElement thresholdField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(threshold)));
        thresholdField.clear();
        thresholdField.sendKeys(String.valueOf(threshold));
    }

    public void setCurrentStockLevel(int stockLevel) {
        WebElement stockLevelField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(stock_level)));
        stockLevelField.clear();
        stockLevelField.sendKeys(String.valueOf(stockLevel));
    }

    public void checkStockLevel() {
        WebElement checkButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(check_stock)));
        checkButton.click();
    }

    public boolean isWarningMessageDisplayed() {
        WebElement warningMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(warning_message)));
        return warningMessage.isDisplayed();
    }

    public void updateStockLevel(int newStockLevel) {
        WebElement stockLevelField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(stock_level)));
        stockLevelField.clear();
        stockLevelField.sendKeys(String.valueOf(newStockLevel));
        WebElement updateButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(update_stock)));
        updateButton.click();
    }

    public void setMultipleProductsStockLevels(List<Map<String, String>> products) {
        for (Map<String, String> product : products) {
            int productId = Integer.parseInt(product.get(Product ID));
            int threshold = Integer.parseInt(product.get(Threshold));
            int currentStock = Integer.parseInt(product.get(Current Stock));
            WebElement productRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(product_ + productId)));
            WebElement thresholdField = productRow.findElement(By.id(threshold));
            WebElement stockLevelField = productRow.findElement(By.id(stock_level));
            thresholdField.clear();
            thresholdField.sendKeys(String.valueOf(threshold));
            stockLevelField.clear();
            stockLevelField.sendKeys(String.valueOf(currentStock));
        }
    }

    public boolean isWarningMessageDisplayedForProduct(int productId) {
        WebElement productRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(product_ + productId)));
        WebElement warningMessage = productRow.findElement(By.id(warning_message));
        return warningMessage.isDisplayed();
    }

    public boolean hasLowInventoryThreshold() {
        WebElement thresholdElement = driver.findElement(By.id(low_inventory_threshold));
        return thresholdElement.isDisplayed();
    }

    public boolean isInventoryBelowThreshold() {
        WebElement inventoryLevel = driver.findElement(By.id(inventory_level));
        int level = Integer.parseInt(inventoryLevel.getText());
        WebElement thresholdElement = driver.findElement(By.id(low_inventory_threshold));
        int threshold = Integer.parseInt(thresholdElement.getText());
        return level < threshold;
    }

    public boolean isStockWarningNotificationSent() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(stock_warning_notification)));
        return notification.isDisplayed();
    }

    public boolean doesNotificationIncludeDetails() {
        WebElement notificationDetails = driver.findElement(By.id(notification_details));
        return notificationDetails.getText().contains(Product Name) && notificationDetails.getText().contains(Inventory Level);
    }

    public boolean isInventoryAboveThreshold() {
        WebElement inventoryLevel = driver.findElement(By.id(inventory_level));
        int level = Integer.parseInt(inventoryLevel.getText());
        WebElement thresholdElement = driver.findElement(By.id(low_inventory_threshold));
        int threshold = Integer.parseInt(thresholdElement.getText());
        return level > threshold;
    }

    public boolean isNoStockWarningNotificationSent() {
        WebElement notification = driver.findElement(By.id(stock_warning_notification));
        return !notification.isDisplayed();
    }

    public void configureNotificationSettings() {
        WebElement settingsButton = driver.findElement(By.id(notification_settings_button));
        settingsButton.click();
        WebElement saveButton = driver.findElement(By.id(save_settings_button));
        saveButton.click();
    }

    public boolean areSettingsSaved() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(settings_saved_confirmation)));
        return confirmationMessage.isDisplayed();
    }

    public boolean doesSystemRespectConfiguredSettings() {
        WebElement notification = driver.findElement(By.id(stock_warning_notification));
        return notification.getText().contains(Configured Settings);
    }

    public boolean areMultipleProductsBelowThreshold() {
        WebElement productList = driver.findElement(By.id(product_list));
        return productList.getText().contains(Low Inventory);
    }

    public void checkInventoryLevels() {
        WebElement checkButton = driver.findElement(By.id(check_inventory_button));
        checkButton.click();
    }

    public boolean areNotificationsSentForEachProduct() {
        WebElement notifications = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(multiple_stock_warning_notifications)));
        return notifications.isDisplayed();
    }

    public boolean doesEachNotificationIncludeDetails() {
        WebElement notificationDetails = driver.findElement(By.id(notification_details));
        return notificationDetails.getText().contains(Product Name) && notificationDetails.getText().contains(Inventory Level);
    }

    public void checkUserNotifications() {
        WebElement notificationTab = driver.findElement(By.id(notification_tab));
        notificationTab.click();
    }

    public boolean doesUserSeeStockWarningNotification() {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(stock_warning_notification)));
        return notification.isDisplayed();
    }
}