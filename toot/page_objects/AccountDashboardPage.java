
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import .time.Duration;

public class AccountDashboardPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By dashboardLocator = By.id(dashboard);
    private final By orderDetailsLinkLocator = By.id(order_details_link);

    public AccountDashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isDashboardDisplayed() {
        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardLocator));
        boolean isDisplayed = dashboardElement.isDisplayed();
        Assert.assertTrue(isDisplayed, Dashboard is not displayed);
        return isDisplayed;
    }

    public void clickOrderDetails() {
        WebElement orderDetailsLink = wait.until(ExpectedConditions.elementToBeClickable(orderDetailsLinkLocator));
        orderDetailsLink.click();
        Assert.assertTrue(isOrderDetailsPageDisplayed(), Order details page did not open);
    }

    private boolean isOrderDetailsPageDisplayed() {
        WebElement orderDetailsPageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(order_details_page)));
        return orderDetailsPageElement.isDisplayed();
    }
}