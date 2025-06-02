Feature: Verify Search Suggestions and Autocomplete Functionality
@TC-144
Scenario: Ensure search bar is visible on the homepage
Given the user is logged into the application
When the user navigates to the homepage of the application
Then the homepage is displayed with a visible search bar
@TC-144
Scenario: Verify search suggestions for the keyword 'laptop'
Given the user is on the homepage
When the user clicks on the search bar
And types 'laptop' into the search bar
Then search suggestions related to 'laptop' are displayed below the search bar
@TC-144
Scenario: Select an autocomplete suggestion for 'laptop'
Given search suggestions for 'laptop' are displayed
When the user selects one of the autocomplete suggestions
Then the selected suggestion is populated in the search bar
And search results are displayed
@TC-144
Scenario Outline: Verify autocomplete suggestions for various keywords
Given the user is on the homepage
When the user types "<keyword>" into the search bar
Then autocomplete suggestions related to "<keyword>" are displayed
When the user selects one of the autocomplete suggestions
Then the selected suggestion is populated in the search bar
And search results are displayed
Examples:
| keyword    |
| phone      |
| tablet     |
| headphones |
| camera     |
@TC-144
Scenario: Verify relevance of suggestions
Given the user is on the homepage
When the user types 'laptop' into the search bar
Then suggestions are relevant and match the initial input
@TC-144
Scenario: Check performance of autocomplete by typing quickly
Given the user is on the homepage
When the user types a keyword quickly into the search bar
Then autocomplete suggestions appear swiftly without delay
@TC-144
Scenario: Test autocomplete with partial keywords
Given the user is on the homepage
When the user types a partial keyword into the search bar
Then suggestions appear even with partial input
@TC-144
Scenario: Verify dynamic update of suggestions
Given the user is on the homepage
When the user types a keyword into the search bar
Then suggestions dynamically update and refine as more characters are input
@TC-144
Scenario: Ensure selecting a suggestion executes the search
Given the user is on the homepage
When the user selects an autocomplete suggestion
Then the selected suggestion populates the search bar
And search results are displayed
@TC-144
Scenario: Check clickable suggestions lead to correct search results
Given the user is on the homepage
When the user clicks on a suggestion
Then it leads to correct search results
@TC-144
Scenario: Verify display of suggestions on different devices
Given the user is on the homepage
When the user types a keyword into the search bar on different devices
Then suggestions display correctly across mobile, tablet, and desktop
@TC-144
Scenario: Test autocomplete with special characters
Given the user is on the homepage
When the user types a keyword with special characters into the search bar
Then autocomplete handles special characters correctly and provides suggestions
@TC-144
Scenario: Validate relevance of autocomplete suggestions
Given the user is on the homepage
When the user types a keyword into the search bar
Then autocomplete does not suggest irrelevant or unrelated items
@TC-144
Scenario: Check if autocomplete respects user privacy settings
Given the user is on the homepage
When the user types a keyword into the search bar
Then autocomplete function operates within user privacy settings