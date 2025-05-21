Feature: Checkout Without Login
""
As a guest user,
I want to be able to checkout without logging in
So that I can complete my purchase quickly and easily
""
Scenario: Guest user checks out without logging in
Given I am a guest user on the website
And I have added items to my shopping cart
When I proceed to the checkout page
Then I should be able to enter my shipping details
And I should be able to enter my payment information
And I should be able to review my order
And I should be able to place the order without logging in
""
Scenario: Guest user attempts to checkout with empty cart
Given I am a guest user on the website
And my shopping cart is empty
When I proceed to the checkout page
Then I should see a message indicating that my cart is empty
And I should not be able to proceed with the checkout
""
Scenario: Guest user enters invalid shipping details
Given I am a guest user on the checkout page
And I have entered invalid shipping details
When I attempt to proceed with the checkout
Then I should see an error message indicating invalid shipping details
And I should be prompted to correct the shipping details
""
Scenario: Guest user enters invalid payment information
Given I am a guest user on the checkout page
And I have entered invalid payment information
When I attempt to proceed with the checkout
Then I should see an error message indicating invalid payment information
And I should be prompted to correct the payment information
""
Scenario: Guest user reviews order before placing
Given I am a guest user on the checkout page
And I have entered valid shipping and payment information
When I review my order
Then I should see a summary of my order details
And I should see the total cost including any taxes and shipping fees
And I should see an option to edit my order before placing it
```gherkin
TCID:50