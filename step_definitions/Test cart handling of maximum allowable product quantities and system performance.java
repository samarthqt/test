package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.CartPage;

public class CartManagementSteps extends CartPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into the application")
    public void theUserIsLoggedIntoTheApplication() {
        loginToApplication();
    }

    @When("the user navigates to the product page for Product ID 67890")
    public void theUserNavigatesToTheProductPage() {
        navigateToProductPage("67890");
    }

    @Then("the product page displays correctly with relevant details")
    public void theProductPageDisplaysCorrectly() {
        verifyProductPageDetails("67890");
    }

    @Given("the user is on the product page for Product ID 67890")
    public void theUserIsOnTheProductPage() {
        navigateToProductPage("67890");
    }

    @When("the user enters the maximum allowable quantity of 50 into the quantity field")
    public void theUserEntersMaximumQuantity() {
        enterProductQuantity("50");
    }

    @Then("the quantity field accepts the input value")
    public void theQuantityFieldAcceptsInput() {
        verifyQuantityField("50");
    }

    @Given("the maximum allowable quantity is entered in the quantity field")
    public void maximumQuantityEntered() {
        enterProductQuantity("50");
    }

    @When("the user clicks the 'Add to Cart' button")
    public void theUserClicksAddToCart() {
        addProductToCart();
    }

    @Then("the system processes the request and adds the product to the cart")
    public void systemProcessesRequest() {
        verifyProductInCart("67890", "50");
    }

    @Given("the product is added to the cart")
    public void productAddedToCart() {
        addProductToCart();
    }

    @When("the user views the cart")
    public void theUserViewsTheCart() {
        openCart();
    }

    @Then("the cart displays the correct quantity of 50")
    public void cartDisplaysCorrectQuantity() {
        verifyProductQuantity("50");
    }

    @When("the transaction is processed")
    public void transactionIsProcessed() {
        processTransaction();
    }

    @Then("the system remains responsive and processes the request efficiently")
    public void systemRemainsResponsive() {
        verifySystemPerformance();
    }

    @When("the user attempts to increase the quantity beyond 50")
    public void userAttemptsToIncreaseQuantity() {
        attemptToIncreaseQuantity("51");
    }

    @Then("the system rejects the input and displays an error message")
    public void systemRejectsInput() {
        verifyErrorMessage();
    }

    @Then("the cart maintains the maximum allowable quantity of 50")
    public void cartMaintainsMaximumQuantity() {
        verifyProductQuantity("50");
    }

    @Given("the user attempts to add multiple products with maximum quantity")
    public void userAttemptsMultipleMaxQuantity() {
        addMultipleProductsMaxQuantity();
    }

    @When("the requests are processed")
    public void requestsAreProcessed() {
        processMultipleRequests();
    }

    @Then("the system handles requests efficiently without performance degradation")
    public void systemHandlesRequestsEfficiently() {
        verifySystemPerformance();
    }

    @Given("the user performs maximum quantity additions")
    public void userPerformsMaxQuantityAdditions() {
        performMaxQuantityAdditions();
    }

    @When("the process is completed")
    public void processIsCompleted() {
        completeProcess();
    }

    @Then("the system should not display any warnings if functioning correctly")
    public void systemNoWarnings() {
        verifyNoWarnings();
    }

    @When("the user enters a quantity of zero")
    public void userEntersQuantityZero() {
        enterProductQuantity("0");
    }

    @Then("the system should not add the product and may display a relevant message")
    public void systemDisplaysRelevantMessage() {
        verifyZeroQuantityMessage();
    }

    @When("the user enters a non-numeric quantity")
    public void userEntersNonNumericQuantity() {
        enterNonNumericQuantity();
    }

    @Then("the system rejects the input and displays an error message")
    public void systemRejectsNonNumericInput() {
        verifyErrorMessage();
    }

    @Given("the user performs transactions")
    public void userPerformsTransactions() {
        performTransactions();
    }

    @When("the transaction logs are checked")
    public void transactionLogsChecked() {
        checkTransactionLogs();
    }

    @Then("the logs should reflect the transaction process and any errors encountered")
    public void logsReflectTransactionProcess() {
        verifyTransactionLogs();
    }

    @When("the stock levels are checked")
    public void stockLevelsChecked() {
        checkStockLevels();
    }

    @Then("stock levels remain consistent and accurately reflect available inventory")
    public void stockLevelsConsistent() {
        verifyStockLevels();
    }

    @When("the user provides feedback")
    public void userProvidesFeedback() {
        provideFeedback();
    }

    @Then("users should find the process smooth and error-free")
    public void processSmoothAndErrorFree() {
        verifyUserSatisfaction();
    }

    @Given("the user performs maximum quantity additions under high load")
    public void userPerformsMaxQuantityUnderHighLoad() {
        performMaxQuantityUnderHighLoad();
    }

    @When("the system is monitored")
    public void systemIsMonitored() {
        monitorSystem();
    }

    @Then("the system scales effectively and maintains performance")
    public void systemScalesEffectively() {
        verifySystemScalability();
    }
}