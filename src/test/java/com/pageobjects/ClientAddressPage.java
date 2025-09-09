package com.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ClientAddressPage {

    public ClientAddressPage() {
        PageFactory.initElements(driver, this);
    }

    private WebDriver driver;

    private By clientAddressField = By.id("clientAddress");
    private By addresseeAddressField = By.id("addresseeAddress");
    private By printLabelButton = By.id("printLabel");
    private By scheduleCourierButton = By.id("scheduleCourier");
    private By confirmationMessage = By.id("confirmationMessage");

    public void navigateToAddressEntryPage() {
        driver.get("http://dummyurl.com/address-entry");
    }

    public void enterClientAddress(String address) {
        driver.findElement(clientAddressField).sendKeys(address);
    }

    public void enterAddresseeAddress(String address) {
        driver.findElement(addresseeAddressField).sendKeys(address);
    }

    public void verifyAddressesAccepted() {
        Assert.assertTrue(driver.findElement(clientAddressField).isDisplayed(), "Client address not accepted.");
        Assert.assertTrue(driver.findElement(addresseeAddressField).isDisplayed(), "Addressee address not accepted.");
    }

    public void verifyBothAddressesEntered() {
        Assert.assertFalse(driver.findElement(clientAddressField).getAttribute("value").isEmpty(), "Client address not entered.");
        Assert.assertFalse(driver.findElement(addresseeAddressField).getAttribute("value").isEmpty(), "Addressee address not entered.");
    }

    public void selectPrintLabelOption() {
        driver.findElement(printLabelButton).click();
    }

    public void verifyLabelGenerated() {
        Assert.assertTrue(driver.findElement(printLabelButton).isDisplayed(), "Label not generated.");
    }

    public void verifyLabelReadyForPrinting() {
        Assert.assertTrue(driver.findElement(printLabelButton).isEnabled(), "Label not ready for printing.");
    }

    public void verifyParcelLabelPrinted() {
        Assert.assertTrue(driver.findElement(printLabelButton).isDisplayed(), "Parcel label not printed.");
    }

    public void selectScheduleCourierOption() {
        driver.findElement(scheduleCourierButton).click();
    }

    public void chooseConvenientTime(String time) {
        // Dummy implementation for selecting time
    }

    public void verifyCourierVisitConfirmed() {
        Assert.assertTrue(driver.findElement(confirmationMessage).isDisplayed(), "Courier visit not confirmed.");
    }

    public void verifyCourierVisitScheduled() {
        Assert.assertTrue(driver.findElement(scheduleCourierButton).isDisplayed(), "Courier visit not scheduled.");
    }

    public void reviewCourierVisitDetails() {
        // Dummy implementation for reviewing details
    }

    public void confirmCourierScheduling() {
        // Dummy implementation for confirming scheduling
    }

    public void verifyConfirmationMessageDisplayed() {
        Assert.assertTrue(driver.findElement(confirmationMessage).isDisplayed(), "Confirmation message not displayed.");
    }

    public void verifyCourierVisitListed() {
        // Dummy implementation for verifying courier visit listing
    }
}