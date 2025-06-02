package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.RecoveryLinkPage;

public class RecoveryLinkSteps extends RecoveryLinkPage {

    private TestHarness testHarness = new TestHarness();

    @Given("User account with email verification enabled")
    public void userAccountWithEmailVerificationEnabled() {
        verifyEmailVerificationEnabled();
    }

    @When("I initiate password recovery process for the user account")
    public void initiatePasswordRecoveryProcess() {
        initiatePasswordRecovery();
    }

    @Then("A recovery link is sent to the user's email \"user@example.com\"")
    public void recoveryLinkSentToEmail() {
        verifyRecoveryLinkSent("user@example.com");
    }

    @Given("User has received a recovery link via email")
    public void userHasReceivedRecoveryLink() {
        verifyRecoveryLinkReceived();
    }

    @When("I access the email and click on the recovery link exactly at 24 hours")
    public void accessRecoveryLinkAt24Hours() {
        accessRecoveryLinkAtBoundary(24);
    }

    @Then("User is directed to the password recovery page successfully")
    public void userDirectedToRecoveryPage() {
        verifyRedirectionToRecoveryPage();
    }

    @When("I attempt to use the recovery link one minute after 24 hours")
    public void attemptRecoveryLinkAfter24Hours() {
        attemptRecoveryLinkAfterBoundary(24, 1);
    }

    @Then("User receives an error message indicating the link has expired")
    public void userReceivesLinkExpiredError() {
        verifyLinkExpiredErrorMessage();
    }

    @Given("System logs are accessible")
    public void systemLogsAreAccessible() {
        verifySystemLogsAccessible();
    }

    @When("I check the system logs for link expiration events at boundary conditions")
    public void checkSystemLogsForLinkExpiration() {
        checkLogsForLinkExpirationEvents();
    }

    @Then("System logs show accurate handling of boundary expiration")
    public void systemLogsShowAccurateHandling() {
        verifyAccurateLogHandling();
    }

    @Given("User has tested boundary conditions for link expiration")
    public void userTestedBoundaryConditions() {
        verifyBoundaryConditionsTested();
    }

    @When("I request a new recovery link")
    public void requestNewRecoveryLink() {
        requestNewRecoveryLink();
    }

    @Then("A new recovery link is sent to the user's email")
    public void newRecoveryLinkSent() {
        verifyNewRecoveryLinkSent();
    }
}