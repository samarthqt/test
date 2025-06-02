Feature: Verify availability of real-time shipping quotes during checkout
To ensure that real-time shipping quotes are available during checkout and users can select preferred shipping providers.
@TC-321
Scenario: Verify real-time shipping quotes during checkout
Given a user account exists
When the user logs into the application using valid credentials
Then the user is successfully logged in and navigated to the homepage
@TC-321
Scenario: Add product to cart and navigate to shopping cart
Given the user is logged in
When the user adds a product to the cart
Then all items added to the cart are displayed with their respective details
@TC-321
Scenario: Proceed to checkout
Given the user is on the shopping cart page
When the user proceeds to checkout
Then the checkout page is displayed with options to enter shipping information
@TC-321
Scenario: Enter shipping address details
Given the user is on the checkout page
When the user enters valid shipping address details
Then the shipping address is accepted and saved
@TC-321
Scenario: Get real-time shipping quotes
Given the user has entered a valid shipping address
When the user selects 'Get Shipping Quotes' option
Then real-time shipping quotes are displayed from available providers
@TC-321
Scenario: Select preferred shipping provider
Given real-time shipping quotes are displayed
When the user reviews the shipping quotes and selects a preferred provider
Then the selected shipping provider is highlighted and confirmed for checkout
@TC-321
Scenario: Confirm shipping selection and proceed to payment
Given the user has selected a shipping provider
When the user confirms the shipping selection and proceeds to payment
Then the user is navigated to the payment section with selected shipping details
@TC-321
Scenario: Complete transaction
Given the user is on the payment section
When the user enters payment information and completes the transaction
Then the transaction is successful, and order confirmation is displayed
@TC-321
Scenario: Verify order summary
Given the transaction is successful
When the user reviews the order summary
Then the order summary includes the selected shipping provider and cost
@TC-321
Scenario: Check email for order confirmation
Given the order is confirmed
When the user checks their email
Then the email confirmation includes selected shipping provider and estimated delivery date
@TC-321
Scenario: Log out and re-log into the application
Given the user is logged in
When the user logs out from the application
Then the user is successfully logged out
@TC-321
Scenario: Verify order history
Given the user is logged out
When the user re-logs into the application and navigates to order history
Then the order history displays recent order with correct shipping details
@TC-321
Scenario: View detailed shipping information
Given the user is in the order history section
When the user selects the order to view detailed shipping information
Then detailed shipping information including provider and tracking number is displayed
@TC-321
Scenario: Track the order
Given the user has a tracking number
When the user tracks the order using the provided tracking number
Then tracking information is accessible and updates are displayed in real-time
@TC-321
Scenario: Verify estimated delivery date
Given the user has tracked the order
When the user verifies the estimated delivery date
Then the estimated delivery date matches the shipping provider's quote