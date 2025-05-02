Feature: Product Search
In order to quickly find desired items
As a user
I want to search for products by name or category
Scenario: Search for a product by name
Given I am on the homepage
When I enter the product name "Laptop" in the search bar
And I click on the search button
Then I should see a list of products related to "Laptop"
Scenario: Search for a product by category
Given I am on the homepage
When I select the category "Electronics" from the category dropdown
And I click on the search button
Then I should see a list of products under the "Electronics" category
Scenario: Search for a non-existing product
Given I am on the homepage
When I enter the product name "XYZ123" in the search bar
And I click on the search button
Then I should see a message "No products found"
Scenario: Search with an empty search bar
Given I am on the homepage
When I leave the search bar empty
And I click on the search button
Then I should see a message "Please enter a search term"
Scenario: Search by partial product name
Given I am on the homepage
When I enter the partial product name "Lap" in the search bar
And I click on the search button
Then I should see a list of products that include "Lap" in their name
Scenario: Search with special characters
Given I am on the homepage
When I enter special characters "!@#$%" in the search bar
And I click on the search button
Then I should see a message "No products found"