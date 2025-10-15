Feature: Verify the system's handling of edge cases for milestone IDs with maximum length  
  Ensure that the system can handle milestone IDs with maximum character length without errors.

  @TC-568
  Scenario Outline: Validate milestone management with maximum length milestone ID
    Given the user logs into the SAP S/4HANA Cloud system using valid credentials "<username>" and "<password>"
    When the user navigates to the milestone management module
    And the user searches for the milestone ID "<milestone_id>"
    Then the milestone details for the milestone ID "<milestone_id>" are displayed
    When the user marks the milestone as "Achieved"
    Then the milestone status is updated to "Achieved"
    And the system triggers the creation of a Periodic Billing order
    Then a Periodic Billing order is automatically created without errors
    And the document type of the created order is "<document_type>"
    When the user documents the test results
    Then the test results are documented successfully

    Examples:
      | username      | password         | milestone_id                        | document_type |
      | TestUser04    | TestPassword04   | MILELONGNAME12345678901234567890    | ZPB           |