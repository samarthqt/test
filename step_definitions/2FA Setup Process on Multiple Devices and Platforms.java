package com.cucumber.steps;

import com.page_objects.TwoFASetupPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TwoFASetupSteps extends TwoFASetupPage {

    @Given("a user account with 2FA not yet set up")
    public void aUserAccountWith2FANotYetSetUp() {
        verify2FANotSetUp();
    }

    @When("the user logs in to the application on a desktop device")
    public void theUserLogsInToTheApplicationOnADesktopDevice() {
        loginToApplication();
    }

    @Then("the user is successfully logged in and directed to the dashboard")
    public void theUserIsSuccessfullyLoggedInAndDirectedToTheDashboard() {
        verifyDashboardRedirection();
    }

    @When("the user navigates to the account security settings")
    public void theUserNavigatesToTheAccountSecuritySettings() {
        navigateToSecuritySettings();
    }

    @Then("the security settings page is displayed, showing 2FA options")
    public void theSecuritySettingsPageIsDisplayedShowing2FAOptions() {
        verifySecuritySettingsPage();
    }

    @When("the user selects the option to enable 2FA")
    public void theUserSelectsTheOptionToEnable2FA() {
        selectEnable2FAOption();
    }

    @Then("the user is prompted to choose a 2FA method")
    public void theUserIsPromptedToChooseA2FAMethod() {
        verify2FAMethodPrompt();
    }

    @When("the user chooses to receive 2FA codes via SMS")
    public void theUserChoosesToReceive2FACodesViaSMS() {
        chooseSMSMethod();
    }

    @Then("the user is prompted to enter their mobile number")
    public void theUserIsPromptedToEnterTheirMobileNumber() {
        verifyMobileNumberPrompt();
    }

    @When("the user enters a valid mobile number and submits")
    public void theUserEntersAValidMobileNumberAndSubmits() {
        enterAndSubmitMobileNumber();
    }

    @Then("a verification code is sent to the provided mobile number")
    public void aVerificationCodeIsSentToTheProvidedMobileNumber() {
        verifyCodeSentToMobile();
    }

    @When("the user enters the received verification code")
    public void theUserEntersTheReceivedVerificationCode() {
        enterVerificationCode();
    }

    @Then("2FA setup is completed successfully, and confirmation is displayed")
    public void twoFASetupIsCompletedSuccessfullyAndConfirmationIsDisplayed() {
        verify2FASetupCompletion();
    }

    @Given("2FA is set up via SMS")
    public void twoFAIsSetUpViaSMS() {
        verify2FASetupViaSMS();
    }

    @When("the user logs out and attempts to log in again on a smartphone")
    public void theUserLogsOutAndAttemptsToLogInAgainOnASmartphone() {
        logoutAndLoginOnSmartphone();
    }

    @Then("the user is prompted for a 2FA code after entering their credentials")
    public void theUserIsPromptedForA2FACodeAfterEnteringTheirCredentials() {
        verify2FACodePrompt();
    }

    @When("the user enters the correct 2FA code")
    public void theUserEntersTheCorrect2FACode() {
        enterCorrect2FACode();
    }

    @Then("the user is successfully logged in on the smartphone")
    public void theUserIsSuccessfullyLoggedInOnTheSmartphone() {
        verifySmartphoneLoginSuccess();
    }

    @When("the user repeats the login and 2FA process on a tablet")
    public void theUserRepeatsTheLoginAnd2FAProcessOnATablet() {
        repeatLoginAnd2FAOnTablet();
    }

    @Then("the user is successfully logged in on the tablet after entering the 2FA code")
    public void theUserIsSuccessfullyLoggedInOnTheTabletAfterEnteringThe2FACode() {
        verifyTabletLoginSuccess();
    }

    @When("the user navigates to account settings")
    public void theUserNavigatesToAccountSettings() {
        navigateToAccountSettings();
    }

    @Then("2FA is shown as enabled on all devices")
    public void twoFAIsShownAsEnabledOnAllDevices() {
        verify2FAEnabledOnAllDevices();
    }

    @When("the user attempts to disable 2FA from one of the devices")
    public void theUserAttemptsToDisable2FAFromOneOfTheDevices() {
        attemptToDisable2FA();
    }

    @Then("the user is prompted to enter a confirmation code sent to the registered mobile number")
    public void theUserIsPromptedToEnterAConfirmationCodeSentToTheRegisteredMobileNumber() {
        verifyConfirmationCodePrompt();
    }

    @When("the user enters the correct confirmation code to disable 2FA")
    public void theUserEntersTheCorrectConfirmationCodeToDisable2FA() {
        enterCorrectConfirmationCode();
    }

    @Then("2FA is successfully disabled, and confirmation is displayed")
    public void twoFAIsSuccessfullyDisabledAndConfirmationIsDisplayed() {
        verify2FADisabledConfirmation();
    }

    @Given("2FA is disabled")
    public void twoFAIsDisabled() {
        verify2FADisabled();
    }

    @When("the user enables 2FA again using an authenticator app")
    public void theUserEnables2FAAgainUsingAnAuthenticatorApp() {
        enable2FAWithAuthenticatorApp();
    }

    @Then("the user is prompted to scan a QR code with the authenticator app")
    public void theUserIsPromptedToScanAQRCodeWithTheAuthenticatorApp() {
        verifyQRCodePrompt();
    }

    @When("the user scans the QR code and enters the generated code from the authenticator app")
    public void theUserScansTheQRCodeAndEntersTheGeneratedCodeFromTheAuthenticatorApp() {
        scanQRCodeAndEnterGeneratedCode();
    }

    @Then("2FA setup is completed with the authenticator app, and confirmation is displayed")
    public void twoFASetupIsCompletedWithTheAuthenticatorAppAndConfirmationIsDisplayed() {
        verifyAuthenticatorAppSetupCompletion();
    }

    @Given("2FA is set up with an authenticator app")
    public void twoFAIsSetUpWithAnAuthenticatorApp() {
        verify2FASetupWithAuthenticatorApp();
    }

    @When("the user attempts to log in on all devices")
    public void theUserAttemptsToLogInOnAllDevices() {
        attemptLoginOnAllDevices();
    }

    @Then("the user is able to log in on all devices using the authenticator app for 2FA")
    public void theUserIsAbleToLogInOnAllDevicesUsingTheAuthenticatorAppFor2FA() {
        verifyLoginSuccessOnAllDevices();
    }
}