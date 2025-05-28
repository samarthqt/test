
package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PartnerPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(linkText = Find a Partner)
    private WebElement findPartnerButton;

    @FindBy(id = username)
    private WebElement txtUserName;

    @FindBy(id = password)
    private WebElement txtPassword;

    @FindBy(id = loginButton)
    private WebElement btnLogin;

    public PartnerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(http://www.qasymphony.com/partners.html);
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, http://www.qasymphony.com/partners.html, Page did not open correctly.);
    }

    public void clickFindPartner() {
        waitUntilElementClickable(findPartnerButton);
        findPartnerButton.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(partners), Find Partner page did not open.);
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName);
        txtUserName.sendKeys(username);
        Assert.assertEquals(txtUserName.getAttribute(value), username, Username not entered correctly.);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword);
        txtPassword.sendKeys(password);
        Assert.assertEquals(txtPassword.getAttribute(value), password, Password not entered correctly.);
    }

    public void clickLoginButton() {
        waitUntilElementClickable(btnLogin);
        btnLogin.click();
        Assert.assertTrue(driver.getCurrentUrl().contains(homepage), User is not redirected to the homepage.);
    }

    private void waitUntilElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void waitUntilElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
