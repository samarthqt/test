Feature: Customer Support via Live Chat
Scenario: Accessing customer support via live chat
Given the application is open
When the customer navigates to the customer support section
Then the customer should see the live chat option
Scenario: Live chat integration within the application
Given the customer is on the application
When the customer accesses the live chat feature
Then the live chat should be integrated within the application
Scenario: Availability of live chat 24/7
Given the customer wants to use the live chat feature
When the customer tries to access live chat at any time
Then the live chat should be available 24/7
Scenario: Notifications for chat availability
Given the customer is using the application
When the live chat feature becomes available
Then the customer should receive a notification informing them of chat availability
Scenario: Error messages for failed chat connections
Given the customer is trying to connect to live chat
When the chat connection fails
Then an error message should be displayed to the customer
Scenario: Logging of live chat interactions
Given the customer is using the live chat feature
When the chat interaction occurs
Then the interaction should be logged for tracking purposes