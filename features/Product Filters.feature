Feature: Product Filters
Scenario: Filter search results by price
Given the user is on the search results page
When the user selects a price range filter
Then the search results should only display products within the selected price range
Scenario: Filter search results by rating
Given the user is on the search results page
When the user selects a rating filter
Then the search results should only display products with the selected rating or higher
Scenario: Filter search results by multiple criteria
Given the user is on the search results page
When the user selects multiple filters such as price and rating
Then the search results should only display products that match all selected criteria
Scenario: Clear all applied filters
Given the user has applied filters on the search results page
When the user clicks on the clear filters option
Then all filters should be removed and the search results should display all products
Scenario: Verify filter options are visible
Given the user is on the search results page
Then the user should see filter options for price, rating, and other criteria
Scenario: Apply and verify filter by other criteria
Given the user is on the search results page
When the user selects a filter by a specific criterion (e.g., brand, category)
Then the search results should only display products that match the selected criterion