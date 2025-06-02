Feature: Verify browsing products by category and search by keyword
@TC-1
Scenario: Browse products by category
Given the user is logged into the application
When the user navigates to the homepage of the retail application
Then the homepage is displayed with navigation options
And product categories are defined
When the user clicks on the 'Categories' dropdown menu
Then the dropdown menu expands showing available product categories
When the user selects the 'Electronics' category from the dropdown
Then the product listing page displays products under the 'Electronics' category
@TC-1
Scenario Outline: Search products by keyword
Given the user is on the homepage of the retail application
When the user enters "<keyword>" in the search bar and presses enter
Then search results display products related to "<keyword>"
And all displayed products are relevant to the search keyword
Examples:
| keyword      |
| Smartphone   |
| Laptop       |
| Camera       |
| Headphones   |
@TC-1
Scenario: Verify pagination of search results
Given the user has searched for a keyword resulting in multiple pages of results
Then pagination controls allow navigation between pages of search results
@TC-1
Scenario: Verify filtering options on search results page
Given the user is on the search results page
Then filtering options are visible
And the user can apply filtering options to narrow down search results
@TC-1
Scenario: Verify sorting options on search results page
Given the user is on the search results page
Then sorting options are visible
And the user can apply sorting options to reorder search results
@TC-1
Scenario: Verify product details display on search results page
Given the user is on the search results page
Then product details such as name, price, and rating are correctly displayed for each item
@TC-1
Scenario: Redirect to product detail page
Given the user is on the search results page
When the user clicks on a product
Then the user is redirected to the product detail page with full product information
@TC-1
Scenario: Verify search bar accessibility
Given the user is on any page within the application
Then the search bar is visible
And the search bar can be used from any page within the application
@TC-1
Scenario: Return to homepage from search results page
Given the user is on the search results page
When the user uses the home button or logo
Then the user can navigate back to the homepage