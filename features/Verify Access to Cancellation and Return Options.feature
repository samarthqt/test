Feature: Verify Access to Cancellation and Return Options
@TC-217
Scenario: Ensure users can access cancellation and return options from their order details page
Given a user account with completed orders
When the user logs into the account with the provided credentials
Then the user is successfully logged into the account
@TC-217
Scenario: Access the order details page
Given the user is logged in
When the user navigates to the order history section of the account
Then the order history section is displayed with a list of orders
@TC-217
Scenario: Select the order with Order ID 54321
Given the order history section is displayed
When the user selects the order with Order ID 54321 from the list
Then the order details page for Order ID 54321 is displayed
@TC-217
Scenario: Locate cancellation and return options
Given the order details page for Order ID 54321 is displayed
When the user locates the cancellation and return options on the order details page
Then the cancellation and return options are visible on the page
@TC-217
Scenario: Initiate cancellation process
Given the cancellation option is visible
When the user clicks on the cancellation option to initiate the cancellation process
Then the cancellation process is initiated successfully
@TC-217
Scenario: Verify cancellation confirmation prompt
Given the cancellation process is initiated
When the system prompts for confirmation of the cancellation
Then the confirmation prompt is displayed for the cancellation
@TC-217
Scenario: Confirm cancellation and check updated order status
Given the confirmation prompt is displayed
When the user confirms the cancellation
Then the order status is updated to 'Cancelled'
@TC-217
Scenario: Initiate return process
Given the return option is visible
When the user accesses the return option and initiates the return process
Then the return process is initiated successfully
@TC-217
Scenario: Verify return confirmation prompt
Given the return process is initiated
When the system prompts for confirmation of the return
Then the confirmation prompt is displayed for the return
@TC-217
Scenario: Confirm return and check updated order status
Given the confirmation prompt is displayed
When the user confirms the return
Then the order status is updated to 'Return Initiated'
@TC-217
Scenario: Ensure options are disabled for ineligible orders
Given the order details page is displayed
When the order is not eligible for cancellation or return
Then the cancellation and return options are disabled
@TC-217
Scenario: Verify email notifications for cancellation and return actions
Given the user initiates cancellation or return
When the actions are completed
Then email notifications are sent for both cancellation and return actions
@TC-217
Scenario: View cancellation and return history
Given the user has completed cancellation or return actions
When the user checks their account
Then the cancellation and return history is accessible in the account
@TC-217
Scenario: Download cancellation and return receipts
Given the user has completed cancellation or return actions
When the user accesses the account
Then the user can download the cancellation and return receipts
@TC-217
Scenario: Verify options accessibility across devices
Given the user has completed orders
When the user accesses the order details page on different devices
Then the cancellation and return options are accessible on all supported devices