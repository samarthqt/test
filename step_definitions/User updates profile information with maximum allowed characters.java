package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ProfilePage;

public class ProfileSteps extends ProfilePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has valid login credentials")
    public void theUserHasValidLoginCredentials() {
        String username = testHarness.getData("LoginData", "Username");
        String password = testHarness.getData("LoginData", "Password");
        login(username, password);
    }

    @When("the user logs in to the account")
    public void theUserLogsInToTheAccount() {
        verifyLoginSuccess();
    }

    @Then("the user is logged in successfully and redirected to the dashboard")
    public void theUserIsLoggedInSuccessfullyAndRedirectedToTheDashboard() {
        verifyDashboardRedirection();
    }

    @When("the user navigates to the profile settings page")
    public void theUserNavigatesToTheProfileSettingsPage() {
        navigateToProfileSettings();
    }

    @Then("the profile settings page is displayed with current user details")
    public void theProfileSettingsPageIsDisplayedWithCurrentUserDetails() {
        verifyProfileSettingsPage();
    }

    @When("the user updates the name field with maximum allowed characters of 50")
    public void theUserUpdatesTheNameFieldWithMaximumAllowedCharactersOf50() {
        String maxName = testHarness.getData("ProfileData", "MaxName");
        updateName(maxName);
    }

    @Then("the name field is updated with maximum allowed characters")
    public void theNameFieldIsUpdatedWithMaximumAllowedCharacters() {
        verifyNameUpdate();
    }

    @When("the user updates the email field with maximum allowed characters of 100")
    public void theUserUpdatesTheEmailFieldWithMaximumAllowedCharactersOf100() {
        String maxEmail = testHarness.getData("ProfileData", "MaxEmail");
        updateEmail(maxEmail);
    }

    @Then("the email field is updated with maximum allowed characters")
    public void theEmailFieldIsUpdatedWithMaximumAllowedCharacters() {
        verifyEmailUpdate();
    }

    @When("the user updates the shipping address field with maximum allowed characters of 200")
    public void theUserUpdatesTheShippingAddressFieldWithMaximumAllowedCharactersOf200() {
        String maxShippingAddress = testHarness.getData("ProfileData", "MaxShippingAddress");
        updateShippingAddress(maxShippingAddress);
    }

    @Then("the shipping address field is updated with maximum allowed characters")
    public void theShippingAddressFieldIsUpdatedWithMaximumAllowedCharacters() {
        verifyShippingAddressUpdate();
    }

    @When("the user updates the billing address field with maximum allowed characters of 200")
    public void theUserUpdatesTheBillingAddressFieldWithMaximumAllowedCharactersOf200() {
        String maxBillingAddress = testHarness.getData("ProfileData", "MaxBillingAddress");
        updateBillingAddress(maxBillingAddress);
    }

    @Then("the billing address field is updated with maximum allowed characters")
    public void theBillingAddressFieldIsUpdatedWithMaximumAllowedCharacters() {
        verifyBillingAddressUpdate();
    }

    @When("the user updates the phone number field with maximum allowed characters of 15")
    public void theUserUpdatesThePhoneNumberFieldWithMaximumAllowedCharactersOf15() {
        String maxPhoneNumber = testHarness.getData("ProfileData", "MaxPhoneNumber");
        updatePhoneNumber(maxPhoneNumber);
    }

    @Then("the phone number field is updated with maximum allowed characters")
    public void thePhoneNumberFieldIsUpdatedWithMaximumAllowedCharacters() {
        verifyPhoneNumberUpdate();
    }

    @When("the user saves the changes made to the profile")
    public void theUserSavesTheChangesMadeToTheProfile() {
        saveProfileChanges();
    }

    @Then("the changes are saved successfully and a confirmation message is displayed")
    public void theChangesAreSavedSuccessfullyAndAConfirmationMessageIsDisplayed() {
        verifyProfileSaveConfirmation();
    }

    @When("the user logs out and logs back in to verify updates")
    public void theUserLogsOutAndLogsBackInToVerifyUpdates() {
        logoutAndLoginAgain();
    }

    @Then("the updated details are displayed correctly on the profile settings page")
    public void theUpdatedDetailsAreDisplayedCorrectlyOnTheProfileSettingsPage() {
        verifyUpdatedDetailsOnProfile();
    }

    @When("the user checks email for confirmation of changes")
    public void theUserChecksEmailForConfirmationOfChanges() {
        checkEmailForConfirmation();
    }

    @Then("email confirmation for each updated detail is received")
    public void emailConfirmationForEachUpdatedDetailIsReceived() {
        verifyEmailConfirmation();
    }
}