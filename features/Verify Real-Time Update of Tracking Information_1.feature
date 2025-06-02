Feature: Verify Real-Time Update of Tracking Information
@TC-208
Scenario: Ensure tracking information is updated in real-time for a valid order with tracking enabled
Given the user has a valid order with Order ID "12345" and tracking number "ABC123"
When the user logs into their account
Then the user should be successfully logged in
When the user navigates to the 'Order History' section
Then the order history page should display all past and current orders
When the user selects the order with the tracking number "ABC123"
Then the order details should be displayed, including tracking information
And the current location of the package should be displayed as "Warehouse"
And the estimated delivery time should be displayed as "2 days"
When the package location is simulated to change to "In Transit"
Then the tracking information should update in real-time to "In Transit"
When the user refreshes the tracking page
Then the page should display the updated location "In Transit"
When the user checks the timestamp of the last update
Then the timestamp should reflect the current time of update
When delivery completion is simulated
Then the status should update to "Delivered"
And the user should receive a notification for delivery completion
When the user logs out of their account
Then the user should be successfully logged out
When the user logs back into their account
Then the user should be successfully logged in again
When the user navigates to the 'Order History' section again
Then the order history page should display all past and current orders
When the user selects the order with the tracking number "ABC123" again
Then the order details should be displayed, including updated tracking information
Then the tracking information should consistently reflect the latest status