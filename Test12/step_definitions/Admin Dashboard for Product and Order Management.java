package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.AdminDashboardPage;

public class AdminDashboardSteps extends AdminDashboardPage {

    private TestHarness testHarness = new TestHarness();

    @Given("an admin is logged into the dashboard")
    public void anAdminIsLoggedIntoTheDashboard() {
        loginToDashboard();
    }

    @When("the admin adds a new product with details like name, description, price, image, stock, and category")
    public void theAdminAddsANewProductWithDetails() {
        String name = testHarness.getData("ProductData", "Name");
        String description = testHarness.getData("ProductData", "Description");
        String price = testHarness.getData("ProductData", "Price");
        String image = testHarness.getData("ProductData", "Image");
        String stock = testHarness.getData("ProductData", "Stock");
        String category = testHarness.getData("ProductData", "Category");
        addNewProduct(name, description, price, image, stock, category);
    }

    @Then("the product should be successfully added to the catalog")
    public void theProductShouldBeSuccessfullyAddedToTheCatalog() {
        verifyProductAdded();
    }

    @Given("there is an existing product in the catalog")
    public void thereIsAnExistingProductInTheCatalog() {
        verifyExistingProduct();
    }

    @When("the admin edits the product details")
    public void theAdminEditsTheProductDetails() {
        String newDescription = testHarness.getData("ProductData", "NewDescription");
        editProductDetails(newDescription);
    }

    @Then("the product details should be successfully updated")
    public void theProductDetailsShouldBeSuccessfullyUpdated() {
        verifyProductUpdated();
    }

    @When("the admin deletes the product")
    public void theAdminDeletesTheProduct() {
        deleteProduct();
    }

    @Then("the product should be successfully removed from the catalog")
    public void theProductShouldBeSuccessfullyRemovedFromTheCatalog() {
        verifyProductRemoved();
    }

    @When("the admin views all orders")
    public void theAdminViewsAllOrders() {
        viewAllOrders();
    }

    @Then("the admin should see details like order number, customer info, and status for each order")
    public void theAdminShouldSeeDetailsForEachOrder() {
        verifyOrderDetails();
    }

    @Given("there is an existing order")
    public void thereIsAnExistingOrder() {
        verifyExistingOrder();
    }

    @When("the admin processes the order and updates its status")
    public void theAdminProcessesTheOrderAndUpdatesItsStatus() {
        processOrder();
    }

    @Then("the order status should be successfully updated")
    public void theOrderStatusShouldBeSuccessfullyUpdated() {
        verifyOrderStatusUpdated();
    }

    @Given("an admin is entering product or order details")
    public void anAdminIsEnteringProductOrOrderDetails() {
        startEnteringDetails();
    }

    @When("the admin provides invalid inputs")
    public void theAdminProvidesInvalidInputs() {
        provideInvalidInputs();
    }

    @Then("the system should display appropriate error messages")
    public void theSystemShouldDisplayAppropriateErrorMessages() {
        verifyErrorMessages();
    }

    @Given("an admin performs actions like adding, editing, or deleting products")
    public void anAdminPerformsActionsLikeAddingEditingOrDeletingProducts() {
        performAdminActions();
    }

    @When("the actions are completed")
    public void theActionsAreCompleted() {
        completeActions();
    }

    @Then("the system should log these actions for auditing purposes")
    public void theSystemShouldLogTheseActionsForAuditingPurposes() {
        verifyActionsLogged();
    }

    @Given("there is a new order placed")
    public void thereIsANewOrderPlaced() {
        verifyNewOrderPlaced();
    }

    @When("the order is processed by the system")
    public void theOrderIsProcessedByTheSystem() {
        processOrderBySystem();
    }

    @Then("the admin should receive a notification about the new order")
    public void theAdminShouldReceiveANotificationAboutTheNewOrder() {
        verifyNotificationReceived();
    }

    @Given("a product's stock reaches a predefined threshold")
    public void aProductsStockReachesAPredefinedThreshold() {
        checkStockThreshold();
    }

    @When("the system checks the stock levels")
    public void theSystemChecksTheStockLevels() {
        checkStockLevels();
    }

    @Then("the admin should receive a stock alert notification")
    public void theAdminShouldReceiveAStockAlertNotification() {
        verifyStockAlertNotification();
    }

    @Given("a user attempts to access the admin dashboard")
    public void aUserAttemptsToAccessTheAdminDashboard() {
        attemptDashboardAccess();
    }

    @When("the user is not authorized")
    public void theUserIsNotAuthorized() {
        checkUserAuthorization();
    }

    @Then("the user should be denied access to the dashboard")
    public void theUserShouldBeDeniedAccessToTheDashboard() {
        verifyAccessDenied();
    }

    @Given("an authorized admin user")
    public void anAuthorizedAdminUser() {
        verifyAuthorizedAdminUser();
    }

    @When("the admin logs into the dashboard")
    public void theAdminLogsIntoTheDashboard() {
        loginToDashboard();
    }

    @Then("the admin should be granted access to the dashboard")
    public void theAdminShouldBeGrantedAccessToTheDashboard() {
        verifyAccessGranted();
    }
}