Feature: Multiple Currencies
""
As a user, I want to view prices in multiple currencies to have a better understanding of the cost in my preferred currency.
""
Background:
Given the user is on the product page
""
Scenario Outline: Viewing prices in different currencies
"    When the user selects ""<currency>"" from the currency dropdown"
"    Then the prices should be displayed in ""<currency>"""
""
Examples:
| currency |
| USD      |
| EUR      |
| GBP      |
| JPY      |
| AUD      |
""
Scenario: Default currency display
Given the user is on the product page
When the page is loaded
Then the prices should be displayed in the default currency
""
Scenario: Currency selection persistence
"    Given the user selects ""EUR"" from the currency dropdown"
When the user navigates to another product page
"    Then the prices should still be displayed in ""EUR"""
""
Scenario: Invalid currency selection
When the user selects an invalid currency from the currency dropdown
Then an error message should be displayed indicating the currency is not supported
""
Scenario: Currency conversion accuracy
"    Given the user selects ""JPY"" from the currency dropdown"
When the prices are displayed
Then the conversion rate should be accurate according to the latest exchange rate
""
Scenario: Currency selection reset
"    Given the user selects ""GBP"" from the currency dropdown"
When the user logs out and logs back in
Then the prices should be displayed in the default currency
```
```gherkin
TCID:40