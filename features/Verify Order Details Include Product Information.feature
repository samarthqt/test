Feature: Verify Order Details Include Product Information
@TC-190
Scenario: Verify order details include product names, quantities, prices, and total cost
Given the user is logged into their account
When the user navigates to the 'Order History' section
And selects an order to view detailed information
Then the product names are listed in the order details
And the quantities for each product are displayed
And the prices for each product are displayed
And the total cost of the order is displayed
And any discounts or promotions applied to the order are displayed
And the order details include tax information, if applicable
And a download or print option for the order details is available
And product images are displayed alongside product details
@TC-190
Scenario: Attempt to view order details without logging in
Given the user is not logged into their account
When the user attempts to view order details
Then the user is prompted to log in before viewing order details
@TC-190
Scenario: Check accuracy of total cost when multiple quantities of a product are ordered
Given the user is logged into their account
And the user has past orders with multiple quantities of products
When the user views the order details
Then the total cost accurately reflects the quantities ordered
@TC-190
Scenario: Verify currency display for international orders
Given the user is logged into their account
And the user has international orders
When the user views the order details
Then the currency is displayed correctly according to the user's location
@TC-190
Scenario: Log out and attempt to view order details
Given the user is logged out of their account
When the user attempts to view order details
Then the user is redirected to the login page