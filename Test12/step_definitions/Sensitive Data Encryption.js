import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import EncryptionPage from "../pages/encryptionPage";

Given("the application handles sensitive data", () => {
 EncryptionPage.verifySensitiveDataHandling();
});

When("sensitive data is transmitted", () => {
 EncryptionPage.transmitSensitiveData();
});

Then("the data should be encrypted using SSL/TLS protocols", () => {
 EncryptionPage.verifyDataEncryption();
});

Given("the application stores passwords, payment details, and sensitive information", () => {
 EncryptionPage.verifySensitiveInformationStorage();
});

When("data is stored or transmitted", () => {
 EncryptionPage.storeOrTransmitData();
});

Then("encryption should be applied to passwords, payment details, and any other sensitive information", () => {
 EncryptionPage.verifyComprehensiveEncryption();
});

Given("the application has implemented encryption protocols", () => {
 EncryptionPage.verifyEncryptionProtocols();
});

When("a security audit is conducted", () => {
 EncryptionPage.conductSecurityAudit();
});

Then("the audit should confirm that the encryption standards are met", () => {
 EncryptionPage.verifyAuditResults();
});

Given("the application has encrypted sensitive data", () => {
 EncryptionPage.verifyEncryptedData();
});

When("an unauthorized user attempts to access the data", () => {
 EncryptionPage.attemptUnauthorizedAccess();
});

Then("the application should prevent access to the encrypted data", () => {
 EncryptionPage.verifyAccessPrevention();
});

Given("the application uses encryption keys", () => {
 EncryptionPage.verifyEncryptionKeyUsage();
});

When("encryption keys are generated", () => {
 EncryptionPage.generateEncryptionKeys();
});

Then("the keys must be securely managed and stored", () => {
 EncryptionPage.verifyKeyManagementAndStorage();
});