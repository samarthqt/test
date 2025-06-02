Feature: Order History Search and Filter by Date Range
@TC-82
Scenario: Log in to the user account
Given the user has a User ID "78912"
When the user logs into the account
Then the user is successfully logged in and navigated to the account dashboard
@TC-82
Scenario: Navigate to the Order History section
Given the user is on the account dashboard
When the user navigates to the 'Order History' section
Then the order history page is displayed with a list of past orders
@TC-82
Scenario: Enter date range in the search filter
Given the user is on the order history page
When the user enters the date range from "2023-01-01" to "2023-12-31" in the search filter
Then the date range filter is applied successfully
@TC-82
Scenario: Filter orders based on the date range
Given the date range filter is applied
When the user clicks the 'Search' button
Then orders within the specified date range are displayed
@TC-82
Scenario: Verify displayed orders match the date range criteria
Given orders are displayed based on the date range
Then all displayed orders fall within the date range from "2023-01-01" to "2023-12-31"
@TC-82
Scenario: Check order details for accuracy and completeness
Given orders are displayed based on the date range
Then order details are accurate and complete for each order displayed
@TC-82
Scenario: Export the filtered order list
Given orders are filtered based on the date range
When the user attempts to export the filtered order list
Then the filtered order list is exported successfully
@TC-82
Scenario: Verify the exported list matches the filtered results
Given the filtered order list is exported
Then the exported list contains the same orders as displayed on the screen
@TC-82
Scenario: Change date range and repeat search
Given the user is on the order history page
When the user changes the date range to a different set of dates and repeats the search
Then orders within the new date range are displayed
@TC-82
Scenario: Verify multiple date range searches consecutively
Given the user performs a search with a date range
When the user changes the date range and performs another search
Then the system supports consecutive searches with different date ranges without errors
@TC-82
Scenario: Search with a date range that has no orders
Given the user enters a date range with no orders
When the user clicks the 'Search' button
Then the system displays a message indicating no orders found for the specified date range
@TC-82
Scenario: Check system's response time to search and filter operation
Given the user performs a search and filter operation
Then the system responds promptly to the search and filter operation
@TC-82
Scenario: Review system logs related to search and filter operation
Given the user performs a search and filter operation
Then system logs indicate the search and filter operation and any results returned
@TC-82
Scenario: Verify user account does not show unauthorized changes
Given the user performs search and filter operations
Then user account details remain unchanged and secure
@TC-82
Scenario: Search using invalid date formats
Given the user enters invalid date formats in the search filter
When the user clicks the 'Search' button
Then the system displays an error message indicating invalid date formats