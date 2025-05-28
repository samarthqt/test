Feature: Save Payment Information
""
As a user,
I want to securely save my payment information
So that I can use it for future purchases without re-entering my details.
""
Background:
Given the user is logged into their account
"    And the user is on the ""Payment Info"" page"
""
Scenario: Save valid payment information
Given the user enters valid payment details
| Card Number      | Expiry Date | CVV |
| 4111111111111111 | 12/25       | 123 |
When the user saves the payment information
Then the payment information should be saved securely
"    And a confirmation message ""Payment information saved successfully."" should be displayed"
""
Scenario: Attempt to save invalid payment information
Given the user enters invalid payment details
| Card Number      | Expiry Date | CVV |
| 1234567890123456 | 01/20       | 000 |
When the user attempts to save the payment information
"    Then an error message ""Invalid payment details. Please check and try again."" should be displayed"
And the payment information should not be saved
""
Scenario: Save payment information with missing fields
Given the user enters incomplete payment details
| Card Number      | Expiry Date | CVV |
| 4111111111111111 |            |     |
When the user attempts to save the payment information
"    Then an error message ""Please fill in all required fields."" should be displayed"
And the payment information should not be saved
""
Scenario: Update existing payment information
Given the user has previously saved payment information
When the user updates the payment details
| Card Number      | Expiry Date | CVV |
| 4111111111111111 | 11/26       | 321 |
And the user saves the updated payment information
Then the updated payment information should be saved securely
"    And a confirmation message ""Payment information updated successfully."" should be displayed"
""
Scenario: Delete saved payment information
Given the user has previously saved payment information
When the user opts to delete the saved payment information
Then the payment information should be removed
"    And a confirmation message ""Payment information deleted successfully."" should be displayed"
```
```gherkin
TCID:13