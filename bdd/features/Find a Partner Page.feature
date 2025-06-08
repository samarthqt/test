Feature: Find a Partner Page
@TC-21
Scenario: Verify the Find a Partner page is accessible
Given a new browser window is opened
When the user enters "http://www.qasymphony.com/partners.html" in the URL bar
Then the Find a Partner page should be displayed
@TC-21
Scenario: Verify the functionality of the Find a Partner button
Given the Find a Partner page is displayed
When the user clicks on the "Find a Partner" button
Then the relevant partner information should be displayed