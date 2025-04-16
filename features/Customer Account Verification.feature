Feature: Customer Account Verification
TCID:TC-6
""
Scenario: Customer fails to complete the account verification process
Given the customer is on the account verification page
When the customer enters their account information
And the customer attempts to verify the account without completing all required fields
Then an error message should be displayed indicating that all required fields must be completed
""
Scenario: Customer completes the account verification process
Given the customer is on the account verification page
When the customer enters their account information
And the customer completes all required fields and submits the verification request
Then the verification request should be submitted successfully
""
Scenario: Customer closes the verification page without completing the process
Given the customer is on the account verification page
When the customer closes the verification page without completing the verification process
Then the verification process should not be completed and the account should remain unverified
""
Scenario: Customer attempts to access restricted features without account verification
Given the customer has not completed the account verification process
When the customer attempts to access restricted features or perform actions that require account verification
Then the system should prevent the customer from accessing restricted features or performing actions that require account verification
""
Scenario: Customer completes the account verification process and submits the verification request
Given the customer is on the account verification page
When the customer completes the verification process and submits the verification request
Then the verification request should be submitted successfully and the account should be verified
""
Scenario: Customer accesses restricted features after completing account verification
Given the customer has completed the account verification process
When the customer attempts to access restricted features or perform actions that require account verification
Then the system should allow the customer to access restricted features and perform actions that require account verification