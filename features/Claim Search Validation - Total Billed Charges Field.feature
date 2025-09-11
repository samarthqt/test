Feature: Claim Search Validation - Total Billed Charges Field
@5
Scenario: User sees an input field labeled 'Total Billed Charges'
Given the user navigates to the claim search page
Then the user should see an input field labeled "Total Billed Charges"
@5
Scenario Outline: User enters a valid Total Billed Charges value
Given the user navigates to the claim search page
When the user enters "<valid_value>" in the "Total Billed Charges" field
Then the system should accept the value without displaying any error messages
Examples:
| valid_value |
| 100         |
| 50.5        |
| 9999        |
@5
Scenario: User leaves the Total Billed Charges field blank
Given the user navigates to the claim search page
When the user does not enter any value in the "Total Billed Charges" field
Then the system should display an error message stating "Total Billed Charges is required"
@5
Scenario Outline: User enters a value less than or equal to 0 in the Total Billed Charges field
Given the user navigates to the claim search page
When the user enters "<invalid_value>" in the "Total Billed Charges" field
Then the system should display a validation error message stating "Total Billed Charges must be greater than 0"
Examples:
| invalid_value |
| 0             |
| -10           |
| -1.5          |
@5
Scenario Outline: User enters non-numeric characters in the Total Billed Charges field
Given the user navigates to the claim search page
When the user enters "<non_numeric_value>" in the "Total Billed Charges" field
Then the system should display a validation error message stating "Only numeric values are allowed in Total Billed Charges"
Examples:
| non_numeric_value |
| abc               |
| 123abc            |
| !@#               |
@5
Scenario: Error messages are user-friendly and clearly indicate the issue
Given the user navigates to the claim search page
When the user leaves the "Total Billed Charges" field blank
Then the system should display an error message stating "Total Billed Charges is required"
When the user enters a value less than or equal to 0 in the "Total Billed Charges" field
Then the system should display an error message stating "Total Billed Charges must be greater than 0"
When the user enters non-numeric characters in the "Total Billed Charges" field
Then the system should display an error message stating "Only numeric values are allowed in Total Billed Charges"