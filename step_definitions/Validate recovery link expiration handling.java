package com.cucumber.steps;

import com.page_objects.RecoveryLinkPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RecoveryLinkSteps extends RecoveryLinkPage {

    @Given("a user account with email verification enabled")
    public void aUserAccountWithEmailVerificationEnabled() {
        verifyEmailVerificationEnabled();
    }

    @When("the user initiates the password recovery process")
    public void theUserInitiatesThePasswordRecoveryProcess() {
        initiatePasswordRecovery();
    }

    @Then("a recovery link is sent to the user's email \"user@example.com\"")
    public void aRecoveryLinkIsSentToTheUsersEmail() {
        verifyRecoveryLinkSent("user@example.com");
    }

    @Given("a recovery link sent to the user's email")
    public void aRecoveryLinkSentToTheUsersEmail() {
        verifyRecoveryLinkExists();
    }

    @When("the user accesses the email and clicks on the recovery link within 24 hours")
    public void theUserAccessesTheEmailAndClicksOnTheRecoveryLinkWithin24Hours() {
        accessRecoveryLinkWithinTime();
    }

    @Then("the user is directed to the password recovery page successfully")
    public void theUserIsDirectedToThePasswordRecoveryPageSuccessfully() {
        verifyRedirectionToRecoveryPage();
    }

    @When("the user attempts to use the recovery link after 24 hours")
    public void theUserAttemptsToUseTheRecoveryLinkAfter24Hours() {
        attemptRecoveryLinkAfterExpiration();
    }

    @Then("the user receives an error message indicating the link has expired")
    public void theUserReceivesAnErrorMessageIndicatingTheLinkHasExpired() {
        verifyLinkExpirationErrorMessage();
    }

    @When("the recovery link expires")
    public void theRecoveryLinkExpires() {
        expireRecoveryLink();
    }

    @Then("the system logs show the link expiration timestamp")
    public void theSystemLogsShowTheLinkExpirationTimestamp() {
        verifySystemLogsForExpiration();
    }

    @Given("a recovery link has expired")
    public void aRecoveryLinkHasExpired() {
        verifyRecoveryLinkExpired();
    }

    @When("the user requests a new recovery link")
    public void theUserRequestsANewRecoveryLink() {
        requestNewRecoveryLink();
    }

    @Then("a new recovery link is sent to the user's email")
    public void aNewRecoveryLinkIsSentToTheUsersEmail() {
        verifyNewRecoveryLinkSent();
    }
}