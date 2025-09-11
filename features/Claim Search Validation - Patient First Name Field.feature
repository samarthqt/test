Feature: Claim Search Validation - Patient First Name Field
As a healthcare provider staff member,
I want to enter a valid Patient First Name in the claim search criteria
So that I can ensure proper validation and submission of the search
@2
Scenario: Verify the presence of the 'Patient First Name' input field
Given the user navigates to the claim search page
Then the user should see an input field labeled "Patient First Name"
@2
Scenario Outline: Validate acceptance of alphabetical characters in the 'Patient First Name' field
Given the user navigates to the claim search page
When the user enters "<inputValue>" into the 'Patient First Name' field
Then the system should accept the input value
Examples:
| inputValue   |
| John         |
| Mary         |
| Alice        |
@2
Scenario: Verify the 'Patient First Name' field is marked as required
Given the user navigates to the claim search page
When the user leaves the 'Patient First Name' field blank
And the user submits the claim search
Then the system should display an error message indicating that the field is required
@2
Scenario Outline: Validate error message for invalid values in the 'Patient First Name' field
Given the user navigates to the claim search page
When the user enters "<invalidValue>" into the 'Patient First Name' field
And the user submits the claim search
Then the system should display a validation error message indicating the issue
Examples:
| invalidValue |
| 123          |
| @John        |
| John123      |
| John!        |
@2
Scenario Outline: Prevent numeric or special characters in the 'Patient First Name' field
Given the user navigates to the claim search page
When the user attempts to enter "<invalidInput>" into the 'Patient First Name' field
Then the system should prevent the user from entering the input
Examples:
| invalidInput |
| 456          |
| #$%^         |
| John@        |
| 789John      |
@2
Scenario Outline: Validate user-friendly error messages
Given the user navigates to the claim search page
When the user enters "<invalidEntry>" into the 'Patient First Name' field
And the user submits the claim search
Then the system should display a user-friendly error message clearly indicating the issue
Examples:
| invalidEntry |
| 123          |
| !@#          |
| John123      |
| Alice@       |