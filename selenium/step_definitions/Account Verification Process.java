package com.cucumber.steps;

import com.page_objects.AccountVerificationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountVerificationSteps extends AccountVerificationPage {

    @Given("the customer is on the account verification page")
    public void theCustomerIsOnTheAccountVerificationPage() {
        launchAccountVerificationPage();
    }

    @When("the customer enters their account credentials")
    public void theCustomerEntersTheirAccountCredentials() {
        String username = testHarness.getData("AccountData", "Username");
        String password = testHarness.getData("AccountData", "Password");
        enterAccountCredentials(username, password);
    }

    @When("the customer enters incorrect account credentials")
    public void theCustomerEntersIncorrectAccountCredentials() {
        String username = testHarness.getData("AccountData", "InvalidUsername");
        String password = testHarness.getData("AccountData", "InvalidPassword");
        enterAccountCredentials(username, password);
    }

    @When("clicks on the 'Verify Account' button")
    public void clicksOnTheVerifyAccountButton() {
        clickVerifyAccountButton();
    }

    @Then("the account verification is successful")
    public void theAccountVerificationIsSuccessful() {
        verifyAccountStatus("Verified");
    }

    @Then("the account verification fails")
    public void theAccountVerificationFails() {
        verifyAccountStatus("Unverified");
    }

    @Then("the customer is redirected to their account details page")
    public void theCustomerIsRedirectedToTheirAccountDetailsPage() {
        verifyRedirectionToAccountDetailsPage();
    }

    @Then("an error message is displayed indicating the account verification failed")
    public void anErrorMessageIsDisplayedIndicatingTheAccountVerificationFailed() {
        verifyErrorMessageDisplayed();
    }

    @Then("the customer can access account features")
    public void theCustomerCanAccessAccountFeatures() {
        verifyAccessToAccountFeatures();
    }

    @Then("the customer is able to logout from the account")
    public void theCustomerIsAbleToLogoutFromTheAccount() {
        logoutFromAccount();
    }

    @Then("the customer is not able to access their account details page")
    public void theCustomerIsNotAbleToAccessTheirAccountDetailsPage() {
        verifyNoAccessToAccountDetailsPage();
    }
}