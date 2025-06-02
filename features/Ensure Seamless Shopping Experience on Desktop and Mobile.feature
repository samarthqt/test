Feature: Ensure Seamless Shopping Experience on Desktop and Mobile
@TC-292
Scenario: Open the application on a desktop browser
Given the application is deployed and accessible
When I open the application on a desktop browser
Then the application loads successfully on the desktop browser
@TC-292
Scenario: Log in using valid user credentials on desktop
Given I have valid user credentials
When I log in using valid user credentials
Then I am redirected to the homepage
@TC-292
Scenario: Perform a product search using relevant keywords on desktop
Given I am on the homepage
When I perform a product search using relevant keywords
Then search results are displayed accurately based on the keywords
@TC-292
Scenario: Add a product to the shopping cart on desktop
Given search results are displayed
When I add a product to the shopping cart
Then the product is added to the cart successfully
@TC-292
Scenario: Proceed to checkout on desktop
Given a product is added to the cart
When I proceed to checkout and fill in the required details
Then checkout process is completed successfully with all details filled
@TC-292
Scenario: Verify order confirmation details on desktop
Given the checkout process is completed
When I verify the order confirmation details
Then order confirmation is displayed with correct details
@TC-292
Scenario: Log out from the desktop session
Given I am logged in
When I log out from the desktop session
Then I log out successfully
@TC-292
Scenario: Open the application on a mobile browser
Given the application is deployed and accessible
When I open the application on a mobile browser
Then the application loads successfully on the mobile browser
@TC-292
Scenario: Log in using valid user credentials on mobile
Given I have valid user credentials
When I log in using the same user credentials on mobile
Then I am redirected to the homepage on mobile
@TC-292
Scenario: Repeat the product search and add a different product to the cart on mobile
Given I am on the homepage on mobile
When I perform a product search using relevant keywords and add a different product to the cart
Then search results are accurate, and the product is added to the cart successfully
@TC-292
Scenario: Proceed to checkout on mobile
Given a product is added to the cart
When I proceed to checkout on mobile and fill in the required details
Then checkout process is completed successfully on mobile
@TC-292
Scenario: Verify order confirmation details on mobile
Given the checkout process is completed on mobile
When I verify the order confirmation details on mobile
Then order confirmation is displayed with correct details on mobile
@TC-292
Scenario: Check responsiveness and UI consistency across desktop and mobile
Given I have access to both desktop and mobile platforms
When I check the application's responsiveness and UI consistency across desktop and mobile
Then the application is responsive and the UI is consistent across both platforms
@TC-292
Scenario: Test the application's performance on both platforms
Given I have access to both desktop and mobile platforms
When I test the application's performance on both platforms
Then the application performs efficiently without any lag or delay on both platforms
@TC-292
Scenario: Log out from the mobile session
Given I am logged in on mobile
When I log out from the mobile session
Then I log out successfully on mobile