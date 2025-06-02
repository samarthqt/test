Feature: Verify ability to enter new shipping and billing addresses
@TC-164
Scenario: Enter new shipping and billing addresses
Given a user account is logged in
When the user navigates to the checkout page
Then the checkout page is displayed with options to enter shipping and billing addresses
@TC-164
Scenario: Add new shipping address
Given the user is on the checkout page
When the user clicks on 'Add New Address' for shipping
Then a form to enter new shipping address is displayed
@TC-164
Scenario: Enter shipping address details
Given the shipping address form is displayed
When the user enters shipping address details "123 New Street, New City, NY"
And enters phone number "123-456-7890"
Then the shipping address details are entered correctly
@TC-164
Scenario: Add new billing address
Given the user has entered shipping address details
When the user clicks on 'Add New Address' for billing
Then a form to enter new billing address is displayed
@TC-164
Scenario: Enter billing address details
Given the billing address form is displayed
When the user enters billing address details "456 Old Street, Old City, NY"
And enters email "user@example.com"
Then billing address details are entered correctly
@TC-164
Scenario: Save new addresses
Given the user has entered shipping and billing address details
When the user clicks 'Save' to store the new addresses
Then addresses are saved successfully without errors
@TC-164
Scenario: Verify saved addresses appear in the address list
Given the addresses are saved successfully
When the user views the list of saved addresses
Then newly entered addresses appear in the list of saved addresses
@TC-164
Scenario: Proceed to checkout using the new addresses
Given the newly entered addresses are saved
When the user proceeds to checkout using the new addresses
Then checkout process continues using the newly entered addresses
@TC-164
Scenario: Verify confirmation of address usage
Given the checkout process continues using the new addresses
When the checkout is confirmed
Then a confirmation message is displayed indicating the use of new addresses
@TC-164
Scenario: Check for error messages during address entry
Given the user is entering addresses
When the addresses are entered
Then no error messages are displayed; addresses are accepted
@TC-164
Scenario: Ensure address format is correct and validated
Given the user is entering addresses
When the addresses are entered
Then address format is validated and correct
@TC-164
Scenario: Verify address fields for required information
Given the user is entering addresses
When the addresses are entered
Then all required fields are populated correctly
@TC-164
Scenario: Test address entry with different valid formats
Given the user is entering addresses
When addresses in different valid formats are entered
Then addresses in different valid formats are accepted
@TC-164
Scenario: Validate entry of international addresses
Given the user is entering addresses
When international addresses are entered
Then international addresses are entered and accepted correctly