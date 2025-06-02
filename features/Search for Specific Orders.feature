Feature: Search for Specific Orders
Verify that users can search for specific orders using various criteria.
@TC-193
Scenario: Log in to the user account with valid credentials
Given the user navigates to the login page
When the user enters valid credentials
Then the user is successfully logged in and redirected to the dashboard
@TC-193
Scenario: Navigate to the 'Order History' section
Given the user is logged in
When the user navigates to the 'Order History' section
Then the order history page is displayed with a list of past orders
@TC-193
Scenario: Search for orders using Order ID
Given the user is on the order history page
When the user enters an order ID in the search bar
Then the system filters and displays the order matching the entered ID
@TC-193
Scenario: Search for orders by date range
Given the user is on the order history page
When the user searches for orders by date range
Then orders within the specified date range are displayed
@TC-193
Scenario: Search for orders using product name
Given the user is on the order history page
When the user searches for orders using product name
Then orders containing the specified product are displayed
@TC-193
Scenario: Combine multiple search criteria
Given the user is on the order history page
When the user combines multiple search criteria (e.g., date and product name)
Then the system accurately filters orders based on combined criteria
@TC-193
Scenario: Attempt a search with invalid or non-existent criteria
Given the user is on the order history page
When the user attempts a search with invalid or non-existent criteria
Then the system displays a message indicating no matching orders found
@TC-193
Scenario: Clear the search criteria and view all orders
Given the user is on the order history page
When the user clears the search criteria
Then all orders are displayed, indicating the search criteria were cleared successfully
@TC-193
Scenario: Verify search functionality on different browsers
Given the user is on the order history page
When the user performs search operations on different browsers
Then search functionality works consistently across different web browsers
@TC-193
Scenario: Check for performance and response time during search operations
Given the user is on the order history page
When the user performs search operations
Then search operations complete quickly and efficiently without delays
@TC-193
Scenario: Test search functionality with a large number of orders
Given the user is on the order history page
When the user searches through a large number of orders
Then the system handles large datasets effectively without performance degradation
@TC-193
Scenario: Search for orders using partial criteria
Given the user is on the order history page
When the user searches for orders using partial criteria (e.g., part of the product name)
Then the system suggests possible matches based on partial criteria
@TC-193
Scenario: Verify the accuracy of search results
Given the user is on the order history page
When the user performs a search
Then search results accurately reflect the entered criteria
@TC-193
Scenario: Attempt to search for orders while logged out
Given the user is logged out
When the user attempts to search for orders
Then the system prevents search operations when the user is not logged in
@TC-193
Scenario: Check for any error messages during search operations
Given the user is on the order history page
When the user performs search operations
Then no error messages are displayed, indicating a smooth search process