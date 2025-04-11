Feature: Guest Checkout
""
As a user,
I want to be able to purchase items without creating an account,
So that I can complete my purchase quickly and easily as a guest.
""
Background:
Given the user is on the e-commerce website
And the shopping cart contains items
""
Scenario: Successful guest checkout
"    Given the user selects ""Checkout as Guest"""
When the user enters valid shipping information
And the user enters valid payment information
And the user reviews the order summary
And the user confirms the purchase
Then the user should see a confirmation message
And the order should be placed successfully
""
Scenario: Guest checkout with invalid shipping information
"    Given the user selects ""Checkout as Guest"""
When the user enters invalid shipping information
Then the user should see an error message indicating invalid shipping information
And the user should be prompted to correct the shipping information
""
Scenario: Guest checkout with invalid payment information
"    Given the user selects ""Checkout as Guest"""
When the user enters valid shipping information
And the user enters invalid payment information
Then the user should see an error message indicating invalid payment information
And the user should be prompted to correct the payment information
""
Scenario: Guest checkout with missing information
"    Given the user selects ""Checkout as Guest"""
When the user leaves required fields empty
Then the user should see an error message indicating missing information
And the user should be prompted to complete the required fields
""
Scenario: Cancel guest checkout
"    Given the user selects ""Checkout as Guest"""
When the user decides to cancel the checkout process
Then the user should be redirected back to the shopping cart
And the items should still be in the shopping cart
""
Scenario: Guest checkout with promotional code
"    Given the user selects ""Checkout as Guest"""
When the user enters a valid promotional code
And the user enters valid shipping and payment information
And the user confirms the purchase
Then the discount should be applied to the order total
And the user should see a confirmation message
And the order should be placed successfully
```
```gherkin
TCID:68