Feature: User views order history and successfully tracks an order via tracking link
@TC-131
Scenario: Verify user can view order history and track an order using the tracking link
Given the user is logged into their account
And the user has previously placed an order
When the user navigates to the order history page
Then the order history page is displayed
@TC-131
Scenario: Locate the order to be tracked in the order history list
Given the user is on the order history page
When the user locates the order with Order ID "123456789" in the order history list
Then the order is located in the list
And the tracking link "http://trackinglink.com/track/123456789" is available
@TC-131
Scenario: Track order via tracking link
Given the user has located the order in the order history list
When the user clicks on the tracking link associated with the order
Then the tracking link opens in a new window/tab
And the tracking information is displayed correctly
@TC-131
Scenario: Verify tracking information details
Given the tracking information is displayed
Then the current status of the order is displayed
And the estimated delivery date is displayed
And the carrier information is displayed correctly
And any updates in the tracking information are displayed
@TC-131
Scenario: Return to order history page and verify order details
Given the user is viewing the tracking information
When the user returns to the order history page
Then the order history page is displayed
And the order details such as product name, quantity, price, and total cost are displayed correctly
And the order status in the order history matches the tracking status
@TC-131
Scenario: Track another order using a different tracking link
Given the user is on the order history page
When the user attempts to track another order using a different tracking link
Then the tracking link opens and displays information correctly
@TC-131
Scenario: Verify system logs for order tracking activity
Given the user has tracked orders using tracking links
When the system logs are checked
Then the system logs show order tracking activity
@TC-131
Scenario: Check for security alerts related to order tracking
Given the user has tracked orders using tracking links
When the system is checked for security alerts
Then no security alerts are triggered
@TC-131
Scenario: Ensure tracking link is accessible from mobile devices
Given the user is on a mobile device
When the user accesses the tracking link
Then the tracking link is accessible and functional on mobile devices