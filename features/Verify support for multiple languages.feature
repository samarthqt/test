Feature: Verify support for multiple languages
@TC-27
Scenario: Verify user can log in to the application
Given the user is on the login page
When the user logs in with valid credentials
Then the user is successfully logged in
@TC-27
Scenario: Verify user can access language settings
Given the user is logged in
When the user navigates to the language settings page
Then the language settings page is displayed
@TC-27
Scenario: Verify language selection updates
Given the user is on the language settings page
When the user selects a different language from the default
Then the language selection is updated
@TC-27
Scenario: Verify application interface updates to selected language
Given the user has selected a different language
When the user navigates through the application
Then the application interface is displayed in the selected language
@TC-27
Scenario: Verify menu items translation
Given the application interface is displayed in the selected language
When the user checks the menu items
Then all menu items are correctly translated
@TC-27
Scenario: Verify error messages translation
Given the application interface is displayed in the selected language
When an error occurs
Then error messages are displayed in the selected language
@TC-27
Scenario: Verify help and support sections translation
Given the application interface is displayed in the selected language
When the user accesses help and support sections
Then help and support sections are correctly translated
@TC-27
Scenario: Verify user-submitted content remains in original language
Given the application interface is displayed in the selected language
When the user views user-submitted content
Then user-submitted content remains in the original language
@TC-27
Scenario: Verify language persists after re-login
Given the user has selected a language
When the user logs out and logs back in
Then the selected language persists after re-login
@TC-27
Scenario: Verify language selection consistency across devices
Given the user has selected a language
When the user accesses the application on different devices
Then language settings are consistent across different devices
@TC-27
Scenario: Verify language selection consistency across browsers
Given the user has selected a language
When the user accesses the application on different browsers
Then language settings are consistent across different browsers
@TC-27
Scenario: Verify language selection accessibility on mobile app
Given the user has selected a language
When the user accesses the mobile app
Then language settings are accessible on the mobile app
@TC-27
Scenario: Verify no missing translations in selected language
Given the application interface is displayed in the selected language
When the user navigates through the application
Then there are no missing translations in the selected language
@TC-27
Scenario: Verify application performance unaffected by language selection
Given the user has selected a language
When the user uses the application
Then application performance remains unaffected by language selection
@TC-27
Scenario: Verify language can be switched back to default
Given the user has selected a language
When the user switches back to the default language
Then the language can be switched back to the default successfully