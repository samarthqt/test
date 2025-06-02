Feature: Edge Case Testing on Outdated Browsers
@TC-350
Scenario: Open the application in Internet Explorer 11 with network throttling
Given the application is deployed on the stage environment
When I open the application in Internet Explorer 11 with network throttling
Then the application should load with potential UI distortions
@TC-350
Scenario: Navigate through the homepage with low resolution settings
Given I am using Firefox 45
When I navigate through the homepage with low resolution settings
Then homepage elements may overlap or misalign
@TC-350
Scenario: Test functionality with JavaScript disabled
Given I am using Chrome 49
When I test the functionality with JavaScript disabled
Then some functionalities may not work as expected
@TC-350
Scenario Outline: Repeat steps 1-3 using different browsers
Given I am using <browser>
When I perform steps 1-3
Then the application may exhibit unexpected behavior
Examples:
| browser  |
| Firefox 45 |
| Chrome 49  |
@TC-350
Scenario: Check for console errors with network throttling
Given the application is running with network throttling
When I check the console
Then console may show errors related to loading resources
@TC-350
Scenario: Verify CSS styles under low resolution settings
Given I am using low resolution settings
When I verify CSS styles
Then CSS styles may not be applied correctly
@TC-350
Scenario: Test form submissions with JavaScript disabled
Given I have JavaScript disabled
When I test form submissions
Then forms may not submit successfully
@TC-350
Scenario: Check responsive design elements with network throttling
Given the application is running with network throttling
When I check responsive design elements
Then responsive elements may not adjust correctly
@TC-350
Scenario: Test media content loading with low resolution settings
Given I am using low resolution settings
When I test media content loading
Then media content may not load correctly
@TC-350
Scenario: Verify interactive elements with JavaScript disabled
Given I have JavaScript disabled
When I verify interactive elements
Then interactive elements may not function correctly
@TC-350
Scenario: Check for deprecated HTML/CSS features under network throttling
Given the application is running with network throttling
When I check for deprecated HTML/CSS features
Then the application may rely on deprecated features
@TC-350
Scenario: Test accessibility features with low resolution settings
Given I am using low resolution settings
When I test accessibility features
Then accessibility features may not be functional
@TC-350
Scenario: Verify compatibility with JavaScript functions under network throttling
Given the application is running with network throttling
When I verify compatibility with JavaScript functions
Then JavaScript functions may not execute correctly
@TC-350
Scenario: Check for browser-specific warnings with low resolution settings
Given I am using low resolution settings
When I check for browser-specific warnings
Then browser-specific warnings may be shown