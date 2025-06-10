package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import com.framework.components.ApplitoolsOperations;
import java.util.*;

public class WebPage extends WebReusableComponents {

    protected By txtFirstName = By.name("firstname");
    protected By txtLastName = By.name("lastname");
    protected By btnGender = By.id("sex-0");
    protected By txtDate = By.id("datepicker");
    protected By btnExp = By.id("exp-4");
    protected By btnProf = By.id("profession-0");
    protected By btnToolSelenium = By.id("tool-2");
    protected By btnToolUFT = By.id("tool-0");
    protected By btnToolProtractor = By.id("tool-1");
    protected By selectContinents = By.id("continents");
    protected By selectCommand = By.id("selenium_commands");
    protected By btnSubmit = By.id("submit");

    private ApplitoolsOperations appliTools = new ApplitoolsOperations();

    public WebPage() {
        PageFactory.initElements(driver, this);
    }

    public void launchApp(String url) {
        launchUrl(url);
        appliTools.openEyes(driver);
        appliTools.captureContent("");
        Assert.assertTrue(driver.getCurrentUrl().contains(url), "Failed to launch the application.");
    }

    public void enterFistName(String firstname) {
        waitUntilElementVisible(txtFirstName, 3);
        enterText(txtFirstName, firstname);
        Assert.assertEquals(getTextFromElement(txtFirstName), firstname, "First name entry failed.");
    }

    public void enterLastName(String lastname) {
        waitUntilElementVisible(txtLastName, 3);
        enterText(txtLastName, lastname);
        Assert.assertEquals(getTextFromElement(txtLastName), lastname, "Last name entry failed.");
    }

    public void clickGender() {
        scrollToElement(btnGender);
        clickElement(btnGender);
        Assert.assertTrue(isElementSelected(btnGender), "Gender selection failed.");
    }

    public void enterDate(String date) {
        if (date != null && !date.isEmpty()) {
            waitUntilElementVisible(txtDate, 3);
            enterText(txtDate, date);
            Assert.assertEquals(getTextFromElement(txtDate), date, "Date entry failed.");
        } else {
            throw new IllegalArgumentException("Invalid date: " + date);
        }
    }

    public void clickExperience() {
        scrollToElement(btnExp);
        clickElement(btnExp);
        Assert.assertTrue(isElementSelected(btnExp), "Experience selection failed.");
    }

    public void clickProfession() {
        scrollToElement(btnProf);
        clickElement(btnProf);
        Assert.assertTrue(isElementSelected(btnProf), "Profession selection failed.");
    }

    public void clickToolSelenium() {
        scrollToElement(btnToolSelenium);
        clickElement(btnToolSelenium);
        Assert.assertTrue(isElementSelected(btnToolSelenium), "Selenium tool selection failed.");
    }

    public void clickToolUFT() {
        scrollToElement(btnToolUFT);
        clickElement(btnToolUFT);
        Assert.assertTrue(isElementSelected(btnToolUFT), "UFT tool selection failed.");
    }

    public void clickToolProtractor() {
        scrollToElement(btnToolProtractor);
        clickElement(btnToolProtractor);
        Assert.assertTrue(isElementSelected(btnToolProtractor), "Protractor tool selection failed.");
    }

    public void ClickSelectCountry(String value) {
        waitUntilElementVisible(selectContinents, 3);
        selectByValue(selectContinents, value);
        Assert.assertEquals(getSelectedValue(selectContinents), value, "Country selection failed.");
    }

    public void ClickSelectCommand(String value) {
        if (value != null) {
            waitUntilElementVisible(selectCommand, 3);
            selectByValue(selectCommand, value);
            Assert.assertEquals(getSelectedValue(selectCommand), value, "Command selection failed.");
        } else {
            throw new IllegalArgumentException("Error: The value passed is null.");
        }
    }

    public void clickSubmit() {
        waitUntilElementVisible(btnSubmit, 3);
        clickElement(btnSubmit);
        Assert.assertTrue(isElementDisplayed(btnSubmit), "Submit button click failed.");
    }

    private void scrollToElement(By locator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }
}