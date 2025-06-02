package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.AccountCreationPage;

public class AccountCreationSteps extends AccountCreationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I navigate to the account creation page")
    public void iNavigateToTheAccountCreationPage() {
        navigateToAccountCreationPage();
    }

    @When("I select the \"Sign up with Email\" option")
    public void iSelectTheSignUpWithEmailOption() {
        selectSignUpWithEmailOption();
    }

    @When("I enter the email address \"testuser@example.com\" and fill in the required details")
    public void iEnterTheEmailAddressAndFillInTheRequiredDetails() {
        enterEmailAndDetails("testuser@example.com");
    }

    @When("I submit the email sign-up form")
    public void iSubmitTheEmailSignUpForm() {
        submitEmailSignUpForm();
    }

    @Then("an account is created successfully using the email address")
    public void anAccountIsCreatedSuccessfullyUsingTheEmailAddress() {
        verifyEmailAccountCreation();
    }

    @Given("I am logged out and on the account creation page")
    public void iAmLoggedOutAndOnTheAccountCreationPage() {
        ensureLoggedOut();
        navigateToAccountCreationPage();
    }

    @When("I select the \"Sign up with Google\" option")
    public void iSelectTheSignUpWithGoogleOption() {
        selectSignUpWithGoogleOption();
    }

    @When("I authenticate using Google account \"googleuser@gmail.com\"")
    public void iAuthenticateUsingGoogleAccount() {
        authenticateWithGoogle("googleuser@gmail.com");
    }

    @Then("Google authentication is successful and account is created")
    public void googleAuthenticationIsSuccessfulAndAccountIsCreated() {
        verifyGoogleAccountCreation();
    }

    @When("I select the \"Sign up with Facebook\" option")
    public void iSelectTheSignUpWithFacebookOption() {
        selectSignUpWithFacebookOption();
    }

    @When("I authenticate using Facebook account \"fbuser@facebook.com\"")
    public void iAuthenticateUsingFacebookAccount() {
        authenticateWithFacebook("fbuser@facebook.com");
    }

    @Then("Facebook authentication is successful and account is created")
    public void facebookAuthenticationIsSuccessfulAndAccountIsCreated() {
        verifyFacebookAccountCreation();
    }

    @Given("accounts are created using email, Google, and Facebook")
    public void accountsAreCreatedUsingEmailGoogleAndFacebook() {
        verifyAllAccountsCreated();
    }

    @When("I attempt to log in using each account")
    public void iAttemptToLogInUsingEachAccount() {
        attemptLoginWithAllAccounts();
    }

    @Then("I am able to log in using email, Google, and Facebook accounts")
    public void iAmAbleToLogInUsingEmailGoogleAndFacebookAccounts() {
        verifyLoginWithAllAccounts();
    }

    @When("I check for any confirmation email or notification received after account creation")
    public void iCheckForAnyConfirmationEmailOrNotificationReceivedAfterAccountCreation() {
        checkForConfirmationEmails();
    }

    @Then("confirmation email or notification is received for each account creation method")
    public void confirmationEmailOrNotificationIsReceivedForEachAccountCreationMethod() {
        verifyConfirmationEmailsReceived();
    }

    @When("I verify the user account details")
    public void iVerifyTheUserAccountDetails() {
        verifyUserAccountDetails();
    }

    @Then("user account details are accurate and match the information provided during sign-up")
    public void userAccountDetailsAreAccurateAndMatchTheInformationProvidedDuringSignUp() {
        assertUserDetailsAccuracy();
    }

    @Given("there is an existing account with the email \"testuser@example.com\"")
    public void thereIsAnExistingAccountWithTheEmail() {
        ensureAccountExists("testuser@example.com");
    }

    @When("I attempt to create another account using the same email")
    public void iAttemptToCreateAnotherAccountUsingTheSameEmail() {
        attemptDuplicateEmailAccountCreation("testuser@example.com");
    }

    @Then("the system displays an error message indicating the email is already registered")
    public void theSystemDisplaysAnErrorMessageIndicatingTheEmailIsAlreadyRegistered() {
        verifyDuplicateEmailErrorMessage();
    }

    @Given("I am on the account creation page")
    public void iAmOnTheAccountCreationPage() {
        navigateToAccountCreationPage();
    }

    @When("I initiate an account creation request")
    public void iInitiateAnAccountCreationRequest() {
        initiateAccountCreationRequest();
    }

    @Then("the system responds promptly to account creation requests")
    public void theSystemRespondsPromptlyToAccountCreationRequests() {
        verifyAccountCreationResponseTime();
    }
}