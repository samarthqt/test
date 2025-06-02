Feature: Test UI adaptability on devices with extreme screen sizes and resolutions
@TC-360
Scenario: Launch the application on Device 1
Given Device 1 with screen size 4 inches and resolution 640x480
When I launch the application
Then the application UI should load correctly without any distortion
@TC-360
Scenario: Navigate through the main menu on Device 1
Given Device 1 with screen size 4 inches and resolution 640x480
When I navigate through the main menu
Then all menu items should be visible and accessible
@TC-360
Scenario: Adjust screen brightness and contrast settings on Device 1
Given Device 1 with screen size 4 inches and resolution 640x480
When I adjust the screen brightness and contrast settings
Then UI elements should remain visible and distinguishable
@TC-360
Scenario: Perform a swipe gesture on the main screen of Device 1
Given Device 1 with screen size 4 inches and resolution 640x480
When I perform a swipe gesture on the main screen
Then the swipe gesture should be recognized and executed smoothly
@TC-360
Scenario: Launch the application on Device 2
Given Device 2 with screen size 12 inches and resolution 3840x2160
When I launch the application
Then the application UI should load correctly without any distortion
@TC-360
Scenario: Navigate through the main menu on Device 2
Given Device 2 with screen size 12 inches and resolution 3840x2160
When I navigate through the main menu
Then all menu items should be visible and accessible
@TC-360
Scenario: Adjust screen brightness and contrast settings on Device 2
Given Device 2 with screen size 12 inches and resolution 3840x2160
When I adjust the screen brightness and contrast settings
Then UI elements should remain visible and distinguishable
@TC-360
Scenario: Perform a swipe gesture on the main screen of Device 2
Given Device 2 with screen size 12 inches and resolution 3840x2160
When I perform a swipe gesture on the main screen
Then the swipe gesture should be recognized and executed smoothly
@TC-360
Scenario: Launch the application on Device 3
Given Device 3 with screen size 6 inches and resolution 1440x2560
When I launch the application
Then the application UI should load correctly without any distortion
@TC-360
Scenario: Navigate through the main menu on Device 3
Given Device 3 with screen size 6 inches and resolution 1440x2560
When I navigate through the main menu
Then all menu items should be visible and accessible
@TC-360
Scenario: Adjust screen brightness and contrast settings on Device 3
Given Device 3 with screen size 6 inches and resolution 1440x2560
When I adjust the screen brightness and contrast settings
Then UI elements should remain visible and distinguishable
@TC-360
Scenario: Perform a swipe gesture on the main screen of Device 3
Given Device 3 with screen size 6 inches and resolution 1440x2560
When I perform a swipe gesture on the main screen
Then the swipe gesture should be recognized and executed smoothly
@TC-360
Scenario: Check application's responsiveness to screen rotation on all devices
Given devices with extreme screen sizes and resolutions
When I rotate the screen to portrait and landscape orientations
Then UI should adapt without loss of functionality
@TC-360
Scenario: Verify accessibility and functionality of interactive elements on all devices
Given devices with extreme screen sizes and resolutions
When I interact with buttons, sliders, and input fields
Then all interactive elements should be operable and responsive
@TC-360
Scenario: Assess application's performance under varied screen resolutions
Given devices with extreme screen sizes and resolutions
When I operate the application
Then the application should run smoothly without lag or crashes