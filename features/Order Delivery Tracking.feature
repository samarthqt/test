Feature: Order Delivery Tracking
@TC-306
Scenario: User can successfully track order delivery status via the website
Given a valid user account with login credentials
When the user logs in to the e-commerce website
Then the user should be successfully logged in and redirected to the homepage
@TC-306
Scenario: Navigate to 'My Orders' section
Given the user is logged in
When the user navigates to the 'My Orders' section
Then 'My Orders' page should display a list of past and current orders
@TC-306
Scenario: Select an order to track
Given the user is on the 'My Orders' page
When the user selects the order to be tracked
Then the order details page should be displayed with tracking options
@TC-306
Scenario: Track order
Given the user is on the order details page
When the user clicks on the 'Track Order' button
Then the user should be redirected to the tracking page with current delivery status
@TC-306
Scenario: Verify tracking information
Given the user is on the tracking page
When the tracking information is displayed
Then the tracking details should include current status, estimated delivery time, and location
@TC-306
Scenario: Check for delivery update notifications
Given the user is on the tracking page
When there are changes in delivery status
Then notifications should be displayed
@TC-306
Scenario: Ensure tracking page responsiveness
Given the user is on the tracking page
When the page loads
Then the tracking page should load efficiently without delays
@TC-306
Scenario: Log out from the website
Given the user is logged in
When the user logs out from the website
Then the user should be logged out successfully
@TC-306
Scenario: Re-login and verify tracking status
Given the user has logged out
When the user logs back in
Then the tracking status should be consistent and accurate
@TC-306
Scenario: Track another order
Given the user is logged in
When the user attempts to track another order
Then tracking information should be displayed correctly for the new order
@TC-306
Scenario: Email notifications for delivery status
Given the user is tracking an order
When there are changes in delivery status
Then the user should receive email updates about delivery status changes
@TC-306
Scenario: Verify integration with the shipping carrier's tracking system
Given the user is tracking an order
When tracking information is updated
Then tracking information should be synced accurately with the carrier's system
@TC-306
Scenario: Error handling for tracking failures
Given the user is tracking an order
When tracking fails
Then relevant error messages should be displayed
@TC-306
Scenario: Security of tracking information
Given the user is logged in
When accessing tracking details
Then tracking details should be accessible only to authorized users
@TC-306
Scenario: Responsiveness on mobile devices
Given the user is accessing the website on a mobile device
When the user tracks an order
Then tracking functionality should be consistent and efficient on mobile platforms