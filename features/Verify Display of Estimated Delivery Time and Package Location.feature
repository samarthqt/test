Feature: Verify Display of Estimated Delivery Time and Package Location
@TC-210
Scenario: Ensure the tracking page displays estimated delivery time and current location of the package
Given a user has a valid order with tracking enabled
When the user logs into their account
Then the user should be successfully logged in
And the order ID should be "11223"
@TC-210
Scenario: Navigate to the tracking section
Given the user is logged in
When the user navigates to the 'Tracking' section
Then the tracking page should display options to view current orders
And the tracking number should be "LMN456"
@TC-210
Scenario: Select the order with the tracking number LMN456
Given the user is on the tracking page
When the user selects the order with the tracking number "LMN456"
Then tracking details should be displayed, including location and estimated delivery time
And the current location should be "Distribution Center"
@TC-210
Scenario: Check the current location of the package
Given the tracking details are displayed
When the user checks the current location of the package
Then the current location should be displayed as "Distribution Center"
@TC-210
Scenario: Verify the estimated delivery time
Given the tracking details are displayed
When the user verifies the estimated delivery time
Then the estimated delivery time should be displayed as "3 days"
@TC-210
Scenario: Simulate a change in the package location to 'In Transit'
Given the tracking details are displayed
When a change in the package location is simulated to "In Transit"
Then the tracking information should update to show "In Transit"
@TC-210
Scenario: Refresh the tracking page
Given the location is updated to "In Transit"
When the user refreshes the tracking page
Then the page should display the updated location "In Transit"
@TC-210
Scenario: Check the timestamp of the last update
Given the location is updated to "In Transit"
When the user checks the timestamp of the last update
Then the timestamp should reflect the current time of update
@TC-210
Scenario: Simulate delivery completion
Given the package is "In Transit"
When delivery completion is simulated
Then the status should update to "Delivered"
@TC-210
Scenario: Verify notification received for delivery completion
Given the status is "Delivered"
When the user verifies notification for delivery completion
Then the user should receive a notification for delivery completion
@TC-210
Scenario: Log out of the user account
Given the user is logged in
When the user logs out of the account
Then the user should be successfully logged out
@TC-210
Scenario: Log back into the user account
Given the user is logged out
When the user logs back into the account
Then the user should be successfully logged in again
@TC-210
Scenario: Navigate to the tracking section again
Given the user is logged in again
When the user navigates to the 'Tracking' section again
Then the tracking page should display options to view current orders
@TC-210
Scenario: Select the order with the tracking number LMN456 again
Given the user is on the tracking page
When the user selects the order with the tracking number "LMN456" again
Then tracking details should be displayed, including updated location and estimated delivery time
@TC-210
Scenario: Verify that the tracking information remains consistent
Given the tracking details are displayed
When the user verifies the tracking information
Then the tracking information should consistently reflect the latest status