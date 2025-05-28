Feature: Add to Cart
""
As a user, I want to be able to add products to my shopping cart so that I can purchase them later.
""
Background:
Given I am a registered user
And I am logged into the e-commerce platform
And I have navigated to the product listing page
""
Scenario: Add a single product to the cart
Given I am viewing a product on the product details page
"    When I click on the ""Add to Cart"" button"
Then the product should be added to the shopping cart
And the cart icon should display the correct number of items
""
Scenario: Add multiple quantities of a single product to the cart
Given I am viewing a product on the product details page
"    When I select a quantity of ""3"""
"    And I click on the ""Add to Cart"" button"
Then three units of the product should be added to the shopping cart
And the cart icon should display the correct number of items
""
Scenario: Add different products to the cart
Given I am viewing the first product on the product details page
"    When I click on the ""Add to Cart"" button"
And I navigate to another product details page
"    And I click on the ""Add to Cart"" button"
Then both products should be added to the shopping cart
And the cart icon should display the correct number of items
""
Scenario: View cart with added products
Given I have added products to my shopping cart
When I click on the cart icon
Then I should be taken to the cart page
And I should see all the products I have added
And the total price should be correctly calculated
""
Scenario: Add to cart when not logged in
Given I am not logged into the e-commerce platform
When I try to add a product to the cart
Then I should be prompted to log in or register
""
Scenario: Verify product details in the cart
Given I have added a product to my shopping cart
When I view my cart
Then I should see the correct product name, price, and quantity
""
Scenario: Remove a product from the cart
Given I have added products to my shopping cart
When I choose to remove a product
Then the product should no longer appear in my cart
And the cart icon should update to reflect the correct number of items
```
```gherkin
TCID:66