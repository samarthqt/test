Feature: Validate Patient DOB field in claim search criteria
@6
Scenario: Verify the presence of the Patient DOB input field
Given the user navigates to the claim search page
Then the user should see an input field labeled "Patient DOB"
@6
Scenario Outline: Validate the format of the Patient DOB field
Given the user navigates to the claim search page
When the user enters "<PatientDOB>" in the "Patient DOB" field
Then the system should validate the format as "<ValidationResult>"
Examples:
| PatientDOB | ValidationResult  |
| 01-01-23   | valid             |
| 1/1/2023   | invalid           |
| 01-01-2023 | invalid           |
| 01-01-YY   | invalid           |
@6
Scenario: Verify the Patient DOB field is optional
Given the user navigates to the claim search page
When the user leaves the "Patient DOB" field blank
Then the system should not display any error message
@6
Scenario Outline: Validate that the entered date is not in the future
Given the user navigates to the claim search page
When the user enters "<PatientDOB>" in the "Patient DOB" field
Then the system should validate the date as "<ValidationResult>"
Examples:
| PatientDOB | ValidationResult  |
| 12-31-22   | valid             |
| 01-01-24   | invalid           |
| 01-01-23   | valid             |
@6
Scenario Outline: Validate error messages for invalid dates
Given the user navigates to the claim search page
When the user enters "<PatientDOB>" in the "Patient DOB" field
Then the system should display the error message "<ErrorMessage>"
Examples:
| PatientDOB | ErrorMessage                                 |
| 01-01-2023 | "Please enter the date in MM-DD-YY format." |
| 01-01-24   | "Date cannot be in the future."             |
| 13-01-23   | "Please enter a valid date."                |