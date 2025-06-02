Feature: Verify saving entered information for future purchases
@TC-165
Scenario: Navigate to the checkout page
Given the user account is logged in
When the user navigates to the checkout page
Then the checkout page is displayed with options to enter shipping and billing addresses
@TC-165
Scenario: Enter new shipping and billing address details
Given the user is on the checkout page
When the user enters new shipping address "789 Future Lane, Future City, FC High 33"
And the user enters billing address "321 Past Lane, Past City, PC"
Then the shipping and billing address details are entered correctly
@TC-165
Scenario: Enter phone number and email address
Given the user has entered shipping and billing addresses
When the user enters phone number "987-654-3210"
And the user enters email address "futureuser@example.com"
Then the phone number and email are entered correctly
@TC-165
Scenario: Save entered information for future use
Given the user has entered contact details
When the user clicks 'Save for Future' to store the information
Then the information is saved successfully without errors
@TC-165
Scenario: Verify saved information in account settings
Given the user has saved information for future use
When the user navigates to account settings
Then the newly entered information appears in the list of saved addresses and contact details
@TC-165
Scenario: Verify information persistence across sessions
Given the user has saved information
When the user logs out and logs back in
Then the saved information persists across sessions
@TC-165
Scenario: Attempt new purchase using saved information
Given the user has saved information
When the user attempts a new purchase
Then the checkout process uses saved information without requiring re-entry
@TC-165
Scenario: Verify confirmation of saved information usage
Given the user has used saved information for a purchase
When the user completes the checkout process
Then a confirmation message is displayed indicating the use of saved information
@TC-165
Scenario: Check for error messages during information saving
Given the user attempts to save information
When the user clicks 'Save for Future'
Then no error messages are displayed and information is saved successfully
@TC-165
Scenario: Ensure saved information can be edited
Given the user has saved information
When the user edits the saved information
Then the saved information can be edited and updated correctly
@TC-165
Scenario: Validate entry of international addresses for saving
Given the user is on the checkout page
When the user enters international address details
Then international addresses are entered, saved, and accepted correctly
@TC-165
Scenario: Test saving information with different valid formats
Given the user is on the checkout page
When the user enters information in different valid formats
Then information in different valid formats is saved correctly
@TC-165
Scenario: Verify deletion of saved information
Given the user has saved information
When the user deletes the saved information
Then the saved information can be deleted successfully
@TC-165
Scenario: Ensure saved information is used in future transactions
Given the user has saved information
When the user makes a future transaction
Then the saved information is automatically used in future transactions
@TC-165
Scenario: Test saving multiple addresses for future use
Given the user is on the checkout page
When the user saves multiple addresses
Then multiple addresses can be saved and selected for future transactions