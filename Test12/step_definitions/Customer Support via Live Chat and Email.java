package com.cucumber.steps;

import com.page_objects.SupportPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SupportSteps extends SupportPage {

    @Given("the user is on the support page")
    public void theUserIsOnTheSupportPage() {
        navigateToSupportPage();
    }

    @When("the user selects the live chat option")
    public void theUserSelectsTheLiveChatOption() {
        selectLiveChatOption();
    }

    @Then("the user should be able to access live chat support easily")
    public void theUserShouldBeAbleToAccessLiveChatSupportEasily() {
        verifyLiveChatAccess();
    }

    @When("the user selects the email support option")
    public void theUserSelectsTheEmailSupportOption() {
        selectEmailSupportOption();
    }

    @Then("the user should be able to send detailed inquiries via email")
    public void theUserShouldBeAbleToSendDetailedInquiriesViaEmail() {
        verifyEmailSupportAccess();
    }

    @Given("a user interaction occurs through live chat or email")
    public void aUserInteractionOccursThroughLiveChatOrEmail() {
        initiateSupportInteraction();
    }

    @When("the interaction is completed")
    public void theInteractionIsCompleted() {
        completeSupportInteraction();
    }

    @Then("the interaction should be logged for quality assurance")
    public void theInteractionShouldBeLoggedForQualityAssurance() {
        verifyInteractionLogging();
    }

    @Given("the user has submitted a support inquiry")
    public void theUserHasSubmittedASupportInquiry() {
        submitSupportInquiry();
    }

    @When("a support response is sent")
    public void aSupportResponseIsSent() {
        sendSupportResponse();
    }

    @Then("the user should receive a notification for the support response")
    public void theUserShouldReceiveANotificationForTheSupportResponse() {
        verifySupportResponseNotification();
    }

    @Given("a support interaction fails")
    public void aSupportInteractionFails() {
        simulateSupportInteractionFailure();
    }

    @When("the failure occurs")
    public void theFailureOccurs() {
        triggerFailure();
    }

    @Then("an error message should be displayed to the user")
    public void anErrorMessageShouldBeDisplayedToTheUser() {
        verifyErrorMessageDisplay();
    }

    @When("the user interacts with the support interface")
    public void theUserInteractsWithTheSupportInterface() {
        interactWithSupportInterface();
    }

    @Then("the interface should be user-friendly and guide the user through the support process")
    public void theInterfaceShouldBeUserFriendlyAndGuideTheUserThroughTheSupportProcess() {
        verifyUserFriendlyInterface();
    }

    @Given("the application provides customer support")
    public void theApplicationProvidesCustomerSupport() {
        initializeCustomerSupport();
    }

    @When("support interactions occur")
    public void supportInteractionsOccur() {
        performSupportInteractions();
    }

    @Then("support should comply with data privacy and security standards")
    public void supportShouldComplyWithDataPrivacyAndSecurityStandards() {
        verifyDataPrivacyCompliance();
    }

    @When("the user selects a language preference")
    public void theUserSelectsALanguagePreference() {
        selectLanguagePreference();
    }

    @Then("the application should support multi-language communication")
    public void theApplicationShouldSupportMultiLanguageCommunication() {
        verifyMultiLanguageSupport();
    }

    @Given("the user needs support")
    public void theUserNeedsSupport() {
        identifySupportNeed();
    }

    @When("the user attempts to access support")
    public void theUserAttemptsToAccessSupport() {
        attemptSupportAccess();
    }

    @Then("support should be available during specified hours")
    public void supportShouldBeAvailableDuringSpecifiedHours() {
        verifySupportAvailability();
    }

    @Given("the user is interacting with support")
    public void theUserIsInteractingWithSupport() {
        initiateSupportInteraction();
    }

    @When("the user sends a request or inquiry")
    public void theUserSendsARequestOrInquiry() {
        sendSupportRequest();
    }

    @Then("support should be optimized for performance and responsiveness")
    public void supportShouldBeOptimizedForPerformanceAndResponsiveness() {
        verifySupportPerformance();
    }
}