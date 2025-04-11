Feature: Add to Cart
""
As a user,
I want to add products to my shopping cart
So that I can purchase them later.
""
Scenario: Add a single product to the cart
Given I am on the product page
"    When I click on the ""Add to Cart"" button"
Then the product should be added to the shopping cart
"    And I should see a confirmation message ""Product added to your cart."""
""
Scenario: Add multiple products to the cart
"    Given I am on the product page of ""Product A"""
"    When I click on the ""Add to Cart"" button"
"    And I navigate to the product page of ""Product B"""
"    And I click on the ""Add to Cart"" button"
Then both products should be present in the shopping cart
"    And I should see a confirmation message ""Product added to your cart."""
""
Scenario: Add the same product multiple times
"    Given I am on the product page of ""Product A"""
"    When I click on the ""Add to Cart"" button"
"    And I click on the ""Add to Cart"" button again"
Then the product quantity in the shopping cart should be updated to 2
"    And I should see a confirmation message ""Product added to your cart."""
""
Scenario: Add a product to the cart when not logged in
Given I am not logged into the website
And I am on the product page
"    When I click on the ""Add to Cart"" button"
Then I should be prompted to log in or register
And the product should be added to the cart after successful login
""
Scenario: Add an out-of-stock product to the cart
Given I am on the product page of an out-of-stock product
"    When I click on the ""Add to Cart"" button"
"    Then I should see a message ""This product is currently out of stock."""
And the product should not be added to the shopping cart
```
```gherkin
TCID:7