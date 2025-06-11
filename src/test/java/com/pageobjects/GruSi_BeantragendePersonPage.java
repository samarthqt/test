package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import com.framework.cucumber.TestHarness;
import com.framework.report.Status;
import java.util.*;

public class GruSi_BeantragendePersonPage extends WebReusableComponents {

    protected TestHarness harness = new TestHarness();
    protected String sheetName = "Angaben zur Antragstellung";

    protected By dropdownBeantragendePerson = By.id("BeantragendePerson");
    protected By txtFamilienname = By.id("BetreuungspersonFamilienname");
    protected By txtVornamen = By.id("BetreuungspersonVornamen");
    protected By txtUnternehmenName = By.id("UnternehmenName");
    protected By txtPersonBeziehung = By.id("PersonBeziehung");
    protected By dropdownAnschrift = By.id("Anschrift");
    protected By txtStrasseDE = By.id("StrasseDE");
    protected By txtHausnummerDE = By.id("HausnummerDE");
    protected By txtPLZ = By.id("PLZ");
    protected By txtOrt = By.id("Ort");
    protected By txtAdresszusatzDE = By.id("AdresszusatzDE");
    protected By txtPostfachDE = By.id("PostfachDE");
    protected By txtPostleitzahlDE = By.id("PostleitzahlDE");
    protected By txtOrtDE = By.id("OrtDE");
    protected By dropdownAuslandStaat = By.id("AuslandStaat");
    protected By btnAnschriftzeileHinzufuegen = By.id("AnschriftzeileHinzufuegen");
    protected By txtAuslandAnschriftzeile = By.id("AuslandAnschriftzeile");
    protected By txtTelefon = By.id("Telefon");
    protected By txtEmail = By.id("Email");
    protected By radioZustimmungCB = By.id("cb");

    public GruSi_BeantragendePersonPage() {
        PageFactory.initElements(driver, this);
    }

    public void selectBeantragendePerson(String beantragendePerson) {
        waitUntilElementVisible(dropdownBeantragendePerson, 3);
        selectByValue(dropdownBeantragendePerson, harness.getData(sheetName, beantragendePerson));
        addTestLog("Selecting beantragende person", "Option = " + harness.getData(sheetName, beantragendePerson), Status.PASS);
    }

    public void namen(String familienname, String vornamen) {
        waitUntilElementVisible(txtFamilienname, 3);
        enterText(txtFamilienname, harness.getData(sheetName, familienname));
        enterText(txtVornamen, harness.getData(sheetName, vornamen));
    }

    public void nameDesUnternehmens(String nameUnternehmen) {
        waitUntilElementVisible(txtUnternehmenName, 3);
        enterText(txtUnternehmenName, harness.getData(sheetName, nameUnternehmen));
    }

    public void beziehungZurAntragstellendenPerson(String beziehung) {
        waitUntilElementVisible(txtPersonBeziehung, 3);
        enterText(txtPersonBeziehung, harness.getData(sheetName, beziehung));
    }

    public void getAnschrift(String anschrift) {
        waitUntilElementVisible(dropdownAnschrift, 3);
        selectByValue(dropdownAnschrift, harness.getData(sheetName, anschrift));
    }

    public void anschriftDeutschlandStrassenanschrift(String str, String hsnr, String plz, String ort, String adresszusatz) {
        waitUntilElementVisible(txtStrasseDE, 3);
        enterText(txtStrasseDE, harness.getData(sheetName, str));
        enterText(txtHausnummerDE, harness.getData(sheetName, hsnr));
        enterText(txtPLZ, harness.getData(sheetName, plz));
        enterText(txtOrt, harness.getData(sheetName, ort));
        if (!harness.getData(sheetName, adresszusatz).isEmpty()) {
            enterText(txtAdresszusatzDE, harness.getData(sheetName, adresszusatz));
        }
    }

    public void anschriftDeutschlandPostfach(String postfach, String plz, String ort) {
        waitUntilElementVisible(txtPostfachDE, 3);
        enterText(txtPostfachDE, harness.getData(sheetName, postfach));
        enterText(txtPostleitzahlDE, harness.getData(sheetName, plz));
        enterText(txtOrtDE, harness.getData(sheetName, ort));
    }

    public void staat(String staat) {
        waitUntilElementVisible(dropdownAuslandStaat, 3);
        selectByValue(dropdownAuslandStaat, harness.getData(sheetName, staat));
    }

    public void anschriftZeilen(String anschriftzeilen) {
        int n = harness.getIterationCount(sheetName, anschriftzeilen);
        for (int i = 1; i <= n; i++) {
            if (i > 2) {
                clickElement(btnAnschriftzeileHinzufuegen);
            }
            enterText(txtAuslandAnschriftzeile, harness.getIterationData(sheetName, anschriftzeilen, i));
        }
    }

    public void kommunikation(String tel, String email) {
        waitUntilElementVisible(txtTelefon, 3);
        enterText(txtTelefon, harness.getData(sheetName, tel));
        enterText(txtEmail, harness.getData(sheetName, email));
    }

    public void hinweis(String zustimmungCB) {
        waitUntilElementVisible(radioZustimmungCB, 3);
        clickElement(radioZustimmungCB);
        Assert.assertTrue(isElementSelected(radioZustimmungCB), "Zustimmung checkbox is not selected.");
    }
}