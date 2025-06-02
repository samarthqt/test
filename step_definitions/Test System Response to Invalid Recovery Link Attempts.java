package com.cucumber.steps;

import com.page_objects.RecoveryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RecoverySteps extends RecoveryPage {

    @Given("an invalid recovery link {string} is available")
    public void anInvalidRecoveryLinkIsAvailable(String link) {
        setRecoveryLink(link);
    }

    @When("I attempt to access the password reset page using the invalid link")
    public void iAttemptToAccessThePasswordResetPageUsingTheInvalidLink() {
        accessRecoveryPage();
    }

    @Then("the system denies access to the password reset page")
    public void theSystemDeniesAccessToThePasswordResetPage() {
        verifyAccessDenied();
    }

    @Then("an error message is displayed indicating the link is invalid")
    public void anErrorMessageIsDisplayedIndicatingTheLinkIsInvalid() {
        verifyInvalidLinkMessage();
    }

    @Then("the invalid link attempt is logged in the system")
    public void theInvalidLinkAttemptIsLoggedInTheSystem() {
        verifyLinkAttemptLogged();
    }

    @Then("the user is redirected to the login page or given an option to request a new link")
    public void theUserIsRedirectedToTheLoginPageOrGivenAnOptionToRequestANewLink() {
        verifyRedirectionOrOption();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyUserLoggedOut();
    }
}