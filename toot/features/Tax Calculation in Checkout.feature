Feature: Tax Calculation in Checkout
""
As a user, I want the system to automatically calculate taxes based on my location during the checkout process, so that I can see the accurate total amount I need to pay.
""
Background:
Given the user is on the checkout page
""
Scenario Outline: Calculate tax based on user location
"    When the user enters their location as ""<location>"""
"    Then the system should calculate the tax based on ""<location>"""
"    And the calculated tax should be ""<expected_tax>"""
""
Examples:
| location      | expected_tax |
| New York      | $8.00        |
| California    | $7.25        |
| Texas         | $6.25        |
| Florida       | $6.00        |
""
Scenario: Verify tax calculation for a known location
"    Given the user enters their location as ""New York"""
When the system calculates the tax
"    Then the calculated tax should be ""$8.00"""
""
Scenario: Verify tax calculation updates when location changes
"    Given the user initially enters their location as ""California"""
"    And the system calculates the tax as ""$7.25"""
"    When the user changes their location to ""Texas"""
"    Then the system should recalculate the tax as ""$6.25"""
""
Scenario: Verify tax calculation for an unsupported location
"    Given the user enters their location as ""Alaska"""
When the system calculates the tax
"    Then the system should display an error message ""Tax calculation not available for this location"""
""
Scenario: Verify tax calculation for an empty location field
Given the user does not enter any location
When the system attempts to calculate the tax
"    Then the system should display an error message ""Location is required for tax calculation"""
```
```gherkin
TCID:28