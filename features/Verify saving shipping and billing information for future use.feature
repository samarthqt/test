Feature: Verify saving shipping and billing information for future use
@TC-269
Scenario: Save shipping and billing information
Given the user is logged into their account
When the user navigates to the user account settings
Then the user account settings page is displayed
When the user clicks on the 'Addresses' section
Then the addresses section is opened
When the user enters shipping address details as "123 Example St, City, Country"
And the user enters billing address details as "456 Sample Ave, City, Country"
And the user clicks the 'Save' button
Then the shipping and billing information is saved successfully
@TC-269
Scenario: Verify saved shipping and billing information
Given the user is logged into their account
When the user logs out and logs back into the user account
And the user navigates to the user account settings again
Then the user account settings page is displayed
And the saved shipping and billing information is displayed correctly
@TC-269
Scenario: Make a purchase using saved billing information
Given the user is logged into their account
When the user attempts to make a purchase using the saved billing information
Then the purchase is completed successfully using saved billing information
@TC-269
Scenario: Edit saved shipping information
Given the user is logged into their account
When the user checks if there is an option to edit saved information
Then the option to edit saved information is available
When the user edits the saved shipping information and saves changes
Then the edited shipping information is saved successfully
@TC-269
Scenario: Verify edited shipping information
Given the user is logged into their account
When the user navigates to the user account settings again
Then the changes to shipping information are reflected correctly
@TC-269
Scenario: Make a purchase using edited shipping information
Given the user is logged into their account
When the user attempts a purchase using the edited shipping information
Then the purchase is completed successfully using edited shipping information
@TC-269
Scenario: Delete saved shipping information
Given the user is logged into their account
When the user checks if there is an option to delete the saved information
Then the option to delete saved information is available
When the user deletes the saved shipping information and confirms deletion
Then the shipping information is deleted successfully