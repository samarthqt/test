Feature: Agile Testing Page Functionality
@TC-31
Scenario: Verify opening a new browser window and navigating to the Agile Testing page
Given the user opens a new browser window
When the user enters the URL "http://www.qasymphony.com/platform.html"
Then the Agile Testing page should be displayed
@TC-31
Scenario: Navigate to Agile Testing sub-menu
Given the user is on the Agile Testing page
When the user clicks on the "Agile Testing" sub-menu
Then the Agile Testing sub-menu should be displayed
@TC-31
Scenario: Call Get Free Trial from Agile Testing page
Given the user is on the Agile Testing page
When the user calls Get Free Trial
Then the Get Free Trial process should be initiated
@TC-31
Scenario: Click on Scale Agile section content or Learn More button
Given the user is on the Agile Testing page
When the user clicks on the content or Learn More button of the Scale Agile section
Then the Scale Agile section details should be displayed
@TC-31
Scenario: Click on eXplorer Testing section content or Learn More button
Given the user is on the Agile Testing page
When the user clicks on the content or Learn More button of the eXplorer Testing section
Then the eXplorer Testing section details should be displayed
@TC-31
Scenario: Click on Distributed Team section content or Learn More button
Given the user is on the Agile Testing page
When the user clicks on the content or Learn More button of the Distributed Team section
Then the Distributed Team section details should be displayed
@TC-31
Scenario: Click on Integration & APIs section content or Learn More button
Given the user is on the Agile Testing page
When the user clicks on the content or Learn More button of the Integration & APIs section
Then the Integration & APIs section details should be displayed