package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderTrackingPage;

public class OrderTrackingSteps extends OrderTrackingPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user is logged into their account")
    public void theUserIsLoggedIntoTheirAccount() {
        loginToAccount();
    }

    @When("the user navigates to the order tracking page")
    public void theUserNavigatesToTheOrderTrackingPage() {
        navigateToOrderTrackingPage();
    }

    @Then("the order tracking page is displayed")
    public void theOrderTrackingPageIsDisplayed() {
        verifyOrderTrackingPageDisplayed();
    }

    @Given("the user is on the order tracking page")
    public void theUserIsOnTheOrderTrackingPage() {
        verifyOrderTrackingPageDisplayed();
    }

    @When("the order details are loaded")
    public void theOrderDetailsAreLoaded() {
        loadOrderDetails();
    }

    @Then("the order status is displayed accurately")
    public void theOrderStatusIsDisplayedAccurately() {
        verifyOrderStatus();
    }

    @When("the user clicks on the tracking number")
    public void theUserClicksOnTheTrackingNumber() {
        clickTrackingNumber();
    }

    @Then("the user is redirected to the shipping provider's site")
    public void theUserIsRedirectedToTheShippingProvidersSite() {
        verifyRedirectionToShippingProvider();
    }

    @When("there is a change in the order status")
    public void thereIsAChangeInTheOrderStatus() {
        simulateOrderStatusChange();
    }

    @Then("the updated order status is displayed in real-time")
    public void theUpdatedOrderStatusIsDisplayedInRealTime() {
        verifyRealTimeOrderStatusUpdate();
    }

    @Given("the user has an active order")
    public void theUserHasAnActiveOrder() {
        verifyActiveOrder();
    }

    @Then("the user receives a notification about the status change")
    public void theUserReceivesANotificationAboutTheStatusChange() {
        verifyStatusChangeNotification();
    }

    @Given("the user is accessing the order tracking page")
    public void theUserIsAccessingTheOrderTrackingPage() {
        navigateToOrderTrackingPage();
    }

    @When("the page is loading")
    public void thePageIsLoading() {
        verifyPageLoading();
    }

    @Then("the page loads within 3 seconds")
    public void thePageLoadsWithin3Seconds() {
        verifyPageLoadTime();
    }

    @Then("the page is responsive")
    public void thePageIsResponsive() {
        verifyPageResponsiveness();
    }

    @When("an unauthorized user attempts to access tracking details")
    public void anUnauthorizedUserAttemptsToAccessTrackingDetails() {
        simulateUnauthorizedAccess();
    }

    @Then("the tracking details are not visible to the unauthorized user")
    public void theTrackingDetailsAreNotVisibleToTheUnauthorizedUser() {
        verifyUnauthorizedAccessRestriction();
    }
}