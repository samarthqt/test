package com.pageobjects;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;

public class GruSi_EinkommenPage extends WebReusableComponents {

    protected By radioButtonById = By.id("radio_rentenerhalt");
    protected By commonButtonById = By.id("btn_rentenangabe_add");
    protected By dropDownById = By.id("Rentenart");
    protected By txtBruttoRente = By.id("bruttoRente");
    protected By txtNettoRente = By.id("nettoRente");
    protected By txtSonstigeRente = By.id("sonstigeRente");

    public GruSi_EinkommenPage() {
        PageFactory.initElements(driver, this);
    }

    public void erhalt_eines_Grundrentenzuschlags(String iteration, String grundrentenzuschlag) {
        if (!harness.getData(sheetName, iteration, grundrentenzuschlag).isEmpty()) {
            clickRadioButtonById("radioButtonById", "radio_grundrentenzuschlag",
                    harness.getData(sheetName, iteration, grundrentenzuschlag), iteration);
        }
    }

    public void antrag_auf_Anerkennung_nach_OEG(String iteration, String antragOEG) {
        if (!harness.getData(sheetName, iteration, antragOEG).isEmpty()) {
            clickRadioButtonById("radioButtonById", "radio_antragOEG",
                    harness.getData(sheetName, iteration, antragOEG), iteration);
        }
    }

    public void leistung_der_Krankenkasse(String iteration, String krankenkasseLeistung) {
        if (!harness.getData(sheetName, iteration, krankenkasseLeistung).isEmpty()) {
            clickRadioButtonById("radioButtonById", "radio_krankenkasseLeistung",
                    harness.getData(sheetName, iteration, krankenkasseLeistung), iteration);
        }
    }

    public void einkommen_aus_einem_Gewerbebetrieb(String iteration, String gewerbeEinkommen) {
        if (!harness.getData(sheetName, iteration, gewerbeEinkommen).isEmpty()) {
            enterText(txtBruttoRente, harness.getData(sheetName, iteration, gewerbeEinkommen));
        }
    }

    public void einkommen_aus_nichtselbststaendiger_Taetigkeit(String iteration, String nichtselbststaendigEinkommen) {
        if (!harness.getData(sheetName, iteration, nichtselbststaendigEinkommen).isEmpty()) {
            enterText(txtNettoRente, harness.getData(sheetName, iteration, nichtselbststaendigEinkommen));
        }
    }

    public void altersvorsorgebeitraege(String iteration, String altersvorsorge) {
        if (!harness.getData(sheetName, iteration, altersvorsorge).isEmpty()) {
            enterText(txtSonstigeRente, harness.getData(sheetName, iteration, altersvorsorge));
        }
    }

    public void erwerbstätigkeit_im_Ausland_Rentenkasse_Ja(String iteration, String rentenkasseAusland) {
        if (!harness.getData(sheetName, iteration, rentenkasseAusland).isEmpty()) {
            clickRadioButtonById("radioButtonById", "radio_rentenkasseAusland",
                    harness.getData(sheetName, iteration, rentenkasseAusland), iteration);
        }
    }

    public void beitraege_fuer_Berufsverbaende_Gewerkschaften_und_Sozialverbaende(String iteration, String beitraege) {
        if (!harness.getData(sheetName, iteration, beitraege).isEmpty()) {
            enterText(txtBruttoRente, harness.getData(sheetName, iteration, beitraege));
        }
    }

    public void erwerbstätigkeit_im_Ausland_Rentenkasse(String iteration, String rentenkasse) {
        if (!harness.getData(sheetName, iteration, rentenkasse).isEmpty()) {
            clickRadioButtonById("radioButtonById", "radio_rentenkasse",
                    harness.getData(sheetName, iteration, rentenkasse), iteration);
        }
    }

    public void sonstige_Einnahmen_aus_Vermietung_und_Verpachtung(String iteration, String vermietungEinnahmen) {
        if (!harness.getData(sheetName, iteration, vermietungEinnahmen).isEmpty()) {
            enterText(txtNettoRente, harness.getData(sheetName, iteration, vermietungEinnahmen));
        }
    }

    public void wohngeld_oder_Lastenzuschuss(String iteration, String wohngeld) {
        if (!harness.getData(sheetName, iteration, wohngeld).isEmpty()) {
            enterText(txtSonstigeRente, harness.getData(sheetName, iteration, wohngeld));
        }
    }

