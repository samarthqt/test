Feature: Verify system feedback for invalid entered information
@TC-166
Scenario: Navigate to the checkout page
Given the user account is logged in
When the user navigates to the checkout page
Then the checkout page is displayed with options to enter shipping and billing addresses
@TC-166
Scenario: Enter invalid shipping and billing address details
Given the user is on the checkout page
When the user enters invalid shipping address "!@# Invalid Lane, Invalid City, IC High 33"
And the user enters invalid billing address "1234"
Then the system displays error messages indicating invalid address format
@TC-166
Scenario: Enter invalid phone number and email address
Given the user is on the checkout page
When the user enters invalid phone number "ABCDEFGHIJ"
And the user enters invalid email "user@invalid"
Then the system displays error messages indicating invalid phone number and email format
@TC-166
Scenario: Attempt to save invalid information
Given the user has entered invalid information on the checkout page
When the user attempts to save the invalid information
Then the system prevents saving and displays error feedback
@TC-166
Scenario: Verify error message content and clarity
Given the system has displayed error messages for invalid information
Then the error messages are clear and informative, guiding users to correct the information
@TC-166
Scenario: Correct the invalid information and attempt to save again
Given the user has corrected the invalid information
When the user attempts to save the corrected information
Then the system accepts corrected information and saves successfully
@TC-166
Scenario: Test system response to incomplete address entry
Given the user is on the checkout page
When the user enters incomplete address information
Then the system prompts the user to complete the address entry before proceeding
@TC-166
Scenario: Verify system feedback on invalid international address formats
Given the user is on the checkout page
When the user enters invalid international address formats
Then the system provides feedback and error messages for invalid international address formats
@TC-166
Scenario: Attempt to use invalid information for checkout
Given the user has entered invalid information on the checkout page
When the user attempts to checkout
Then the system prevents checkout and displays error messages for invalid information
@TC-166
Scenario: Check system behavior for invalid characters in address fields
Given the user is on the checkout page
When the user enters invalid characters in address fields
Then the system flags invalid characters and prevents saving
@TC-166
Scenario: Verify system response to invalid email formats
Given the user is on the checkout page
When the user enters invalid email formats
Then the system displays error messages for invalid email formats
@TC-166
Scenario: Validate error handling for invalid phone number formats
Given the user is on the checkout page
When the user enters invalid phone number formats
Then the system displays error messages for invalid phone number formats
@TC-166
Scenario: Test system feedback for missing required fields
Given the user is on the checkout page
When the user leaves required fields empty
Then the system prompts the user to fill in missing required fields
@TC-166
Scenario: Verify system response to invalid postal codes
Given the user is on the checkout page
When the user enters invalid postal codes
Then the system displays error messages for invalid postal codes
@TC-166
Scenario: Ensure system prevents saving of invalid information
Given the user has entered invalid information on the checkout page
When the user attempts to save the invalid information
Then the system prevents saving and prompts the user to correct invalid information