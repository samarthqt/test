Feature: Verify integration with Twilio for SMS notifications
@TC-30
Scenario: Ensure Twilio account is configured
Given the user has a Twilio account configured
When the user logs into the application
Then the user is successfully logged in
@TC-30
Scenario: Ensure Twilio API key is configured in the application settings
Given the Twilio API key is set up in the application
When the user checks the application settings
Then the Twilio API key is correctly configured
@TC-30
Scenario: Submit a support request via the support portal
Given the user is logged into the application
When the user submits a support request
Then the support request is successfully submitted and a ticket ID is generated
@TC-30
Scenario: Respond to the support request from the support team dashboard
Given the support request is submitted
When the support team responds to the request
Then the support team can successfully respond to the support request
@TC-30
Scenario: Check the Twilio dashboard for SMS delivery status
Given the support response is sent
When the user checks the Twilio dashboard
Then the SMS delivery status is marked as successful
@TC-30
Scenario: Verify the SMS is received on the user's phone
Given the SMS delivery status is successful
When the user checks their phone
Then the user receives an SMS notification about the support response
@TC-30
Scenario: Check the SMS content for correctness
Given the user receives an SMS notification
When the user reviews the SMS content
Then the SMS contains the correct details of the support response
@TC-30
Scenario: Ensure the SMS is sent from the correct support number
Given the user receives an SMS notification
When the user checks the sender number
Then the SMS is sent from the designated support number
@TC-30
Scenario: Verify the SMS for any formatting issues
Given the user receives an SMS notification
When the user reviews the SMS format
Then the SMS is well-formatted and readable
@TC-30
Scenario: Ensure the SMS is delivered within a reasonable time frame
Given the support response is sent
When the user checks the SMS delivery time
Then the SMS is received within 5 minutes of the support response
@TC-30
Scenario: Verify that no duplicate SMS are received for the same response
Given the support response is sent
When the user checks the SMS notifications
Then only one SMS notification is received per support response
@TC-30
Scenario: Check if the SMS includes a link to the support request
Given the user receives an SMS notification
When the user checks the SMS content
Then the SMS includes a link that redirects to the support request in the portal
@TC-30
Scenario: Ensure the SMS can be received on different mobile networks
Given the user receives an SMS notification
When the user checks the SMS on various mobile networks
Then the SMS is accessible and correctly displayed on various mobile networks
@TC-30
Scenario: Verify the SMS does not contain any unnecessary information
Given the user receives an SMS notification
When the user reviews the SMS content
Then the SMS contains only the necessary information about the support response
@TC-30
Scenario: Check the SMS for any charges incurred by the user
Given the user receives an SMS notification
When the user checks for any charges
Then the user is not charged for receiving the SMS notification