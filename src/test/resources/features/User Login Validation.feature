Feature: User Login Validation

  @TC-44
  Scenario Outline: Invalid User Login
    Given the user navigates to the login page
    When the user enters "<username>" and "<password>"
    And the user selects the 'Login' option
    Then an error message is displayed indicating incorrect credentials

    Examples:
      | username     | password      |
      | invalidUser  | wrongPassword |