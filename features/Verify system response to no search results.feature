Feature: Verify system response to no search results
@TC-61
Scenario: User searches for a query with no matching products
Given the user is logged into the retail application
When the user navigates to the search bar in the product catalog section
And enters a search query that has no matching products
Then the system displays a message indicating no products were found matching the search criteria
And UI elements remain intact after search
And alternative suggestions are provided if applicable
@TC-61
Scenario: User searches using special characters
Given the user is logged into the retail application
When the user navigates to the search bar in the product catalog section
And enters a search query with special characters
Then the system handles special characters gracefully and displays an appropriate message
@TC-61
Scenario: User searches using an excessively long query
Given the user is logged into the retail application
When the user navigates to the search bar in the product catalog section
And enters an excessively long search query
Then the system processes the query and handles it without errors
@TC-61
Scenario: Validate system performance with rapid successive searches
Given the user is logged into the retail application
When the user performs rapid successive search operations
Then the system maintains performance and responsiveness
@TC-61
Scenario: User logs out from the application
Given the user is logged into the retail application
When the user logs out from the application
Then the user is successfully logged out and redirected to the login page
@TC-61
Scenario Outline: Repeat search operation using a different user account
Given the user is logged into the retail application using <user account>
When the user navigates to the search bar in the product catalog section
And enters a search query that has no matching products
Then the search functionality works consistently across different user accounts
Examples:
| user account |
| User A       |
| User B       |
@TC-61
Scenario Outline: Test search functionality across different browsers
Given the user is logged into the retail application
When the user navigates to the search bar in the product catalog section using <browser>
And enters a search query that has no matching products
Then the search works consistently on all supported browsers
Examples:
| browser   |
| Chrome    |
| Firefox   |
| Safari    |
@TC-61
Scenario Outline: Test search functionality on mobile devices
Given the user is logged into the retail application
When the user navigates to the search bar in the product catalog section using <device>
And enters a search query that has no matching products
Then search operations can be performed on mobile devices without any issues
Examples:
| device      |
| iPhone      |
| Android     |
@TC-61
Scenario: Attempt search with invalid data format
Given the user is logged into the retail application
When the user navigates to the search bar in the product catalog section
And enters a search query with invalid data format
Then the system handles invalid data gracefully and displays an error message
@TC-61
Scenario: Check system logs for any errors during search operation
Given the user is logged into the retail application
When the user performs a search operation
Then system logs do not show any critical errors related to search operations