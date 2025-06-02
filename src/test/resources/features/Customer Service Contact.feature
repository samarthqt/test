Feature: Customer Service Contact
TCID:TC-3
""
Scenario: Verify customer can connect with available customer service representative
Given the customer service contact page is displayed
When a contact channel is selected
Then the selected contact channel should be highlighted or marked as active
""
Given the customer's contact information is entered correctly
When the 'Connect' button is clicked
Then the system should connect the customer with an available customer service representative
""
Given the customer is connected with a customer service representative
Then the customer should be able to initiate a conversation with the representative
""
Given the customer service representative is responsive
When the customer makes inquiries or requests
Then the representative should respond to the customer
""
Given the customer is in a conversation with the representative
When the customer wants to end the conversation
Then the customer should be able to end the conversation
""
Given the conversation with the representative is ended
Then the conversation should be ended
""
Given the customer wants to connect with a representative through different contact channels
When the process is repeated for each contact channel
Then the customer should be able to connect with an available representative through different contact channels
""
Given there is at least one representative available for each contact channel
Then the customer service representative should be available for each contact channel
""
Given the customer service contact page is displayed
Then the page should accurately display information about the availability of representatives for each contact channel
""
Given the customer service contact page is displayed
Then the page should provide clear instructions on how to connect with a representative for each contact channel
""
Given the customer service contact page is displayed
Then the page should provide alternative contact methods (e.g. leave a message, schedule a callback) in case all representatives are busy
""
Given the customer service contact page is displayed
Then the page should accurately display contact information (e.g. phone number, email address) for each contact channel