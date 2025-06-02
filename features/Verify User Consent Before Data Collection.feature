Feature: Verify User Consent Before Data Collection
@TC-240
Scenario: Ensure user consent is obtained before any data collection and processing
Given the user account is active with User ID: 12345
When the user navigates to account settings
Then the user account settings page is displayed
And a consent form must be available
@TC-240
Scenario: Locate and provide consent
Given the user is on the account settings page
When the user locates the consent section
Then the consent section is visible with options
And the consent form version is 1.0
When the user selects the option to provide consent
Then the consent option is selected
And the consent status is 'Not Given'
When the user submits the consent form
Then the consent form is submitted successfully
@TC-240
Scenario: Verify consent status and proceed with data collection
Given the consent form is submitted successfully
When the user verifies the status of consent in the user profile
Then the consent status is updated to 'Given'
When the user attempts to collect data
Then data collection proceeds as consent is given
And the consent record is logged with a timestamp
@TC-240
Scenario: Verify data processing and user notification
Given data collection proceeds
When the user verifies data processing initiation
Then data processing starts as per the consent
When the user checks for consent confirmation notification
Then the user receives confirmation notification
@TC-240
Scenario: Verify audit trail for consent
Given the user receives confirmation notification
When the user verifies the audit trail for consent
Then the audit trail includes consent details
@TC-240
Scenario: Revoke consent and attempt data collection
Given the user can revoke consent
When the user revokes consent successfully
Then the user attempts data collection after revoking consent
And data collection is blocked as consent is revoked
@TC-240
Scenario: Verify system response and user notification for consent revocation
Given data collection is blocked
When the user checks system response to consent revocation
Then the system updates consent status to 'Revoked'
When the user verifies notification for consent revocation
Then the user receives notification of consent revocation
@TC-240
Scenario: Verify audit trail for consent revocation
Given the user receives notification of consent revocation
When the user checks audit trail for consent revocation
Then the audit trail includes revocation details