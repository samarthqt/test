Feature: Verify User Can View Past Orders and Order Details
@TC-76
Scenario: User logs in to view past orders
Given the user has valid credentials
When the user logs in with User ID "12345"
Then the user is redirected to the dashboard
@TC-76
Scenario: Navigate to Order History
Given the user is on the dashboard
When the user navigates to the "Order History" section
Then the "Order History" section is displayed with a list of past orders
@TC-76
Scenario: View Order Details
Given the user is on the "Order History" section
When the user selects an order with Order ID "67890"
Then the order details are displayed including product names, quantities, prices, and total cost
@TC-76
Scenario: Verify Order Date and Status
Given the order details are displayed
Then the order date "2022-01-01" and status match the expected values
@TC-76
Scenario: Check Product Details
Given the order details are displayed
Then the product details such as name "Example Product", quantity "2", and price are accurate
@TC-76
Scenario: Verify Total Order Amount
Given the order details are displayed
Then the total amount "$50.00" matches the sum of product prices and quantities
@TC-76
Scenario: Verify Discounts and Promotions
Given the order details are displayed
Then any applicable discounts or promotions are accurately applied to the total amount
@TC-76
Scenario: Verify Shipping and Billing Addresses
Given the order details are displayed
Then the shipping address and billing address are correct and match the user's information
@TC-76
Scenario: Verify Payment Method
Given the order details are displayed
Then the payment method matches the method used during checkout
@TC-76
Scenario: Download Order Invoice
Given the order details are displayed
When the user attempts to download the order invoice or receipt
Then the invoice or receipt is successfully downloaded and contains accurate order information
@TC-76
Scenario: Filter Orders by Date Range
Given the user is on the "Order History" section
When the user filters orders by a specified date range
Then orders are filtered and displayed according to the specified date range
@TC-76
Scenario: Sort Orders by Status
Given the user is on the "Order History" section
When the user sorts orders by status
Then orders are sorted correctly based on status
@TC-76
Scenario: Check Pagination of Order History
Given the user is on the "Order History" section
When there are large numbers of orders
Then pagination is implemented and works correctly for navigating through orders
@TC-76
Scenario: Navigate Back to Dashboard
Given the user is on the order details page
When the user navigates back to the dashboard
Then the user is redirected to the dashboard without any issues
@TC-76
Scenario: Log Out from User Account
Given the user is on the dashboard
When the user logs out from the account
Then the user is successfully logged out and redirected to the login page