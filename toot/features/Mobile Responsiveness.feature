Feature: Mobile Responsiveness
""
As a user, I want the website to be fully functional on mobile devices to ensure a seamless user experience.
""
Background:
Given the website is deployed and accessible
""
@mobile
Scenario Outline: Verify website responsiveness on different mobile devices
"    Given I am using a ""<device>"" with ""<resolution>"" resolution"
When I navigate to the homepage
Then the website should load without any layout issues
And all interactive elements should be functional
And the navigation menu should be accessible and functional
And the content should be readable without zooming
""
Examples:
| device            | resolution  |
| iPhone 12         | 1170x2532   |
| Samsung Galaxy S21| 1080x2400   |
| iPad Pro          | 2048x2732   |
""
@mobile
Scenario: Verify website responsiveness on portrait and landscape orientations
Given I am using a mobile device
When I view the website in portrait orientation
Then the website should display correctly without horizontal scrolling
When I switch to landscape orientation
Then the website should adjust and display correctly without vertical scrolling
""
@mobile
Scenario: Verify touch interactions are functional
Given I am using a mobile device
When I tap on a button or link
Then the corresponding action should be performed
And there should be no delay in response
""
@mobile
Scenario: Verify form inputs are usable on mobile
Given I am using a mobile device
When I focus on a text input field
Then the on-screen keyboard should appear
And I should be able to enter text without issues
""
@mobile
Scenario: Verify media content is accessible on mobile
Given I am using a mobile device
When I play a video or audio file
Then the media should play smoothly
And the controls should be accessible and functional
```
```gherkin
TCID:34