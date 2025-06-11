package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class GruSi_PersoenlicheVerhaeltnissePage extends WebReusableComponents {

    protected By txtDoktorgrade = By.id("doktorgrade");
    protected By txtSteuerlicheIdentifikationsnummer = By.id("steuerlicheIdentifikationsnummer");
    protected By txtAnschriftZeilen = By.id("anschriftZeilen");
    protected By btnAntragAbbrechen = By.id("antragAbbrechen");
    protected By dropdownStaatsangehoerigkeiten = By.id("staatsangehoerigkeit");
    protected By txtName = By.id("name");
    protected By txtGeburtdaten = By.id("geburtdaten");
    protected By dropdownGeschlecht = By.id("geschlecht");
    protected By dropdownFamilienStand = By.id("familienStand");
    protected By txtKommunikation = By.id("kommunikation");
    protected By txtAnschrift = By.id("anschrift");
    protected By txtBesondereWohnformAnschrift = By.id("besondereWohnformAnschrift");
    protected By txtBesondereWohnformAnschriftAusland = By.id("besondereWohnformAnschriftAusland");
    protected By txtAnschriftInDeutschland = By.id("anschriftInDeutschland");
    protected By txtStaat = By.id("staat");
    protected By txtVerhaeltnisse = By.id("verhaeltnisse");
    protected By txtHaushaltsmitglieder = By.id("haushaltsmitglieder");
    protected By txtHaushaltsmitgliedName = By.id("haushaltsmitgliedName");
    protected By txtHaushaltsmitgliedGeburtsdaten = By.id("haushaltsmitgliedGeburtsdaten");
    protected By dropdownHaushaltsmitgliedGeschlecht = By.id("haushaltsmitgliedGeschlecht");
    protected By dropdownHaushaltsmitgliedFamilienstand = By.id("haushaltsmitgliedFamilienstand");
    protected By dropdownHaushaltsmitgliedStaatsangehoerigkeiten = By.id("haushaltsmitgliedStaatsangehoerigkeiten");
    protected By txtHaushaltsmitgliedUnterbringung = By.id("haushaltsmitgliedUnterbringung");
    protected By txtWeitereHaushaltStaatsangehoerigkeiten = By.id("weitereHaushaltStaatsangehoerigkeiten");
    protected By txtWeitereAntragstellerAnschriftInDeutschland = By.id("weitereAntragstellerAnschriftInDeutschland");
    protected By txtBestellungEinerGesetzlichenBetreuung = By.id("bestellungEinerGesetzlichenBetreuung");
    protected By txtBestellungEinerGesetzlichenBetreeungAnschriftInlandPostal = By.id("bestellungEinerGesetzlichenBetreeungAnschriftInlandPostal");
    protected By txtBestellungEinerGesetzlichenBetreungAnschriftAusland = By.id("bestellungEinerGesetzlichenBetreungAnschriftAusland");
    protected By txtBesondereWohnformAnschriftInland = By.id("besondereWohnformAnschriftInland");
    protected By txtVerpflichtungserklaerung = By.id("verpflichtungserklaerung");
    protected By txtAuslandsaufenthalteInDenKommenden12Monaten = By.id("auslandsaufenthalteInDenKommenden12Monaten");

    public GruSi_PersoenlicheVerhaeltnissePage() {
        PageFactory.initElements(driver, this);
    }

    public void enterDoktorgrade(String doktorgrade) {
        waitUntilElementVisible(txtDoktorgrade, 3);
        enterText(txtDoktorgrade, doktorgrade);
    }

    public void steuerlicheIdentifikationsnummer(String identifikationsnummer) {
        waitUntilElementVisible(txtSteuerlicheIdentifikationsnummer, 3);
        enterText(txtSteuerlicheIdentifikationsnummer, identifikationsnummer);
    }

    public void anschriftZeilen(String anschriftZeilen) {
        waitUntilElementVisible(txtAnschriftZeilen, 3);
        enterText(txtAnschriftZeilen, anschriftZeilen);
    }

    public void antragAbbrechen() {
        waitUntilElementVisible(btnAntragAbbrechen, 3);
        clickElement(btnAntragAbbrechen);
    }

    public void staatsangehoerigkeiten(String staatsangehoerigkeit) {
        waitUntilElementVisible(dropdownStaatsangehoerigkeiten, 3);
        selectByValue(dropdownStaatsangehoerigkeiten, staatsangehoerigkeit);
    }

    public void name(String name) {
        waitUntilElementVisible(txtName, 3);
        enterText(txtName, name);
    }

    public void geburtdaten(String geburtdaten) {
        waitUntilElementVisible(txtGeburtdaten, 3);
        enterText(txtGeburtdaten, geburtdaten);
    }

    public void geschlecht(String geschlecht) {
        waitUntilElementVisible(dropdownGeschlecht, 3);
        selectByValue(dropdownGeschlecht, geschlecht);
    }

    public void familienStand(String familienStand) {
        waitUntilElementVisible(dropdownFamilienStand, 3);
        selectByValue(dropdownFamilienStand, familienStand);
    }

    public void kommunikation(String kommunikation) {
        waitUntilElementVisible(txtKommunikation, 3);
        enterText(txtKommunikation, kommunikation);
    }

    public void anschrift(String anschrift) {
        waitUntilElementVisible(txtAnschrift, 3);
        enterText(txtAnschrift, anschrift);
    }

    public void besondereWohnformAnschrift(String wohnformAnschrift) {
        waitUntilElementVisible(txtBesondereWohnformAnschrift, 3);
        enterText(txtBesondereWohnformAnschrift, wohnformAnschrift);
    }

    public void besondereWohnformAnschriftAusland(String wohnformAnschriftAusland) {
        waitUntilElementVisible(txtBesondereWohnformAnschriftAusland, 3);
        enterText(txtBesondereWohnformAnschriftAusland, wohnformAnschriftAusland);
    }

    public void anschriftInDeutschland(String anschriftInDeutschland) {
        waitUntilElementVisible(txtAnschriftInDeutschland, 3);
        enterText(txtAnschriftInDeutschland, anschriftInDeutschland);
    }

    public void staat(String staat) {
        waitUntilElementVisible(txtStaat, 3);
        enterText(txtStaat, staat);
    }

    public void verhaeltnisse(String verhaeltnisse) {
        waitUntilElementVisible(txtVerhaeltnisse, 3);
        enterText(txtVerhaeltnisse, verhaeltnisse);
    }

    public void haushaltsmitglieder(String haushaltsmitglieder) {
        waitUntilElementVisible(txtHaushaltsmitglieder, 3);
        enterText(txtHaushaltsmitglieder, haushaltsmitglieder);
    }

    public void angabenZumHaushaltsmitgliedName(String name) {
        waitUntilElementVisible(txtHaushaltsmitgliedName, 3);
        enterText(txtHaushaltsmitgliedName, name);
    }

    public void angabenZumHaushaltsmitgliedGeburtsdaten(String geburtsdaten) {
        waitUntilElementVisible(txtHaushaltsmitgliedGeburtsdaten, 3);
        enterText(txtHaushaltsmitgliedGeburtsdaten, geburtsdaten);
    }

    public void angabenZumHaushaltsmitgliedGeschlecht(String geschlecht) {
        waitUntilElementVisible(dropdownHaushaltsmitgliedGeschlecht, 3);
        selectByValue(dropdownHaushaltsmitgliedGeschlecht, geschlecht);
    }

    public void angabenZumHaushaltsmitgliedFamilienstand(String familienstand) {
        waitUntilElementVisible(dropdownHaushaltsmitgliedFamilienstand, 3);
        selectByValue(dropdownHaushaltsmitgliedFamilienstand, familienstand);
    }

    public void angabenZumHaushaltsmitgliedStaatsangehoerigkeiten(String staatsangehoerigkeiten) {
        waitUntilElementVisible(dropdownHaushaltsmitgliedStaatsangehoerigkeiten, 3);
        selectByValue(dropdownHaushaltsmitgliedStaatsangehoerigkeiten, staatsangehoerigkeiten);
    }

    public void angabenZumHaushaltsmitgliedUnterbringung(String unterbringung) {
        waitUntilElementVisible(txtHaushaltsmitgliedUnterbringung, 3);
        enterText(txtHaushaltsmitgliedUnterbringung, unterbringung);
    }

    public void weitereHaushaltStaatsangehoerigkeiten(String staatsangehoerigkeiten) {
        waitUntilElementVisible(txtWeitereHaushaltStaatsangehoerigkeiten, 3);
        enterText(txtWeitereHaushaltStaatsangehoerigkeiten, staatsangehoerigkeiten);
    }

    public void weitereAntragstellerAnschriftInDeutschland(String anschrift) {
        waitUntilElementVisible(txtWeitereAntragstellerAnschriftInDeutschland, 3);
        enterText(txtWeitereAntragstellerAnschriftInDeutschland, anschrift);
    }

    public void bestellungEinerGesetzlichenBetreuung(String betreuung) {
        waitUntilElementVisible(txtBestellungEinerGesetzlichenBetreuung, 3);
        enterText(txtBestellungEinerGesetzlichenBetreuung, betreuung);
    }

    public void bestellungEinerGesetzlichenBetreeungAnschriftInlandPostal(String anschrift) {
        waitUntilElementVisible(txtBestellungEinerGesetzlichenBetreeungAnschriftInlandPostal, 3);
        enterText(txtBestellungEinerGesetzlichenBetreeungAnschriftInlandPostal, anschrift);
    }

    public void bestellungEinerGesetzlichenBetreungAnschriftAusland(String anschrift) {
        waitUntilElementVisible(txtBestellungEinerGesetzlichenBetreungAnschriftAusland, 3);
        enterText(txtBestellungEinerGesetzlichenBetreungAnschriftAusland, anschrift);
    }

    public void besondereWohnformAnschriftInland(String anschrift) {
        waitUntilElementVisible(txtBesondereWohnformAnschriftInland, 3);
        enterText(txtBesondereWohnformAnschriftInland, anschrift);
    }

    public void verpflichtungserklaerung(String erklaerung) {
        waitUntilElementVisible(txtVerpflichtungserklaerung, 3);
        enterText(txtVerpflichtungserklaerung, erklaerung);
    }

    public void auslandsaufenthalteInDenKommenden12Monaten(String aufenthalte) {
        waitUntilElementVisible(txtAuslandsaufenthalteInDenKommenden12Monaten, 3);
        enterText(txtAuslandsaufenthalteInDenKommenden12Monaten, aufenthalte);
    }

    private void waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    private void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    private void selectByValue(By locator, String value) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(value);
    }
}