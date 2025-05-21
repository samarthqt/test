Feature: Product Bundles - Offer product bundles at a discounted price
""
Background:
Given the user is on the product bundles page
""
Scenario: Display available product bundles
When the user navigates to the product bundles section
Then the system should display a list of available product bundles
""
Scenario: Verify product bundle details
Given a list of available product bundles is displayed
When the user selects a product bundle
Then the system should display the details of the selected product bundle
And the details should include the original price, discounted price, and items included in the bundle
""
Scenario: Add product bundle to cart
Given a list of available product bundles is displayed
When the user selects a product bundle and adds it to the cart
Then the product bundle should be added to the cart
And the cart should display the discounted price of the product bundle
""
Scenario: Remove product bundle from cart
Given a product bundle is added to the cart
When the user removes the product bundle from the cart
Then the product bundle should be removed from the cart
And the cart should update to reflect the removal
""
Scenario: Checkout with product bundle
Given a product bundle is added to the cart
When the user proceeds to checkout
Then the checkout page should display the product bundle with the discounted price
And the total price should reflect the discount applied to the product bundle
""
Scenario: Validate discount applied correctly
Given a product bundle is added to the cart
When the user verifies the cart total
Then the total should correctly reflect the sum of the discounted prices of all product bundles in the cart
""
Scenario: Display message for no available product bundles
Given there are no product bundles available
When the user navigates to the product bundles section
Then the system should display a message indicating that no product bundles are currently available
```gherkin
TCID:51