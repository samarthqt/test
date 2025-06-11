package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class LZA_Page extends WebReusableComponents {

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By addressBookLink = By.id("addressBook");
    protected By addAddressButton = By.id("addAddress");
    protected By txtAddressLine1 = By.id("addressLine1");
    protected By txtCity = By.id("city");
    protected By txtState = By.id("state");
    protected By txtPostalCode = By.id("postalCode");
    protected By txtCountry = By.id("country");
    protected By saveAddressButton = By.id("saveAddress");
    protected By addressEntries = By.cssSelector(".address-entry");
    protected By removeAddressButton(String addressLine1) {
        return By.xpath("//div[contains(text(), '" + addressLine1 + "')]/following-sibling::button[@class='remove']");
    }

    public LZA_Page() {
        PageFactory.initElements(driver, this);
    }

    public void enterUserName(String username) {
        waitUntilElementVisible(txtUserName, 3);
        enterText(txtUserName, username);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(txtPassword, 3);
        enterText(txtPassword, password);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(btnLogin, 3);
        clickElement(btnLogin);
    }

    public void verifyHomePageRedirection(String expectedURL) {
        String currentURL = getCurrentURL();
        Assert.assertEquals(currentURL, expectedURL, "User is not redirected to the homepage.");
    }

    public void navigateToAddressBook() {
        waitUntilElementVisible(addressBookLink, 3);
        clickElement(addressBookLink);
    }

    public void addNewAddress(String addressLine1, String city, String state, String postalCode, String country) {
        waitUntilElementVisible(addAddressButton, 3);
        clickElement(addAddressButton);
        enterText(txtAddressLine1, addressLine1);
        enterText(txtCity, city);
        enterText(txtState, state);
        enterText(txtPostalCode, postalCode);
        enterText(txtCountry, country);
        clickElement(saveAddressButton);
    }

    public void verifyAddressSaved() {
        waitUntilElementVisible(addressEntries, 3);
        List<WebElement> addresses = getWebElementList(addressEntries);
        Assert.assertFalse(addresses.isEmpty(), "No addresses found in the address book.");
    }

    public void removeAddress(String addressLine1) {
        By removeButton = removeAddressButton(addressLine1);
        waitUntilElementVisible(removeButton, 3);
        clickElement(removeButton);
    }

    public void verifyAddressRemoved(String addressLine1) {
        By addressLocator = removeAddressButton(addressLine1);
        boolean isAddressPresent = elementVisible(addressLocator);
        Assert.assertFalse(isAddressPresent, "Address was not removed from the address book.");
    }

    public void geplante_entlohnung_bindung_vorgesehenes_gehalt(String salary) {
        // Implementation for planned salary binding
        enterText(By.id("salary"), salary);
        Assert.assertTrue(elementVisible(By.id("salaryConfirmation")), "Salary confirmation not visible.");
    }

    public void einzustellende_person_strassenanschrift(String str, String hsnr, String plz, String ort, String adresszusatz) {
        enterText(By.id("strasse"), str);
        enterText(By.id("hausnummer"), hsnr);
        enterText(By.id("plz"), plz);
        enterText(By.id("ort"), ort);
        enterText(By.id("adresszusatz"), adresszusatz);
        Assert.assertTrue(elementVisible(By.id("addressConfirmation")), "Address confirmation not visible.");
    }

    public void geplantes_arbeitsverhaeltnis_unbefristetes_Beschaeftigungsverhältnis() {
        // Implementation for planned employment relationship
        clickElement(By.id("unbefristet"));
        Assert.assertTrue(elementVisible(By.id("employmentConfirmation")), "Employment confirmation not visible.");
    }

    public void einzustellende_person_kommunikation(String tel, String mail) {
        enterText(By.id("telefon"), tel);
        enterText(By.id("mail"), mail);
        Assert.assertTrue(elementVisible(By.id("communicationConfirmation")), "Communication confirmation not visible.");
    }

    public void geplantes_arbeitsverhaeltnis_arbeitsvertrag_geschlossen() {
        // Implementation for planned employment contract
        clickElement(By.id("vertragGeschlossen"));
        Assert.assertTrue(elementVisible(By.id("contractConfirmation")), "Contract confirmation not visible.");
    }

    public void weiteres_zum_Arbeitsverhaeltnisbeziehung_vorherige_beschäftigung_im_betrieb() {
        // Implementation for previous employment in the company
        clickElement(By.id("previousEmployment"));
        Assert.assertTrue(elementVisible(By.id("previousEmploymentConfirmation")), "Previous employment confirmation not visible.");
    }

    public void arbeitgeber_strassenanschrift(String str, String hsnr, String plz, String ort, String adresszusatz) {
        enterText(By.id("arbeitgeberStrasse"), str);
        enterText(By.id("arbeitgeberHausnummer"), hsnr);
        enterText(By.id("arbeitgeberPLZ"), plz);
        enterText(By.id("arbeitgeberOrt"), ort);
        enterText(By.id("arbeitgeberAdresszusatz"), adresszusatz);
        Assert.assertTrue(elementVisible(By.id("employerAddressConfirmation")), "Employer address confirmation not visible.");
    }

    public void arbeitgeber_postfachanschrift(String postfach, String plz, String ort) {
        enterText(By.id("arbeitgeberPostfach"), postfach);
        enterText(By.id("arbeitgeberPostPLZ"), plz);
        enterText(By.id("arbeitgeberPostOrt"), ort);
        Assert.assertTrue(elementVisible(By.id("employerPostAddressConfirmation")), "Employer post address confirmation not visible.");
    }

    public void uploadFile_Nachweise(String filePath) {
        // Implementation for file upload
        uploadFile(By.id("nachweiseUpload"), filePath);
        Assert.assertTrue(elementVisible(By.id("uploadConfirmation")), "Upload confirmation not visible.");
    }

    public void geplantes_arbeitsverhaeltnis_zyklus_der_Arbeitszeit(String cycle) {
        // Implementation for work cycle
        selectDropdown(By.id("arbeitszeitZyklus"), cycle);
        Assert.assertTrue(elementVisible(By.id("workCycleConfirmation")), "Work cycle confirmation not visible.");
    }

    public void weiteres_zum_Arbeitsverhaeltnisbeziehung_einzustellende_person_wird_gesellschafter() {
        // Implementation for shareholder status
        clickElement(By.id("gesellschafter"));
        Assert.assertTrue(elementVisible(By.id("shareholderConfirmation")), "Shareholder confirmation not visible.");
    }

    public void arbeitgeber_name(String arbeitgeberName, String betriebsnummer) {
        enterText(By.id("arbeitgeberName"), arbeitgeberName);
        enterText(By.id("betriebsnummer"), betriebsnummer);
        Assert.assertTrue(elementVisible(By.id("employerNameConfirmation")), "Employer name confirmation not visible.");
    }

    public void einzustellende_person_geburtsdatum(String tag, String monat, String jahr) {
        enterText(By.id("geburtsdatumTag"), tag);
        enterText(By.id("geburtsdatumMonat"), monat);
        enterText(By.id("geburtsdatumJahr"), jahr);
        Assert.assertTrue(elementVisible(By.id("birthDateConfirmation")), "Birth date confirmation not visible.");
    }

    public void geplante_taetigkeit(String activity) {
        // Implementation for planned activity
        enterText(By.id("taetigkeit"), activity);
        Assert.assertTrue(elementVisible(By.id("activityConfirmation")), "Activity confirmation not visible.");
    }

    public void arbeitgeber_auslandsanschrift(String staat, String anschriftzeilen) {
        selectDropdown(By.id("arbeitgeberStaat"), staat);
        enterText(By.id("anschriftzeilen"), anschriftzeilen);
        Assert.assertTrue(elementVisible(By.id("foreignAddressConfirmation")), "Foreign address confirmation not visible.");
    }

    public void print_testcase_description_in_Report(String testid, String sn, String col) {
        String description = harness.getData(sn, col);
        addTestLog("Beschreibung", testid + "\n=================================\n\n" + description + "\n=================================\n\n", Status.DONE);
        Assert.assertTrue(description != null && !description.isEmpty(), "Test case description is empty.");
    }

    public void geplante_entlohnung_bindung_an_einem_tarifvertrag(String contract) {
        // Implementation for tariff contract binding
        selectDropdown(By.id("tarifvertrag"), contract);
        Assert.assertTrue(elementVisible(By.id("contractBindingConfirmation")), "Contract binding confirmation not visible.");
    }

    public void weiteres_zum_Arbeitsverhaeltnisbeziehung_erfolgte_entlassungen() {
        // Implementation for previous dismissals
        clickElement(By.id("entlassungen"));
        Assert.assertTrue(elementVisible(By.id("dismissalsConfirmation")), "Dismissals confirmation not visible.");
    }

    public void arbeitgeber_ansprechperson_erreichbarkeit(String anrede, String familienname, String vornamen, String funktion, String telefonnummer, String email) {
        selectDropdown(By.id("ansprechpersonAnrede"), anrede);
        enterText(By.id("ansprechpersonFamilienname"), familienname);
        enterText(By.id("ansprechpersonVornamen"), vornamen);
        enterText(By.id("funktion"), funktion);
        enterText(By.id("telefonnummer"), telefonnummer);
        enterText(By.id("email"), email);
        Assert.assertTrue(elementVisible(By.id("contactPersonConfirmation")), "Contact person confirmation not visible.");
    }

    public void angaben_zur_bankverbindung(String bankName, String iban, String bic) {
        enterText(By.id("bankName"), bankName);
        enterText(By.id("iban"), iban);
        enterText(By.id("bic"), bic);
        Assert.assertTrue(elementVisible(By.id("bankDetailsConfirmation")), "Bank details confirmation not visible.");
    }

    public void arbeitgeber_anschriftsland(String anschriftLand) {
        selectDropdown(By.id("anschriftLand"), anschriftLand);
        Assert.assertTrue(elementVisible(By.id("addressCountryConfirmation")), "Address country confirmation not visible.");
    }

    public void einzustellende_person_namen(String doktorgrade, String familienname, String vornamen) {
        enterText(By.id("doktorgrade"), doktorgrade);
        enterText(By.id("familienname"), familienname);
        enterText(By.id("vornamen"), vornamen);
        Assert.assertTrue(elementVisible(By.id("nameConfirmation")), "Name confirmation not visible.");
    }

    public void arbeitgeber_ansprechperson(String anrede, String familienname, String vornamen) {
        selectDropdown(By.id("ansprechpersonAnrede"), anrede);
        enterText(By.id("ansprechpersonFamilienname"), familienname);
        enterText(By.id("ansprechpersonVornamen"), vornamen);
        Assert.assertTrue(elementVisible(By.id("contactPersonConfirmation")), "Contact person confirmation not visible.");
    }

    public void weiteres_zum_Arbeitsverhaeltnisbeziehung_zum_arbeitgeber() {
        // Implementation for relationship with employer
        clickElement(By.id("arbeitsverhaeltnisbeziehung"));
        Assert.assertTrue(elementVisible(By.id("relationshipConfirmation")), "Relationship confirmation not visible.");
    }
}