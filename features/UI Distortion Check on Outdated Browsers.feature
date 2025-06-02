Feature: UI Distortion Check on Outdated Browsers
@TC-348
Scenario: Open application in Internet Explorer 11 without UI distortions
Given the application is deployed on the stage environment
When I open the application in Internet Explorer 11
Then the application loads without UI distortions
@TC-348
Scenario: Navigate homepage in Firefox 45 without layout issues
Given the application is open in Firefox 45
When I navigate through the homepage
Then homepage elements are displayed correctly without overlapping
@TC-348
Scenario: Test functionality of links and buttons in Chrome 49
Given the application is open in Chrome 49
When I click on various links and buttons
Then all links and buttons function as expected
@TC-348
Scenario: Repeat steps in Firefox 45 without UI distortions
Given the steps 1-3 are repeated using Firefox 45
Then the application functions correctly without UI distortions
@TC-348
Scenario: Repeat steps in Chrome 49 without UI distortions
Given the steps 1-3 are repeated using Chrome 49
Then the application functions correctly without UI distortions
@TC-348
Scenario: Check for console errors during navigation
Given the application is open in an outdated browser
When I navigate through the application
Then no critical console errors are present
@TC-348
Scenario: Verify CSS styles on outdated browsers
Given the application is open in an outdated browser
When I observe the CSS styles
Then CSS styles are consistent across outdated browsers
@TC-348
Scenario: Test form submissions on outdated browsers
Given the application is open in an outdated browser
When I submit forms
Then forms submit successfully without errors
@TC-348
Scenario: Check responsive design elements on outdated browsers
Given the application is open in an outdated browser
When I observe responsive design elements
Then responsive design elements adjust correctly
@TC-348
Scenario: Test media content loading on outdated browsers
Given the application is open in an outdated browser
When I load media content such as images and videos
Then media content loads without distortion or error
@TC-348
Scenario: Verify interactive elements on outdated browsers
Given the application is open in an outdated browser
When I interact with elements such as sliders and dropdowns
Then interactive elements function correctly
@TC-348
Scenario: Check for deprecated HTML/CSS features
Given the application is open in an outdated browser
When I check for HTML/CSS features
Then the application does not rely on deprecated features
@TC-348
Scenario: Test accessibility features on outdated browsers
Given the application is open in an outdated browser
When I test accessibility features
Then accessibility features are functional
@TC-348
Scenario: Verify compatibility with JavaScript functions
Given the application is open in an outdated browser
When I execute JavaScript functions
Then JavaScript functions execute correctly
@TC-348
Scenario: Check for browser-specific warnings or suggestions
Given the application is open in an outdated browser
When I observe for warnings or suggestions
Then no browser-specific warnings are shown