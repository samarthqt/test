package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import .io.File;
import .io.IOException;
import .time.Duration;
import .util.List;

public class ManageShippingAddressesPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public ManageShippingAddressesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToManageShippingAddresses() {
        driver.get(http://example.com/manage-shipping-addresses);
        Assert.assertTrue(driver.getTitle().contains(Manage Shipping Addresses), Navigation to Manage Shipping Addresses failed);
    }

    public void clickAddNewAddress() {
        WebElement addNewAddressButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(add_new_address)));
        addNewAddressButton.click();
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(address_form))).isDisplayed(), Add New Address form not displayed);
    }

    public void enterShippingAddress(String street, String city, String state, String zip) {
        WebElement streetField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(street)));
        streetField.clear();
        streetField.sendKeys(street);

        WebElement cityField = driver.findElement(By.id(city));
        cityField.clear();
        cityField.sendKeys(city);

        WebElement stateField = driver.findElement(By.id(state));
        stateField.clear();
        stateField.sendKeys(state);

        WebElement zipField = driver.findElement(By.id(zip));
        zipField.clear();
        zipField.sendKeys(zip);

        Assert.assertTrue(streetField.getAttribute(value).equals(street), Street not entered correctly);
        Assert.assertTrue(cityField.getAttribute(value).equals(city), City not entered correctly);
        Assert.assertTrue(stateField.getAttribute(value).equals(state), State not entered correctly);
        Assert.assertTrue(zipField.getAttribute(value).equals(zip), Zip not entered correctly);
    }

    public void saveAddress() {
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(save_address)));
        saveButton.click();
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(success_message))).isDisplayed(), Address not saved successfully);
    }

    public boolean isAddressInList(String address) {
        List<WebElement> addresses = driver.findElements(By.cssSelector(.address-list .address-item));
        for (WebElement addr : addresses) {
            if (addr.getText().contains(address)) {
                return true;
            }
        }
        return false;
    }

    public void ensureAddressStored(String address) {
        if (!isAddressInList(address)) {
            enterShippingAddress(address, City, State, 12345);
            saveAddress();
        }
        Assert.assertTrue(isAddressInList(address), Address not stored);
    }

    public void ensureMultipleAddressesStored() {
        ensureAddressStored(123 Main St);
        ensureAddressStored(456 Elm St);
    }

    public void proceedToCheckout() {
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(checkout)));
        checkoutButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(checkout), Proceed to checkout failed);
    }

    public void selectShippingAddress(String address) {
        WebElement addressDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(address_dropdown)));
        Select select = new Select(addressDropdown);
        select.selectByVisibleText(address);
        Assert.assertTrue(select.getFirstSelectedOption().getText().equals(address), Address not selected correctly);
    }

    public boolean isAddressUsedForOrder(String address) {
        WebElement orderAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(order_address)));
        return orderAddress.getText().contains(address);
    }

    public void selectAddressToEdit(String address) {
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(//div[text()=' + address + ']/following-sibling::button[@class='edit'])));
        editButton.click();
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(edit_form))).isDisplayed(), Edit form not displayed);
    }

    public void updateAddressDetails(String street, String city, String state, String zip) {
        enterShippingAddress(street, city, state, zip);
        saveAddress();
    }

    public void selectAddressToDelete(String address) {
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(//div[text()=' + address + ']/following-sibling::button[@class='delete'])));
        deleteButton.click();
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(confirm_delete))).isDisplayed(), Delete confirmation not displayed);
    }

    public void confirmDeletion() {
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(confirm_delete)));
        confirmButton.click();
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(delete_success_message))).isDisplayed(), Deletion not confirmed);
    }

    public boolean areRemainingAddressesVisible() {
        List<WebElement> addresses = driver.findElements(By.cssSelector(.address-list .address-item));
        return !addresses.isEmpty();
    }

    public boolean isErrorMessageDisplayed() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(error_message)));
        return errorMessage.isDisplayed();
    }

    public void takeScreenshot(String fileName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(./screenshots/ + fileName));
    }
}