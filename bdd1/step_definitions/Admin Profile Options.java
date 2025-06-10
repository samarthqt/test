package com.cucumber.steps;

import com.pageobjects.AdminProfilePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminProfileSteps extends AdminProfilePage {

    @Given("I am logged into COCO as an Admin")
    public void iAmLoggedIntoCOCOAsAnAdmin() {
        loginAsAdmin();
    }

    @When("I navigate to the user profile")
    public void iNavigateToTheUserProfile() {
        navigateToUserProfile();
    }

    @Then("the following admin related menus should be displayed:")
    public void theFollowingAdminRelatedMenusShouldBeDisplayed(io.cucumber.datatable.DataTable dataTable) {
        verifyAdminMenus(dataTable.asList(String.class));
    }
}