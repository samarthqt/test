Feature: Verify 'Proceed to Checkout' Button Functionality
@TC-161
Scenario: Verify redirection to checkout page with 3 items in cart
Given a user account with items added to the cart
When the user logs in to the retail application
And navigates to the cart page
And clicks the 'Proceed to Checkout' button
Then the user is redirected to the checkout page
And the checkout page displays the correct items in the cart
@TC-161
Scenario Outline: Verify redirection to checkout page with varying number of items in cart
Given a user account with <number_of_items> items added to the cart
When the user logs in to the retail application
And navigates to the cart page
And clicks the 'Proceed to Checkout' button
Then the user is redirected to the checkout page
And the checkout page displays all <number_of_items> items correctly
Examples:
| number_of_items |
| 5               |
| 10              |
| 1               |
@TC-161
Scenario: Verify checkout page with an empty cart
Given a user account with no items in the cart
When the user logs in to the retail application
And navigates to the cart page
And clicks the 'Proceed to Checkout' button
Then the user is redirected to the checkout page
And the checkout page displays a message indicating no items are present
@TC-161
Scenario: Verify 'Proceed to Checkout' button visibility and functionality
Given a user is on the cart page
Then the 'Proceed to Checkout' button is visible and functional
@TC-161
Scenario: Test button functionality on mobile devices
Given a user is on the cart page using a mobile device
When the user clicks the 'Proceed to Checkout' button
Then the user is redirected to the checkout page on the mobile device
@TC-161
Scenario Outline: Test button functionality on different browsers
Given a user is on the cart page using <browser>
When the user clicks the 'Proceed to Checkout' button
Then the user is redirected to the checkout page on <browser>
Examples:
| browser    |
| Chrome     |
| Firefox    |
| Safari     |
| Edge       |
@TC-161
Scenario: Verify checkout page loads without errors
Given a user clicks the 'Proceed to Checkout' button
Then the checkout page loads successfully without any error messages
@TC-161
Scenario: Check checkout page for responsiveness
Given a user is on the checkout page
Then the page layout adjusts correctly to screen size
@TC-161
Scenario: Verify checkout page displays payment options
Given a user is on the checkout page
Then payment options are visible and selectable
@TC-161
Scenario: Ensure checkout page allows address input
Given a user is on the checkout page
Then address fields are editable and save inputs correctly