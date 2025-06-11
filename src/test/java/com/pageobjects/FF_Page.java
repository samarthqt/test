package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class FF_Page extends WebReusableComponents {

    protected By btnProceedToCheckout = By.id("proceedToCheckout");
    protected By txtFullName = By.id("fullName");
    protected By txtAddress = By.id("address");
    protected By txtCity = By.id("city");
    protected By txtPostalCode = By.id("postalCode");
    protected By txtPhone = By.id("phone");
    protected By paymentMethodDropdown = By.id("paymentMethod");
    protected By txtCardNumber = By.id("cardNumber");
    protected By txtExpiryDate = By.id("expiryDate");
    protected By txtCVV = By.id("cvv");
    protected By btnPlaceOrder = By.id("placeOrder");
    protected By orderConfirmationMessage = By.id("orderConfirmationMessage");
    protected By btnPayWithPayPal = By.id("payWithPayPal");
    protected By btnLoginToPayPal = By.id("paypalLogin");
    protected By btnConfirmPayPalPayment = By.id("confirmPaypalPayment");
    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");

    public FF_Page() {
        PageFactory.initElements(driver, this);
    }

    public void proceedToCheckout() {
        waitUntilElementVisible(btnProceedToCheckout, 3);
        clickElement(btnProceedToCheckout);
    }

    public void enterShippingDetails(String fullName, String address, String city, String postalCode, String phone) {
        waitUntilElementVisible(txtFullName, 3);
        enterText(txtFullName, fullName);
        enterText(txtAddress, address);
        enterText(txtCity, city);
        enterText(txtPostalCode, postalCode);
        enterText(txtPhone, phone);
    }

    public void selectPaymentMethod(String method) {
        waitUntilElementVisible(paymentMethodDropdown, 3);
        selectByValue(paymentMethodDropdown, method);
    }

    public void enterCreditCardDetails(String cardNumber, String expiryDate, String cvv) {
        waitUntilElementVisible(txtCardNumber, 3);
        enterText(txtCardNumber, cardNumber);
        enterText(txtExpiryDate, expiryDate);
        enterText(txtCVV, cvv);
    }

    public void placeOrder() {
        waitUntilElementVisible(btnPlaceOrder, 3);
        clickElement(btnPlaceOrder);
    }

    public void verifyOrderConfirmation(String expectedMessage) {
        waitUntilElementVisible(orderConfirmationMessage, 3);
        String actualMessage = getTextFromElement(orderConfirmationMessage);
        Assert.assertEquals(actualMessage, expectedMessage, "Order confirmation message does not match.");
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

    public void printTestcaseDescriptionInReport(String testId, String description) {
        addTestLog("Beschreibung", testId + "\n=================================\n\n" + description + "\n=================================\n\n", Status.DONE);
    }

    public void beantragendePerson(String beantragendePerson) {
        selectDropdownById("dropDownById", "beantragendePerson", beantragendePerson, "last()");
    }

    public void beantragendePersonNamen(String familienname, String vornamen, String organisation, String beziehung) {
        enterTextBoxById("textBoxById", "betreuerFamilienname", familienname, "last()");
        enterTextBoxById("textBoxById", "betreuerVornamen", vornamen, "last()");
        if (!organisation.isEmpty()) {
            enterTextBoxById("textBoxById", "organisation", organisation, "last()");
        }
        if (!beziehung.isEmpty()) {
            enterTextBoxById("textBoxById", "bezeiehung", beziehung, "last()");
        }
    }

    public void beantragendePersonAnschriftsland(String anschriftLand) {
        selectDropdownById("dropDownById", "betreuerAnschrift", anschriftLand, "last()");
        handlePageLoading();
    }

    public void beantragendePersonStrassenanschrift(String str, String hsnr, String plz, String ort, String adresszusatz) {
        handlePageLoading();
        enterTextBoxById("textBoxById", "betreuerStr", str, "last()");
        if (!hsnr.isEmpty()) {
            handlePageLoading();
            enterTextBoxById("textBoxById", "betreuerHausNr", hsnr, "last()");
        }
        handlePageLoading();
        enterTextBoxById("textBoxById", "betreuerPlz", plz, "last()");
        handlePageLoading();
        enterTextBoxById("textBoxById", "betreuerOrt", ort, "last()");
        handlePageLoading();
        if (!adresszusatz.isEmpty()) {
            enterTextBoxById("textBoxById", "betreuerAdresszusatz", adresszusatz, "last()");
        }
    }

    public void beantragendePersonPostfachanschrift(String postfach, String plz, String ort) {
        if (!postfach.isEmpty()) {
            enterTextBoxById("textBoxById", "betreuerPostfach", postfach, "1");
        }
        handlePageLoading(1000);
        enterTextBoxById("textBoxById", "betreuerPostfachPlz", plz, "last()");
        handlePageLoading(1000);
        enterTextBoxById("textBoxById", "betreuerPostfachOrt", ort, "last()");
    }

    public void beantragendePersonAuslandsanschrift(String staat, String anschriftzeilen) {
        selectDropdownById("dropDownById", "betreuerStaat", staat, "last()");
        handlePageLoading();
        int n = harness.getIterationCount(SN_BP, anschriftzeilen);
        for (int i = 1; i <= n; i++) {
            if (i > 2) {
                clickCommonButton_Index("commonButtonAsSubmit_Index", "Anschriftzeile hinzufügen", "last()");
                handlePageLoading();
            }
            String prefixId = String.valueOf(i - 1);
            handlePageLoading();
            enterTextBoxById("anschriftzeileById", prefixId + ".betreuerAnschriftzeile", harness.getIterationData(SN_BP, anschriftzeilen, i), "last()");
            handlePageLoading();
        }
    }

    public void beantragendePersonKommunikation(String tel, String mail) {
        if (!tel.isEmpty()) {
            enterTextBoxById("textBoxById", "betreuerTel", tel, "last()");
        }
        if (!mail.isEmpty()) {
            enterTextBoxById("textBoxById", "betreuerMail", mail, "last()");
        }
    }

    public void antragstellendePersonNamen(String doktorgrade, String familienname, String vornamen) {
        if (!doktorgrade.isEmpty()) {
            handlePageLoading(1000);
            enterTextBoxById("textBoxById", "doktorgrad", doktorgrade, "last()");
        }
        handlePageLoading(1000);
        enterTextBoxById("textBoxById", "familienname", familienname, "last()");
        handlePageLoading(1000);
        enterTextBoxById("textBoxById", "vorname", vornamen, "last()");
    }

    public void antragstellendePersonGeburtsdatum(String tag, String monat, String jahr) {
        if (!tag.isEmpty()) {
            handlePageLoading(1000);
            enterTextBoxById("textBoxById", "gebTag", tag, "1");
        }
        if (!monat.isEmpty()) {
            handlePageLoading(1000);
            enterTextBoxById("textBoxById", "gebMonat", monat, "last()");
        }
        handlePageLoading(1000);
        enterTextBoxById("textBoxById", "gebJahr", jahr, "last()");
    }

    public void antragstellendePersonStrassenanschrift(String str, String hsnr, String plz, String ort, String adresszusatz) {
        handlePageLoading();
        enterTextBoxById("textBoxById", "strasse", str, "last()");
        if (!hsnr.isEmpty()) {
            handlePageLoading();
            enterTextBoxById("textBoxById", "hausnummer", hsnr, "last()");
        }
        handlePageLoading();
        enterTextBoxById("textBoxById", "postleitzahl", plz, "last()");
        handlePageLoading();
        enterTextBoxById("textBoxById", "ort", ort, "last()");
        handlePageLoading();
        if (!adresszusatz.isEmpty()) {
            enterTextBoxById("textBoxById", "adresszusatz", adresszusatz, "last()");
        }
    }

    public void antragstellendePersonKommunikation(String tel, String mail) {
        if (!tel.isEmpty()) {
            enterTextBoxById("textBoxById", "telefonnummer", tel, "last()");
        }
        if (!mail.isEmpty()) {
            enterTextBoxById("textBoxById", "eMailAdresse", mail, "last()");
        }
    }

    public void angabenZumZeitraum(String zeitraum) {
        selectDropdownById("dropDownById", "zeitraum", zeitraum, "last()");
    }

    public void angabenZurUnterstuetzung(String unterstuetzung) {
        selectDropdownById("dropDownById", "unterstuetzung", unterstuetzung, "last()");
    }

    public void angabenZurLeistung(String leistung) {
        selectDropdownById("dropDownById", "leistung", leistung, "last()");
    }

    public void angabenZumKontoinhaber(String kontoinhaber) {
        enterTextBoxById("textBoxById", "kontoinhaber", kontoinhaber, "last()");
    }

    public void angabenZumKonto(String konto) {
        enterTextBoxById("textBoxById", "konto", konto, "last()");
    }

    public void angabenZurBankverbindung(String bankverbindung) {
        enterTextBoxById("textBoxById", "bankverbindung", bankverbindung, "last()");
    }

    public void uploadFileNachweise(String filePath) {
        uploadFileById("fileUploadById", "nachweise", filePath, "last()");
    }
}