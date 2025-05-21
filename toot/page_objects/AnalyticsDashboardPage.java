package com.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import .time.Duration;

public class AnalyticsDashboardPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By dashboard = By.id(dashboard);
    private final By salesDataTab = By.id(sales_data_tab);
    private final By performanceMetricsTab = By.id(performance_metrics_tab);
    private final By salesGraph = By.id(sales_graph);
    private final By performanceGraph = By.id(performance_graph);
    private final By timePeriodFilter = By.id(time_period_filter);
    private final By exportDataOption = By.id(export_data_option);
    private final By noDataMessage = By.id(no_data_message);
    private final By confirmationMessage = By.id(confirmation_message);
    private final By errorMessage = By.id(error_message);
    private final By accessDeniedMessage = By.id(access_denied);
    private final By salesData = By.id(sales_data);
    private final By customizeButton = By.id(customize_button);
    private final By saveButton = By.id(save_button);
    private final By saveConfirmation = By.id(save_confirmation);
    private final By exportConfirmation = By.id(export_confirmation);

    public AnalyticsDashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToDashboard() {
        driver.get(http://example.com/analytics-dashboard);
    }

    public boolean isDashboardDisplayed() {
        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
        return dashboardElement.isDisplayed();
    }

    public void selectSalesDataTab() {
        wait.until(ExpectedConditions.elementToBeClickable(salesDataTab)).click();
    }

    public boolean isSalesGraphDisplayed() {
        WebElement salesGraphElement = wait.until(ExpectedConditions.visibilityOfElementLocated(salesGraph));
        return salesGraphElement.isDisplayed();
    }

    public boolean isSalesDataDisplayed() {
        WebElement salesDataElement = wait.until(ExpectedConditions.visibilityOfElementLocated(salesData));
        return salesDataElement.isDisplayed();
    }

    public void viewSalesData() {
        WebElement salesDataElement = wait.until(ExpectedConditions.visibilityOfElementLocated(salesData));
        salesDataElement.click();
    }

    public boolean isSalesDataClear() {
        WebElement salesDataElement = wait.until(ExpectedConditions.visibilityOfElementLocated(salesData));
        return salesDataElement.getText().contains(Clear Format);
    }

    public boolean isSalesDataUpToDate() {
        WebElement salesDataElement = wait.until(ExpectedConditions.visibilityOfElementLocated(salesData));
        return salesDataElement.getText().contains(Up-to-date);
    }

    public void filterSalesDataByDateRange(String startDate, String endDate) {
        WebElement startDateField = driver.findElement(By.id(start_date));
        WebElement endDateField = driver.findElement(By.id(end_date));
        startDateField.sendKeys(startDate);
        endDateField.sendKeys(endDate);
        WebElement filterButton = driver.findElement(By.id(filter_button));
        filterButton.click();
    }

    public boolean isSalesDataUpdatedForDateRange() {
        WebElement salesDataElement = wait.until(ExpectedConditions.visibilityOfElementLocated(salesData));
        return salesDataElement.getText().contains(Date Range Updated);
    }

    public void exportSalesData(String format) {
        WebElement exportButton = driver.findElement(By.id(export_button));
        exportButton.click();
        WebElement formatDropdown = driver.findElement(By.id(format_dropdown));
        formatDropdown.sendKeys(format);
        WebElement confirmExportButton = driver.findElement(By.id(confirm_export_button));
        confirmExportButton.click();
    }

    public boolean isSalesDataExported() {
        WebElement exportConfirmationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(exportConfirmation));
        return exportConfirmationElement.isDisplayed();
    }

    public boolean isConfirmationMessageDisplayed() {
        WebElement confirmationMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage));
        return confirmationMessageElement.isDisplayed();
    }

    public void customizeDashboardWidgets() {
        WebElement customizeButtonElement = driver.findElement(customizeButton);
        customizeButtonElement.click();
        WebElement saveButtonElement = driver.findElement(saveButton);
        saveButtonElement.click();
    }

    public boolean areChangesSaved() {
        WebElement saveConfirmationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(saveConfirmation));
        return saveConfirmationElement.isDisplayed();
    }

    public boolean isDashboardCustomized() {
        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
        return dashboardElement.getText().contains(Customized);
    }

    public void attemptAccessDashboard() {
        driver.get(http://example.com/analytics-dashboard);
    }

    public boolean isAccessDenied() {
        WebElement accessDeniedMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accessDeniedMessage));
        return accessDeniedMessageElement.isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return errorMessageElement.isDisplayed();
    }

    public void selectPerformanceMetricsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(performanceMetricsTab)).click();
    }

    public boolean isPerformanceGraphDisplayed() {
        WebElement performanceGraphElement = wait.until(ExpectedConditions.visibilityOfElementLocated(performanceGraph));
        return performanceGraphElement.isDisplayed();
    }

    public boolean isPerformanceMetricsDisplayed() {
        WebElement performanceGraphElement = wait.until(ExpectedConditions.visibilityOfElementLocated(performanceGraph));
        return performanceGraphElement.isDisplayed();
    }

    public boolean isSalesDataFilteredByTime() {
        WebElement salesDataElement = wait.until(ExpectedConditions.visibilityOfElementLocated(salesData));
        return salesDataElement.getText().contains(Filtered by Time);
    }

    public boolean isPerformanceMetricsFilteredByTime() {
        WebElement performanceGraphElement = wait.until(ExpectedConditions.visibilityOfElementLocated(performanceGraph));
        return performanceGraphElement.getText().contains(Filtered by Time);
    }

    public void applyTimePeriodFilter() {
        WebElement timePeriodFilterElement = wait.until(ExpectedConditions.elementToBeClickable(timePeriodFilter));
        timePeriodFilterElement.click();
    }

    public boolean isSalesDataUpdatedForTimePeriod() {
        WebElement salesDataElement = wait.until(ExpectedConditions.visibilityOfElementLocated(salesData));
        return salesDataElement.getText().contains(Time Period Updated);
    }

    public boolean isPerformanceMetricsUpdatedForTimePeriod() {
        WebElement performanceGraphElement = wait.until(ExpectedConditions.visibilityOfElementLocated(performanceGraph));
        return performanceGraphElement.getText().contains(Time Period Updated);
    }

    public void selectExportDataOption() {
        WebElement exportDataOptionElement = wait.until(ExpectedConditions.elementToBeClickable(exportDataOption));
        exportDataOptionElement.click();
    }

    public boolean isSalesDataDownloadableAsCSV() {
        WebElement exportConfirmationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(exportConfirmation));
        return exportConfirmationElement.getText().contains(Sales Data CSV);
    }

    public boolean isPerformanceMetricsDownloadableAsCSV() {
        WebElement exportConfirmationElement = wait.until(ExpectedConditions.visibilityOfElementLocated(exportConfirmation));
        return exportConfirmationElement.getText().contains(Performance Metrics CSV);
    }

    public void setNoSalesDataForTimePeriod() {
        WebElement noDataMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(noDataMessage));
        Assert.assertTrue(noDataMessageElement.getText().contains(No Sales Data));
    }

    public void setNoPerformanceMetricsForTimePeriod() {
        WebElement noDataMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(noDataMessage));
        Assert.assertTrue(noDataMessageElement.getText().contains(No Performance Metrics));
    }

    public boolean isNoDataMessageDisplayed() {
        WebElement noDataMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(noDataMessage));
        return noDataMessageElement.isDisplayed();
    }

    public void ensureOnDashboard() {
        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
        Assert.assertTrue(dashboardElement.isDisplayed(), Not on Analytics Dashboard);
    }
}