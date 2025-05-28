Feature: Multiple Shipping Addresses
""
As a user, I want to be able to ship items to multiple addresses in one order so that I can send items to different locations in a single transaction.
""
Background:
Given the user is on the checkout page
""
Scenario: User selects multiple shipping addresses for different items
Given the user has items in the cart
When the user chooses to ship to multiple addresses
Then the user should see an option to select different addresses for each item
""
Scenario: User adds a new address during checkout
Given the user has items in the cart
And the user chooses to ship to multiple addresses
When the user adds a new shipping address
Then the new address should be available for selection in the address list
""
Scenario: User assigns different addresses to each item
Given the user has items in the cart
And the user has multiple addresses available
When the user assigns different addresses to each item in the order
Then each item should display the assigned address in the order summary
""
Scenario: User reviews order summary with multiple addresses
Given the user has assigned different addresses to items
When the user reviews the order summary
Then the order summary should display each item with its respective shipping address
""
Scenario: User completes checkout with multiple shipping addresses
Given the user has reviewed the order summary
When the user confirms the order
Then the order should be processed with items being shipped to their respective addresses
And the user should receive a confirmation email with details of each shipment
```
```gherkin
TCID:43