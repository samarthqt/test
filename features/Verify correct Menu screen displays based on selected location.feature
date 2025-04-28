Feature: Verify correct Menu screen displays based on selected location
Scenario: Display correct Menu screen for selected location
Given the user is logged into the system
And multiple locations are configured in the system
When the user navigates to the location selection screen
Then the location selection screen is displayed
Scenario Outline: Select location and verify Menu screen
When the user selects "<Location>" from the list
And confirms the selection
Then a confirmation message is displayed
And the Menu screen for "<Location>" is displayed
And the menu items correspond to the selected location
And the layout and design are consistent with the selected location
And all buttons and links work as expected
And the selected location name is displayed on the screen
And no error messages or alerts are shown
Examples:
| Location   |
| Location A |
| Location B |
| Location C |
Scenario: Verify persistence of location selection after re-login
Given the user has selected a location
When the user logs out and logs back in
Then the selected location is persistent after re-login
Scenario: Change location and verify Menu screen updates
Given the user has selected a location
When the user changes the location
Then the Menu screen updates according to the new location
Scenario: Test with a location having no specific menu
Given the user selects a location with no specific menu
Then a default menu or appropriate message is displayed
Scenario: Check accessibility features on the Menu screen
Given the user is on the Menu screen
Then accessibility features are present and functional