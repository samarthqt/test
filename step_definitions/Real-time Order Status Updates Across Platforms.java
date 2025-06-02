package com.cucumber.steps;

import com.framework.cucumber.TestHarness;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.page_objects.OrderStatusPage;

public class OrderStatusSteps extends OrderStatusPage {

    private TestHarness testHarness = new TestHarness();

    @Given("the user has placed an order with ID {string}")
    public void theUserHasPlacedAnOrderWithID(String orderId) {
        verifyOrderPlaced(orderId);
    }

    @Given("the order tracking system is integrated with web and mobile platforms")
    public void theOrderTrackingSystemIsIntegrated() {
        verifyIntegration();
    }

    @Given("the user logs in to the web platform using valid credentials")
    public void theUserLogsInToTheWebPlatform() {
        String username = testHarness.getData("LoginData", "Username");
        String password = testHarness.getData("LoginData", "Password");
        loginToWebPlatform(username, password);
    }

    @Then("the user is successfully logged in and redirected to the dashboard")
    public void theUserIsRedirectedToDashboard() {
        verifyDashboardRedirection();
    }

    @Given("the user is on the dashboard")
    public void theUserIsOnTheDashboard() {
        verifyUserOnDashboard();
    }

    @When("the user navigates to the 'Order History' section")
    public void theUserNavigatesToOrderHistory() {
        navigateToOrderHistory();
    }

    @Then("the order history page is displayed with a list of past orders")
    public void theOrderHistoryPageIsDisplayed() {
        verifyOrderHistoryPage();
    }

    @Given("the order history page is displayed")
    public void theOrderHistoryPageIsDisplayedAgain() {
        verifyOrderHistoryPage();
    }

    @When("the user selects the order with ID {string}")
    public void theUserSelectsTheOrderWithID(String orderId) {
        selectOrder(orderId);
    }

    @Then("the order details page is displayed showing the current status")
    public void theOrderDetailsPageIsDisplayed() {
        verifyOrderDetailsPage();
    }

    @Given("the order details page is displayed")
    public void theOrderDetailsPageIsDisplayedAgain() {
        verifyOrderDetailsPage();
    }

    @When("the order status is updated to 'Shipped' in the backend system")
    public void theOrderStatusIsUpdatedToShipped() {
        updateOrderStatusInBackend("Shipped");
    }

    @Then("the order status is updated in the backend system")
    public void theOrderStatusIsUpdatedInBackend() {
        verifyOrderStatusInBackend("Shipped");
    }

    @Given("the order status is updated to 'Shipped' in the backend system")
    public void theOrderStatusIsUpdatedToShippedInBackend() {
        verifyOrderStatusInBackend("Shipped");
    }

    @When("the user refreshes the order details page on the web platform")
    public void theUserRefreshesOrderDetailsPage() {
        refreshOrderDetailsPage();
    }

    @Then("the order status is updated to 'Shipped' in real-time on the web platform")
    public void theOrderStatusIsUpdatedToShippedOnWeb() {
        verifyOrderStatusOnWeb("Shipped");
    }

    @Given("the user has the mobile app version 1.0.0")
    public void theUserHasMobileApp() {
        verifyMobileAppVersion("1.0.0");
    }

    @When("the user opens the mobile app and logs in using valid credentials")
    public void theUserLogsInToMobileApp() {
        String username = testHarness.getData("LoginData", "Username");
        String password = testHarness.getData("LoginData", "Password");
        loginToMobileApp(username, password);
    }

    @Then("the user is successfully logged in and redirected to the mobile app dashboard")
    public void theUserIsRedirectedToMobileDashboard() {
        verifyMobileDashboardRedirection();
    }

    @Given("the user is on the mobile app dashboard")
    public void theUserIsOnMobileDashboard() {
        verifyUserOnMobileDashboard();
    }

    @When("the user navigates to the 'Order History' section in the mobile app")
    public void theUserNavigatesToOrderHistoryInMobile() {
        navigateToOrderHistoryInMobile();
    }

    @Then("the order history page is displayed with a list of past orders in the mobile app")
    public void theOrderHistoryPageIsDisplayedInMobile() {
        verifyOrderHistoryPageInMobile();
    }

