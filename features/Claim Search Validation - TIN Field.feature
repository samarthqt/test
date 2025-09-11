Feature: Claim Search Validation - TIN Field
@1
Scenario Outline: Validate the TIN field for proper input and error handling
Given the user navigates to the claim search page
When the user enters "<TIN>" in the TIN field
Then the system should display "<ValidationMessage>"
Examples:
| TIN         | ValidationMessage                              |
| 123456789   | No error, valid TIN entered                    |
| 12345678    | "TIN must be exactly 9 digits"                 |
| abcdefghi   | "TIN must contain only numeric characters"     |
|             | "TIN field is required"                        |
@1
Scenario: Verify the TIN field is displayed and labeled correctly
Given the user navigates to the claim search page
Then the user should see an input field labeled "TIN"
@1
Scenario Outline: Prevent non-numeric characters in the TIN field
Given the user navigates to the claim search page
When the user attempts to enter "<InvalidCharacters>" in the TIN field
Then the system should prevent the input and display "<ValidationMessage>"
Examples:
| InvalidCharacters | ValidationMessage                          |
| abcdefghi         | "TIN must contain only numeric characters" |
| 12345abcde        | "TIN must contain only numeric characters" |
| !@#$%^&*()        | "TIN must contain only numeric characters" |
@1
Scenario: Verify error message when TIN field is left blank
Given the user navigates to the claim search page
When the user leaves the TIN field blank and submits the search
Then the system should display "TIN field is required"
@1
Scenario Outline: Validate error messages for invalid TIN input
Given the user navigates to the claim search page
When the user enters "<InvalidTIN>" in the TIN field
Then the system should display "<ValidationMessage>"
Examples:
| InvalidTIN  | ValidationMessage                              |
| 12345678    | "TIN must be exactly 9 digits"                 |
| abc123456   | "TIN must contain only numeric characters"     |
| 12345abcde  | "TIN must contain only numeric characters"     |
|             | "TIN field is required"                        |