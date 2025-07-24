package com.qt.pshop.pageobjs;
import org.openqa.selenium.By;
import com.framework.reusable.WebReusableComponents;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage extends WebReusableComponents {

    private By ordersModule = By.id("ordersModule");
    private By orderDetails = By.id("orderDetails");
    private By shipmentStatusDropdown = By.id("shipmentStatus");
    private By shippedOption = By.xpath("//option[text()='Shipped']");

    public OrdersPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToOrdersModule() {
        clickElement(ordersModule);
    }

    public boolean isOrdersModuleDisplayed() {
        return isElementVisible(ordersModule, 5);
    }

    public void selectOrderById(String orderId) {
        By order = By.xpath("//tr[td[text()='" + orderId + "']]");
        clickElement(order);
    }

    public boolean isOrderDetailsDisplayed(String orderId) {
        return isElementVisible(orderDetails, 5);
    }

    public void updateShipmentStatusToShipped() {
        selectByVisibleText(shipmentStatusDropdown, "Shipped");
    }

    public boolean isShipmentStatusUpdatedToShipped() {
        return getSelectedOption(shipmentStatusDropdown).equals("Shipped");
    }
}