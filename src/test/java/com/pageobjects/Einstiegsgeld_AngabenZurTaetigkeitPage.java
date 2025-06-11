package com.pageobjects;

import com.framework.cucumber.TestHarness;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.*;

public class Einstiegsgeld_AngabenZurTaetigkeitPage extends MasterPage {

    protected TestHarness harness = new TestHarness();

    protected String sozialversicherungspflichtigSheetName = "Sozialversicherungspflichtig";
    protected static final String sozialversicherungspflichtig_Name_des_Arbeitgebers = "Name des Arbeitgebers";
    protected static final String sozialversicherungspflichtig_Wo_befindet_sich_die_Anschrift = "Wo befindet sich die Anschrift?";
    protected static final String sozialversicherungspflichtig_Staat = "Staat";
    protected static final String sozialversicherungspflichtig_Anschriftzeilen = "Anschriftzeilen";
    protected static final String sozialversicherungspflichtig_Strasse = "Straße";
    protected static final String sozialversicherungspflichtig_Hausnummer = "Hausnummer";
    protected static final String sozialversicherungspflichtig_Hausnummerzusatz = "Hausnummerzusatz";
    protected static final String sozialversicherungspflichtig_Postleitzahl = "Postleitzahl";
    protected static final String sozialversicherungspflichtig_Ort = "Ort";
    protected static final String sozialversicherungspflichtig_Adresszusatz = "Adresszusatz";
    protected static final String sozialversicherungspflichtig_Postfach = "Postfach";
    protected static final String sozialversicherungspflichtig_Postfach_PLZ = "Postfach_PLZ";
    protected static final String sozialversicherungspflichtig_Postfach_Ort = "Postfach_Ort";
    protected static final String sozialversicherungspflichtig_Bezeichnung_der_aufzunehmenden_Taetigkeit_Stelle = "Bezeichnung der aufzunehmenden Tätigkeit/Stelle";
    protected static final String sozialversicherungspflichtig_Beschaeftigungsbeginn = "Beschäftigungsbeginn";
    protected static final String sozialversicherungspflichtig_Handelt_es_sich_um_eine_unbefristete_Beschaeftigung = "Handelt es sich um eine unbefristete Beschäftigung?";
    protected static final String sozialversicherungspflichtig_Beschaeftigungsende = "Beschäftigungsende";
    protected static final String sozialversicherungspflichtig_Monatliches_Bruttoeinkommen = "Monatliches Bruttoeinkommen";
    protected static final String sozialversicherungspflichtig_Stundenlohn = "Stundenlohn";
    protected static final String sozialversicherungspflichtig_Woechentliche_Arbeitszeit_in_Stunden = "Wöchentliche Arbeitszeit in Stunden";

    protected String selbststaendigSheetName = "Selbststaendig";
    protected static final String selbststaendig_Existenzgruendungsvorhaben = "Existenzgründungsvorhaben";
    protected static final String selbststaendig_Taetigkeitsort = "Tätigkeitsort";
    protected static final String selbststaendig_Erwartetes_monatliches_Einkommen = "Erwartetes monatliches Einkommen";
    protected static final String selbststaendig_Haupt_oder_Nebengewerbe = "Haupt oder Nebengewerbe";

    public Einstiegsgeld_AngabenZurTaetigkeitPage() {
        PageFactory.initElements(driver, this);
    }

    public void selbststaendigeTaetigkeit(String existenzGruendungsVorhaben, String taetigkeitsort, String erwartetesMonatlichesEinkommen, String hauptOderNebengewerbe) {
        if (!harness.getData(selbststaendigSheetName, existenzGruendungsVorhaben).isEmpty()) {
            enterTextBoxById("textBoxById", "existenzgruendungsvorhaben", harness.getData(selbststaendigSheetName, existenzGruendungsVorhaben), "last()");
        }
        if (!harness.getData(selbststaendigSheetName, taetigkeitsort).isEmpty()) {
            enterTextBoxById("textBoxById", "taetigkeitsort", harness.getData(selbststaendigSheetName, taetigkeitsort), "last()");
        }
        if (!harness.getData(selbststaendigSheetName, erwartetesMonatlichesEinkommen).isEmpty()) {
            enterTextBoxById("textBoxById", "selbstEinkommen", harness.getData(selbststaendigSheetName, erwartetesMonatlichesEinkommen), "last()");
        }
        if (!harness.getData(selbststaendigSheetName, hauptOderNebengewerbe).isEmpty()) {
            selectCommonDropdown("commonDropdown", "Haupt oder Nebengewerbe", harness.getData(selbststaendigSheetName, hauptOderNebengewerbe));
        }
    }

