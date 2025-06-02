Feature: Validate Currency Conversion During Payment Processing
@TC-116
Scenario: Ensure the system accurately handles currency conversion during payment processing
Given I have access to the payment processing system
When I log in to the system using User123 credentials
Then User is successfully logged in
Given User account with sufficient funds
And 19 currencies set up in the system
When I navigate to the payment processing section
Then Payment processing section is displayed
When I select the option to make a payment
Then Payment options are displayed
When I enter the payment amount as 100 USD
Then Payment amount is accepted
When I select EUR as the target currency
Then Target currency is selected
When I verify the displayed exchange rate of 0.85
Then Exchange rate is correctly displayed
When I proceed to confirm the payment
Then Confirmation screen is displayed
When I confirm the payment transaction
Then Payment is processed successfully
When I check the transaction details for currency conversion accuracy
Then Currency conversion is accurate as per the exchange rate
When I verify the updated account balance in EUR
Then Account balance reflects the conversion
When I log out of the system
Then User is logged out successfully