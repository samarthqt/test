Feature: In-App Customer Support with AI Chatbot
Scenario: Chatbot handles common banking queries
Given the AI-powered chatbot is active
When a user asks a common banking query
Then the chatbot should respond with the correct information
And the chatbot should handle at least 10 different common banking queries
Scenario: Chatbot response time
Given the AI-powered chatbot is active
When a user sends a query
Then the chatbot should respond in less than 2 seconds
Scenario: Chatbot escalates to human agent
Given the AI-powered chatbot is active
When a user query cannot be resolved within 3 interactions
Then the chatbot should escalate the query to a human agent
Scenario: Compliance with data privacy standards
Given the AI-powered chatbot is active
When a user interacts with the chatbot
Then all interactions should comply with data privacy standards
Scenario: User rates chatbot experience
Given the AI-powered chatbot is active
When a user finishes interacting with the chatbot
Then the user should be able to rate their chatbot experience for continuous improvement