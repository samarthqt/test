Feature: Product Search
""
As a user,
I want to search for products by name or category
So that I can easily find the products I am looking for.
""
Scenario: Search for a product by name
Given I am on the product search page
"    When I enter ""Laptop"" in the search bar"
And I click on the search button
"    Then I should see a list of products with names containing ""Laptop"""
""
Scenario: Search for a product by category
Given I am on the product search page
"    When I select ""Electronics"" from the category dropdown"
And I click on the search button
"    Then I should see a list of products under the ""Electronics"" category"
""
Scenario: No products found for a given name
Given I am on the product search page
"    When I enter ""XYZ123"" in the search bar"
And I click on the search button
"    Then I should see a message ""No products found for your search"""
""
Scenario: No products found for a given category
Given I am on the product search page
"    When I select ""Toys"" from the category dropdown"
And I click on the search button
"    Then I should see a message ""No products found for your search"""
""
Scenario: Search with an empty search bar
Given I am on the product search page
When I leave the search bar empty
And I click on the search button
"    Then I should see a validation message ""Please enter a product name or select a category"""
""
Scenario: Search with special characters in the search bar
Given I am on the product search page
"    When I enter ""!@#$%^&*"" in the search bar"
And I click on the search button
"    Then I should see a message ""No products found for your search"""
```
```gherkin
TCID:8