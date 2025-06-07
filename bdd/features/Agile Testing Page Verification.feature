Feature: Agile Testing Page Verification
@TC-31
Scenario: Verify the Agile Testing page is accessible
Given a new browser window is opened
When the user enters the URL "http://www.qasymphony.com/platform.html"
Then the platform page should be displayed
When the user clicks on the "Agile Testing" sub-menu
Then the Agile Testing page should be displayed