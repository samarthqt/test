Feature: Invalid Email Address for Alerts
@TC-7
Scenario: Verify that alerts are not sent if the customer's email address is invalid
Given a shipment order exists in the system
And I am logged into the Dynamics 365 system with valid credentials
When I navigate to the 'Orders' module
And I select the order with ID 54321
And I update the shipment status to 'Delivered'
Then no alert should be sent due to invalid email address "invalidemail@.com"
And an error should be logged indicating failure to send alert to "invalidemail@.com"