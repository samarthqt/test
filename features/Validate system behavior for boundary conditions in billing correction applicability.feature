Feature: Validate system behavior for boundary conditions in billing correction applicability

  Ensure the system accurately handles correction requests at the exact boundaries of billing correction applicability.

  @TC-108
  Scenario Outline: Validate correction request submission for boundary conditions
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user navigates to the billing correction module
    And the user selects the option to create a new correction request
    And the user enters the document type "<Document Type>"
    And the user provides the output type "<Output Type>"
    And the user attaches the billing document "<Billing Document>"
    And the user submits the correction request
    Then the system processes the correction request and generates a confirmation message "<Confirmation Message>"
    And the output is generated correctly and aligns with the defined boundary conditions

    Examples:
      | Document Type | Output Type | Billing Document | Confirmation Message                  |
      | BCR050        | OT050       | BD050            | Correction request processed successfully |

  @TC-108
  Scenario: Validate document flow for a boundary condition correction request
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user navigates to the document flow for the correction request
    Then the document flow displays accurate linkage to the original billing document

  @TC-108
  Scenario: Validate all fields and conditions for boundary requirements
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user validates all fields and conditions for the correction request
    Then all fields and conditions meet the defined boundary requirements

  @TC-108
  Scenario: Validate user logout from the system
    Given the user is logged into the SAP S/4HANA Cloud system
    When the user logs out of the system
    Then the user is successfully logged out