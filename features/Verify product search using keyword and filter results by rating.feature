Feature: Verify product search using keyword and filter results by rating
@TC-334
Scenario: Ensure the product search functionality works correctly using keywords and rating filters
Given the product database is populated
When I navigate to the product search page
Then the product search page should be displayed
@TC-334
Scenario: Enter keyword and apply rating filter
Given I am on the product search page
When I enter the keyword "headphones" in the search bar
Then the keyword should be entered successfully
When I apply the rating filter for "4 stars and above"
Then the rating filter should be applied
@TC-334
Scenario: Initiate search and verify results
Given the keyword and rating filter are applied
When I click on the "Search" button
Then the search process should be initiated
And the search results should be displayed
@TC-334
Scenario: Verify search results rating and relevance
Given the search results are displayed
Then all search results should have a rating of "4 stars and above"
And the results should be relevant to the keyword "headphones"
@TC-334
Scenario: Sort and filter search results
Given the search results are displayed
When I sort the search results by price
Then the search results should be sorted by price
And the sorting order should be correct
When I filter the search results by category
Then the category filter should be applied
And the results should be filtered by category
@TC-334
Scenario: Verify number of results and add product to cart
Given the search results are filtered by category
Then the number of results should match the applied filters
When I add a product from the search results to the cart
Then the product should be added to the cart
@TC-334
Scenario: Verify added product in cart and log out
Given a product is added to the cart
When I check the cart for the added product
Then the cart should display the added product
When I log out from the application
Then the user should be logged out successfully