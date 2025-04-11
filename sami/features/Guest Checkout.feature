Feature: Guest Checkout
""
In order to purchase items without creating an account
As a guest user
I want to be able to complete the checkout process
""
Scenario: Successful guest checkout
Given I have items in my shopping cart
When I proceed to checkout
And I select the option to checkout as a guest
And I enter my shipping and payment information
And I review my order
And I confirm the order
Then I should see a confirmation message
And I should receive an order confirmation email
""
Scenario: Guest checkout with invalid payment information
Given I have items in my shopping cart
When I proceed to checkout
And I select the option to checkout as a guest
And I enter my shipping information
And I enter invalid payment information
And I attempt to confirm the order
Then I should see an error message indicating payment failure
""
Scenario: Guest checkout with missing shipping information
Given I have items in my shopping cart
When I proceed to checkout
And I select the option to checkout as a guest
And I leave the shipping information blank
And I attempt to confirm the order
Then I should see an error message indicating missing shipping information
""
Scenario: Guest checkout with invalid email format
Given I have items in my shopping cart
When I proceed to checkout
And I select the option to checkout as a guest
And I enter an invalid email format
And I attempt to confirm the order
Then I should see an error message indicating invalid email format
""
Scenario: Guest checkout with optional account creation
Given I have items in my shopping cart
When I proceed to checkout
And I select the option to checkout as a guest
And I enter my shipping and payment information
And I choose to create an account with the provided information
And I confirm the order
Then I should see a confirmation message
And I should receive an order confirmation email
And I should receive an account creation confirmation email
```
```gherkin
TCID:3