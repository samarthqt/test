Feature: Find a Partner Page
@4
Scenario: Verify Find a Partner page functionality
Given a new browser window is opened
When the user enters the URL "http://www.qasymphony.com/partners.html"
And clicks on the "Find a Partner" button
Then the Find a Partner page should be displayed