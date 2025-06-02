Feature: Concurrent Admin Actions
Verify system behavior when admin actions are performed concurrently. Multiple admin accounts must be logged in simultaneously.
@TC-95
Scenario: Admin1 logs in using valid credentials
Given the network supports concurrent connections
When Admin1 logs in with email "admin1@example.com" and password "password123"
Then Admin1 is successfully logged in and redirected to the dashboard
@TC-95
Scenario: Admin2 logs in using valid credentials
When Admin2 logs in with email "admin2@example.com" and password "password456"
Then Admin2 is successfully logged in and redirected to the dashboard
@TC-95
Scenario: Admin1 navigates to the catalog management section
When Admin1 navigates to the catalog management section with Product ID "12345"
Then Admin1 accesses the catalog management section
@TC-95
Scenario: Admin2 navigates to the catalog management section
When Admin2 navigates to the catalog management section with URL "/admin/catalog"
Then Admin2 accesses the catalog management section
@TC-95
Scenario: Admin1 attempts to delete a product
When Admin1 attempts to delete a product
Then Admin1 sees a confirmation dialog for deletion
@TC-95
Scenario: Admin2 attempts to edit the same product
When Admin2 simultaneously attempts to edit the same product
Then Admin2 receives a notification of ongoing deletion and cannot edit
@TC-95
Scenario: Admin1 confirms the deletion
When Admin1 confirms the deletion
Then the product is successfully deleted
@TC-95
Scenario: Admin2 verifies the product is no longer available for editing
When Admin2 verifies the product
Then the product is not found in the catalog
@TC-95
Scenario: Check for error messages or alerts during concurrent actions
When checking for error messages or alerts during concurrent actions
Then no error messages or alerts are displayed
@TC-95
Scenario: Verify audit logs for concurrent actions
When verifying audit logs for concurrent actions
Then audit logs show both admin actions with timestamps
@TC-95
Scenario: Review system performance during concurrent actions
When reviewing system performance during concurrent actions
Then system performance remains stable and unaffected
@TC-95
Scenario: Ensure no data inconsistency due to concurrent actions
When ensuring data consistency during concurrent actions
Then data remains consistent and accurate
@TC-95
Scenario: Check for automatic notifications regarding concurrent actions
When checking for automatic notifications regarding concurrent actions
Then notifications are sent to relevant stakeholders if applicable
@TC-95
Scenario: Verify system scalability under concurrent admin actions
When verifying system scalability under concurrent admin actions
Then the system handles concurrent actions smoothly without degradation
@TC-95
Scenario: Attempt concurrent actions on different products
When attempting concurrent actions on different products
Then both actions succeed without interference