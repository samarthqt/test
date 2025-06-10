package com.cucumber.steps;

import com.page_objects.GDPRCompliancePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GDPRComplianceSteps extends GDPRCompliancePage {

    @Given("the application is running")
    public void theApplicationIsRunning() {
        verifyApplicationRunning();
    }

    @When("user data is stored in the application")
    public void userDataIsStoredInTheApplication() {
        storeUserData();
    }

    @Then("the data must be stored in compliance with GDPR guidelines")
    public void theDataMustBeStoredInComplianceWithGDPRGuidelines() {
        verifyDataStorageCompliance();
    }

    @When("user data is processed")
    public void userDataIsProcessed() {
        processUserData();
    }

    @Then("the processing must adhere to GDPR guidelines")
    public void theProcessingMustAdhereToGDPRGuidelines() {
        verifyDataProcessingCompliance();
    }

    @When("user data is accessed")
    public void userDataIsAccessed() {
        accessUserData();
    }

    @Then("the access must comply with GDPR guidelines")
    public void theAccessMustComplyWithGDPRGuidelines() {
        verifyDataAccessCompliance();
    }

    @Given("a user accesses their account")
    public void aUserAccessesTheirAccount() {
        accessUserAccount();
    }

    @When("the user navigates to the privacy settings")
    public void theUserNavigatesToThePrivacySettings() {
        navigateToPrivacySettings();
    }

    @Then("the application must display information about their rights regarding data privacy")
    public void theApplicationMustDisplayInformationAboutTheirRightsRegardingDataPrivacy() {
        displayPrivacyRightsInformation();
    }

    @Then("the user must be informed about how their data is being used")
    public void theUserMustBeInformedAboutHowTheirDataIsBeingUsed() {
        informDataUsage();
    }

    @Given("the application is operational")
    public void theApplicationIsOperational() {
        verifyApplicationOperational();
    }

    @When("a data protection impact assessment is scheduled")
    public void aDataProtectionImpactAssessmentIsScheduled() {
        scheduleDataProtectionImpactAssessment();
    }

    @Then("the assessment must be conducted regularly")
    public void theAssessmentMustBeConductedRegularly() {
        conductRegularAssessment();
    }

    @Then("the results must be documented and reviewed")
    public void theResultsMustBeDocumentedAndReviewed() {
        documentAndReviewResults();
    }

    @When("the user navigates to the consent management section")
    public void theUserNavigatesToTheConsentManagementSection() {
        navigateToConsentManagement();
    }

    @Then("the application must provide tools for managing consent")
    public void theApplicationMustProvideToolsForManagingConsent() {
        provideConsentManagementTools();
    }

    @Then("the user should be able to easily give or withdraw consent")
    public void theUserShouldBeAbleToEasilyGiveOrWithdrawConsent() {
        manageUserConsent();
    }
}