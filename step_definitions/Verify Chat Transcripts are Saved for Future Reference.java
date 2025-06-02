package com.cucumber.steps;

import com.page_objects.ChatTranscriptPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChatTranscriptSteps extends ChatTranscriptPage {

    @Given("the user is logged into the application using valid credentials")
    public void theUserIsLoggedIntoTheApplicationUsingValidCredentials() {
        loginToApplication();
    }

    @Given("the live chat feature is enabled and functional")
    public void theLiveChatFeatureIsEnabledAndFunctional() {
        verifyLiveChatFeatureEnabled();
    }

    @When("the user navigates to the support or help section of the application")
    public void theUserNavigatesToTheSupportOrHelpSectionOfTheApplication() {
        navigateToSupportSection();
    }

    @Then("the support section is displayed with all available options")
    public void theSupportSectionIsDisplayedWithAllAvailableOptions() {
        verifySupportSectionDisplayed();
    }

    @Given("the user initiates a live chat session")
    public void theUserInitiatesALiveChatSession() {
        initiateLiveChatSession();
    }

    @Then("the live chat session is initiated successfully with an available agent")
    public void theLiveChatSessionIsInitiatedSuccessfullyWithAnAvailableAgent() {
        verifyLiveChatSessionInitiated();
    }

    @When("the user engages in a conversation with the live chat agent")
    public void theUserEngagesInAConversationWithTheLiveChatAgent() {
        engageInConversation();
    }

    @Then("the conversation is carried out successfully")
    public void theConversationIsCarriedOutSuccessfully() {
        verifyConversationSuccess();
    }

    @When("the user ends the live chat session")
    public void theUserEndsTheLiveChatSession() {
        endLiveChatSession();
    }

    @Then("the live chat session ends successfully with a confirmation message")
    public void theLiveChatSessionEndsSuccessfullyWithAConfirmationMessage() {
        verifyLiveChatSessionEnded();
    }

    @Given("the user navigates to the chat history or transcripts section")
    public void theUserNavigatesToTheChatHistoryOrTranscriptsSection() {
        navigateToChatHistorySection();
    }

    @Then("the chat history section is displayed with all past chat sessions listed")
    public void theChatHistorySectionIsDisplayedWithAllPastChatSessionsListed() {
        verifyChatHistoryDisplayed();
    }

    @When("the user selects the most recent chat session to view the transcript")
    public void theUserSelectsTheMostRecentChatSessionToViewTheTranscript() {
        selectRecentChatSession();
    }

    @Then("the transcript of the selected chat session is displayed accurately")
    public void theTranscriptOfTheSelectedChatSessionIsDisplayedAccurately() {
        verifyTranscriptDisplayed();
    }

    @Given("the user views the chat transcript")
    public void theUserViewsTheChatTranscript() {
        viewChatTranscript();
    }

    @Then("the chat transcript is accurate and complete, reflecting the entire conversation")
    public void theChatTranscriptIsAccurateAndCompleteReflectingTheEntireConversation() {
        verifyTranscriptAccuracy();
    }

    @Given("the user checks for options to download or print the chat transcript")
    public void theUserChecksForOptionsToDownloadOrPrintTheChatTranscript() {
        checkDownloadPrintOptions();
    }

    @Then("options to download or print the chat transcript are available and functional")
    public void optionsToDownloadOrPrintTheChatTranscriptAreAvailableAndFunctional() {
        verifyDownloadPrintOptions();
    }

    @Given("the user attempts to access chat transcripts on a different device/browser")
    public void theUserAttemptsToAccessChatTranscriptsOnADifferentDeviceBrowser() {
        accessTranscriptsOnDifferentDevice();
    }

    @Then("chat transcripts are accessible across different devices/browsers")
    public void chatTranscriptsAreAccessibleAcrossDifferentDevicesBrowsers() {
        verifyTranscriptsAccessibility();
    }

    @Given("the user verifies the security and privacy of chat transcripts")
    public void theUserVerifiesTheSecurityAndPrivacyOfChatTranscripts() {
        verifySecurityPrivacy();
    }

    @Then("chat transcripts are secured and accessible only to authorized users")
    public void chatTranscriptsAreSecuredAndAccessibleOnlyToAuthorizedUsers() {
        verifyTranscriptsSecurity();
    }

    @Given("the user checks the retention period for chat transcripts")
    public void theUserChecksTheRetentionPeriodForChatTranscripts() {
        checkRetentionPeriod();
    }

    @Then("chat transcripts are retained for the specified period as per the policy")
    public void chatTranscriptsAreRetainedForTheSpecifiedPeriodAsPerThePolicy() {
        verifyRetentionPeriod();
    }

    @Given("the user tests the chat transcript feature with a slow internet connection")
    public void theUserTestsTheChatTranscriptFeatureWithASlowInternetConnection() {
        testWithSlowInternet();
    }

    @Then("chat transcripts are accessible, albeit with possible delays")
    public void chatTranscriptsAreAccessibleAlbeitWithPossibleDelays() {
        verifyAccessibilityWithDelays();
    }

    @Given("the user verifies the chat transcript feature with different types of chat sessions \(e.g., resolved, unresolved\)")
    public void theUserVerifiesTheChatTranscriptFeatureWithDifferentTypesOfChatSessions() {
        verifyTranscriptFeatureWithDifferentSessions();
    }

    @Then("all types of chat sessions have transcripts saved and accessible")
    public void allTypesOfChatSessionsHaveTranscriptsSavedAndAccessible() {
        verifyTranscriptsForAllSessions();
    }

    @Given("the user checks for any error messages or logs during chat transcript retrieval")
    public void theUserChecksForAnyErrorMessagesOrLogsDuringChatTranscriptRetrieval() {
        checkForErrorMessages();
    }

    @Then("no error messages or logs indicate issues during chat transcript retrieval")
    public void noErrorMessagesOrLogsIndicateIssuesDuringChatTranscriptRetrieval() {
        verifyNoErrorMessages();
    }
}