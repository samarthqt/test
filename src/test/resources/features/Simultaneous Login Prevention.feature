Feature: Simultaneous Login Prevention

  @TC-46
  Scenario Outline: Prevent multiple simultaneous logins from different devices
    Given the user is logged in on one device with username "<username>" and password "<password>"
    When the user attempts to log in from a second device using the same credentials
    Then the system should prevent login and display an error message about simultaneous sessions

    Examples:
      | username   | password          |
      | validUser  | validPassword123  |