package com.cucumber.steps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import com.framework.cucumber.TestHarness;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;
import io.cucumber.java.en.When;

import com.framework.cucumber.TestHarness;

public class ProductPageSteps extends ProductPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user navigates to the 'Camera B' product detail page")
    public void theUserNavigatesToTheCameraBProductDetailPage() {
        navigateToProductDetailPage("Camera B");
    }

    @Then("the product detail page is displayed")
    public void theProductDetailPageIsDisplayed() {
        verifyProductDetailPageDisplayed();
    }

    @When("the user selects the product image to view in high resolution")
    public void theUserSelectsTheProductImageToViewInHighResolution() {
        selectProductImageForHighResolution();
    }

    @Then("the high-resolution image is displayed and can be zoomed in")
    public void theHighResolutionImageIsDisplayedAndCanBeZoomedIn() {
        verifyHighResolutionImageDisplayed();
    }

    @Given("the user is logged into the retail application")
    public void theUserIsLoggedIntoTheRetailApplication() {
        loginToRetailApplication();
    }

    @When("the user navigates to a product page")
    public void theUserNavigatesToAProductPage() {
        navigateToProductPage();
    }

    @Then("the product page is displayed to the user")
    public void theProductPageIsDisplayedToTheUser() {
        verifyProductPageDisplayed();
    }

    @When("the user locates the 'Live Chat' button or link")
    public void theUserLocatesTheLiveChatButtonOrLink() {
        locateLiveChatButton();
    }

    @Then("the 'Live Chat' button or link is visible on the product page")
    public void theLiveChatButtonOrLinkIsVisibleOnTheProductPage() {
        verifyLiveChatButtonVisible();
    }

    @When("the user clicks on the 'Live Chat' button")
    public void theUserClicksOnTheLiveChatButton() {
        clickLiveChatButton();
    }

    @Then("the live chat window opens, and the user is prompted to start a conversation")
    public void theLiveChatWindowOpensAndTheUserIsPromptedToStartAConversation() {
        verifyLiveChatWindowOpens();
    }

    @When("the user enters a sample message in the chat window")
    public void theUserEntersASampleMessageInTheChatWindow() {
        enterSampleMessageInChatWindow();
    }

    @Then("the message is displayed in the chat window")
    public void theMessageIsDisplayedInTheChatWindow() {
        verifyMessageDisplayedInChatWindow();
    }

    @When("the user sends the message")
    public void theUserSendsTheMessage() {
        sendMessage();
    }

    @Then("the message is sent, and a response is received from a live agent within 30 seconds")
    public void theMessageIsSentAndAResponseIsReceivedFromALiveAgentWithin30Seconds() {
        verifyResponseReceivedWithin30Seconds();
    }

    @When("the user attempts to start a conversation when no agents are available")
    public void theUserAttemptsToStartAConversationWhenNoAgentsAreAvailable() {
        attemptToStartConversationWithNoAgents();
    }

    @Then("an automated message informs the user that no agents are available, offering options to leave a message or providing estimated wait times")
    public void anAutomatedMessageInformsTheUserThatNoAgentsAreAvailableOfferingOptionsToLeaveAMessageOrProvidingEstimatedWaitTimes() {
        verifyAutomatedMessageForNoAgents();
    }

    @When("the user enters a sample message and sends it")
    public void theUserEntersASampleMessageAndSendsIt() {
        enterAndSendSampleMessage();
    }

    @Then("the message is sent, and no response is received within 30 seconds")
    public void theMessageIsSentAndNoResponseIsReceivedWithin30Seconds() {
        verifyNoResponseWithin30Seconds();
    }

    @When("the user observes the system behavior after 30 seconds")
    public void theUserObservesTheSystemBehaviorAfter30Seconds() {
        observeSystemBehaviorAfterDelay();
    }

    @Then("the system provides a notification or message indicating the delay and possible options for the user")
    public void theSystemProvidesANotificationOrMessageIndicatingTheDelayAndPossibleOptionsForTheUser() {
        verifyNotificationForDelay();
    }
}