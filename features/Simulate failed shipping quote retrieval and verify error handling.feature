Feature: Simulate failed shipping quote retrieval and verify error handling
@TC-322
Scenario: Simulate failure in retrieving shipping quotes and verify error handling capabilities
Given User account exists
When User logs into the application using valid credentials
Then User is successfully logged in and navigated to the homepage
@TC-322
Scenario: Navigate to shopping cart and verify items
Given User is on the homepage
When User navigates to the shopping cart
Then All items added to the cart are displayed with their respective details
@TC-322
Scenario: Proceed to checkout and enter shipping address
Given User is on the shopping cart page
When User proceeds to checkout
Then Checkout page is displayed with options to enter shipping information
@TC-322
Scenario: Enter valid shipping address details
Given User is on the checkout page
When User enters valid shipping address details
Then Shipping address is accepted and saved
@TC-322
Scenario: Select 'Get Shipping Quotes' option
Given User has entered shipping address details
When User selects 'Get Shipping Quotes' option
Then System attempts to retrieve shipping quotes
@TC-322
Scenario: Simulate network failure or service outage
Given System is attempting to retrieve shipping quotes
When Network failure or service outage is simulated
Then System displays an error message indicating failure to retrieve shipping quotes
@TC-322
Scenario: Verify error message provides alternative actions or retry options
Given Error message is displayed
Then Error message includes options to retry or contact support
@TC-322
Scenario: Attempt to retrieve shipping quotes again using retry option
Given Error message includes retry option
When User attempts to retrieve shipping quotes again using retry option
Then System attempts to retrieve quotes again and either succeeds or displays error message
@TC-322
Scenario: Verify logging of error details for further analysis
Given System has displayed an error message
Then Error details are logged in the system for troubleshooting
@TC-322
Scenario: Check email for notification about shipping quote retrieval issue
Given Error details are logged in the system
When User checks email for notification
Then Email notification is sent with details about the issue and possible resolutions
@TC-322
Scenario: Log out from the application
Given User is on any page of the application
When User logs out from the application
Then User is successfully logged out
@TC-322
Scenario: Re-log into the application and navigate to order history
Given User is logged out
When User logs into the application again
And User navigates to order history
Then Order history displays recent order with an indication of shipping quote retrieval issue
@TC-322
Scenario: Attempt to edit shipping details and retrieve quotes again
Given User is on the order history page
When User attempts to edit shipping details
And User attempts to retrieve quotes again
Then System allows editing of shipping details and attempts to retrieve quotes
@TC-322
Scenario: Verify system response when quotes are successfully retrieved after issue resolution
Given User has edited shipping details
When System successfully retrieves shipping quotes
Then System allows selection of preferred provider
@TC-322
Scenario: Confirm the shipping selection and proceed to payment
Given User has selected preferred shipping provider
When User confirms the shipping selection
Then User is navigated to the payment section with selected shipping details