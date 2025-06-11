package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import com.framework.cucumber.TestHarness;
import java.util.*;

public class Miet_EinfuehrendeFragenPage extends WebReusableComponents {

    protected TestHarness harness = new TestHarness();
    protected String sheetName = "EinfuehrendeFragen";

    protected By radioButtonObdachlosigkeit = By.id("radioButtonObdachlosigkeit");
    protected By radioButtonWohnsituation = By.id("radioButtonWohnsituation");
    protected By radioButtonUmzug = By.id("radioButtonUmzug");
    protected By dropdownLeistungenBeziehung = By.id("dropdownLeistungenBeziehung");
    protected By radioButtonSgbLeistungen = By.id("radioButtonSgbLeistungen");
    protected By commonButton = By.id("commonButton");

    public Miet_EinfuehrendeFragenPage() {
        PageFactory.initElements(driver, this);
    }

    public void AngabenzumEinfuehrende(String obdachlosigkeit, String aktuelleWohnung, String umzugGeplant) {
        if (!harness.getData(sheetName, obdachlosigkeit).isEmpty()) {
            selectRadioButton(radioButtonObdachlosigkeit, harness.getData(sheetName, obdachlosigkeit));
        }
        selectRadioButton(radioButtonWohnsituation, harness.getData(sheetName, aktuelleWohnung));
        selectRadioButton(radioButtonUmzug, harness.getData(sheetName, umzugGeplant));
    }

    public void BeziehenvonLeistungen(String beziehen) {
        selectDropdown(dropdownLeistungenBeziehung, harness.getData(sheetName, beziehen));
    }

    public void sgbLeistung(String abbrechenOderFortfahren, String trotzdemFortfahren) {
        selectRadioButton(radioButtonSgbLeistungen, harness.getData(sheetName, abbrechenOderFortfahren));
        if (harness.getData(sheetName, abbrechenOderFortfahren).equalsIgnoreCase("Nein")) {
            clickButton(commonButton, harness.getData(sheetName, trotzdemFortfahren));
        }
    }

    private void selectRadioButton(By locator, String value) {
        WebElement element = waitUntilElementVisible(locator, 3);
        element.click();
        Assert.assertTrue(element.isSelected(), "Radio button is not selected.");
    }

    private void selectDropdown(By locator, String value) {
        WebElement element = waitUntilElementVisible(locator, 3);
        selectByValue(element, value);
        Assert.assertEquals(getSelectedValue(element), value, "Dropdown value is not selected correctly.");
    }

    private void clickButton(By locator, String expectedText) {
        WebElement element = waitUntilElementVisible(locator, 3);
        element.click();
        Assert.assertEquals(element.getText(), expectedText, "Button text does not match.");
    }

    private WebElement waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private String getSelectedValue(WebElement element) {
        return element.getAttribute("value");
    }
}