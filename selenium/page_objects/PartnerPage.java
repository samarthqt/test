
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

    @FindBy(xpath = //a[text()='Find a Partner'])
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
        String expectedTitle = Partners - QASymphony;
        Assert.assertEquals(driver.getTitle(), expectedTitle, Page title does not match);
    }

    public void clickFindPartnerButton() {
        waitUntilElementClickable(findPartnerButton);
        findPartnerButton.click();
        Assert.assertTrue(isTextPresent(Partner Network), Partner Network text is not present);
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName);
        txtUserName.sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword);
        txtPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        waitUntilElementClickable(btnLogin);
        btnLogin.click();
        verifyHomePageRedirection(http://www.qasymphony.com/home);
    }

    private void waitUntilElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void waitUntilElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private boolean isTextPresent(String text) {
        return driver.findElement(By.tagName(body)).getText().contains(text);
    }

    private void verifyHomePageRedirection(String expectedURL) {
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expectedURL, User is not redirected to the homepage);
    }
}
