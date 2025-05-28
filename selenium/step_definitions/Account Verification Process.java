package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountVerificationSteps extends AccountVerificationPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the customer is on the account verification page")
    public void theCustomerIsOnTheAccountVerificationPage() {
        navigateToAccountVerificationPage();
    }

    @When("the customer enters their account credentials")
    public void theCustomerEntersTheirAccountCredentials() {
        String username = testHarness.getData("AccountData", "UserName");
        String password = testHarness.getData("AccountData", "Password");
        enterUserName(username);
        enterPassword(password);
    }

    @When("the customer enters incorrect account credentials")
    public void theCustomerEntersIncorrectAccountCredentials() {
        String username = testHarness.getData("AccountData", "InvalidUserName");
        String password = testHarness.getData("AccountData", "InvalidPassword");
        enterUserName(username);
        enterPassword(password);
    }

    @When("clicks on the 'Verify Account' button")
    public void clicksOnTheVerifyAccountButton() {
        clickVerifyAccountButton();
    }

    @Then("the account verification is successful")
    public void theAccountVerificationIsSuccessful() {
        String expectedMessage = testHarness.getData("AccountData", "ExpectedSuccessMessage");
        verifyAccountSuccess(expectedMessage);
    }

    @Then("the account verification fails")
    public void theAccountVerificationFails() {
        String expectedErrorMessage = testHarness.getData("AccountData", "ExpectedErrorMessage");
        verifyAccountFailure(expectedErrorMessage);
    }

    @Then("the customer is redirected to their account details page")
    public void theCustomerIsRedirectedToTheirAccountDetailsPage() {
        String expectedURL = testHarness.getData("AccountData", "ExpectedAccountDetailsURL");
        verifyAccountDetailsPageRedirection(expectedURL);
    }

    @Then("an error message is displayed indicating the account verification failed")
    public void anErrorMessageIsDisplayedIndicatingTheAccountVerificationFailed() {
        String expectedErrorMessage = testHarness.getData("AccountData", "ExpectedErrorMessage");
        verifyErrorMessageDisplayed(expectedErrorMessage);
    }

    @Then("the account status is updated to 'Verified'")
    public void theAccountStatusIsUpdatedToVerified() {
        verifyAccountStatusUpdated("Verified");
    }

    @Then("the account status remains as 'Unverified'")
    public void theAccountStatusRemainsAsUnverified() {
        verifyAccountStatusUpdated("Unverified");
    }

    @Then("the customer can access account features")
    public void theCustomerCanAccessAccountFeatures() {
        verifyAccessToAccountFeatures();
    }

    @Then("the customer is able to logout from the account")
    public void theCustomerIsAbleToLogoutFromTheAccount() {
        performLogout();
    }

    @Then("the customer is not able to access their account details page")
    public void theCustomerIsNotAbleToAccessTheirAccountDetailsPage() {
        verifyNoAccessToAccountDetailsPage();
    }
}