Feature: Verify system behavior when milestone is marked as 'Achieved' without prior configuration

  @TC-566
  Scenario Outline: User marks milestone as 'Achieved' and verifies system behavior
    Given the user logs into the SAP S/4HANA Cloud system using "<username>" and "<password>"
    And the user navigates to the milestone management module
    When the user searches for the milestone ID "<milestoneID>"
    And the user marks the milestone as 'Achieved'
    Then the system should not create a Periodic Billing order
    And the system logs should display error messages indicating "<errorMessage>"
    And the user documents the test results

    Examples:
      | username      | password        | milestoneID | errorMessage                          |
      | TestUser02    | TestPassword02  | MILE002     | Missing configuration for milestone   |