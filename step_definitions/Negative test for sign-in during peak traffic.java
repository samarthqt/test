package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInSteps extends SignInPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the server is under simulated peak load beyond capacity")
    public void theServerIsUnderSimulatedPeakLoadBeyondCapacity() {
        simulatePeakLoad();
    }

    @Given("the user has a valid account with email {string} and password {string}")
    public void theUserHasAValidAccount(String email, String password) {
        testHarness.setData("UserData", "Email", email);
        testHarness.setData("UserData", "Password", password);
    }

    @When("the user navigates to the sign-in page")
    public void theUserNavigatesToTheSignInPage() {
        navigateToSignInPage();
    }

    @Then("the sign-in page should be displayed with email and password fields")
    public void theSignInPageShouldBeDisplayed() {
        verifySignInPageDisplayed();
    }

    @When("the user enters a valid email address in the email field")
    public void theUserEntersAValidEmailAddress() {
        String email = testHarness.getData("UserData", "Email");
        enterEmail(email);
    }

    @When("the user enters a valid password in the password field")
    public void theUserEntersAValidPassword() {
        String password = testHarness.getData("UserData", "Password");
        enterPassword(password);
    }

    @When("the user clicks on the 'Sign In' button")
    public void theUserClicksOnTheSignInButton() {
        clickSignInButton();
    }

    @Then("the system may delay or deny sign-in due to traffic load")
    public void theSystemMayDelayOrDenySignIn() {
        verifySignInDelayOrDenial();
    }

    @Then("appropriate error messages or retry prompts are displayed")
    public void appropriateErrorMessagesOrRetryPromptsAreDisplayed() {
        verifyErrorMessagesOrRetryPrompts();
    }

    @When("the user attempts to sign in repeatedly")
    public void theUserAttemptsToSignInRepeatedly() {
        attemptRepeatedSignIn();
    }

    @Then("the system handles repeated attempts gracefully without crashing")
    public void theSystemHandlesRepeatedAttemptsGracefully() {
        verifyGracefulHandlingOfRepeatedAttempts();
    }

    @When("the user attempts to sign in")
    public void theUserAttemptsToSignIn() {
        attemptSignIn();
    }

    @Then("capacity-related errors are logged for auditing")
    public void capacityRelatedErrorsAreLogged() {
        verifyCapacityRelatedErrorsLogged();
    }

    @When("multiple users attempt to sign in")
    public void multipleUsersAttemptToSignIn() {
        simulateMultipleUserSignIn();
    }

    @Then("the system manages excess load without significant failures")
    public void theSystemManagesExcessLoad() {
        verifySystemLoadManagement();
    }

    @When("the user navigates the UI")
    public void theUserNavigatesTheUI() {
        navigateUI();
    }

    @Then("the UI remains responsive, and the user is informed of delays")
    public void theUIRemainsResponsive() {
        verifyUIResponsiveness();
    }

    @Then("the system queues requests and processes them as capacity allows")
    public void theSystemQueuesRequests() {
        verifyRequestQueuing();
    }

    @Then("no data corruption occurs; user data remains intact")
    public void noDataCorruptionOccurs() {
        verifyDataIntegrity();
    }

    @Then("failover mechanisms activate and manage overload effectively")
    public void failoverMechanismsActivate() {
        verifyFailoverMechanisms();
    }

    @When("the user enters an invalid email/password")
    public void theUserEntersAnInvalidEmailPassword() {
        enterInvalidCredentials();
    }

    @Then("the system handles invalid credentials gracefully and prompts retry")
    public void theSystemHandlesInvalidCredentials() {
        verifyInvalidCredentialsHandling();
    }

    @Then("session management is handled correctly, with no issues")
    public void sessionManagementIsHandledCorrectly() {
        verifySessionManagement();
    }
}