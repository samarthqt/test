Feature: Cart Notifications
""
As a user, I want to be notified when the total price of items in my cart exceeds a certain threshold so that I can make informed purchasing decisions.
""
Background:
Given the user is logged into the e-commerce platform
And the user has items in their cart
""
Scenario Outline: User receives notification when cart exceeds price threshold
"    Given the price threshold is set to ""<threshold>"""
"    And the current total price of items in the cart is ""<current_total>"""
"    When the user adds an item with price ""<item_price>"""
Then the user should receive a notification that their cart has exceeded the threshold
""
Examples:
| threshold | current_total | item_price |
| 100       | 90            | 20         |
| 150       | 140           | 15         |
| 200       | 180           | 25         |
""
Scenario: User does not receive notification when cart is below price threshold
"    Given the price threshold is set to ""100"""
"    And the current total price of items in the cart is ""80"""
"    When the user adds an item with price ""10"""
Then the user should not receive a notification
""
Scenario: User receives notification only once when cart exceeds price threshold
"    Given the price threshold is set to ""100"""
"    And the current total price of items in the cart is ""90"""
"    When the user adds an item with price ""15"""
"    And the user adds another item with price ""10"""
Then the user should receive only one notification that their cart has exceeded the threshold
""
Scenario: User receives notification when removing items causes cart to exceed threshold
"    Given the price threshold is set to ""100"""
"    And the current total price of items in the cart is ""110"""
"    When the user removes an item with price ""20"""
Then the user should receive a notification that their cart is now below the threshold
```
```gherkin
TCID:31