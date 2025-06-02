Feature: Product Browsing and Search Functionality During Peak Traffic
@TC-3
Scenario: Simulate peak traffic conditions on the retail application
Given the system is under peak traffic load
When I navigate to the homepage of the retail application
Then the homepage is displayed with navigation options
@TC-3
Scenario: Browse products by category during peak traffic
Given the homepage is displayed
When I click on the 'Categories' dropdown menu
Then the dropdown menu expands showing available product categories
When I select the 'Fashion' category from the dropdown
Then the product listing page displays products under the 'Fashion' category
@TC-3
Scenario Outline: Search for products during peak traffic
Given the product listing page is displayed
When I enter "<keyword>" in the search bar and press enter
Then search results display products related to "<keyword>"
Examples:
| keyword     |
| Shoes       |
| Dresses     |
| Accessories |
| Bags        |
@TC-3
Scenario: Verify system performance during peak traffic
Given the system is under peak traffic load
When I browse and search for products
Then the system maintains acceptable response times for browsing and searching
@TC-3
Scenario: Check system stability during peak traffic
Given the system is under peak traffic load
When I perform various operations
Then the system remains stable and does not crash or slow down excessively
@TC-3
Scenario: Verify pagination and filtering options during peak traffic
Given the product listing page is displayed
When I use pagination and filtering options
Then pagination and filtering options work correctly without delays
@TC-3
Scenario: Verify product details display during peak traffic
Given the search results are displayed
Then product details such as name, price, and rating are correctly displayed for each item
@TC-3
Scenario: Redirect to product detail page during peak traffic
Given the search results are displayed
When I click on a product
Then I am redirected to the product detail page promptly
@TC-3
Scenario: Ensure search bar functionality during peak traffic
Given the system is under peak traffic load
Then the search bar is visible and can be used from any page within the application
@TC-3
Scenario: Navigate back to homepage from search results during peak traffic
Given the search results page is displayed
When I choose to return to the homepage
Then I can navigate back to the homepage promptly