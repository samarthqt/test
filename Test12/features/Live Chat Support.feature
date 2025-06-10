Feature: Live Chat Support
@47
Scenario: Accessing live chat support from web platform
Given the user is on the web platform
When the user navigates to the customer support section
Then the user should see the live chat option
@47
Scenario: Accessing live chat support from mobile platform
Given the user is on the mobile platform
When the user navigates to the customer support section
Then the user should see the live chat option
@47
Scenario: Live chat availability during support hours
Given the current time is within specified support hours
When the user accesses the live chat feature
Then the live chat should be available
@47
Scenario: Secure and private communication in live chat
Given the user has initiated a live chat
When the communication is ongoing
Then the system should ensure secure and private communication
@47
Scenario: Immediate acknowledgment of chat requests
Given the user sends a chat request
When the request is received by the system
Then the user should receive immediate acknowledgment
@47
Scenario: Accessing chat history for future reference
Given the user has previously engaged in live chat
When the user navigates to the chat history section
Then the user should be able to access past chat history
@47
Scenario: Handling connection errors gracefully
Given the user is engaged in a live chat session
When a connection error occurs
Then the system should handle the error gracefully
@47
Scenario: Automated responses for common queries
Given the user asks a common query in live chat
When the query is recognized by the system
Then the system should provide an automated response
@47
Scenario: Integration with support ticketing system for escalations
Given the live chat requires escalation
When the escalation is initiated
Then the integration with the support ticketing system should be seamless