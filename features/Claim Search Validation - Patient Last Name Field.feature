Feature: Claim Search Validation - Patient Last Name Field
@3
Scenario: User views the input field for Patient Last Name
Given the user navigates to the claim search page
Then the user sees an input field labeled "Patient Last Name"
@3
Scenario Outline: User enters values into the Patient Last Name field
Given the user navigates to the claim search page
When the user enters "<value>" into the "Patient Last Name" field
Then the system displays "<message>"
Examples:
| value          | message                                     |
| ""             | "Patient Last Name is required."           |
| "John"         | "Valid input accepted."                    |
| "John123"      | "Invalid input: Only alphabetical characters are allowed." |
| "John@Doe"     | "Invalid input: Only alphabetical characters are allowed." |
| "123"          | "Invalid input: Only alphabetical characters are allowed." |
@3
Scenario Outline: Validation of user input for special or numeric characters
Given the user navigates to the claim search page
When the user attempts to enter "<invalid_value>" into the "Patient Last Name" field
Then the system prevents the input and displays a validation error message
Examples:
| invalid_value | message                                     |
| "123"         | "Invalid input: Only alphabetical characters are allowed." |
| "@Doe"        | "Invalid input: Only alphabetical characters are allowed." |
| "John123"     | "Invalid input: Only alphabetical characters are allowed." |
@3
Scenario: User-friendly error message for blank input
Given the user navigates to the claim search page
When the user leaves the "Patient Last Name" field blank
Then the system displays the error message "Patient Last Name is required."