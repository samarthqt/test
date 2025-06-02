Feature: Support for Multiple Address Formats for International Users
@TC-167
Scenario: Verify support for multiple address formats for international users
Given the user account is logged in
When the user navigates to the checkout page
Then the checkout page is displayed with options to enter shipping and billing addresses
@TC-167
Scenario: Enter international address details for shipping
Given the user is on the checkout page
When the user enters international address details for shipping as "12 Rue de Rivoli, Paris, France"
Then the international address details are entered correctly
@TC-167
Scenario: Enter international address details for billing
Given the user is on the checkout page
When the user enters international address details for billing as "1 Infinite Loop, Cupertino, CA, USA"
Then the international address details are entered correctly
@TC-167
Scenario: Verify system acceptance of different address formats
Given the user is on the checkout page
When the user enters various international address formats
Then the system accepts multiple address formats without errors
@TC-167
Scenario: Test address entry with non-standard formats
Given the user is on the checkout page
When the user enters a non-standard address format as "1-2-3 Nanjing Rd, Shanghai, China"
Then the system accepts non-standard formats and validates correctly
@TC-167
Scenario: Ensure address fields accommodate international formats
Given the user is on the checkout page
When the user enters an international address
Then the address fields accommodate and display international formats correctly
@TC-167
Scenario: Verify system validation for international postal codes
Given the user is on the checkout page
When the user enters international postal codes
Then the system validates and accepts international postal codes correctly
@TC-167
Scenario: Test system support for special characters in international addresses
Given the user is on the checkout page
When the user enters an international address with special characters
Then the system accepts special characters in international addresses without errors
@TC-167
Scenario: Validate system response to incomplete international address entry
Given the user is on the checkout page
When the user enters an incomplete international address
Then the system prompts the user to complete the address entry before proceeding
@TC-167
Scenario: Verify system behavior for international address changes
Given the user is on the checkout page
When the user changes international address formats
Then the system allows changes and updates to international address formats
@TC-167
Scenario: Test system integration for international address validation services
Given the user is on the checkout page
When the system integrates with validation services
Then the system accepts validated addresses
@TC-167
Scenario: Ensure international addresses are saved for future use
Given the user is on the checkout page
When the user saves an international address
Then the international addresses can be saved and used in future transactions
@TC-167
Scenario: Verify system support for multiple languages in address entry
Given the user is on the checkout page
When the user enters address details in different languages
Then the system supports multiple languages and accepts address entry in different languages
@TC-167
Scenario: Test system feedback for unsupported international address formats
Given the user is on the checkout page
When the user enters an unsupported international address format
Then the system provides feedback and error messages for unsupported formats
@TC-167
Scenario: Validate system response to address format changes in user profile
Given the user is in their profile settings
When the user changes the address format
Then the system updates and accepts address format changes in user profile