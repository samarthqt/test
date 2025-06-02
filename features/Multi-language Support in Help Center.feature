Feature: Multi-language Support in Help Center
@TC-226
Scenario: Navigate to Help Center page
Given the user is logged in
When the user navigates to the Help Center page
Then the Help Center page is displayed
@TC-226
Scenario: Access Help Center with multi-language support
Given the user is on the Help Center page
When the user selects 'English' from the language options
Then the Help Center content is displayed in English
@TC-226
Scenario: Select Spanish language in Help Center
Given the user is on the Help Center page
When the user selects 'Spanish' from the language options
Then the Help Center content is displayed in Spanish
@TC-226
Scenario: Select French language in Help Center
Given the user is on the Help Center page
When the user selects 'French' from the language options
Then the Help Center content is displayed in French
@TC-226
Scenario: Select Chinese language in Help Center
Given the user is on the Help Center page
When the user selects 'Chinese' from the language options
Then the Help Center content is displayed in Chinese
@TC-226
Scenario: Load Help Center content under 3G network condition
Given the network condition is 3G
When the user loads Help Center content
Then the Help Center content loads within acceptable time limits
@TC-226
Scenario: Load Help Center content under 4G network condition
Given the network condition is 4G
When the user loads Help Center content
Then the Help Center content loads within acceptable time limits
@TC-226
Scenario: Load Help Center content under WiFi network condition
Given the network condition is WiFi
When the user loads Help Center content
Then the Help Center content loads within acceptable time limits
@TC-226
Scenario: Verify language selection persistence across sessions
Given the user has selected a language
When the user logs out and logs back in
Then the selected language persists across user sessions
@TC-226
Scenario: Test Help Center accessibility features in different languages
Given the user is on the Help Center page
When the user tests accessibility features in different languages
Then the accessibility features are functional in all languages
@TC-226
Scenario: Check for language translation errors
Given the user is on the Help Center page
When the user reviews the language translations
Then the translations are accurate and error-free
@TC-226
Scenario: Test Help Center responsiveness in different languages
Given the user is on the Help Center page
When the user tests responsiveness in different languages
Then the Help Center is responsive in all languages
@TC-226
Scenario: Verify content synchronization in different languages
Given the user is on the Help Center page
When the user checks content synchronization across languages
Then the content is synchronized and consistent across languages
@TC-226
Scenario: Attempt to access Help Center with unsupported language
Given the user is on the Help Center page
When the user selects an unsupported language
Then the system displays an error message for unsupported language
@TC-226
Scenario: Test Help Center language selection with expired session
Given the user is on the Help Center page
When the user's session expires
Then the system prompts the user to re-login and select language again