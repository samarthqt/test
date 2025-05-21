Feature: Display of Discounted Price alongside Original Price
""
As a user, I want to see the discounted price displayed alongside the original price
so that I can easily understand the discount being offered on a product.
""
Background:
Given I am on the product pricing page
""
Scenario: Display discounted price for a product with a discount
"    Given a product has an original price of ""$100"""
"    And the product has a discount of ""20%"""
When I view the product pricing details
"    Then I should see the original price displayed as ""$100"""
"    And I should see the discounted price displayed as ""$80"""
""
Scenario: Display original price for a product without a discount
"    Given a product has an original price of ""$100"""
And the product has no discount
When I view the product pricing details
"    Then I should see the original price displayed as ""$100"""
And I should not see any discounted price displayed
""
Scenario: Display discounted price for multiple products
Given the following products exist:
| Product Name | Original Price | Discount |
| Product A    | $200           | 10%      |
| Product B    | $150           | 15%      |
When I view the product pricing details
"    Then I should see the original price for ""Product A"" displayed as ""$200"""
"    And I should see the discounted price for ""Product A"" displayed as ""$180"""
"    And I should see the original price for ""Product B"" displayed as ""$150"""
"    And I should see the discounted price for ""Product B"" displayed as ""$127.50"""
""
Scenario: Validate discounted price calculation
"    Given a product has an original price of ""$120"""
"    And the product has a discount of ""25%"""
When I calculate the discounted price
"    Then the discounted price should be calculated as ""$90"""
""
Scenario: Display message for invalid discount
"    Given a product has an original price of ""$100"""
"    And the product has an invalid discount of ""-10%"""
When I view the product pricing details
"    Then I should see a message indicating ""Invalid discount value"""
```gherkin
TCID:39