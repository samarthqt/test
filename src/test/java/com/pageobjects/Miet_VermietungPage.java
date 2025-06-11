package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import com.framework.cucumber.TestHarness;
import java.util.*;

public class Miet_VermietungPage extends WebReusableComponents {

    protected TestHarness harness = new TestHarness();
    protected String sheetName = "Vermietung";

    public Miet_VermietungPage() {
        PageFactory.initElements(driver, this);
    }

    protected By txtEingetragener = By.id("eingetragener");
    protected By txtVermietungFamilienname = By.id("vermietungFamilienname");
    protected By txtVermietungVornamen = By.id("vermietungVornamen");
    protected By dropdownVermietungAnschriftLand = By.id("vermietungAnschriftLand");
    protected By txtVertragsnummer = By.id("vertragsnummer");
    protected By txtVermietungStrasse = By.id("vermietungStrasse");
    protected By txtVermietungHausnr = By.id("vermietungHausnr");
    protected By txtVermietungPLZ = By.id("vermietungPLZ");
    protected By txtVermietungOrt = By.id("vermietungOrt");
    protected By txtVermietungAdresszusatz = By.id("vermietungAdresszusatz");
    protected By txtVermietungPostfach = By.id("vermietungPostfach");
    protected By txtVermietungPostfachPLZ = By.id("vermietungPostfachPLZ");
    protected By txtVermietungPostfachOrt = By.id("vermietungPostfachOrt");
    protected By dropdownVermietungStaat = By.id("vermietungStaat");
    protected By txtAuslandAnschriftzeile1 = By.id("Ausland.0.vermietungAnschriftzeile");
    protected By txtAuslandAnschriftzeile2 = By.id("Ausland.1.vermietungAnschriftzeile");
    protected By txtIban = By.id("iban");
    protected By txtBic = By.id("bic");
    protected By radioVerstanden = By.id("verstanden");
    protected By txtKaltmiete = By.id("kaltmiete");
    protected By txtWarmmiete = By.id("warmmiete");
    protected By txtHeizkosten = By.id("heizkosten");
    protected By txtBetriebskosten = By.id("betriebskosten");
    protected By txtWohnungsgroesse = By.id("wohnungsgroesse");
    protected By txtMietschulden = By.id("mietschulden");
    protected By txtSonstigeKosten = By.id("sonstigeKosten");
    protected By txtSonstigeHoehe = By.id("sonstigeHoehe");

    public void angabenzumvermieter(String eingetragener, String vermietungName, String vermietungVornamen) {
        enterText(txtEingetragener, harness.getData(sheetName, eingetragener));
        enterText(txtVermietungFamilienname, harness.getData(sheetName, vermietungName));
        enterText(txtVermietungVornamen, harness.getData(sheetName, vermietungVornamen));
    }

    public void anschriftAuswahl(String vermietungAnschrift) {
        selectDropdown(dropdownVermietungAnschriftLand, harness.getData(sheetName, vermietungAnschrift));
    }

    public void vertragsnummer(String vertragsnummer) {
        enterText(txtVertragsnummer, harness.getData(sheetName, vertragsnummer));
    }

    public void AnschriftdesVermieterInDeutschland(String vermietungStrasse, String vermietungHausnr, String vermietungPLZ,
                                                   String vermietungOrt, String vermietungAdresszusatz, String vermietungPostfach,
                                                   String vermietungPostfachPLZ, String vermietungPostfachOrt) {
        anschriftDeutschland(vermietungStrasse, vermietungHausnr, vermietungPLZ, vermietungOrt,
                vermietungAdresszusatz, vermietungPostfach, vermietungPostfachPLZ, vermietungPostfachOrt);
    }

    public void AnschriftdesVermieterAusserhalbVonDeutschland(String vermietungStaat, String vermietungAnschriftzeile, String vermietungAnschriftzeile2) {
        anschriftAusserhalbDeutschland(vermietungStaat, vermietungAnschriftzeile, vermietungAnschriftzeile2);
    }

