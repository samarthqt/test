package com.cucumber.steps;

import com.page_objects.AccountManagementPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountManagementSteps extends AccountManagementPage {

    @Given("a user wants to recover their password")
    public void userWantsToRecoverPassword() {
        navigateToRecoveryOptions();
    }

    @When("the user selects the {string} option")
    public void userSelectsRecoveryOption(String option) {
        selectRecoveryOption(option);
    }

    @When("the user chooses to receive recovery details via {string}")
    public void userChoosesRecoveryMethod(String method) {
        chooseRecoveryMethod(method);
    }

    @Then("the system sends a recovery {string} to the user's registered {string}")
    public void systemSendsRecoveryDetails(String type, String destination) {
        verifyRecoveryDetailsSent(type, destination);
    }

    @Then("the user can reset their password using the link in the email")
    public void userCanResetPasswordViaEmail() {
        verifyPasswordResetLink();
    }

    @Then("the user can reset their password using the code in the SMS")
    public void userCanResetPasswordViaSMS() {
        verifyPasswordResetCode();
    }

    @Given("a user wants to update their personal information")
    public void userWantsToUpdatePersonalInformation() {
        navigateToAccountSettings();
    }

    @When("the user navigates to the account settings")
    public void userNavigatesToAccountSettings() {
        openAccountSettings();
    }

    @When("the user updates their name, address, or phone number")
    public void userUpdatesPersonalInformation() {
        updatePersonalInformation();
    }

    @Then("the system saves the updated information successfully")
    public void systemSavesUpdatedInformation() {
        verifyInformationSaved();
    }

    @Then("the changes are reflected in the user's account details")
    public void changesReflectedInAccountDetails() {
        verifyAccountDetailsUpdated();
    }

    @Given("a user wants to change their password")
    public void userWantsToChangePassword() {
        navigateToChangePasswordSection();
    }

    @When("the user navigates to the change password section")
    public void userNavigatesToChangePasswordSection() {
        openChangePasswordSection();
    }

    @When("the user enters their current password and a new password")
    public void userEntersCurrentAndNewPassword() {
        enterCurrentAndNewPassword();
    }

    @Then("the system validates the new password for security")
    public void systemValidatesNewPassword() {
        validateNewPassword();
    }

    @Then("the system updates the password if validation passes")
    public void systemUpdatesPassword() {
        updatePassword();
    }

    @Then("the user receives a confirmation of the password change")
    public void userReceivesPasswordChangeConfirmation() {
        verifyPasswordChangeConfirmation();
    }

    @Given("a user wants to view their past orders")
    public void userWantsToViewPastOrders() {
        navigateToOrderHistorySection();
    }

    @When("the user navigates to the order history section")
    public void userNavigatesToOrderHistorySection() {
        openOrderHistorySection();
    }

    @Then("the system displays a list of past orders with details")
    public void systemDisplaysPastOrders() {
        verifyPastOrdersDisplayed();
    }

    @Then("each order shows the order date, items, and status")
    public void eachOrderShowsDetails() {
        verifyOrderDetails();
    }

    @Given("a user wants to track their order delivery")
    public void userWantsToTrackOrderDelivery() {
        navigateToOrderTrackingSection();
    }

    @When("the user navigates to the order tracking section")
    public void userNavigatesToOrderTrackingSection() {
        openOrderTrackingSection();
    }

    @When("the user enters their tracking number")
    public void userEntersTrackingNumber() {
        enterTrackingNumber();
    }

    @Then("the system displays the current delivery status of the order")
    public void systemDisplaysDeliveryStatus() {
        verifyDeliveryStatusDisplayed();
    }

    @Given("a user wants to manage their wishlist")
    public void userWantsToManageWishlist() {
        navigateToWishlistSection();
    }

    @When("the user navigates to the wishlist section")
    public void userNavigatesToWishlistSection() {
        openWishlistSection();
    }

    @When("the user adds an item to the wishlist")
    public void userAddsItemToWishlist() {
        addItemToWishlist();
    }

    @Then("the system adds the item to the user's wishlist")
    public void systemAddsItemToWishlist() {
        verifyItemAddedToWishlist();
    }

    @When("the user removes an item from the wishlist")
    public void userRemovesItemFromWishlist() {
        removeItemFromWishlist();
    }

    @Then("the system removes the item from the user's wishlist")
    public void systemRemovesItemFromWishlist() {
        verifyItemRemovedFromWishlist();
    }

    @Given("a user performs any account management action")
    public void userPerformsAccountManagementAction() {
        performAccountManagementAction();
    }

    @Then("the system logs the action for auditing purposes")
    public void systemLogsActionForAuditing() {
        verifyActionLoggedForAuditing();
    }

    @Then("the log includes details of the action performed")
    public void logIncludesActionDetails() {
        verifyLogDetails();
    }

    @Given("a user encounters an error while managing their account")
    public void userEncountersError() {
        simulateErrorEncounter();
    }

    @Then("the system handles the error gracefully")
    public void systemHandlesErrorGracefully() {
        verifyErrorHandledGracefully();
    }

    @Then("the system provides a user-friendly error message")
    public void systemProvidesErrorMessage() {
        verifyUserFriendlyErrorMessage();
    }

    @Given("a user manages their account")
    public void userManagesAccount() {
        manageUserAccount();
    }

    @Then("the system ensures compliance with GDPR")
    public void systemEnsuresGDPRCompliance() {
        verifyGDPRCompliance();
    }

    @Then("the user's data is protected according to GDPR standards")
    public void userDataProtectedByGDPR() {
        verifyDataProtectionByGDPR();
    }
}