Feature: Verify product search by keyword
@TC-58
Scenario: Verify product search functionality using keyword 'Laptop'
Given the product catalog is populated with sample products
When I open the search page
Then the search page is displayed
When I enter the keyword 'Laptop' in the search bar
Then the search bar is populated with 'Laptop'
When I click the 'Search' button
Then the system displays search results for 'Laptop'
And the search results include products related to 'Laptop'
@TC-58
Scenario: Verify product search functionality using keyword 'Smartphone'
Given the product catalog is populated with sample products
When I enter the keyword 'Smartphone' in the search bar
Then the search bar is populated with 'Smartphone'
When I click the 'Search' button
Then the system displays search results for 'Smartphone'
And the search results include products related to 'Smartphone'
@TC-58
Scenario: Verify product search functionality using keyword 'Headphones'
Given the product catalog is populated with sample products
When I enter the keyword 'Headphones' in the search bar
Then the search bar is populated with 'Headphones'
When I click the 'Search' button
Then the system displays search results for 'Headphones'
And the search results include products related to 'Headphones'
@TC-58
Scenario: Verify product search functionality using keyword 'Camera'
Given the product catalog is populated with sample products
When I enter the keyword 'Camera' in the search bar
Then the search bar is populated with 'Camera'
When I click the 'Search' button
Then the system displays search results for 'Camera'
And the search results include products related to 'Camera'
@TC-58
Scenario: Verify product search functionality using keyword 'Tablet'
Given the product catalog is populated with sample products
When I enter the keyword 'Tablet' in the search bar
Then the search bar is populated with 'Tablet'
When I click the 'Search' button
Then the system displays search results for 'Tablet'
And the search results include products related to 'Tablet'
@TC-58
Scenario: Verify search results for accuracy
Given the product catalog is populated with sample products
When I perform a search using any keyword
Then the search results are accurate and relevant
@TC-58
Scenario: Verify search performance and speed
Given the product catalog is populated with sample products
When I perform a search using any keyword
Then the search results are displayed within acceptable time
@TC-58
Scenario: Check system logs for search queries
Given the product catalog is populated with sample products
When I perform a search using any keyword
Then the logs reflect all search queries and outcomes
@TC-58
Scenario: Attempt search with a keyword not present in the catalog
Given the product catalog is populated with sample products
When I enter a keyword not present in the catalog
Then the system displays no results found message
@TC-58
Scenario: Verify search results pagination
Given the product catalog is populated with sample products
When I perform a search using any keyword
Then the search results are paginated correctly
@TC-58
Scenario: Check search functionality on different devices
Given the product catalog is populated with sample products
When I perform a search using any keyword on different devices
Then the search works consistently across devices
@TC-58
Scenario: Verify search results sorting options
Given the product catalog is populated with sample products
When I perform a search using any keyword
Then the search results can be sorted by relevance, price, etc.