
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import .time.Duration;

public class DashboardPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By usernameFieldLocator = By.id(username);
    private final By passwordFieldLocator = By.id(password);
    private final By loginButtonLocator = By.id(login_button);
    private final By dashboardElementLocator = By.id(dashboard);
    private final By ordersModuleLinkLocator = By.id(orders_module);

    public DashboardPage(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void login(final String username, final String password) {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFieldLocator));
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
        Assert.assertTrue(isDashboardDisplayed(), Login failed - Dashboard not displayed);
    }

    public boolean isDashboardDisplayed() {
        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardElementLocator));
        return dashboardElement.isDisplayed();
    }

    public void navigateToOrdersModule() {
        WebElement ordersModuleLink = wait.until(ExpectedConditions.visibilityOfElementLocated(ordersModuleLinkLocator));
        ordersModuleLink.click();
        Assert.assertTrue(isOrdersModuleDisplayed(), Navigation to Orders Module failed);
    }

    private boolean isOrdersModuleDisplayed() {
        WebElement ordersModuleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(orders_module_page)));
        return ordersModuleElement.isDisplayed();
    }
}