    private void anschriftDeutschland(String vermietungStrasse, String vermietungHausnr, String vermietungPLZ, String vermietungOrt,
                                      String vermietungAdresszusatz, String vermietungPostfach, String vermietungPostfachPLZ, String vermietungPostfachOrt) {
        enterText(txtVermietungStrasse, harness.getData(sheetName, vermietungStrasse));
        enterText(txtVermietungHausnr, harness.getData(sheetName, vermietungHausnr));
        enterText(txtVermietungPLZ, harness.getData(sheetName, vermietungPLZ));
        enterText(txtVermietungOrt, harness.getData(sheetName, vermietungOrt));
        enterText(txtVermietungAdresszusatz, harness.getData(sheetName, vermietungAdresszusatz));
        if (harness.getData(sheetName, vermietungStrasse).isEmpty() && harness.getData(sheetName, vermietungHausnr).isEmpty() &&
                harness.getData(sheetName, vermietungPLZ).isEmpty() && harness.getData(sheetName, vermietungOrt).isEmpty() &&
                harness.getData(sheetName, vermietungAdresszusatz).isEmpty()) {
            enterText(txtVermietungPostfach, harness.getData(sheetName, vermietungPostfach));
            enterText(txtVermietungPostfachPLZ, harness.getData(sheetName, vermietungPostfachPLZ));
            enterText(txtVermietungPostfachOrt, harness.getData(sheetName, vermietungPostfachOrt));
        }
    }

    private void anschriftAusserhalbDeutschland(String vermietungStaat, String vermietungAnschriftzeile, String vermietungAnschriftzeile2) {
        selectDropdown(dropdownVermietungStaat, harness.getData(sheetName, vermietungStaat));
        enterText(txtAuslandAnschriftzeile1, harness.getData(sheetName, vermietungAnschriftzeile));
        enterText(txtAuslandAnschriftzeile2, harness.getData(sheetName, vermietungAnschriftzeile2));
    }

    public void angaben_zu_den_Anschriften(int subIteration, String anschrift, int pos) {
        enterText(By.id("vermietungAnschriftzeile"), harness.getIterationData(sheetName, anschrift, subIteration));
    }

    public void Bankverbindung(String iban, String bic, String verstanden) {
        enterText(txtIban, harness.getData(sheetName, iban));
        if (harness.getData(sheetName, iban).isEmpty()) {
            enterText(txtBic, harness.getData(sheetName, bic));
        }
        clickElement(radioVerstanden);
    }

    public void AngabenzuMietkosten(String kaltmiete, String warmmiete, String heizkosten, String betriebskosten, String wohnungsgroesse) {
        enterText(txtKaltmiete, harness.getData(sheetName, kaltmiete));
        enterText(txtWarmmiete, harness.getData(sheetName, warmmiete));
        enterText(txtHeizkosten, harness.getData(sheetName, heizkosten));
        enterText(txtBetriebskosten, harness.getData(sheetName, betriebskosten));
        enterText(txtWohnungsgroesse, harness.getData(sheetName, wohnungsgroesse));
    }

    public void Mietschulden(String mietschulden, String sonstigeKosten, String hoehesonstigekosten) {
        enterText(txtMietschulden, harness.getData(sheetName, mietschulden));
        enterText(txtSonstigeKosten, harness.getData(sheetName, sonstigeKosten));
        enterText(txtSonstigeHoehe, harness.getData(sheetName, hoehesonstigekosten));
    }

    private void enterText(By locator, String text) {
        waitUntilElementVisible(locator, 3);
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text, "Text not entered correctly.");
    }

    private void selectDropdown(By locator, String value) {
        waitUntilElementVisible(locator, 3);
        WebElement dropdown = driver.findElement(locator);
        dropdown.click();
        dropdown.findElement(By.xpath("//option[text()='" + value + "']")).click();
        Assert.assertEquals(dropdown.getAttribute("value"), value, "Dropdown value not selected correctly.");
    }

    private void clickElement(By locator) {
        waitUntilElementVisible(locator, 3);
        driver.findElement(locator).click();
    }

    private void waitUntilElementVisible(By locator, int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}