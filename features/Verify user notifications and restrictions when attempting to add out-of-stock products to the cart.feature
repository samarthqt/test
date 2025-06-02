Feature: Verify user notifications and restrictions when attempting to add out-of-stock products to the cart
@TC-67
Scenario: Navigate to the product page of an out-of-stock item
Given the user is logged into the application
When the user navigates to the product page of an out-of-stock item with Product ID 102
Then the product page is displayed with an out-of-stock status
@TC-67
Scenario: Verify 'Add to Cart' button is disabled for out-of-stock products
Given the user is on the product page of an out-of-stock item
Then the 'Add to Cart' button is disabled
@TC-67
Scenario: Attempt to click the 'Add to Cart' button for an out-of-stock product
Given the 'Add to Cart' button is disabled
When the user attempts to click the 'Add to Cart' button
Then the system prevents adding the product to the cart and displays an error message
@TC-67
Scenario: Check if an out-of-stock notification is displayed on the product page
Given the user is on the product page of an out-of-stock item
Then an out-of-stock notification is visible on the product page
@TC-67
Scenario: Try adding the product to the cart using a direct URL manipulation
When the user tries to add the product to the cart using a direct URL manipulation
Then the system prevents addition and displays an error message
@TC-67
Scenario: Verify that the cart does not include the out-of-stock product
Given the user attempted to add an out-of-stock product to the cart
Then the cart remains unchanged with no out-of-stock products added
@TC-67
Scenario: Check if the product detail page provides alternative suggestions for similar products
Given the user is on the product page of an out-of-stock item
Then alternative product suggestions are displayed
@TC-67
Scenario: Attempt to add the product to a wishlist
When the user attempts to add the out-of-stock product to a wishlist
Then the system allows adding to the wishlist but not to the cart
@TC-67
Scenario: Verify if the product page updates in real-time when stock status changes
Given the stock status of the product changes
Then the product page reflects real-time stock status updates
@TC-67
Scenario: Log out and attempt to add the out-of-stock product
Given the user is logged out
When the user attempts to add the out-of-stock product to the cart
Then the system prevents addition and prompts for login
@TC-67
Scenario: Check if the system logs an attempt to add out-of-stock products
When the user attempts to add an out-of-stock product to the cart
Then the system logs the attempt for auditing purposes
@TC-67
Scenario: Attempt to add the out-of-stock product using a mobile device
When the user attempts to add the out-of-stock product using a mobile device
Then the system prevents addition and displays a consistent error message
@TC-67
Scenario: Verify if the out-of-stock product is searchable in the product catalog
When the user searches for the out-of-stock product in the product catalog
Then the product is searchable but marked as out of stock
@TC-67
Scenario: Attempt to add the product via API call
When the user attempts to add the product via an API call
Then the API responds with an error indicating out-of-stock status
@TC-67
Scenario: Check if the system provides an option to notify the user when the product is back in stock
Given the product is out of stock
Then a notification option is available for the user to be notified when the product is back in stock