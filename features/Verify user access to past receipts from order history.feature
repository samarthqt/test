Feature: Verify user access to past receipts from order history
@TC-181
Scenario: User logs in to their account
Given the user has a valid account with order history
When the user logs in using User ID "U12345"
Then the user is successfully logged in
@TC-181
Scenario: Navigate to the 'Order History' section
Given the user is logged in
When the user navigates to the 'Order History' section
Then the 'Order History' section is displayed
@TC-181
Scenario: Select a past order from the order history
Given the user is in the 'Order History' section
When the user selects a past order with Order ID "O67890"
Then the details of the selected order are displayed
@TC-181
Scenario: View receipt for the selected order
Given the user has selected an order
When the user clicks on the 'View Receipt' option
Then the receipt for the selected order is displayed
@TC-181
Scenario: Verify receipt details match the order details
Given the receipt for the selected order is displayed
When the user checks the receipt details
Then the receipt details match the order details
@TC-181
Scenario: Download receipt as PDF
Given the receipt for the selected order is displayed
When the user attempts to download the receipt as a PDF
Then the receipt is successfully downloaded as a PDF
@TC-181
Scenario: Access receipt from an unauthorized account
Given the user is not authorized to access the receipt
When the user attempts to access the receipt
Then access to the receipt is denied
@TC-181
Scenario: Verify receipt is stored securely
Given the receipt is stored in the system
When the user checks the security of the receipt
Then the receipt is stored securely and is not tampered with
@TC-181
Scenario: System failure while accessing the receipt
Given the user is accessing the receipt
When a system failure occurs
Then the system handles the failure gracefully and provides an error message
@TC-181
Scenario: Check retention policy for receipts
Given receipts are stored in the system
When the user checks the retention policy
Then receipts are retained according to the policy
@TC-181
Scenario: Access receipts for orders from the last year
Given the user has orders from the last year
When the user attempts to access receipts for these orders
Then the user can access receipts for orders from the last year
@TC-181
Scenario: Access receipt for a cancelled order
Given the user has a cancelled order
When the user attempts to access the receipt for the cancelled order
Then the receipt for the cancelled order is available with a cancellation note
@TC-181
Scenario: Verify no duplicate receipts in the order history
Given the user is in the 'Order History' section
When the user checks for duplicate receipts
Then no duplicate receipts are found in the order history
@TC-181
Scenario: Check receipt includes tax and discount details
Given the receipt for the selected order is displayed
When the user checks for tax and discount details
Then the receipt includes accurate tax and discount details
@TC-181
Scenario: Print receipt directly from the system
Given the receipt for the selected order is displayed
When the user attempts to print the receipt
Then the receipt is printed successfully