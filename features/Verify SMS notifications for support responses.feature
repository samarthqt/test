Feature: Verify SMS notifications for support responses
@TC-26
Scenario: Submit a support request via the support portal
Given the user has a registered phone number +1234567890
When the user submits a support request via the support portal
Then the support request is successfully submitted and a ticket ID is generated
@TC-26
Scenario: Ensure the system is configured to send SMS notifications for support responses
Given the system configuration settings confirm SMS notifications are enabled
And the user has a support ticket ID 12345
When a support response is sent to the user
Then the user receives an SMS notification about the support response
@TC-26
Scenario: Verify the content of the SMS notification
Given the user receives an SMS notification about the support response
Then the SMS contains the correct details of the support response
@TC-26
Scenario: Ensure the SMS is sent from the correct support number
Given the user receives an SMS notification
Then the SMS is sent from the designated support number
@TC-26
Scenario: Check the SMS for any formatting issues
Given the user receives an SMS notification
Then the SMS is well-formatted and readable
@TC-26
Scenario: Ensure the SMS is delivered within a reasonable time frame
Given the user receives an SMS notification
Then the SMS is received within 5 minutes of the support response
@TC-26
Scenario: Verify that no duplicate SMS are received for the same response
Given the user receives an SMS notification
Then only one SMS notification is received per support response
@TC-26
Scenario: Check if the SMS includes a link to the support request
Given the user receives an SMS notification
Then the SMS includes a link that redirects to the support request in the portal
@TC-26
Scenario: Ensure the SMS can be received on different mobile networks
Given the user receives an SMS notification
Then the SMS is accessible and correctly displayed on various mobile networks
@TC-26
Scenario: Verify the SMS does not contain any unnecessary information
Given the user receives an SMS notification
Then the SMS contains only the necessary information about the support response
@TC-26
Scenario: Check the SMS for any charges incurred by the user
Given the user receives an SMS notification
Then the user is not charged for receiving the SMS notification
@TC-26
Scenario: Verify user can respond to the SMS
Given the user receives an SMS notification
When the user replies to the SMS
Then the reply is directed to the support team
@TC-26
Scenario: Ensure the SMS notification is not marked as spam
Given the user receives an SMS notification
Then the SMS is delivered to the inbox and not marked as spam