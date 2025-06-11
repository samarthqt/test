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

public class Miet_EinkundVermoegenPage extends WebReusableComponents {

    protected TestHarness harness = new TestHarness();
    protected String sheetName = "Einkommen und Vermoegen";

    protected By radioButtonById(String id) {
        return By.id(id);
    }

    protected By textBoxById(String id) {
        return By.id(id);
    }

    protected By dropDownById(String id) {
        return By.id(id);
    }

    public Miet_EinkundVermoegenPage() {
        PageFactory.initElements(driver, this);
    }

    public void AngabenzumEinkommen(String iteration, String lohnzahlungen, String selbstaendig, String sgb2, String SGBZwoelf, String kindergeld, String unterhaltsleistungen, String krankengeld, String arbeitslosengeld, String rente, String verpachtung, String kapitalertraegen, String sonstiges) {
        if (!harness.getData(sheetName, iteration, lohnzahlungen).isEmpty()) {
            clickRadioButtonById("lohnzahlungen", harness.getData(sheetName, iteration, lohnzahlungen));
        }
        if (!harness.getData(sheetName, iteration, selbstaendig).isEmpty()) {
            clickRadioButtonById("selbststaendig", harness.getData(sheetName, iteration, selbstaendig));
        }
        if (!harness.getData(sheetName, iteration, sgb2).isEmpty()) {
            clickRadioButtonById("SGBZwei", harness.getData(sheetName, iteration, sgb2));
        }
        if (!harness.getData(sheetName, iteration, SGBZwoelf).isEmpty()) {
            clickRadioButtonById("SGBZwoelf", harness.getData(sheetName, iteration, SGBZwoelf));
        }
        if (!harness.getData(sheetName, iteration, kindergeld).isEmpty()) {
            clickRadioButtonById("kindergeld", harness.getData(sheetName, iteration, kindergeld));
        }
        if (!harness.getData(sheetName, iteration, unterhaltsleistungen).isEmpty()) {
            clickRadioButtonById("unterhaltsleistungen", harness.getData(sheetName, iteration, unterhaltsleistungen));
        }
        if (!harness.getData(sheetName, iteration, krankengeld).isEmpty()) {
            clickRadioButtonById("krankengeld", harness.getData(sheetName, iteration, krankengeld));
        }
        if (!harness.getData(sheetName, iteration, arbeitslosengeld).isEmpty()) {
            clickRadioButtonById("arbeitslosengeld", harness.getData(sheetName, iteration, arbeitslosengeld));
        }
        if (!harness.getData(sheetName, iteration, rente).isEmpty()) {
            clickRadioButtonById("rente", harness.getData(sheetName, iteration, rente));
        }
        if (!harness.getData(sheetName, iteration, verpachtung).isEmpty()) {
            clickRadioButtonById("verpachtung", harness.getData(sheetName, iteration, verpachtung));
        }
        if (!harness.getData(sheetName, iteration, kapitalertraegen).isEmpty()) {
            clickRadioButtonById("kapitalertraegen", harness.getData(sheetName, iteration, kapitalertraegen));
        }
        if (!harness.getData(sheetName, iteration, sonstiges).isEmpty()) {
            enterTextBoxById("sonstigesEinkommen", harness.getData(sheetName, iteration, sonstiges));
        }
    }

    public void AngabenzumVermoegen(String iteration, String bargeld, String bankguthaben, String sparguthaben, String kontoguthaben, String wertpapiere, String schmuck, String sonstigesVermoegen, String altersvorsorge, String kapital, String anzahlKfz, String schenkungOderVerleihung) {
        clickRadioButtonById("bargeld", harness.getData(sheetName, iteration, bargeld));
        if (harness.getData(sheetName, iteration, bargeld).equalsIgnoreCase("Ja")) {
            Bargeld("Bargeldhoehe");
        }
        clickRadioButtonById("bankguthaben", harness.getData(sheetName, iteration, bankguthaben));
        clickRadioButtonById("sparguthaben", harness.getData(sheetName, iteration, sparguthaben));
        clickRadioButtonById("kontoguthaben", harness.getData(sheetName, iteration, kontoguthaben));
        clickRadioButtonById("wertpapiere", harness.getData(sheetName, iteration, wertpapiere));
        clickRadioButtonById("schmuck", harness.getData(sheetName, iteration, schmuck));
        if (harness.getData(sheetName, iteration, schmuck).equalsIgnoreCase("Ja")) {
            SchmuckoderEdelmetalle("Geschätzter Wert des Schmucks oder der Edelmetalle");
        }
        clickRadioButtonById("sonstigesVermoegen", harness.getData(sheetName, iteration, sonstigesVermoegen));
        clickRadioButtonById("altersvorsorge", harness.getData(sheetName, iteration, altersvorsorge));
        if (harness.getData(sheetName, iteration, altersvorsorge).equalsIgnoreCase("Ja")) {
            int n = harness.getIterationCount(iteration, sheetName, "Art der privaten Altersvorsorge");
            for (int i = 1; i <= n; i++) {
                private_altersvorsorge(iteration, i, "Art der privaten Altersvorsorge", "Fällig am");
            }
        }
        clickRadioButtonById("kapital", harness.getData(sheetName, iteration, kapital));
        clickRadioButtonById("anzahlKfz", harness.getData(sheetName, iteration, anzahlKfz));
        if (harness.getData(sheetName, iteration, anzahlKfz).equalsIgnoreCase("Ja")) {
            int n = harness.getIterationCount(iteration, sheetName, "Fahrzeugkennzeichen");
            for (int i = 1; i <= n; i++) {
                Kraftfahrzeuge(iteration, i, "Fahrzeugkennzeichen", "Kilometerstand", "Baujahr", "Modelltyp", "Serientyp");
            }
        }
        clickRadioButtonById("dritten", harness.getData(sheetName, iteration, schenkungOderVerleihung));
        if (harness.getData(sheetName, iteration, schenkungOderVerleihung).equalsIgnoreCase("Ja")) {
            int n = harness.getIterationCount(iteration, sheetName, "Art der Ansprüche");
            for (int i = 1; i <= n; i++) {
                AnspruechegegenueberDritten(iteration, i, "Art der Ansprüche", "Höhe Ansprüche gegenüber Dritten");
            }
        }
    }

