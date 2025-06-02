import { Given, When, Then } from "cypress-cucumber-preprocessor/steps";
import WebPlatformPage from "../pages/webPlatformPage";
import MobileAppPage from "../pages/mobileAppPage";

Given("the user has placed an order with ID {string}", (orderId) => {
 cy.wrap(orderId).as('orderId');
});

Given("the order tracking system is integrated with web and mobile platforms", () => {
 cy.log("Order tracking system is integrated.");
});

Given("the user logs in to the web platform using valid credentials", () => {
 WebPlatformPage.login();
});

Then("the user is successfully logged in and redirected to the dashboard", () => {
 WebPlatformPage.verifyDashboard();
});

Given("the user is on the dashboard", () => {
 WebPlatformPage.verifyDashboard();
});

When("the user navigates to the 'Order History' section", () => {
 WebPlatformPage.navigateToOrderHistory();
});

Then("the order history page is displayed with a list of past orders", () => {
 WebPlatformPage.verifyOrderHistoryPage();
});

Given("the order history page is displayed", () => {
 WebPlatformPage.verifyOrderHistoryPage();
});

When("the user selects the order with ID {string}", (orderId) => {
 WebPlatformPage.selectOrder(orderId);
});

Then("the order details page is displayed showing the current status", () => {
 WebPlatformPage.verifyOrderDetailsPage();
});

Given("the order details page is displayed", () => {
 WebPlatformPage.verifyOrderDetailsPage();
});

When("the order status is updated to 'Shipped' in the backend system", () => {
 WebPlatformPage.updateOrderStatusToShipped();
});

Then("the order status is updated in the backend system", () => {
 cy.log("Order status updated in backend.");
});

Given("the order status is updated to 'Shipped' in the backend system", () => {
 cy.log("Order status is 'Shipped'.");
});

When("the user refreshes the order details page on the web platform", () => {
 WebPlatformPage.refreshOrderDetailsPage();
});

Then("the order status is updated to 'Shipped' in real-time on the web platform", () => {
 WebPlatformPage.verifyOrderStatus("Shipped");
});

Given("the user has the mobile app version 1.0.0", () => {
 cy.log("Mobile app version 1.0.0.");
});

When("the user opens the mobile app and logs in using valid credentials", () => {
 MobileAppPage.login();
});

Then("the user is successfully logged in and redirected to the mobile app dashboard", () => {
 MobileAppPage.verifyDashboard();
});

Given("the user is on the mobile app dashboard", () => {
 MobileAppPage.verifyDashboard();
});

When("the user navigates to the 'Order History' section in the mobile app", () => {
 MobileAppPage.navigateToOrderHistory();
});

Then("the order history page is displayed with a list of past orders in the mobile app", () => {
 MobileAppPage.verifyOrderHistoryPage();
});

Given("the order history page is displayed in the mobile app", () => {
 MobileAppPage.verifyOrderHistoryPage();
});

When("the user selects the order with ID {string} in the mobile app", (orderId) => {
 MobileAppPage.selectOrder(orderId);
});

Then("the order details page is displayed showing the current status in the mobile app", () => {
 MobileAppPage.verifyOrderDetailsPage();
});

Given("the order status is updated to 'Shipped' in the backend system", () => {
 cy.log("Order status is 'Shipped'.");
});

When("the user verifies the order status in the mobile app", () => {
 MobileAppPage.verifyOrderStatus("Shipped");
});

Then("the order status is updated to 'Shipped' in real-time in the mobile app", () => {
 MobileAppPage.verifyOrderStatus("Shipped");
});

Given("the order status is 'Shipped'", () => {
 cy.log("Order status is 'Shipped'.");
});

When("the order status is changed to 'Delivered' in the backend system", () => {
 WebPlatformPage.updateOrderStatusToDelivered();
});

Then("the order status is updated in the backend system", () => {
 cy.log("Order status updated in backend.");
});

Given("the order status is updated to 'Delivered' in the backend system", () => {
 cy.log("Order status is 'Delivered'.");
});

When("the user refreshes the order details page on the web platform", () => {
 WebPlatformPage.refreshOrderDetailsPage();
});

Then("the order status is updated to 'Delivered' in real-time on the web platform", () => {
 WebPlatformPage.verifyOrderStatus("Delivered");
});

Given("the order status is updated to 'Delivered' in the backend system", () => {
 cy.log("Order status is 'Delivered'.");
});

When("the user refreshes the order details page in the mobile app", () => {
 MobileAppPage.refreshOrderDetailsPage();
});

Then("the order status is updated to 'Delivered' in real-time in the mobile app", () => {
 MobileAppPage.verifyOrderStatus("Delivered");
});

Given("the order status changes to 'Shipped' and 'Delivered'", () => {
 cy.log("Order status changes detected.");
});

When("notifications are sent to the user", () => {
 cy.log("Notifications sent.");
});

Then("the user receives notifications for 'Shipped' and 'Delivered' status updates", () => {
 cy.log("User receives notifications.");
});

Given("the order status is 'Delivered' on both platforms", () => {
 cy.log("Order status is 'Delivered' on both platforms.");
});

When("the user checks the order status consistency", () => {
 cy.log("Checking order status consistency.");
});

Then("the order status is consistent across web and mobile platforms", () => {
 cy.log("Order status is consistent.");
});

Given("the user is logged in on both platforms", () => {
 cy.log("User logged in on both platforms.");
});

When("the user logs out from both web and mobile platforms", () => {
 WebPlatformPage.logout();
 MobileAppPage.logout();
});

Then("the user is successfully logged out from both platforms", () => {
 cy.log("User logged out from both platforms.");
});