Feature: Verify error message for invalid product category filter
@TC-62
Scenario: Display error message for invalid category filter
Given the user is logged into the retail application
When the user navigates to the product catalog section
And the user locates the filter option for product categories
And the user selects an invalid category to filter products
Then the system displays an error message indicating the category is invalid
And UI elements remain intact after the filter attempt
@TC-62
Scenario: Handle empty category filter gracefully
Given the user is logged into the retail application
When the user navigates to the product catalog section
And the user locates the filter option for product categories
And the user attempts filtering products with an empty category
Then the system handles the empty category gracefully and displays an appropriate message
@TC-62
Scenario: Handle special characters in category filter
Given the user is logged into the retail application
When the user navigates to the product catalog section
And the user locates the filter option for product categories
And the user filters products using special characters in the category
Then the system handles special characters gracefully and displays an appropriate message
@TC-62
Scenario: Validate system performance with rapid successive filter attempts
Given the user is logged into the retail application
When the user navigates to the product catalog section
And the user locates the filter option for product categories
And the user performs rapid successive filter attempts
Then the system maintains performance and responsiveness
@TC-62
Scenario: Log out from the application
Given the user is logged into the retail application
When the user logs out from the application
Then the user is successfully logged out and redirected to the login page
@TC-62
Scenario: Consistent filter functionality across different user accounts
Given the user is logged into the retail application
When the user navigates to the product catalog section
And the user locates the filter option for product categories
And the user performs a filter operation
Then the filter functionality works consistently across different user accounts
@TC-62
Scenario: Consistent filter functionality across different browsers
Given the user is logged into the retail application
When the user navigates to the product catalog section
And the user locates the filter option for product categories
And the user performs a filter operation
Then the filter works consistently on all supported browsers
@TC-62
Scenario: Filter functionality on mobile devices
Given the user is logged into the retail application
When the user navigates to the product catalog section
And the user locates the filter option for product categories
And the user performs a filter operation
Then the filter operations can be performed on mobile devices without any issues
@TC-62
Scenario: Handle invalid data format in category filter
Given the user is logged into the retail application
When the user navigates to the product catalog section
And the user locates the filter option for product categories
And the user attempts to filter with an invalid data format
Then the system handles invalid data gracefully and displays an error message
@TC-62
Scenario: Check system logs for errors during filter operation
Given the user is logged into the retail application
When the user navigates to the product catalog section
And the user locates the filter option for product categories
And the user performs a filter operation
Then the system logs do not show any critical errors related to filter operations