package com.pageobjects;

import com.framework.cucumber.TestHarness;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.*;

public class GruSi_UnterhaltPage extends MasterPage {

    protected TestHarness harness = new TestHarness();
    protected String sheetName = "Unterhalt";

    public GruSi_UnterhaltPage() {
        PageFactory.initElements(driver, this);
    }

    public void angabenZurLeistungsberechtigtenPerson(int antragsteller, String name, String beziehung, String beruf, String jahreseinkommen, String getrennt) {
        String prefixId = String.valueOf(antragsteller - 1);
        if (!harness.getData(sheetName, name).isEmpty()) {
            handlePageLoading();
            enterTextBoxById("textBoxById", prefixId + ".namePerson", harness.getData(sheetName, name), "last()");
        }
        if (!harness.getData(sheetName, beziehung).isEmpty()) {
            selectDropdownById("dropDownById", prefixId + ".beziehungPerson", harness.getData(sheetName, beziehung), "last()");
        }
        if (!harness.getData(sheetName, beruf).isEmpty()) {
            enterTextBoxById("textBoxById", prefixId + ".beruf", harness.getData(sheetName, beruf), "last()");
        }
        if (!harness.getData(sheetName, jahreseinkommen).isEmpty()) {
            clickRadioButtonById("radioButtonById", prefixId + ".jahreseinkommen", harness.getData(sheetName, jahreseinkommen), "last()");
        }
        if (!harness.getData(sheetName, getrennt).isEmpty()) {
            clickRadioButtonById("radioButtonById", prefixId + ".getrennt", harness.getData(sheetName, getrennt), "last()");
            handlePageLoading();
        }
    }

    public void Unterhaltsansprueche(String unterhaltsansprueche, String grund) {
        handlePageLoading();
        if (!harness.getData(sheetName, unterhaltsansprueche).isEmpty()) {
            selectDropdownById("dropDownById", ".unterhaltsansprueche", harness.getData(sheetName, unterhaltsansprueche), "last()");
            handlePageLoading();
            if (harness.getData(sheetName, unterhaltsansprueche).equalsIgnoreCase("Nein, sonstige Gründe")) {
                enterTextBoxById("textBoxById", ".grund", harness.getData(sheetName, grund), "last()");
                handlePageLoading();
            }
        }
    }

    public void AngabenZurBetreffendenPerson_name(String iteration, String familienname, String vornamen) {
        if (Integer.parseInt(iteration) == 1) {
            if (sheetName.contains("(")) {
                int currentPersonIndex = Integer.parseInt(iteration) + numberBetroffene;
                enterTextBoxById("textBoxById", ".familiennameBetroffene", harness.getData(sheetName, iteration, familienname), String.valueOf(currentPersonIndex));
                enterTextBoxById("textBoxById", ".vornamenBetroffene", harness.getData(sheetName, iteration, vornamen), String.valueOf(currentPersonIndex));
            } else {
                enterTextBoxById("textBoxById", ".familiennameBetroffene", harness.getData(sheetName, iteration, familienname), iteration);
                enterTextBoxById("textBoxById", ".vornamenBetroffene", harness.getData(sheetName, iteration, vornamen), iteration);
            }
        } else {
            enterTextBoxById("textBoxById", ".familiennameBetroffene", harness.getData(sheetName, iteration, familienname), "last()");
            enterTextBoxById("textBoxById", ".vornamenBetroffene", harness.getData(sheetName, iteration, vornamen), "last()");
        }
    }

    public void AngabenZurBetreffendenPerson_Anschrift(String iteration, String anschriftsland) {
        selectDropdownById("dropDownById", ".anschriftLandBetroffene", harness.getData(sheetName, iteration, "Wo befindet sich die Anschrift"), "last()");
    }

    public void AngabenZurBetreffendenPerson_anschriftAusserhalbDeutschland(String iteration, String staat, String anschriftzeilen) {
        selectDropdownById("dropDownById", ".staatBetroffene", harness.getData(sheetName, iteration, staat), "last()");
        int n = harness.getIterationCount(iteration, sheetName, anschriftzeilen);
        for (int i = 1; i <= n; i++) {
            if (i > 2) {
                clickCommonButton_Index("commonButton_Index", "Anschriftzeile hinzufügen", "last()");
                handlePageLoading();
            }
            if (i == 1) {
                enterTextBoxById("anschriftzeileById", ".anschriftzeileBetroffene", harness.getIterationData(iteration, sheetName, anschriftzeilen, i), "last()-1");
                handlePageLoading();
            } else {
                enterTextBoxById("anschriftzeileById", ".anschriftzeileBetroffene", harness.getIterationData(iteration, sheetName, anschriftzeilen, i), "last()");
                handlePageLoading();
            }
            handlePageLoading();
        }
    }

