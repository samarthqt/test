Feature: Shipping Options
""
As a customer, I want to be able to choose from various shipping options during checkout based on delivery speed and location, so that I can select the most suitable option for my needs.
""
Background:
Given I am on the checkout page
""
Scenario Outline: Display shipping options based on delivery speed and location
"    When I enter my delivery location as ""<location>"""
Then I should see the following shipping options:
| Option Name         | Delivery Speed | Availability |
| Standard Shipping   | 5-7 days       | Yes          |
| Expedited Shipping  | 2-3 days       | Yes          |
| Overnight Shipping  | 1 day          | Yes          |
And the options should be sorted by delivery speed
""
Examples:
| location    |
| New York    |
| California  |
| Texas       |
""
Scenario: Select a shipping option
"    Given I have entered my delivery location as ""New York"""
"    When I choose ""Expedited Shipping"""
"    Then the selected shipping option should be ""Expedited Shipping"""
And the estimated delivery date should be updated accordingly
""
Scenario: Verify unavailable shipping options
"    Given I have entered my delivery location as ""Remote Island"""
"    Then I should see a message indicating ""Overnight Shipping is not available for your location"""
And I should only see the following available options:
| Option Name         | Delivery Speed |
| Standard Shipping   | 5-7 days       |
| Expedited Shipping  | 2-3 days       |
""
Scenario: Validate shipping cost calculation
"    Given I have entered my delivery location as ""California"""
"    When I choose ""Standard Shipping"""
Then the shipping cost should be calculated based on the selected option
And the total cost should reflect the added shipping cost
""
Scenario: Ensure default selection of shipping option
"    Given I have entered my delivery location as ""Texas"""
When I proceed to checkout without selecting a shipping option
"    Then ""Standard Shipping"" should be selected by default"
```
```gherkin
TCID:22