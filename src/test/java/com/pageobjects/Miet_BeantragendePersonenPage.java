package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class Miet_BeantragendePersonenPage extends WebReusableComponents {

    protected By addressBookLink = By.id("addressBook");
    protected By addAddressButton = By.id("addAddress");
    protected By txtAddressLine1 = By.id("addressLine1");
    protected By txtCity = By.id("city");
    protected By txtState = By.id("state");
    protected By txtPostalCode = By.id("postalCode");
    protected By txtCountry = By.id("country");
    protected By saveAddressButton = By.id("saveAddress");
    protected By addressEntries = By.cssSelector(".address-entry");
    protected By paymentMethodsLink = By.id("paymentMethods");
    protected By addPaymentMethodButton = By.id("addPaymentMethod");
    protected By txtCardNumber = By.id("cardNumber");
    protected By txtCardHolderName = By.id("cardHolderName");
    protected By txtExpiryDate = By.id("expiryDate");
    protected By txtCVV = By.id("cvv");
    protected By savePaymentMethodButton = By.id("savePaymentMethod");
    protected By savedCards = By.cssSelector(".saved-card");

    public Miet_BeantragendePersonenPage() {
        PageFactory.initElements(driver, this);
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

    public void navigateToPaymentMethods() {
        waitUntilElementVisible(paymentMethodsLink, 3);
        clickElement(paymentMethodsLink);
    }

    public void addNewPaymentMethod(String cardNumber, String cardHolderName, String expiryDate, String cvv) {
        waitUntilElementVisible(addPaymentMethodButton, 3);
        clickElement(addPaymentMethodButton);
        enterText(txtCardNumber, cardNumber);
        enterText(txtCardHolderName, cardHolderName);
        enterText(txtExpiryDate, expiryDate);
        enterText(txtCVV, cvv);
        clickElement(savePaymentMethodButton);
    }

    public void verifyPaymentMethodSaved() {
        waitUntilElementVisible(savedCards, 3);
        List<WebElement> cards = getWebElementList(savedCards);
        Assert.assertFalse(cards.isEmpty(), "No saved payment methods found.");
    }

    public void removePaymentMethod(String lastFourDigits) {
        By removeButton = By.xpath("//div[contains(text(), '**** **** **** " + lastFourDigits + "')]/following-sibling::button[@class='remove']");
        waitUntilElementVisible(removeButton, 3);
        clickElement(removeButton);
    }

    public void verifyPaymentMethodRemoved(String lastFourDigits) {
        By cardLocator = By.xpath("//div[contains(text(), '**** **** **** " + lastFourDigits + "')]/following-sibling::button[@class='remove']");
        boolean isCardPresent = elementVisible(cardLocator);
        Assert.assertFalse(isCardPresent, "Card was not removed from saved payment methods.");
    }

    public void angabenZumAntragstellendenPerson(String familienname, String vorname, String geburtstag, String geburtsmonat, String geburtsjahr, String geschlecht) {
        enterTextBoxById("textBoxById", "antragstellerFamilienname", familienname, "1");
        enterTextBoxById("textBoxById", "antragstellerVorname", vorname, "1");
        if (!geburtstag.isEmpty()) {
            enterTextBoxById("textBoxById", "geburtstag", geburtstag, "1");
            handlePageLoading();
            enterTextBoxById("textBoxById", "geburtsmonat", geburtsmonat, "1");
            handlePageLoading();
        }
        enterTextBoxById("textBoxById", "geburtsjahr", geburtsjahr, "1");
        handlePageLoading();
        selectDropdownById("dropDownById", "geschlecht", geschlecht, "1");
    }

    public void angabenZurBeantragendenPerson(String beantragendePerson) {
        selectDropdownById("dropDownById", "beantragendePerson", beantragendePerson, "1");
    }

    public void angabenZurBetreuendenOderBevollmächtigtenPerson(String beantragendePerson, String familienname, String vorname, String beziehung, String nameDesUnternehmens, String beziehungPerson, String anschrift, String telefonnummer, String email, String hinweis, String strasse, String hausnummer, String plz, String ort, String adresszusatz, String postfach, String postfach_plz, String postfach_ort, String staat, String anschriftzeile1, String anschriftzeile2) {
        enterTextBoxById("textBoxById", "betreuerName", familienname, "1");
        enterTextBoxById("textBoxById", "betreuerVornamen", vorname, "1");
        if (beantragendePerson.equalsIgnoreCase("Sonstige")) {
            enterTextBoxById("textBoxById", "beziehung", beziehung, "1");
        }
        if (beantragendePerson.equalsIgnoreCase("Ich als gerichtliche Betreuung für meine betreute Person")) {
            enterTextBoxById("textBoxById", "organisation", nameDesUnternehmens, "1");
        }
        if (beantragendePerson.equalsIgnoreCase("Sonstige")) {
            enterTextBoxById("textBoxById", "beziehung", beziehungPerson, "1");
        }
        selectDropdownById("dropDownById", "anschriftLand-selectized", anschrift, "1");
        if (anschrift.equalsIgnoreCase("in Deutschland")) {
            AngabenzuAnschriftInDeutschland(strasse, hausnummer, plz, ort, adresszusatz, postfach, postfach_plz, postfach_ort);
        } else if (anschrift.equalsIgnoreCase("außerhalb von Deutschland")) {
            AngabenzuAnschriftAußerhalbVonDeutschland(staat, anschriftzeile1, anschriftzeile2);
        }
        if (anschrift.equalsIgnoreCase("außerhalb von Deutschland")) {
            if (!anschriftzeile1.isEmpty()) {
                int n = 3; // Assuming 3 iterations for example
                int pos = 3;
                for (int i = 1; i <= n; i++) {
                    clickCommonButton_Index("commonButton_Index", "Anschriftzeile hinzufügen", "last()");
                    angaben_zu_den_Anschriften(i, anschriftzeile1, pos);
                    pos = pos + 2;
                }
            }
        }
        enterTextBoxById("textBoxById", "betreuerTel", telefonnummer, "1");
        enterTextBoxById("textBoxById", "betreuerMail", email, "1");
        clickRadioButtonById("radioButtonById", "betreuerEinverstaendniss", hinweis, "1");
    }

    public void AngabenzuAnschriftInDeutschland(String strasse, String hausnummer, String plz, String ort, String adresszusatz, String postfach, String postfach_plz, String postfach_ort) {
        enterTextBoxById("textBoxById", "betreuerStrasse", strasse, "1");
        enterTextBoxById("textBoxById", "betreuerHausnr", hausnummer, "1");
        enterTextBoxById("textBoxById", "betreuerPLZ", plz, "1");
        enterTextBoxById("textBoxById", "betreuerOrt", ort, "1");
        enterTextBoxById("textBoxById", "betreuerAdresszusatz", adresszusatz, "1");
        if (checkEmpty(strasse) && checkEmpty(hausnummer) && checkEmpty(plz) && checkEmpty(ort) && checkEmpty(adresszusatz)) {
            enterTextBoxById("textBoxById", "betreuerPostfach", postfach, "1");
            enterTextBoxById("textBoxById", "betreuerPostfachPLZ", postfach_plz, "1");
            enterTextBoxById("textBoxById", "betreuerPostfachOrt", postfach_ort, "1");
        }
    }

    public void AngabenzuAnschriftAußerhalbVonDeutschland(String staat, String anschriftzeile1, String anschriftzeile2) {
        selectDropdownById("dropDownById", "betreuerStaat-selectized", staat, "1");
        enterTextBoxById("textBoxById", "UvM_AnschriftAusland.0.anschriftzeile", anschriftzeile1, "1");
        enterTextBoxById("textBoxById", "UvM_AnschriftAusland.1.anschriftzeile", anschriftzeile2, "1");
    }

    public void angaben_zu_den_Anschriften(int subIteration, String anschrift, int pos) {
        enterTextBoxById("textBoxById", "anschriftzeile", anschrift, String.valueOf(pos));
    }

    public Boolean checkEmpty(String val) {
        return val.isEmpty();
    }
}