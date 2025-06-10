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
        loginAsAdmin();
    }

    @When("the admin adds a new product")
    public void theAdminAddsANewProduct() {
        addNewProduct();
    }

    @Then("the product should be visible in the product list")
    public void theProductShouldBeVisibleInTheProductList() {
        verifyProductInList();
    }

    @When("the admin edits an existing product")
    public void theAdminEditsAnExistingProduct() {
        editProduct();
    }

    @Then("the changes should be reflected in the product details")
    public void theChangesShouldBeReflectedInTheProductDetails() {
        verifyProductDetails();
    }

    @When("the admin deletes a product")
    public void theAdminDeletesAProduct() {
        deleteProduct();
    }

    @Then("the product should be removed from the product list")
    public void theProductShouldBeRemovedFromTheProductList() {
        verifyProductRemoved();
    }

    @When("the admin views the order list")
    public void theAdminViewsTheOrderList() {
        viewOrderList();
    }

    @Then("the admin should see all orders with their statuses")
    public void theAdminShouldSeeAllOrdersWithTheirStatuses() {
        verifyOrderStatuses();
    }

    @When("the admin updates an order status")
    public void theAdminUpdatesAnOrderStatus() {
        updateOrderStatus();
    }

    @Then("the status change should be reflected in the order details")
    public void theStatusChangeShouldBeReflectedInTheOrderDetails() {
        verifyOrderStatusChange();
    }

    @When("the admin deletes an order")
    public void theAdminDeletesAnOrder() {
        deleteOrder();
    }

    @Then("the order should be removed from the order list")
    public void theOrderShouldBeRemovedFromTheOrderList() {
        verifyOrderRemoved();
    }

    @When("a customer initiates a live chat")
    public void aCustomerInitiatesALiveChat() {
        initiateLiveChat();
    }

    @Then("the admin should be able to respond to the customer")
    public void theAdminShouldBeAbleToRespondToTheCustomer() {
        respondToLiveChat();
    }

    @When("a customer sends an email")
    public void aCustomerSendsAnEmail() {
        receiveCustomerEmail();
    }

    @Then("the admin should be able to reply to the email")
    public void theAdminShouldBeAbleToReplyToTheEmail() {
        replyToCustomerEmail();
    }

    @When("the admin selects a different language")
    public void theAdminSelectsADifferentLanguage() {
        selectLanguage();
    }

    @Then("the dashboard should display in the selected language")
    public void theDashboardShouldDisplayInTheSelectedLanguage() {
        verifyLanguageChange();
    }

    @When("the admin selects a different currency")
    public void theAdminSelectsADifferentCurrency() {
        selectCurrency();
    }

    @Then("the dashboard should display prices in the selected currency")
    public void theDashboardShouldDisplayPricesInTheSelectedCurrency() {
        verifyCurrencyChange();
    }

    @When("the admin accesses sensitive data")
    public void theAdminAccessesSensitiveData() {
        accessSensitiveData();
    }

    @Then("the data should be protected by security measures")
    public void theDataShouldBeProtectedBySecurityMeasures() {
        verifyDataProtection();
    }

    @Given("an admin is performing operations on the dashboard")
    public void anAdminIsPerformingOperationsOnTheDashboard() {
        performAdminOperations();
    }

    @When("an error occurs")
    public void anErrorOccurs() {
        simulateError();
    }

    @Then("the admin should receive an appropriate error message")
    public void theAdminShouldReceiveAnAppropriateErrorMessage() {
        verifyErrorMessage();
    }

    @When("an important change occurs")
    public void anImportantChangeOccurs() {
        triggerImportantChange();
    }

    @Then("the admin should receive a notification")
    public void theAdminShouldReceiveANotification() {
        verifyNotificationReceived();
    }

    @Given("the dashboard is set up for testing")
    public void theDashboardIsSetUpForTesting() {
        setupDashboardForTesting();
    }

    @When("tests are executed")
    public void testsAreExecuted() {
        executeTests();
    }

    @Then("all features should function as expected")
    public void allFeaturesShouldFunctionAsExpected() {
        verifyAllFeatures();
    }

    @When("the admin performs operations")
    public void theAdminPerformsOperations() {
        performAdminOperations();
    }

    @Then("the operations should be logged for future reference")
    public void theOperationsShouldBeLoggedForFutureReference() {
        verifyOperationsLogged();
    }

    @Given("the admin dashboard is available")
    public void theAdminDashboardIsAvailable() {
        verifyDashboardAvailability();
    }

    @When("an admin needs guidance")
    public void anAdminNeedsGuidance() {
        requestGuidance();
    }

    @Then("documentation should be provided for all functionalities")
    public void documentationShouldBeProvidedForAllFunctionalities() {
        verifyDocumentationProvided();
    }
}