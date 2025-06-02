Feature: Functionality Check on Outdated Browsers
@TC-349
Scenario: Open the application in Internet Explorer 11
Given the application is deployed on the stage environment
When the application is opened in Internet Explorer 11
Then the application loads with functionality issues
@TC-349
Scenario: Attempt navigation through the homepage using Firefox 45
Given the application is opened in Firefox 45
When navigating through the homepage
Then homepage elements are not displayed correctly
@TC-349
Scenario: Click on various links and buttons using Chrome 49
Given the application is opened in Chrome 49
When clicking on various links and buttons
Then some links and buttons do not function as expected
@TC-349
Scenario: Repeat steps 1-3 using Firefox 45
Given the application is opened in Firefox 45
When repeating steps 1-3
Then the application functions incorrectly with UI distortions
@TC-349
Scenario: Repeat steps 1-3 using Chrome 49
Given the application is opened in Chrome 49
When repeating steps 1-3
Then the application functions incorrectly with UI distortions
@TC-349
Scenario: Check for console errors during navigation
Given the application is opened in an outdated browser
When navigating through the application
Then critical console errors are present
@TC-349
Scenario: Verify CSS styles are applied incorrectly
Given the application is opened in an outdated browser
When verifying CSS styles
Then CSS styles are inconsistent across outdated browsers
@TC-349
Scenario: Test form submissions on outdated browsers
Given the application is opened in an outdated browser
When testing form submissions
Then forms do not submit successfully
@TC-349
Scenario: Check for responsive design elements on outdated browsers
Given the application is opened in an outdated browser
When checking for responsive design elements
Then responsive design elements do not adjust correctly
@TC-349
Scenario: Test media content loading such as images and videos
Given the application is opened in an outdated browser
When testing media content loading
Then media content does not load correctly
@TC-349
Scenario: Verify interactive elements such as sliders and dropdowns
Given the application is opened in an outdated browser
When verifying interactive elements
Then interactive elements do not function correctly
@TC-349
Scenario: Check for any deprecated HTML/CSS features
Given the application is opened in an outdated browser
When checking for deprecated HTML/CSS features
Then the application relies on deprecated features
@TC-349
Scenario: Test accessibility features on outdated browsers
Given the application is opened in an outdated browser
When testing accessibility features
Then accessibility features are not functional
@TC-349
Scenario: Verify compatibility with JavaScript functions
Given the application is opened in an outdated browser
When verifying JavaScript functions
Then JavaScript functions do not execute correctly
@TC-349
Scenario: Check for browser-specific warnings or suggestions
Given the application is opened in an outdated browser
When checking for browser-specific warnings or suggestions
Then browser-specific warnings are shown