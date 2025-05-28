Feature: Manage Shipping Addresses
""
As a user,
I want to add and store multiple shipping addresses,
So that I can easily select an address during checkout.
""
Background:
Given the user is logged into their account
"    And the user is on the ""Manage Shipping Addresses"" page"
""
Scenario: Add a new shipping address
"    When the user clicks on ""Add New Address"""
And the user enters a valid shipping address
And the user saves the new address
Then the new address should be added to the list of stored addresses
""
Scenario: Store multiple shipping addresses
Given the user has already stored one shipping address
"    When the user clicks on ""Add New Address"""
And the user enters another valid shipping address
And the user saves the new address
Then both addresses should be visible in the list of stored addresses
""
Scenario: Select a stored address during checkout
Given the user has multiple shipping addresses stored
When the user proceeds to checkout
And the user selects a stored shipping address
Then the selected address should be used for the order
""
Scenario: Edit an existing shipping address
Given the user has a stored shipping address
When the user selects an address to edit
And the user updates the address details
And the user saves the changes
Then the updated address should be reflected in the list of stored addresses
""
Scenario: Delete a stored shipping address
Given the user has multiple stored shipping addresses
When the user selects an address to delete
And the user confirms the deletion
Then the address should be removed from the list of stored addresses
And the remaining addresses should still be visible
""
Scenario: Attempt to add an invalid shipping address
"    When the user clicks on ""Add New Address"""
And the user enters an invalid shipping address
And the user attempts to save the new address
Then an error message should be displayed
And the invalid address should not be added to the list of stored addresses
```
```gherkin
TCID:24