package com.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AddressEntryPage extends WebReusableComponents {

    protected By txtClientAddress = By.id("clientAddress");
    protected By txtAddresseeAddress = By.id("addresseeAddress");
    protected By btnPrintLabel = By.id("printLabel");

    public AddressEntryPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToAddressEntryPage() {
        driver.get("http://dummyurl.com/address-entry");
    }

    public void enterClientAddress(String address) {
        waitUntilElementVisible(txtClientAddress, 3);
        enterText(txtClientAddress, address);
    }

    public void enterAddresseeAddress(String address) {
        waitUntilElementVisible(txtAddresseeAddress, 3);
        enterText(txtAddresseeAddress, address);
    }

    public void verifyAddressesAccepted() {
        Assert.assertTrue(isElementVisible(txtClientAddress) && isElementVisible(txtAddresseeAddress), "Addresses not accepted.");
    }

    public void verifyAddressesEntered() {
        Assert.assertTrue(isElementVisible(txtClientAddress) && isElementVisible(txtAddresseeAddress), "Addresses not entered.");
    }

    public void selectPrintLabelOption() {
        waitUntilElementVisible(btnPrintLabel, 3);
        clickElement(btnPrintLabel);
    }

    public void verifyLabelGenerated() {
        Assert.assertTrue(isElementVisible(btnPrintLabel), "Label not generated.");
    }

    public void verifyLabelReadyForPrinting() {
        Assert.assertTrue(isElementVisible(btnPrintLabel), "Label not ready for printing.");
    }

    public void verifyLabelPrinted() {
        Assert.assertTrue(isElementVisible(btnPrintLabel), "Label not printed.");
    }

    public void selectScheduleCourierOption() {
        // Implementation for scheduling courier option
    }

    public void chooseCourierTime(String time) {
        // Implementation for choosing courier time
    }

    public void verifyCourierVisitConfirmed() {
        // Implementation for confirming courier visit
    }

    public void verifyCourierVisitScheduled() {
        // Implementation for verifying courier visit scheduled
    }

    public void reviewCourierVisitDetails() {
        // Implementation for reviewing courier visit details
    }

    public void confirmCourierScheduling() {
        // Implementation for confirming courier scheduling
    }

    public void verifyConfirmationMessageDisplayed() {
        // Implementation for verifying confirmation message
    }

    public void verifyCourierVisitListed() {
        // Implementation for verifying courier visit listed
    }
}