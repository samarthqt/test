package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountCreationSteps extends AccountCreationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the account creation page")
    public void theUserIsOnTheAccountCreationPage() {
        navigateToAccountCreationPage();
    }

    @When("the user navigates to the account creation page")
    public void theUserNavigatesToTheAccountCreationPage() {
        navigateToAccountCreationPage();
    }

    @Then("the account creation page is displayed")
    public void theAccountCreationPageIsDisplayed() {
        verifyAccountCreationPageDisplayed();
    }

    @When("the user enters {string} in the first name field")
    public void theUserEntersInTheFirstNameField(String firstName) {
        enterFirstName(firstName);
    }

    @Then("the first name {string} is entered in the field")
    public void theFirstNameIsEnteredInTheField(String firstName) {
        verifyFirstNameEntered(firstName);
    }

    @When("the user enters {string} in the last name field")
    public void theUserEntersInTheLastNameField(String lastName) {
        enterLastName(lastName);
    }

    @Then("the last name {string} is entered in the field")
    public void theLastNameIsEnteredInTheField(String lastName) {
        verifyLastNameEntered(lastName);
    }

    @When("the user enters {string} in the email field")
    public void theUserEntersInTheEmailField(String email) {
        enterEmail(email);
    }

    @Then("the email {string} is entered in the field")
    public void theEmailIsEnteredInTheField(String email) {
        verifyEmailEntered(email);
    }

    @When("the user enters {string} in the password field")
    public void theUserEntersInThePasswordField(String password) {
        enterPassword(password);
    }

    @Then("the password {string} is entered in the field")
    public void thePasswordIsEnteredInTheField(String password) {
        verifyPasswordEntered(password);
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonName) {
        if (buttonName.equals("Create Account")) {
            clickCreateAccountButton();
        }
    }

    @Then("the account creation process is initiated")
    public void theAccountCreationProcessIsInitiated() {
        verifyAccountCreationInitiated();
    }

    @Then("the account is created successfully")
    public void theAccountIsCreatedSuccessfully() {
        verifyAccountCreationSuccess();
    }

    @Then("the user is redirected to the welcome page with a success message")
    public void theUserIsRedirectedToTheWelcomePageWithASuccessMessage() {
        verifyRedirectionToWelcomePage();
    }

    @When("the system logs are checked for any errors during the account creation process")
    public void theSystemLogsAreCheckedForAnyErrorsDuringTheAccountCreationProcess() {
        checkSystemLogsForErrors();
    }

    @Then("no errors related to account creation are found in the system logs")
    public void noErrorsRelatedToAccountCreationAreFoundInTheSystemLogs() {
        verifyNoErrorsInSystemLogs();
    }

    @When("the user attempts to log in with the newly created account credentials")
    public void theUserAttemptsToLogInWithTheNewlyCreatedAccountCredentials() {
        attemptLoginWithNewAccount();
    }

    @Then("the user is able to log in successfully with the new account")
    public void theUserIsAbleToLogInSuccessfullyWithTheNewAccount() {
        verifySuccessfulLogin();
    }

    @When("the user receives a confirmation email about the account creation")
    public void theUserReceivesAConfirmationEmailAboutTheAccountCreation() {
        checkForConfirmationEmail();
    }

    @Then("the user receives a confirmation email with account details")
    public void theUserReceivesAConfirmationEmailWithAccountDetails() {
        verifyConfirmationEmailReceived();
    }

    @When("the database is checked to ensure the account details are stored correctly")
    public void theDatabaseIsCheckedToEnsureTheAccountDetailsAreStoredCorrectly() {
        checkDatabaseForAccountDetails();
    }

    @Then("the database reflects the correct account details for {string}")
    public void theDatabaseReflectsTheCorrectAccountDetailsFor(String fullName) {
        verifyDatabaseAccountDetails(fullName);
    }

    @When("the server performance is monitored during the account creation process")
    public void theServerPerformanceIsMonitoredDuringTheAccountCreationProcess() {
        monitorServerPerformance();
    }

    @Then("the server performance remains stable during the account creation")
    public void theServerPerformanceRemainsStableDuringTheAccountCreation() {
        verifyServerPerformanceStability();
    }

    @When("the account creation process is repeated with different valid names")
    public void theAccountCreationProcessIsRepeatedWithDifferentValidNames() {
        repeatAccountCreationWithDifferentNames();
    }

    @Then("the account is created successfully with different valid names")
    public void theAccountIsCreatedSuccessfullyWithDifferentValidNames() {
        verifyAccountCreationWithDifferentNames();
    }

    @When("the account creation process is reflected across all user-related services")
    public void theAccountCreationProcessIsReflectedAcrossAllUserRelatedServices() {
        checkAccountReflectionAcrossServices();
    }

    @Then("all user-related services reflect the newly created account")
    public void allUserRelatedServicesReflectTheNewlyCreatedAccount() {
        verifyAccountReflectionInServices();
    }

    @When("verifying that the profanity filter does not trigger for non-profane names")
    public void verifyingThatTheProfanityFilterDoesNotTriggerForNonProfaneNames() {
        checkProfanityFilterForNonProfaneNames();
    }

    @Then("the profanity filter does not trigger for the name {string}")
    public void theProfanityFilterDoesNotTriggerForTheName(String name) {
        verifyProfanityFilterNotTriggered(name);
    }
}