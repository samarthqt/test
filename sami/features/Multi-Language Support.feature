Feature: Multi-Language Support
""
In order to enhance user experience
As a user
I want to be able to view the site in multiple languages
""
Background:
Given the site supports multiple languages
""
Scenario Outline: Change site language
Given the user is on the homepage
"    When the user selects ""<Language>"" from the language dropdown"
"    Then the site should display content in ""<Language>"""
""
Examples:
| Language  |
| English   |
| Spanish   |
| French    |
| German    |
| Chinese   |
| Japanese  |
""
Scenario: Verify default language
Given the user is on the homepage
Then the site should display content in English by default
""
Scenario: Remember user language preference
"    Given the user selects ""Spanish"" from the language dropdown"
And the user navigates to another page
Then the site should continue to display content in Spanish
""
Scenario: Language switch reflects on all pages
"    Given the user selects ""French"" from the language dropdown"
"    When the user navigates to the ""Contact Us"" page"
"    Then the ""Contact Us"" page should display content in French"
""
Scenario: Verify language switch availability
Given the user is on the homepage
Then the language dropdown should be visible
""
Scenario: Validate language switch functionality
"    Given the user selects ""German"" from the language dropdown"
When the user refreshes the page
Then the site should continue to display content in German
```
```gherkin
TCID:29