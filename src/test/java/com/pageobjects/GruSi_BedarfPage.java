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

public class GruSi_BedarfPage extends WebReusableComponents {

    private TestHarness harness = new TestHarness();
    private String sheetName = "Bedarf";

    protected By txtPersonAnzahl = By.id("personAnzahl");
    protected By txtWohnflaeche = By.id("wohnflaeche");
    protected By txtBaujahr = By.id("baujahr");
    protected By txtRaumAnzahl = By.id("raumAnzahl");
    protected By dropdownWohnsituation = By.id("wohnsituation");
    protected By radioWohngemeinschaft = By.id("radio_wohngemeinschaft");
    protected By txtKaltmiete = By.id("kaltmiete");
    protected By txtNebenkosten = By.id("nebenkosten");
    protected By txtGesamtkosten = By.id("gesamtkosten");
    protected By txtPersonZahl = By.id("personZahl");
    protected By txtBruttowarmmiete = By.id("bruttowarmmiete");
    protected By txtGrundmiete = By.id("grundmiete");
    protected By txtZuschlaege = By.id("zuschlaege");
    protected By txtMoeblierung = By.id("moeblierung");
    protected By txtWohnnebenkosten = By.id("wohnnebenkosten");
    protected By txtHaushaltsstrom = By.id("haushaltsstrom");
    protected By txtKommunikation = By.id("kommunikation");
    protected By dropdownZuschlaegenWarm = By.id("zuschlaegenWarm");
    protected By radioZuschlaegenWarmwasser = By.id("radio_zuschlaegenWarmwasser");
    protected By txtHinweisText = By.id("hinweisText");
    protected By dropdownUnterkunftKosten = By.id("unterkunftKosten");
    protected By txtKostenHoehe = By.id("kostenHoehe");
    protected By txtHeizkosten = By.id("heizkosten");
    protected By dropdownEnergieArt = By.id("energieArt");
    protected By dropdownHeizkostenPosten = By.id("heizkostenPosten");
    protected By txtHeizkostenHoehe = By.id("heizkostenHoehe");
    protected By dropdownWarmwasserbereitung = By.id("warmwasserbereitung");
    protected By radioMesseinrichtung = By.id("radio_messeinrichtung");
    protected By dropdownSchwerbehindertenausweises = By.id(".schwerbehindertenausweises");
    protected By txtBeantragDatum = By.id("beantragDatum");

    public GruSi_BedarfPage() {
        PageFactory.initElements(driver, this);
    }

    public void bedarfe_fuer_die_Unterkunft(String personAnzahl, String wohnflaeche, String baujahr, String raumanzahl, String wohnsituation, String wohngemeinschat) {
        enterText(txtPersonAnzahl, harness.getData(sheetName, personAnzahl));
        enterText(txtWohnflaeche, harness.getData(sheetName, wohnflaeche));
        enterText(txtBaujahr, harness.getData(sheetName, baujahr));
        enterText(txtRaumAnzahl, harness.getData(sheetName, raumanzahl));
        selectDropdown(dropdownWohnsituation, harness.getData(sheetName, wohnsituation));
        clickRadioButton(radioWohngemeinschaft, harness.getData(sheetName, wohngemeinschat));
    }

    public void monatliche_Kosten_der_Unterkunft(String kaltmiete, String nebenkosten, String gesamtKosten) {
        enterText(txtKaltmiete, harness.getData(sheetName, kaltmiete));
        enterText(txtNebenkosten, harness.getData(sheetName, nebenkosten));
        enterText(txtGesamtkosten, harness.getData(sheetName, gesamtKosten));
    }

    public void monatliche_Kosten_der_Unterkunft_Besondere_Wohnform(String personZahl, String bruttowarmmiete, String grundmiete, String zuschlaege) {
        enterText(txtPersonZahl, harness.getData(sheetName, personZahl));
        enterText(txtBruttowarmmiete, harness.getData(sheetName, bruttowarmmiete));
        enterText(txtGrundmiete, harness.getData(sheetName, grundmiete));
        enterText(txtZuschlaege, harness.getData(sheetName, zuschlaege));
    }

