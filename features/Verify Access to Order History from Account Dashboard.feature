Feature: Verify Access to Order History from Account Dashboard
@TC-187
Scenario: User can view their order history from their account dashboard
Given a user account with previous orders
When the user logs in to their account
Then the user is successfully logged in
@TC-187
Scenario: Access to the account dashboard
When the user navigates to the account dashboard
Then the account dashboard is displayed
@TC-187
Scenario: Locate the order history section
Given the account dashboard is displayed
When the user locates the order history section on the dashboard
Then the order history section is visible on the dashboard
@TC-187
Scenario: View order history details
Given the order history section is visible
When the user clicks on the order history section
Then the order history details are displayed
@TC-187
Scenario: Verify list of past orders
Given the order history details are displayed
Then all past orders are listed with relevant details
@TC-187
Scenario: Check details of a specific order
Given the list of past orders is displayed
When the user checks the details of a specific order from the list
Then the order details including items, quantities, prices, and status are displayed
@TC-187
Scenario: Ensure order history is sorted by date
Given the list of past orders is displayed
Then orders are sorted from most recent to oldest
@TC-187
Scenario: Filter orders by date range
Given the order history details are displayed
When the user filters orders by selecting a specific date range
Then the user can filter orders by date range
@TC-187
Scenario: Search functionality in order history
Given the order history details are displayed
When the user searches for specific orders using keywords or order numbers
Then the user can search for specific orders
@TC-187
Scenario: Display of payment and delivery status
Given the list of past orders is displayed
Then each order displays its payment and delivery status clearly
@TC-187
Scenario: Download order invoices
Given the order history details are displayed
When the user downloads invoices for past orders
Then the user can download order invoices
@TC-187
Scenario: Log out from the user account
When the user logs out from their account
Then the user is logged out successfully
@TC-187
Scenario: Verify persistence of order history
Given the user is logged out
When the user logs back in
Then the order history remains accessible and unchanged
@TC-187
Scenario: Responsiveness of order history section
Given the order history details are displayed
When the user accesses the order history section on different devices
Then the order history is accessible and displays correctly on various devices
@TC-187
Scenario: Security of order history data
Given the order history details are displayed
Then the order history data is secure and accessible only to the authorized user