package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import .time.Duration;

public class NewBrowserWindowPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By newWindowButton = By.id(newWindowButton);
    private final By txtUserName = By.id(username);
    private final By txtPassword = By.id(password);
    private final By btnLogin = By.id(loginButton);

    public NewBrowserWindowPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void openNewWindow() {
        WebElement button = waitUntilElementVisible(newWindowButton);
        button.click();
        switchToLatestWindow();
        Assert.assertTrue(isNewWindowOpened(), New window did not open successfully.);
    }

    public void enterUserName(String username) {
        WebElement userNameField = waitUntilElementVisible(txtUserName);
        userNameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordField = waitUntilElementVisible(txtPassword);
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = waitUntilElementVisible(btnLogin);
        loginButton.click();
    }

    public void verifyHomePageRedirection(String expectedURL) {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expectedURL, User is not redirected to the homepage.);
    }

    private WebElement waitUntilElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void switchToLatestWindow() {
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
    }

    private boolean isNewWindowOpened() {
        return driver.getWindowHandles().size() > 1;
    }
}