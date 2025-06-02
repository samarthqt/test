Feature: Validate Eligibility for Cancellation or Return
@TC-218
Scenario: Validate eligibility for return within merchant's policy
Given the user is logged into the account with Order ID 98765
When the user navigates to the order history section
And selects the order with Order ID 98765
And locates the cancellation and return options on the order details page
And attempts to initiate a return for the order
Then the system checks the merchant's policy for eligibility
And displays the eligibility status
And allows return if the order is within the eligible period
@TC-218
Scenario: Deny return for orders outside the eligible period
Given the user is logged into the account with Order ID 98765
When the user navigates to the order history section
And selects the order with Order ID 98765
And locates the cancellation and return options on the order details page
And attempts to initiate a return for the order
Then the system checks the merchant's policy for eligibility
And denies return for ineligible orders
And prompts with the merchant's policy details when denying returns
@TC-218
Scenario: Log eligibility check for audit purposes
Given the user is logged into the account with Order ID 98765
When the user navigates to the order history section
And selects the order with Order ID 98765
And locates the cancellation and return options on the order details page
And attempts to initiate a return for the order
Then the system logs the eligibility check for audit purposes
@TC-218
Scenario: Notify user about eligibility status
Given the user is logged into the account with Order ID 98765
When the user navigates to the order history section
And selects the order with Order ID 98765
And locates the cancellation and return options on the order details page
And attempts to initiate a return for the order
Then the user receives notifications for eligibility status
@TC-218
Scenario: Update order status based on eligibility checks
Given the user is logged into the account with Order ID 98765
When the user navigates to the order history section
And selects the order with Order ID 98765
And locates the cancellation and return options on the order details page
And attempts to initiate a return for the order
Then the system updates the order status based on eligibility
@TC-218
Scenario: Ensure eligibility checks are consistent across devices
Given the user is logged into the account with Order ID 98765
When the user navigates to the order history section
And selects the order with Order ID 98765
And locates the cancellation and return options on the order details page
And attempts to initiate a return for the order
Then the eligibility checks are consistent on all devices
@TC-218
Scenario: Allow cancellation for eligible orders
Given the user is logged into the account with Order ID 98765
When the user navigates to the order history section
And selects the order with Order ID 98765
And locates the cancellation and return options on the order details page
Then the system allows cancellation for eligible orders
@TC-218
Scenario: Update cancellation and return options based on policy changes
Given the user is logged into the account with Order ID 98765
When the user navigates to the order history section
And selects the order with Order ID 98765
And locates the cancellation and return options on the order details page
Then the options are updated according to policy changes