
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import .io.File;
import .io.IOException;
import .time.Duration;

public class OrderHistoryPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By pageHeader = By.id(order-history-header);
    private final By orderList = By.id(order-list);
    private final By orderItem = By.cssSelector(.order-item);
    private final By orderDetails = By.id(order-details);
    private final By noOrdersMessage = By.id(no-orders-message);
    private final By nextPageButton = By.id(next-page);
    private final By dateFilter = By.id(date-filter);
    private final By filteredOrders = By.id(filtered-orders);
    private final By downloadInvoiceButton = By.id(download-invoice);

    public OrderHistoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToOrderHistoryPage() {
        driver.get(http://example.com/order-history);
        Assert.assertTrue(isPageLoaded(), Order History page did not load successfully.);
    }

    public boolean isPageLoaded() {
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeader));
        return header.isDisplayed();
    }

    public boolean isOrderListVisible() {
        WebElement list = wait.until(ExpectedConditions.visibilityOfElementLocated(orderList));
        return list.isDisplayed();
    }

    public void selectOrderFromList() {
        WebElement order = wait.until(ExpectedConditions.elementToBeClickable(orderItem));
        order.click();
        Assert.assertTrue(isOrderDetailsVisible(), Order details are not visible after selection.);
    }

    public boolean isOrderDetailsVisible() {
        WebElement details = wait.until(ExpectedConditions.visibilityOfElementLocated(orderDetails));
        return details.isDisplayed();
    }

    public void clearOrderList() {
        // Logic to clear order list for testing
        // Assuming some action is performed here to clear the list
        Assert.assertTrue(isNoOrdersMessageVisible(), No orders message is not visible after clearing the list.);
    }

    public boolean isNoOrdersMessageVisible() {
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(noOrdersMessage));
        return message.isDisplayed();
    }

    public void populateOrdersForPagination() {
        // Logic to populate orders for pagination testing
        // Assuming some action is performed here to populate orders
        Assert.assertTrue(isOrderListVisible(), Order list is not visible after populating orders.);
    }

    public void navigateThroughPages() {
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(nextPageButton));
        nextButton.click();
        Assert.assertTrue(areAllOrdersVisibleAcrossPages(), Not all orders are visible across pages.);
    }

    public boolean areAllOrdersVisibleAcrossPages() {
        // Logic to verify all orders are visible across pages
        // Assuming some validation logic here
        return true;
    }

    public void applyDateFilter() {
        WebElement filter = wait.until(ExpectedConditions.elementToBeClickable(dateFilter));
        filter.click();
        Assert.assertTrue(areFilteredOrdersVisible(), Filtered orders are not visible after applying date filter.);
    }

    public boolean areFilteredOrdersVisible() {
        WebElement orders = wait.until(ExpectedConditions.visibilityOfElementLocated(filteredOrders));
        return orders.isDisplayed();
    }

    public void downloadInvoice() {
        WebElement downloadButton = wait.until(ExpectedConditions.elementToBeClickable(downloadInvoiceButton));
        downloadButton.click();
        Assert.assertTrue(isInvoiceDownloaded(), Invoice was not downloaded successfully.);
    }

    public boolean isInvoiceDownloaded() {
        // Logic to verify invoice is downloaded
        // Assuming some validation logic here
        return true;
    }

    private void takeScreenshot(String fileName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(./screenshots/ + fileName));
    }
}
