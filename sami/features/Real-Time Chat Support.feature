Feature: Real-Time Chat Support
""
As a customer service representative,
I want to provide live chat support for customers,
So that I can assist them in real-time with their inquiries and issues.
""
Background:
Given the chat support system is operational
And the customer service representative is logged into the system
""
Scenario: Customer initiates a chat session
Given a customer navigates to the chat support page
"    When the customer clicks on the ""Start Chat"" button"
Then a new chat session should be initiated
And the customer should see a welcome message
""
Scenario: Customer service representative receives a chat request
Given a customer has initiated a chat session
When the chat request is sent to the customer service representative
Then the representative should receive a notification of a new chat request
And the chat session should be displayed in the representative's chat interface
""
Scenario: Customer sends a message
Given a chat session is active
"    When the customer types a message and clicks ""Send"""
Then the message should appear in the chat window for both the customer and the representative
""
Scenario: Customer service representative responds to a message
Given the customer has sent a message
"    When the representative types a response and clicks ""Send"""
Then the response should appear in the chat window for both the representative and the customer
""
Scenario: Customer ends the chat session
Given a chat session is active
"    When the customer clicks on the ""End Chat"" button"
Then the chat session should be terminated
And the customer should see a feedback form
""
Scenario: Customer service representative ends the chat session
Given a chat session is active
"    When the representative clicks on the ""End Chat"" button"
Then the chat session should be terminated
And the representative should see a summary of the chat session
""
Scenario: Chat session timeout due to inactivity
Given a chat session is active
When there is no activity from either the customer or representative for a predefined period
Then the chat session should automatically end
And both parties should receive a notification of the session timeout
```
```gherkin
TCID:42