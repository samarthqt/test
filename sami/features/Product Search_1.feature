Feature: Product Search
""
As a user, I want to be able to search for products by name or category so that I can easily find the products I am interested in.
""
Scenario: Search for products by name
Given the user is on the product search page
When the user enters a product name in the search bar
And clicks the search button
Then the system should display a list of products that match the entered name
""
Scenario: Search for products by category
Given the user is on the product search page
When the user selects a category from the category dropdown
And clicks the search button
Then the system should display a list of products that belong to the selected category
""
Scenario: Search with no results
Given the user is on the product search page
When the user enters a non-existent product name in the search bar
And clicks the search button
Then the system should display a message indicating no products were found
""
Scenario: Search with special characters
Given the user is on the product search page
When the user enters special characters in the search bar
And clicks the search button
Then the system should handle the input gracefully and display a message if no products are found
""
Scenario: Search with empty input
Given the user is on the product search page
When the user leaves the search bar empty
And clicks the search button
Then the system should prompt the user to enter a search term
""
Scenario: Search for products by partial name
Given the user is on the product search page
When the user enters a partial product name in the search bar
And clicks the search button
Then the system should display a list of products that match the partial name
""
Scenario: Search with case insensitive input
Given the user is on the product search page
When the user enters a product name in the search bar with different case
And clicks the search button
Then the system should display a list of products that match the entered name regardless of case
```
```gherkin
TCID:70