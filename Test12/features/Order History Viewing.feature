Feature: Order History Viewing
Users should be able to view their past orders, including order status and payment details.
@43
Scenario: View past orders from user account
Given the user is logged into their account
When the user navigates to the order history page
Then the user should see a list of their past orders
@43
Scenario: View order details including status, payment method, and transaction date
Given the user is on the order history page
When the user selects an order from the list
Then the user should see the order status, payment method, and transaction date
@43
Scenario: Filter orders by date
Given the user is on the order history page
When the user filters orders by a specific date range
Then the user should see orders within that date range
@43
Scenario: Filter orders by status
Given the user is on the order history page
When the user filters orders by a specific status
Then the user should see orders with that status
@43
Scenario: View detailed information for each order
Given the user is on the order history page
When the user selects an order for detailed view
Then the user should see detailed information for that order
@43
Scenario: Access order history on web platform
Given the user is using a web browser
When the user logs into their account and navigates to the order history page
Then the user should see their order history
@43
Scenario: Access order history on mobile platform
Given the user is using a mobile device
When the user logs into their account and navigates to the order history page
Then the user should see their order history