    public void AngabenZurBetreffendenPerson_anschriftDeutschland(String iteration, String str, String hsnr, String plz, String ort, String adresszusatz) {
        enterTextBoxById("textBoxById", ".strasseBetroffene", harness.getData(sheetName, iteration, str), "last()");
        handlePageLoading();
        enterTextBoxById("textBoxById", ".hausnrBetroffene", harness.getData(sheetName, iteration, hsnr), "last()");
        handlePageLoading();
        enterTextBoxById("textBoxById", ".plzBetroffene", harness.getData(sheetName, iteration, plz), "last()");
        handlePageLoading();
        enterTextBoxById("textBoxById", ".ortBetroffene", harness.getData(sheetName, iteration, ort), "last()");
        handlePageLoading();
        if (!harness.getData(sheetName, iteration, adresszusatz).isEmpty()) {
            enterTextBoxById("textBoxById", ".adresszusatzBetroffene", harness.getData(sheetName, iteration, adresszusatz), "last()");
        }
    }

    public boolean isData_in_Betroffene_Strassenanschrift(String iteration, String str, String hsnr, String plz, String ort, String adresszusatz) {
        return !(harness.getData(sheetName, iteration, str).isEmpty()
                || harness.getData(sheetName, iteration, hsnr).isEmpty()
                || harness.getData(sheetName, iteration, plz).isEmpty()
                || harness.getData(sheetName, iteration, ort).isEmpty()
                || harness.getData(sheetName, iteration, adresszusatz).isEmpty());
    }

    public void AngabenZurBetreffendenPerson_anschriftDeutschland_Postfach(String iteration, String postfach, String plz, String ort) {
        handlePageLoading();
        enterTextBoxById("textBoxById", ".postfachBetroffene", harness.getData(sheetName, iteration, postfach), "last()");
        handlePageLoading();
        enterTextBoxById("textBoxById", ".postfachPlzBetroffene", harness.getData(sheetName, iteration, plz), "last()");
        handlePageLoading();
        enterTextBoxById("textBoxById", ".postfachOrtBetroffene", harness.getData(sheetName, iteration, ort), "last()");
        handlePageLoading();
    }

    public boolean isData_in_Betroffene_Postanschrift(String iteration, String postfach, String plz, String ort) {
        return !(harness.getData(sheetName, iteration, postfach).isEmpty()
                || harness.getData(sheetName, iteration, plz).isEmpty()
                || harness.getData(sheetName, iteration, ort).isEmpty());
    }

    public void AngabenZurBetreffendenPerson_Geburtsdaten(String iteration, String geburtstag, String geburtsmonat, String geburtsjahr, String geburtsort, String staatDerGeburt) {
        enterTextBoxById("textBoxById", ".geburtstagBetroffene", harness.getData(sheetName, iteration, geburtstag), "last()");
        handlePageLoading();
        enterTextBoxById("textBoxById", ".geburtsmonatBetroffene", harness.getData(sheetName, iteration, geburtsmonat), "last()");
        handlePageLoading();
        enterTextBoxById("textBoxById", ".geburtsjahrBetroffene", harness.getData(sheetName, iteration, geburtsjahr), "last()");
        handlePageLoading();
        enterTextBoxById("textBoxById", ".geburtsortBetroffene", harness.getData(sheetName, iteration, geburtsort), "last()");
        handlePageLoading();
        selectDropdownById("dropDownById", ".staatDerGeburtBetroffene", harness.getData(sheetName, iteration, staatDerGeburt), "last()");
        handlePageLoading();
    }

    public void AngabenZurBetreffendenPerson_Telefonnummer(String iteration, String telefonnummer) {
        enterTextBoxById("textBoxById", ".telefonnummerBetroffene", harness.getData(sheetName, iteration, telefonnummer), "last()");
        handlePageLoading();
    }

    public void AngabenZurBetreffendenPerson_jahresbruttoEinkommen(String iteration, String bruttoeinkommen) {
        enterTextBoxById("textBoxById", ".bruttoeinkommenBetroffene", harness.getData(sheetName, iteration, bruttoeinkommen), "last()");
        handlePageLoading();
    }
}