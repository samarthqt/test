Feature: Multiple Payment Methods
Users should be able to choose between multiple payment methods during checkout. The system should present all available payment options, validate the selected payment method, and provide confirmation upon successful selection. The UI must be intuitive and responsive across devices.
@41
Scenario: Display all available payment options during checkout
Given the user is on the checkout page
When the user proceeds to the payment section
Then all available payment options should be displayed
@41
Scenario: Validate the selected payment method
Given the user is on the checkout page
And all available payment options are displayed
When the user selects a valid payment method
Then the system should validate the selected payment method
@41
Scenario: Confirm successful selection of a payment method
Given the user has selected a valid payment method
When the payment method is validated successfully
Then the user should receive a confirmation of successful payment method selection
@41
Scenario: Prompt user to choose another option for invalid payment method
Given the user selects an invalid payment method
When the system attempts to validate the selected payment method
Then the user should be prompted to choose another payment option
@41
Scenario: Ensure UI is intuitive and responsive across devices
Given the user accesses the checkout page on any device
When the user navigates to the payment section
Then the UI should be intuitive and responsive across all devices