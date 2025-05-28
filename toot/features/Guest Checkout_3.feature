Feature: Guest Checkout
""
As a user,
I want to purchase items without creating an account,
So that I can complete my purchase quickly and easily.
""
Background:
Given the online store is open
And the user is on the shopping cart page with items added
""
Scenario: Successful guest checkout
Given the user opts for guest checkout
When the user enters valid shipping information
And the user enters valid payment information
And the user reviews the order summary
Then the user should be able to place the order successfully
And the user receives an order confirmation with details
""
Scenario: Guest checkout with invalid shipping information
Given the user opts for guest checkout
When the user enters invalid shipping information
Then the user should see an error message for invalid shipping details
And the user should not be able to proceed to payment
""
Scenario: Guest checkout with invalid payment information
Given the user opts for guest checkout
And the user enters valid shipping information
When the user enters invalid payment information
Then the user should see an error message for invalid payment details
And the user should not be able to place the order
""
Scenario: Guest checkout with missing mandatory fields
Given the user opts for guest checkout
When the user leaves mandatory fields empty
Then the user should see an error message indicating the required fields
And the user should not be able to proceed to the next step
""
Scenario: Guest checkout with optional fields
Given the user opts for guest checkout
When the user fills in only the mandatory fields
Then the user should be able to proceed with the checkout
And the user should not be prompted to fill optional fields
""
Scenario: Guest checkout with promotional code
Given the user opts for guest checkout
And the user enters a valid promotional code
When the user reviews the order summary
Then the discount should be applied to the order total
And the user should see the updated order total
""
Scenario: Guest checkout with expired promotional code
Given the user opts for guest checkout
And the user enters an expired promotional code
When the user reviews the order summary
Then the user should see an error message for the expired code
And the order total should not reflect any discount
```
```gherkin
TCID:65