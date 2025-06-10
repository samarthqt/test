package com.cucumber.steps;

import com.page_objects.LiveChatPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LiveChatSteps extends LiveChatPage {

    @Given("the user is on the web platform")
    public void theUserIsOnTheWebPlatform() {
        navigateToWebPlatform();
    }

    @Given("the user is on the mobile platform")
    public void theUserIsOnTheMobilePlatform() {
        navigateToMobilePlatform();
    }

    @Given("the current time is within specified support hours")
    public void theCurrentTimeIsWithinSpecifiedSupportHours() {
        verifySupportHours();
    }

    @Given("the user has initiated a live chat")
    public void theUserHasInitiatedALiveChat() {
        initiateLiveChat();
    }

    @Given("the user sends a chat request")
    public void theUserSendsAChatRequest() {
        sendChatRequest();
    }

    @Given("the user has previously engaged in live chat")
    public void theUserHasPreviouslyEngagedInLiveChat() {
        verifyPreviousChatEngagement();
    }

    @Given("the user is engaged in a live chat session")
    public void theUserIsEngagedInALiveChatSession() {
        verifyLiveChatSession();
    }

    @Given("the user asks a common query in live chat")
    public void theUserAsksACommonQueryInLiveChat() {
        askCommonQuery();
    }

    @Given("the live chat requires escalation")
    public void theLiveChatRequiresEscalation() {
        verifyEscalationRequirement();
    }

    @When("the user navigates to the customer support section")
    public void theUserNavigatesToTheCustomerSupportSection() {
        navigateToCustomerSupport();
    }

    @When("the user accesses the live chat feature")
    public void theUserAccessesTheLiveChatFeature() {
        accessLiveChatFeature();
    }

    @When("the communication is ongoing")
    public void theCommunicationIsOngoing() {
        verifyOngoingCommunication();
    }

    @When("the request is received by the system")
    public void theRequestIsReceivedByTheSystem() {
        verifyRequestReception();
    }

    @When("the user navigates to the chat history section")
    public void theUserNavigatesToTheChatHistorySection() {
        navigateToChatHistory();
    }

    @When("a connection error occurs")
    public void aConnectionErrorOccurs() {
        simulateConnectionError();
    }

    @When("the query is recognized by the system")
    public void theQueryIsRecognizedByTheSystem() {
        recognizeQuery();
    }

    @When("the escalation is initiated")
    public void theEscalationIsInitiated() {
        initiateEscalation();
    }

    @Then("the user should see the live chat option")
    public void theUserShouldSeeTheLiveChatOption() {
        verifyLiveChatOption();
    }

    @Then("the live chat should be available")
    public void theLiveChatShouldBeAvailable() {
        verifyLiveChatAvailability();
    }

    @Then("the system should ensure secure and private communication")
    public void theSystemShouldEnsureSecureAndPrivateCommunication() {
        ensureSecureCommunication();
    }

    @Then("the user should receive immediate acknowledgment")
    public void theUserShouldReceiveImmediateAcknowledgment() {
        verifyImmediateAcknowledgment();
    }

    @Then("the user should be able to access past chat history")
    public void theUserShouldBeAbleToAccessPastChatHistory() {
        verifyChatHistoryAccess();
    }

    @Then("the system should handle the error gracefully")
    public void theSystemShouldHandleTheErrorGracefully() {
        handleConnectionErrorGracefully();
    }

    @Then("the system should provide an automated response")
    public void theSystemShouldProvideAnAutomatedResponse() {
        provideAutomatedResponse();
    }

    @Then("the integration with the support ticketing system should be seamless")
    public void theIntegrationWithTheSupportTicketingSystemShouldBeSeamless() {
        verifySeamlessIntegration();
    }
}