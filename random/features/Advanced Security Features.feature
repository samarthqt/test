Feature: Advanced Security Features
Scenario: User logs in using biometric authentication
Given the user has registered biometric data
When the user attempts to log in using fingerprint or face ID
Then the user should be successfully logged in
Scenario: Real-time fraud detection alerts
Given the user is logged in
When suspicious activity is detected
Then the system should alert the user within 1 minute
Scenario: User freezes account upon fraud detection
Given the user has been alerted of suspicious activity
When the user chooses to freeze their account
Then the account should be automatically frozen
Scenario: Secure storage of biometric data
Given the user has provided biometric data
Then the biometric data should be stored securely
And the storage should comply with data protection regulations
Scenario: Alerts sent via email and SMS
Given the user has been alerted of suspicious activity
When the alert is sent
Then the user should receive an email with details of the suspicious activity
And the user should receive an SMS with details of the suspicious activity