package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.LiveChatPage;

public class LiveChatSteps extends LiveChatPage {

    private TestHarness testHarness = new TestHarness();

    @Given("user account with valid credentials")
    public void userAccountWithValidCredentials() {
        String username = testHarness.getData("UserData", "Username");
        String password = testHarness.getData("UserData", "Password");
        enterUserName(username);
        enterPassword(password);
    }

    @Given("user ID is {int}")
    public void userIdIs(int userId) {
        verifyUserId(userId);
    }

    @When("user logs into the system on web platform")
    public void userLogsIntoTheSystemOnWebPlatform() {
        clickLoginButton();
    }

    @Then("user successfully logs into the system")
    public void userSuccessfullyLogsIntoTheSystem() {
        verifyHomePage();
    }

    @When("user navigates to the 'Help' section")
    public void userNavigatesToTheHelpSection() {
        navigateToHelpSection();
    }

    @Then("help section is displayed with various support options")
    public void helpSectionIsDisplayedWithVariousSupportOptions() {
        verifyHelpSection();
    }

    @When("user clicks on 'Live Chat' option")
    public void userClicksOnLiveChatOption() {
        clickLiveChatOption();
    }

    @Then("live chat window opens with greeting message")
    public void liveChatWindowOpensWithGreetingMessage() {
        verifyLiveChatWindow();
    }

    @Then("chat availability is 24/7")
    public void chatAvailabilityIs247() {
        verifyChatAvailability();
    }

    @When("user initiates a chat by typing a message")
    public void userInitiatesAChatByTypingAMessage() {
        typeMessage();
    }

    @Then("message is sent and received by support agent")
    public void messageIsSentAndReceivedBySupportAgent() {
        verifyMessageSent();
    }

    @Then("user receives a response from the support agent within expected time frame")
    public void userReceivesAResponseFromTheSupportAgentWithinExpectedTimeFrame() {
        verifyResponseTime();
    }

    @When("user logs out from the web platform")
    public void userLogsOutFromTheWebPlatform() {
        clickLogoutButton();
    }

    @Then("user successfully logs out from the web platform")
    public void userSuccessfullyLogsOutFromTheWebPlatform() {
        verifyLogout();
    }

    @When("user logs into the system on mobile platform")
    public void userLogsIntoTheSystemOnMobilePlatform() {
        clickLoginButton();
    }

    @Then("user navigates to the 'Contact Us' page")
    public void userNavigatesToTheContactUsPage() {
        navigateToContactUsPage();
    }

    @Then("contact us page is displayed with support options")
    public void contactUsPageIsDisplayedWithSupportOptions() {
        verifyContactUsPage();
    }

    @When("user selects 'Live Chat' option")
    public void userSelectsLiveChatOption() {
        selectLiveChatOption();
    }

    @Then("live chat window opens on mobile with greeting message")
    public void liveChatWindowOpensOnMobileWithGreetingMessage() {
        verifyLiveChatWindow();
    }

    @Given("user has initiated and received responses from live chat on both web and mobile platforms")
    public void userHasInitiatedAndReceivedResponsesFromLiveChatOnBothWebAndMobilePlatforms() {
        verifyChatInitiationOnBothPlatforms();
    }

    @When("user checks chat history for both platforms")
    public void userChecksChatHistoryForBothPlatforms() {
        checkChatHistory();
    }

    @Then("chat history is consistent across web and mobile")
    public void chatHistoryIsConsistentAcrossWebAndMobile() {
        verifyChatHistoryConsistency();
    }

    @Given("user is in varying network conditions")
    public void userIsInVaryingNetworkConditions() {
        simulateNetworkConditions();
    }

    @When("user initiates a live chat")
    public void userInitiatesALiveChat() {
        initiateLiveChat();
    }

    @Then("chat remains functional under varying network conditions")
    public void chatRemainsFunctionalUnderVaryingNetworkConditions() {
        verifyChatFunctionalityUnderNetworkConditions();
    }

    @Given("user has initiated a chat")
    public void userHasInitiatedAChat() {
        verifyChatInitiation();
    }

    @When("user verifies system logs")
    public void userVerifiesSystemLogs() {
        checkSystemLogs();
    }

    @Then("logs contain entries for chat initiation and messages exchanged")
    public void logsContainEntriesForChatInitiationAndMessagesExchanged() {
        verifyLogEntries();
    }

    @Given("user is on the live chat section")
    public void userIsOnTheLiveChatSection() {
        navigateToLiveChatSection();
    }

    @When("user checks UI for accessibility and ease of use")
    public void userChecksUIForAccessibilityAndEaseOfUse() {
        checkUIAccessibility();
    }

    @Then("UI is accessible and user-friendly for chat initiation")
    public void uiIsAccessibleAndUserFriendlyForChatInitiation() {
        verifyUIAccessibility();
    }
}