package com.cucumber.steps;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

import com.pageobjects.LiveChatPage;

public class LiveChatSteps extends LiveChatPage {

    @Given("the user is on the {string} page")
    public void theUserIsOnThePage(String page) {
        navigateToPage(page);
    }

    @When("the user initiates a conversation with a live agent")
    public void theUserInitiatesAConversationWithALiveAgent() {
        initiateLiveChat();
    }

    @Then("the chat request should be acknowledged or assigned to an agent within {string}")
    public void theChatRequestShouldBeAcknowledgedOrAssignedToAnAgentWithin(String responseTime) {
        verifyChatAcknowledgement(responseTime);
    }

    @When("agents are unavailable")
    public void agentsAreUnavailable() {
        simulateAgentsUnavailable();
    }

    @Then("the user should receive an automated message")
    public void theUserShouldReceiveAnAutomatedMessage() {
        verifyAutomatedMessageReceived();
    }

    @Then("the message should offer a way to leave a message or provide estimated wait times")
    public void theMessageShouldOfferAWayToLeaveAMessageOrProvideEstimatedWaitTimes() {
        verifyMessageOptions();
    }
}