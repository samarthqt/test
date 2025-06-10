package com.cucumber.steps;

import com.page_objects.UserAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserAccountSteps extends UserAccountPage {

    @Given("a user navigates to the sign-up page")
    public void aUserNavigatesToTheSignUpPage() {
        navigateToSignUpPage();
    }

    @When("the user enters valid email and password")
    public void theUserEntersValidEmailAndPassword() {
        enterEmailAndPassword();
    }

    @When("clicks on the sign-up button")
    public void clicksOnTheSignUpButton() {
        clickSignUpButton();
    }

    @Then("the user account should be created successfully")
    public void theUserAccountShouldBeCreatedSuccessfully() {
        verifyAccountCreation();
    }

    @When("the user selects the option to sign up with Google")
    public void theUserSelectsTheOptionToSignUpWithGoogle() {
        selectGoogleSignUp();
    }

    @When("completes the Google authentication process")
    public void completesTheGoogleAuthenticationProcess() {
        completeGoogleAuthentication();
    }

    @When("the user selects the option to sign up with Facebook")
    public void theUserSelectsTheOptionToSignUpWithFacebook() {
        selectFacebookSignUp();
    }

    @When("completes the Facebook authentication process")
    public void completesTheFacebookAuthenticationProcess() {
        completeFacebookAuthentication();
    }

    @Given("a user navigates to the password recovery page")
    public void aUserNavigatesToThePasswordRecoveryPage() {
        navigateToPasswordRecoveryPage();
    }

    @When("the user enters their registered email address")
    public void theUserEntersTheirRegisteredEmailAddress() {
        enterRegisteredEmail();
    }

    @When("clicks on the recover password button")
    public void clicksOnTheRecoverPasswordButton() {
        clickRecoverPasswordButton();
    }

    @Then("a password recovery email should be sent to the user")
    public void aPasswordRecoveryEmailShouldBeSentToTheUser() {
        verifyPasswordRecoveryEmailSent();
    }

    @Given("a user is logged in")
    public void aUserIsLoggedIn() {
        verifyUserLoggedIn();
    }

    @When("the user navigates to the personal information page")
    public void theUserNavigatesToThePersonalInformationPage() {
        navigateToPersonalInformationPage();
    }

    @When("updates their personal information")
    public void updatesTheirPersonalInformation() {
        updatePersonalInformation();
    }

    @When("clicks on the save button")
    public void clicksOnTheSaveButton() {
        clickSaveButton();
    }

    @Then("the user's personal information should be updated successfully")
    public void theUsersPersonalInformationShouldBeUpdatedSuccessfully() {
        verifyPersonalInformationUpdated();
    }

    @When("the user navigates to the order history page")
    public void theUserNavigatesToTheOrderHistoryPage() {
        navigateToOrderHistoryPage();
    }

    @Then("the user should be able to see a detailed view of past orders")
    public void theUserShouldBeAbleToSeeADetailedViewOfPastOrders() {
        verifyOrderHistoryDetails();
    }

    @When("the user navigates to the order tracking page")
    public void theUserNavigatesToTheOrderTrackingPage() {
        navigateToOrderTrackingPage();
    }

    @Then("the user should receive real-time updates on their order status")
    public void theUserShouldReceiveRealTimeUpdatesOnTheirOrderStatus() {
        verifyRealTimeOrderUpdates();
    }

    @When("the user navigates to the wishlist page")
    public void theUserNavigatesToTheWishlistPage() {
        navigateToWishlistPage();
    }

    @When("adds, removes, or organizes products")
    public void addsRemovesOrOrganizesProducts() {
        manageWishlist();
    }

    @Then("the wishlist should be updated accordingly")
    public void theWishlistShouldBeUpdatedAccordingly() {
        verifyWishlistUpdated();
    }

    @Given("a user account exists")
    public void aUserAccountExists() {
        verifyUserAccountExists();
    }

    @When("a user performs account-related actions")
    public void aUserPerformsAccountRelatedActions() {
        performAccountActions();
    }

    @Then("security measures should protect user data")
    public void securityMeasuresShouldProtectUserData() {
        verifySecurityMeasures();
    }

    @When("the user updates account information")
    public void theUserUpdatesAccountInformation() {
        updateAccountInformation();
    }

    @Then("a notification should be sent to the user")
    public void aNotificationShouldBeSentToTheUser() {
        verifyNotificationSent();
    }

    @Given("a user performs an invalid action")
    public void aUserPerformsAnInvalidAction() {
        performInvalidAction();
    }

    @When("the system detects the error")
    public void theSystemDetectsTheError() {
        detectError();
    }

    @Then("appropriate error messages should be displayed to the user")
    public void appropriateErrorMessagesShouldBeDisplayedToTheUser() {
        verifyErrorMessagesDisplayed();
    }

    @Given("a user has access to the account management features")
    public void aUserHasAccessToTheAccountManagementFeatures() {
        verifyAccessToAccountFeatures();
    }

    @When("the user interacts with each feature")
    public void theUserInteractsWithEachFeature() {
        interactWithAccountFeatures();
    }

    @Then("each feature should function as expected without errors")
    public void eachFeatureShouldFunctionAsExpectedWithoutErrors() {
        verifyFeatureFunctionality();
    }
}