    @Given("the order history page is displayed in the mobile app")
    public void theOrderHistoryPageIsDisplayedInMobileAgain() {
        verifyOrderHistoryPageInMobile();
    }

    @When("the user selects the order with ID {string} in the mobile app")
    public void theUserSelectsTheOrderWithIDInMobile(String orderId) {
        selectOrderInMobile(orderId);
    }

    @Then("the order details page is displayed showing the current status in the mobile app")
    public void theOrderDetailsPageIsDisplayedInMobile() {
        verifyOrderDetailsPageInMobile();
    }

    @Given("the order status is updated to 'Shipped' in the backend system")
    public void theOrderStatusIsUpdatedToShippedInBackendAgain() {
        verifyOrderStatusInBackend("Shipped");
    }

    @When("the user verifies the order status in the mobile app")
    public void theUserVerifiesOrderStatusInMobile() {
        verifyOrderStatusInMobile();
    }

    @Then("the order status is updated to 'Shipped' in real-time in the mobile app")
    public void theOrderStatusIsUpdatedToShippedInMobile() {
        verifyOrderStatusInMobile("Shipped");
    }

    @Given("the order status is 'Shipped'")
    public void theOrderStatusIsShipped() {
        verifyOrderStatus("Shipped");
    }

    @When("the order status is changed to 'Delivered' in the backend system")
    public void theOrderStatusIsChangedToDelivered() {
        updateOrderStatusInBackend("Delivered");
    }

    @Then("the order status is updated in the backend system")
    public void theOrderStatusIsUpdatedInBackendAgain() {
        verifyOrderStatusInBackend("Delivered");
    }

    @Given("the order status is updated to 'Delivered' in the backend system")
    public void theOrderStatusIsUpdatedToDeliveredInBackend() {
        verifyOrderStatusInBackend("Delivered");
    }

    @When("the user refreshes the order details page on the web platform")
    public void theUserRefreshesOrderDetailsPageAgain() {
        refreshOrderDetailsPage();
    }

    @Then("the order status is updated to 'Delivered' in real-time on the web platform")
    public void theOrderStatusIsUpdatedToDeliveredOnWeb() {
        verifyOrderStatusOnWeb("Delivered");
    }

    @Given("the order status is updated to 'Delivered' in the backend system")
    public void theOrderStatusIsUpdatedToDeliveredInBackendAgain() {
        verifyOrderStatusInBackend("Delivered");
    }

    @When("the user refreshes the order details page in the mobile app")
    public void theUserRefreshesOrderDetailsPageInMobile() {
        refreshOrderDetailsPageInMobile();
    }

    @Then("the order status is updated to 'Delivered' in real-time in the mobile app")
    public void theOrderStatusIsUpdatedToDeliveredInMobile() {
        verifyOrderStatusInMobile("Delivered");
    }

    @Given("the order status changes to 'Shipped' and 'Delivered'")
    public void theOrderStatusChanges() {
        verifyOrderStatusChanges();
    }

    @When("notifications are sent to the user")
    public void notificationsAreSent() {
        sendNotifications();
    }

    @Then("the user receives notifications for 'Shipped' and 'Delivered' status updates")
    public void theUserReceivesNotifications() {
        verifyNotificationsReceived();
    }

    @Given("the order status is 'Delivered' on both platforms")
    public void theOrderStatusIsDeliveredOnBothPlatforms() {
        verifyOrderStatusOnBothPlatforms("Delivered");
    }

    @When("the user checks the order status consistency")
    public void theUserChecksOrderStatusConsistency() {
        checkOrderStatusConsistency();
    }

    @Then("the order status is consistent across web and mobile platforms")
    public void theOrderStatusIsConsistent() {
        verifyOrderStatusConsistency();
    }

    @Given("the user is logged in on both platforms")
    public void theUserIsLoggedInOnBothPlatforms() {
        verifyUserLoggedInOnBothPlatforms();
    }

    @When("the user logs out from both web and mobile platforms")
    public void theUserLogsOutFromBothPlatforms() {
        logoutFromBothPlatforms();
    }

    @Then("the user is successfully logged out from both platforms")
    public void theUserIsLoggedOutFromBothPlatforms() {
        verifyUserLoggedOutFromBothPlatforms();
    }
}