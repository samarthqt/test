package com.qt.pageobjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class AlertPage extends WebReusableComponents {

    private final By outgoingAlerts = By.id("outgoingAlerts");
    private final By alertMessage = By.id("alertMessage");

    public AlertPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks on the outgoing alerts element.
     */
    public void checkOutgoingAlerts() {
        WebElement element = waitUntilElementVisible(outgoingAlerts, 5);
        element.click();
    }

    /**
     * Checks if an alert is sent to the specified email.
     * 
     * @param email the email to check for alert visibility
     * @return true if the alert is visible, false otherwise
     */
    public boolean isAlertSent(String email) {
        By emailLocator = By.id(email);
        WebElement element = waitUntilElementVisible(emailLocator, 5);
        return element.isDisplayed();
    }

    /**
     * Retrieves the alert message for the specified email.
     * 
     * @param email the email to retrieve the alert message for
     * @return the alert message text
     */
    public String getAlertMessage(String email) {
        By emailLocator = By.id(email);
        WebElement element = waitUntilElementVisible(emailLocator, 5);
        String message = element.getText();
        Assert.assertNotNull(message, "Alert message should not be null");
        return message;
    }

    /**
     * Waits until the specified element is visible.
     * 
     * @param locator the locator of the element to wait for
     * @param timeout the timeout in seconds
     * @return the visible WebElement
     */
    private WebElement waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}