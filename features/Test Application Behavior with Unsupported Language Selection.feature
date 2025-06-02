Feature: Test Application Behavior with Unsupported Language Selection
@TC-107
Scenario: Navigate to user settings page
Given User is logged into the application
When User navigates to the user settings page
Then User settings page is displayed
And Language selection feature is enabled
@TC-107
Scenario: Locate language selection dropdown
Given User is on the user settings page
When User locates the language selection dropdown
Then Language selection dropdown is visible
@TC-107
Scenario: Attempt to select unsupported language 'Klingon'
Given User is viewing the language selection dropdown
When User attempts to select 'Klingon' from the dropdown
Then System does not allow selection of unsupported language
@TC-107
Scenario: Verify error message for unsupported language
Given User attempted to select an unsupported language
When User checks for error messages
Then Appropriate error message is displayed indicating unsupported language
@TC-107
Scenario: Attempt to save changes with unsupported language
Given User has selected an unsupported language
When User attempts to save changes
Then Changes are not saved
And User is prompted to select a supported language
@TC-107
Scenario: Save changes with a supported language
Given User selects a supported language
When User saves changes
Then Changes are saved successfully with a supported language
@TC-107
Scenario: Refresh or navigate to another page
Given User has saved changes with a supported language
When User refreshes the page or navigates to another page
Then Interface text is displayed in the selected supported language
@TC-107
Scenario: Log out and log back into the application
Given User is logged in with a supported language
When User logs out and logs back into the application
Then Login page and subsequent pages are displayed in the selected supported language
@TC-107
Scenario: Attempt to set unsupported language via URL manipulation
Given User is logged in
When User attempts to manually change URL parameters to set an unsupported language
Then System prevents setting of unsupported language via URL manipulation
@TC-107
Scenario: Verify default language setting after unsupported language attempt
Given User attempted to set an unsupported language
When User checks the default language setting
Then System reverts to default language setting
@TC-107
Scenario: Check language settings in user profile
Given User is logged in
When User checks the language settings in the user profile
Then Language settings reflect a supported language
@TC-107
Scenario: Perform a product search
Given User has selected a supported language
When User performs a product search
Then Search results are displayed in the supported language
@TC-107
Scenario: Navigate to the help section
Given User is logged in with a supported language
When User navigates to the help section
Then Help section is displayed in the supported language
@TC-107
Scenario: Attempt to select multiple unsupported languages simultaneously
Given User is on the language selection page
When User attempts to select multiple unsupported languages simultaneously
Then System does not allow selection of multiple unsupported languages
@TC-107
Scenario: Verify system logs for unsupported language selection errors
Given User attempted unsupported language selection
When User verifies system logs
Then System logs indicate handling of unsupported language selection without errors