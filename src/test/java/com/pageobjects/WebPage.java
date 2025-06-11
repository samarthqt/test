package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import com.framework.components.ApplitoolsOperations;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import java.util.*;

public class WebPage extends WebReusableComponents {

    protected By homeLink = By.linkText("Techlistic");
    protected By loginHeader = By.xpath("//*[@class='login_logo']");
    protected By txtUserName = By.name("user-name");
    protected By txtPassword = By.name("password");
    protected By btnLogin = By.xpath("//*[@id='login-button']");
    protected By btnSauceBackPack = By.xpath("//*[@id='item_4_title_link']");
    protected By btnSauceBikeLight = By.xpath("//*[@id='item_0_title_link']");
    protected By btnAddToCart = By.xpath("//*[contains(text(),'Add to cart')]");
    protected By btnCart = By.xpath("//*[@class='shopping_cart_link']");
    protected By btnRemoveCart = By.xpath("//*[contains(text(),'Remove')]");
    protected By btnCheckOut = By.xpath("//*[@id='checkout']");
    protected By btnContinue = By.xpath("//*[@id='continue']");
    protected By btnFinish = By.xpath("//*[@id='finish']");
    protected By btnTopMenu = By.xpath("//*[@id='react-burger-menu-btn']");
    protected By btnLogOut = By.xpath("//*[@id='logout_sidebar_link']");
    protected By btnAllItems = By.xpath("//*[@id='inventory_sidebar_link']");
    protected By btnAcceptCookies = By.id("ez-accept-all");
    protected By lblHeader = By.xpath("//*[@class='app_logo']");
    protected By lblSauceBackPack = By.xpath("//*[contains(text(),'Sauce Labs Backpack')]");
    protected By lblSauceBikeLight = By.xpath("//*[contains(text(),'Sauce Labs Bike Light')]");
    protected By lblLoginErrorMessage = By.xpath("//*[contains(text(),'Epic sadface: Username and password do not match any user in this service')]");
    protected By lblEmptyCart = By.xpath("//*[@class='cart_desc_label']");
    protected By lblConfirmOrder = By.xpath("//*[contains(text(),'Thank you for your order!')]");
    protected By btnOk = By.xpath("//span[@class='cookie-choices-buttons']/a[text()=\"Ok\"]");
    protected By txtFirstName = By.xpath("//input[@id='first-name']");
    protected By txtLastName = By.xpath("//input[@id='last-name']");
    protected By txtZipCode = By.xpath("//input[@id='postal-code']");
    protected By btnGender = By.id("sex-0");
    protected By btnExp = By.id("exp-6");
    protected By btnProf = By.id("profession-0");
    protected By btnToolUFT = By.id("tool-0");
    protected By btnToolProtractor = By.id("tool-1");
    protected By btnToolSelenium = By.id("tool-2");
    protected By selectContinents = By.id("continents");
    protected By btnSubmit = By.id("submit");
    protected By btnCookie = By.xpath("//a[contains(text(),'Got it')]");

    protected ApplitoolsOperations appliTools = new ApplitoolsOperations();

    public WebPage() {
        PageFactory.initElements(driver, this);
    }

    public void launchApp() {
        launchUrl(getAppUrl());
        maximizeWindow();
        appliTools.captureContent("");
    }

    public void verifyLogin() {
        Assert.assertTrue(elementVisible(loginHeader, 10), "Login header is not visible.");
    }

    public void enterUserName(String textValue) {
        enterText(txtUserName, textValue);
    }

    public void enterPassword(String textValue) {
        enterText(txtPassword, textValue);
    }

    public void clickLoginbutton() {
        Assert.assertTrue(elementVisible(btnLogin), "Login button is not visible.");
        clickElement(btnLogin);
    }

    public void clickButton(By buttonName) {
        Assert.assertTrue(elementVisible(buttonName), "Button is not visible.");
        clickElement(buttonName);
    }

    public void clickAcceptCookies() {
        Assert.assertTrue(elementVisible(btnAcceptCookies, 10), "Accept Cookies button is not visible.");
        clickElement(btnAcceptCookies);
    }

    public void verifyHome() {
        Assert.assertTrue(elementVisible(lblHeader, 5), "Home page header is not visible.");
    }

