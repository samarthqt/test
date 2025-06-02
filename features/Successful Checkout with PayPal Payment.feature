Feature: Successful Checkout with PayPal Payment
@TC-339
Scenario: Verify successful checkout process using PayPal payment
Given User is logged in
And User has a valid PayPal account
And Products are available in the cart
When User navigates to the cart page
Then Cart page is displayed with selected products
@TC-339
Scenario: Verify products listed in the cart
Given Products are available in the cart
When User verifies the products listed in the cart
Then Products in the cart match the selected items
@TC-339
Scenario: Proceed to checkout
Given User is on the cart page
When User clicks on 'Proceed to Checkout' button
Then Checkout page is displayed
@TC-339
Scenario: Select PayPal as the payment method
Given User is on the checkout page
When User selects 'PayPal' as the payment method
Then PayPal payment section is displayed
@TC-339
Scenario: Log in to PayPal account
Given User is on the PayPal payment section
When User logs in to PayPal account
Then PayPal login is successful
@TC-339
Scenario: Confirm payment in PayPal
Given User is logged in to PayPal
When User confirms the payment in PayPal
Then Payment is confirmed through PayPal
@TC-339
Scenario: Return to merchant site
Given Payment is confirmed through PayPal
When User returns to the merchant site
Then Redirected back to merchant site with confirmation
@TC-339
Scenario: Verify order confirmation message
Given User is redirected back to merchant site
When User verifies the order confirmation message
Then Order confirmation message is displayed with order details
@TC-339
Scenario: Check order summary in user account
Given Order confirmation message is displayed
When User checks the order summary in the user account
Then Order summary matches the transaction details
@TC-339
Scenario: Verify payment transaction in PayPal account
Given Payment is confirmed through PayPal
When User verifies the payment transaction in PayPal account
Then Transaction is recorded and successful in PayPal
@TC-339
Scenario: Check email for order confirmation
Given Order confirmation message is displayed
When User checks email for order confirmation
Then Order confirmation email is received with correct details
@TC-339
Scenario: Verify order status in user dashboard
Given Order confirmation message is displayed
When User verifies the order status in the user dashboard
Then Order status is displayed as 'Processing' or 'Completed'
@TC-339
Scenario: Check delivery address details in order summary
Given Order confirmation message is displayed
When User checks the delivery address details in the order summary
Then Correct delivery address is displayed
@TC-339
Scenario: Verify loyalty points or discounts applied
Given Order confirmation message is displayed
When User verifies if the loyalty points or discounts were applied correctly
Then Loyalty points/discounts are correctly applied to the order
@TC-339
Scenario: Ensure 'Print Receipt' option is available
Given Order confirmation message is displayed
When User ensures the 'Print Receipt' option is available
Then 'Print Receipt' option is available and functional