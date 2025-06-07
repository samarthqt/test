package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.FindPartnerPage;

public class FindPartnerSteps extends FindPartnerPage {

    private TestHarness testHarness = new TestHarness();

    @Given("a new browser window is opened")
    public void aNewBrowserWindowIsOpened() {
        openNewBrowserWindow();
    }

    @When("the user enters the URL \"{string}\"")
    public void theUserEntersTheURL(String url) {
        navigateToUrl(url);
    }

    @When("clicks on the \"Find a Partner\" button")
    public void clicksOnTheFindAPartnerButton() {
        clickFindPartnerButton();
    }

    @Then("the Find a Partner page should be displayed")
    public void theFindAPartnerPageShouldBeDisplayed() {
        verifyFindPartnerPageDisplayed();
    }
}