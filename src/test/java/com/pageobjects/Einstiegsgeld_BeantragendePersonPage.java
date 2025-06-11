package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import com.framework.cucumber.TestHarness;
import java.util.*;

public class Einstiegsgeld_BeantragendePersonPage extends WebReusableComponents {

    protected TestHarness harness = new TestHarness();
    protected String sheetName = "BeantragendePerson";

    protected By txtDoktorgrade = By.id("doktorgrade");
    protected By txtFamilienname = By.id("familienname");
    protected By txtVornamen = By.id("vornamen");
    protected By txtTag = By.id("tag");
    protected By txtMonat = By.id("monat");
    protected By txtJahr = By.id("jahr");
    protected By txtStrasse = By.id("strasse");
    protected By txtHausnummer = By.id("hausnummer");
    protected By txtPostleitzahl = By.id("postleitzahl");
    protected By txtOrt = By.id("ort");
    protected By txtAdresszusatz = By.id("adresszusatz");
    protected By txtTelefonnummer = By.id("telefonnummer");
    protected By txtEmailAdresse = By.id("emailAdresse");
    protected By txtPostfach = By.id("postfach");
    protected By txtPLZPostfach = By.id("plzPostfach");
    protected By txtOrtPostfach = By.id("ortPostfach");
    protected By txtThirdPersonTelefonnummer = By.id("thirdPersonTelefonnummer");
    protected By txtThirdPersonEmailAdresse = By.id("thirdPersonEmailAdresse");

    public Einstiegsgeld_BeantragendePersonPage() {
        PageFactory.initElements(driver, this);
    }

    public void geburt(String tag, String monat, String jahr) {
        waitUntilElementVisible(txtJahr, 3);
        enterText(txtJahr, harness.getData(sheetName, jahr));
        if (!harness.getData(sheetName, monat).isEmpty()) {
            enterText(txtMonat, harness.getData(sheetName, monat));
        }
        if (!harness.getData(sheetName, tag).isEmpty()) {
            enterText(txtTag, harness.getData(sheetName, tag));
        }
    }

    public Boolean strassenAnschrift(String strasse, String hsnr, String plz, String ort, String adresszusatz) {
        boolean emptyFields = true;
        waitUntilElementVisible(txtStrasse, 3);
        enterText(txtStrasse, harness.getData(sheetName, strasse));
        enterText(txtHausnummer, harness.getData(sheetName, hsnr));
        enterText(txtPostleitzahl, harness.getData(sheetName, plz));
        enterText(txtOrt, harness.getData(sheetName, ort));
        enterText(txtAdresszusatz, harness.getData(sheetName, adresszusatz));

        if (!checkEmpty(harness.getData(sheetName, strasse)) || !checkEmpty(harness.getData(sheetName, hsnr))
                || !checkEmpty(harness.getData(sheetName, plz)) || !checkEmpty(harness.getData(sheetName, ort))
                || !checkEmpty(harness.getData(sheetName, adresszusatz))) {
            emptyFields = false;
        }

        return emptyFields;
    }

    public Boolean anschriftPostfach(String postfach, String plzPostfach, String ortPostfach) {
        boolean emptyFields = true;
        waitUntilElementVisible(txtPostfach, 3);
        enterText(txtPostfach, harness.getData(sheetName, postfach));
        enterText(txtPLZPostfach, harness.getData(sheetName, plzPostfach));
        enterText(txtOrtPostfach, harness.getData(sheetName, ortPostfach));

        if (!checkEmpty(harness.getData(sheetName, postfach)) || !checkEmpty(harness.getData(sheetName, plzPostfach))
                || !checkEmpty(harness.getData(sheetName, ortPostfach))) {
            emptyFields = false;
        }
        return emptyFields;
    }

    public void third_person_kontakt() {
        waitUntilElementVisible(txtThirdPersonTelefonnummer, 3);
        enterText(txtThirdPersonTelefonnummer, harness.getData(sheetName, "ThirdPerson_Telefonnummer"));
        enterText(txtThirdPersonEmailAdresse, harness.getData(sheetName, "ThirdPerson_E_Mail_Adresse"));
    }

    public void name(String familien, String vorname) {
        waitUntilElementVisible(txtFamilienname, 3);
        enterText(txtFamilienname, harness.getData(sheetName, familien));
        enterText(txtVornamen, harness.getData(sheetName, vorname));
    }

    public void bevollmaechtigter(String familienName, String vorname) {
        third_person_name(familienName, vorname);
    }

    public void gerichtlicheBetreuung(String familienName, String vorname, String organisation) {
        third_person_name(familienName, vorname);
        enterText(By.id("organisation"), harness.getData(sheetName, organisation));
    }

    public void sonstige(String familienName, String vorname, String beziehung) {
        third_person_name(familienName, vorname);
        enterText(By.id("beziehung"), harness.getData(sheetName, beziehung));
    }

    public void third_person_name(String familienName, String vorname) {
        waitUntilElementVisible(txtFamilienname, 3);
        enterText(txtFamilienname, harness.getData(sheetName, familienName));
        enterText(txtVornamen, harness.getData(sheetName, vorname));
    }

    public void doktorgrade(String doktorgrade) {
        waitUntilElementVisible(txtDoktorgrade, 3);
        enterText(txtDoktorgrade, harness.getData(sheetName, doktorgrade));
    }

    public boolean checkEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public void third_person_anschrift(String anschrift) {
        selectDropdown(By.id("anschriftDropdown"), harness.getData(sheetName, anschrift));
        if (harness.getData(sheetName, "ThirdPerson_Anschrift").equalsIgnoreCase("außerhalb von Deutschland")) {
            selectDropdown(By.id("stateDropdown"), harness.getData(sheetName, "ThirdPerson_Staat"));
            int n = harness.getIterationCount(sheetName, "ThirdPerson_Anschriftzeilen");
            for (int i = 1; i <= n; i++) {
                if (i > 2) {
                    clickElement(By.id("addAddressLineButton"));
                }
                enterText(By.id("addressLine" + i), harness.getIterationData(sheetName, "ThirdPerson_Anschriftzeilen", i));
            }
        }
    }
}