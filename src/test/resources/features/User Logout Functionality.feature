Feature: User Logout Functionality

  @TC-45
  Scenario: User logs out and is redirected to the login page
    Given the user is logged in
    When the user selects the 'Logout' option
    Then the user is logged out
    And the user is redirected to the login page

  @TC-45
  Scenario: User attempts to access the dashboard without logging in
    Given the user is logged out
    When the user attempts to access the dashboard
    Then access is denied
    And the login page is prompted