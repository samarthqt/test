Feature: Admin edits product description with maximum characters
@TC-136
Scenario: Admin successfully edits product description with maximum characters
Given Admin is logged in and product management module is accessible
When Admin selects the product with ID 12345 from the list
Then Product details page is displayed
When Admin clicks on the 'Edit' button for the product description field
Then Description field becomes editable
When Admin enters a description with the maximum allowed characters
Then Description is entered without any truncation
When Admin saves the changes
Then Changes are saved successfully and confirmation message is displayed
When Admin refreshes the page
Then Updated description is displayed correctly
@TC-136
Scenario: Admin logs out and logs in again to verify persistence
Given Admin is logged in and product management module is accessible
When Admin logs out from admin account
Then Admin is logged out successfully
When Admin logs in again and navigates to the product
Then Description remains updated
@TC-136
Scenario: Attempt to edit description with more than maximum characters
Given Admin is logged in and product management module is accessible
When Admin attempts to edit description with more than maximum characters
Then System prevents saving and displays error message
@TC-136
Scenario: Verify database entry for the product description
Given Admin is logged in and product management module is accessible
When Admin checks the database entry for the product description
Then Database reflects the updated description accurately
@TC-136
Scenario: Attempt to edit description with special characters
Given Admin is logged in and product management module is accessible
When Admin attempts to edit description with special characters
Then Special characters are accepted and saved correctly
@TC-136
Scenario: Verify audit logs for the description change
Given Admin is logged in and product management module is accessible
When Admin verifies audit logs for the description change
Then Audit logs show the change made with timestamp and admin ID
@TC-136
Scenario: Check description display on customer-facing product page
Given Admin is logged in and product management module is accessible
When Admin checks if description is correctly displayed on the customer-facing product page
Then Updated description is visible on the product page
@TC-136
Scenario: Attempt to edit description with HTML tags
Given Admin is logged in and product management module is accessible
When Admin attempts to edit description with HTML tags
Then HTML tags are sanitized or displayed as text
@TC-136
Scenario: Check if description update triggers any notification
Given Admin is logged in and product management module is accessible
When Admin checks if the description update triggers any notification
Then No unexpected notifications are triggered