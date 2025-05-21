Feature: Price Comparison
""
As a user, I want to be able to compare similar products so that I can make informed purchasing decisions.
""
Scenario: Compare two similar products
Given I am on the product comparison page
When I select two similar products to compare
Then I should see a side-by-side comparison of the products' features
And I should see the price difference between the two products
""
Scenario: Compare multiple similar products
Given I am on the product comparison page
When I select multiple similar products to compare
Then I should see a side-by-side comparison of the products' features
And I should see the price differences among the selected products
""
Scenario: No products selected for comparison
Given I am on the product comparison page
When I do not select any products to compare
Then I should see a message indicating that no products have been selected for comparison
""
Scenario: Compare products with different attributes
Given I am on the product comparison page
When I select products with different attributes to compare
Then I should see a side-by-side comparison of the products' features
And I should see the attributes that are not comparable highlighted or noted
""
Scenario: Compare products with similar prices
Given I am on the product comparison page
When I select products with similar prices to compare
Then I should see a side-by-side comparison of the products' features
And I should see a message indicating that the prices are similar
""
Scenario: View detailed product information
Given I am on the product comparison page
When I select a product from the comparison list
Then I should be able to view detailed information about the selected product
""
Scenario: Reset product comparison selection
Given I have selected products for comparison
When I choose to reset the comparison selection
Then all selected products should be deselected
And the comparison page should be reset to its initial state
```gherkin
TCID:38