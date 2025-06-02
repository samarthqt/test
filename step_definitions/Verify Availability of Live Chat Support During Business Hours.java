package com.cucumber.steps;

import com.page_objects.LiveChatPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LiveChatSteps extends LiveChatPage {

    @Given("the user is logged into the application using valid credentials")
    public void theUserIsLoggedIntoTheApplicationUsingValidCredentials() {
        loginWithValidCredentials();
    }

    @Given("the live chat feature is enabled")
    public void theLiveChatFeatureIsEnabled() {
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

    @Then("business hours information is visible")
    public void businessHoursInformationIsVisible() {
        verifyBusinessHoursInformationVisible();
    }

    @Then("the live chat support option is visible and accessible")
    public void theLiveChatSupportOptionIsVisibleAndAccessible() {
        verifyLiveChatOptionVisibleAndAccessible();
    }

    @Given("the user locates the live chat support option")
    public void theUserLocatesTheLiveChatSupportOption() {
        locateLiveChatSupportOption();
    }

    @When("the user initiates a live chat session during business hours")
    public void theUserInitiatesALiveChatSessionDuringBusinessHours() {
        initiateLiveChatSession();
    }

    @Then("the live chat session is initiated successfully with an available agent")
    public void theLiveChatSessionIsInitiatedSuccessfullyWithAnAvailableAgent() {
        verifyLiveChatSessionInitiated();
    }

    @Given("a live chat session is initiated")
    public void aLiveChatSessionIsInitiated() {
        verifyLiveChatSessionInitiated();
    }

    @When("the user sends a message to the live chat agent")
    public void theUserSendsAMessageToTheLiveChatAgent() {
        sendMessageToLiveChatAgent();
    }

    @Then("the message is sent successfully")
    public void theMessageIsSentSuccessfully() {
        verifyMessageSentSuccessfully();
    }

    @Then("the agent responds in a timely manner")
    public void theAgentRespondsInATimelyManner() {
        verifyAgentResponseTimely();
    }

    @Given("a message is sent to the live chat agent")
    public void aMessageIsSentToTheLiveChatAgent() {
        verifyMessageSentSuccessfully();
    }

    @When("the agent responds")
    public void theAgentResponds() {
        waitForAgentResponse();
    }

    @Then("the response time is within acceptable limits as per business standards")
    public void theResponseTimeIsWithinAcceptableLimitsAsPerBusinessStandards() {
        verifyResponseTimeWithinLimits();
    }

    @Given("a live chat session is active")
    public void aLiveChatSessionIsActive() {
        verifyLiveChatSessionActive();
    }

    @When("the user receives messages")
    public void theUserReceivesMessages() {
        receiveMessages();
    }

    @Then("automated messages or acknowledgments are appropriate and informative")
    public void automatedMessagesOrAcknowledgmentsAreAppropriateAndInformative() {
        verifyAutomatedMessagesAppropriate();
    }

    @When("the user sends different types of inquiries")
    public void theUserSendsDifferentTypesOfInquiries() {
        sendDifferentTypesOfInquiries();
    }

    @Then("all types of inquiries are handled appropriately by the live chat agent")
    public void allTypesOfInquiriesAreHandledAppropriatelyByTheLiveChatAgent() {
        verifyInquiriesHandledAppropriately();
    }

    @When("the user attempts to end the live chat session")
    public void theUserAttemptsToEndTheLiveChatSession() {
        endLiveChatSession();
    }

    @Then("the live chat session ends successfully with a confirmation message")
    public void theLiveChatSessionEndsSuccessfullyWithAConfirmationMessage() {
        verifyLiveChatSessionEndedSuccessfully();
    }

    @Given("the user has ended a live chat session")
    public void theUserHasEndedALiveChatSession() {
        verifyLiveChatSessionEndedSuccessfully();
    }

    @When("the user re-initiates the live chat session during business hours")
    public void theUserReInitiatesTheLiveChatSessionDuringBusinessHours() {
        reInitiateLiveChatSession();
    }

    @Then("live chat can be re-initiated without issues")
    public void liveChatCanBeReInitiatedWithoutIssues() {
        verifyLiveChatReInitiatedSuccessfully();
    }

    @Given("the user navigates to the support section outside business hours")
    public void theUserNavigatesToTheSupportSectionOutsideBusinessHours() {
        navigateToSupportSectionOutsideBusinessHours();
    }

    @When("the user attempts to initiate a live chat session")
    public void theUserAttemptsToInitiateALiveChatSession() {
        attemptToInitiateLiveChatSession();
    }

    @Then("live chat support is unavailable or provides an appropriate message")
    public void liveChatSupportIsUnavailableOrProvidesAnAppropriateMessage() {
        verifyLiveChatUnavailableOutsideBusinessHours();
    }

    @Given("the user has access to different devices/browsers")
    public void theUserHasAccessToDifferentDevicesBrowsers() {
        accessDifferentDevicesBrowsers();
    }

    @When("the user tests the live chat feature on these devices/browsers")
    public void theUserTestsTheLiveChatFeatureOnTheseDevicesBrowsers() {
        testLiveChatOnDifferentDevicesBrowsers();
    }

    @Then("live chat is accessible and functional across different devices/browsers")
    public void liveChatIsAccessibleAndFunctionalAcrossDifferentDevicesBrowsers() {
        verifyLiveChatAccessibleOnAllDevicesBrowsers();
    }

    @Given("the user has a slow internet connection")
    public void theUserHasASlowInternetConnection() {
        simulateSlowInternetConnection();
    }

    @When("the user initiates a live chat session")
    public void theUserInitiatesALiveChatSession() {
        initiateLiveChatSession();
    }

    @Then("live chat remains functional, albeit with possible delays")
    public void liveChatRemainsFunctionalAlbeitWithPossibleDelays() {
        verifyLiveChatFunctionalWithDelays();
    }

    @Given("the user has completed a live chat session")
    public void theUserHasCompletedALiveChatSession() {
        verifyLiveChatSessionCompleted();
    }

    @When("the user checks the session history")
    public void theUserChecksTheSessionHistory() {
        checkLiveChatSessionHistory();
    }

    @Then("chat history is saved and accessible for future reference")
    public void chatHistoryIsSavedAndAccessibleForFutureReference() {
        verifyChatHistorySaved();
    }

    @When("the user monitors for errors")
    public void theUserMonitorsForErrors() {
        monitorForErrorsDuringLiveChat();
    }

    @Then("no error messages or logs indicate issues during live chat sessions")
    public void noErrorMessagesOrLogsIndicateIssuesDuringLiveChatSessions() {
        verifyNoErrorsDuringLiveChat();
    }
}