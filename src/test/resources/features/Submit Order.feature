Feature: Submit Order
@WD-REQ-05
Scenario: User adds products to cart and proceeds to checkout
Given the user is on the product page
When the user adds a product to the cart
Then the product should be visible in the cart
@WD-REQ-05
Scenario: User enters information and completes order
Given the user has proceeded to checkout
When the user enters shipping information
And the user enters payment information
And the user submits the order
Then the user should see the "ThankYouOrder" page
@WD-REQ-05
Scenario: User sees "ThankYouOrder" page after order submission
Given the user has submitted the order
Then the user should see the "ThankYouOrder" page with order confirmation details