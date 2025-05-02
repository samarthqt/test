package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReturnPolicySteps extends ReturnPolicyPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I am a user on the retail website")
    public void iAmAUserOnTheRetailWebsite() {
        navigateToHomePage();
    }

    @When("I navigate to the return policy page")
    public void iNavigateToTheReturnPolicyPage() {
        navigateToReturnPolicyPage();
    }

    @Then("I should see the return policy details clearly displayed")
    public void iShouldSeeTheReturnPolicyDetailsClearlyDisplayed() {
        verifyReturnPolicyDetailsDisplayed();
    }

    @When("I view the return policy page")
    public void iViewTheReturnPolicyPage() {
        navigateToReturnPolicyPage();
    }

    @Then("I should see clear instructions on how to initiate a return")
    public void iShouldSeeClearInstructionsOnHowToInitiateAReturn() {
        verifyReturnInstructionsDisplayed();
    }

    @When("I scroll to the footer of the page")
    public void iScrollToTheFooterOfThePage() {
        scrollToFooter();
    }

    @Then("I should see a visible link to the return policy")
    public void iShouldSeeAVisibleLinkToTheReturnPolicy() {
        verifyReturnPolicyLinkVisible();
    }

    @Given("I am viewing a product page on the retail website")
    public void iAmViewingAProductPageOnTheRetailWebsite() {
        navigateToProductPage();
    }

    @When("I look for return policy information")
    public void iLookForReturnPolicyInformation() {
        searchForReturnPolicyInfo();
    }

    @Then("I should find a link or reference to the return policy")
    public void iShouldFindALinkOrReferenceToTheReturnPolicy() {
        verifyReturnPolicyReference();
    }

    @When("I check the return policy page")
    public void iCheckTheReturnPolicyPage() {
        navigateToReturnPolicyPage();
    }

    @Then("the information should be current and reflect any recent changes")
    public void theInformationShouldBeCurrentAndReflectAnyRecentChanges() {
        verifyReturnPolicyIsCurrent();
    }
}