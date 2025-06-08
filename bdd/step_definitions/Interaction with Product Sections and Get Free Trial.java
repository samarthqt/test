package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.HomePage;

public class HomePageSteps extends HomePage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is on the homepage")
    public void theUserIsOnTheHomepage() {
        navigateToHomePage();
    }

    @When("the user clicks on the \"Get Free Trial\" button")
    public void theUserClicksOnTheGetFreeTrialButton() {
        clickGetFreeTrialButton();
    }

    @Then("the user should be directed to the free trial registration page")
    public void theUserShouldBeDirectedToTheFreeTrialRegistrationPage() {
        verifyFreeTrialPageRedirection();
    }

    @When("the user clicks on the content or \"Learn More\" button of the Scale Agile section")
    public void theUserClicksOnTheContentOrLearnMoreButtonOfTheScaleAgileSection() {
        clickScaleAgileLearnMore();
    }

    @Then("the user should be directed to the Scale Agile information page")
    public void theUserShouldBeDirectedToTheScaleAgileInformationPage() {
        verifyScaleAgilePageRedirection();
    }

    @When("the user clicks on the content or \"Learn More\" button of the eXplorer Testing section")
    public void theUserClicksOnTheContentOrLearnMoreButtonOfTheEXplorerTestingSection() {
        clickExplorerTestingLearnMore();
    }

    @Then("the user should be directed to the eXplorer Testing information page")
    public void theUserShouldBeDirectedToTheEXplorerTestingInformationPage() {
        verifyExplorerTestingPageRedirection();
    }

    @When("the user clicks on the content or \"Learn More\" button of the Distributed Team section")
    public void theUserClicksOnTheContentOrLearnMoreButtonOfTheDistributedTeamSection() {
        clickDistributedTeamLearnMore();
    }

    @Then("the user should be directed to the Distributed Team information page")
    public void theUserShouldBeDirectedToTheDistributedTeamInformationPage() {
        verifyDistributedTeamPageRedirection();
    }

    @When("the user clicks on the content or \"Learn More\" button of the Integration & APIs section")
    public void theUserClicksOnTheContentOrLearnMoreButtonOfTheIntegrationAPIsSection() {
        clickIntegrationAPIsLearnMore();
    }

    @Then("the user should be directed to the Integration & APIs information page")
    public void theUserShouldBeDirectedToTheIntegrationAPIsInformationPage() {
        verifyIntegrationAPIsPageRedirection();
    }
}