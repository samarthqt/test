Feature: Verify Multiple Payment Methods Selection During Checkout
@TC-168
Scenario: Verify the presence of multiple payment methods during checkout
Given User is logged into the application
And User has items in the shopping cart
When User navigates to the shopping cart page
Then Shopping cart page is displayed with items listed
And Payment methods available are Credit Card, PayPal, Gift Card
@TC-168
Scenario Outline: Select and process payment using different methods
Given User clicks on the 'Proceed to Checkout' button
Then Checkout page is displayed with payment options
When User selects "<Payment Method>" as the payment method
And User enters valid <Payment Method> details
And User clicks on 'Pay Now' button
Then Payment is processed successfully using <Payment Method>
And Confirmation message is displayed
Examples:
| Payment Method |
| Credit Card    |
| PayPal         |
| Gift Card      |
@TC-168
Scenario: Verify order summary and payment details
Given Payment is processed successfully
When User verifies the order summary and payment details
Then Order summary and payment details are accurate and correspond to the selected payment method
@TC-168
Scenario: Log out from the user account
Given User has completed the checkout process
When User logs out from the user account
Then User is logged out successfully