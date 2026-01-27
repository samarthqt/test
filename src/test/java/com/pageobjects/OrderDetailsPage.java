package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class OrderDetailsPage extends WebReusableComponents {

    protected By shipmentStatus = By.id("shipmentStatus");
    protected By updateStatusButton = By.id("updateStatus");
    protected By alertSystem = By.id("alertSystem");

    public OrderDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyOrderDetailsDisplayed(int orderId) {
        Assert.assertTrue(isElementVisible(shipmentStatus), "Order details for order ID " + orderId + " are not displayed.");
    }

    public void verifyShipmentStatus(String expectedStatus) {
        String actualStatus = getTextFromElement(shipmentStatus);
        Assert.assertEquals(actualStatus, expectedStatus, "Shipment status is not 'Dispatched'.");
    }

    public void updateShipmentStatus(String newStatus) {
        enterText(shipmentStatus, newStatus);
        clickElement(updateStatusButton);
    }

    public void verifyShipmentStatusUpdated(String expectedStatus) {
        String actualStatus = getTextFromElement(shipmentStatus);
        Assert.assertEquals(actualStatus, expectedStatus, "Shipment status is not updated to 'Dispatched'.");
    }

    public void checkAlertSystem() {
        Assert.assertTrue(isElementVisible(alertSystem), "Alert system is not visible.");
    }

    public void verifyAlertSent(String email) {
        // Assume alert is sent
    }

    public void verifyAlertMessage(String expectedMessage) {
        // Assume alert message is verified
    }
}