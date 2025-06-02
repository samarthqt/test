Feature: Verify user can adjust product quantities in the cart
@TC-65
Scenario: Adjust product quantity in the shopping cart
Given the user is logged into the application
And at least one product is added to the cart
When the user navigates to the shopping cart page
Then the shopping cart page is displayed with current products
@TC-65
Scenario: Locate and adjust product quantity
Given the product with Product ID: 101 is visible in the cart
When the user enters a new quantity in the quantity field
Then the quantity field accepts the new value
@TC-65
Scenario: Update product quantity
Given the user has entered a new quantity
When the user clicks the 'Update' button
Then the product quantity is updated in the cart
And a confirmation message is displayed
@TC-65
Scenario: Verify total price recalculation
Given the product quantity is updated
When the user checks the total price
Then the total price reflects the new quantity
@TC-65
Scenario: Prevent setting quantity to zero
Given the user attempts to set the quantity to zero
Then the system prevents setting quantity to zero
And displays an error message
@TC-65
Scenario: Prevent non-numeric quantity input
Given the user enters a non-numeric value in the quantity field
Then the system displays an error message indicating invalid input
@TC-65
Scenario: Warn about insufficient stock
Given the user increases the quantity to a number greater than available stock
Then the system displays a warning about insufficient stock
@TC-65
Scenario: Decrease product quantity
Given the user decreases the quantity to a lower number
Then the quantity is updated successfully
And the total price is recalculated
@TC-65
Scenario: Real-time cart updates
Given the user changes the quantity
Then the cart reflects the updated quantity immediately
@TC-65
Scenario: Cart persistence after re-login
Given the user logs out and logs back in
Then the cart retains updated quantities after re-login
@TC-65
Scenario: Adjust quantity for a new product
Given the user adds a new product to the cart
When the user adjusts its quantity
Then the new product quantity can be adjusted successfully
@TC-65
Scenario: Adjust quantity for promotional products
Given the user attempts to adjust quantity for a product with a special promotion
Then quantity adjustment works correctly with promotional products
@TC-65
Scenario: Cart icon updates with correct item count
Given the user changes the quantity of items in the cart
Then the cart icon displays the correct number of items
@TC-65
Scenario: Adjust quantity for bundled products
Given the user checks the system for quantity adjustment for bundled products
Then the system permits quantity adjustment for bundled products