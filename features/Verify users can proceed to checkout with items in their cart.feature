Feature: Verify users can proceed to checkout with items in their cart
@TC-4
Scenario: User can proceed to checkout with items in their shopping cart
Given the user is logged into the application
When the user navigates to the shopping cart page
Then the shopping cart page displays items added to the cart
@TC-4
Scenario: Verify items in the cart are correctly listed
Given items are added to the shopping cart
Then all items in the cart should be listed with correct name, price, quantity, and subtotal
@TC-4
Scenario: User can proceed to checkout
When the user clicks on the 'Proceed to Checkout' button
Then the user is redirected to the checkout page
@TC-4
Scenario: Enter valid shipping information
When the user enters valid shipping information
Then the shipping information is accepted and saved
@TC-4
Scenario: Enter valid billing information
When the user enters valid billing information
Then the billing information is accepted and saved
@TC-4
Scenario: Select and accept a payment method
When the user selects a payment method
Then the payment method is selected and accepted
@TC-4
Scenario: Review order summary
When the user reviews the order summary
Then the order summary displays correct items, quantities, prices, and totals
@TC-4
Scenario: Place the order
When the user clicks on the 'Place Order' button
Then the order is successfully placed and a confirmation message is displayed
@TC-4
Scenario: Verify confirmation email is sent
Then a confirmation email is received with order details
@TC-4
Scenario: Check order in user's order history
Then the order appears in the order history with correct details
@TC-4
Scenario: Track order status from dashboard
Then the order status is visible and can be tracked from the dashboard
@TC-4
Scenario: Verify shopping cart is emptied after order placement
Then the shopping cart is empty and ready for new items
@TC-4
Scenario: Return to homepage from checkout page
When the user navigates back to the homepage
Then the user can return using the home button or logo
@TC-4
Scenario: Ensure checkout process is secure
Then the checkout process is secure and uses encryption protocols
@TC-4
Scenario: Add new items to the cart after checkout
When the user adds new items to the cart
Then the user can add new items without issues