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

public class Einstiegsgeld_BedarfsermittlungPage extends WebReusableComponents {

    protected TestHarness harness = new TestHarness();
    protected String sheetName = "Bedarfsermittlung";

    protected By alg1Dropdown = By.id("alg1-selectized");
    protected By ausbildungDropdown = By.id("ausbildung-selectized");
    protected By minijobDropdown = By.id("minijob-selectized");
    protected By gefoerdertesArbeitsDropdown = By.id("gefoerdertes_Arbeits-selectized");
    protected By taetigkeitsbeginnDropdown = By.id("taetigkeitsbeginn-selectized");
    protected By taetigkeitDropdown = By.id("taetigkeit-selectized");

    public Einstiegsgeld_BedarfsermittlungPage() {
        PageFactory.initElements(driver, this);
    }

    public void bedarfe(String arbeitslosengeld, String ausbildung, String minijob, String gefoerdertesArbeitsverhaeltnis, String taetigkeitbegonnen, String sozialversicherungspflichtigeBeschaeftigung) {
        selectDropdownOption(alg1Dropdown, arbeitslosengeld);
        selectDropdownOption(ausbildungDropdown, ausbildung);
        selectDropdownOption(minijobDropdown, minijob);
        selectDropdownOption(gefoerdertesArbeitsDropdown, gefoerdertesArbeitsverhaeltnis);
        selectDropdownOption(taetigkeitsbeginnDropdown, taetigkeitbegonnen);
        selectDropdownOption(taetigkeitDropdown, sozialversicherungspflichtigeBeschaeftigung);
    }

    public void selectDropdownOption(By dropdownLocator, String option) {
        if (!harness.getData(sheetName, option).isEmpty()) {
            waitUntilElementVisible(dropdownLocator, 3);
            WebElement dropdown = driver.findElement(dropdownLocator);
            dropdown.click();
            WebElement optionElement = driver.findElement(By.xpath("//option[text()='" + harness.getData(sheetName, option) + "']"));
            optionElement.click();
            Assert.assertTrue(optionElement.isSelected(), "Option " + option + " is not selected.");
        }
    }

    public void waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}