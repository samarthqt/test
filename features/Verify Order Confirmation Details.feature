Feature: Verify Order Confirmation Details
@TC-172
Scenario: Verify the order confirmation page is displayed
Given the user has completed a purchase transaction
When the user navigates to the order confirmation page
Then the order confirmation page is displayed
@TC-172
Scenario: Verify the order number is displayed
Given the user is on the order confirmation page
Then the order number '12345' is displayed
@TC-172
Scenario: Verify the shipping address is displayed correctly
Given the user is on the order confirmation page
Then the shipping address '123 Main St, Springfield' is displayed
@TC-172
Scenario: Verify all items purchased are listed on the confirmation page
Given the user is on the order confirmation page
Then the items '1x Laptop, 2x Mouse' are listed
@TC-172
Scenario: Verify item quantities match the purchase order
Given the user is on the order confirmation page
Then the item quantities match the purchase order
@TC-172
Scenario: Verify item prices are displayed correctly
Given the user is on the order confirmation page
Then the item prices are accurate as per the purchase order
@TC-172
Scenario: Verify the total amount matches the purchase total
Given the user is on the order confirmation page
Then the total amount matches the purchase order
@TC-172
Scenario: Verify the estimated delivery date is provided
Given the user is on the order confirmation page
Then the estimated delivery date is displayed
@TC-172
Scenario: Verify the payment method used is listed
Given the user is on the order confirmation page
Then the payment method is displayed
@TC-172
Scenario: Verify customer support contact information is provided
Given the user is on the order confirmation page
Then customer support contact information is displayed
@TC-172
Scenario: Verify a link to track the order is available
Given the user is on the order confirmation page
Then a tracking link is available
@TC-172
Scenario: Verify the page layout is user-friendly and information is legible
Given the user is on the order confirmation page
Then the page layout is clear and information is easily readable
@TC-172
Scenario: Verify there is an option to print the confirmation
Given the user is on the order confirmation page
Then a print option is available
@TC-172
Scenario: Verify there is an option to send the confirmation to an email
Given the user is on the order confirmation page
Then an email option is available
@TC-172
Scenario: Verify promotional offers or discounts are displayed if applicable
Given the user is on the order confirmation page
Then promotional offers or discounts are displayed if applicable