    public void leistungen_der_Arbeitsfoerderung_SGBIII(String iteration, String arbeitsfoerderung) {
        if (!harness.getData(sheetName, iteration, arbeitsfoerderung).isEmpty()) {
            clickRadioButtonById("radioButtonById", "radio_arbeitsfoerderung",
                    harness.getData(sheetName, iteration, arbeitsfoerderung), iteration);
        }
    }

    public void leistung_des_Lastenausgleichsamtes(String iteration, String lastenausgleich) {
        if (!harness.getData(sheetName, iteration, lastenausgleich).isEmpty()) {
            clickRadioButtonById("radioButtonById", "radio_lastenausgleich",
                    harness.getData(sheetName, iteration, lastenausgleich), iteration);
        }
    }

    public void aufwendungen_fuer_Arbeitsmittel(String iteration, String arbeitsmittel) {
        if (!harness.getData(sheetName, iteration, arbeitsmittel).isEmpty()) {
            enterText(txtBruttoRente, harness.getData(sheetName, iteration, arbeitsmittel));
        }
    }

    public void ich_habe_33_oder_mehr_Jahre_an_Grundrentenzeiten(String iteration, String grundrentenzeiten) {
        if (!harness.getData(sheetName, iteration, grundrentenzeiten).isEmpty()) {
            clickRadioButtonById("radioButtonById", "radio_grundrentenzeiten",
                    harness.getData(sheetName, iteration, grundrentenzeiten), iteration);
        }
    }

    public void leistungen_der_Grundsicherung_fuer_Arbeitssuchende_SGBII(String iteration, String grundsicherung) {
        if (!harness.getData(sheetName, iteration, grundsicherung).isEmpty()) {
            clickRadioButtonById("radioButtonById", "radio_grundsicherung",
                    harness.getData(sheetName, iteration, grundsicherung), iteration);
        }
    }

    public void erhalt_von_Unterhaltsleistungen(String iteration, String unterhaltsleistungen) {
        if (!harness.getData(sheetName, iteration, unterhaltsleistungen).isEmpty()) {
            enterText(txtNettoRente, harness.getData(sheetName, iteration, unterhaltsleistungen));
        }
    }

    public void entgelt_Werkstaetten_fuer_behinderte(String iteration, String entgelt) {
        if (!harness.getData(sheetName, iteration, entgelt).isEmpty()) {
            enterText(txtSonstigeRente, harness.getData(sheetName, iteration, entgelt));
        }
    }

    public void einnahmen_aus_Untervermietung(String iteration, String untervermietung) {
        if (!harness.getData(sheetName, iteration, untervermietung).isEmpty()) {
            enterText(txtBruttoRente, harness.getData(sheetName, iteration, untervermietung));
        }
    }

    public void beziehen_Sie_Leistungen_fuer_Ihre_Kinder(String iteration, String kinderLeistungen) {
        if (!harness.getData(sheetName, iteration, kinderLeistungen).isEmpty()) {
            clickRadioButtonById("radioButtonById", "radio_kinderLeistungen",
                    harness.getData(sheetName, iteration, kinderLeistungen), iteration);
        }
    }

    public void renteneinkommen(String iteration, String rentenErhalt, String rentenArt, String bruttoRente, String nettoRente, String sonstigeRente) {
        if (!harness.getData(sheetName, iteration, rentenErhalt).isEmpty()) {
            clickRadioButtonById("radioButtonById", "radio_rentenerhalt",
                    harness.getData(sheetName, iteration, rentenErhalt), iteration);
        }

        if (harness.getData(sheetName, iteration, rentenErhalt).equalsIgnoreCase("Ja")) {
            angaben_zur_Rente_Ja(iteration, rentenArt, bruttoRente, nettoRente, sonstigeRente);
        }
    }

    public void antrag_auf_Anerkennung_nach_OEG_Ja(String iteration, String antragOEG) {
        if (!harness.getData(sheetName, iteration, antragOEG).isEmpty()) {
            clickRadioButtonById("radioButtonById", "radio_antragOEG",
                    harness.getData(sheetName, iteration, antragOEG), iteration);
        }
    }

