Feature: Valid User Login

  @TC-43
  Scenario Outline: User logs in with valid credentials
    Given the user navigates to the login page
    When the user enters a username "<username>" and password "<password>"
    And the user selects the 'Login' option
    Then the user is redirected to the dashboard
    And the user dashboard is displayed with user-specific content

    Examples:
      | username   | password          |
      | validUser  | validPassword123  |