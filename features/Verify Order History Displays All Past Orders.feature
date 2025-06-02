Feature: Verify Order History Displays All Past Orders
@TC-188
Scenario: Verify user can log into their account
Given the user has a valid account with multiple past orders
When the user logs into their account
Then the user is successfully logged in and redirected to the dashboard
@TC-188
Scenario: Navigate to the 'Order History' section
Given the user is logged into their account
When the user navigates to the 'Order History' section
Then the Order History page is displayed
@TC-188
Scenario: Verify the list of past orders is displayed
Given the user is on the Order History page
When the user views the list of past orders
Then all past orders are listed with basic details
@TC-188
Scenario: Check the order status for each order
Given the user is viewing the list of past orders
When the user checks the order status for each order
Then each order displays the correct order status
@TC-188
Scenario: Check the payment details for each order
Given the user is viewing the list of past orders
When the user checks the payment details for each order
Then each order displays the correct payment method and status
@TC-188
Scenario: Select an order to view detailed information
Given the user is viewing the list of past orders
When the user selects an order to view detailed information
Then detailed information for the selected order is displayed
@TC-188
Scenario: Verify the order status in the detailed view
Given the user is viewing detailed information for a selected order
When the user verifies the order status
Then the order status matches the status shown in the list view
@TC-188
Scenario: Verify the payment details in the detailed view
Given the user is viewing detailed information for a selected order
When the user verifies the payment details
Then the payment details match those shown in the list view
@TC-188
Scenario: Check the presence of a filter or search option
Given the user is on the Order History page
When the user looks for a filter or search option
Then a filter or search option is available for refining order history
@TC-188
Scenario: Apply a filter to view orders by a specific status
Given the user is on the Order History page
When the user applies a filter to view orders by a specific status
Then the order history updates to show only orders with the selected status
@TC-188
Scenario: Remove the filter
Given the user has applied a filter on the Order History page
When the user removes the filter
Then the order history reverts to showing all orders
@TC-188
Scenario: Attempt to access order history without logging in
Given the user is not logged into their account
When the user attempts to access the order history
Then the user is prompted to log in before accessing order history
@TC-188
Scenario: Verify the display of orders with different payment methods
Given the user is viewing the list of past orders
When the user checks the display of orders with different payment methods
Then orders display correct payment method icons or labels
@TC-188
Scenario: Check for pagination if the number of orders is large
Given the user is on the Order History page
When the number of orders is large
Then pagination controls are available and functional
@TC-188
Scenario: Log out and attempt to view order history
Given the user is logged into their account
When the user logs out and attempts to view order history
Then the user is redirected to the login page