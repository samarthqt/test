package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.AccountSettingsPage;

public class AccountSettingsSteps extends AccountSettingsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user account is active with User ID: 12345")
    public void theUserAccountIsActiveWithUserID() {
        verifyUserAccountActive("12345");
    }

    @When("the user navigates to account settings")
    public void theUserNavigatesToAccountSettings() {
        navigateToAccountSettings();
    }

    @Then("the account settings page is displayed")
    public void theAccountSettingsPageIsDisplayed() {
        verifyAccountSettingsPageDisplayed();
    }

    @Then("2FA options must be available")
    public void twoFAOptionsMustBeAvailable() {
        verify2FAOptionsAvailable();
    }

    @When("the user locates the 2FA section")
    public void theUserLocatesThe2FASection() {
        locate2FASection();
    }

    @Then("the 2FA section is visible with options")
    public void the2FASectionIsVisibleWithOptions() {
        verify2FASectionVisible();
    }

    @When("the user selects SMS as the 2FA method")
    public void theUserSelectsSMSAsThe2FAMethod() {
        selectSMS2FAMethod();
    }

    @Then("the SMS option is selected")
    public void theSMSOptionIsSelected() {
        verifySMSOptionSelected();
    }

    @When("the user enters a valid phone number for SMS verification")
    public void theUserEntersAValidPhoneNumberForSMSVerification() {
        enterPhoneNumberForSMSVerification("+1234567890");
    }

    @Then("the phone number \"\+1234567890\" is entered successfully")
    public void thePhoneNumberIsEnteredSuccessfully() {
        verifyPhoneNumberEntered("+1234567890");
    }

    @When("the user submits the SMS verification request")
    public void theUserSubmitsTheSMSVerificationRequest() {
        submitSMSVerificationRequest();
    }

    @Then("the SMS verification request is submitted")
    public void theSMSVerificationRequestIsSubmitted() {
        verifySMSVerificationRequestSubmitted();
    }

    @When("the user verifies receipt of SMS verification code")
    public void theUserVerifiesReceiptOfSMSVerificationCode() {
        verifyReceiptOfSMSVerificationCode();
    }

    @Then("the SMS verification code is received")
    public void theSMSVerificationCodeIsReceived() {
        verifySMSVerificationCodeReceived();
    }

    @When("the user enters the SMS verification code")
    public void theUserEntersTheSMSVerificationCode() {
        enterSMSVerificationCode();
    }

    @Then("the SMS verification code is entered successfully")
    public void theSMSVerificationCodeIsEnteredSuccessfully() {
        verifySMSVerificationCodeEntered();
    }

    @When("the user confirms 2FA setup via SMS")
    public void theUserConfirms2FASetupViaSMS() {
        confirm2FASetupViaSMS();
    }

    @Then("the 2FA setup via SMS is confirmed")
    public void the2FASetupViaSMSIsConfirmed() {
        verify2FASetupViaSMSConfirmed();
    }

    @Given("the user switches to email as the 2FA method")
    public void theUserSwitchesToEmailAsThe2FAMethod() {
        switchToEmail2FAMethod();
    }

    @Then("the email option is selected")
    public void theEmailOptionIsSelected() {
        verifyEmailOptionSelected();
    }

    @When("the user enters a valid email address for verification")
    public void theUserEntersAValidEmailAddressForVerification() {
        enterEmailAddressForVerification("user@example.com");
    }

    @Then("the email address \"user@example.com\" is entered successfully")
    public void theEmailAddressIsEnteredSuccessfully() {
        verifyEmailAddressEntered("user@example.com");
    }

    @When("the user submits the email verification request")
    public void theUserSubmitsTheEmailVerificationRequest() {
        submitEmailVerificationRequest();
    }

    @Then("the email verification request is submitted")
    public void theEmailVerificationRequestIsSubmitted() {
        verifyEmailVerificationRequestSubmitted();
    }

    @When("the user verifies receipt of email verification code")
    public void theUserVerifiesReceiptOfEmailVerificationCode() {
        verifyReceiptOfEmailVerificationCode();
    }

    @Then("the email verification code is received")
    public void theEmailVerificationCodeIsReceived() {
        verifyEmailVerificationCodeReceived();
    }

    @When("the user enters the email verification code")
    public void theUserEntersTheEmailVerificationCode() {
        enterEmailVerificationCode();
    }

    @Then("the email verification code is entered successfully")
    public void theEmailVerificationCodeIsEnteredSuccessfully() {
        verifyEmailVerificationCodeEntered();
    }

    @When("the user confirms 2FA setup via email")
    public void theUserConfirms2FASetupViaEmail() {
        confirm2FASetupViaEmail();
    }

    @Then("the 2FA setup via email is confirmed")
    public void the2FASetupViaEmailIsConfirmed() {
        verify2FASetupViaEmailConfirmed();
    }

    @Given("the user switches to authenticator app as the 2FA method")
    public void theUserSwitchesToAuthenticatorAppAsThe2FAMethod() {
        switchToAuthenticatorApp2FAMethod();
    }

    @Then("the authenticator app option is selected")
    public void theAuthenticatorAppOptionIsSelected() {
        verifyAuthenticatorAppOptionSelected();
    }

    @When("the user enables authenticator app for verification")
    public void theUserEnablesAuthenticatorAppForVerification() {
        enableAuthenticatorAppForVerification();
    }

    @Then("the authenticator app is enabled successfully")
    public void theAuthenticatorAppIsEnabledSuccessfully() {
        verifyAuthenticatorAppEnabled();
    }

    @When("the user verifies receipt of authenticator app code")
    public void theUserVerifiesReceiptOfAuthenticatorAppCode() {
        verifyReceiptOfAuthenticatorAppCode();
    }

    @Then("the authenticator app code is received")
    public void theAuthenticatorAppCodeIsReceived() {
        verifyAuthenticatorAppCodeReceived();
    }

    @When("the user enters the authenticator app code")
    public void theUserEntersTheAuthenticatorAppCode() {
        enterAuthenticatorAppCode();
    }

    @Then("the authenticator app code is entered successfully")
    public void theAuthenticatorAppCodeIsEnteredSuccessfully() {
        verifyAuthenticatorAppCodeEntered();
    }

    @When("the user confirms 2FA setup via authenticator app")
    public void theUserConfirms2FASetupViaAuthenticatorApp() {
        confirm2FASetupViaAuthenticatorApp();
    }

    @Then("the 2FA setup via authenticator app is confirmed")
    public void the2FASetupViaAuthenticatorAppIsConfirmed() {
        verify2FASetupViaAuthenticatorAppConfirmed();
    }

    @Given("the user has completed 2FA setup via SMS, email, and authenticator app")
    public void theUserHasCompleted2FASetupViaSMSAndEmailAndAuthenticatorApp() {
        verify2FASetupCompleted();
    }

    @When("the user checks the 2FA status in user profile")
    public void theUserChecksThe2FAStatusInUserProfile() {
        check2FAStatusInUserProfile();
    }

    @Then("the 2FA status shows as enabled")
    public void the2FAStatusShowsAsEnabled() {
        verify2FAStatusEnabled();
    }
}