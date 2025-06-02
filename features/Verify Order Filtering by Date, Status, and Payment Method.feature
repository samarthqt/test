Feature: Verify Order Filtering by Date, Status, and Payment Method
@TC-189
Scenario: User logs into their account
Given the user is on the login page
When the user enters valid credentials
Then the user is successfully logged in
And the user is redirected to the dashboard
@TC-189
Scenario: Navigate to the 'Order History' section
Given the user is logged in
When the user navigates to the 'Order History' section
Then the Order History page is displayed
@TC-189
Scenario: Locate filter options for date, status, and payment method
Given the user is on the Order History page
When the user views the filter options
Then filter options for date, status, and payment method are visible
@TC-189
Scenario: Apply a filter to view orders from a specific date range
Given the user is on the Order History page
When the user applies a filter for a specific date range
Then the order history updates to show only orders within the specified date range
@TC-189
Scenario: Clear the date filter
Given the user has applied a date filter
When the user clears the date filter
Then the order history reverts to showing all orders
@TC-189
Scenario: Apply a filter to view orders with a specific status
Given the user is on the Order History page
When the user applies a filter for a specific status
Then the order history updates to show only orders with the selected status
@TC-189
Scenario: Clear the status filter
Given the user has applied a status filter
When the user clears the status filter
Then the order history reverts to showing all orders
@TC-189
Scenario: Apply a filter to view orders with a specific payment method
Given the user is on the Order History page
When the user applies a filter for a specific payment method
Then the order history updates to show only orders with the selected payment method
@TC-189
Scenario: Clear the payment method filter
Given the user has applied a payment method filter
When the user clears the payment method filter
Then the order history reverts to showing all orders
@TC-189
Scenario: Apply multiple filters simultaneously
Given the user is on the Order History page
When the user applies multiple filters simultaneously
Then the order history updates to show orders matching all selected filter criteria
@TC-189
Scenario: Clear all filters
Given the user has applied multiple filters
When the user clears all filters
Then the order history reverts to showing all orders
@TC-189
Scenario: Attempt to filter orders with an invalid date range
Given the user is on the Order History page
When the user applies a filter with an invalid date range
Then the system displays an error message indicating an invalid date range
@TC-189
Scenario: Verify filters are retained when navigating away and back to the order history page
Given the user has applied filters on the Order History page
When the user navigates away and then returns to the Order History page
Then the filters remain applied
@TC-189
Scenario: Check the responsiveness of the filter options on different devices
Given the user is accessing the Order History page on different devices
When the user views the filter options
Then the filter options are accessible and functional across devices
@TC-189
Scenario: Log out and attempt to apply filters
Given the user is logged out
When the user attempts to apply filters on the Order History page
Then the user is prompted to log in before applying filters