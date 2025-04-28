package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInSteps extends SignInPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the server is under simulated peak load")
    public void theServerIsUnderSimulatedPeakLoad() {
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

    @Then("the sign-in page is displayed with email and password fields")
    public void theSignInPageIsDisplayed() {
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

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonName) {
        clickSignInButton();
    }

    @Then("the user is successfully signed in, and the home page is displayed")
    public void theUserIsSuccessfullySignedIn() {
        verifyHomePageDisplayed();
    }

    @When("the system response time during sign-in is verified")
    public void theSystemResponseTimeIsVerified() {
        verifyResponseTime();
    }

    @Then("the response time is within acceptable limits even during peak traffic")
    public void theResponseTimeIsWithinLimits() {
        verifyResponseTimeWithinLimits();
    }

    @When("the user logs out of the application")
    public void theUserLogsOut() {
        logout();
    }

    @Then("the user is logged out, and the sign-in page is displayed")
    public void theUserIsLoggedOut() {
        verifySignInPageDisplayed();
    }

    @When("the process is repeated with different email and password combinations")
    public void theProcessIsRepeated() {
        repeatSignInProcess();
    }

    @Then("the system consistently handles sign-in attempts during peak traffic")
    public void theSystemConsistentlyHandlesSignInAttempts() {
        verifyConsistentHandling();
    }

    @When("sign-in is tested with multiple users simultaneously")
    public void signInIsTestedWithMultipleUsers() {
        testConcurrentSignIn();
    }

    @Then("the system handles concurrent sign-in attempts efficiently")
    public void theSystemHandlesConcurrentSignInAttempts() {
        verifyConcurrentHandling();
    }

    @When("system logs are verified for any errors or slowdowns")
    public void systemLogsAreVerified() {
        verifySystemLogs();
    }

    @Then("no significant errors or performance issues are logged")
    public void noSignificantErrorsAreLogged() {
        verifyNoErrorsInLogs();
    }

    @When("sign-in is tested with different network types (Wi-Fi, cellular) during peak traffic")
    public void signInIsTestedWithDifferentNetworkTypes() {
        testSignInWithDifferentNetworks();
    }

    @Then("the system performs consistently across different network types")
    public void theSystemPerformsConsistently() {
        verifyConsistentPerformanceAcrossNetworks();
    }

    @When("ensuring no data loss occurs during peak traffic sign-in attempts")
    public void ensuringNoDataLossOccurs() {
        ensureNoDataLoss();
    }

    @Then("no data loss occurs; user data remains intact")
    public void noDataLossOccurs() {
        verifyDataIntegrity();
    }

    @When("verifying UI responsiveness during peak traffic")
    public void verifyingUIResponsiveness() {
        verifyUIResponsiveness();
    }

    @Then("the UI remains responsive, and the user is informed of any delays")
    public void theUIRemainsResponsive() {
        verifyUIResponsivenessAndInformUser();
    }

    @When("testing the system's ability to prioritize sign-in requests during peak traffic")
    public void testingSystemAbilityToPrioritizeRequests() {
        testSignInRequestPrioritization();
    }

    @Then("the system prioritizes sign-in requests appropriately")
    public void theSystemPrioritizesRequests() {
        verifyRequestPrioritization();
    }

    @When("checking for any session management issues during peak traffic")
    public void checkingForSessionManagementIssues() {
        checkSessionManagement();
    }

    @Then("session management is handled correctly, with no issues")
    public void sessionManagementIsHandledCorrectly() {
        verifySessionManagement();
    }
}