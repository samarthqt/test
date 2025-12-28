Feature: Verify system behavior when billing plan linkage is incorrect

  @TC-567
  Scenario Outline: Validate milestone management with incorrect billing plan linkage
    Given the user logs into the SAP S/4HANA Cloud system using "<username>" and "<password>"
    When the user navigates to the milestone management module
    And the user searches for the milestone ID "<milestone_id>"
    And the user marks the milestone as "Achieved"
    Then the system should not create a Periodic Billing order
    And the system logs should display appropriate error messages indicating incorrect billing plan linkage
    And the user documents the test results

    Examples:
      | username      | password       | milestone_id | billing_plan_id |
      | TestUser03    | TestPassword03 | MILE003      | BP002           |