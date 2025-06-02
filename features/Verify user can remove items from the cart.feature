Feature: Verify user can remove items from the cart
@TC-66
Scenario: User can successfully remove an item from the shopping cart
Given the user is logged into the application
And the user navigates to the shopping cart page
And the shopping cart page is displayed with current products
And at least one product is added to the cart
When the user locates the product to be removed from the cart
And clicks the 'Remove' button next to the product
Then the product is removed from the cart
And a confirmation message is displayed
And the total price is recalculated after product removal
And the cart updates immediately and accurately reflects current items
@TC-66
Scenario: Prevent multiple removals of the same product
Given the user is logged into the application
And the user navigates to the shopping cart page
And at least one product is added to the cart
When the user attempts to remove a product multiple times
Then the system prevents multiple removals
And maintains cart integrity
@TC-66
Scenario: Remove all products from the cart
Given the user is logged into the application
And the user navigates to the shopping cart page
And multiple products are added to the cart
When the user removes all products from the cart
Then the cart is empty
And a message indicates no items in the cart
@TC-66
Scenario: Cart persistence after logout and re-login
Given the user is logged into the application
And the user navigates to the shopping cart page
And multiple products are added to the cart
When the user removes products from the cart
And logs out and logs back in
Then the cart remains empty after re-login
@TC-66
Scenario: Remove one product from a cart with multiple products
Given the user is logged into the application
And the user navigates to the shopping cart page
And multiple products are added to the cart
When the user removes one product from the cart
Then only the selected product is removed
And others remain in the cart
@TC-66
Scenario: Cart icon updates with correct item count after product removal
Given the user is logged into the application
And the user navigates to the shopping cart page
And multiple products are added to the cart
When the user removes a product from the cart
Then the cart icon displays the correct number of items
@TC-66
Scenario: Attempt to remove a product when not logged in
Given the user is not logged into the application
When the user tries to remove a product from the cart
Then the user is prompted to log in before removing products from the cart
@TC-66
Scenario: Remove a product with a special promotion applied
Given the user is logged into the application
And the user navigates to the shopping cart page
And a product with a special promotion is added to the cart
When the user removes the promotional product from the cart
Then the promotional product is removed successfully
And promotions are recalculated
@TC-66
Scenario: Remove bundled products from the cart
Given the user is logged into the application
And the user navigates to the shopping cart page
And bundled products are added to the cart
When the user removes a bundled product from the cart
Then the system permits removal of bundled products
@TC-66
Scenario: Undo product removal
Given the user is logged into the application
And the user navigates to the shopping cart page
And at least one product is added to the cart
When the user removes a product from the cart
And undoes the removal
Then the product is restored to the cart
@TC-66
Scenario: Verify system logs product removal action
Given the user is logged into the application
And the user navigates to the shopping cart page
And at least one product is added to the cart
When the user removes a product from the cart
Then the system logs the removal action for auditing purposes