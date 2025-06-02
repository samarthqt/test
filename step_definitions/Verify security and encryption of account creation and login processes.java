package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.AccountPage;
import com.page_objects.LoginPage;

public class SecuritySteps extends AccountPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I navigate to the account creation page")
    public void iNavigateToTheAccountCreationPage() {
        navigateToAccountCreationPage();
    }

    @Then("the account creation page is displayed with SSL/TLS encryption active")
    public void theAccountCreationPageIsDisplayedWithSSLTlsEncryptionActive() {
        verifySSLTlsEncryption();
    }

    @Given("I am on the account creation page")
    public void iAmOnTheAccountCreationPage() {
        navigateToAccountCreationPage();
    }

    @When("I enter a valid email {string} and password {string}")
    public void iEnterAValidEmailAndPassword(String email, String password) {
        enterEmail(email);
        enterPassword(password);
    }

    @Then("the email and password fields are populated securely")
    public void theEmailAndPasswordFieldsArePopulatedSecurely() {
        verifySecureFieldPopulation();
    }

    @Given("I have entered valid account creation details")
    public void iHaveEnteredValidAccountCreationDetails() {
        enterValidAccountDetails();
    }

    @When("I complete the account creation process")
    public void iCompleteTheAccountCreationProcess() {
        completeAccountCreation();
    }

    @Then("the account is created successfully with encrypted data")
    public void theAccountIsCreatedSuccessfullyWithEncryptedData() {
        verifyAccountCreationWithEncryption();
    }

    @Given("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        navigateToLoginPage();
    }

    @Then("the login page is displayed with SSL/TLS encryption active")
    public void theLoginPageIsDisplayedWithSSLTlsEncryptionActive() {
        verifySSLTlsEncryption();
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        navigateToLoginPage();
    }

    @When("I enter valid login credentials")
    public void iEnterValidLoginCredentials() {
        String username = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        enterUserName(username);
        enterPassword(password);
    }

    @Then("the credentials are entered securely")
    public void theCredentialsAreEnteredSecurely() {
        verifySecureCredentialEntry();
    }

    @Given("I have entered valid login credentials")
    public void iHaveEnteredValidLoginCredentials() {
        enterValidLoginCredentials();
    }

    @When("I log in to the application")
    public void iLogInToTheApplication() {
        clickLoginButton();
    }

    @Then("the user is logged in successfully with encrypted data transmission")
    public void theUserIsLoggedInSuccessfullyWithEncryptedDataTransmission() {
        verifyLoginWithEncryption();
    }

    @Given("I am logged into the application")
    public void iAmLoggedIntoTheApplication() {
        logIntoApplication();
    }

    @When("I verify the encryption of data during login")
    public void iVerifyTheEncryptionOfDataDuringLogin() {
        verifyDataEncryptionDuringLogin();
    }

    @Then("the data is transmitted securely with encryption")
    public void theDataIsTransmittedSecurelyWithEncryption() {
        verifySecureDataTransmission();
    }

    @When("I attempt to login with an incorrect password")
    public void iAttemptToLoginWithAnIncorrectPassword() {
        enterIncorrectPassword();
    }

    @Then("an error message is displayed with secure data handling")
    public void anErrorMessageIsDisplayedWithSecureDataHandling() {
        verifySecureErrorMessage();
    }

    @When("I check server logs for encrypted data transmission")
    public void iCheckServerLogsForEncryptedDataTransmission() {
        checkServerLogsForEncryption();
    }

    @Then("the server logs show encrypted data transmission during login")
    public void theServerLogsShowEncryptedDataTransmissionDuringLogin() {
        verifyServerLogEncryption();
    }

    @When("I attempt account creation with a weak password")
    public void iAttemptAccountCreationWithAWeakPassword() {
        enterWeakPassword();
    }

    @Then("the system prompts for a stronger password")
    public void theSystemPromptsForAStrongerPassword() {
        verifyPasswordStrengthPrompt();
    }

    @When("I verify encryption compliance with industry standards")
    public void iVerifyEncryptionComplianceWithIndustryStandards() {
        verifyEncryptionCompliance();
    }

    @Then("encryption meets industry standards for security")
    public void encryptionMeetsIndustryStandardsForSecurity() {
        verifyIndustryStandardEncryption();
    }

    @When("I check for security vulnerabilities in the login process")
    public void iCheckForSecurityVulnerabilitiesInTheLoginProcess() {
        checkLoginSecurityVulnerabilities();
    }

    @Then("no security vulnerabilities are detected in the login process")
    public void noSecurityVulnerabilitiesAreDetectedInTheLoginProcess() {
        verifyNoSecurityVulnerabilities();
    }

    @When("I log out of the application")
    public void iLogOutOfTheApplication() {
        logOutOfApplication();
    }

    @Then("the logout process securely terminates the user session")
    public void theLogoutProcessSecurelyTerminatesTheUserSession() {
        verifySecureLogout();
    }

    @Given("I am on the login page on a different device")
    public void iAmOnTheLoginPageOnADifferentDevice() {
        navigateToLoginPageOnDifferentDevice();
    }

    @When("I enter valid login credentials")
    public void iEnterValidLoginCredentialsOnDifferentDevice() {
        enterValidLoginCredentials();
    }

    @Then("login is successful with secure data transmission")
    public void loginIsSuccessfulWithSecureDataTransmission() {
        verifyLoginWithSecureTransmission();
    }

    @When("I check for security alerts during login attempts")
    public void iCheckForSecurityAlertsDuringLoginAttempts() {
        checkSecurityAlertsDuringLogin();
    }

    @Then("security alerts are triggered for suspicious login attempts")
    public void securityAlertsAreTriggeredForSuspiciousLoginAttempts() {
        verifySecurityAlerts();
    }
}