    public void clickOkButton() {
        Assert.assertTrue(elementVisible(btnOk), "OK button is not visible.");
        clickElement(btnOk);
    }

    public void clickSauceBackPackPagelink() {
        Assert.assertTrue(elementVisible(btnSauceBackPack), "Sauce Labs Backpack link is not visible.");
        clickElement(btnSauceBackPack);
    }

    public void verifySauceBackPackPage() {
        Assert.assertTrue(elementVisible(lblSauceBackPack, 5), "Sauce Labs Backpack page is not visible.");
    }

    public void clickAddToCartButton() {
        Assert.assertTrue(elementVisible(btnAddToCart), "Add to Cart button is not visible.");
        clickElement(btnAddToCart);
    }

    public void clickCartButton() {
        Assert.assertTrue(elementVisible(btnCart), "Cart button is not visible.");
        clickElement(btnCart);
    }

    public void verifyCartSauceLabBackPack() {
        Assert.assertTrue(elementVisible(lblSauceBackPack, 5), "Sauce Labs Backpack is not in the cart.");
    }

    public void clickRemovefromCartButton() {
        Assert.assertTrue(elementVisible(btnRemoveCart), "Remove from Cart button is not visible.");
        clickElement(btnRemoveCart);
    }

    public void verifyEmptyCart() {
        Assert.assertTrue(elementVisible(lblEmptyCart, 5), "Cart is not empty.");
    }

    public void enterFistName(String firstname) {
        enterText(txtFirstName, firstname);
    }

    public void enterFirstName(String firstName) {
        enterText(txtFirstName, firstName);
    }

    public void enterLastName(String lastname) {
        enterText(txtLastName, lastname);
    }

    public void enterZipCode(String zipCode) {
        enterText(txtZipCode, zipCode);
    }

    public void clickCheckOutButton() {
        Assert.assertTrue(elementVisible(btnCheckOut), "Checkout button is not visible.");
        clickElement(btnCheckOut);
    }

    public void clickContinueButton() {
        Assert.assertTrue(elementVisible(btnContinue), "Continue button is not visible.");
        clickElement(btnContinue);
    }

    public void clickFinishButton() {
        Assert.assertTrue(elementVisible(btnFinish), "Finish button is not visible.");
        clickElement(btnFinish);
    }

    public void clickTopMenuButton() {
        Assert.assertTrue(elementVisible(btnTopMenu), "Top Menu button is not visible.");
        clickElement(btnTopMenu);
    }

    public void clickLogOutButton() {
        Assert.assertTrue(elementVisible(btnLogOut), "Logout button is not visible.");
        clickElement(btnLogOut);
    }

    public void clickAllItemButton() {
        Assert.assertTrue(elementVisible(btnAllItems), "All Items button is not visible.");
        clickElement(btnAllItems);
    }

    public void clickSauceLabBikeLightButton() {
        Assert.assertTrue(elementVisible(btnSauceBikeLight), "Sauce Labs Bike Light button is not visible.");
        clickElement(btnSauceBikeLight);
    }

    public void verifySauceBikeLightPage() {
        Assert.assertTrue(elementVisible(lblSauceBikeLight, 5), "Sauce Labs Bike Light page is not visible.");
    }

    public void verifyInvalidCredentialsMessage() {
        Assert.assertTrue(elementVisible(lblLoginErrorMessage, 5), "Invalid credentials message is not visible.");
    }

    public void verifyOrderConfirmPage() {
        Assert.assertTrue(elementVisible(lblConfirmOrder, 20), "Order confirmation page is not visible.");
    }

    public void clickGender() {
        clickElement(btnGender);
    }

    public void clickExperience() {
        clickElement(btnExp);
    }

    public void clickProfession() {
        clickElement(btnProf);
    }

    public void clickToolUFT() {
        clickElement(btnToolUFT);
    }

    public void clickToolProtractor() {
        clickElement(btnToolProtractor);
    }

    public void clickToolSelenium() {
        clickElement(btnToolSelenium);
    }

    public void selectCountry(String value) {
        selectByValue(selectContinents, value);
    }

    public void submitDetails() {
        clickElement(btnSubmit);
    }
}