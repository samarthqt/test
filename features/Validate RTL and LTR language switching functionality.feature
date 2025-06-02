Feature: Validate RTL and LTR language switching functionality
Ensure that the application correctly switches between right-to-left (RTL) and left-to-right (LTR) languages without loss of functionality. The application supports multiple languages, including at least one RTL language.
@TC-108
Scenario: Navigate to the language settings in the application
Given the user is logged into the application
When the user navigates to the language settings
Then the language settings screen is displayed
@TC-108
Scenario: Select English (LTR) as the current language
Given the user is on the language settings screen
When the user selects English (LTR) as the current language
Then the application interface updates to display in English
@TC-108
Scenario: Verify LTR text alignment and interface
Given the application interface is in English (LTR)
Then all text is aligned to the left
And navigation is from left to right
@TC-108
Scenario: Switch language setting to Arabic (RTL)
Given the user is on the language settings screen
When the user switches the language setting to Arabic (RTL)
Then the application interface updates to display in Arabic
@TC-108
Scenario: Verify RTL text alignment and interface
Given the application interface is in Arabic (RTL)
Then all text is aligned to the right
And navigation is from right to left
@TC-108
Scenario: Navigate through application modules in RTL mode
Given the application interface is in Arabic (RTL)
When the user navigates through different application modules
Then all modules are accessible and display correctly in RTL format
@TC-108
Scenario: Switch back to English (LTR) and verify the interface
Given the application interface is in Arabic (RTL)
When the user switches back to English (LTR)
Then the application returns to LTR format with no loss of functionality
@TC-108
Scenario: Check user data consistency after language switch
Given the application interface is switched between languages
Then all user data remains consistent and accessible
@TC-108
Scenario: Test navigation and functionality in both RTL and LTR modes
Given the application supports both RTL and LTR modes
Then navigation and functionality remain intact in both modes
@TC-108
Scenario: Verify language persistence after logout and login
Given the user is logged into the application
When the user logs out and logs back in
Then the selected language persists after logout and login
@TC-108
Scenario: Test input fields for correct text direction in both modes
Given the application supports both RTL and LTR modes
Then input fields reflect the correct text direction based on language setting
@TC-108
Scenario: Verify error messages and alerts in both RTL and LTR languages
Given the application supports both RTL and LTR modes
Then error messages and alerts are displayed correctly in the selected language
@TC-108
Scenario: Check application responsiveness and layout integrity during language switch
Given the application supports language switching
Then application layout remains responsive and intact during and after language switch
@TC-108
Scenario: Test language switch on different devices and screen sizes
Given the application supports language switching
Then language switch functions correctly across various devices and screen sizes
@TC-108
Scenario: Verify language switch does not affect session or security settings
Given the application supports language switching
Then session and security settings remain unaffected by language switch