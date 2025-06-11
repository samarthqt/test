package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import com.framework.selenium.SeleniumTestParameters;
import com.framework.report.Status;
import java.util.*;

public class AVGS_Page extends WebReusableComponents {

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

    public AVGS_Page() {
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
        By removeButton = By.xpath("//div[contains(text(), '" + addressLine1 + "')]/following-sibling::button[@class='remove']");
        waitUntilElementVisible(removeButton, 3);
        clickElement(removeButton);
    }

    public void verifyAddressRemoved(String addressLine1) {
        By addressLocator = By.xpath("//div[contains(text(), '" + addressLine1 + "')]/following-sibling::button[@class='remove']");
        boolean isAddressPresent = elementVisible(addressLocator);
        Assert.assertFalse(isAddressPresent, "Address was not removed from the address book.");
    }

    public void printTestcaseDescriptionInReport(String testid, String sn, String col) {
        addTestLog("Beschreibung", testid + "\n=================================\n\n" + harness.getData(sn, col)
                + "\n=================================\n\n", Status.DONE);
    }

    public void beantragendePerson(String beantragendePerson) {
        selectDropdownById("dropDownById", "beantragendePerson-selectized", harness.getData("Beantragende Person", beantragendePerson), "last()");
        handlePageLoading();
    }

    public void angabenZurBetreuungspersonOderBevollmaechtigten(String betreuerName, String betreuerVornamen, String organisation, String beziehung) {
        enterTextBoxById("textBoxById", "betreuerName", harness.getData("Beantragende Person", betreuerName), "last()");
        enterTextBoxById("textBoxById", "betreuerVornamen", harness.getData("Beantragende Person", betreuerVornamen), "last()");
        if (!harness.getData("Beantragende Person", organisation).isEmpty()) {
            enterTextBoxById("textBoxById", "betreuerOrga", harness.getData("Beantragende Person", organisation), "last()");
        }
        if (!harness.getData("Beantragende Person", beziehung).isEmpty()) {
            enterTextBoxById("textBoxById", "betreuerBeziehung", harness.getData("Beantragende Person", beziehung), "last()");
        }
    }

    public void beantragendePersonAuslandsanschrift(String staat, String anschriftzeilen) {
        selectDropdownById("dropDownById", "betreuerAnschriftAuslStaat-selectized", harness.getData("Beantragende Person", staat), "last()");
        handlePageLoading();
        int n = harness.getIterationCount("Beantragende Person", anschriftzeilen);
        for (int i = 1; i <= n; i++) {
            if (i > 2) {
                handlePageLoading();
                clickCommonButton_Index("commonButtonSubmit_Index", "Anschriftzeile hinzufügen", "last()");
                handlePageLoading();
            }
            String prefixId = String.valueOf(i - 1);
            handlePageLoading();
            enterTextBoxById("anschriftzeileById", prefixId + ".betreuerAnschriftAuslZeile", harness.getIterationData("Beantragende Person", anschriftzeilen, i), "last()");
            handlePageLoading();
        }
    }

