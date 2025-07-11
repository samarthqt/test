package com.cucumber.steps;
import io.cucumber.java.en.Given;
import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.When;
import static com.framework.selenium.SeleniumTestParameters.getAppUrl;

import com.pageobjects.AgileTestingPage;
import io.cucumber.java.en.Then;

public class AgileTestingSteps extends AgileTestingPage {

    @Given("I open a new browser window")
    public void iOpenANewBrowserWindow() {
        openNewBrowserWindow();
    }

    @When("I enter \"{string}\" URL")
    public void iEnterURL(String url) {
        navigateToUrl(url);
    }

    @Then("I should see the \"{string}\" sub-menu")
    public void iShouldSeeTheSubMenu(String subMenu) {
        verifySubMenuVisible(subMenu);
    }

    @When("I click on the \"{string}\" sub-menu")
    public void iClickOnTheSubMenu(String subMenu) {
        clickSubMenu(subMenu);
    }

    @Then("I should be able to call Get Free Trial")
    public void iShouldBeAbleToCallGetFreeTrial() {
        verifyGetFreeTrial();
    }

    @When("I click on the content or Learn More button of Scale Agile section")
    public void iClickOnTheContentOrLearnMoreButtonOfScaleAgileSection() {
        clickScaleAgileLearnMore();
    }

    @Then("I should see details about Scale Agile")
    public void iShouldSeeDetailsAboutScaleAgile() {
        verifyScaleAgileDetails();
    }

    @When("I click on the content or Learn More button of eXplorer Testing section")
    public void iClickOnTheContentOrLearnMoreButtonOfExplorerTestingSection() {
        clickExplorerTestingLearnMore();
    }

    @Then("I should see details about eXplorer Testing")
    public void iShouldSeeDetailsAboutExplorerTesting() {
        verifyExplorerTestingDetails();
    }

    @When("I click on the content or Learn More button of Distributed Team section")
    public void iClickOnTheContentOrLearnMoreButtonOfDistributedTeamSection() {
        clickDistributedTeamLearnMore();
    }

    @Then("I should see details about Distributed Team")
    public void iShouldSeeDetailsAboutDistributedTeam() {
        verifyDistributedTeamDetails();
    }

    @When("I click on the content or Learn More button of Integration & APIs section")
    public void iClickOnTheContentOrLearnMoreButtonOfIntegrationAPIsSection() {
        clickIntegrationAPIsLearnMore();
    }

    @Then("I should see details about Integration & APIs")
    public void iShouldSeeDetailsAboutIntegrationAPIs() {
        verifyIntegrationAPIsDetails();
    }
}

