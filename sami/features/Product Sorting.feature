Feature: Product Sorting
""
As a user,
I want to sort products by price, popularity, or rating,
So that I can easily find the products I'm interested in.
""
Scenario: Sort products by price in ascending order
Given I am on the product listing page
"    When I select ""Price"" from the sort options"
"    And I choose ""Ascending"" order"
Then the products should be displayed sorted by price in ascending order
""
Scenario: Sort products by price in descending order
Given I am on the product listing page
"    When I select ""Price"" from the sort options"
"    And I choose ""Descending"" order"
Then the products should be displayed sorted by price in descending order
""
Scenario: Sort products by popularity in ascending order
Given I am on the product listing page
"    When I select ""Popularity"" from the sort options"
"    And I choose ""Ascending"" order"
Then the products should be displayed sorted by popularity in ascending order
""
Scenario: Sort products by popularity in descending order
Given I am on the product listing page
"    When I select ""Popularity"" from the sort options"
"    And I choose ""Descending"" order"
Then the products should be displayed sorted by popularity in descending order
""
Scenario: Sort products by rating in ascending order
Given I am on the product listing page
"    When I select ""Rating"" from the sort options"
"    And I choose ""Ascending"" order"
Then the products should be displayed sorted by rating in ascending order
""
Scenario: Sort products by rating in descending order
Given I am on the product listing page
"    When I select ""Rating"" from the sort options"
"    And I choose ""Descending"" order"
Then the products should be displayed sorted by rating in descending order
```
```gherkin
TCID:30