    public void beantragendePersonKommunikation(String tel, String mail) {
        if (!harness.getData("Beantragende Person", tel).isEmpty()) {
            enterTextBoxById("textBoxById", "betreuerKontaktTel", harness.getData("Beantragende Person", tel), "last()");
        }
        if (!harness.getData("Beantragende Person", mail).isEmpty()) {
            enterTextBoxById("textBoxById", "betreuerKontaktMail", harness.getData("Beantragende Person", mail), "last()");
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void angabenZurAnstragstellendenPerson(String doktorgrade, String familienname, String vornamen) {
        if (!harness.getData("antragstellende Person", doktorgrade).isEmpty()) {
            enterTextBoxById("textBoxById", "doktorgrade", harness.getData("antragstellende Person", doktorgrade), "last()");
        }
        enterTextBoxById("textBoxById", "familienname", harness.getData("antragstellende Person", familienname), "last()");
        if (!harness.getData("antragstellende Person", vornamen).isEmpty()) {
            enterTextBoxById("textBoxById", "vornamen", harness.getData("antragstellende Person", vornamen), "last()");
        }
    }

    public void angabenZurAnstragstellendenPersonGeburtsdaten(String tag, String monat, String jahr) {
        if (!harness.getData("antragstellende Person", tag).isEmpty()) {
            enterTextBoxById("textBoxById", "gebTag", harness.getData("antragstellende Person", tag), "last()");
            handlePageLoading();
        }
        if (!harness.getData("antragstellende Person", monat).isEmpty()) {
            enterTextBoxById("textBoxById", "gebMonat", harness.getData("antragstellende Person", monat), "last()");
            handlePageLoading();
        }
        if (!harness.getData("antragstellende Person", jahr).isEmpty()) {
            enterTextBoxById("textBoxById", "gebJahr", harness.getData("antragstellende Person", jahr), "last()");
            handlePageLoading();
        }
    }

    public void angabenZurAnstragstellendenPersonKommunikation(String tel, String mail) {
        if (!harness.getData("antragstellende Person", tel).isEmpty()) {
            enterTextBoxById("textBoxById", "kontaktTel", harness.getData("antragstellende Person", tel), "last()");
        }
        if (!harness.getData("antragstellende Person", mail).isEmpty()) {
            enterTextBoxById("textBoxById", "kontaktMail", harness.getData("antragstellende Person", mail), "last()");
        }
    }

    public void angabenZurAnstragstellendenPersonStrassenanschrift(String str, String hsnr, String plz, String ort, String adresszusatz) {
        enterTextBoxById("textBoxById", "anschriftStr", harness.getData("antragstellende Person", str), "last()");
        if (!harness.getData("antragstellende Person", hsnr).isEmpty()) {
            handlePageLoading();
            enterTextBoxById("textBoxById", "anschriftHsNr", harness.getData("antragstellende Person", hsnr), "last()");
        }
        handlePageLoading();
        enterTextBoxById("textBoxById", "anschriftPlz", harness.getData("antragstellende Person", plz), "last()");
        handlePageLoading();
        enterTextBoxById("textBoxById", "anschriftOrt", harness.getData("antragstellende Person", ort), "last()");
        if (!harness.getData("antragstellende Person", adresszusatz).isEmpty()) {
            handlePageLoading();
            enterTextBoxById("textBoxById", "anschriftZusatz", harness.getData("antragstellende Person", adresszusatz), "last()");
        }
    }

    public void beantragendePersonAnschriftsland(String anschriftLand) {
        selectDropdownById("dropDownById", "betreuerAnschrift-selectized", harness.getData("Beantragende Person", anschriftLand), "last()");
    }

    public void beantragendePersonStrassenanschrift(String str, String hsnr, String plz, String ort, String adresszusatz) {
        enterTextBoxById("textBoxById", "betreuerAnschriftInlStr", harness.getData("Beantragende Person", str), "last()");
        if (!harness.getData("Beantragende Person", hsnr).isEmpty()) {
            handlePageLoading();
            enterTextBoxById("textBoxById", "betreuerAnschriftInlHsNr", harness.getData("Beantragende Person", hsnr), "last()");
        }
        handlePageLoading();
        enterTextBoxById("textBoxById", "betreuerAnschriftInlPlz", harness.getData("Beantragende Person", plz), "last()");
        handlePageLoading();
        enterTextBoxById("textBoxById", "betreuerAnschriftInlOrt", harness.getData("Beantragende Person", ort), "last()");
        if (!harness.getData("Beantragende Person", adresszusatz).isEmpty()) {
            handlePageLoading();
            enterTextBoxById("textBoxById", "betreuerAnschriftInlZusatz", harness.getData("Beantragende Person", adresszusatz), "last()");
        }
    }

    public void beantragendePersonAnschriftPostfach(String postfach, String plz, String ort) {
        if (!harness.getData("Beantragende Person", postfach).isEmpty()) {
            handlePageLoading();
            enterTextBoxById("textBoxById", "betreuerAnschriftInlPf", harness.getData("Beantragende Person", postfach), "1");
        }
        handlePageLoading();
        enterTextBoxById("textBoxById", "betreuerAnschriftInlPfPlz", harness.getData("Beantragende Person", plz), "last()");
        handlePageLoading();
        enterTextBoxById("textBoxById", "betreuerAnschriftInlPfOrt", harness.getData("Beantragende Person", ort), "last()");
    }
}