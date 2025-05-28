Feature: Guest Checkout
TCID:5
""
As a user, I want to be able to purchase items without creating an account, so that I can have a faster and more convenient shopping experience.
""
Scenario: Successful guest checkout with valid details
Given a user has items in their shopping cart
When the user opts to checkout as a guest
And the user provides valid shipping and payment information
Then the purchase should be completed successfully
And the user should receive a confirmation message
""
Scenario: Guest checkout with missing shipping information
Given a user has items in their shopping cart
When the user opts to checkout as a guest
And the user provides incomplete shipping information
Then the purchase should not be completed
And the user should be prompted to provide the missing shipping information
""
Scenario: Guest checkout with invalid payment information
Given a user has items in their shopping cart
When the user opts to checkout as a guest
And the user provides invalid payment information
Then the purchase should not be completed
And the user should be notified of the payment error
""
Scenario: Guest checkout with an empty cart
Given a user has an empty shopping cart
When the user attempts to checkout as a guest
Then the user should not be able to proceed with the checkout
And the user should be prompted to add items to the cart
""
Scenario: Guest checkout with special promotions
Given a user has items eligible for a special promotion in their shopping cart
When the user opts to checkout as a guest
And the user provides valid shipping and payment information
Then the purchase should be completed successfully
And the special promotion should be applied to the purchase
""
Scenario: Guest checkout with optional account creation
Given a user has items in their shopping cart
When the user opts to checkout as a guest
And the user completes the purchase
Then the user should be offered an option to create an account for future convenience
And the user can choose to create an account or continue as a guest
```gherkin
TCID:6