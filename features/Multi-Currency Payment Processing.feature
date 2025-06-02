Feature: Multi-Currency Payment Processing
@TC-320
Scenario: Verify payment processing with USD
Given the user is logged into the system with valid credentials
And the user navigates to the checkout page
When the user selects USD as the currency for payment
And enters payment details for USD transaction
And confirms the payment using USD
Then the payment is processed successfully using USD
And transaction confirmation is received for USD
@TC-320
Scenario: Verify payment processing with EUR
Given the user is logged into the system with valid credentials
And the user navigates to the checkout page
When the user selects EUR as the currency for payment
And enters payment details for EUR transaction
And confirms the payment using EUR
Then the payment is processed successfully using EUR
And transaction confirmation is received for EUR
@TC-320
Scenario: Verify payment processing with GBP
Given the user is logged into the system with valid credentials
And the user navigates to the checkout page
When the user selects GBP as the currency for payment
And enters payment details for GBP transaction
And confirms the payment using GBP
Then the payment is processed successfully using GBP
And transaction confirmation is received for GBP
@TC-320
Scenario: Verify payment processing with JPY
Given the user is logged into the system with valid credentials
And the user navigates to the checkout page
When the user selects JPY as the currency for payment
And enters payment details for JPY transaction
And confirms the payment using JPY
Then the payment is processed successfully using JPY
And transaction confirmation is received for JPY
@TC-320
Scenario: Verify payment processing with AUD
Given the user is logged into the system with valid credentials
And the user navigates to the checkout page
When the user selects AUD as the currency for payment
And enters payment details for AUD transaction
And confirms the payment using AUD
Then the payment is processed successfully using AUD
And transaction confirmation is received for AUD
@TC-320
Scenario: Verify currency conversion rates are applied accurately
Given the user has completed transactions in multiple currencies
Then currency conversion rates are applied accurately for transactions