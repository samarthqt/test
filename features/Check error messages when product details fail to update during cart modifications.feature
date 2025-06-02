Feature: Check error messages when product details fail to update during cart modifications
@TC-159
Scenario: Verify error message when product quantity update fails
Given User is logged into the application
And Product ID 98765 is added to the cart with an initial quantity of 3
When User navigates to the shopping cart page
Then Shopping cart page displays correctly with initial quantity 3
When User attempts to update the product quantity to 5
And Simulate a failure in updating the product details
Then System displays an error message indicating the update failure
And Error message clearly states the issue with updating product details
And Cart maintains the original quantity and details
@TC-159
Scenario: Verify error message when updating other product details fails
Given User is logged into the application
And Product ID 98765 is added to the cart with an initial quantity of 3
When User navigates to the shopping cart page
Then Shopping cart page displays correctly with initial quantity 3
When User attempts to update other product details such as price or name
And Simulate a failure in updating the product details
Then System displays an error message indicating the update failure
And Cart maintains the original quantity and details
@TC-159
Scenario: Verify system performance under repeated update failures
Given User is logged into the application
And Product ID 98765 is added to the cart with an initial quantity of 3
When User navigates to the shopping cart page
Then Shopping cart page displays correctly with initial quantity 3
When User attempts to update the product quantity to 5 multiple times
And Simulate repeated failures in updating the product details
Then System remains responsive and handles errors gracefully
@TC-159
Scenario: Verify system logs for error handling entries
Given User is logged into the application
And Product ID 98765 is added to the cart with an initial quantity of 3
When User navigates to the shopping cart page
Then Shopping cart page displays correctly with initial quantity 3
When User attempts to update the product quantity to 5
And Simulate a failure in updating the product details
Then Logs should reflect the error handling process for update failures
@TC-159
Scenario: Assess user experience and satisfaction with error handling
Given User is logged into the application
And Product ID 98765 is added to the cart with an initial quantity of 3
When User navigates to the shopping cart page
Then Shopping cart page displays correctly with initial quantity 3
When User attempts to update the product quantity to 5
And Simulate a failure in updating the product details
Then Users should understand the error message and how to resolve the issue
@TC-159
Scenario: Ensure system maintains accurate product details after error handling
Given User is logged into the application
And Product ID 98765 is added to the cart with an initial quantity of 3
When User navigates to the shopping cart page
Then Shopping cart page displays correctly with initial quantity 3
When User attempts to update the product quantity to 5
And Simulate a failure in updating the product details
Then Product details remain consistent and accurately reflect available information
@TC-159
Scenario: Verify system scalability under high load with update failures
Given User is logged into the application
And Product ID 98765 is added to the cart with an initial quantity of 3
When User navigates to the shopping cart page
Then Shopping cart page displays correctly with initial quantity 3
When User attempts to update the product quantity to 5 under high load
And Simulate a failure in updating the product details
Then System scales effectively and maintains performance
@TC-159
Scenario: Evaluate the impact of update failures on overall cart functionality
Given User is logged into the application
And Product ID 98765 is added to the cart with an initial quantity of 3
When User navigates to the shopping cart page
Then Shopping cart page displays correctly with initial quantity 3
When User attempts to update the product quantity to 5
And Simulate a failure in updating the product details
Then Cart functions should remain unaffected by update failures
@TC-159
Scenario: Check for any system warnings or alerts during update failures
Given User is logged into the application
And Product ID 98765 is added to the cart with an initial quantity of 3
When User navigates to the shopping cart page
Then Shopping cart page displays correctly with initial quantity 3
When User attempts to update the product quantity to 5
And Simulate a failure in updating the product details
Then System should not display any warnings if functioning correctly