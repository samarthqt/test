Feature: Product Filters
""
As a user, I want to be able to filter search results based on various criteria such as price and rating, so that I can easily find the products that meet my needs.
""
Background:
Given the user is on the product search results page
""
@high
Scenario: Filter search results by price
When the user selects a price range filter
Then the search results should only display products within the selected price range
""
@high
Scenario: Filter search results by rating
When the user selects a rating filter
Then the search results should only display products with the selected rating or higher
""
@high
Scenario: Filter search results by multiple criteria
When the user selects both price and rating filters
Then the search results should only display products that meet both the selected price range and rating criteria
""
@high
Scenario: Clear filters
Given the user has applied one or more filters
When the user clears all filters
Then the search results should display all products without any applied filters
""
@high
Scenario: Apply and modify filters
Given the user has applied a price filter
When the user modifies the price filter to a different range
Then the search results should update to display products within the new price range
```