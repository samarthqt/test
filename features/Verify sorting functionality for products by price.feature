Feature: Verify sorting functionality for products by price
To ensure that users can sort products by price in ascending and descending order.
@TC-60
Scenario: Verify sorting products by price in ascending order
Given the user is logged into the retail application
And the product catalog is displayed with a list of available products
When the user selects 'Sort by Price' in ascending order
Then the products are sorted from lowest to highest price
And each subsequent product has a higher price than the previous one
@TC-60
Scenario: Verify sorting products by price in descending order
Given the user is logged into the retail application
And the product catalog is displayed with a list of available products
When the user selects 'Sort by Price' in descending order
Then the products are sorted from highest to lowest price
And each subsequent product has a lower price than the previous one
@TC-60
Scenario: Attempt to sort products by price with an empty catalog
Given the user is logged into the retail application
And the product catalog is empty
When the user attempts to sort products by price
Then the system displays a message indicating no products are available to sort
@TC-60
Scenario: Check sorting performance with a large number of products
Given the user is logged into the retail application
And the product catalog contains a large number of products
When the user selects 'Sort by Price'
Then the sorting operation completes within acceptable time limits
@TC-60
Scenario: Validate UI responsiveness after sorting
Given the user is logged into the retail application
And the product catalog is displayed with a list of available products
When the user sorts products by price
Then the UI remains responsive and no errors are displayed
@TC-60
Scenario: Log out from the application
Given the user is logged into the retail application
When the user logs out from the application
Then the user is successfully logged out and redirected to the login page
@TC-60
Scenario: Repeat sorting operation using a different user account
Given the user logs into the retail application using a different user account
And the product catalog is displayed with a list of available products
When the user selects 'Sort by Price'
Then the sorting functionality works consistently across different user accounts
@TC-60
Scenario: Attempt sorting products with invalid price data
Given the user is logged into the retail application
And the product catalog contains products with invalid price data
When the user attempts to sort products by price
Then the system handles invalid data gracefully and displays an error message
@TC-60
Scenario: Verify sorting functionality across different browsers
Given the user is logged into the retail application on different supported browsers
And the product catalog is displayed with a list of available products
When the user selects 'Sort by Price'
Then the sorting works consistently on all supported browsers
@TC-60
Scenario: Test sorting functionality on mobile devices
Given the user is logged into the retail application on a mobile device
And the product catalog is displayed with a list of available products
When the user selects 'Sort by Price'
Then products can be sorted by price on mobile devices without any issues