    public void angaben_der_Zuschlaege(String moeblierung, String wohnnebenkosten, String haushaltsstrom, String kommunikation, String zuschlaegenWarm, String separateMessWarmwasser, String hinweisText) {
        enterText(txtMoeblierung, harness.getData(sheetName, moeblierung));
        enterText(txtWohnnebenkosten, harness.getData(sheetName, wohnnebenkosten));
        enterText(txtHaushaltsstrom, harness.getData(sheetName, haushaltsstrom));
        enterText(txtKommunikation, harness.getData(sheetName, kommunikation));
        selectDropdown(dropdownZuschlaegenWarm, harness.getData(sheetName, zuschlaegenWarm));
        clickRadioButton(radioZuschlaegenWarmwasser, harness.getData(sheetName, separateMessWarmwasser));
        enterText(txtHinweisText, harness.getData(sheetName, hinweisText));
    }

    public void in_Kosten_der_Unterkunft_enthaltene_Posten(String unterkunftKosten, String kostenHoehe) {
        int n = harness.getIterationCount(sheetName, unterkunftKosten);
        for (int i = 1; i <= n; i++) {
            if (i > 1) {
                clickCommonButton_Index("commonButton_Index", "Unterkunftskosten hinzufügen", "last()");
                handlePageLoading();
            }
            selectDropdown(dropdownUnterkunftKosten, harness.getIterationData(sheetName, unterkunftKosten, i));
            enterText(txtKostenHoehe, harness.getIterationData(sheetName, kostenHoehe, i));
        }
    }

    public void bedarfe_fuer_die_Heizung(String heizkosten, String energieArt) {
        enterText(txtHeizkosten, harness.getData(sheetName, heizkosten));
        selectDropdown(dropdownEnergieArt, harness.getData(sheetName, energieArt));
    }

    public void in_Heizkosten_enthaltene_Posten(String heizkostenPosten, String heizkostenHoehe) {
        int n = harness.getIterationCount(sheetName, heizkostenPosten);
        for (int i = 1; i <= n; i++) {
            if (i > 1) {
                clickCommonButton_Index("commonButton_Index", "Heizkosten hinzufügen", "last()");
                handlePageLoading();
            }
            selectDropdown(dropdownHeizkostenPosten, harness.getIterationData(sheetName, heizkostenPosten, i));
            enterText(txtHeizkostenHoehe, harness.getIterationData(sheetName, heizkostenHoehe, i));
        }
    }

    public void in_Heizkosten_enthaltene_Posten_Warmwasserbereitung(String warmwasserbereitung, String messeinrichtung) {
        selectDropdown(dropdownWarmwasserbereitung, harness.getData(sheetName, warmwasserbereitung));
        if (harness.getData(sheetName, warmwasserbereitung).equalsIgnoreCase("dezentral (z.B. „Boiler“)")) {
            clickRadioButton(radioMesseinrichtung, harness.getData(sheetName, messeinrichtung));
        }
    }

    public void mehrbedarf_Schwerbehinderungen_Ausweis(String iteration, String ausweisBeantragung, String beantragungsdatum) {
        selectDropdown(dropdownSchwerbehindertenausweises, harness.getData(sheetName, iteration, ausweisBeantragung));
        if (harness.getData(sheetName, iteration, ausweisBeantragung).equalsIgnoreCase("beantragt")) {
            enterText(txtBeantragDatum, harness.getData(sheetName, iteration, beantragungsdatum));
        }
    }

    private void enterText(By locator, String text) {
        WebElement element = waitUntilElementVisible(locator, 3);
        element.clear();
        element.sendKeys(text);
    }

    private void selectDropdown(By locator, String value) {
        WebElement element = waitUntilElementVisible(locator, 3);
        element.click();
        // Assume selectByValue is implemented elsewhere
        selectByValue(locator, value);
    }

    private void clickRadioButton(By locator, String value) {
        WebElement element = waitUntilElementVisible(locator, 3);
        element.click();
        // Assume clickRadioButtonById is implemented elsewhere
        clickRadioButtonById(locator, value);
    }

    private WebElement waitUntilElementVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void handlePageLoading() {
        // Assume handlePageLoading is implemented elsewhere
    }

    private void clickCommonButton_Index(String buttonType, String buttonName, String index) {
        // Assume clickCommonButton_Index is implemented elsewhere
    }

    private void selectByValue(By locator, String value) {
        // Assume selectByValue is implemented elsewhere
    }

    private void clickRadioButtonById(By locator, String value) {
        // Assume clickRadioButtonById is implemented elsewhere
    }
}