    public void sozialversicherungspflichtigeBeschaeftigung() {
        enterCommonTextBox("commonTextBox", "Name des Arbeitgebers", harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Name_des_Arbeitgebers));
        if (!harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Wo_befindet_sich_die_Anschrift).isEmpty()) {
            anschrift();
        }
        beschaeftigung();
    }

    public void anschrift() {
        selectCommonDropdown("commonDropdown", "Wo befindet sich die Anschrift?", harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Wo_befindet_sich_die_Anschrift));
        if (harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Wo_befindet_sich_die_Anschrift).equalsIgnoreCase("in Deutschland")) {
            if (strassenAnschrift()) {
                anschriftPostfach();
            }
        }
        if (harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Wo_befindet_sich_die_Anschrift).equalsIgnoreCase("außerhalb von Deutschland")) {
            selectCommonDropdown("commonDropdown", sozialversicherungspflichtig_Staat, harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Staat));
            int n = harness.getIterationCount(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Anschriftzeilen);
            for (int i = 1; i <= n; i++) {
                if (i > 2) {
                    clickCommonButton_Index("commonButton_Index", "Anschriftzeile hinzufügen", "last()");
                    handlePageLoading();
                }
                enterTextBoxById("anschriftzeileById", "arbeitgeberZeilen", harness.getIterationData(sozialversicherungspflichtigSheetName, "Anschriftzeilen", i), String.valueOf(i));
            }
        }
    }

    public Boolean strassenAnschrift() {
        boolean emptyFields = true;
        enterCommonTextBox("commonTextBox", "Straße", harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Strasse));
        enterCommonTextBox("commonTextBox", "Hausnummer", harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Hausnummer));
        handlePageLoading();
        enterCommonTextBox("commonTextBox", "Hausnummerzusatz", harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Hausnummerzusatz));
        handlePageLoading();
        enterCommonTextBox("commonTextBox", "Postleitzahl", harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Postleitzahl));
        handlePageLoading();
        enterCommonTextBox("commonTextBox", "Ort", harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Ort));
        handlePageLoading();
        enterCommonTextBox("commonTextBox", "Adresszusatz", harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Adresszusatz));
        if (!checkEmpty(harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Strasse))) {
            emptyFields = false;
        }
        return emptyFields;
    }

    public Boolean anschriftPostfach() {
        boolean emptyFields = true;
        enterCommonTextBox("commonTextBox", "Postfach", harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Postfach));
        enterCommonTextBox("commonTextBox", "Postleitzahl", harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Postfach_PLZ));
        enterCommonTextBox("commonTextBox", "Ort", harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Postfach_Ort));
        if (!checkEmpty(harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Postfach))) {
            emptyFields = false;
        }
        return emptyFields;
    }

    public void beschaeftigung() {
        enterCommonTextBox("commonTextBox", "Bezeichnung der aufzunehmenden Tätigkeit/Stelle", harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Bezeichnung_der_aufzunehmenden_Taetigkeit_Stelle));
        enterCommonTextBox("commonTextBox", "Beschäftigungsbeginn", harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Beschaeftigungsbeginn));
        selectCommonDropdown("commonDropdown", "Handelt es sich um eine unbefristete Beschäftigung?", harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Handelt_es_sich_um_eine_unbefristete_Beschaeftigung));
        enterCommonTextBox("commonTextBox", "Beschäftigungsende", harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Beschaeftigungsende));
        enterCommonTextBox("commonTextBox", "Monatliches Bruttoeinkommen", harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Monatliches_Bruttoeinkommen));
        enterCommonTextBox("commonTextBox", "Stundenlohn", harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Stundenlohn));
        enterCommonTextBox("commonTextBox", "Wöchentliche Arbeitszeit in Stunden", harness.getData(sozialversicherungspflichtigSheetName, sozialversicherungspflichtig_Woechentliche_Arbeitszeit_in_Stunden));
    }

    public boolean checkEmpty(String data) {
        return data == null || data.trim().isEmpty();
    }
}