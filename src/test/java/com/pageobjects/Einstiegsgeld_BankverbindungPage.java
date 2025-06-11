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

public class Einstiegsgeld_BankverbindungPage extends WebReusableComponents {

    protected TestHarness harness = new TestHarness();
    protected String sheetName = "Bankdaten";

    protected By commonDropdown = By.id("commonDropdown");
    protected By commonTextBox = By.id("commonTextBox");

    public Einstiegsgeld_BankverbindungPage() {
        PageFactory.initElements(driver, this);
    }

    public void bankDaten(String auswahlKonto) {
        waitUntilElementVisible(commonDropdown, 3);
        WebElement dropdownElement = driver.findElement(commonDropdown);
        dropdownElement.click();
        WebElement optionElement = dropdownElement.findElement(By.xpath("//option[text()='" + harness.getData(sheetName, auswahlKonto) + "']"));
        optionElement.click();
        Assert.assertTrue(optionElement.isSelected(), "Dropdown selection failed for: " + auswahlKonto);
    }

    public void bankDaten_ein_anderes_Konto(String iban, String bic, String geldInstitut, String vorname, String familienname) {
        enterText(commonTextBox, "IBAN", harness.getData(sheetName, iban));
        enterText(commonTextBox, "BIC", harness.getData(sheetName, bic));
        enterText(commonTextBox, "Name des Geldinstituts", harness.getData(sheetName, geldInstitut));
        enterText(commonTextBox, "Vornamen", harness.getData(sheetName, vorname));
        enterText(commonTextBox, "Familienname", harness.getData(sheetName, familienname));
        verifyTextEntered("IBAN", iban);
        verifyTextEntered("BIC", bic);
        verifyTextEntered("Name des Geldinstituts", geldInstitut);
        verifyTextEntered("Vornamen", vorname);
        verifyTextEntered("Familienname", familienname);
    }

    private void enterText(By locator, String fieldName, String text) {
        waitUntilElementVisible(locator, 3);
        WebElement textBox = driver.findElement(locator);
        textBox.clear();
        textBox.sendKeys(text);
        Assert.assertEquals(textBox.getAttribute("value"), text, "Text entry failed for: " + fieldName);
    }

    private void verifyTextEntered(String fieldName, String expectedText) {
        WebElement textBox = driver.findElement(By.xpath("//input[@name='" + fieldName + "']"));
        String actualText = textBox.getAttribute("value");
        Assert.assertEquals(actualText, expectedText, "Text verification failed for: " + fieldName);
    }

    private void waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}