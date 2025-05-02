Feature: Save Payment Information
Scenario: User saves payment information successfully
Given the user is logged into their account
And the user is on the checkout page
When the user enters valid payment information
And the user chooses to save the payment information for future purchases
And the user submits the payment information
Then the payment information is saved securely
And a confirmation message is displayed to the user
Scenario: User chooses not to save payment information
Given the user is logged into their account
And the user is on the checkout page
When the user enters valid payment information
And the user chooses not to save the payment information
And the user submits the payment information
Then the payment information is not saved
And the transaction is completed successfully
Scenario: User attempts to save invalid payment information
Given the user is logged into their account
And the user is on the checkout page
When the user enters invalid payment information
And the user chooses to save the payment information for future purchases
And the user submits the payment information
Then an error message is displayed indicating the payment information is invalid
And the payment information is not saved
Scenario: User views saved payment information
Given the user is logged into their account
And the user has previously saved payment information
When the user navigates to the payment information section of their account
Then the saved payment information is displayed securely
And the user can edit or delete the payment information
Scenario: User deletes saved payment information
Given the user is logged into their account
And the user has previously saved payment information
When the user navigates to the payment information section of their account
And the user chooses to delete the saved payment information
Then the payment information is removed from the account
And a confirmation message is displayed to the user
Scenario: User edits saved payment information
Given the user is logged into their account
And the user has previously saved payment information
When the user navigates to the payment information section of their account
And the user edits the saved payment information
And the user submits the updated payment information
Then the payment information is updated securely
And a confirmation message is displayed to the user