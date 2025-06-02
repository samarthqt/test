Feature: Ensure filtering of products by category, price, and rating
@TC-110
Scenario: Verify filtering by category
Given the user is logged into the application
When the user navigates to the product catalog
Then the product catalog is displayed with filter options
When the user selects the 'Electronics' category filter
Then products related to the 'Electronics' category are displayed
And all displayed products belong to the 'Electronics' category
@TC-110
Scenario: Verify filtering by price range
Given the user is on the product catalog page
When the user applies a price filter of $100 - $500
Then products within the price range of $100 - $500 are displayed
And all displayed products are within the specified price range
@TC-110
Scenario: Verify filtering by rating
Given the user is on the product catalog page
When the user applies a rating filter of 4 stars and above
Then products with a rating of 4 stars and above are displayed
And all displayed products have a rating of 4 stars and above
@TC-110
Scenario: Verify combined filtering
Given the user is on the product catalog page
When the user combines category, price, and rating filters
Then products satisfying all selected filters are displayed
@TC-110
Scenario: Verify filter reset functionality
Given the user is on the product catalog page
When the user applies filters and then resets them
Then the filter reset functionality is available and works correctly
@TC-110
Scenario: Verify no products meet filter criteria
Given the user is on the product catalog page
When the user applies filters with no products meeting the criteria
Then an appropriate message is displayed when no products meet the filter criteria
@TC-110
Scenario: Verify performance and speed of applying filters
Given the user is on the product catalog page
When the user applies any filter
Then filters are applied promptly without delay
@TC-110
Scenario: Verify filter functionality on different devices
Given the user accesses the product catalog page on different devices
Then filter functionality is consistent across various devices and screen sizes
@TC-110
Scenario: Verify filter persistence after navigation
Given the user applies filters on the product catalog page
When the user navigates away and returns to the catalog
Then selected filters persist after navigation
@TC-110
Scenario: Verify accuracy of product count display
Given the user applies filters on the product catalog page
Then the product count accurately reflects the number of filtered products
@TC-110
Scenario: Verify applying multiple filters simultaneously
Given the user is on the product catalog page
When the user applies multiple filters simultaneously
Then multiple filters can be applied simultaneously without issue