Feature: Verify GDPR Compliance in Handling Customer Data During Support Interactions
@TC-103
Scenario: Log in to the user account using valid credentials
Given the user has valid account credentials
When the user logs into their account
Then the user is successfully logged in
@TC-103
Scenario: Navigate to the support interaction section of the application
Given the user is logged in
When the user navigates to the support interaction section
Then the user is directed to the support interaction page
@TC-103
Scenario: Initiate a support interaction using sample customer data
Given the user is on the support interaction page
When the user initiates a support interaction with sample customer data
Then the support interaction is successfully initiated
@TC-103
Scenario: Verify data handling during the support interaction
Given a support interaction is in progress
When customer data is being handled
Then the data is handled in compliance with GDPR guidelines
@TC-103
Scenario: Check system logs support interactions with necessary data protection measures
Given a support interaction is initiated
When the system logs the interaction
Then support interactions are logged with data protection measures in place
@TC-103
Scenario: Verify system notifications for users regarding data handling and protection
Given a support interaction is initiated
When the system sends notifications to users
Then users receive notifications regarding data handling and protection in compliance with GDPR
@TC-103
Scenario: Check if the system allows users to request data deletion or access
Given a user wants to manage their data
When the user requests data deletion or access
Then the system allows the request as per GDPR guidelines
@TC-103
Scenario: Verify system behavior when handling sensitive customer data
Given sensitive customer data is being handled
When the system processes the data
Then sensitive data is handled securely and in compliance with GDPR
@TC-103
Scenario: Attempt to access support interaction logs using different user roles
Given support interaction logs exist
When a user with different roles attempts to access the logs
Then access to interaction logs is restricted based on user roles
@TC-103
Scenario: Check system logs for any errors related to data handling during support interactions
Given support interactions are ongoing
When the system logs data handling activities
Then no errors are logged; data handling is recorded as expected
@TC-103
Scenario: Verify system recovery time after handling sensitive data
Given sensitive data has been handled
When the system recovers from the interaction
Then system recovery time is within acceptable limits
@TC-103
Scenario: Monitor system resource usage during data handling
Given data handling is in progress
When the system monitors resource usage
Then resource usage remains within acceptable limits
@TC-103
Scenario: Verify system performance during support interactions
Given support interactions are ongoing
When the system processes interactions
Then system performance is consistent during support interactions
@TC-103
Scenario: Attempt to initiate support interactions using different user roles
Given different user roles exist
When users attempt to initiate support interactions
Then system response is consistent across different user roles
@TC-103
Scenario: Verify system compliance with GDPR during data processing
Given customer data is being processed
When the system handles data processing
Then the system processes customer data in compliance with GDPR guidelines