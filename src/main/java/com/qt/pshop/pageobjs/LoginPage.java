package com.qt.pshop.pageobjs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class LoginPage extends WebReusableComponents {

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By dashboard = By.id("dashboard");

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        enterText(txtUserName, username);
        enterText(txtPassword, password);
        clickLoginButton();
    }

    public boolean isDashboardDisplayed() {
        waitUntilElementVisible(dashboard);
        boolean isDisplayed = driver.findElement(dashboard).isDisplayed();
        Assert.assertTrue(isDisplayed, "Dashboard is not displayed.");
        return isDisplayed;
    }

    public void enterText(By locator, String text) {
        waitUntilElementVisible(locator);
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin);
        driver.findElement(btnLogin).click();
    }

    public void waitUntilElementVisible(By locator) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}