    public void angaben_zur_Rente_Ja(String iteration, String rentenArt, String bruttoRente, String nettoRente, String sonstigeRente) {
        int n = harness.getIterationCount(iteration, sheetName, rentenArt);
        if (Integer.parseInt(iteration) > 1) {
            handlePageLoading();
            clickButtonById("commonButtonById", "btn_rentenangabe_add", "last()");
            handlePageLoading();
        }
        for (int i = 1; i <= n; i++) {
            if (i > 1) {
                handlePageLoading();
                clickButtonById("commonButtonById", "btn_rentenangabe_add", "last()");
                handlePageLoading();
            }
            String prefixId = String.valueOf(Integer.parseInt(iteration) - 1) + ".GruSi_EinkommenAngabenRente." + String.valueOf(i - 1);

            if (!harness.getIterationData(iteration, sheetName, rentenArt, i).isEmpty()) {
                selectDropdownById("dropDownById", prefixId + ".Rentenart", harness.getIterationData(iteration, sheetName, rentenArt, i), "last()");
                handlePageLoading();
            }
            if (!harness.getIterationData(iteration, sheetName, bruttoRente, i).isEmpty()) {
                enterText(txtBruttoRente, harness.getIterationData(iteration, sheetName, bruttoRente, i));
            }
            if (!harness.getIterationData(iteration, sheetName, nettoRente, i).isEmpty()) {
                enterText(txtNettoRente, harness.getIterationData(iteration, sheetName, nettoRente, i));
            }
            if (!harness.getIterationData(iteration, sheetName, sonstigeRente, i).isEmpty()) {
                enterText(txtSonstigeRente, harness.getIterationData(iteration, sheetName, sonstigeRente, i));
            }
        }
    }

    public void einkommen_aus_Land_und_Forstwirtschaft(String iteration, String forstwirtschaftEinkommen) {
        if (!harness.getData(sheetName, iteration, forstwirtschaftEinkommen).isEmpty()) {
            enterText(txtBruttoRente, harness.getData(sheetName, iteration, forstwirtschaftEinkommen));
        }
    }

    public void kapitalertraeger(String iteration, String kapitalertraege) {
        if (!harness.getData(sheetName, iteration, kapitalertraege).isEmpty()) {
            enterText(txtNettoRente, harness.getData(sheetName, iteration, kapitalertraege));
        }
    }

    public void beitraege_zur_Haftpflichtversicherung(String iteration, String haftpflichtversicherung) {
        if (!harness.getData(sheetName, iteration, haftpflichtversicherung).isEmpty()) {
            enterText(txtSonstigeRente, harness.getData(sheetName, iteration, haftpflichtversicherung));
        }
    }

    public void beantragte_Rente_Ja(String iteration, String beantragteRente) {
        if (!harness.getData(sheetName, iteration, beantragteRente).isEmpty()) {
            clickRadioButtonById("radioButtonById", "radio_beantragteRente",
                    harness.getData(sheetName, iteration, beantragteRente), iteration);
        }
    }

    public void einkommen_aus_sonstige_selbststaendige_Taetigkeit(String iteration, String sonstigeSelbststaendigEinkommen) {
        if (!harness.getData(sheetName, iteration, sonstigeSelbststaendigEinkommen).isEmpty()) {
            enterText(txtBruttoRente, harness.getData(sheetName, iteration, sonstigeSelbststaendigEinkommen));
        }
    }

    public void leistung_nach_Asylbewerberleistungsgesetz(String iteration, String asylLeistung) {
        if (!harness.getData(sheetName, iteration, asylLeistung).isEmpty()) {
            clickRadioButtonById("radioButtonById", "radio_asylLeistung",
                    harness.getData(sheetName, iteration, asylLeistung), iteration);
        }
    }

    public void beitraege_zur_Hausratversicherung(String iteration, String hausratversicherung) {
        if (!harness.getData(sheetName, iteration, hausratversicherung).isEmpty()) {
            enterText(txtNettoRente, harness.getData(sheetName, iteration, hausratversicherung));
        }
    }

    public void erwerbstätigkeit_im_Ausland_ohne_Rentenkasse(String iteration, String auslandOhneRentenkasse) {
        if (!harness.getData(sheetName, iteration, auslandOhneRentenkasse).isEmpty()) {
            clickRadioButtonById("radioButtonById", "radio_auslandOhneRentenkasse",
                    harness.getData(sheetName, iteration, auslandOhneRentenkasse), iteration);
        }
    }

