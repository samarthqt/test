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
        verifyAccountCreationPageDisplayed();
    }

    @When("the user enters {string} in the first name field")
    public void theUserEntersInTheFirstNameField(String firstName) {
        enterFirstName(firstName);
    }

    @When("the user enters {string} in the last name field")
    public void theUserEntersInTheLastNameField(String lastName) {
        enterLastName(lastName);
    }

    @When("the user enters {string} in the email field")
    public void theUserEntersInTheEmailField(String email) {
        enterEmail(email);
    }

    @When("the user enters {string} in the password field")
    public void theUserEntersInThePasswordField(String password) {
        enterPassword(password);
    }

    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonName) {
        if (buttonName.equals("Create Account")) {
            clickCreateAccountButton();
        }
    }

    @Then("verify that the account is created successfully")
    public void verifyThatTheAccountIsCreatedSuccessfully() {
        verifyAccountCreationSuccess();
    }

    @Then("the user is redirected to the welcome page with a success message")
    public void theUserIsRedirectedToTheWelcomePageWithASuccessMessage() {
        verifyRedirectionToWelcomePage();
    }

    @Then("check the system logs for any errors during the account creation process")
    public void checkTheSystemLogsForAnyErrorsDuringTheAccountCreationProcess() {
        verifyNoErrorsInSystemLogs();
    }

    @When("the user attempts to log in with the newly created account credentials")
    public void theUserAttemptsToLogInWithTheNewlyCreatedAccountCredentials() {
        attemptLoginWithNewAccount();
    }

    @Then("the user is able to log in successfully with the new account")
    public void theUserIsAbleToLogInSuccessfullyWithTheNewAccount() {
        verifyLoginSuccess();
    }

    @Then("verify the user receives a confirmation email about the account creation")
    public void verifyTheUserReceivesAConfirmationEmailAboutTheAccountCreation() {
        verifyConfirmationEmailReceived();
    }

    @Then("check the database to ensure the account details are stored correctly")
    public void checkTheDatabaseToEnsureTheAccountDetailsAreStoredCorrectly() {
        verifyAccountDetailsInDatabase();
    }

    @Then("monitor the server performance during the account creation process")
    public void monitorTheServerPerformanceDuringTheAccountCreationProcess() {
        monitorServerPerformance();
    }

    @When("the account creation process is repeated with different names containing whitelisted words")
    public void theAccountCreationProcessIsRepeatedWithDifferentNamesContainingWhitelistedWords() {
        repeatAccountCreationWithWhitelistedNames();
    }

    @Then("ensure the account creation process is reflected across all user-related services")
    public void ensureTheAccountCreationProcessIsReflectedAcrossAllUserRelatedServices() {
        verifyAccountReflectionInServices();
    }

    @Then("verify that the profanity filter does not trigger for names containing whitelisted words")
    public void verifyThatTheProfanityFilterDoesNotTriggerForNamesContainingWhitelistedWords() {
        verifyProfanityFilterNotTriggered();
    }
}