Feature: Limited Stock Warning
""
As a user managing product inventory,
I want to receive a warning when stock is running low,
So that I can take appropriate action to replenish the stock.
""
Background:
Given the product inventory system is operational
""
Scenario: Display warning when stock is below the threshold
Given a product with a stock threshold set to 10 units
And the current stock level is 8 units
When the inventory system checks the stock level
Then a warning message should be displayed indicating the stock is low
""
Scenario: Do not display warning when stock is above the threshold
Given a product with a stock threshold set to 10 units
And the current stock level is 15 units
When the inventory system checks the stock level
Then no warning message should be displayed
""
Scenario: Display warning when stock is exactly at the threshold
Given a product with a stock threshold set to 10 units
And the current stock level is 10 units
When the inventory system checks the stock level
Then a warning message should be displayed indicating the stock is low
""
Scenario: Update stock and remove warning
Given a product with a stock threshold set to 10 units
And the current stock level is 8 units
And a warning message is displayed
When the stock level is updated to 12 units
Then the warning message should be removed
""
Scenario: Multiple products with varying stock levels
Given products with the following stock thresholds and current stock levels:
| Product ID | Threshold | Current Stock |
| 1          | 10        | 8             |
| 2          | 20        | 25            |
| 3          | 5         | 5             |
When the inventory system checks the stock levels
Then a warning message should be displayed for Product ID 1 indicating the stock is low
And no warning message should be displayed for Product ID 2
And a warning message should be displayed for Product ID 3 indicating the stock is low
```
```gherkin
TCID:46