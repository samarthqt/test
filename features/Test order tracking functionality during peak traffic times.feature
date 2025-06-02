Feature: Test order tracking functionality during peak traffic times
@TC-308
Scenario: Log in to the e-commerce website using valid credentials
Given I am on the login page
When I enter valid user ID "U98765" and password "********"
Then I should be successfully logged in and redirected to the homepage
@TC-308
Scenario: Navigate to the 'My Orders' section
Given I am logged in to the e-commerce website
When I navigate to the 'My Orders' section
Then 'My Orders' page should display a list of past and current orders
@TC-308
Scenario: Select the order to be tracked
Given I am on the 'My Orders' page
When I select the order with Order ID "O987654"
Then the order details page should be displayed with tracking options
@TC-308
Scenario: Click on the 'Track Order' button
Given I am on the order details page
When I click on the 'Track Order' button
Then I should be redirected to the tracking page with current delivery status
@TC-308
Scenario: Simulate peak traffic conditions
Given I am on the tracking page
When peak traffic conditions are simulated
Then the system should continue to function efficiently under high load
@TC-308
Scenario: Verify the tracking information displayed during peak traffic
Given peak traffic conditions are simulated
When I check the tracking information
Then tracking details should remain accurate and up-to-date
@TC-308
Scenario: Check for any delays or performance issues
Given peak traffic conditions are simulated
When I monitor the system performance
Then the system should maintain performance standards without significant delays
@TC-308
Scenario: Log out from the website
Given I am logged in to the e-commerce website
When I log out
Then I should be logged out successfully
@TC-308
Scenario: Log back in and verify the tracking status again
Given I am logged out from the e-commerce website
When I log back in using valid credentials
Then the tracking status should be consistent and accurate even during peak traffic
@TC-308
Scenario: Attempt to track another order
Given I am logged in to the e-commerce website
When I attempt to track another order
Then tracking information should be displayed correctly for the new order
@TC-308
Scenario: Check for email notifications related to delivery status
Given I am tracking an order
When there are delivery status changes
Then I should receive email updates about delivery status changes
@TC-308
Scenario: Verify the integration with the shipping carrier's tracking system
Given I am tracking an order
When I check the integration with the shipping carrier's tracking system
Then tracking information should be synced accurately with the carrier's system
@TC-308
Scenario: Check for any error messages if tracking fails
Given I am tracking an order
When tracking fails
Then relevant error messages should be displayed
@TC-308
Scenario: Ensure the security of tracking information
Given I am tracking an order
When I check the security of tracking information
Then tracking details should be accessible only to authorized users
@TC-308
Scenario: Verify the website's responsiveness on mobile devices
Given I am using a mobile device
When I access the tracking functionality
Then tracking functionality should be consistent and efficient on mobile platforms