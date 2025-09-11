Feature: Claim Search Validation - Date of Service Field
@4
Scenario: User views the Date of Service input field
Given the user navigates to the claim search page
Then the user sees an input field labeled "Date of Service"
@4
Scenario Outline: User enters a valid Date of Service in the correct format
Given the user navigates to the claim search page
When the user enters "<date_of_service>" in the "Date of Service" field
Then the system accepts the entered date without any error
Examples:
| date_of_service |
| 10-15-22        |
| 12-01-23        |
@4
Scenario: User leaves the Date of Service field blank
Given the user navigates to the claim search page
When the user submits the search criteria without entering a value in the "Date of Service" field
Then the system displays an error message "Date of Service is required"
@4
Scenario Outline: User enters a Date of Service older than 1 year
Given the user navigates to the claim search page
When the user enters "<date_of_service>" in the "Date of Service" field
Then the system displays an error message "Date of Service cannot be older than 1 year"
Examples:
| date_of_service |
| 09-10-21        |
| 08-01-21        |
@4
Scenario Outline: User enters a Date of Service in the future
Given the user navigates to the claim search page
When the user enters "<date_of_service>" in the "Date of Service" field
Then the system displays an error message "Date of Service cannot be in the future"
Examples:
| date_of_service |
| 11-15-24        |
| 01-01-25        |
@4
Scenario Outline: User enters an invalid Date of Service format
Given the user navigates to the claim search page
When the user enters "<date_of_service>" in the "Date of Service" field
Then the system displays an error message "Invalid date format. Please use MM-DD-YY."
Examples:
| date_of_service |
| 2022-10-15      |
| 15/10/22        |
| October 15, 2022|