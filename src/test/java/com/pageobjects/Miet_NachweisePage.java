package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.framework.reusable.WebReusableComponents;
import com.framework.cucumber.TestHarness;
import java.util.*;

public class Miet_NachweisePage extends WebReusableComponents {

    protected By uploadFileNachweiseById = By.id("uploadFileNachweiseById");
    protected By labelManageAttachments = By.id("labelManageAttachments");
    protected By attachmentClose = By.id("attachmentClose");

    protected TestHarness harness = new TestHarness();
    protected String sheetName = "Nachweise";
    protected String mietschulden = "Mietschulden";
    protected String vermietung = "Vermietung";
    protected String vermoegen = "Einkommen und Vermoegen";

    public Miet_NachweisePage() {
        PageFactory.initElements(driver, this);
    }

    public void nachweise() {
        uploadFileIfNotEmpty("Mietvertrag/Mietbescheinigung", "UvM_Att_MietVertrag");
        uploadFileIfNotEmpty("Höhe der Mietschulden", "UvM_Att_Mietschulden");
        uploadFileIfNotEmpty("Nebenkostenabrechnung", "UvM_Att_MietNebenkosten");
        uploadFileIfNotEmpty("Einkommensnachweise aller im Haushalt lebender Personen", "UvM_Att_Einkommen");
        uploadFileIfNotEmpty("Auflistung von Ausgaben aller im Haushalt lebender Personen", "UvM_Att_Ausgaben");
        uploadFileIfNotEmpty("Kontoauszüge der letzten 3 Monate aller im Haushalt lebender Personen", "UvM_Att_Konto");

        conditionalUpload(mietschulden, "Mahnung", "UvM_Att_Mahnung");
        conditionalUpload(mietschulden, "Kündigung", "UvM_Att_Kuendigung");
        conditionalUpload(mietschulden, "Räumungsklage", "UvM_Att_Raeumung");
        conditionalUpload(mietschulden, "Räumungsklage zurückzunehmen", "UvM_Att_RaeumungRuecknahme");
        conditionalUpload(mietschulden, "Räumungstitel", "UvM_Att_RaeumungTitel");
        conditionalUpload(mietschulden, "Gibt es einen Räumungstermin?", "UvM_Att_RaeumungTermin");
        conditionalUpload(mietschulden, "Räumung verzuzichten", "UvM_Att_RaeumungVerzicht");

        if (harness.getData(mietschulden, "Keine Ratenzahlung").equalsIgnoreCase("Der Vermieter oder die Vermieterin lehnt eine Ratenzahlung ab.")) {
            uploadFileIfNotEmpty("Ablehnung einer Ratenzahlung", "UvM_Att_RatenzahlungAblehnung");
        }

        if (!harness.getData(vermietung, "Sonstige Kosten").isEmpty()) {
            uploadFileIfNotEmpty("Nachweis für sonstige Kosten", "UvM_Att_KostenSonstige");
        }

        conditionalUpload(vermoegen, "Bankguthaben", "UvM_Att_VermoegenBank");
        conditionalUpload(vermoegen, "Sparguthaben", "UvM_Att_VermoegenSpar");
    }

    public void uploadFileIfNotEmpty(String dataKey, String attachmentId) {
        if (!harness.getData(sheetName, dataKey).isEmpty()) {
            uploadFileInNachweise("uploadFileNachweiseById", attachmentId, harness.getData(sheetName, dataKey));
            Assert.assertTrue(isLabelManageAttachments());
            clickAttachmentClose();
        }
    }

    public void conditionalUpload(String section, String conditionKey, String attachmentId) {
        if (harness.getData(section, conditionKey).equalsIgnoreCase("Ja")) {
            uploadFileIfNotEmpty(conditionKey, attachmentId);
        }
    }

    public void uploadFileInNachweise(String locatorId, String attachmentId, String filePath) {
        waitUntilElementVisible(By.id(locatorId), 3);
        enterText(By.id(attachmentId), filePath);
    }

    public boolean isLabelManageAttachments() {
        waitUntilElementVisible(labelManageAttachments, 3);
        return isElementDisplayed(labelManageAttachments);
    }

    public void clickAttachmentClose() {
        waitUntilElementVisible(attachmentClose, 3);
        clickElement(attachmentClose);
    }
}