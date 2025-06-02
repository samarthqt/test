Feature: Test Cart Display Responsiveness on Mobile Devices
@TC-160
Scenario: Verify cart display on iPhone 12
Given the retail application is opened on iPhone 12
And user account with items added to the cart is logged in
When the user navigates to the cart page
Then the cart page loads with items correctly displayed
And the text in the cart is clear and readable without needing to zoom
And the cart layout adjusts correctly to the screen size without overlapping elements
@TC-160
Scenario: Verify cart display on Samsung Galaxy S21
Given the retail application is opened on Samsung Galaxy S21
And user account with items added to the cart is logged in
When the user navigates to the cart page
Then similar positive results as observed on iPhone 12 are seen
@TC-160
Scenario: Verify cart display on Google Pixel 5
Given the retail application is opened on Google Pixel 5
And user account with items added to the cart is logged in
When the user navigates to the cart page
Then similar positive results as observed on iPhone 12 are seen
@TC-160
Scenario: Verify cart display on iPad Air
Given the retail application is opened on iPad Air
And user account with items added to the cart is logged in
When the user navigates to the cart page
Then similar positive results as observed on iPhone 12 are seen
@TC-160
Scenario: Verify cart display on Huawei P40
Given the retail application is opened on Huawei P40
And user account with items added to the cart is logged in
When the user navigates to the cart page
Then similar positive results as observed on iPhone 12 are seen
@TC-160
Scenario: Check cart display in landscape mode on iPhone 12
Given the retail application is opened on iPhone 12 in landscape mode
When the user navigates to the cart page
Then the cart display adjusts correctly without losing readability
@TC-160
Scenario: Check cart display in landscape mode on Samsung Galaxy S21
Given the retail application is opened on Samsung Galaxy S21 in landscape mode
When the user navigates to the cart page
Then the cart display adjusts correctly without losing readability
@TC-160
Scenario: Check cart display in landscape mode on Google Pixel 5
Given the retail application is opened on Google Pixel 5 in landscape mode
When the user navigates to the cart page
Then the cart display adjusts correctly without losing readability
@TC-160
Scenario: Check cart display in landscape mode on iPad Air
Given the retail application is opened on iPad Air in landscape mode
When the user navigates to the cart page
Then the cart display adjusts correctly without losing readability
@TC-160
Scenario: Check cart display in landscape mode on Huawei P40
Given the retail application is opened on Huawei P40 in landscape mode
When the user navigates to the cart page
Then the cart display adjusts correctly without losing readability
@TC-160
Scenario: Test cart functionality by adding an item on iPhone 12
Given the retail application is opened on iPhone 12
And user account with items added to the cart is logged in
When the user adds an item to the cart
Then the item is successfully added and displayed in the cart
@TC-160
Scenario: Test cart functionality by removing an item on iPhone 12
Given the retail application is opened on iPhone 12
And user account with items added to the cart is logged in
When the user removes an item from the cart
Then the item is successfully removed and no longer displayed in the cart