package com.pageobjects;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class DashboardPage extends WebReusableComponents {

    protected By ordersModuleLink = By.id("ordersModule");

    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyDashboardDisplayed() {
        Assert.assertTrue(isElementVisible(ordersModuleLink), "Dashboard is not displayed.");
    }

    public OrdersPage navigateToOrdersModule() {
        clickElement(ordersModuleLink);
        return new OrdersPage();
    }
}