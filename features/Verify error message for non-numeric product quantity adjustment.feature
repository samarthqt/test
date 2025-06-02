Feature: Verify error message for non-numeric product quantity adjustment
As a user, I want to see an appropriate error message when entering non-numeric values for product quantity adjustment in the shopping cart.
@TC-68
Scenario: Verify error message for non-numeric value 'abc'
Given a user is logged in
And a product is added to the cart
When the user navigates to the shopping cart page
And selects a product to adjust its quantity
And enters a non-numeric value 'abc' in the quantity field
Then an error message indicating invalid quantity input is displayed
@TC-68
Scenario: Verify error message for non-numeric value '@!#$'
Given a user is logged in
And a product is added to the cart
When the user navigates to the shopping cart page
And selects a product to adjust its quantity
And enters a non-numeric value '@!#$' in the quantity field
Then an error message indicating invalid quantity input is displayed
@TC-68
Scenario: Verify error message for non-numeric value ' ' (space)
Given a user is logged in
And a product is added to the cart
When the user navigates to the shopping cart page
And selects a product to adjust its quantity
And enters a space ' ' in the quantity field
Then an error message indicating invalid quantity input is displayed
@TC-68
Scenario: Verify error message for non-numeric value 'ten'
Given a user is logged in
And a product is added to the cart
When the user navigates to the shopping cart page
And selects a product to adjust its quantity
And enters a non-numeric value 'ten' in the quantity field
Then an error message indicating invalid quantity input is displayed
@TC-68
Scenario: Verify error message for non-numeric value '1.5.0'
Given a user is logged in
And a product is added to the cart
When the user navigates to the shopping cart page
And selects a product to adjust its quantity
And enters a non-numeric value '1.5.0' in the quantity field
Then an error message indicating invalid quantity input is displayed
@TC-68
Scenario: Attempt to save changes with invalid quantity input
Given a user is logged in
And a product is added to the cart
When the user navigates to the shopping cart page
And selects a product to adjust its quantity
And enters a non-numeric value in the quantity field
And attempts to save the changes
Then the system prevents saving and displays an error message
@TC-68
Scenario: Verify cart remains unchanged after invalid input
Given a user is logged in
And a product is added to the cart
When the user navigates to the shopping cart page
And selects a product to adjust its quantity
And enters a non-numeric value in the quantity field
Then the cart should retain the original quantity before the invalid input was attempted
@TC-68
Scenario: Check error message guidance on valid inputs
Given a user is logged in
And a product is added to the cart
When the user navigates to the shopping cart page
And selects a product to adjust its quantity
And enters a non-numeric value in the quantity field
Then the error message should suggest entering a numeric value
@TC-68
Scenario: Repeat test for different products in the cart
Given a user is logged in
And multiple products are added to the cart
When the user navigates to the shopping cart page
And selects different products to adjust their quantities
And enters non-numeric values in the quantity fields
Then consistent error message behavior should be observed across different products
@TC-68
Scenario: Verify error message consistency after relogging
Given a user is logged in
And a product is added to the cart
When the user logs out and logs back in
And navigates to the shopping cart page
And selects a product to adjust its quantity
And enters a non-numeric value in the quantity field
Then error message behavior remains consistent after relogging
@TC-68
Scenario: Verify error message consistency across different browsers
Given a user is logged in
And a product is added to the cart
When the user switches browser
And navigates to the shopping cart page
And selects a product to adjust its quantity
And enters a non-numeric value in the quantity field
Then error message should be consistent across different browsers
@TC-68
Scenario: Refresh page after entering invalid values
Given a user is logged in
And a product is added to the cart
When the user navigates to the shopping cart page
And selects a product to adjust its quantity
And enters a non-numeric value in the quantity field
And refreshes the page
Then the cart should revert to original quantities and error messages should reset
@TC-68
Scenario: Check for console errors during test steps
Given a user is logged in
And a product is added to the cart
When the user navigates to the shopping cart page
And selects a product to adjust its quantity
And enters a non-numeric value in the quantity field
Then no console errors should appear during the test execution