Feature: Search functionality with invalid keyword
@TC-336
Scenario: Perform a search with an invalid keyword and verify error handling for no results found
Given the product database is populated
And I navigate to the product search page
When I enter the invalid keyword "nonexistentproduct123" in the search bar
And I click on the "Search" button
Then the system displays an appropriate message for no results found
And no search results are displayed
@TC-336
Scenario: Apply filters to an invalid search
Given I have performed a search with the invalid keyword "nonexistentproduct123"
When I attempt to apply a category filter to the invalid search
Then the filter application does not change the no results message
When I attempt to apply a price filter to the invalid search
Then the filter application does not change the no results message
When I attempt to apply a rating filter to the invalid search
Then the filter application does not change the no results message
@TC-336
Scenario: Check system logs and search bar functionality after invalid search
Given I have performed a search with the invalid keyword "nonexistentproduct123"
When I check the system logs for any errors during the search
Then no errors are logged for the invalid keyword search
When I verify that the search bar allows re-entry of valid keywords
Then the search bar allows new keyword entry
@TC-336
Scenario: Perform a valid search and add product to cart
Given the search bar allows new keyword entry
When I enter a valid keyword and perform the search again
Then search results are displayed for the valid keyword
When I add a product from the valid search results to the cart
Then the product is added to the cart
When I check the cart for the added product
Then the cart displays the added product
@TC-336
Scenario: Log out and verify system performance
Given I have added a product to the cart
When I log out from the application
Then the user is logged out successfully
When I ensure system performance is unaffected by invalid searches
Then system performance remains stable