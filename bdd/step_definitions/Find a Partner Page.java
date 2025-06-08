package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.FindPartnerPage;
import java.util.List;

public class FindPartnerSteps extends FindPartnerPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a new browser window is opened")
    public void aNewBrowserWindowIsOpened() {
        openNewBrowserWindow();
    }

    @When("the user enters \"{string}\" in the URL bar")
    public void theUserEntersInTheURLBar(String url) {
        navigateToUrl(url);
    }

    @Then("the Find a Partner page should be displayed")
    public void theFindAPartnerPageShouldBeDisplayed() {
        verifyFindPartnerPageDisplayed();
    }

    @Given("the Find a Partner page is displayed")
    public void theFindAPartnerPageIsDisplayed() {
        verifyFindPartnerPageDisplayed();
    }

    @When("the user clicks on the \"Find a Partner\" button")
    public void theUserClicksOnTheFindAPartnerButton() {
        clickFindPartnerButton();
    }

    @Then("the relevant partner information should be displayed")
    public void theRelevantPartnerInformationShouldBeDisplayed() {
        verifyPartnerInformationDisplayed();
    }
}