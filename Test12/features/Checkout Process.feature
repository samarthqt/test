Feature: Checkout Process
@36
Scenario: User proceeds to checkout from shopping cart
Given the user has items in the shopping cart
When the user clicks on the "Proceed to Checkout" button
Then the user is redirected to the checkout page
@36
Scenario: User enters new shipping information
Given the user is on the checkout page
When the user enters new shipping information
Then the system validates the shipping information for accuracy
@36
Scenario: User selects saved shipping information
Given the user is on the checkout page
And the user has saved shipping information
When the user selects saved shipping information
Then the system validates the shipping information for accuracy
@36
Scenario: User enters new billing information
Given the user is on the checkout page
When the user enters new billing information
Then the system validates the billing information for accuracy
@36
Scenario: User selects saved billing information
Given the user is on the checkout page
And the user has saved billing information
When the user selects saved billing information
Then the system validates the billing information for accuracy
@36
Scenario: System provides different shipping methods
Given the user is on the checkout page
When the user proceeds to select a shipping method
Then the system provides options for different shipping methods
@36
Scenario: Checkout process is secure and complies with data protection regulations
Given the user is on the checkout page
When the user enters personal information
Then the checkout process is secure and complies with data protection regulations
@36
Scenario: System displays order summary before final confirmation
Given the user has entered shipping and billing information
When the user proceeds to the order review step
Then the system displays a summary of the order before final confirmation
@36
Scenario: User reviews and edits order details before payment
Given the user is on the order summary page
When the user reviews the order details
And the user edits the order details
Then the system updates the order summary with the edited details
@36
Scenario: Checkout process is optimized for quick completion
Given the user is on the checkout page
When the user completes all required steps
Then the checkout process should be quick and efficient
@36
Scenario: System handles errors and provides clear instructions for correction
Given the user is on the checkout page
When the user enters incorrect information
Then the system displays an error message with clear instructions for correction