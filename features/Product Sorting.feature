Feature: Product Sorting
Scenario: Sort products by price in ascending order
Given a list of products displayed on the website
When the user selects the option to sort by price in ascending order
Then the products should be displayed in ascending order of their prices
Scenario: Sort products by price in descending order
Given a list of products displayed on the website
When the user selects the option to sort by price in descending order
Then the products should be displayed in descending order of their prices
Scenario: Sort products by popularity
Given a list of products displayed on the website
When the user selects the option to sort by popularity
Then the products should be displayed in order of their popularity
Scenario: Sort products by rating in ascending order
Given a list of products displayed on the website
When the user selects the option to sort by rating in ascending order
Then the products should be displayed in ascending order of their ratings
Scenario: Sort products by rating in descending order
Given a list of products displayed on the website
When the user selects the option to sort by rating in descending order
Then the products should be displayed in descending order of their ratings
Scenario: Verify default sorting order
Given a list of products displayed on the website
When the user does not select any sorting option
Then the products should be displayed in the default sorting order
Scenario: Validate sorting options availability
Given a list of products displayed on the website
When the user views the sorting options
Then the options to sort by price, popularity, and rating should be available