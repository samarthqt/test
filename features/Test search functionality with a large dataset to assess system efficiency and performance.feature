Feature: Test search functionality with a large dataset to assess system efficiency and performance
@TC-337
Scenario: Evaluate search functionality's efficiency and performance with a large dataset
Given the product database is populated with a large dataset
When I navigate to the product search page
Then the product search page is displayed
@TC-337
Scenario: Enter keyword 'electronics' in the search bar
Given I am on the product search page
When I enter the keyword 'electronics' in the search bar
Then the keyword is entered successfully
@TC-337
Scenario: Apply category, price, and rating filters
Given I have entered the keyword 'electronics'
When I select 'All Categories' from the category filter
Then the category filter is applied
When I apply the price filter for 'All Prices'
Then the price filter is applied
When I apply the rating filter for 'All Ratings'
Then the rating filter is applied
@TC-337
Scenario: Initiate search and verify results
Given I have applied all necessary filters
When I click on the 'Search' button
Then the search process is initiated
And the search results are displayed
@TC-337
Scenario: Measure search result display time
Given the search results are displayed
When I measure the time taken to display search results
Then the search results are displayed within acceptable time limits
@TC-337
Scenario: Verify relevance of search results
Given the search results are displayed
When I verify the relevance of search results to the keyword 'electronics'
Then the results are relevant to the keyword 'electronics'
@TC-337
Scenario: Sort and verify search results by price
Given the search results are displayed
When I sort the search results by price
Then the search results are sorted by price
And the sorting order is correct
@TC-337
Scenario: Filter and verify search results by rating
Given the search results are displayed
When I filter the search results by rating
Then the rating filter is applied
And the results are filtered by rating
@TC-337
Scenario: Verify number of results matches applied filters
Given the search results are filtered by rating
When I verify the number of results matches the applied filters
Then the number of results matches filters
@TC-337
Scenario: Add product to cart and verify
Given I have search results displayed
When I add a product from the search results to the cart
Then the product is added to the cart
And the cart displays the added product
@TC-337
Scenario: Log out from the application
Given I have added a product to the cart
When I log out from the application
Then the user is logged out successfully
@TC-337
Scenario: Ensure system performance stability
Given I am using the search functionality
When I perform multiple search operations
Then the system performance remains stable