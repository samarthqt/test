Feature: Verify automatic creation of Periodic Billing order upon milestone achievement

  @TC-565
  Scenario Outline: Ensure the system automatically creates a Periodic Billing order when a milestone is marked as 'Achieved'
    Given the user logs into the SAP S/4HANA Cloud system using "<username>" and "<password>"
    When the user navigates to the milestone management module
    And the user searches for the milestone ID "<milestoneID>"
    And the user marks the milestone as "<milestoneStatus>"
    Then the system should trigger the creation of a Periodic Billing order
    And the user navigates to the billing document overview section
    And the user searches for the newly created billing order using the milestone ID "<milestoneID>"
    Then the billing order should be displayed
    And the document type of the billing order should be "<documentType>"
    And the billing order should be correctly linked to the milestone and billing plan "<billingPlanID>"
    And the billing order should be available for subsequent billing steps

    Examples:
      | username       | password         | milestoneID | milestoneStatus | documentType | billingPlanID |
      | TestUser01     | TestPassword01   | MILE001     | Achieved        | ZPB          | BP001         |

  @TC-565
  Scenario: Verify user logs out of the SAP system
    Given the user is logged into the SAP system
    When the user logs out of the system
    Then the user is successfully logged out

  @TC-565
  Scenario: Verify test results are documented
    Given the test execution is complete
    When the user documents the test results
    Then the test results are documented successfully