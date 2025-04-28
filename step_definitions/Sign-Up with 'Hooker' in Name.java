package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpSteps extends SignUpPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has access to the sign-up page")
    public void theUserHasAccessToTheSignUpPage() {
        navigateToSignUpPage();
    }

    @When("the user navigates to the sign-up page")
    public void theUserNavigatesToTheSignUpPage() {
        verifySignUpPageDisplayed();
    }

    @When("the user enters {string} in the First Name field")
    public void theUserEntersInTheFirstNameField(String firstName) {
        enterFirstName(firstName);
    }

    @Then("the First Name field accepts input without errors")
    public void theFirstNameFieldAcceptsInputWithoutErrors() {
        verifyFirstNameInputAccepted();
    }

    @When("the user enters {string} in the Last Name field")
    public void theUserEntersInTheLastNameField(String lastName) {
        enterLastName(lastName);
    }

    @Then("the Last Name field accepts input without errors")
    public void theLastNameFieldAcceptsInputWithoutErrors() {
        verifyLastNameInputAccepted();
    }

    @When("the user enters {string} in the Email field")
    public void theUserEntersInTheEmailField(String email) {
        enterEmail(email);
    }

    @Then("the Email field accepts input without errors")
    public void theEmailFieldAcceptsInputWithoutErrors() {
        verifyEmailInputAccepted();
    }

    @When("the user enters {string} in the Password field")
    public void theUserEntersInThePasswordField(String password) {
        enterPassword(password);
    }

    @Then("the Password field accepts input without errors")
    public void thePasswordFieldAcceptsInputWithoutErrors() {
        verifyPasswordInputAccepted();
    }

    @When("the user clicks on the 'Sign Up' button")
    public void theUserClicksOnTheSignUpButton() {
        clickSignUpButton();
    }

    @Then("the system processes the sign-up request")
    public void theSystemProcessesTheSignUpRequest() {
        verifySignUpRequestProcessed();
    }

    @Then("no error messages are displayed related to the name field")
    public void noErrorMessagesAreDisplayedRelatedToTheNameField() {
        verifyNoNameFieldErrors();
    }

    @When("the user verifies account creation confirmation")
    public void theUserVerifiesAccountCreationConfirmation() {
        verifyAccountCreationConfirmation();
    }

    @Then("account creation is confirmed")
    public void accountCreationIsConfirmed() {
        verifyAccountCreationConfirmed();
    }

    @Then("the user is redirected to the welcome page")
    public void theUserIsRedirectedToTheWelcomePage() {
        verifyRedirectionToWelcomePage();
    }

    @When("the user logs out of the account")
    public void theUserLogsOutOfTheAccount() {
        logout();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyLogoutSuccess();
    }

    @When("the user attempts to log in with the newly created account")
    public void theUserAttemptsToLogInWithTheNewlyCreatedAccount() {
        loginWithNewAccount();
    }

    @Then("the user is able to log in successfully")
    public void theUserIsAbleToLogInSuccessfully() {
        verifyLoginSuccess();
    }

    @When("the user checks the user profile for correct name display")
    public void theUserChecksTheUserProfileForCorrectNameDisplay() {
        checkUserProfileNameDisplay();
    }

    @Then("'John Hooker' is displayed correctly in the user profile")
    public void johnHookerIsDisplayedCorrectlyInTheUserProfile() {
        verifyUserProfileNameDisplay();
    }

    @When("the user inspects network logs for any sign-up errors")
    public void theUserInspectsNetworkLogsForAnySignUpErrors() {
        inspectNetworkLogsForSignUpErrors();
    }

    @Then("no errors related to the name field are logged")
    public void noErrorsRelatedToTheNameFieldAreLogged() {
        verifyNoNameFieldErrorsInLogs();
    }

    @When("the user verifies that the name 'Hooker' is stored correctly in the database")
    public void theUserVerifiesThatTheNameHookerIsStoredCorrectlyInTheDatabase() {
        verifyNameStoredInDatabase();
    }

    @Then("the name is stored as 'John Hooker' in the database")
    public void theNameIsStoredAsJohnHookerInTheDatabase() {
        verifyNameStoredCorrectly();
    }

    @When("the user ensures that the name 'Hooker' does not trigger any backend validation errors")
    public void theUserEnsuresThatTheNameHookerDoesNotTriggerAnyBackendValidationErrors() {
        ensureNoBackendValidationErrors();
    }

    @Then("no backend validation errors are triggered")
    public void noBackendValidationErrorsAreTriggered() {
        verifyNoBackendValidationErrors();
    }

    @When("the user confirms that they receive a welcome email")
    public void theUserConfirmsThatTheyReceiveAWelcomeEmail() {
        confirmWelcomeEmailReceived();
    }

    @Then("the welcome email is received with the correct name")
    public void theWelcomeEmailIsReceivedWithTheCorrectName() {
        verifyWelcomeEmailContent();
    }
}