Feature: Verify product search using keyword and filter results by category
@TC-332
Scenario: Ensure the product search functionality works correctly using keywords and category filters
Given the product database is populated
When I navigate to the product search page
Then the product search page is displayed
And I understand category filters available
@TC-332
Scenario: Search for products using a keyword
Given I am on the product search page
When I enter the keyword 'laptop' in the search bar
Then the keyword is entered successfully
@TC-332
Scenario: Apply category filter to search results
Given I have entered a keyword in the search bar
When I select 'Electronics' from the category filter
Then the category filter is applied
@TC-332
Scenario: Initiate the search process
Given I have selected a category filter
When I click on the 'Search' button
Then the search process is initiated
@TC-332
Scenario: Display search results
Given the search process is initiated
When I check if the search results are displayed
Then search results are displayed
@TC-332
Scenario: Verify category of search results
Given search results are displayed
When I verify that all search results belong to the 'Electronics' category
Then all results are from the 'Electronics' category
@TC-332
Scenario: Check relevance of search results
Given search results are displayed
When I check the relevance of search results to the keyword 'laptop'
Then results are relevant to the keyword 'laptop'
@TC-332
Scenario: Sort search results by price
Given search results are displayed
When I sort the search results by price
Then search results are sorted by price
@TC-332
Scenario: Verify sorting order
Given search results are sorted by price
When I verify the sorting order is correct
Then sorting order is correct
@TC-332
Scenario: Filter search results by rating
Given search results are displayed
When I filter the search results by rating
Then rating filter is applied
@TC-332
Scenario: Check results filtered by rating
Given rating filter is applied
When I check if the search results are filtered by rating
Then results are filtered by rating
@TC-332
Scenario: Verify number of results matches filters
Given search results are filtered
When I verify the number of results matches the applied filters
Then number of results matches filters
@TC-332
Scenario: Add product to cart
Given search results are displayed
When I add a product from the search results to the cart
Then product is added to the cart
@TC-332
Scenario: Check cart for added product
Given product is added to the cart
When I check the cart for the added product
Then cart displays the added product
@TC-332
Scenario: Log out from the application
Given I have checked the cart for the added product
When I log out from the application
Then user is logged out successfully