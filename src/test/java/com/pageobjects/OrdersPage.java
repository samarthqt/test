package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class OrdersPage extends WebReusableComponents {

    protected By ordersList = By.id("ordersList");
    protected By orderLinkTemplate = By.xpath("//a[contains(@href, 'orderId={0}')]");

    public OrdersPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyOrdersModuleDisplayed() {
        Assert.assertTrue(isElementVisible(ordersList), "Orders module is not displayed.");
    }

    public OrderDetailsPage selectOrderById(int orderId) {
        By orderLink = By.xpath(orderLinkTemplate.toString().replace("{0}", String.valueOf(orderId)));
        clickElement(orderLink);
        return new OrderDetailsPage();
    }
}