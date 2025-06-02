Feature: Admin Customization of Confirmation Messages
@TC-184
Scenario: Verify Admin can customize confirmation messages
Given the admin has access to the system
When the admin logs in to the admin panel using valid admin credentials
Then the admin is successfully logged into the system
When the admin navigates to the settings section of the admin panel
Then the settings section is displayed
When the admin locates the confirmation message customization options
Then the customization options for confirmation messages are visible
When the admin selects a confirmation message template to customize
Then the selected template is ready for customization
When the admin modifies the text of the confirmation message
Then the text of the confirmation message is updated
When the admin changes the font style of the confirmation message
Then the font style is successfully changed
When the admin updates the color scheme of the confirmation message
Then the color scheme is updated as per the selection
When the admin saves the changes made to the confirmation message
Then the changes are saved successfully
When the admin previews the customized confirmation message
Then the preview shows the updated confirmation message with all applied customizations
When the admin reverts the changes to the default confirmation message settings
Then the confirmation message is reverted to default settings
When the admin logs out from the admin panel
Then the admin is logged out successfully
@TC-184
Scenario: Verify customized confirmation message is displayed to a regular user
Given the admin has customized the confirmation message
When a regular user logs in and performs an action that triggers a confirmation message
Then the customized confirmation message is displayed to the user
When the user verifies the content, font, and color of the confirmation message
Then the confirmation message matches the customizations made by the admin
When the user checks if the confirmation message is clear and understandable
Then the confirmation message is clear and provides necessary information
When the user ensures that the confirmation message is appropriately aligned and formatted
Then the confirmation message is well-aligned and formatted correctly