Feature: Multiple Channels to Contact Customer Service
TCID:TC-1
""
Scenario: Verify multiple channels to contact customer service
Given I have accessed the system's customer service page or contact information
Then the customer service page or contact information should be displayed
""
Scenario: Verify if phone contact information is provided
Then phone contact information should be displayed, including phone number and working hours
""
Scenario: Verify if email contact information is provided
Then email contact information should be displayed, including email address and response time
""
Scenario: Verify if live chat option is available
Then a live chat option should be available for customers to contact customer service
""
Scenario: Click on the phone contact information
When I click on the phone contact information
Then the phone dialer should open with the provided phone number pre-filled
""
Scenario: Click on the email contact information
When I click on the email contact information
Then the default email client should open with the recipient email address pre-filled
""
Scenario: Click on the live chat option
When I click on the live chat option
Then a live chat window should open for customers to start a conversation with customer service
""
Scenario: Enter a message in the live chat window
Given I have opened the live chat window
When I enter a message in the live chat window
Then the message should be sent to customer service and a response should be received
""
Scenario: Verify if alternative contact methods are provided
Then alternative contact methods should be displayed, if available, with relevant information
""
Scenario: Verify if customer service response time is mentioned
Then the expected response time for each contact method should be mentioned
""
Scenario: Verify if customer service working hours are mentioned
Then the working hours for each contact method should be mentioned
""
Scenario: Try contacting customer service using each available channel
When I try contacting customer service using each available channel
Then customer service should be reachable through each available channel
""
Scenario: Verify if customer service contact information is easily accessible from any page
Then the customer service contact information should be easily accessible from any page of the system
""
Scenario: Verify if customer service contact information is displayed correctly on different devices (desktop, mobile)
Then the customer service contact information should be displayed correctly on different devices without any formatting issues
""
Scenario: Verify if customer service contact information is up to date
Then the customer service contact information should be up to date and accurate