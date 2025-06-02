Feature: Verify Viewing of Tracking History for Past Orders
@TC-211
Scenario: Ensure users can view tracking history for past orders
Given the user has past orders with tracking enabled
When the user logs into their account
Then the user should be successfully logged in
@TC-211
Scenario: Navigate to the 'Order History' section
When the user navigates to the 'Order History' section
Then the order history page should display all past and current orders
@TC-211
Scenario: Select the order with the tracking number OPQ789
When the user selects the order with the tracking number OPQ789
Then the order details should be displayed, including tracking history
@TC-211
Scenario: Check the tracking history of the package
When the user checks the tracking history of the package
Then the tracking history should display all past locations: Warehouse, Distribution Center, In Transit, Delivered
@TC-211
Scenario: Verify the timestamp of each location update
When the user verifies the timestamp of each location update
Then each location update should have a corresponding timestamp
@TC-211
Scenario: Verify the delivery status as 'Delivered'
When the user verifies the delivery status
Then the delivery status should be displayed as 'Delivered'
@TC-211
Scenario: Log out of the user account
When the user logs out of their account
Then the user should be successfully logged out
@TC-211
Scenario: Log back into the user account
When the user logs back into their account
Then the user should be successfully logged in again
@TC-211
Scenario: Navigate to the 'Order History' section again
When the user navigates to the 'Order History' section again
Then the order history page should display all past and current orders
@TC-211
Scenario: Select the order with the tracking number OPQ789 again
When the user selects the order with the tracking number OPQ789 again
Then the order details should be displayed, including tracking history
@TC-211
Scenario: Verify that the tracking history remains consistent
When the user verifies that the tracking history remains consistent
Then the tracking history should consistently reflect all past updates
@TC-211
Scenario: Check for any discrepancies in the tracking history
When the user checks for any discrepancies in the tracking history
Then there should be no discrepancies in the tracking history
@TC-211
Scenario: Verify the ability to download or print tracking history
When the user verifies the ability to download or print tracking history
Then the user should be able to download or print tracking history
@TC-211
Scenario: Verify notification settings for past orders
When the user verifies notification settings for past orders
Then notification settings should be available for past orders
@TC-211
Scenario: Simulate a request for tracking history via customer support
When the user simulates a request for tracking history via customer support
Then customer support should be able to provide tracking history upon request