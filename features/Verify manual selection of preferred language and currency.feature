Feature: Verify manual selection of preferred language and currency
@TC-281
Scenario: Ensure users can manually select their preferred language and currency
Given the user is logged into the application
When the user navigates to the user settings page
Then the user settings page is displayed
And language options are available: English, Spanish, French
And currency options are available: USD, EUR, GBP
@TC-281
Scenario: Select Spanish language and EUR currency
Given the language dropdown is visible
When the user selects 'Spanish' from the language dropdown
Then the language is set to Spanish
And the currency dropdown is visible
When the user selects 'EUR' from the currency dropdown
Then the currency is set to EUR
And the user saves the changes
Then the changes are saved successfully
@TC-281
Scenario: Verify settings after page refresh
When the user refreshes the page
Then the settings remain unchanged
And the language is Spanish
And the currency is EUR
@TC-281
Scenario: Verify home page language and currency
When the user navigates to the home page
Then the home page is displayed in Spanish
And prices are shown in EUR
@TC-281
Scenario: Verify product prices and help section
When checking products listed on the page
Then product prices are displayed in EUR
When the user accesses the help section
Then the help section is displayed in Spanish
@TC-281
Scenario: Persist settings after logout and login
When the user logs out and logs back in
Then the language and currency settings persist
And the language is Spanish
And the currency is EUR
@TC-281
Scenario: Switch to French language and GBP currency
When the user switches to 'French' and 'GBP'
Then the language is set to French
And the currency is set to GBP
@TC-281
Scenario: Verify changes after switching language and currency
When the user repeats navigation steps to verify changes
Then all pages display in French
And prices are shown in GBP
@TC-281
Scenario: Verify notifications in selected language
When checking if notifications are in the selected language
Then notifications are displayed in French
@TC-281
Scenario: Revert settings to default
When the user attempts to change settings back to default
Then settings revert to default language and currency