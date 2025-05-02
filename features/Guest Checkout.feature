Feature: Guest Checkout
Scenario: Guest user adds items to the cart
Given a guest user is browsing the online store
When the guest user selects an item to purchase
Then the item should be added to the cart
Scenario: Guest user proceeds to checkout
Given a guest user has items in the cart
When the guest user clicks on the checkout button
Then the guest user should be directed to the checkout page
Scenario: Guest user enters shipping information
Given a guest user is on the checkout page
When the guest user enters valid shipping information
Then the shipping information should be accepted
Scenario: Guest user enters payment information
Given a guest user has entered shipping information
When the guest user enters valid payment information
Then the payment information should be accepted
Scenario: Guest user reviews order summary
Given a guest user has entered payment information
When the guest user reviews the order summary
Then the order summary should display the correct items and total cost
Scenario: Guest user completes the purchase
Given a guest user has reviewed the order summary
When the guest user confirms the purchase
Then the purchase should be completed successfully
Scenario: Guest user receives order confirmation
Given the purchase is completed
Then the guest user should receive an order confirmation via email
Scenario: Guest user is offered account creation
Given a guest user has completed the purchase
When the guest user views the order confirmation page
Then the guest user should be offered the option to create an account for future purchases