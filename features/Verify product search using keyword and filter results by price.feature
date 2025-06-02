Feature: Verify product search using keyword and filter results by price
@TC-333
Scenario: Ensure the product search functionality works correctly using keywords and price filters
Given the product database is populated
When I navigate to the product search page
Then the product search page is displayed
@TC-333
Scenario: Enter keyword 'smartphone' in the search bar
Given I am on the product search page
When I enter the keyword 'smartphone' in the search bar
Then the keyword is entered successfully
@TC-333
Scenario: Apply the price filter for the range '$200-$500'
Given the keyword 'smartphone' is entered
When I apply the price filter for the range '$200-$500'
Then the price filter is applied
@TC-333
Scenario: Initiate the search process
Given the price filter is applied
When I click on the 'Search' button
Then the search process is initiated
@TC-333
Scenario: Display search results
Given the search process is initiated
Then the search results are displayed
@TC-333
Scenario: Verify all search results fall within the price range '$200-$500'
Given the search results are displayed
Then all results are within the specified price range
@TC-333
Scenario: Check relevance of search results to the keyword 'smartphone'
Given the search results are displayed
Then results are relevant to the keyword 'smartphone'
@TC-333
Scenario: Sort search results by category
Given the search results are displayed
When I sort the search results by category
Then the search results are sorted by category
@TC-333
Scenario: Verify the sorting order is correct
Given the search results are sorted by category
Then the sorting order is correct
@TC-333
Scenario: Filter search results by rating
Given the search results are displayed
When I filter the search results by rating
Then the rating filter is applied
@TC-333
Scenario: Check if search results are filtered by rating
Given the rating filter is applied
Then results are filtered by rating
@TC-333
Scenario: Verify the number of results matches the applied filters
Given the results are filtered by rating
Then the number of results matches filters
@TC-333
Scenario: Add a product from the search results to the cart
Given the search results are displayed
When I add a product from the search results to the cart
Then the product is added to the cart
@TC-333
Scenario: Check the cart for the added product
Given the product is added to the cart
When I check the cart
Then the cart displays the added product
@TC-333
Scenario: Log out from the application
Given the cart displays the added product
When I log out from the application
Then the user is logged out successfully