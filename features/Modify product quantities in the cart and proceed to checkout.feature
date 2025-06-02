Feature: Modify product quantities in the cart and proceed to checkout
@TC-303
Scenario: User can successfully modify product quantities in the cart and proceed to checkout
Given the user is logged into the shopping platform
And products are added to the cart
When the user navigates to the cart page
Then the cart page is displayed with all added products
@TC-303
Scenario: Modify the quantity of 'Product A' from '1' to '2'
Given 'Product A' is in the cart with quantity '1'
When the user modifies the quantity of 'Product A' to '2'
Then the quantity for 'Product A' is updated to '2'
And the subtotal reflects the change
@TC-303
Scenario: Modify the quantity of 'Product B' from '2' to '1'
Given 'Product B' is in the cart with quantity '2'
When the user modifies the quantity of 'Product B' to '1'
Then the quantity for 'Product B' is updated to '1'
And the subtotal reflects the change
@TC-303
Scenario: Modify the quantity of 'Product C' from '3' to '4'
Given 'Product C' is in the cart with quantity '3'
When the user modifies the quantity of 'Product C' to '4'
Then the quantity for 'Product C' is updated to '4'
And the subtotal reflects the change
@TC-303
Scenario: Verify the total amount in the cart is updated correctly
When the user reviews the cart
Then the total amount reflects the updated quantities and subtotals
@TC-303
Scenario: Proceed to checkout
When the user clicks on the 'Proceed to Checkout' button
Then the user is directed to the checkout page successfully
@TC-303
Scenario: Verify cart items on the checkout page
When the user is on the checkout page
Then all cart items and their quantities are displayed correctly
@TC-303
Scenario: Enter valid shipping information
When the user enters valid shipping information on the checkout page
Then the shipping information is accepted and saved successfully
@TC-303
Scenario: Select payment method and enter payment details
When the user selects a payment method and enters valid payment details
Then the payment details are accepted and ready for processing
@TC-303
Scenario: Confirm purchase
When the user clicks on the 'Confirm Purchase' button
Then the purchase is confirmed and an order confirmation message is displayed
@TC-303
Scenario: Verify order confirmation email is received
When the purchase is confirmed
Then the order confirmation email is received with all order details
@TC-303
Scenario: Check order history for the recorded order
When the user checks the order history
Then the order appears in the order history with correct details
@TC-303
Scenario: Verify order remains in history after logout and login
When the user logs out and logs back in
Then the order is still present in the order history
@TC-303
Scenario: Attempt to modify the order after checkout
When the user attempts to modify the order after checkout
Then the system does not allow modifications and prompts a message
@TC-303
Scenario: Verify system's response time during checkout
When the user proceeds through the checkout process
Then the system responds quickly and efficiently