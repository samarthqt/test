package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import com.framework.cucumber.TestHarness;
import java.util.*;

public class GruSi_VermoegenPage extends WebReusableComponents {

    protected TestHarness harness = new TestHarness();

    protected By txtUserName = By.id("username");
    protected By txtPassword = By.id("password");
    protected By btnLogin = By.id("loginButton");
    protected By paymentMethodsLink = By.id("paymentMethods");
    protected By addPaymentMethodButton = By.id("addPaymentMethod");
    protected By txtCardNumber = By.id("cardNumber");
    protected By txtCardHolderName = By.id("cardHolderName");
    protected By txtExpiryDate = By.id("expiryDate");
    protected By txtCVV = By.id("cvv");
    protected By savePaymentMethodButton = By.id("savePaymentMethod");
    protected By savedCards = By.cssSelector(".saved-card");

    public GruSi_VermoegenPage() {
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

    public void bargeld(String iteration, String bargeld, String bargeldHoehe) {
        String prefixId = String.valueOf(Integer.parseInt(iteration) - 1);
        clickRadioButtonById("radioButtonById", prefixId + ".bargeld", harness.getData("Vermoegen", iteration, bargeld), "last()");
        if (harness.getData("Vermoegen", iteration, bargeld).equalsIgnoreCase("Ja")) {
            Bargeld_Ja(iteration, bargeldHoehe);
        }
    }

    public void Bargeld_Ja(String iteration, String bargeldHoehe) {
        String prefixId = String.valueOf(Integer.parseInt(iteration) - 1);
        if (!harness.getData("Vermoegen", iteration, bargeldHoehe).isEmpty()) {
            enterTextBoxById("textBoxById", prefixId + ".BetragBargeld", harness.getData("Vermoegen", iteration, bargeldHoehe), "last()");
        }
    }

    public void bankguthaben(String iteration, String bankGuthaben) {
        String prefixId = String.valueOf(Integer.parseInt(iteration) - 1);
        clickRadioButtonById("radioButtonById", prefixId + ".bankguthaben", harness.getData("Vermoegen", iteration, bankGuthaben), "last()");
        handlePageLoading();
    }

    public void sparguthaben(String iteration, String sparGuthaben) {
        String prefixId = String.valueOf(Integer.parseInt(iteration) - 1);
        clickRadioButtonById("radioButtonById", prefixId + ".sparguthaben", harness.getData("Vermoegen", iteration, sparGuthaben), "last()");
        handlePageLoading();
    }

    public void sonstige_Kontoguthaben(String iteration, String sonstigeKontoGuthaben) {
        String prefixId = String.valueOf(Integer.parseInt(iteration) - 1);
        clickRadioButtonById("radioButtonById", prefixId + ".sonstigeKontoguthaben", harness.getData("Vermoegen", iteration, sonstigeKontoGuthaben), "last()");
        handlePageLoading();
    }

    public void wertpapiere_und_aktien(String iteration, String wertpappe) {
        String prefixId = String.valueOf(Integer.parseInt(iteration) - 1);
        clickRadioButtonById("radioButtonById", prefixId + ".wertpapiere", harness.getData("Vermoegen", iteration, wertpappe), "last()");
        handlePageLoading();
    }

    public void schmuck_und_edelmetalle(String iteration, String blinkblink, String wert) {
        String prefixId = String.valueOf(Integer.parseInt(iteration) - 1);
        clickRadioButtonById("radioButtonById", prefixId + ".schmuck", harness.getData("Vermoegen", iteration, blinkblink), "last()");
        handlePageLoading();
        if (harness.getData("Vermoegen", blinkblink).equalsIgnoreCase("Ja")) {
            enterTextBoxById("textBoxById", prefixId + ".SchmuckSchaetzwert", harness.getData("Vermoegen", iteration, wert), "last()");
        }
    }

    public void vermoegen_ausland(String iteration, String vermoegenAusland) {
        String prefixId = String.valueOf(Integer.parseInt(iteration) - 1);
        clickRadioButtonById("radioButtonById", prefixId + ".sonstigesVermoegen", harness.getData("Vermoegen", iteration, vermoegenAusland), "last()");
        handlePageLoading();
    }

    public void altersvorsorge(String iteration, String altersVorsorge, String artPrivateAltersvorsorge, String datum) {
        String prefixId = String.valueOf(Integer.parseInt(iteration) - 1);
        clickRadioButtonById("radioButtonById", prefixId + ".altersvorsorge", harness.getData("Vermoegen", iteration, altersVorsorge), "last()");
        if (harness.getData("Vermoegen", altersVorsorge).equalsIgnoreCase("Ja")) {
            altersvorsorge_Ja(iteration, artPrivateAltersvorsorge, datum);
        }
    }

    public void altersvorsorge_Ja(String iteration, String artPrivateAltersvorsorge, String altersvorsorgeFaelligkeit) {
        int n = harness.getIterationCount(iteration, "Vermoegen", artPrivateAltersvorsorge);
        if (Integer.parseInt(iteration) > 1) {
            handlePageLoading();
            clickButtonById("commonButtonById", "btn_altersvorsorge_add", "last()");
            handlePageLoading();
        }
        for (int i = 1; i <= n; i++) {
            String prefixId = String.valueOf(Integer.parseInt(iteration) - 1) + ".GruSi_VermoegenAlter." + String.valueOf(i - 1);
            if (i > 1) {
                handlePageLoading();
                clickButtonById("commonButtonById", ".btn_altersvorsorge_add", "last()");
                handlePageLoading();
            }
            selectDropdownById("dropDownById", prefixId + ".privateAltersvorsorge", harness.getIterationData(iteration, "Vermoegen", artPrivateAltersvorsorge, i), "last()");
            enterTextBoxById("textBoxById", prefixId + ".altersvorsorgeFaelligkeit", harness.getIterationData(iteration, "Vermoegen", altersvorsorgeFaelligkeit, i), "last()");
            handlePageLoading();
        }
    }

    public void kapital_oder_risikolebensversicherung(String iteration, String kapitalRisiko) {
        String prefixId = String.valueOf(Integer.parseInt(iteration) - 1);
        clickRadioButtonById("radioButtonById", prefixId + ".lebensversicherung", harness.getData("Vermoegen", iteration, kapitalRisiko), "last()");
        handlePageLoading();
    }

    public void kraftfahrzeuge(String iteration, String besitz, String kennzeichen, String kmStand, String baujahr, String modell, String serie) {
        String prefixId = String.valueOf(Integer.parseInt(iteration) - 1);
        clickRadioButtonById("radioButtonById", prefixId + ".radio_kraftfahrzeuge", harness.getData("Vermoegen", iteration, besitz), "last()");
        if (harness.getData("Vermoegen", iteration, besitz).equalsIgnoreCase("Ja")) {
            int n = harness.getIterationCount(iteration, "Vermoegen", kennzeichen);
            if (Integer.parseInt(iteration) > 1) {
                handlePageLoading();
                clickButtonById("commonButtonById", "btn_kraftfahrzeug_add", "last()");
                handlePageLoading();
            }
            for (int i = 1; i <= n; i++) {
                String prefixIdVehicle = String.valueOf(Integer.parseInt(iteration) - 1) + ".GruSi_VermoegenKfz." + String.valueOf(i - 1);
                if (i > 1) {
                    handlePageLoading();
                    clickButtonById("commonButtonById", "btn_kraftfahrzeug_add", "last()");
                    handlePageLoading();
                }
                enterTextBoxById("textBoxById", prefixIdVehicle + ".kennzeichen", harness.getIterationData(iteration, "Vermoegen", kennzeichen, i), "last()");
                enterTextBoxById("textBoxById", prefixIdVehicle + ".kmStand", harness.getIterationData(iteration, "Vermoegen", kmStand, i), "last()");
                enterTextBoxById("textBoxById", prefixIdVehicle + ".baujahr", harness.getIterationData(iteration, "Vermoegen", baujahr, i), "last()");
                enterTextBoxById("textBoxById", prefixIdVehicle + ".modell", harness.getIterationData(iteration, "Vermoegen", modell, i), "last()");
                enterTextBoxById("textBoxById", prefixIdVehicle + ".serie", harness.getIterationData(iteration, "Vermoegen", serie, i), "last()");
                handlePageLoading();
            }
        }
    }

    public void ansprueche_gegen_dritten(String iteration, String ansprueche, String hoeheDerAnsprueche) {
        String prefixId = String.valueOf(Integer.parseInt(iteration) - 1);
        clickRadioButtonById("radioButtonById", prefixId + ".ansprueche", harness.getData("Vermoegen", iteration, ansprueche), "last()");
        if (harness.getData("Vermoegen", iteration, ansprueche).equalsIgnoreCase("Ja")) {
            enterTextBoxById("textBoxById", prefixId + ".hoeheDerAnsprueche", harness.getData("Vermoegen", iteration, hoeheDerAnsprueche), "last()");
        }
    }

    public void hauseigentum_oder_wohneigentum(String iteration, String hauseigentum) {
        String prefixId = String.valueOf(Integer.parseInt(iteration) - 1);
        clickRadioButtonById("radioButtonById", prefixId + ".hauseigentum", harness.getData("Vermoegen", iteration, hauseigentum), "last()");
        handlePageLoading();
    }

    public void ansprueche_aus_uebertragungsvertraegen(String iteration, String uebertragungsvertraegen, String datumDerVermoegensuebertragung, String hoeheDerVermoegensuebertragung) {
        String prefixId = String.valueOf(Integer.parseInt(iteration) - 1);
        clickRadioButtonById("radioButtonById", prefixId + ".uebertragungsvertraegen", harness.getData("Vermoegen", iteration, uebertragungsvertraegen), "last()");
        if (harness.getData("Vermoegen", iteration, uebertragungsvertraegen).equalsIgnoreCase("Ja")) {
            enterTextBoxById("textBoxById", prefixId + ".datumDerVermoegensuebertragung", harness.getData("Vermoegen", iteration, datumDerVermoegensuebertragung), "last()");
            enterTextBoxById("textBoxById", prefixId + ".hoeheDerVermoegensuebertragung", harness.getData("Vermoegen", iteration, hoeheDerVermoegensuebertragung), "last()");
        }
    }

    public void sonstiger_grundbesitz(String iteration, String grundbesitz) {
        String prefixId = String.valueOf(Integer.parseInt(iteration) - 1);
        clickRadioButtonById("radioButtonById", prefixId + ".grundbesitz", harness.getData("Vermoegen", iteration, grundbesitz), "last()");
        handlePageLoading();
    }

    public void vermoegensuebertragungen(String iteration, String vermoegensuebertragung, String datumDerVermoegensuebertragung, String hoeheDerVermoegensuebertragung) {
        String prefixId = String.valueOf(Integer.parseInt(iteration) - 1);
        clickRadioButtonById("radioButtonById", prefixId + ".vermoegensuebertragung", harness.getData("Vermoegen", iteration, vermoegensuebertragung), "last()");
        if (harness.getData("Vermoegen", iteration, vermoegensuebertragung).equalsIgnoreCase("Ja")) {
            enterTextBoxById("textBoxById", prefixId + ".datumDerVermoegensuebertragung", harness.getData("Vermoegen", iteration, datumDerVermoegensuebertragung), "last()");
            enterTextBoxById("textBoxById", prefixId + ".hoeheDerVermoegensuebertragung", harness.getData("Vermoegen", iteration, hoeheDerVermoegensuebertragung), "last()");
        }
    }
}