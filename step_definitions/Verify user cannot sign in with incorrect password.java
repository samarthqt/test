package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.SignInPage;

public class SignInSteps extends SignInPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user navigates to the application URL {string}")
    public void theUserNavigatesToTheApplicationURL(String url) {
        launchUrl(url);
        maximizeWindow();
    }

    @Given("the application homepage is displayed")
    public void theApplicationHomepageIsDisplayed() {
        verifyHomePageDisplayed();
    }

    @When("the user clicks on the 'Sign In' button")
    public void theUserClicksOnTheSignInButton() {
        clickSignInButton();
    }

    @Then("the sign-in page is displayed")
    public void theSignInPageIsDisplayed() {
        verifySignInPageDisplayed();
    }

    @Then("the user enters registered email {string} in the email field")
    public void theUserEntersRegisteredEmailInTheEmailField(String email) {
        enterEmail(email);
    }

    @Then("the user enters incorrect password {string} in the password field")
    public void theUserEntersIncorrectPasswordInThePasswordField(String password) {
        enterPassword(password);
    }

    @When("the user clicks on 'Sign In' to proceed")
    public void theUserClicksOnSignInToProceed() {
        clickProceedSignIn();
    }

    @Then("the system processes the sign-in request")
    public void theSystemProcessesTheSignInRequest() {
        verifySignInRequestProcessed();
    }

    @Then("the system checks password validity")
    public void theSystemChecksPasswordValidity() {
        verifyPasswordValidity();
    }

    @Then("an error message indicating incorrect password is displayed")
    public void anErrorMessageIndicatingIncorrectPasswordIsDisplayed() {
        verifyIncorrectPasswordErrorMessage();
    }

    @Then("the error message includes guidance for password recovery or contacting support")
    public void theErrorMessageIncludesGuidanceForPasswordRecoveryOrContactingSupport() {
        verifyErrorMessageGuidance();
    }

    @Then("the system logs the incorrect sign-in attempt")
    public void theSystemLogsTheIncorrectSignInAttempt() {
        verifySignInAttemptLogged();
    }

    @Then("no alerts or notifications are displayed")
    public void noAlertsOrNotificationsAreDisplayed() {
        verifyNoAlertsOrNotifications();
    }

    @Then("privacy policies are adhered to")
    public void privacyPoliciesAreAdheredTo() {
        verifyPrivacyPoliciesAdhered();
    }

    @Then("terms and conditions are displayed")
    public void termsAndConditionsAreDisplayed() {
        verifyTermsAndConditionsDisplayed();
    }

    @Then("support contact information is available")
    public void supportContactInformationIsAvailable() {
        verifySupportContactInformation();
    }

    @Then("sign-in is successful with the correct password")
    public void signInIsSuccessfulWithTheCorrectPassword() {
        verifySuccessfulSignIn();
    }

    @Then("user dashboard is accessible")
    public void userDashboardIsAccessible() {
        verifyUserDashboardAccessible();
    }
}