package com.cucumber.steps;

import com.page_objects.SignUpPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpSteps extends SignUpPage {

    @Given("the user has access to the sign-up page")
    public void theUserHasAccessToTheSignUpPage() {
        navigateToSignUpPage();
    }

    @When("the user navigates to the sign-up page")
    public void theUserNavigatesToTheSignUpPage() {
        verifySignUpPageLoaded();
    }

    @Then("the sign-up page loads successfully")
    public void theSignUpPageLoadsSuccessfully() {
        assertSignUpPageLoaded();
    }

    @Given("the user has no existing account with the test email")
    public void theUserHasNoExistingAccountWithTheTestEmail() {
        checkNoExistingAccount();
    }

    @When("the user enters a valid email address in the email field")
    public void theUserEntersAValidEmailAddressInTheEmailField() {
        enterEmailAddress();
    }

    @Then("the email address is accepted without errors")
    public void theEmailAddressIsAcceptedWithoutErrors() {
        verifyEmailAccepted();
    }

    @Given("the user has a valid email address")
    public void theUserHasAValidEmailAddress() {
        ensureValidEmailAddress();
    }

    @When("the user enters a strong password in the password field")
    public void theUserEntersAStrongPasswordInThePasswordField() {
        enterStrongPassword();
    }

    @Then("the password is accepted and meets strength criteria")
    public void thePasswordIsAcceptedAndMeetsStrengthCriteria() {
        verifyPasswordStrength();
    }

    @Given("the user has entered a valid email address and strong password")
    public void theUserHasEnteredAValidEmailAddressAndStrongPassword() {
        ensureValidEmailAndPassword();
    }

    @When("the user fills in the required user details \(e.g., name, date of birth\)")
    public void theUserFillsInTheRequiredUserDetails() {
        fillUserDetails();
    }

    @Then("the user details are accepted without errors")
    public void theUserDetailsAreAcceptedWithoutErrors() {
        verifyUserDetailsAccepted();
    }

    @Given("the user has filled in the required user details")
    public void theUserHasFilledInTheRequiredUserDetails() {
        ensureUserDetailsFilled();
    }

    @When("the user agrees to the terms and conditions")
    public void theUserAgreesToTheTermsAndConditions() {
        agreeToTermsAndConditions();
    }

    @Then("the terms and conditions are agreed upon")
    public void theTermsAndConditionsAreAgreedUpon() {
        verifyTermsAgreed();
    }

    @Given("the user has agreed to the terms and conditions")
    public void theUserHasAgreedToTheTermsAndConditions() {
        ensureTermsAgreed();
    }

    @When("the user clicks the 'Sign Up' button")
    public void theUserClicksTheSignUpButton() {
        clickSignUpButton();
    }

    @Then("user registration is successful and a confirmation message is displayed")
    public void userRegistrationIsSuccessfulAndAConfirmationMessageIsDisplayed() {
        verifyRegistrationSuccess();
    }

    @Given("the user has successfully registered")
    public void theUserHasSuccessfullyRegistered() {
        ensureSuccessfulRegistration();
    }

    @When("the user checks the email inbox for a confirmation email")
    public void theUserChecksTheEmailInboxForAConfirmationEmail() {
        checkEmailInbox();
    }

    @Then("the confirmation email is received in the inbox")
    public void theConfirmationEmailIsReceivedInTheInbox() {
        verifyConfirmationEmailReceived();
    }

    @Given("the user has received a confirmation email")
    public void theUserHasReceivedAConfirmationEmail() {
        ensureConfirmationEmailReceived();
    }

    @When("the user clicks the confirmation link in the email")
    public void theUserClicksTheConfirmationLinkInTheEmail() {
        clickConfirmationLink();
    }

    @Then("the email is verified and the user is directed to the welcome page")
    public void theEmailIsVerifiedAndTheUserIsDirectedToTheWelcomePage() {
        verifyEmailAndRedirect();
    }

    @Given("the user has verified their email")
    public void theUserHasVerifiedTheirEmail() {
        ensureEmailVerified();
    }

    @When("the user attempts to log in with the registered email and password")
    public void theUserAttemptsToLogInWithTheRegisteredEmailAndPassword() {
        attemptLogin();
    }

    @Then("login is successful and the user is directed to the dashboard")
    public void loginIsSuccessfulAndTheUserIsDirectedToTheDashboard() {
        verifyLoginSuccess();
    }

    @Given("the user is on the dashboard")
    public void theUserIsOnTheDashboard() {
        ensureOnDashboard();
    }

    @When("the user verifies the account details")
    public void theUserVerifiesTheAccountDetails() {
        verifyAccountDetails();
    }

    @Then("account details are accurate and reflect the registration information")
    public void accountDetailsAreAccurateAndReflectTheRegistrationInformation() {
        assertAccountDetailsAccuracy();
    }

    @Given("the user is logged into the dashboard")
    public void theUserIsLoggedIntoTheDashboard() {
        ensureLoggedIn();
    }

    @When("the user logs out and attempts to log back in")
    public void theUserLogsOutAndAttemptsToLogBackIn() {
        logoutAndLogin();
    }

    @Then("the user can log back in successfully with the registered credentials")
    public void theUserCanLogBackInSuccessfullyWithTheRegisteredCredentials() {
        verifyReLoginSuccess();
    }

    @Given("the user is attempting to sign up")
    public void theUserIsAttemptingToSignUp() {
        initiateSignUp();
    }

    @When("the user completes the sign-up process")
    public void theUserCompletesTheSignUpProcess() {
        completeSignUpProcess();
    }

    @Then("no error messages are displayed during the sign-up process")
    public void noErrorMessagesAreDisplayedDuringTheSignUpProcess() {
        verifyNoSignUpErrors();
    }

    @Given("the user has a registered account")
    public void theUserHasARegisteredAccount() {
        ensureRegisteredAccount();
    }

    @When("the user attempts to recover the password")
    public void theUserAttemptsToRecoverThePassword() {
        attemptPasswordRecovery();
    }

    @Then("the password recovery process functions correctly")
    public void thePasswordRecoveryProcessFunctionsCorrectly() {
        verifyPasswordRecovery();
    }

    @Given("the user is attempting to sign up on {string} using {string}")
    public void theUserIsAttemptingToSignUpOnDeviceUsingBrowser(String device, String browser) {
        initiateSignUpOnDevice(device, browser);
    }

    @When("the user completes the sign-up process")
    public void theUserCompletesTheSignUpProcessOnDevice() {
        completeSignUpProcess();
    }

    @Then("the sign-up process works consistently across devices and browsers")
    public void theSignUpProcessWorksConsistentlyAcrossDevicesAndBrowsers() {
        verifySignUpConsistency();
    }

    @Given("the user is attempting to register with an existing email")
    public void theUserIsAttemptingToRegisterWithAnExistingEmail() {
        attemptDuplicateRegistration();
    }

    @When("the user tries to sign up")
    public void theUserTriesToSignUp() {
        trySignUp();
    }

    @Then("the system prevents duplicate registrations and provides appropriate feedback")
    public void theSystemPreventsDuplicateRegistrationsAndProvidesAppropriateFeedback() {
        verifyDuplicateRegistrationPrevention();
    }
}