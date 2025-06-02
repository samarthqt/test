Feature: Test cart handling of maximum allowable product quantities and system performance
@TC-157
Scenario: Verify the shopping cart's ability to manage maximum allowable product quantities
Given the user is logged into the application
When the user navigates to the product page for Product ID 67890
Then the product page displays correctly with relevant details
@TC-157
Scenario: Enter maximum allowable quantity into the quantity field
Given the user is on the product page for Product ID 67890
When the user enters the maximum allowable quantity of 50 into the quantity field
Then the quantity field accepts the input value
@TC-157
Scenario: Add product to the cart
Given the maximum allowable quantity is entered in the quantity field
When the user clicks the 'Add to Cart' button
Then the system processes the request and adds the product to the cart
@TC-157
Scenario: Verify cart reflects maximum allowable quantity
Given the product is added to the cart
When the user views the cart
Then the cart displays the correct quantity of 50
@TC-157
Scenario: Check system performance metrics during transaction
Given the product is added to the cart
When the transaction is processed
Then the system remains responsive and processes the request efficiently
@TC-157
Scenario: Attempt to increase quantity beyond maximum limit
Given the product is added to the cart
When the user attempts to increase the quantity beyond 50
Then the system rejects the input and displays an error message
@TC-157
Scenario: Verify cart does not reflect any quantity above maximum limit
Given the product is added to the cart
When the user attempts to increase the quantity beyond 50
Then the cart maintains the maximum allowable quantity of 50
@TC-157
Scenario: Assess system behavior under multiple maximum quantity additions
Given the user attempts to add multiple products with maximum quantity
When the requests are processed
Then the system handles requests efficiently without performance degradation
@TC-157
Scenario: Check for system warnings or alerts during the process
Given the user performs maximum quantity additions
When the process is completed
Then the system should not display any warnings if functioning correctly
@TC-157
Scenario: Attempt to add a quantity of zero to test edge case handling
Given the user is on the product page for Product ID 67890
When the user enters a quantity of zero
Then the system should not add the product and may display a relevant message
@TC-157
Scenario: Test input validation by adding a non-numeric quantity
Given the user is on the product page for Product ID 67890
When the user enters a non-numeric quantity
Then the system rejects the input and displays an error message
@TC-157
Scenario: Verify system logs for transaction entries
Given the user performs transactions
When the transaction logs are checked
Then the logs should reflect the transaction process and any errors encountered
@TC-157
Scenario: Ensure system maintains accurate stock levels after transactions
Given the user performs transactions
When the stock levels are checked
Then stock levels remain consistent and accurately reflect available inventory
@TC-157
Scenario: Evaluate user satisfaction and experience during the transaction
Given the user performs transactions
When the user provides feedback
Then users should find the process smooth and error-free
@TC-157
Scenario: Check system scalability under high load with maximum quantity additions
Given the user performs maximum quantity additions under high load
When the system is monitored
Then the system scales effectively and maintains performance