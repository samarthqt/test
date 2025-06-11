package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class BuT_AntragstellungPage extends WebReusableComponents {

    protected By txtDoktorgrade = By.id("doktorgrade");
    protected By txtFamiliennameAntragsteller = By.id("FamiliennameAntragsteller");
    protected By txtVornameAntragsteller = By.id("VornameAntragsteller");
    protected By txtGeburtstag = By.id("Geburtstag");
    protected By txtGeburtsmonat = By.id("Geburtsmonat");
    protected By txtGeburtsjahr = By.id("Geburtsjahr");
    protected By txtStrasse = By.id("Strasse");
    protected By txtHausnummer = By.id("Hausnummer");
    protected By txtPostleitzahl = By.id("Postleitzahl");
    protected By txtOrt = By.id("Ort");
    protected By txtAdresszusatz = By.id("Adresszusatz");
    protected By txtTelefonnummer = By.id("Telefonnummer");
    protected By txtEmail = By.id("Email");
    protected By dropdownStaatsangehoerigkeit = By.id("Staatsangehoerigkeit");
    protected By btnStaatsangehoerigkeitHinzufuegen = By.id("Staatsangehörigkeit hinzufügen");
    protected By dropdownLeistungsempfaenger = By.id("Leistungsempfaenger");
    protected By txtFamilienname = By.id("Familienname");
    protected By txtVornamen = By.id("Vornamen");

    public BuT_AntragstellungPage() {
        PageFactory.initElements(driver, this);
    }

    public void printTestcaseDescriptionInReport(String testid, String sn, String col) {
        String description = harness.getData(sn, col);
        Assert.assertNotNull(description, "Test case description is null.");
        addTestLog("Beschreibung", testid + "\n=================================\n\n" + description + "\n=================================\n\n", Status.DONE);
    }

    public void empfaengerDerLeistung(String leistungsEmpfaenger) {
        String value = harness.getData(sheetName, leistungsEmpfaenger);
        Assert.assertNotNull(value, "Leistungsempfaenger value is null.");
        new Select(driver.findElement(dropdownLeistungsempfaenger)).selectByVisibleText(value);
    }

    public void angabenZuAntragstellendenPersonName(String doktorGrade, String familienName, String vorName, String gebTag, String gebMonat, String gebJahr) {
        if (!harness.getData(sheetName, doktorGrade).isEmpty()) {
            doktorgrade(doktorGrade);
        }
        name(familienName, vorName);
        geburtsdatum(gebTag, gebMonat, gebJahr);
    }

    public void doktorgrade(String doktorGrade) {
        String value = harness.getData(sheetName, doktorGrade);
        Assert.assertNotNull(value, "Doktorgrade value is null.");
        driver.findElement(txtDoktorgrade).sendKeys(value);
    }

    public void name(String familienName, String vorName) {
        String famName = harness.getData(sheetName, familienName);
        String vName = harness.getData(sheetName, vorName);
        Assert.assertNotNull(famName, "Familienname value is null.");
        Assert.assertNotNull(vName, "Vorname value is null.");
        driver.findElement(txtFamiliennameAntragsteller).sendKeys(famName);
        driver.findElement(txtVornameAntragsteller).sendKeys(vName);
    }

    public void geburtsdatum(String gebTag, String gebMonat, String gebJahr) {
        String tag = harness.getData(sheetName, gebTag);
        String monat = harness.getData(sheetName, gebMonat);
        String jahr = harness.getData(sheetName, gebJahr);
        Assert.assertNotNull(jahr, "Geburtsjahr value is null.");
        if (!tag.isEmpty()) {
            driver.findElement(txtGeburtstag).sendKeys(tag);
        }
        if (!monat.isEmpty()) {
            driver.findElement(txtGeburtsmonat).sendKeys(monat);
        }
        driver.findElement(txtGeburtsjahr).sendKeys(jahr);
    }

    public void strassenanschrift(String str, String hausnr, String plz, String ort, String adresszusatz) {
        String strasse = harness.getData(sheetName, str);
        String postleitzahl = harness.getData(sheetName, plz);
        String ortValue = harness.getData(sheetName, ort);
        Assert.assertNotNull(strasse, "Strasse value is null.");
        Assert.assertNotNull(postleitzahl, "Postleitzahl value is null.");
        Assert.assertNotNull(ortValue, "Ort value is null.");
        driver.findElement(txtStrasse).sendKeys(strasse);
        if (!harness.getData(sheetName, hausnr).isEmpty()) {
            driver.findElement(txtHausnummer).sendKeys(harness.getData(sheetName, hausnr));
        }
        driver.findElement(txtPostleitzahl).sendKeys(postleitzahl);
        driver.findElement(txtOrt).sendKeys(ortValue);
        if (!harness.getData(sheetName, adresszusatz).isEmpty()) {
            driver.findElement(txtAdresszusatz).sendKeys(harness.getData(sheetName, adresszusatz));
        }
    }

    public void kommunikation(String telefon, String email) {
        String telefonnummer = harness.getData(sheetName, telefon);
        String emailAdresse = harness.getData(sheetName, email);
        Assert.assertNotNull(telefonnummer, "Telefonnummer value is null.");
        Assert.assertNotNull(emailAdresse, "Email value is null.");
        driver.findElement(txtTelefonnummer).sendKeys(telefonnummer);
        driver.findElement(txtEmail).sendKeys(emailAdresse);
    }

    public void staatsangehoerigkeiten(String staatsangehoerigkeiten) {
        String staatsangehoerigkeitenData = harness.getData(sheetName, staatsangehoerigkeiten);
        Assert.assertNotNull(staatsangehoerigkeitenData, "Staatsangehoerigkeiten value is null.");
        List<String> staatsangehoerigkeitenList = Arrays.asList(staatsangehoerigkeitenData.split("@@"));
        if (!staatsangehoerigkeitenList.isEmpty()) {
            new Select(driver.findElement(dropdownStaatsangehoerigkeit)).selectByVisibleText(staatsangehoerigkeitenList.get(0));
            if (staatsangehoerigkeitenList.size() > 1) {
                staatsangehoerigkeitenList.subList(1, staatsangehoerigkeitenList.size()).forEach(this::weitereStaatsangehoerigkeiten);
            }
        }
    }

    public void weitereStaatsangehoerigkeiten(String staatsangehoerigkeiten) {
        driver.findElement(btnStaatsangehoerigkeitHinzufuegen).click();
        new Select(driver.findElement(dropdownStaatsangehoerigkeit)).selectByVisibleText(staatsangehoerigkeiten);
    }

    public void bedarfsermittlingBeziehenVonLeistungen(String leistungen, String leistungenInfo) {
        String leistungenData = harness.getData(sheetName, leistungen);
        String leistungenInfoData = harness.getData(sheetName, leistungenInfo);
        Assert.assertNotNull(leistungenData, "Leistungen value is null.");
        Assert.assertNotNull(leistungenInfoData, "Leistungen Info value is null.");
        // Implement logic for handling Leistungen and Leistungen Info
    }

    public void bevollmaechtigterName(String familienName, String vorName) {
        String famName = harness.getData(sheetName, familienName);
        String vName = harness.getData(sheetName, vorName);
        Assert.assertNotNull(famName, "Familienname value is null.");
        Assert.assertNotNull(vName, "Vorname value is null.");
        driver.findElement(txtFamilienname).sendKeys(famName);
        driver.findElement(txtVornamen).sendKeys(vName);
    }
}