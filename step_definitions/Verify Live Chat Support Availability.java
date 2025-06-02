package com.cucumber.steps;

import com.page_objects.LiveChatPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LiveChatSteps extends LiveChatPage {

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("the user navigates to the homepage of the application")
    public void theUserNavigatesToTheHomepageOfTheApplication() {
        navigateToHomepage();
    }

    @Then("the homepage is displayed with all navigation options")
    public void theHomepageIsDisplayedWithAllNavigationOptions() {
        verifyHomepageDisplayed();
    }

    @Given("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        verifyHomepageDisplayed();
    }

    @When("the user locates the 'Live Chat' option")
    public void theUserLocatesTheLiveChatOption() {
        locateLiveChatOption();
    }

    @Then("the 'Live Chat' option is visible and accessible")
    public void theLiveChatOptionIsVisibleAndAccessible() {
        verifyLiveChatOptionVisible();
    }

    @Given("the 'Live Chat' option is visible")
    public void theLiveChatOptionIsVisible() {
        verifyLiveChatOptionVisible();
    }

    @When("the user clicks on the 'Live Chat' option")
    public void theUserClicksOnTheLiveChatOption() {
        clickLiveChatOption();
    }

    @Then("the live chat window opens with a welcome message")
    public void theLiveChatWindowOpensWithAWelcomeMessage() {
        verifyLiveChatWindowOpens();
    }

    @Given("the live chat window is open")
    public void theLiveChatWindowIsOpen() {
        verifyLiveChatWindowOpens();
    }

    @When("the user enters a query into the chat window")
    public void theUserEntersAQueryIntoTheChatWindow() {
        enterQueryIntoChatWindow();
    }

    @Then("the chat window accepts input and displays the entered query")
    public void theChatWindowAcceptsInputAndDisplaysTheEnteredQuery() {
        verifyQueryDisplayedInChatWindow();
    }

    @When("the user sends the query through the chat")
    public void theUserSendsTheQueryThroughTheChat() {
        sendQueryThroughChat();
    }

    @Then("the query is sent successfully and a response is received")
    public void theQueryIsSentSuccessfullyAndAResponseIsReceived() {
        verifyResponseReceived();
    }

    @Given("a query has been sent")
    public void aQueryHasBeenSent() {
        sendQueryThroughChat();
    }

    @When("the user waits for a response")
    public void theUserWaitsForAResponse() {
        waitForResponse();
    }

    @Then("the response is received within expected time frame")
    public void theResponseIsReceivedWithinExpectedTimeFrame() {
        verifyResponseTime();
    }

    @Given("the chat session is ongoing")
    public void theChatSessionIsOngoing() {
        verifyChatSessionOngoing();
    }

    @When("the user interacts with the chat")
    public void theUserInteractsWithTheChat() {
        interactWithChat();
    }

    @Then("no error messages are displayed")
    public void noErrorMessagesAreDisplayed() {
        verifyNoErrorMessages();
    }

    @Given("the live chat window is open")
    public void theLiveChatWindowIsOpenAgain() {
        verifyLiveChatWindowOpens();
    }

    @When("the user closes the live chat window")
    public void theUserClosesTheLiveChatWindow() {
        closeLiveChatWindow();
    }

    @Then("the live chat window closes without errors")
    public void theLiveChatWindowClosesWithoutErrors() {
        verifyLiveChatWindowCloses();
    }

    @When("the user reopens the live chat window")
    public void theUserReopensTheLiveChatWindow() {
        reopenLiveChatWindow();
    }

    @Then("the live chat window opens again successfully")
    public void theLiveChatWindowOpensAgainSuccessfully() {
        verifyLiveChatWindowOpens();
    }

    @Given("the time is outside business hours")
    public void theTimeIsOutsideBusinessHours() {
        verifyOutsideBusinessHours();
    }

    @When("the user attempts to access live chat support")
    public void theUserAttemptsToAccessLiveChatSupport() {
        attemptAccessLiveChatOutsideHours();
    }

    @Then("live chat is unavailable, and a message indicating hours of operation is displayed")
    public void liveChatIsUnavailableAndAMessageIndicatingHoursOfOperationIsDisplayed() {
        verifyLiveChatUnavailableMessage();
    }

    @Given("the chat session has ended")
    public void theChatSessionHasEnded() {
        endChatSession();
    }

    @When("the user checks the user profile")
    public void theUserChecksTheUserProfile() {
        checkUserProfileForTranscripts();
    }

    @Then("transcripts are saved and accessible in user profile")
    public void transcriptsAreSavedAndAccessibleInUserProfile() {
        verifyTranscriptsSavedInProfile();
    }

    @Given("the application supports multiple browsers")
    public void theApplicationSupportsMultipleBrowsers() {
        verifyBrowserSupport();
    }

    @When("the user accesses the chat window on different browsers")
    public void theUserAccessesTheChatWindowOnDifferentBrowsers() {
        accessChatWindowOnDifferentBrowsers();
    }

    @Then("the chat window functions correctly across different browsers")
    public void theChatWindowFunctionsCorrectlyAcrossDifferentBrowsers() {
        verifyChatWindowCompatibility();
    }

    @Given("the user accesses the application on a mobile device")
    public void theUserAccessesTheApplicationOnAMobileDevice() {
        accessApplicationOnMobileDevice();
    }

    @When("the user opens the live chat window")
    public void theUserOpensTheLiveChatWindow() {
        openLiveChatWindowOnMobile();
    }

    @Then("live chat functions properly on mobile devices")
    public void liveChatFunctionsProperlyOnMobileDevices() {
        verifyLiveChatOnMobile();
    }

    @Given("multiple users are logged into the application")
    public void multipleUsersAreLoggedIntoTheApplication() {
        verifyMultipleUsersLoggedIn();
    }

    @When("multiple users use live chat simultaneously")
    public void multipleUsersUseLiveChatSimultaneously() {
        useLiveChatSimultaneously();
    }

    @Then("the system handles multiple chat sessions without performance degradation")
    public void theSystemHandlesMultipleChatSessionsWithoutPerformanceDegradation() {
        verifyMultipleChatSessionsPerformance();
    }

    @Given("the chat session is ongoing")
    public void theChatSessionIsOngoingAgain() {
        verifyChatSessionOngoing();
    }

    @When("the user interacts with the chat")
    public void theUserInteractsWithTheChatAgain() {
        interactWithChat();
    }

    @Then("chat interactions are logged in CRM systems for future reference")
    public void chatInteractionsAreLoggedInCRMSystemsForFutureReference() {
        verifyChatLoggedInCRM();
    }
}