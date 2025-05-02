Feature: Multiple Shipping Addresses
Scenario: User selects multiple shipping addresses for items in one order
Given the user is on the checkout page
When the user selects the option to ship items to multiple addresses
Then the user should be presented with a list of items in the order
And each item should have an option to select a shipping address
Scenario: User assigns different shipping addresses to items
Given the user has selected multiple shipping addresses option
When the user assigns different addresses to each item
Then each item should display the selected shipping address
Scenario: User saves the shipping address selection
Given the user has assigned different shipping addresses to items
When the user confirms the shipping address selection
Then the system should save the shipping address for each item
And the order summary should reflect the different shipping addresses
Scenario: User edits shipping addresses before finalizing the order
Given the user has saved the shipping address selection
When the user chooses to edit the shipping addresses
Then the user should be able to change the shipping addresses for items
And the changes should be reflected in the order summary
Scenario: User completes the order with multiple shipping addresses
Given the user has finalized the shipping addresses
When the user completes the order process
Then the order confirmation should list all items with their respective shipping addresses
And the user should receive a confirmation email with the shipping details for each item