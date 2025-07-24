package com.qt.pshop.pageobjs;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import com.framework.reusable.WebReusableComponents;

public class AlertSystemPage extends WebReusableComponents {

    private By outgoingAlerts = By.id("outgoingAlerts");
    private By alertMessage = By.id("alertMessage");

    public AlertSystemPage() {
        PageFactory.initElements(driver, this);
    }

    public void checkOutgoingAlerts() {
        clickElement(outgoingAlerts);
    }

    public boolean isAlertSentToCustomer(String email) {
        return getTextFromElement(alertMessage).contains(email);
    }

    public boolean verifyCustomerAlert(String expectedMessage) {
        return getTextFromElement(alertMessage).equals(expectedMessage);
    }
}