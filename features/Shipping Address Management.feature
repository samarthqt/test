Feature: Shipping Address Management
Scenario: Add a new shipping address
Given a user is logged into their account
When the user navigates to the shipping address section
And the user selects the option to add a new address
And the user enters valid address details
Then the new shipping address is saved successfully
And the user receives a confirmation message
Scenario: Store multiple shipping addresses
Given a user is logged into their account
When the user navigates to the shipping address section
And the user adds multiple addresses
Then all the addresses are stored successfully
And the user can view all saved addresses
Scenario: Select a shipping address during checkout
Given a user has multiple shipping addresses saved
When the user proceeds to checkout
Then the user is presented with a list of saved shipping addresses
And the user can select one of the saved addresses for shipping
Scenario: Edit an existing shipping address
Given a user is logged into their account
And the user has at least one shipping address saved
When the user navigates to the shipping address section
And the user selects an address to edit
And the user updates the address details
Then the changes are saved successfully
And the user receives a confirmation message
Scenario: Delete a shipping address
Given a user is logged into their account
And the user has multiple shipping addresses saved
When the user navigates to the shipping address section
And the user selects an address to delete
Then the address is removed from the list of saved addresses
And the user receives a confirmation message