Feature: Account Verification Process
TCID:TC-5
""
Scenario: Customer goes through the account verification process successfully
Given the customer is on the account verification page
When the customer enters their account credentials
And clicks on the 'Verify Account' button
Then the account verification is successful
And the customer is redirected to their account details page
And the account status is updated to 'Verified'
And the customer can access account features
And the customer is able to logout from the account
""
Scenario: Customer fails to complete the account verification process
Given the customer is on the account verification page
When the customer enters incorrect account credentials
And clicks on the 'Verify Account' button
Then the account verification fails
And an error message is displayed indicating the account verification failed
And the customer is not able to access their account details page
And the account status remains as 'Unverified'