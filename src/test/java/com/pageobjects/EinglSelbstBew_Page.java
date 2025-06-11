package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import com.framework.selenium.SeleniumTestParameters;
import com.framework.report.Status;
import java.util.*;

public class EinglSelbstBew_Page extends WebReusableComponents {

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
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

    public EinglSelbstBew_Page() {
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

    public void printTestcaseDescriptionInReport(String testid, String sn, String col) {
        addTestLog("Beschreibung", testid + "\n=================================\n\n" + harness.getData(sn, col)
                + "\n=================================\n\n", Status.DONE);
    }

    public void beantragendePerson(String beantragendePerson) {
        selectDropdownById("dropDownById", "beantragendePerson", harness.getData(SN_BP, beantragendePerson), "last()");
    }

    public void angabenZurBetreuungspersonOderBevollmaechtigten(String betreuerName, String betreuerVornamen,
            String organisation, String beziehung) {
        enterTextBoxById("textBoxById", "betreuerName", harness.getData(SN_BP, betreuerName), "last()");
        enterTextBoxById("textBoxById", "betreuerVornamen", harness.getData(SN_BP, betreuerVornamen), "last()");
        if (!harness.getData(SN_BP, organisation).isEmpty()) {
            enterTextBoxById("textBoxById", "organisation", harness.getData(SN_BP, organisation), "last()");
        }
        if (!harness.getData(SN_BP, beziehung).isEmpty()) {
            enterTextBoxById("textBoxById", "beziehungAntragstellendePerson", harness.getData(SN_BP, beziehung),
                    "last()");
        }
    }

    public void beantragendePersonAnschriftsland(String anschriftLand) {
        selectDropdownById("dropDownById", "betreuerAnschrift-selectized", harness.getData(SN_BP, anschriftLand),
                "last()");
    }

    public void beantragendePersonStrassenanschrift(String str, String hsnr, String plz, String ort,
            String adresszusatz) {
        enterTextBoxById("textBoxById", "betreuerStrasse", harness.getData(SN_BP, str), "last()");
        if (!harness.getData(SN_BP, hsnr).isEmpty()) {
            handlePageLoading();
            enterTextBoxById("textBoxById", "betreuerHausnummer", harness.getData(SN_BP, hsnr), "last()");
        }
        handlePageLoading();
        enterTextBoxById("textBoxById", "betreuerPLZ", harness.getData(SN_BP, plz), "last()");
        handlePageLoading();
        enterTextBoxById("textBoxById", "betreuerOrt", harness.getData(SN_BP, ort), "last()");
        if (!harness.getData(SN_BP, adresszusatz).isEmpty()) {
            handlePageLoading();
            enterTextBoxById("textBoxById", "betreuerAnschriftZusatz", harness.getData(SN_BP, adresszusatz), "last()");
        }
    }

    public void beantragendePersonAnschriftPostfach(String postfach, String plz, String ort) {
        if (!harness.getData(SN_BP, postfach).isEmpty()) {
            handlePageLoading();
            enterTextBoxById("textBoxById", "betreuerPostfach", harness.getData(SN_BP, postfach), "1");
        }
        handlePageLoading();
        enterTextBoxById("textBoxById", "betreuerPlzPostfach", harness.getData(SN_BP, plz), "last()");
        handlePageLoading();
        enterTextBoxById("textBoxById", "betreuerOrtPostfach", harness.getData(SN_BP, ort), "last()");
    }

    public void beantragendePersonAuslandsanschrift(String staat, String anschriftzeilen) {
        selectDropdownById("dropDownById", "betreuerStaat-selectized", harness.getData(SN_BP, staat), "last()");
        handlePageLoading();
        int n = harness.getIterationCount(SN_BP, anschriftzeilen);
        for (int i = 1; i <= n; i++) {
            if (i > 1) {
                handlePageLoading();
                clickCommonButton_Index("commonButton_Index", "Anschriftzeile hinzufügen", "last()");
                handlePageLoading();
            }
            String prefixId = String.valueOf(i - 1);
            handlePageLoading();
            enterTextBoxById("anschriftzeileById", prefixId + ".anschriftzeile",
                    harness.getIterationData(SN_BP, anschriftzeilen, i), "last()");
            handlePageLoading();
        }
    }

    public void beantragendePersonKommunikation(String tel, String mail) {
        if (!harness.getData(SN_BP, tel).isEmpty()) {
            enterTextBoxById("textBoxById", "betreuerTelefon", harness.getData(SN_BP, tel), "last()");
        }
        if (!harness.getData(SN_BP, mail).isEmpty()) {
            enterTextBoxById("textBoxById", "betreuerEmail", harness.getData(SN_BP, mail), "last()");
        }
    }

    public void angabenZurAnstragstellendenPerson(String doktorgrade, String familienname, String vornamen) {
        if (!harness.getData(SN_AP, doktorgrade).isEmpty()) {
            enterTextBoxById("textBoxById", "doktorgrade", harness.getData(SN_AP, doktorgrade), "last()");
        }
        enterTextBoxById("textBoxById", "familienname", harness.getData(SN_AP, familienname), "last()");
        if (!harness.getData(SN_AP, vornamen).isEmpty()) {
            enterTextBoxById("textBoxById", "vornamen", harness.getData(SN_AP, vornamen), "last()");
        }
    }

    public void angabenZurAnstragstellendenPersonGeburtsdaten(String tag, String monat, String jahr) {
        if (!harness.getData(SN_AP, tag).isEmpty()) {
            enterTextBoxById("textBoxById", "geburtstag", harness.getData(SN_AP, tag), "last()");
            handlePageLoading();
        }
        if (!harness.getData(SN_AP, monat).isEmpty()) {
            enterTextBoxById("textBoxById", "geburtsmonat", harness.getData(SN_AP, monat), "last()");
            handlePageLoading();
        }
        enterTextBoxById("textBoxById", "geburtsjahr", harness.getData(SN_AP, jahr), "last()");
        handlePageLoading();
    }

    public void angabenZurAnstragstellendenPersonStrassenanschrift(String str, String hsnr, String plz, String ort,
            String adresszusatz) {
        enterTextBoxById("textBoxById", "strasse", harness.getData(SN_AP, str), "last()");
        if (!harness.getData(SN_AP, hsnr).isEmpty()) {
            handlePageLoading();
            enterTextBoxById("textBoxById", "hausnummer", harness.getData(SN_AP, hsnr), "last()");
        }
        handlePageLoading();
        enterTextBoxById("textBoxById", "postleitzahl", harness.getData(SN_AP, plz), "last()");
        handlePageLoading();
        enterTextBoxById("textBoxById", "ort", harness.getData(SN_AP, ort), "last()");
        if (!harness.getData(SN_AP, adresszusatz).isEmpty()) {
            handlePageLoading();
            enterTextBoxById("textBoxById", "adresszusatz", harness.getData(SN_AP, adresszusatz), "last()");
        }
    }

    public void angabenZurAnstragstellendenPersonKommunikation(String tel, String mail) {
        if (!harness.getData(SN_AP, tel).isEmpty()) {
            enterTextBoxById("textBoxById", "telefonnummer", harness.getData(SN_AP, tel), "last()");
        }
        if (!harness.getData(SN_AP, mail).isEmpty()) {
            enterTextBoxById("textBoxById", "emailAdresse", harness.getData(SN_AP, mail), "last()");
        }
    }

    public void abweichenderKontoInhaber(String kontoInhaber) {
        enterTextBoxById("textBoxById", "kontoInhaber", harness.getData(SN_BP, kontoInhaber), "last()");
    }

    public void angabeZurSelbststaendigkeit(String selbststaendigkeit) {
        selectDropdownById("dropDownById", "selbststaendigkeit", harness.getData(SN_BP, selbststaendigkeit), "last()");
    }

    public void uploadDatei(String dateiPfad) {
        WebElement uploadElement = driver.findElement(By.id("uploadDatei"));
        uploadElement.sendKeys(dateiPfad);
        Assert.assertTrue(uploadElement.getAttribute("value").contains(dateiPfad), "File upload failed.");
    }

    public void artDerGewuenschtenLeistung(String leistung) {
        selectDropdownById("dropDownById", "gewuenschteLeistung", harness.getData(SN_BP, leistung), "last()");
    }

    public void artDerGewuenschtenFinanziellenUnterstuetzung(String unterstuetzung) {
        selectDropdownById("dropDownById", "finanzielleUnterstuetzung", harness.getData(SN_BP, unterstuetzung), "last()");
    }

    public void bankverbindung(String bankName, String iban, String bic) {
        enterTextBoxById("textBoxById", "bankName", harness.getData(SN_BP, bankName), "last()");
        enterTextBoxById("textBoxById", "iban", harness.getData(SN_BP, iban), "last()");
        enterTextBoxById("textBoxById", "bic", harness.getData(SN_BP, bic), "last()");
    }
}