    public void private_altersvorsorge(String iteration, int subIteration, String altersvorsorge, String altersvorsorgeDatum) {
        selectDropdownById("altersvorsorgeArt-selectized", harness.getIterationData(iteration, sheetName, altersvorsorge, subIteration));
        enterTextBoxById("altersvorsorgeDatum", harness.getIterationData(iteration, sheetName, altersvorsorgeDatum, subIteration));
    }

    public void AnspruechegegenueberDritten(String iteration, int subIteration, String artderAnsprüche, String hoeheAnsprueche) {
        enterTextBoxById("anspruecheArt", harness.getIterationData(iteration, sheetName, artderAnsprüche, subIteration));
        enterTextBoxById("drittenAnsprueche", harness.getIterationData(iteration, sheetName, hoeheAnsprueche, subIteration));
    }

    public void Kraftfahrzeuge(String iteration, int subIteration, String fahrzeugkennzeichen, String kilometerstand, String baujahr, String modelltyp, String serientyp) {
        enterTextBoxById("fahrzeugkennzeichen", harness.getIterationData(iteration, sheetName, fahrzeugkennzeichen, subIteration));
        enterTextBoxById("kilometerstand", harness.getIterationData(iteration, sheetName, kilometerstand, subIteration));
        enterTextBoxById("baujahr", harness.getIterationData(iteration, sheetName, baujahr, subIteration));
        enterTextBoxById("modelltyp", harness.getIterationData(iteration, sheetName, modelltyp, subIteration));
        enterTextBoxById("serientyp", harness.getIterationData(iteration, sheetName, serientyp, subIteration));
    }

    public void SchmuckoderEdelmetalle(String geschaetzterWert) {
        enterTextBoxById("schmuckWert", harness.getData(sheetName, geschaetzterWert));
    }

    public void Bargeld(String bargeldHoehe) {
        enterTextBoxById("bargeldHoehe", harness.getData(sheetName, bargeldHoehe));
    }

    public void ImmobilienundGrundbesitz(String iteration, String immobilienArt, String grundstuecksflaeche, String gesamtwert) {
        enterTextBoxById("immobilienArt", harness.getData(sheetName, iteration, immobilienArt));
        enterTextBoxById("grundstuecksflaeche", harness.getData(sheetName, iteration, grundstuecksflaeche));
        enterTextBoxById("gesamtwert", harness.getData(sheetName, iteration, gesamtwert));
    }

    private void clickRadioButtonById(String id, String value) {
        WebElement radioButton = driver.findElement(radioButtonById(id));
        waitUntilElementVisible(radioButton, 3);
        radioButton.click();
        Assert.assertTrue(radioButton.isSelected(), "Radio button " + id + " is not selected.");
    }

    private void enterTextBoxById(String id, String value) {
        WebElement textBox = driver.findElement(textBoxById(id));
        waitUntilElementVisible(textBox, 3);
        textBox.clear();
        textBox.sendKeys(value);
        Assert.assertEquals(textBox.getAttribute("value"), value, "Text box " + id + " value is not set correctly.");
    }

    private void selectDropdownById(String id, String value) {
        WebElement dropdown = driver.findElement(dropDownById(id));
        waitUntilElementVisible(dropdown, 3);
        dropdown.sendKeys(value);
        Assert.assertEquals(dropdown.getAttribute("value"), value, "Dropdown " + id + " value is not set correctly.");
    }

    private void waitUntilElementVisible(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}