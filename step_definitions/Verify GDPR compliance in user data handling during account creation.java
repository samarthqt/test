package com.cucumber.steps;

import com.page_objects.AccountCreationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountCreationSteps extends AccountCreationPage {

    @Given("the user navigates to the account creation page")
    public void theUserNavigatesToTheAccountCreationPage() {
        navigateToAccountCreationPage();
    }

    @Then("the account creation page is displayed")
    public void theAccountCreationPageIsDisplayed() {
        verifyAccountCreationPageDisplayed();
    }

    @Given("the user is on the account creation page")
    public void theUserIsOnTheAccountCreationPage() {
        verifyAccountCreationPageDisplayed();
    }

    @When("the user enters personal information into the required fields")
    public void theUserEntersPersonalInformationIntoTheRequiredFields() {
        enterPersonalInformation();
    }

    @Then("personal information is entered successfully")
    public void personalInformationIsEnteredSuccessfully() {
        verifyPersonalInformationEntered();
    }

    @Then("a consent checkbox for data processing is available and unchecked by default")
    public void aConsentCheckboxForDataProcessingIsAvailableAndUncheckedByDefault() {
        verifyConsentCheckboxAvailableAndUnchecked();
    }

    @When("the user attempts to proceed without checking the consent box")
    public void theUserAttemptsToProceedWithoutCheckingTheConsentBox() {
        attemptToProceedWithoutConsent();
    }

    @Then("the system prevents proceeding without consent")
    public void theSystemPreventsProceedingWithoutConsent() {
        verifyProceedingPreventedWithoutConsent();
    }

    @When("the user checks the consent box and proceeds")
    public void theUserChecksTheConsentBoxAndProceeds() {
        checkConsentBoxAndProceed();
    }

    @Then("the user is allowed to proceed with account creation")
    public void theUserIsAllowedToProceedWithAccountCreation() {
        verifyAllowedToProceedWithAccountCreation();
    }

    @Then("the privacy policy is accessible and details GDPR compliance")
    public void thePrivacyPolicyIsAccessibleAndDetailsGDPRCompliance() {
        verifyPrivacyPolicyAccessible();
    }

    @Given("the user has checked the consent box")
    public void theUserHasCheckedTheConsentBox() {
        verifyConsentBoxChecked();
    }

    @When("the user completes the account creation process")
    public void theUserCompletesTheAccountCreationProcess() {
        completeAccountCreationProcess();
    }

    @Then("the account is created successfully with GDPR compliance")
    public void theAccountIsCreatedSuccessfullyWithGDPRCompliance() {
        verifyAccountCreatedWithGDPRCompliance();
    }

    @Given("the user has created an account")
    public void theUserHasCreatedAnAccount() {
        verifyAccountCreated();
    }

    @Then("user data is stored securely and in compliance with GDPR")
    public void userDataIsStoredSecurelyAndInComplianceWithGDPR() {
        verifyUserDataStoredSecurely();
    }

    @Given("the user has an account")
    public void theUserHasAnAccount() {
        verifyAccountExists();
    }

    @Then("the option to request data deletion is available")
    public void theOptionToRequestDataDeletionIsAvailable() {
        verifyDataDeletionOptionAvailable();
    }

    @Given("the user requests data deletion")
    public void theUserRequestsDataDeletion() {
        requestDataDeletion();
    }

    @Then("user data is deleted upon request in compliance with GDPR")
    public void userDataIsDeletedUponRequestInComplianceWithGDPR() {
        verifyUserDataDeleted();
    }

    @Then("access logs show compliant handling of user data")
    public void accessLogsShowCompliantHandlingOfUserData() {
        verifyAccessLogsCompliant();
    }

    @Given("there is user data stored")
    public void thereIsUserDataStored() {
        verifyUserDataStored();
    }

    @When("a user attempts to access user data without consent")
    public void aUserAttemptsToAccessUserDataWithoutConsent() {
        attemptAccessWithoutConsent();
    }

    @Then("access is denied without user consent")
    public void accessIsDeniedWithoutUserConsent() {
        verifyAccessDeniedWithoutConsent();
    }

    @Given("the system stores user data")
    public void theSystemStoresUserData() {
        verifySystemStoresUserData();
    }

    @Then("no data breaches or vulnerabilities are detected")
    public void noDataBreachesOrVulnerabilitiesAreDetected() {
        verifyNoDataBreaches();
    }

    @Given("the system operates in different regions")
    public void theSystemOperatesInDifferentRegions() {
        verifySystemOperatesInDifferentRegions();
    }

    @Then("the system complies with GDPR across different regions")
    public void theSystemCompliesWithGDPRAcrossDifferentRegions() {
        verifyGDPRComplianceAcrossRegions();
    }

    @Given("the system transfers user data")
    public void theSystemTransfersUserData() {
        verifySystemTransfersUserData();
    }

    @Then("data transfer complies with GDPR requirements")
    public void dataTransferCompliesWithGDPRRequirements() {
        verifyDataTransferGDPRCompliance();
    }
}