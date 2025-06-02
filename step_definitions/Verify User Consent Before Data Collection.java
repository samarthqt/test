package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.UserConsentPage;

public class UserConsentSteps extends UserConsentPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user account is active with User ID: {int}")
    public void theUserAccountIsActiveWithUserID(int userId) {
        verifyUserAccountActive(userId);
    }

    @When("the user navigates to account settings")
    public void theUserNavigatesToAccountSettings() {
        navigateToAccountSettings();
    }

    @Then("the user account settings page is displayed")
    public void theUserAccountSettingsPageIsDisplayed() {
        verifyAccountSettingsPageDisplayed();
    }

    @Then("a consent form must be available")
    public void aConsentFormMustBeAvailable() {
        verifyConsentFormAvailable();
    }

    @Given("the user is on the account settings page")
    public void theUserIsOnTheAccountSettingsPage() {
        verifyOnAccountSettingsPage();
    }

    @When("the user locates the consent section")
    public void theUserLocatesTheConsentSection() {
        locateConsentSection();
    }

    @Then("the consent section is visible with options")
    public void theConsentSectionIsVisibleWithOptions() {
        verifyConsentSectionVisible();
    }

    @Then("the consent form version is {double}")
    public void theConsentFormVersionIs(double version) {
        verifyConsentFormVersion(version);
    }

    @When("the user selects the option to provide consent")
    public void theUserSelectsTheOptionToProvideConsent() {
        selectConsentOption();
    }

    @Then("the consent option is selected")
    public void theConsentOptionIsSelected() {
        verifyConsentOptionSelected();
    }

    @Then("the consent status is 'Not Given'")
    public void theConsentStatusIsNotGiven() {
        verifyConsentStatusNotGiven();
    }

    @When("the user submits the consent form")
    public void theUserSubmitsTheConsentForm() {
        submitConsentForm();
    }

    @Then("the consent form is submitted successfully")
    public void theConsentFormIsSubmittedSuccessfully() {
        verifyConsentFormSubmitted();
    }

    @Given("the consent form is submitted successfully")
    public void theConsentFormIsSubmittedSuccessfullyGiven() {
        verifyConsentFormSubmitted();
    }

    @When("the user verifies the status of consent in the user profile")
    public void theUserVerifiesTheStatusOfConsentInTheUserProfile() {
        verifyConsentStatusInProfile();
    }

    @Then("the consent status is updated to 'Given'")
    public void theConsentStatusIsUpdatedToGiven() {
        verifyConsentStatusUpdatedToGiven();
    }

    @When("the user attempts to collect data")
    public void theUserAttemptsToCollectData() {
        attemptDataCollection();
    }

    @Then("data collection proceeds as consent is given")
    public void dataCollectionProceedsAsConsentIsGiven() {
        verifyDataCollectionProceeds();
    }

    @Then("the consent record is logged with a timestamp")
    public void theConsentRecordIsLoggedWithATimestamp() {
        verifyConsentRecordLogged();
    }

    @Given("data collection proceeds")
    public void dataCollectionProceeds() {
        verifyDataCollectionProceeds();
    }

    @When("the user verifies data processing initiation")
    public void theUserVerifiesDataProcessingInitiation() {
        verifyDataProcessingInitiation();
    }

    @Then("data processing starts as per the consent")
    public void dataProcessingStartsAsPerTheConsent() {
        verifyDataProcessingStarts();
    }

    @When("the user checks for consent confirmation notification")
    public void theUserChecksForConsentConfirmationNotification() {
        checkConsentConfirmationNotification();
    }

    @Then("the user receives confirmation notification")
    public void theUserReceivesConfirmationNotification() {
        verifyConfirmationNotificationReceived();
    }

    @Given("the user receives confirmation notification")
    public void theUserReceivesConfirmationNotificationGiven() {
        verifyConfirmationNotificationReceived();
    }

    @When("the user verifies the audit trail for consent")
    public void theUserVerifiesTheAuditTrailForConsent() {
        verifyAuditTrailForConsent();
    }

    @Then("the audit trail includes consent details")
    public void theAuditTrailIncludesConsentDetails() {
        verifyAuditTrailIncludesConsentDetails();
    }

    @Given("the user can revoke consent")
    public void theUserCanRevokeConsent() {
        verifyUserCanRevokeConsent();
    }

    @When("the user revokes consent successfully")
    public void theUserRevokesConsentSuccessfully() {
        revokeConsent();
    }

    @Then("the user attempts data collection after revoking consent")
    public void theUserAttemptsDataCollectionAfterRevokingConsent() {
        attemptDataCollectionAfterRevocation();
    }

    @Then("data collection is blocked as consent is revoked")
    public void dataCollectionIsBlockedAsConsentIsRevoked() {
        verifyDataCollectionBlocked();
    }

    @Given("data collection is blocked")
    public void dataCollectionIsBlocked() {
        verifyDataCollectionBlocked();
    }

    @When("the user checks system response to consent revocation")
    public void theUserChecksSystemResponseToConsentRevocation() {
        checkSystemResponseToRevocation();
    }

    @Then("the system updates consent status to 'Revoked'")
    public void theSystemUpdatesConsentStatusToRevoked() {
        verifyConsentStatusRevoked();
    }

    @When("the user verifies notification for consent revocation")
    public void theUserVerifiesNotificationForConsentRevocation() {
        verifyNotificationForRevocation();
    }

    @Then("the user receives notification of consent revocation")
    public void theUserReceivesNotificationOfConsentRevocation() {
        verifyRevocationNotificationReceived();
    }

    @Given("the user receives notification of consent revocation")
    public void theUserReceivesNotificationOfConsentRevocationGiven() {
        verifyRevocationNotificationReceived();
    }

    @When("the user checks audit trail for consent revocation")
    public void theUserChecksAuditTrailForConsentRevocation() {
        checkAuditTrailForRevocation();
    }

    @Then("the audit trail includes revocation details")
    public void theAuditTrailIncludesRevocationDetails() {
        verifyAuditTrailIncludesRevocationDetails();
    }
}