Feature: Verify Order History Retention
@TC-196
Scenario: Ensure order history is retained for a minimum of one year
Given a user account with previous orders
When the user logs in using valid credentials
Then the user is successfully logged in
@TC-196
Scenario: Access order history feature
Given user ID: 12345
When the user navigates to the 'Order History' section
Then the order history page is displayed
@TC-196
Scenario: Verify presence of orders from 29th May 2022
Given order date: 29th May 2022
When the current date is 30th May 2023
Then orders from 29th May 2022 are visible
@TC-196
Scenario: Check details of an order from 29th May 2022
When the user checks the details of an order from 29th May 2022
Then order details are correctly displayed
@TC-196
Scenario: Attempt to search for orders older than one year
When the user attempts to search for an order older than one year
Then no orders older than one year are displayed
@TC-196
Scenario: Verify filtering options for date range
When the user verifies the filtering options for date range
Then date range filter is available and functional
@TC-196
Scenario: Select a date range from 29th May 2022 to 29th May 2023
When the user selects a date range from 29th May 2022 to 29th May 2023
Then orders within the selected date range are displayed
@TC-196
Scenario: Check for missing orders within the one-year range
When the user checks for any missing orders within the one-year range
Then all orders within the one-year range are present
@TC-196
Scenario: Validate accuracy of order details displayed
When the user validates the accuracy of the order details displayed
Then order details are accurate and complete
@TC-196
Scenario: Attempt to export order history for the past year
When the user attempts to export the order history for the past year
Then order history is successfully exported
@TC-196
Scenario: Check format of exported order history file
When the user checks the format of the exported order history file
Then exported file is in correct format and readable
@TC-196
Scenario: Try to delete an order from the history
When the user tries to delete an order from the history
Then the user is unable to delete orders from history
@TC-196
Scenario: Verify security measures for accessing order history
When the user verifies the security measures for accessing order history
Then order history access is secure and requires authentication
@TC-196
Scenario: Check if the order history page is responsive and loads quickly
When the user checks if the order history page is responsive and loads quickly
Then order history page loads efficiently without delays
@TC-196
Scenario: Ensure order history is consistent across different devices
When the user ensures that the order history is consistent across different devices
Then order history displays consistent information on all devices