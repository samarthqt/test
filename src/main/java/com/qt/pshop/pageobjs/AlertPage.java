package com.qt.pshop.pageobjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AlertPage {

    private WebDriver driver;
    private WebDriverWait wait;

    protected By outgoingAlerts = By.id("outgoingAlerts");
    protected By alertMessage = By.id("alertMessage");

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    /**
     * Clicks on the outgoing alerts element.
     */
    public void checkOutgoingAlerts() {
        WebElement element = waitUntilElementVisible(outgoingAlerts);
        element.click();
    }

    /**
     * Checks if an alert has been sent to the specified email.
     * 
     * @param email The email to check for.
     * @return True if the alert has been sent, false otherwise.
     */
    public boolean isAlertSent(String email) {
        WebElement element = waitUntilElementVisible(outgoingAlerts);
        boolean isSent = element.getText().contains(email);
        Assert.assertTrue(isSent, "Alert not sent to the specified email.");
        return isSent;
    }

    /**
     * Verifies if the alert message received matches the expected message.
     * 
     * @param expectedMessage The expected alert message.
     * @return True if the alert message matches, false otherwise.
     */
    public boolean verifyAlertReceived(String expectedMessage) {
        WebElement element = waitUntilElementVisible(alertMessage);
        String actualMessage = element.getText();
        boolean isReceived = actualMessage.equals(expectedMessage);
        Assert.assertTrue(isReceived, "Alert message does not match the expected message.");
        return isReceived;
    }

    /**
     * Waits until the specified element is visible.
     * 
     * @param locator The locator of the element to wait for.
     * @return The visible WebElement.
     */
    private WebElement waitUntilElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}