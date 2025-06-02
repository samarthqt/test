Feature: Verify product filtering by category
@TC-59
Scenario: Verify filtering by 'Electronics' category
Given the product listing page is displayed
When I select the category 'Electronics' from the filter options
And I apply the filter
Then the system displays products under 'Electronics' category
And the filtered results include only 'Electronics' products
@TC-59
Scenario: Verify filtering by 'Home Appliances' category
Given the product listing page is displayed
When I select the category 'Home Appliances' from the filter options
And I apply the filter
Then the system displays products under 'Home Appliances' category
@TC-59
Scenario: Verify filtering by 'Fashion' category
Given the product listing page is displayed
When I select the category 'Fashion' from the filter options
And I apply the filter
Then the system displays products under 'Fashion' category
@TC-59
Scenario: Verify filtering by 'Books' category
Given the product listing page is displayed
When I select the category 'Books' from the filter options
And I apply the filter
Then the system displays products under 'Books' category
@TC-59
Scenario: Verify filtering by 'Sports Equipment' category
Given the product listing page is displayed
When I select the category 'Sports Equipment' from the filter options
And I apply the filter
Then the system displays products under 'Sports Equipment' category
@TC-59
Scenario: Verify filter performance and speed
Given the product listing page is displayed
When I apply any category filter
Then the filtered results are displayed within acceptable time
@TC-59
Scenario: Check system logs for filtering actions
Given the product listing page is displayed
When I apply any category filter
Then logs reflect all filtering actions and outcomes
@TC-59
Scenario: Attempt filtering with a category not present in the catalog
Given the product listing page is displayed
When I attempt to filter by a non-existent category
Then the system displays no results found message
@TC-59
Scenario: Verify filter combination with other criteria
Given the product listing page is displayed
When I apply category and price filters
Then the system allows combination of filters and displays accurate results
@TC-59
Scenario: Check filtering functionality on different devices
Given the product listing page is displayed on different devices
When I apply any category filter
Then filtering works consistently across devices
@TC-59
Scenario: Verify filter reset functionality
Given the product listing page is displayed
When I reset the filters
Then the system resets filters and displays all products
@TC-59
Scenario: Check accessibility of filter options
Given the product listing page is displayed
When I navigate to filter options
Then filter options are accessible and easy to navigate