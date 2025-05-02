Feature: Shipping Options
Scenario: User selects shipping option based on delivery speed
Given the user is on the checkout page
When the user is presented with shipping options
Then the user should see options for different delivery speeds
And the user selects a shipping option based on preferred delivery speed
And the selected shipping option should be displayed in the order summary
Scenario: User selects shipping option based on location
Given the user is on the checkout page
When the user enters their delivery location
Then the user should see shipping options available for their location
And the user selects a shipping option based on preferred delivery location
And the selected shipping option should be displayed in the order summary
Scenario: User reviews shipping options before finalizing order
Given the user has selected items to purchase
When the user proceeds to checkout
Then the user should see a list of available shipping options
And the user reviews the shipping options based on delivery speed and location
And the user selects the most suitable shipping option
And the selected shipping option should be confirmed in the order summary
Scenario: User changes shipping option after initial selection
Given the user has initially selected a shipping option
When the user decides to change the shipping option
Then the user should be able to view all available shipping options again
And the user selects a new shipping option
And the updated shipping option should be displayed in the order summary
Scenario: User sees shipping cost associated with each option
Given the user is on the shipping options page
When the user reviews the available shipping options
Then the user should see the cost associated with each shipping option
And the user selects a shipping option based on cost preference
And the selected shipping option cost should be displayed in the order summary