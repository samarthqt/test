package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.ProductPage;

public class ProductManagementSteps extends ProductPage {

    private TestHarness testHarness = new TestHarness();

    @Given("I am logged in as an admin")
    public void iAmLoggedInAsAnAdmin() {
        loginAsAdmin();
    }

    @When("I add a new product with name {string}, description {string}, price {string}, image {string}, stock {string}, and category {string}")
    public void iAddANewProduct(String name, String description, String price, String image, String stock, String category) {
        addProduct(name, description, price, image, stock, category);
    }

    @Then("the product should be successfully added to the product catalog")
    public void theProductShouldBeSuccessfullyAdded() {
        verifyProductAdded();
    }

    @Then("I should receive a notification for the successful update")
    public void iShouldReceiveNotification() {
        verifyNotificationReceived();
    }

    @Then("the change should be logged for auditing purposes")
    public void theChangeShouldBeLogged() {
        verifyChangeLogged();
    }

    @Given("a product with name {string} exists in the product catalog")
    public void aProductExistsInCatalog(String name) {
        verifyProductExists(name);
    }

    @When("I edit the product's details to name {string}, description {string}, price {string}, image {string}, stock {string}, and category {string}")
    public void iEditProductDetails(String name, String description, String price, String image, String stock, String category) {
        editProduct(name, description, price, image, stock, category);
    }

    @Then("the product details should be successfully updated")
    public void theProductDetailsShouldBeUpdated() {
        verifyProductUpdated();
    }

    @When("I attempt to delete the product")
    public void iAttemptToDeleteTheProduct() {
        attemptDeleteProduct();
    }

    @Then("I should see a confirmation prompt")
    public void iShouldSeeConfirmationPrompt() {
        verifyConfirmationPrompt();
    }

    @When("I confirm the deletion")
    public void iConfirmTheDeletion() {
        confirmDeletion();
    }

    @Then("the product should be successfully deleted from the product catalog")
    public void theProductShouldBeDeleted() {
        verifyProductDeleted();
    }

    @When("I add a new product with name {string}, description {string}, price {string}, image {string}, stock {string}, and category {string}")
    public void iAddProductWithInvalidData(String name, String description, String price, String image, String stock, String category) {
        addProduct(name, description, price, image, stock, category);
    }

    @Then("I should see error messages for the invalid data inputs")
    public void iShouldSeeErrorMessages() {
        verifyErrorMessages();
    }

    @When("I edit the product's details to name {string}, description {string}, price {string}, image {string}, stock {string}, and category {string}")
    public void iEditProductWithInvalidData(String name, String description, String price, String image, String stock, String category) {
        editProduct(name, description, price, image, stock, category);
    }

    @Given("I am not logged in as an admin")
    public void iAmNotLoggedInAsAnAdmin() {
        logoutAdmin();
    }

    @When("I attempt to add, edit, or delete a product")
    public void iAttemptUnauthorizedActions() {
        attemptUnauthorizedActions();
    }

    @Then("I should not be able to perform these actions")
    public void iShouldNotBeAbleToPerformActions() {
        verifyUnauthorizedAccess();
    }

    @Then("I should see an error message indicating unauthorized access")
    public void iShouldSeeUnauthorizedAccessError() {
        verifyUnauthorizedAccessError();
    }
}