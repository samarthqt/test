package com.cucumber.steps;

import com.page_objects.EncryptionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EncryptionSteps extends EncryptionPage {

    @Given("the application handles sensitive data")
    public void theApplicationHandlesSensitiveData() {
        verifySensitiveDataHandling();
    }

    @When("sensitive data is transmitted")
    public void sensitiveDataIsTransmitted() {
        transmitSensitiveData();
    }

    @Then("the data should be encrypted using SSL/TLS protocols")
    public void theDataShouldBeEncryptedUsingSSLTLSProtocols() {
        verifyDataEncryption();
    }

    @Given("the application stores passwords, payment details, and sensitive information")
    public void theApplicationStoresSensitiveInformation() {
        verifySensitiveInformationStorage();
    }

    @When("data is stored or transmitted")
    public void dataIsStoredOrTransmitted() {
        storeOrTransmitData();
    }

    @Then("encryption should be applied to passwords, payment details, and any other sensitive information")
    public void encryptionShouldBeAppliedToSensitiveInformation() {
        verifyEncryptionApplication();
    }

    @Given("the application has implemented encryption protocols")
    public void theApplicationHasImplementedEncryptionProtocols() {
        verifyEncryptionProtocolsImplementation();
    }

    @When("a security audit is conducted")
    public void aSecurityAuditIsConducted() {
        conductSecurityAudit();
    }

    @Then("the audit should confirm that the encryption standards are met")
    public void theAuditShouldConfirmEncryptionStandards() {
        verifyAuditConfirmation();
    }

    @Given("the application has encrypted sensitive data")
    public void theApplicationHasEncryptedSensitiveData() {
        verifySensitiveDataEncryption();
    }

    @When("an unauthorized user attempts to access the data")
    public void unauthorizedUserAttemptsToAccessData() {
        attemptUnauthorizedAccess();
    }

    @Then("the application should prevent access to the encrypted data")
    public void theApplicationShouldPreventAccessToEncryptedData() {
        verifyAccessPrevention();
    }

    @Given("the application uses encryption keys")
    public void theApplicationUsesEncryptionKeys() {
        verifyEncryptionKeysUsage();
    }

    @When("encryption keys are generated")
    public void encryptionKeysAreGenerated() {
        generateEncryptionKeys();
    }

    @Then("the keys must be securely managed and stored")
    public void theKeysMustBeSecurelyManagedAndStored() {
        verifyKeysManagementAndStorage();
    }
}