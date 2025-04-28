package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpSteps extends SignUpPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I have access to the sign-up page")
    public void iHaveAccessToTheSignUpPage() {
        navigateToSignUpPage();
    }

    @When("I navigate to the sign-up page")
    public void iNavigateToTheSignUpPage() {
        navigateToSignUpPage();
    }

    @Then("the sign-up page is displayed")
    public void theSignUpPageIsDisplayed() {
        verifySignUpPageDisplayed();
    }

    @When("I enter {string} in the First Name field")
    public void iEnterInTheFirstNameField(String firstName) {
        enterFirstName(firstName);
    }

    @Then("the First Name field accepts input without errors")
    public void theFirstNameFieldAcceptsInputWithoutErrors() {
        verifyFirstNameFieldNoErrors();
    }

    @When("I enter {string} in the Last Name field")
    public void iEnterInTheLastNameField(String lastName) {
        enterLastName(lastName);
    }

    @Then("the Last Name field accepts input without errors")
    public void theLastNameFieldAcceptsInputWithoutErrors() {
        verifyLastNameFieldNoErrors();
    }

    @When("I enter {string} in the Email field")
    public void iEnterInTheEmailField(String email) {
        enterEmail(email);
    }

    @Then("the Email field accepts input without errors")
    public void theEmailFieldAcceptsInputWithoutErrors() {
        verifyEmailFieldNoErrors();
    }

    @When("I enter {string} in the Password field")
    public void iEnterInThePasswordField(String password) {
        enterPassword(password);
    }

    @Then("the Password field accepts input without errors")
    public void thePasswordFieldAcceptsInputWithoutErrors() {
        verifyPasswordFieldNoErrors();
    }

    @When("I click on the 'Sign Up' button")
    public void iClickOnTheSignUpButton() {
        clickSignUpButton();
    }

    @Then("the system processes the sign-up request")
    public void theSystemProcessesTheSignUpRequest() {
        verifySignUpRequestProcessed();
    }

    @Then("no error messages are displayed for 'Anudeep'")
    public void noErrorMessagesAreDisplayedForAnudeep() {
        verifyNoErrorMessagesForAnudeep();
    }

    @When("I verify account creation confirmation")
    public void iVerifyAccountCreationConfirmation() {
        verifyAccountCreationConfirmation();
    }

    @Then("account creation is confirmed, and the user is redirected to the welcome page")
    public void accountCreationIsConfirmedAndTheUserIsRedirectedToTheWelcomePage() {
        verifyRedirectionToWelcomePage();
    }

    @When("I log out of the account")
    public void iLogOutOfTheAccount() {
        logOut();
    }

    @Then("the user is logged out successfully")
    public void theUserIsLoggedOutSuccessfully() {
        verifyUserLoggedOut();
    }

    @When("I attempt to log in with the newly created account")
    public void iAttemptToLogInWithTheNewlyCreatedAccount() {
        logInWithNewAccount();
    }

    @Then("the user is able to log in successfully")
    public void theUserIsAbleToLogInSuccessfully() {
        verifySuccessfulLogin();
    }

    @When("I check the user profile for correct name display")
    public void iCheckTheUserProfileForCorrectNameDisplay() {
        checkUserProfileNameDisplay();
    }

    @Then("'Anudeep Smith' is displayed correctly in the user profile")
    public void anudeepSmithIsDisplayedCorrectlyInTheUserProfile() {
        verifyCorrectNameDisplayInProfile();
    }

    @When("I inspect network logs for any sign-up errors")
    public void iInspectNetworkLogsForAnySignUpErrors() {
        inspectNetworkLogsForSignUpErrors();
    }

    @Then("no errors related to the name field are logged")
    public void noErrorsRelatedToTheNameFieldAreLogged() {
        verifyNoNameFieldErrorsInLogs();
    }

    @When("I verify that the name 'Anudeep' is stored correctly in the database")
    public void iVerifyThatTheNameAnudeepIsStoredCorrectlyInTheDatabase() {
        verifyNameStoredInDatabase();
    }

    @Then("the name is stored as 'Anudeep' in the database")
    public void theNameIsStoredAsAnudeepInTheDatabase() {
        verifyCorrectNameStorageInDatabase();
    }

    @When("I ensure that the name 'Anudeep' does not trigger any backend validation errors")
    public void iEnsureThatTheNameAnudeepDoesNotTriggerAnyBackendValidationErrors() {
        ensureNoBackendValidationErrors();
    }

    @Then("no backend validation errors are triggered")
    public void noBackendValidationErrorsAreTriggered() {
        verifyNoBackendValidationErrors();
    }

    @When("I confirm that the user receives a welcome email")
    public void iConfirmThatTheUserReceivesAWelcomeEmail() {
        confirmWelcomeEmailReceived();
    }

    @Then("the welcome email is received with the correct name")
    public void theWelcomeEmailIsReceivedWithTheCorrectName() {
        verifyWelcomeEmailCorrectName();
    }
}