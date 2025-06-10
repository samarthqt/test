package com.cucumber.steps;

import com.pageobjects.AdminProfilePage;
import com.pageobjects.UserProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileOptionsSteps extends AdminProfilePage {

    @Given("the admin user is logged in successfully")
    public void theAdminUserIsLoggedInSuccessfully() {
        verifyAdminLogin();
    }

    @When("the user navigates to the user profile section")
    public void theUserNavigatesToTheUserProfileSection() {
        navigateToUserProfile();
    }

    @Then("the user profile section is displayed")
    public void theUserProfileSectionIsDisplayed() {
        verifyUserProfileSectionDisplayed();
    }

    @Then("'Release' label is displayed with an appropriate value")
    public void releaseLabelIsDisplayedWithAnAppropriateValue() {
        verifyMenuItemDisplayed("Release");
    }

    @Then("'Last Deployed Date' label is displayed with an appropriate value")
    public void lastDeployedDateLabelIsDisplayedWithAnAppropriateValue() {
        verifyMenuItemDisplayed("Last Deployed Date");
    }
}

public class UserProfileOptionsSteps extends UserProfilePage {

    @Given("the user is logged in successfully")
    public void theUserIsLoggedInSuccessfully() {
        verifyUserProfileSectionDisplayed();
    }

    @When("the user navigates to the user profile section")
    public void theUserNavigatesToTheUserProfileSection() {
        navigateToUserProfile();
    }

    @Then("the user profile section is displayed")
    public void theUserProfileSectionIsDisplayed() {
        verifyUserProfileSectionDisplayed();
    }

    @Then("'Release' label is displayed with an appropriate value")
    public void releaseLabelIsDisplayedWithAnAppropriateValue() {
        verifyMenuItemDisplayed("Release");
    }

    @Then("'Last Deployed Date' label is displayed with an appropriate value")
    public void lastDeployedDateLabelIsDisplayedWithAnAppropriateValue() {
        verifyMenuItemDisplayed("Last Deployed Date");
    }
}