    public void erwerbstätigkeit_im_Ausland_ohne_Rentenkasse_Ja(String iteration, String auslandOhneRentenkasseJa) {
        if (!harness.getData(sheetName, iteration, auslandOhneRentenkasseJa).isEmpty()) {
            clickRadioButtonById("radioButtonById", "radio_auslandOhneRentenkasseJa",
                    harness.getData(sheetName, iteration, auslandOhneRentenkasseJa), iteration);
        }
    }

    public void einnahmen_aus_Untervermietung_Ja(String iteration, String untervermietungJa) {
        if (!harness.getData(sheetName, iteration, untervermietungJa).isEmpty()) {
            clickRadioButtonById("radioButtonById", "radio_untervermietungJa",
                    harness.getData(sheetName, iteration, untervermietungJa), iteration);
        }
    }

    public void leistungen_nach_dem_Bundesversorgungsgesetz(String iteration, String bundesversorgung) {
        if (!harness.getData(sheetName, iteration, bundesversorgung).isEmpty()) {
            clickRadioButtonById("radioButtonById", "radio_bundesversorgung",
                    harness.getData(sheetName, iteration, bundesversorgung), iteration);
        }
    }

    public void fahrkosten(String iteration, String fahrkosten) {
        if (!harness.getData(sheetName, iteration, fahrkosten).isEmpty()) {
            enterText(txtBruttoRente, harness.getData(sheetName, iteration, fahrkosten));
        }
    }

    public void vermoegen_answer_all_with_no(String iteration) {
        clickRadioButtonById("radioButtonById", "radio_vermoegen", "Nein", iteration);
    }

    public void sonstige_Einkuenfte_In_Ausland(String iteration, String einkuenfteAusland) {
        if (!harness.getData(sheetName, iteration, einkuenfteAusland).isEmpty()) {
            enterText(txtNettoRente, harness.getData(sheetName, iteration, einkuenfteAusland));
        }
    }

    public void steuer_auf_das_Einkommen(String iteration, String einkommenSteuer) {
        if (!harness.getData(sheetName, iteration, einkommenSteuer).isEmpty()) {
            enterText(txtSonstigeRente, harness.getData(sheetName, iteration, einkommenSteuer));
        }
    }

    public void beitraege_zu_einer_Sterbegeldversicherung(String iteration, String sterbegeldversicherung) {
        if (!harness.getData(sheetName, iteration, sterbegeldversicherung).isEmpty()) {
            enterText(txtBruttoRente, harness.getData(sheetName, iteration, sterbegeldversicherung));
        }
    }

    public void ausblidungsfoerderung(String iteration, String ausbildungsfoerderung) {
        if (!harness.getData(sheetName, iteration, ausbildungsfoerderung).isEmpty()) {
            enterText(txtNettoRente, harness.getData(sheetName, iteration, ausbildungsfoerderung));
        }
    }

    public void klicke_Angaben_zu_Arbeit_im_Ausland_hinzufuegen(String iteration) {
        clickButtonById("commonButtonById", "btn_arbeitAusland_add", "last()");
    }

    public void Sozialversicherungsbeitraege(String iteration, String sozialversicherungsbeitraege) {
        if (!harness.getData(sheetName, iteration, sozialversicherungsbeitraege).isEmpty()) {
            enterText(txtSonstigeRente, harness.getData(sheetName, iteration, sozialversicherungsbeitraege));
        }
    }

    public void beantragung_einer_Rente(String iteration, String beantragungRente) {
        if (!harness.getData(sheetName, iteration, beantragungRente).isEmpty()) {
            clickRadioButtonById("radioButtonById", "radio_beantragungRente",
                    harness.getData(sheetName, iteration, beantragungRente), iteration);
        }
    }

    public void wird_entsprechendes_Einkommen_an_Kinder_weitergegeben(String iteration, String einkommenWeitergabe) {
        if (!harness.getData(sheetName, iteration, einkommenWeitergabe).isEmpty()) {
            clickRadioButtonById("radioButtonById", "radio_einkommenWeitergabe",
                    harness.getData(sheetName, iteration, einkommenWeitergabe), iteration);
        }
    }

    public void privatrechtliche_geldwerte_Ansprueche(String iteration, String geldwerteAnsprueche) {
        if (!harness.getData(sheetName, iteration, geldwerteAnsprueche).isEmpty()) {
            enterText(txtBruttoRente, harness.getData(sheetName, iteration, geldwerteAnsprueche));
        }
    }
}