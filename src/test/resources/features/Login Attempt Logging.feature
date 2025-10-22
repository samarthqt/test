Feature: Login Attempt Logging

  @TC-47
  Scenario Outline: Verify that login attempts are logged for security monitoring
    Given the user has access to system logs
    When the user logs in with username "<username>" and password "<password>"
    Then the user should be logged in successfully
    And the login attempt should be logged with a timestamp and user details in the system logs

    Examples:
      | username   | password         |
      | validUser  | validPassword123 |