Feature: View Order Status and Tracking Number
@TC-343
Scenario: Verify that users can view their order status and tracking number from their account dashboard
Given the user is logged into their account
And an order has been placed
When the user navigates to the 'Orders' section in the account dashboard
Then the 'Orders' section is displayed
When the user selects the most recent order from the list
Then the order details are displayed
And the order status matches the current status in the system
And the tracking number is displayed correctly
When the user clicks on the tracking number to view shipping details
Then the shipping details are displayed with tracking information
And the estimated delivery date is displayed correctly
And any updates or changes in delivery status are displayed
When the user ensures the tracking link redirects to the carrier's website
Then the tracking link redirects correctly to the carrier's website
And the order summary matches the transaction details
And all relevant notifications are displayed in the dashboard
When the user logs out and logs back in
Then the order status and tracking details persist after logging back in
And the order can be filtered by its current status
And the order can be archived successfully
And archived orders remain accessible in the user dashboard