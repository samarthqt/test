Feature: Verify purchase process consistency across desktop and mobile platforms
@TC-276
Scenario: Complete purchase process on desktop
Given the application is opened on a desktop browser
When the user logs into the application using valid credentials
And navigates to the product page and selects a product to purchase
And adds the product to the shopping cart
And proceeds to checkout and selects payment method
Then the purchase process is completed successfully on the desktop without errors
@TC-276
Scenario: Complete purchase process on mobile
Given the application is opened on a mobile browser
When the user logs into the application using valid credentials
And navigates to the product page and selects the same product to purchase
And adds the product to the shopping cart
And proceeds to checkout and selects payment method
Then the purchase process is completed successfully on the mobile without errors
@TC-276
Scenario: Verify purchase confirmation consistency across platforms
Given the purchase process is completed on both desktop and mobile
Then purchase confirmation is received consistently across both platforms
@TC-276
Scenario: Check for discrepancies in purchase details
Given the purchase process is completed on both desktop and mobile
Then no discrepancies are found; purchase details match across platforms
@TC-276
Scenario: Document issues encountered during testing
Given the purchase process is completed on both desktop and mobile
Then no issues are documented; purchase process is consistent across platforms