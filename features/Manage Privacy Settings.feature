Feature: Manage Privacy Settings
@TC-33
Scenario: Verify users can manage privacy settings, including data sharing permissions
Given the user is logged into the application
And the user has existing privacy settings
When the user navigates to the user settings page
Then the user settings page is displayed
@TC-33
Scenario: Verify privacy settings options are displayed
Given the user is on the user settings page
When the user clicks on 'Privacy Settings'
Then the privacy settings options are displayed
@TC-33
Scenario: Enable data sharing and set privacy level to high
Given the privacy settings options are displayed
When the user selects 'Data Sharing' option
And the user enables data sharing
And the user sets privacy level to 'High'
And the user clicks 'Save Changes'
Then the changes are saved successfully
And a confirmation message 'Privacy settings updated successfully' is displayed
@TC-33
Scenario: Verify privacy settings persist after logout
Given the user has updated privacy settings
When the user logs out and logs back in
And the user navigates back to 'Privacy Settings'
Then the privacy settings reflect the updated preferences
@TC-33
Scenario: Attempt to disable data sharing without saving
Given the user is on the privacy settings page
When the user attempts to disable data sharing without saving
Then no changes occur without saving
@TC-33
Scenario: Ensure privacy settings are not editable by unauthorized users
Given an unauthorized user is logged into the application
When the unauthorized user attempts to edit privacy settings
Then the unauthorized user cannot edit privacy settings
@TC-33
Scenario: Check system logs for data sharing activity
Given the user has enabled data sharing
When the system logs are checked
Then the logs reflect data sharing activity accurately
@TC-33
Scenario: Verify data protection compliance
When the system is evaluated for data protection compliance
Then the system complies with data protection regulations
@TC-33
Scenario: Attempt to change privacy settings with a lower privilege account
Given a user with a lower privilege account is logged into the application
When the user attempts to change privacy settings
Then changes are not allowed with lower privilege accounts
@TC-33
Scenario: Test system response to conflicting privacy settings
Given conflicting privacy settings are introduced
When the system processes the settings
Then the system resolves conflicts appropriately