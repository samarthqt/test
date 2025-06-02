Feature: Test Filtering Functionality with Maximum Number of Filters Applied Simultaneously
@TC-112
Scenario: Verify filtering functionality with maximum filters applied
Given User is logged into the application
When User navigates to the product listing page
Then The product listing page is displayed with all available products
@TC-112
Scenario: Apply Category filter
Given User is on the product listing page
When User selects the 'Category' filter and chooses 'Electronics'
Then The product list is updated to show only electronics
@TC-112
Scenario: Apply Price Range filter
Given User has applied the 'Category' filter as 'Electronics'
When User selects the 'Price Range' filter and sets it to $100 to $500
Then The product list is further refined to show electronics within the $100 to $500 price range
@TC-112
Scenario: Apply Brand filter
Given User has applied the 'Price Range' filter as $100 to $500
When User selects the 'Brand' filter and chooses 'BrandX'
Then The product list is further refined to show BrandX electronics within the specified price range
@TC-112
Scenario: Apply Rating filter
Given User has applied the 'Brand' filter as 'BrandX'
When User selects the 'Rating' filter and sets it to 4 stars & up
Then The product list is further refined to show BrandX electronics with a rating of 4 stars and above, within the specified price range
@TC-112
Scenario: Apply Availability filter
Given User has applied the 'Rating' filter as 4 stars & up
When User selects the 'Availability' filter and chooses 'In Stock'
Then The product list is further refined to show BrandX electronics that are in stock, with a rating of 4 stars and above, within the specified price range
@TC-112
Scenario: Verify applied filters in filter summary
Given User has applied multiple filters
Then All applied filters are correctly displayed in the filter summary section
@TC-112
Scenario: Verify product count matches expected count
Given User has applied multiple filters
Then The number of products displayed matches the expected count based on the applied filters
@TC-112
Scenario: Remove a filter and verify product list updates
Given User has applied multiple filters
When User removes one of the filters
Then The product list updates to reflect the removal of the selected filter
@TC-112
Scenario: Reapply a removed filter and verify product list updates
Given User has removed a filter
When User reapplies the removed filter
Then The product list updates to reflect the reapplication of the filter
@TC-112
Scenario: Attempt to apply additional filter beyond maximum allowed
Given User has applied the maximum number of filters
When User attempts to apply an additional filter
Then The system does not allow the application of more filters beyond the maximum limit
@TC-112
Scenario: Verify filter reset option clears all applied filters
Given User has applied multiple filters
When User uses the filter reset option
Then All applied filters are cleared, and the full product list is displayed
@TC-112
Scenario: Verify system performance with multiple filters applied
Given User applies multiple filters simultaneously
Then The system performance remains optimal with no noticeable lag
@TC-112
Scenario: Check filter section responsiveness on different screen sizes
Given User accesses the filter section on different screen sizes
Then The filter section is responsive and user-friendly on different screen sizes
@TC-112
Scenario: Verify accuracy of filter criteria applied to product list
Given User has applied specific filter criteria
Then The product list accurately reflects the filter criteria applied