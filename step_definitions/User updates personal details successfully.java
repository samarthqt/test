package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ProfileSettingsPage;

public class ProfileSettingsSteps extends ProfileSettingsPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a user account with valid login credentials")
    public void aUserAccountWithValidLoginCredentials() {
        // Assume user credentials are valid and stored in test data
    }

    @When("the user logs in to the user account")
    public void theUserLogsInToTheUserAccount() {
        String username = testHarness.getData("LoginData", "UserName");
        String password = testHarness.getData("LoginData", "Password");
        login(username, password);
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
        verifyProfileSettingsPageDisplayed();
    }

    @When("the user updates the name field with \"John Doe\"")
    public void theUserUpdatesTheNameFieldWithJohnDoe() {
        updateName("John Doe");
    }

    @Then("the name field is updated with \"John Doe\"")
    public void theNameFieldIsUpdatedWithJohnDoe() {
        verifyNameUpdated("John Doe");
    }

    @When("the user updates the email field with \"john.doe@example.com\"")
    public void theUserUpdatesTheEmailFieldWithJohnDoeExampleCom() {
        updateEmail("john.doe@example.com");
    }

    @Then("the email field is updated with \"john.doe@example.com\"")
    public void theEmailFieldIsUpdatedWithJohnDoeExampleCom() {
        verifyEmailUpdated("john.doe@example.com");
    }

    @When("the user updates the shipping address field with \"123 Elm St, Springfield\"")
    public void theUserUpdatesTheShippingAddressFieldWith123ElmStSpringfield() {
        updateShippingAddress("123 Elm St, Springfield");
    }

    @Then("the shipping address field is updated with \"123 Elm St, Springfield\"")
    public void theShippingAddressFieldIsUpdatedWith123ElmStSpringfield() {
        verifyShippingAddressUpdated("123 Elm St, Springfield");
    }

    @When("the user updates the billing address field with \"123 Elm St, Springfield\"")
    public void theUserUpdatesTheBillingAddressFieldWith123ElmStSpringfield() {
        updateBillingAddress("123 Elm St, Springfield");
    }

    @Then("the billing address field is updated with \"123 Elm St, Springfield\"")
    public void theBillingAddressFieldIsUpdatedWith123ElmStSpringfield() {
        verifyBillingAddressUpdated("123 Elm St, Springfield");
    }

    @When("the user updates the phone number field with \"123-456-7890\"")
    public void theUserUpdatesThePhoneNumberFieldWith1234567890() {
        updatePhoneNumber("123-456-7890");
    }

    @Then("the phone number field is updated with \"123-456-7890\"")
    public void thePhoneNumberFieldIsUpdatedWith1234567890() {
        verifyPhoneNumberUpdated("123-456-7890");
    }

    @When("the user saves the changes made to the profile")
    public void theUserSavesTheChangesMadeToTheProfile() {
        saveProfileChanges();
    }

    @Then("the changes are saved successfully and a confirmation message is displayed")
    public void theChangesAreSavedSuccessfullyAndAConfirmationMessageIsDisplayed() {
        verifyChangesSaved();
    }

    @When("the user logs out and logs back in to verify updates")
    public void theUserLogsOutAndLogsBackInToVerifyUpdates() {
        logout();
        loginAgain();
    }

    @Then("the updated details are displayed correctly on the profile settings page")
    public void theUpdatedDetailsAreDisplayedCorrectlyOnTheProfileSettingsPage() {
        verifyUpdatedDetails();
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