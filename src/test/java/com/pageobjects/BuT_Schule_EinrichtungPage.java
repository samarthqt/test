package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import java.util.*;

public class BuT_Schule_EinrichtungPage extends WebReusableComponents {

    protected By dropdownEinrichtung = By.id("Einrichtung");
    protected By textboxSchulname = By.id("Schulname");
    protected By dropdownBedarfeBildungTeilhabe = By.id("BedarfeBildungTeilhabe");
    protected By dropdownAusflugsdauer = By.id("Ausflugsdauer");
    protected By textboxKostenEintaegig = By.id("KostenEintaegig");
    protected By textboxKostenMehrtaegig = By.id("KostenMehrtaegig");
    protected By radioSchulbedarfsfoerderung = By.id("Schulbedarfsfoerderung");
    protected By radioSchulbedarfsauszahlung = By.id("Schulbedarfsauszahlung");
    protected By textboxKontoinhaberSchulbedarf = By.id("KontoinhaberSchulbedarf");
    protected By textboxIbanSchulbedarf = By.id("IbanSchulbedarf");
    protected By textboxBicSchulbedarf = By.id("BicSchulbedarf");
    protected By textboxGeldinstitutsnameSchulbedarf = By.id("GeldinstitutsnameSchulbedarf");

    public BuT_Schule_EinrichtungPage() {
        PageFactory.initElements(driver, this);
    }

    public void besuchteEinrichtung(String einrichtung, String schulname) {
        waitUntilElementVisible(dropdownEinrichtung, 3);
        selectDropdownByValue(dropdownEinrichtung, einrichtung);
        waitUntilElementVisible(textboxSchulname, 3);
        enterText(textboxSchulname, schulname);
    }

    public void bedarfeFuerBildungUndTeilhabe(String bedarfe) {
        if (!bedarfe.isEmpty()) {
            List<String> bedarfeList = Arrays.asList(bedarfe.split("@@"));
            for (String s : bedarfeList) {
                waitUntilElementVisible(dropdownBedarfeBildungTeilhabe, 3);
                selectDropdownByValue(dropdownBedarfeBildungTeilhabe, s.trim());
            }
        }
        sendKeysToWindow(Keys.TAB);
    }

    public void bedarfeFuerSchulausfluege(String ausflugsdauer, String kosten) {
        waitUntilElementVisible(dropdownAusflugsdauer, 3);
        selectDropdownByValue(dropdownAusflugsdauer, ausflugsdauer);
        if (ausflugsdauer.equalsIgnoreCase("eintägig")) {
            waitUntilElementVisible(textboxKostenEintaegig, 3);
            enterText(textboxKostenEintaegig, kosten);
        } else if (ausflugsdauer.equalsIgnoreCase("mehrtägig")) {
            waitUntilElementVisible(textboxKostenMehrtaegig, 3);
            enterText(textboxKostenMehrtaegig, kosten);
        } else {
            Assert.fail("Option " + ausflugsdauer + " not available. Value should be 'eintägig' or 'mehrtätig'");
        }
    }

    public void persoenlicherSchulbedarf(String schulbedarfsfoerderung, String schulbedarfsauszahlung) {
        waitUntilElementVisible(radioSchulbedarfsfoerderung, 3);
        clickRadioButtonByValue(radioSchulbedarfsfoerderung, schulbedarfsfoerderung);
        waitUntilElementVisible(radioSchulbedarfsauszahlung, 3);
        clickRadioButtonByValue(radioSchulbedarfsauszahlung, schulbedarfsauszahlung);
    }

    public void persoenlicherSchuldbedarfBankverbindung(String ktoInh, String iban, String bic, String geldinstitut) {
        waitUntilElementVisible(textboxKontoinhaberSchulbedarf, 3);
        enterText(textboxKontoinhaberSchulbedarf, ktoInh);
        waitUntilElementVisible(textboxIbanSchulbedarf, 3);
        enterText(textboxIbanSchulbedarf, iban);
        if (!bic.isEmpty()) {
            waitUntilElementVisible(textboxBicSchulbedarf, 3);
            enterText(textboxBicSchulbedarf, bic);
        }
        if (!geldinstitut.isEmpty()) {
            waitUntilElementVisible(textboxGeldinstitutsnameSchulbedarf, 3);
            enterText(textboxGeldinstitutsnameSchulbedarf, geldinstitut);
        }
    }

    // Additional methods for other functionalities can be implemented similarly
}