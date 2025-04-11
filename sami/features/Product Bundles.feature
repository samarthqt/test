Feature: Product Bundles
""
As a customer, I want to be able to purchase discounted product bundles so that I can save money on my purchases.
""
Background:
Given I am a registered customer
And I am logged into the e-commerce platform
""
Scenario: Create a discounted product bundle
"    Given I navigate to the ""Product Bundles"" section"
When I select multiple products to create a bundle
And I apply a discount to the bundle
Then I should see the total price of the bundle reflecting the discount
And the bundle should be added to my cart
""
Scenario: View available product bundles
"    Given I navigate to the ""Product Bundles"" section"
When I browse through the available bundles
Then I should see a list of product bundles with their respective discounts
""
Scenario: Edit a product bundle
Given I have a product bundle in my cart
When I choose to edit the bundle
And I add or remove products from the bundle
And I update the discount if necessary
Then the updated product bundle should reflect the changes
And the new total price should be displayed
""
Scenario: Delete a product bundle from the cart
Given I have a product bundle in my cart
When I choose to remove the bundle from my cart
Then the product bundle should no longer appear in my cart
""
Scenario: Purchase a product bundle
Given I have a discounted product bundle in my cart
When I proceed to checkout
And I complete the payment process
Then I should receive a confirmation of my purchase
And the product bundle should be marked as purchased
```
```gherkin
TCID:60