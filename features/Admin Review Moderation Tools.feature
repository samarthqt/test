Feature: Admin Review Moderation Tools
@TC-152
Scenario: Navigate to the admin dashboard
Given the admin user is logged into the system
When the admin navigates to the admin dashboard
Then the admin dashboard is displayed with options for review moderation
@TC-152
Scenario: Select the 'Reviews' section from the dashboard menu
Given there are existing reviews available for moderation
When the admin selects the 'Reviews' section from the dashboard menu
Then a list of reviews is displayed with options to approve, edit, or delete
@TC-152
Scenario: Select a review with ID 12345
Given the review content is 'Great product!'
When the admin selects a review with ID 12345
Then review details are displayed including content and user information
@TC-152
Scenario: Approve the selected review
Given the admin credentials are admin_user and secure_password
When the admin clicks on 'Approve' for the selected review
Then the review status changes to 'Approved' and is visible to users
@TC-152
Scenario: Edit the review content
When the admin edits the review content to 'Excellent product!' and saves changes
Then the review content is updated successfully
@TC-152
Scenario: Delete the review with ID 12345
When the admin deletes the review with ID 12345
Then the review is removed from the list and no longer visible to users
@TC-152
Scenario: Verify the audit log for actions taken on the review
When the admin verifies the audit log for actions taken on the review
Then the audit log shows entries for approval, edit, and deletion actions
@TC-152
Scenario: Log out from the admin account
When the admin logs out from the admin account
Then the admin is logged out and redirected to the login page
@TC-152
Scenario: Log back into the admin account and navigate to the reviews section
When the admin logs back into the admin account
And navigates to the reviews section
Then the admin can access the reviews section with updated review list
@TC-152
Scenario: Attempt to edit a non-existent review
When the admin attempts to edit a non-existent review
Then the system displays an error message indicating the review does not exist
@TC-152
Scenario: Attempt to delete a review not owned by the admin
When the admin attempts to delete a review not owned by the admin
Then the system restricts action and displays an authorization error
@TC-152
Scenario: Check system response to bulk approval of reviews
When the admin checks system response to bulk approval of reviews
Then the system processes bulk approval without errors and updates statuses
@TC-152
Scenario: Verify review moderation tools are accessible on mobile devices
When the admin verifies review moderation tools on mobile devices
Then admin tools are accessible and functional on mobile interfaces
@TC-152
Scenario: Test the performance of the review moderation tools under high load
When the admin tests the performance of the review moderation tools under high load
Then the system maintains performance and responsiveness under load
@TC-152
Scenario: Ensure changes made by one admin are reflected in real-time for other admins
When changes are made by one admin
Then changes are synchronized in real-time across all admin views