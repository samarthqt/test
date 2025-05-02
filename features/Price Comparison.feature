Feature: Price Comparison
In order to make informed purchase decisions
As a user
I want to compare similar products
Scenario: Compare two similar products
Given I am on the product listing page
When I select two similar products for comparison
Then I should see a comparison chart with product details including price, features, and specifications
Scenario: Compare more than two similar products
Given I am on the product listing page
When I select more than two similar products for comparison
Then I should see a comparison chart with all selected product details including price, features, and specifications
Scenario: Compare products with different categories
Given I am on the product listing page
When I select products from different categories for comparison
Then I should see a message indicating that only similar products can be compared
Scenario: Remove a product from comparison
Given I have a comparison chart with multiple products
When I remove a product from the comparison
Then the comparison chart should update to reflect the remaining products
Scenario: Add a product to an existing comparison
Given I have a comparison chart with some products
When I add another similar product to the comparison
Then the comparison chart should update to include the new product with all its details
Scenario: View detailed comparison of a specific feature
Given I have a comparison chart with multiple products
When I select a specific feature for detailed comparison
Then I should see a detailed view highlighting the differences of the selected feature across the products
Scenario: Access the comparison feature from a product page
Given I am on a specific product page
When I choose to compare the product with similar ones
Then I should be redirected to a comparison page with the selected product and similar options
Scenario: Save a comparison for future reference
Given I have a comparison chart with selected products
When I choose to save the comparison
Then the comparison should be saved under my account for future reference
Scenario: Share a product comparison
Given I have a comparison chart with selected products
When I choose to share the comparison
Then I should be able to share the comparison via email or social media platforms